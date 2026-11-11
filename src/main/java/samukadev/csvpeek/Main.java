package samukadev.csvpeek;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        CsvReader csvReader = new CsvReader();
            List<String[]> csvPath = csvReader.readCsv("src/main/java/samukadev/csvpeek/files/example2.csv");

        List<String> name = csvPath.stream()
                .map(row -> row[1])
                .collect(Collectors.toList());

        name.forEach(data -> System.out.println(data));
        System.out.println(csvReader.average(csvPath, 2));
    }
}