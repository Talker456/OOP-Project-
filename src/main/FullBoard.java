package main;

import javax.swing.*;
import java.awt.*;

public class FullBoard extends JPanel {
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagLayout grid = new GridBagLayout();

    static int DIFFICULTY_WEIGHT; // MOD
    static double RATIO;
    Board testBoard;


    void init(String[] img) {
        DIFFICULTY_WEIGHT = img.length;
        RATIO = (double) DIFFICULTY_WEIGHT / (Math.round(DIFFICULTY_WEIGHT/2.0));

        setLayout(grid);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        testBoard = new Board();
        testBoard.init(img);

        JPanel bottomRight = new JPanel();
        bottomRight.setBackground(Color.gray);
        bottomRight.setPreferredSize(new Dimension(1,1));

        JPanel topLeft = new JPanel();
        topLeft.setBackground(Color.white);
        topLeft.setPreferredSize(new Dimension(1,1));

        ColumnDescription cd = new ColumnDescription();
        cd.init((int)Math.round(DIFFICULTY_WEIGHT/2.0),DIFFICULTY_WEIGHT,img); //MOD

        RowDescription rd = new RowDescription();
        rd.init((int)Math.round(DIFFICULTY_WEIGHT/2.0),DIFFICULTY_WEIGHT,img); //MOD

        make(topLeft,0,0,1,1,1.0,1.0);

        //top right
        make(rd,1,0,1,1, RATIO,1.0);

        // bottom left
        make(cd,0,1,1,1,1.0, RATIO);

        make(testBoard,1,1,1,1, RATIO, RATIO);

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