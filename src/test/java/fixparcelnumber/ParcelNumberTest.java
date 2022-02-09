package fixparcelnumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParcelNumberTest {


    @Test
    void fixWrongSubpartConcatenation() {
        ParcelNumber parcelNumber = new ParcelNumber("0255/a");
        parcelNumber.fixWrongSubpartConcatenation();
        assertEquals("0255a", parcelNumber.getParcel());
    }

    @Test
    void fixWrongSubpartConcatenationNoProblemWithBreakthrough() {
        ParcelNumber parcelNumber = new ParcelNumber("0255/7a");
        parcelNumber.fixWrongSubpartConcatenation();
        assertEquals("0255/7a", parcelNumber.getParcel());
    }

    @Test
    void fixWrongSubpartConcatenationSlashAfterBreakthrough() {
        ParcelNumber parcelNumber = new ParcelNumber("0255/7/a");
        parcelNumber.fixWrongSubpartConcatenation();
        assertEquals("0255/7a", parcelNumber.getParcel());
    }

    @Test
    void fixWrongSubpartConcatenationNoSubpart() {
        ParcelNumber parcelNumber = new ParcelNumber("0255/7");
        parcelNumber.fixWrongSubpartConcatenation();
        assertEquals("0255/7", parcelNumber.getParcel());
    }

    @Test
    void fixWrongSubpartConcatenationNoBreakthroughAndSubpart() {
        ParcelNumber parcelNumber = new ParcelNumber("0255");
        parcelNumber.fixWrongSubpartConcatenation();
        assertEquals("0255", parcelNumber.getParcel());
    }

    @Test
    void fixWrongSubpartConcatenationEndsWithSlash() {
        ParcelNumber parcelNumber = new ParcelNumber("0255/");
        parcelNumber.fixWrongSubpartConcatenation();
        assertEquals("0255", parcelNumber.getParcel());
    }
}
