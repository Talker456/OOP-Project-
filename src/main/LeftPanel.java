package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel implements ActionListener {

    // HTML syntax vs setHorizontalAlignment, etc
    //<html><p style='font-size:15px'>O</p></html>
    //html><p style='font-size:15px;'>Hint<br>3/3</p></html>
    static int hintLeft = 3;

    JButton modButton = new JButton("O");
    JButton hintButton = new JButton(setHintButtonText());

    static ClockComponent clock = new ClockComponent();

    public void init() {
        this.setLayout(new GridLayout(3, 1));
        this.setPreferredSize(new Dimension(200,700));

        JLabel topLabel = new JLabel("user : ");
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topLabel.setFont(topLabel.getFont().deriveFont(24.0f));

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        modButton.addActionListener(this);

        bottomPanel.add(modButton);
        bottomPanel.add(hintButton);

        this.add(clock, BorderLayout.CENTER);
        this.add(topLabel, BorderLayout.CENTER);
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

    public static int getHintLeft() {
        return hintLeft;
    }

    public static String getTime() {
        return ClockComponent.t.toString();
    }

    public void setEventHandler(ActionListener actionListener) {
        hintButton.addActionListener(actionListener);
    }
}
