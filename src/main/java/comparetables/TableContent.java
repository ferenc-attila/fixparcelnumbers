package comparetables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TableContent {

    private List<Integer> columnsToCompare = new ArrayList<>();
    private List<String> content;
    private String separator;

    public TableContent(List<String> content, String separator, Integer... columnsToCompare) {
        this.columnsToCompare.addAll(Arrays.asList(columnsToCompare));
        this.content = content;
        this.separator = separator;
    }
}
