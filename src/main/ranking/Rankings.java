package main.ranking;

import main.scenes.MainScene;
import main.start.MenuScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Rankings {
    private Map<String, List<RankingEntry>> stageRankings;
    static String currentUser;

    public Rankings(String username) {
        currentUser = username;

        // Initialize rankings for each stage using LinkedHashMap to preserve order
        stageRankings = new LinkedHashMap<>();
        for (int i = 1; i <= 10; i++) {
            stageRankings.put("Stage " + i, new ArrayList<>());
        }

        // Example rankings for some of the stages
        stageRankings.get("Stage 1").add(new RankingEntry("UserA", "02:15"));
        stageRankings.get("Stage 2").add(new RankingEntry("UserB", "03:45"));
        stageRankings.get("Stage 3").add(new RankingEntry("UserC", "01:30"));
        stageRankings.get("Stage 4").add(new RankingEntry("UserD", "04:10"));
        stageRankings.get("Stage 5").add(new RankingEntry("UserE", "05:25"));
    }

    public void addRanking(String stage, String userId, String time) {
        if (stageRankings.containsKey(stage)) {
            List<RankingEntry> rankings = stageRankings.get(stage);
            if (isValidTimeFormat(time)) {
                rankings.add(new RankingEntry(userId, time));

                // Sort rankings by clear time in ascending order
                Collections.sort(rankings, Comparator.comparingInt(RankingEntry::getClearTimeInSeconds));
            } else {
                System.err.println("Invalid time format: " + time);
            }
        }
    }

    // Show all stages with buttons in a larger window
    public void showRankings() {
        JFrame rankingFrame = new JFrame("Rankings");
        rankingFrame.setSize(800, 600);
        rankingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 4, 15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(230, 230, 250)); // Light lavender background

        for (String stage : stageRankings.keySet()) {
            JButton stageButton = new JButton(stage);
            stageButton.setFont(new Font("Serif", Font.BOLD, 20));
            stageButton.addActionListener(new StageButtonListener(stage));
            mainPanel.add(stageButton);
        }

        JButton back = new JButton("Back");
        back.addActionListener(e->{
            MenuScreen m = new MenuScreen(currentUser);
            m.setVisible(true);
            rankingFrame.dispose();
        });
        mainPanel.add(back);

        rankingFrame.add(mainPanel);
        rankingFrame.setVisible(true);
    }

    // Listener for each stage button to display specific rankings
    private class StageButtonListener implements ActionListener {
        private String stage;

        public StageButtonListener(String stage) {
            this.stage = stage;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame stageRankingFrame = new JFrame(stage + " Rankings");
            stageRankingFrame.setSize(400, 400);
            stageRankingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel rankingPanel = createRankingPanel(stage);
            JScrollPane scrollPane = new JScrollPane(rankingPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            stageRankingFrame.add(scrollPane);
            stageRankingFrame.setVisible(true);
        }
    }

    // Method to create the ranking panel for a specific stage
    private JPanel createRankingPanel(String stage) {
        JPanel rankingPanel = new JPanel();
        rankingPanel.setLayout(new BoxLayout(rankingPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(stage + " Rankings");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rankingPanel.add(titleLabel);
        rankingPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        List<RankingEntry> rankings = stageRankings.get(stage);
        for (int i = 0; i < rankings.size(); i++) {
            JLabel rankingLabel = new JLabel((i + 1) + ": " + rankings.get(i));
            rankingLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            rankingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            rankingPanel.add(rankingLabel);
            rankingPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        return rankingPanel;
    }

    public List<String> getStages() {
        return new ArrayList<>(stageRankings.keySet());
    }

    // Utility method to check if the time format is valid (MM:SS)
    private boolean isValidTimeFormat(String time) {
        if (time == null || !time.matches("\\d{2}:\\d{2}")) {
            return false;
        }
        try {
            String[] parts = time.split(":");
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            return seconds >= 0 && seconds < 60;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}