package samukadev.csvpeek;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvReader csvReader = new CsvReader();
        List<String[]> csvStream = csvReader.readCsv("src/main/java/samukadev/csvpeek/files/example2.csv");

        List<String> Name = csvStream.stream()
                .map(row -> row[1])
                .collect(Collectors.toList());

        Name.forEach(data -> System.out.println(data));
        System.out.println(csvReader.average(csvStream, 2));
    }
}