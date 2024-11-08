package main;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    static JLabel timerLabel;

    public void setupMainPanel() {
        JPanel top = new JPanel(new GridLayout(3, 1));
        setTitle("Demo");

        Container pane = getContentPane();

        top.setPreferredSize(new Dimension(200, 1));
        JLabel topLabel = new JLabel("Title");
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topLabel.setFont(topLabel.getFont().deriveFont(24.0f));

        timerLabel = new JLabel("\tTimer : ?");
        timerLabel.setFont(timerLabel.getFont().deriveFont(24.0f));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        top.add(timerLabel, BorderLayout.CENTER);
        top.add(topLabel, BorderLayout.CENTER);

        pane.add(top, BorderLayout.LINE_START);

        String[] ex = {
                "11111",
                "10001",
                "10101",
                "10001",
                "11111"
        };
        String[] ex2 = {
                "1111111111",
                "1010000111",
                "1100001101",
                "1000011001",
                "1000110011",
                "1001100111",
                "1011001101",
                "1110011001",
                "1100110011",
                "1111111111",
        };
        String[] ex3 = {
                "000000000000000",
                "000000000000000",
                "000000010000000",
                "000000101000000",
                "000001000100000",
                "001111000111100",
                "001000101000100",
                "000100101001000",
                "000010000010000",
                "000010000010000",
                "000100111001000",
                "000101000101000",
                "000010000010000",
                "000000000000000",
                "000000000000000",
        };

        FullBoard g = new FullBoard();


        g.init(ex);

        JPanel north = new JPanel();
        north.setPreferredSize(new Dimension(WIDTH,50));
        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(50,HEIGHT));
        JPanel south = new JPanel();
        south.setPreferredSize(new Dimension(WIDTH,50));

        pane.add(north, BorderLayout.PAGE_START);
        pane.add(g,BorderLayout.CENTER);
        pane.add(right, BorderLayout.LINE_END);
        pane.add(south, BorderLayout.PAGE_END);

    }

    private void createAndShowGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMainPanel();
        setPreferredSize(new Dimension(800, 700));
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.createAndShowGUI();
    }
}


