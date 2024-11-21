package main.games;


import main.MainController;
import test.rankingtest.alternate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel implements ActionListener {

    //<html><p style='font-size:15px'>O</p></html>
    //html><p style='font-size:15px;'>Hint<br>3/3</p></html>
    static int hintLeft = 3;

    JButton modButton = new JButton("O");
    JButton hintButton = new JButton();

    static ClockComponent clock = new ClockComponent();
    Font font = new Font("Arial", Font.BOLD, 20);

    public void init() {
        this.setLayout(new GridLayout(3, 1));
        this.setPreferredSize(new Dimension(200, 700));

        clock.clearClock();
        clearHint();

        JLabel userLabel = new JLabel("User : "+ MainController.getCurrentUser());
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userLabel.setFont(userLabel.getFont().deriveFont(24.0f));

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        modButton.addActionListener(this);
        modButton.setBackground(Color.darkGray);
        modButton.setForeground(Color.white);
        modButton.setFont(font);

        hintButton.setText(setHintButtonText());
        hintButton.setBackground(Color.darkGray);
        hintButton.setForeground(Color.white);
        hintButton.setFont(font);

        bottomPanel.add(modButton);
        bottomPanel.add(hintButton);

        this.add(clock, BorderLayout.CENTER);
        this.add(userLabel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.LINE_END);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        if (source.getText().equals("O")) {
            source.setText("X");
            Board.setState(false);
        }else if(source.getText().equals("X")){
            source.setText("O");
            Board.setState(true);
        }
    }

    public String setHintButtonText() {
        return "<html><p style='font-size:15px;'>Hint<br>"+hintLeft+"/3</p></html>";
    }

    public boolean isHintLeft() {
        return hintLeft > 0;
    }

    public void hintUse() {
        hintLeft--;
        hintButton.setText(setHintButtonText());
    }

//    public static int getHintLeft() {
//        return hintLeft;
//    }

    public static String getTime() {
        return ClockComponent.t.toString();
    }

    public void setEventHandler(ActionListener actionListener) {
        hintButton.addActionListener(actionListener);
    }

    public static void clearHint() {
        hintLeft = 3;
    }
}
