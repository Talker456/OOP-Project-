package main;

public class Record {
    String username;
    String difficulty;
    String time;
    int hintUsed;

    public Record(String username, String difficulty, String time, int hintUsed) {
        this.username = username;
        this.difficulty = difficulty;
        this.time = time;
        this.hintUsed = hintUsed;
    }

    @Override
    public String toString() {
        return "Record [username=" + username + ", difficulty=" + difficulty + ", time="+time+", hintUsed=" + hintUsed;
    }
}
