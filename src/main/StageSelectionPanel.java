package main;

import main.start_menu.MenuPanel;
import main.start_menu.RealTimeClock;
import main.start_menu.StageSelectionCenter;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class StageSelectionPanel extends JPanel {

    StageSelectionCenter center;

    public StageSelectionPanel(){
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        setTopPanel(topPanel);

        JPanel bottomPanel = new JPanel();
        setBottomPanel(bottomPanel);

        center = new StageSelectionCenter();
        center.init();

        add(topPanel, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void setBottomPanel(JPanel bottomPanel) {
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.setBackground(new Color(35, 35, 35));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel clockLabel = new JLabel("2024:12:05 13:32:08", SwingConstants.CENTER); // Placeholder for the clock
        clockLabel.setForeground(Color.WHITE);
        clockLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        RealTimeClock clock = new RealTimeClock(clockLabel);
        clock.startClock();
        bottomPanel.add(clockLabel);

        JLabel nonogramsLabel = new JLabel("NONOGRAMS", SwingConstants.CENTER);
        nonogramsLabel.setForeground(Color.WHITE);
        nonogramsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bottomPanel.add(nonogramsLabel);

        JLabel myPageLabel = new JLabel(MainFrame.getCurrentUser(), SwingConstants.CENTER);
        myPageLabel.setForeground(new Color(255, 215, 0)); // Golden color for better emphasis
        myPageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bottomPanel.add(myPageLabel);
    }

    private void setTopPanel(JPanel topPanel) {
        topPanel.setLayout(new BorderLayout());

        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setBackground(new Color(35, 35, 35));
        upperPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(70, 130, 180)),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));

        JButton pauseButton = new JButton("Back");
        pauseButton.setPreferredSize(new Dimension(120, 50));
        pauseButton.setBackground(new Color(70, 130, 180));
        pauseButton.setForeground(Color.WHITE);
        pauseButton.setFont(new Font("Arial", Font.BOLD, 20));
        pauseButton.setFocusPainted(false);
        pauseButton.addActionListener(e->{
            MenuPanel menu = new MenuPanel();
            JPanel cardPanel = MainFrame.getCardPanel();
            cardPanel.add(menu, "menu");
            MainFrame.getCardLayout().show(cardPanel,"menu");
        });
        upperPanel.add(pauseButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("Select Stage", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(new Color(255, 215, 0));
        upperPanel.add(titleLabel, BorderLayout.CENTER);


        topPanel.add(upperPanel, BorderLayout.CENTER);

    }

}
