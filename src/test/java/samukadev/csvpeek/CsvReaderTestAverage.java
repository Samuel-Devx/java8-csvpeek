package samukadev.csvpeek;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTestAverage {
        private CsvReader csvpeek = new CsvReader();
        List<String[]> csvData = csvpeek.readCsv("src/main/java/samukadev/csvpeek/files/testeaverage.csv");
        @Test
        public void testAverage() {
            double average = csvpeek.average(csvData, 2);
            assertEquals(57.5, average, 0.001);
        }


}
