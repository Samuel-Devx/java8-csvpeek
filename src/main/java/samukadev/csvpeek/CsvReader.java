package samukadev.csvpeek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReader {
    public List<String[]> readCsv(String filePath) {
        List<String[]> csvData;
        Path path = Paths.get(filePath);
        try(Stream<String> csv = Files.lines(path)) {
            csvData = csv
               .skip(1)
               .map(line -> line.split(","))
               .collect(Collectors.toList());
            return csvData;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo CSV: " + filePath, e);
        }
    }

    public double average(List<String[]> csvData, int columnIndex) {
        if (columnIndex < 0) {
            throw new IllegalArgumentException("O índice da coluna não pode ser negativo.");
        }
        if (csvData == null) {
            throw new IllegalArgumentException("A lista de dados não pode ser nula.");
        }

        return csvData.stream()
                .filter(row -> row != null && row.length > columnIndex )
                .map(row ->     row[columnIndex])
                .filter(data -> data != null)
                .map(data -> data.trim())
                .filter( data -> !data.isEmpty() && data.matches("-?\\d+(\\.\\d+)?"))
                .mapToDouble(row -> Double.parseDouble(row))
                .average()
                .orElse(0.0);
    }

}
