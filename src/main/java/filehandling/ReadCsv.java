package filehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadCsv {

    public List<String> readTextFile(String pathOfFile) {
        try {
            return Files.readAllLines(Path.of(pathOfFile));
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to read file: " + pathOfFile + "!", ioe);
        }
    }
}
