package filehandling;

import fixparcelnumber.FixParcelNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WriteCsvTest {

    List<String> fileContentToWrite = Arrays.asList("identifier;description;in progress;start time;end time;notes",
            "0;jogging;yes;2021-05-06 12:34;;;",
            "1;cooking;no;2021-04-14 09:45;2021-04-14 11:37;;",
            "2;hiking;no;2021-03-15 07:10;2021-03-15 18:20;in the local mountains");

    WriteCsv write = new WriteCsv();

    @TempDir
    File temporaryFolder;

    @Test
    void writeTextFileTest() throws IOException {

        write.writeCsv(temporaryFolder.toString(), "testFile.csv", fileContentToWrite);

        List<String> readString = Files.readAllLines(temporaryFolder.toPath().resolve("testFile.csv"));
        assertEquals("0;jogging;yes;2021-05-06 12:34;;;", readString.get(1));
        String[] row = readString.get(3).split(";", -1);
        assertEquals(6, row.length);
        assertEquals("in the local mountains", row[5]);
        assertEquals("2021-03-15 18:20", row[4]);
    }

    @Test
    void readTextInvalidFileTest() {
        String invalidPath = "M:";
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> write.writeCsv(invalidPath, "recordings_.txt", fileContentToWrite));
        assertEquals("Unable to write file: M:recordings_.txt!", ise.getMessage());
        assertEquals(IOException.class, ise.getCause().getClass());
    }

//    @Test
//    void fullFlowTest() {
//        String filename = "src/test/resources/dhte_vagyonkezelt_2022_01_TD.csv";
//        String outputFileName = "src/test/resources/dhte_vagyonkezelt_fixed_2022_01_TD.csv";
//        ReadCsv read = new ReadCsv();
//        FixParcelNumbers fix = new FixParcelNumbers();
//
//        List<String> fileContent = read.readTextFile(filename);
//        List<String> fixed = fix.fixParcelNumbers(fileContent, 1, ";");
//        write.writeCsv(outputFileName, "", fixed);
//    }
}