package main.ranking;

class RankingEntry {
    private String userId;
    private String clearTime; // e.g., "02:15" (MM:SS format)

    public RankingEntry(String userId, String clearTime) {
        this.userId = userId;
        this.clearTime = clearTime;
    }

    public String getUserId() {
        return userId;
    }

    public String getClearTime() {
        return clearTime;
    }

    // Method to convert clear time to seconds for sorting purposes
    public int getClearTimeInSeconds() {
        try {
            String[] parts = clearTime.split(":");
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            return minutes * 60 + seconds;
        } catch (NumberFormatException e) {
            System.err.println("Invalid clear time format: " + clearTime);
            return Integer.MAX_VALUE; // Return a large value to indicate invalid time
        }
    }

    @Override
    public String toString() {
        return userId + ": " + clearTime;
    }
}