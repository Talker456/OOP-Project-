package main;

import main.start_menu.MenuPanel;
import main.start_menu.StageSelectionCenter;
import test.RealTimeClock;

import javax.swing.*;
import java.awt.*;

public class StageSelectionPanel extends JPanel {

    StageSelectionCenter center;

    public StageSelectionPanel(){
        JPanel cardPanel = MainFrame.getCardPanel();
        CardLayout cardLayout = MainFrame.getCardLayout();

        setLayout(new BorderLayout());


        JButton backButton = new JButton("back");
        backButton.setSize(50, HEIGHT);
        Decorator.setButtonStyle(backButton,20);

        JPanel bottomPanel = new JPanel();
        setBottomPanel(bottomPanel);


        backButton.addActionListener(e -> {
            MenuPanel loginPanel = new MenuPanel();
            cardPanel.add(loginPanel,"menu");
            cardLayout.show(cardPanel, "menu");
        });

        center = new StageSelectionCenter();
        center.init();
        add(backButton, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private void setBottomPanel(JPanel bottomPanel) {
        bottomPanel.setLayout(new GridLayout(1, 3));
        JButton bottomButton1 = new JButton();
        bottomButton1.setEnabled(false);
        RealTimeClock clock = new RealTimeClock(bottomButton1);
        clock.startClock();
        JButton bottomButton2 = new JButton("NONOGRAMs");
        bottomButton2.setForeground(Color.lightGray);
        bottomButton2.setFont(Decorator.DEFAULT_FONT);
        bottomButton2.setEnabled(false);
        bottomButton2.setBackground(Color.darkGray);
        JButton bottomButton3 = new JButton("RANKING");
        bottomButton3.setEnabled(false);
        Decorator.setButtonStyle(bottomButton1,20);
        Decorator.setButtonStyle(bottomButton2,20);
        Decorator.setButtonStyle(bottomButton3,20);
        bottomPanel.add(bottomButton1);
        bottomPanel.add(bottomButton2);
        bottomPanel.add(bottomButton3);
        bottomPanel.setPreferredSize(new Dimension(WIDTH, 50));
    }
}
