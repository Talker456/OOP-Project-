package main;

import javax.swing.*;
import java.awt.*;

public class Decorator {
    public static final Font DEFAULT_FONT= new Font("Arial", Font.BOLD, 20);

    public static void setButtonStyle(JButton b,int size) {
        b.setFont(getFontWithSize(size));
        b.setBackground(Color.darkGray);
        b.setForeground(Color.white);
    }

    private static Font getFontWithSize(int size) {
        return new Font("Arial", Font.BOLD, size);
    }


}
