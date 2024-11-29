
package main.record;

public class Record {
    private String userId;
    private int clearTimeInSeconds;

    public Record(String userId, String clearTime) {
        this.userId = userId;
        this.clearTimeInSeconds = parseClearTimeToSeconds(clearTime);
    }

    private int parseClearTimeToSeconds(String clearTime) {
        String[] parts = clearTime.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    public String getUserId() {
        return userId;
    }

    public int getClearTimeInSeconds() {
        return clearTimeInSeconds;
    }

    @Override
    public String toString() {
        int minutes = clearTimeInSeconds / 60;
        int seconds = clearTimeInSeconds % 60;
        return userId + ": " + String.format("%02d:%02d", minutes, seconds);
    }
}
