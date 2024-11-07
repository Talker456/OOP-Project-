package trashcan;

import javax.swing.*;
import java.awt.*;

public class FullBoard extends JPanel {
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagLayout grid = new GridBagLayout();

    static int DIFFICULTY_WEIGHT; // MOD
    static double WEIGHT;


    void init(String[] img) {
        DIFFICULTY_WEIGHT = img.length;
        WEIGHT = (double) DIFFICULTY_WEIGHT / (Math.round(DIFFICULTY_WEIGHT/2.0));

        setLayout(grid);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        String[] ex = {
                "11111",
                "10001",
                "10101",
                "10001",
                "11111"
        };

        String[] ex2 = {
                "1111111111",
                "1000000001",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1111111111",
                "1000000001",
                "1111111111",
        };
        Board testBoard = new Board();
        testBoard.init(img);

        JPanel topRight = new JPanel();
        topRight.setBackground(Color.cyan);
        topRight.setPreferredSize(new Dimension(1,1));

        JPanel bottomLeft = new JPanel();
        bottomLeft.setBackground(Color.pink);
        bottomLeft.setPreferredSize(new Dimension(1,1));

        JPanel bottomRight = new JPanel();
        bottomRight.setBackground(Color.gray);
        bottomRight.setPreferredSize(new Dimension(1,1));

        JPanel topLeft = new JPanel();
        topLeft.setBackground(Color.black);
        topLeft.setPreferredSize(new Dimension(1,1));

        ColumnDescription cd = new ColumnDescription();
        cd.init((int)Math.round(DIFFICULTY_WEIGHT/2.0),DIFFICULTY_WEIGHT,img); //MOD

        RowDescription rd = new RowDescription();
        rd.init((int)Math.round(DIFFICULTY_WEIGHT/2.0),DIFFICULTY_WEIGHT,img); //MOD

        make(topLeft,0,0,1,1,1.0,1.0);

        //top right
        make(rd,1,0,1,1,WEIGHT,1.0);

        // bottom left
        make(cd,0,1,1,1,1.0,WEIGHT);

        make(testBoard,1,1,1,1,WEIGHT,WEIGHT);

        this.add(topLeft);

        this.add(rd);

        // bottom left
        this.add(cd);
        this.add(testBoard);

        setPreferredSize(new Dimension(600, 600));
    }
    public void make(JComponent c, int x, int y, int w, int h,double weightx, double weighty) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.weightx=weightx;
        gbc.weighty=weighty;
        grid.setConstraints(c, gbc);
    }
}
