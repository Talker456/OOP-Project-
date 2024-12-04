package main;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutCenterAlignmentExample extends JFrame {
    public BoxLayoutCenterAlignmentExample() {
        setTitle("BoxLayout Center Alignment Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Label");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Button");

        // Set alignment to center
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add vertical space and components to the panel
        panel.add(Box.createVerticalGlue());
        panel.add(label);
        panel.add(Box.createVerticalStrut(10));
        panel.add(textField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(button);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BoxLayoutCenterAlignmentExample frame = new BoxLayoutCenterAlignmentExample();
            frame.setVisible(true);
        });
    }
}
