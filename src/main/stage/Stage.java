package main.stage;

import java.util.Scanner;

public class Stage {
    static int count;
    String name;
    String difficulty;
    String[] image;

    public void read(Scanner scanner) {
        name = "Stage" + (++count);
    }

    public String[] getImage() {
        return image;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
