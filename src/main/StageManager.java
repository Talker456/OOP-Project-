package main;


import main.stage.EasyStage;
import main.stage.HardStage;
import main.stage.NormalStage;
import main.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class StageManager{

    ArrayList<Stage> stages = new ArrayList<>();

    public void readAllStages(Scanner scanner) {
        Stage stage = null;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    stage = new EasyStage();
                    break;
                case 2:
                    stage = new NormalStage();
                    break;
                case 3:
                    stage = new HardStage();
                    break;
            }
            stage.read(scanner);
            stages.add(stage);
        }
    }

    public void print() {
        for (Stage stage : stages) {
            stage.print();
        }
    }

    public int size() {
        return stages.size();
    }

}
