package samukadev.csvpeek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTest {
    private CsvReader csvReader;
    private List<String[]> csvData;

    @BeforeEach
    void setUp() {
      csvReader = new CsvReader();
      csvData = csvReader.readCsv(
                "src/main/java/samukadev/csvpeek/files/testeaverage2.csv"
      );
    }

    @Test
    public void testReadCsvSize() {
        assertEquals(5, csvData.size());
    }
    @Test
    public void testReadCsvIgnoreFirstLine() {
        assertEquals("Mouse", csvData.get(0)[1]);
    }
    @Test
    void testReadCsvColumns(){
        assertEquals(3, csvData.get(0).length);
    }
    @Test
    void testReadCsvFirstPrice(){
        assertEquals("29.90", csvData.get(0)[2]);
    }
    @Test
    void testReadCsvNotExist(){
        assertThrows(RuntimeException.class, () -> {
            csvReader.readCsv("src/main/java/samukadev/csvpeek/files/nonexistent.csv");
        });
    }
    @Test
    void testReadCsvEmptyFile(){
      List<String[]> data = csvReader.readCsv("src/main/java/samukadev/csvpeek/files/testemptyfile.csv");
      assertTrue(data.isEmpty());
    }
    @Test
    void testAverageNegativeColumnIndex() {
        assertThrows(IllegalArgumentException.class, () -> {
            csvReader.average(csvData, -1);
        });
    }
    @Test
    void testAverageNullData() {
        assertThrows(IllegalArgumentException.class, () -> {
            csvReader.average(null, 2);
        });
    }
}

