package main;

import main.manager.Manageable;

import java.util.Scanner;

public class Record implements Manageable {
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

    public void read(Scanner scanner) {
        this.username = scanner.next();
        this.stageName = scanner.next();
        this.difficulty = scanner.next();
        this.time = scanner.next();
    }

    public void altRead(Scanner scanner, String username) {
        this.username = username;
        this.stageName = scanner.next();
        this.difficulty = scanner.next();
        this.time = scanner.next();
    }

    public void print() {
        System.out.println(username+", "+stageName+", "+difficulty+", "+time);
    }

    public String getStageName() {
        return stageName;
    }

    @Override
    public String toString() {
        return username + " " + stageName + " " + difficulty + " " + time+"\n";
    }
}
