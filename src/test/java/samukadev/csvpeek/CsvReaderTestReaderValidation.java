package samukadev.csvpeek;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvReaderTestReaderValidation {

    @Test
    public void testReadCsvSize() {
        CsvReader csvReader = new CsvReader();
        List<String[]> csvData = csvReader.readCsv(
                "src/main/java/samukadev/csvpeek/files/testeaverage2.csv"
        );

        assertEquals(5, csvData.size());
    }
    @Test
    public void testReadCsvIgnoreFirstLine() {
        CsvReader csvReader = new CsvReader();
        List<String[]> csvData = csvReader.readCsv(
                "src/main/java/samukadev/csvpeek/files/testeaverage2.csv"
        );

        assertEquals("Mouse", csvData.get(0)[1]);
    }
    @Test
    void testReadCsvColumns(){
        CsvReader csvReader = new CsvReader();
        List<String[]> csvData = csvReader.readCsv(
                "src/main/java/samukadev/csvpeek/files/testeaverage2.csv"
        );

        assertEquals(3, csvData.get(0).length);
    }
    @Test
    void testReadCsvFirstPrice(){
        CsvReader csvReader = new CsvReader();
        List<String[]> csvData = csvReader.readCsv(
                "src/main/java/samukadev/csvpeek/files/testeaverage2.csv"
        );
        assertEquals("29.90", csvData.get(0)[2]);
    }



}
