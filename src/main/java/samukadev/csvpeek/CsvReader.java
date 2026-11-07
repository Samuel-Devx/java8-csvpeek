package samukadev.csvpeek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CsvReader {
    public List<String[]> readCsv(String filePath) {
        List<String[]> csvData = new ArrayList<>();
        Path path = Paths.get(filePath);
        try(Stream<String> csv = Files.lines(path)) {
            csv
               .skip(1)
               .map(line -> line.split(","))
               .forEach(line -> csvData.add(line));
            return csvData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public double average(List<String[]> csvData, int columnIndex) {
        return csvData.stream()
                .filter(row -> row.length > columnIndex)
                .map(roww ->     roww[columnIndex].trim())
                .filter(row -> row != null && !row.isEmpty() && row.matches("-?\\d+(\\.\\d+)?"))
                .mapToDouble(row -> Double.parseDouble(row))
                .average()
                .orElse(0.0);
    }

}
