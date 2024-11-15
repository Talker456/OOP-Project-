package main;

import java.util.Scanner;

public class Record {
    String username;
    String stageName;
    String difficulty;
    String time;

    public Record(){}

    public Record(String username, String stageName,String difficulty, String time) {
        this.username = username;
        this.stageName = stageName;
        this.difficulty = difficulty;
        this.time = time;
    }

    public void read(Scanner scanner,String username) {
        this.username = username;
        this.stageName = scanner.next();
        this.difficulty = scanner.next();
        this.time = scanner.next();
    }

    public String getStageName() {
        return stageName;
    }

    @Override
    public String toString() {
        return "Record [username=" + username + ",stage name="+stageName+", difficulty=" + difficulty + ", time="+time;
    }
}
