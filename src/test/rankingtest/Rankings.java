
package test.rankingtest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static test.rankingtest.alternate.getStageRecords;

public class Rankings {
    public Rankings(){
        JFrame rankingFrame = new JFrame("NONOGRAMS");
        rankingFrame.setSize(800, 700); // 화면 크기 수정
        rankingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 4, 15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(230, 230, 250));

        for (String stage : alternate.getStages()) {
            JButton stageButton = new JButton(stage);
            stageButton.setFont(new Font("Serif", Font.BOLD, 20));
            stageButton.addActionListener(new StageButtonListener(stage));
            mainPanel.add(stageButton);
        }

        rankingFrame.add(mainPanel);
        rankingFrame.setVisible(true);
    }

    public void showRankings() {
        JFrame rankingFrame = new JFrame("NONOGRAMS");
        rankingFrame.setSize(800, 700); // 화면 크기 수정
        rankingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 4, 15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(230, 230, 250));

        for (String stage : alternate.getStages()) {
            JButton stageButton = new JButton(stage);
            stageButton.setFont(new Font("Serif", Font.BOLD, 20));
            stageButton.addActionListener(new StageButtonListener(stage));
            mainPanel.add(stageButton);
        }

        rankingFrame.add(mainPanel);
        rankingFrame.setVisible(true);
    }

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

    private JPanel createRankingPanel(String stage) {
        JPanel rankingPanel = new JPanel();
        rankingPanel.setLayout(new BoxLayout(rankingPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("NONOGRAMS");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rankingPanel.add(titleLabel);
        rankingPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        List<Record> rankings = getStageRecords(stage);
        for (int i = 0; i < rankings.size(); i++) {
            JLabel rankingLabel = new JLabel((i + 1) + ": " + rankings.get(i));
            rankingLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            rankingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            rankingPanel.add(rankingLabel);
            rankingPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        return rankingPanel;
    }

    public static void main(String[] args) {
        new Rankings();
    }
}
