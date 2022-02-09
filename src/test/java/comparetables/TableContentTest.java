package comparetables;

import filehandling.ReadCsv;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableContentTest {

    ReadCsv readCsv = new ReadCsv();
    List<String> firstTable = readCsv.readTextFile("src/test/resources/recordings.csv");
    List<String> secondTable = readCsv.readTextFile("src/test/resources/recordingsToCompare.csv");
    TableContent firstTableContent = new TableContent(firstTable,";",1,2);

}