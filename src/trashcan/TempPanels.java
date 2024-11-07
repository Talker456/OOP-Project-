package trashcan;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TempPanels extends JPanel {
    static final int rowSize = 5;
    static final int colSize = 5;
    Random rand = new Random();
    AlternateButton[][] cellPanel = new AlternateButton[rowSize][colSize];

    void init(String[] img) {
        setLayout(new GridLayout(rowSize, colSize));

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                cellPanel[i][j] = new AlternateButton(img[i].charAt(j));
                cellPanel[i][j].setFont(cellPanel[i][j].getFont().deriveFont(28.0f));
                add(cellPanel[i][j]);
            }
        }
        setPreferredSize(new Dimension(400, 400));
    }


    class AlternateButton extends JButton {
        boolean isCell;
        AlternateButton(char isCell) {
            this.isCell=(isCell=='1');
            if (this.isCell) {
                this.setBackground(Color.GREEN);
            }else{
                this.setBackground(Color.red);
            }
        }
    }
}
