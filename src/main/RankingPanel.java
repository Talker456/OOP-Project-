package main;

import main.start_menu.MenuPanel;
import main.start_menu.RealTimeClock;
import test.Record;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class RankingPanel extends JPanel {


    public RankingPanel(String username) {
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        setMainPanel(mainPanel);

        JPanel topPanel = new JPanel();
        setTopPanel(topPanel);


        JPanel bottomPanel = new JPanel();
        setBottomPanel(bottomPanel);


        add(topPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void setBottomPanel(JPanel bottomPanel) {
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.setBackground(new Color(35, 35, 35));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel clockLabel = new JLabel("2024-11-21 11:08:40", SwingConstants.CENTER); // Placeholder for the clock
        clockLabel.setForeground(Color.WHITE);
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        RealTimeClock clock = new RealTimeClock(clockLabel);
        clock.startClock();
        bottomPanel.add(clockLabel);

        JLabel nonogramsLabel = new JLabel("NONOGRAMS", SwingConstants.CENTER);
        nonogramsLabel.setForeground(Color.WHITE);
        nonogramsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bottomPanel.add(nonogramsLabel);

        JLabel myPageLabel = new JLabel("RANKING", SwingConstants.CENTER);
        myPageLabel.setForeground(new Color(255, 215, 0)); // Golden color for better emphasis
        myPageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bottomPanel.add(myPageLabel);
    }

    private void setTopPanel(JPanel topPanel) {
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(35, 35, 35));
        topPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(70, 130, 180)),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));

        JButton undoButton = new JButton("Back");
        undoButton.setPreferredSize(new Dimension(120, 50));
        undoButton.setBackground(new Color(70, 130, 180));
        undoButton.setForeground(Color.WHITE);
        undoButton.setFont(new Font("Arial", Font.BOLD, 20));
        undoButton.setFocusPainted(false);
        undoButton.addActionListener(e->{
            MenuPanel menu = new MenuPanel();
            JPanel cardPanel = MainFrame.getCardPanel();
            cardPanel.add(menu, "menu");
            MainFrame.getCardLayout().show(cardPanel,"menu");
        });
        topPanel.add(undoButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("RANKING", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(new Color(255, 215, 0));
        topPanel.add(titleLabel, BorderLayout.CENTER);
    }



    private void setMainPanel(JPanel mainPanel) {
        mainPanel.setLayout(new GridLayout(3, 4, 15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.LIGHT_GRAY);


        for (int i = 0; i < MainFrame.getStageManager().size(); i++) {
            String stageName = MainFrame.getStageManager().getStage((i)).getName();
            JButton stageButton = new JButton(stageName);
            stageButton.setFont(new Font("Arial", Font.BOLD, 30));
            stageButton.setBackground(new Color(241, 221, 111));
            stageButton.addActionListener(new StageButtonListener(stageName));
            mainPanel.add(stageButton);
        }
    }

    private class StageButtonListener implements ActionListener {
        private String stage;

        public StageButtonListener(String stage) {
            this.stage = stage;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog stageRankingFrame = new JDialog(SwingUtilities.getWindowAncestor(RankingPanel.this), stage + " Rankings", Dialog.ModalityType.APPLICATION_MODAL);
            stageRankingFrame.setSize(400, 400);
            stageRankingFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            JPanel rankingPanel = createRankingPanel(stage);
            JScrollPane scrollPane = new JScrollPane(rankingPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            stageRankingFrame.add(scrollPane);
            stageRankingFrame.setVisible(true);
        }
    }

    private JPanel createRankingPanel(String stage) {
        JPanel rankingPanel = new JPanel();
        rankingPanel.setLayout(new BoxLayout(rankingPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("NONOGRAMS");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rankingPanel.add(titleLabel);
        rankingPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        ArrayList<Record> rankings = MainFrame.getRecordManager().getStageRecord(stage);
        for (int i = 0; i < rankings.size(); i++) {
            JLabel rankingLabel = new JLabel((i + 1) + ": " + rankings.get(i));
            rankingLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            rankingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            if (MainFrame.getCurrentUser().equals(rankings.get(i).getUsername())){
                rankingLabel.setForeground(new Color(187, 147, 5));
            }
            rankingPanel.add(rankingLabel);
            rankingPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        return rankingPanel;
    }

}
