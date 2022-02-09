package filehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriteCsv {

    public void writeCsv(String relativePath, String outputFilename, List<String> stringList) {
        try {
            Files.write(Path.of(relativePath).resolve(outputFilename), stringList);
        } catch (IOException ioe) {
            throw new IllegalStateException("Unable to write file: " + relativePath + outputFilename + "!", ioe);
        }
    }
}
