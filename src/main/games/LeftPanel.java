package main.games;


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

    static TimerComponent clock = new TimerComponent();
    Font font = new Font("Arial", Font.BOLD, 20);

    public void init() {
        setLayout(new GridLayout(4, 1));
        this.setPreferredSize(new Dimension(200, HEIGHT));

        clock.clearClock();
        clearHint();

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        JPanel modButtonPanel = new JPanel();
        modButtonPanel.setLayout(new BorderLayout());
        modButton.addActionListener(this);
        modButton.setBackground(Color.darkGray);
        modButton.setForeground(Color.white);
        modButton.setFont(font);
        setButtonMargin(modButtonPanel,modButton,30);

        JPanel hintButtonPanel = new JPanel();
        hintButtonPanel.setLayout(new BorderLayout());
        hintButton.setText(setHintButtonText());
        hintButton.setBackground(Color.darkGray);
        hintButton.setForeground(Color.white);
        hintButton.setFont(font);
        setButtonMargin(hintButtonPanel,hintButton,30);

        bottomPanel.add(modButtonPanel);
        bottomPanel.add(hintButtonPanel);

//        this.add(clock, BorderLayout.CENTER);
//        this.add(userLabel, BorderLayout.CENTER);
//        this.add(bottomPanel, BorderLayout.LINE_END);

        add(clock);
        add(hintButtonPanel);
        add(modButtonPanel);

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

    public static String getTime() {
        return TimerComponent.localTime.toString();
    }

    public void setEventHandler(ActionListener actionListener) {
        hintButton.addActionListener(actionListener);
    }

    public static void clearHint() {
        hintLeft = 3;
    }

    private void setButtonMargin(JPanel panel, JButton button,int margin) {
        JPanel marginTop = new JPanel();
        JPanel marginBottom = new JPanel();
        JPanel marginLeft = new JPanel();
        JPanel marginRight = new JPanel();

        marginTop.setPreferredSize(new Dimension(WIDTH, margin));
        marginBottom.setPreferredSize(new Dimension(WIDTH, margin));
        marginLeft.setPreferredSize(new Dimension(margin, HEIGHT));
        marginRight.setPreferredSize(new Dimension(margin, HEIGHT));

        panel.add(marginTop, BorderLayout.NORTH);
        panel.add(marginBottom, BorderLayout.SOUTH);
        panel.add(marginLeft, BorderLayout.WEST);
        panel.add(marginRight, BorderLayout.EAST);
        panel.add(button, BorderLayout.CENTER);
    }

    public static void pauseClock() {
        clock.pause();
    }

    public static void resumeClock() {
        clock.resume();
    }
}
