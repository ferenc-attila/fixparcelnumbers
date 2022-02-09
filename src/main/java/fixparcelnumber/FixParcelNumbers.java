package fixparcelnumber;

import java.util.ArrayList;
import java.util.List;

public class FixParcelNumbers {

    public List<String> fixParcelNumbers (List<String> fileContent, int indexOfParcelNumberColumn, String separator) {
        List<String> fixed = new ArrayList<>();
        for (String line : fileContent) {
            String[] row = line.split(separator);
            ParcelNumber parcelNumber = updateParcelNumber(row[indexOfParcelNumberColumn]);
            row[indexOfParcelNumberColumn] = parcelNumber.getParcel();
            fixed.add(createFixedLine(separator, row).toString());
        }
        return fixed;
    }

    private ParcelNumber updateParcelNumber(String row) {
        ParcelNumber parcelNumber = new ParcelNumber(row);
        parcelNumber.fixWrongSubpartConcatenation();
        return parcelNumber;
    }

    private StringBuilder createFixedLine(String separator, String[] row) {
        StringBuilder fixedLine = new StringBuilder();
        boolean first = true;
        for (String cell : row) {
            if (first) {
                fixedLine.append(cell);
                first = false;
            } else {
                fixedLine.append(separator);
                fixedLine.append(cell);
            }
        }
        return fixedLine;
    }
}
