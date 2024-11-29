package test;


import test.games.InGameFrame;

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

    public void init(StageSelectionFrame parentFrame) {
        setLayout(new GridLayout(3, 4)); // ??
        setBackground(Color.lightGray);
        setButtons();
        String username = MainController.getCurrentUser();
        setEnable(MainController.recordManager.getUserRecord(username),parentFrame);

        for (StageButton button : buttons) {
            JPanel tmp = new JPanel();

            tmp.setLayout(new BorderLayout());
            setButtonMargin(tmp);

            tmp.add(button, BorderLayout.CENTER);
            add(tmp);
        }
    }

    public void setEnable(ArrayList<Record> userRecords, StageSelectionFrame frame) {
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
            int index=i;
            buttons[i].addActionListener(e -> {
                new InGameFrame(MainController.stageManager.getStage(index));
                frame.dispose();
            });
        }
    }

    private void setButtonMargin(JPanel tmp) {
        JPanel marginTop = new JPanel();
        marginTop.setPreferredSize(new Dimension(WIDTH, 20));
        JPanel marginBottom = new JPanel();
        marginBottom.setPreferredSize(new Dimension(WIDTH, 20));
        JPanel marginRight = new JPanel();
        marginRight.setPreferredSize(new Dimension(10, HEIGHT));
        JPanel marginLeft = new JPanel();
        marginLeft.setPreferredSize(new Dimension(10, HEIGHT));

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