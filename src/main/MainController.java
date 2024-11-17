package main;

import main.start.StartScreen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainController {

    static StageManager stageManager = new StageManager();
    static RecordManager recordManager = new RecordManager();

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
        stageManager.readAllStages(openFile("stage.txt"));
        recordManager.readAllRecord(openFile("record.txt"));

        stageManager.print();
        recordManager.print();

        new StartScreen();
    }

    public static RecordManager getRecordManager() {
        return recordManager;
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
        MainController mainController = new MainController();
        mainController.start();
    }
}
