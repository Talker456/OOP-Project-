package test;

import javax.swing.*;
import java.awt.*;

public class Decorator {
    public static final Font DEFAULT_FONT= new Font("Arial", Font.BOLD, 20);

    public static void setButtonStyle(JButton b) {
        b.setFont(DEFAULT_FONT);
        b.setBackground(Color.darkGray);
        b.setForeground(Color.white);
    }
}
