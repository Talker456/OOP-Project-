package main;


import main.games.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StageSelectionCenter extends JPanel {

    StageButton[] buttons = new StageButton[MainController.stageManager.size()];

    public void setButtons() {

        System.out.println("buttons = " + buttons.length);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new StageButton("Level"+(i+1));
        }
    }

    //GamePanel gp = new GamePanel();
    //            gp.init(stages.get(r.nextInt(stages.size())));
    //            cardPanel.add(gp, "game");
    //            cards.show(cardPanel, "game");


    public void init() {
        setLayout(new GridLayout(3, 4)); // ??
        setButtons();
        setEnable(GameControlFrame.records.get(GameControlFrame.getUsername()));

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

        for (int i = 0; i < max+1; i++) {
            if (i>=buttons.length) break;
            buttons[i].enabled = true;
            buttons[i].setBackground(new Color(169, 246, 164));
            if(i==max) buttons[i].setBackground(Color.white);
            int index=i;
            buttons[i].addActionListener(e->{
                GamePanel gp = new GamePanel();
                gp.init(GameControlFrame.stages.get(index));
                GameControlFrame.cardPanel.add(gp, "game");
                GameControlFrame.showCard("game");
            });
        }
    }

    private void setButtonMargin(JPanel tmp) {
        System.out.println("WIDTH = " + WIDTH);
        System.out.println("HEIGHT = " + HEIGHT);

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
//            ArrayList<Record> userRecord = MainFrame.getUserRecord(MainFrame.getUsername());
//            for (Record record : userRecord) {
//                if (record.getStageName().equals(stageName)) {
//                    setBackground(new Color(169, 246, 164));
//                    enabled = true;
//                    break;
//                }
//            }
            setFont(this.getFont().deriveFont(24.0f));
        }



        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(getBackground());
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 100, 100);
            g2d.setColor(getForeground());
            FontMetrics fm = g2d.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(getText())) / 2;
            int y = (getHeight() + fm.getAscent()) / 2 - 2;
            g2d.drawString(getText(), x, y);
            g2d.dispose();
            super.paintComponent(g);
        }

        private void defaultOff() {
            setOpaque(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
        }
    }
}
