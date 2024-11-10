package main;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GamePanel extends JPanel{

    LeftPanel left = new LeftPanel();
    FullBoard fullBoard = new FullBoard();

    public void init(String[] stage) {

        for (String string : stage) {
            System.out.println(string);
        }

        setLayout(new BorderLayout());

        left.init();
        fullBoard.init(stage);

        JPanel north = new JPanel();
        north.setPreferredSize(new Dimension(WIDTH,50));
        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(50,HEIGHT));
        JPanel south = new JPanel();
        south.setPreferredSize(new Dimension(WIDTH,50));

        this.add(left, BorderLayout.WEST);
        this.add(north, BorderLayout.PAGE_START);
        this.add(fullBoard,BorderLayout.CENTER);
        this.add(right, BorderLayout.LINE_END);
        this.add(south, BorderLayout.PAGE_END);
    }

}
