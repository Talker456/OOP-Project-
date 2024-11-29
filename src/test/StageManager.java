package test;


import test.stage.EasyStage;
import test.stage.HardStage;
import test.stage.NormalStage;
import test.stage.Stage;

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

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public int size() {
        return stages.size();
    }

    public Stage getStage(int index) {
        return stages.get(index);
    }

}
