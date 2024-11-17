package main;

import main.manager.Manageable;
import main.manager.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RecordManager {

    ArrayList<Record> records = new ArrayList<>();

    public void readAllRecord(Scanner scanner) {
        Record r = null;
        while (scanner.hasNext()) {
            r = new Record();
            r.read(scanner);
            records.add(r);
        }
    }

    public void print() {
        for (Record record : records) {
            record.print();
        }
    }

}
