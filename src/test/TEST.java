package test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TEST {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Custom Position Dialog Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);

        // Create a JOptionPane
        JOptionPane optionPane = new JOptionPane("This dialog is at a custom position",
                JOptionPane.INFORMATION_MESSAGE);

        // Create a dialog
        JDialog dialog = optionPane.createDialog(frame, "Custom Position Dialog");

        // Set the location of the dialog (x, y)
        dialog.setLocation(100, 100); // Example coordinates
        dialog.setVisible(true);
    }

}
