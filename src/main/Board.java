package main;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    static int rowSize; //MOD
    static int colSize; //MOD
    AlternateButton[][] cellPanel;

    void init(String[] img) {
        rowSize = img.length;
        colSize = img.length;
        cellPanel = new AlternateButton[rowSize][colSize];

        setLayout(new GridLayout(rowSize, colSize));

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                cellPanel[i][j] = new AlternateButton(img[i].charAt(j));
                cellPanel[i][j].setBorder(BorderFactory.createBevelBorder(0));
                add(cellPanel[i][j]);
            }
        }
    }

    private static class AlternateButton extends JButton {
        boolean isCell;
        AlternateButton(char isCell) {
            this.isCell=(isCell=='1');
            if (this.isCell) {
                this.setBackground(Color.darkGray);
            }else{
                this.setBackground(Color.lightGray);
            }
        }
    }
}