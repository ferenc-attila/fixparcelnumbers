package fixparcelnumber;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FixParcelNumbersTest {

    @Test
    void fixParcelNumbers() {
        FixParcelNumbers fix = new FixParcelNumbers();
        List<String> fileContent = new ArrayList<>(Arrays.asList("Besenyőtelek;0255/a",
                "Besenyőtelek;0255a",
                "Besenyőtelek;0255/7a",
                "Besenyőtelek;0255/7/a",
                "Besenyőtelek;0255/7",
                "Besenyőtelek;0255/7/",
                "Besenyőtelek;0255",
                "Besenyőtelek;0255/"));

        List<String> expected = new ArrayList<>(Arrays.asList("Besenyőtelek;0255a",
                "Besenyőtelek;0255a",
                "Besenyőtelek;0255/7a",
                "Besenyőtelek;0255/7a",
                "Besenyőtelek;0255/7",
                "Besenyőtelek;0255/7",
                "Besenyőtelek;0255",
                "Besenyőtelek;0255"));

        assertEquals(expected, fix.fixParcelNumbers(fileContent, 1, ";"));
    }
}