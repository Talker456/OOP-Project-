package test.stage;

import java.util.Scanner;

public class EasyStage extends Stage{

    @Override
    public void read(Scanner scanner) {
        super.read(scanner);
        image = new String[5];
        difficulty = "Easy";
        for (int i = 0; i < 5; i++) {
            image[i] = scanner.next();
        }
    }
}
