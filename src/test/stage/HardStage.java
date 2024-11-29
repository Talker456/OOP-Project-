package test.stage;

import java.util.Scanner;

public class HardStage extends Stage{
    @Override
    public void read(Scanner scanner) {
        super.read(scanner);
        difficulty = "Hard";
        image = new String[15];
        for (int i = 0; i < 15; i++) {
            image[i] = scanner.next();
        }
    }
}
