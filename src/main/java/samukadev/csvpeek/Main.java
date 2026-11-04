package samukadev.csvpeek;

import java.io.IOException;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/samukadev/csvpeek/files/example1.csv");
        Stream<String[]> csv = Files.lines(path)
                .skip(1)
                .map(line -> line.split(","));

        csv.forEach(dados -> System.out.println(Arrays.toString(dados)));
    }
}