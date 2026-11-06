package samukadev.csvpeek;

import java.io.IOException;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvReader csvReader = new CsvReader();
        List<String[]> csvStream = csvReader.readCsv("src/main/java/samukadev/csvpeek/files/example1.csv");

        csvStream.forEach(data -> System.out.println(Arrays.toString(data)));
    }
}