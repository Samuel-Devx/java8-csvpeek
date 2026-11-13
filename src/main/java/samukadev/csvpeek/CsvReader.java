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
    private boolean isValidNumber(String value) {
        return value != null
                && !value.trim().isEmpty()
                && value.trim().matches("-?\\d+(\\.\\d+)?");
    }
    public void averageReport(List<String[]> csvData, int columnIndex) {
        if (csvData == null || columnIndex < 0) {
            throw new IllegalArgumentException("Dados ou índice inválidos.");
        }

        long validValues = csvData.stream()
                .filter(row -> row != null && row.length > columnIndex)
                .map(row -> row[columnIndex])
                .filter(this::isValidNumber)
                .count();

        long totalRecords = csvData.size();
        long invalidValues = totalRecords - validValues;

        double average = average(csvData, columnIndex);

        System.out.printf(
                "=========== Average Report ===========%n" +
                        "Column Index: %d%n" +
                        "Total Records: %d%n" +
                        "Valid Values: %d%n" +
                        "Invalid Values: %d%n" +
                        "Average: %.2f%n" +
                        "======================================%n",
                columnIndex, totalRecords, validValues, invalidValues, average
        );
    }
    public String[] readHeader(String filePath) {
        Path path = Paths.get(filePath);

        try (Stream<String> csv = Files.lines(path)) {
            return csv
                    .findFirst()
                    .map(line -> line.split(","))
                    .orElse(new String[0]);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o cabeçalho do CSV: " + filePath, e);
        }
    }
    public void printTable(String[] headers, List<String[]> csvData) {
        int[] widths = new int[headers.length];

        for (int i = 0; i < headers.length; i++) {
            widths[i] = headers[i].length();

            for (String[] row : csvData) {
                if (row != null && i < row.length && row[i] != null) {
                    widths[i] = Math.max(widths[i], row[i].length());
                }
            }
        }

        printSeparator(widths);
        printRow(headers, widths);
        printSeparator(widths);

        for (String[] row : csvData) {
            if (row != null) {
                printRow(row, widths);
            }
        }

        printSeparator(widths);
    }

    private void printSeparator(int[] widths) {
        for (int width : widths) {
            System.out.print("+");
            for (int i = 0; i < width + 2; i++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    private void printRow(String[] row, int[] widths) {
        for (int i = 0; i < widths.length; i++) {
            String value = i < row.length && row[i] != null ? row[i] : "";
            System.out.printf("| %-" + widths[i] + "s ", value);
        }
        System.out.println("|");
    }
}
