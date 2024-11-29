package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FUNCTION_TEST {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pause Screen Dialog Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.GREEN);
        JButton pauseButton = new JButton("Pause");

        // Define the action to open the pause dialog
        pauseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog pauseDialog = createPauseDialog(frame);
                pauseDialog.setVisible(true);
            }
        });

        gamePanel.add(pauseButton);

        frame.add(gamePanel);
        frame.setVisible(true);
    }

    private static JDialog createPauseDialog(JFrame parentFrame) {
        JDialog pauseDialog = new JDialog(parentFrame, "Paused", true);
        pauseDialog.setSize(300, 150);
        pauseDialog.setLayout(new BoxLayout(pauseDialog.getContentPane(), BoxLayout.Y_AXIS));

        JLabel pauseLabel = new JLabel("Paused", JLabel.CENTER);
        pauseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton resumeButton = new JButton("Resume");
        resumeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Define the action to close the pause dialog
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pauseDialog.dispose();
            }
        });

        pauseDialog.add(Box.createVerticalGlue());
        pauseDialog.add(pauseLabel);
        pauseDialog.add(Box.createRigidArea(new Dimension(0, 20)));
        pauseDialog.add(resumeButton);
        pauseDialog.add(Box.createVerticalGlue());

        pauseDialog.setLocationRelativeTo(parentFrame);

        return pauseDialog;
    }
}
