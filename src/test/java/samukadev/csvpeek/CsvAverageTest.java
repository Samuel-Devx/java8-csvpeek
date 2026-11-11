package samukadev.csvpeek;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvAverageTest {
    private CsvReader csvpeek = new CsvReader();
    List<String[]> csvData = csvpeek.readCsv("src/main/java/samukadev/csvpeek/files/testeaverage2.csv");

    @Test
    public void testAverage() {
        double average = csvpeek.average(csvData, 2);
        assertEquals(33.2667, average, 0.001);
    }

    @Test
    public void testAverageIgnoringInvalidValues(){
        CsvReader csvReader = new CsvReader();
        List<String[]> csvData = csvReader.readCsv(
                "src/main/java/samukadev/csvpeek/files/testeaverage2.csv"
        );

        double average = csvReader.average(csvData, 2);
        assertEquals(33.2667, average, 0.001);
    }
}
