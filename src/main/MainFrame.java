package main;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    static JLabel timerLabel;

    GamePanel gamePanel=new GamePanel();

    public void setupMainPanel() {
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

        setTitle("Demo");
        Container pane = getContentPane();

        gamePanel.init(ex);
        pane.add(gamePanel);
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


