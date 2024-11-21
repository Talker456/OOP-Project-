package main;

import java.time.LocalTime;
import java.util.Scanner;

public class Record{
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

    public String getUsername() {
        return username;
    }

    public String getStageName() {
        return stageName;
    }

    public LocalTime getTimeAsLocalTime() {
        return LocalTime.parse(time);
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return username + " " + stageName + " " + difficulty + " " + time;
    }
}
