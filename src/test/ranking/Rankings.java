package test.ranking;

import test.MainController;
import test.RealTimeClock;
import test.Record;
import test.start.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Rankings extends JFrame {

    Font font = new Font("Arial", Font.BOLD, 20);

    public Rankings(String username) {
        setTitle("NONOGRAMS");
        setSize(new Dimension(800, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        Container contentPane = getContentPane();

        JPanel mainPanel = new JPanel();
        setMainPanel(mainPanel);

        JButton backButton = new JButton("back");
        backButton.setSize(50, HEIGHT);
        setButtonStyle(backButton);
        backButton.addActionListener(e->{
            new MenuFrame(username);
            this.setVisible(false);
        });

        JPanel bottomPanel = new JPanel();
        setBottomPanel(bottomPanel);

        contentPane.add(backButton, BorderLayout.WEST);
        contentPane.add(mainPanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void setBottomPanel(JPanel bottomPanel) {
        bottomPanel.setLayout(new GridLayout(1, 3));
        JButton bottomButton1 = new JButton();
        bottomButton1.setEnabled(false);
        RealTimeClock clock = new RealTimeClock(bottomButton1);
        clock.startClock();
        JButton bottomButton2 = new JButton("NONOGRAMs");
        bottomButton2.setForeground(Color.lightGray);
        bottomButton2.setFont(font);
        bottomButton2.setEnabled(false);
        bottomButton2.setBackground(Color.darkGray);
        JButton bottomButton3 = new JButton("RANKING");
        bottomButton3.setEnabled(false);
        setButtonStyle(bottomButton1);
        setButtonStyle(bottomButton2);
        setButtonStyle(bottomButton3);
        bottomPanel.add(bottomButton1);
        bottomPanel.add(bottomButton2);
        bottomPanel.add(bottomButton3);
        bottomPanel.setPreferredSize(new Dimension(WIDTH, 50));
    }

    private void setButtonStyle(JButton jButton) {
        jButton.setForeground(Color.white);
        jButton.setBackground(Color.darkGray);
        jButton.setFont(font);
    }

    private void setMainPanel(JPanel mainPanel) {
        mainPanel.setLayout(new GridLayout(3, 4, 15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.LIGHT_GRAY);


        for (int i = 0; i < MainController.getStageManager().size(); i++) {
            String stageName = MainController.getStageManager().getStage((i)).getName();
            JButton stageButton = new JButton(stageName);
            stageButton.setBackground(new Color(173, 216, 230));
            stageButton.setFont(new Font("Arial", Font.BOLD, 20));
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

        ArrayList<Record> rankings = MainController.getRecordManager().getStageRecord(stage);
        for (int i = 0; i < rankings.size(); i++) {
            JLabel rankingLabel = new JLabel((i + 1) + ": " + rankings.get(i));
            rankingLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            rankingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            rankingPanel.add(rankingLabel);
            rankingPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        }

        return rankingPanel;
    }
}