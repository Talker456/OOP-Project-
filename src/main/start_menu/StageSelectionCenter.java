package main.start_menu;


import test.Record;
import main.MainFrame;
import main.games.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StageSelectionCenter extends JPanel {

    StageButton[] buttons = new StageButton[MainFrame.getStageManager().size()];

    public void setButtons() {

        System.out.println("buttons = " + buttons.length);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new StageButton("Level"+(i+1));
        }
    }

    public void init() {
        setLayout(new GridLayout(3, 4)); // ??
        setBackground(Color.lightGray);
        setButtons();
        String username = MainFrame.getCurrentUser();
        setEnable(MainFrame.getRecordManager().getUserRecord(username));

        for (StageButton button : buttons) {
            JPanel tmp = new JPanel();

            tmp.setLayout(new BorderLayout());
            setButtonMargin(tmp);

            tmp.add(button, BorderLayout.CENTER);
            add(tmp);
        }
    }

    public void setEnable(ArrayList<Record> userRecords) {
        int max = 0;
        if (userRecords != null) {
            for (Record userRecord : userRecords) {
                String substring = userRecord.getStageName().substring(5);
                max = Math.max(max, Integer.parseInt(substring));
            }
        }

        for (StageButton button : buttons) {
            button.setEnabled(false);
        }

        for (int i = 0; i < max+1; i++) {
            if (i>=buttons.length) break;
            buttons[i].enabled = true;
            buttons[i].setEnabled(true);
            buttons[i].setBackground(new Color(169, 246, 164));
            if(i==max) buttons[i].setBackground(Color.white);
            int index = i;

            // button action
            buttons[i].addActionListener(e -> {
                GamePanel gamePanel = new GamePanel(MainFrame.getStageManager().getStage(index));
                MainFrame.getCardPanel().add(gamePanel, "game");
                MainFrame.getCardLayout().show(MainFrame.getCardPanel(),"game");

            });
        }
    }

    private void setButtonMargin(JPanel tmp) {
        JPanel marginTop = new JPanel();
        marginTop.setPreferredSize(new Dimension(WIDTH, 20));
        JPanel marginBottom = new JPanel();
        marginBottom.setPreferredSize(new Dimension(WIDTH, 20));
        JPanel marginRight = new JPanel();
        marginRight.setPreferredSize(new Dimension(20, HEIGHT));
        JPanel marginLeft = new JPanel();
        marginLeft.setPreferredSize(new Dimension(20, HEIGHT));

        tmp.add(marginTop, BorderLayout.NORTH);
        tmp.add(marginBottom, BorderLayout.SOUTH);
        tmp.add(marginLeft, BorderLayout.WEST);
        tmp.add(marginRight, BorderLayout.EAST);
    }

    private static class StageButton extends JButton {
        boolean enabled = false;

        public StageButton(String stageName) {
            super(stageName);
            setBorderPainted(false);
            setBackground(Color.lightGray);
            setFont(this.getFont().deriveFont(24.0f));
        }
    }
}
