package main;

import java.util.ArrayList;
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

    public ArrayList<Record> getUserRecord(String username) {
        return records.stream()
               .filter(record -> record.getUsername().equals(username))
               .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public void addRecord(Record record) {
        records.add(record);
    }
}
