package test;

import java.util.ArrayList;
import java.util.Comparator;
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

    public ArrayList<Record> getUserRecord(String username) {
        return records.stream()
               .filter(record -> record.getUsername().equals(username))
               .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public ArrayList<Record> getStageRecord(String stageName) {
        ArrayList<Record> collected = records.stream()
                .filter(record -> record.getStageName().equals(stageName))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        collected.sort(Comparator.comparing(Record::getTimeAsLocalTime));
        return collected;
    }

    public void addRecord(Record record) {
        records.add(record);
    }
}
