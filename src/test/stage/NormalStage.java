package test.stage;

import java.util.Scanner;

public class NormalStage extends Stage{
    @Override
    public void read(Scanner scanner) {
        super.read(scanner);
        image = new String[10];
        difficulty = "Normal";
        for (int i = 0; i < 10; i++) {
            image[i] = scanner.next();
        }
    }

}
