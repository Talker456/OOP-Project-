package main;

import main.manager.Manager;
import main.stage.EasyStage;
import main.stage.HardStage;
import main.stage.NormalStage;
import main.stage.Stage;
import main.start.StartScreen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainController {

    static StageManager stageManager = new StageManager();
    static RecordManager recordManager = new RecordManager();


    void start() {
        stageManager.readAllStages(openFile("stage.txt"));
        recordManager.readAllRecord(openFile("record.txt"));

        stageManager.print();
        recordManager.print();

        new StartScreen();
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
