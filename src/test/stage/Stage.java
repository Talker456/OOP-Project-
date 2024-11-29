package test.stage;

import java.util.Scanner;

public class Stage {
    static int count;
    String name;
    String difficulty;
    String[] image;


    public void read(Scanner scanner) {
        name = "Level" + (++count);
    }

    public String[] getImage() {
        return image;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println(name+", "+difficulty);
        for (String string : image) {
            System.out.println(string);
        }
    }
}
