
package test.rankingtest;

import main.StageManager;
import main.start.StartFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class alternate {
    static StageManager stageManager = new StageManager();
    static Map<String, List<Record>> stageRecords = new TreeMap<>();
    static String currentUser;

    public static void setUsername(String username) {
        currentUser = username;
    }

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void print() {
        System.out.println("currentUser = " + currentUser);
    }

    public static void writeRecord(String string) {
        try (FileWriter writer = new FileWriter("record.txt", true)) {
            writer.write(string + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    void start() {
        readAllStages(openFile("stage.txt"));
        readAllRecords(openFile("record.txt"));
        new StartFrame();
    }

    private void readAllStages(Scanner scanner) {
        stageManager.readAllStages(scanner);
    }

    private void readAllRecords(Scanner scanner) {
        while (scanner != null && scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String stage = parts[0].trim();
                String userId = parts[1].trim();
                String time = parts[2].trim();
                addRecord(stage, userId, time);
            }
        }
    }

    public static void addRecord(String stage, String userId, String time) {
        stageRecords.putIfAbsent(stage, new ArrayList<>());
        stageRecords.get(stage).add(new Record(userId, time));
        stageRecords.get(stage).sort(Comparator.comparingInt(Record::getClearTimeInSeconds));
    }

    public static List<String> getStages() {
        return new ArrayList<>(stageRecords.keySet());
    }

    public static List<Record> getStageRecords(String stage) {
        return stageRecords.getOrDefault(stage, new ArrayList<>());
    }

    public Scanner openFile(String path) {
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }
        return s;
    }

    public static void main(String[] args) {
        alternate mainController = new alternate();
        mainController.start();
    }
}
