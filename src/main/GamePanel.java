package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GamePanel extends JPanel implements ActionListener {

    LeftPanel left = new LeftPanel();
    FullBoard fullBoard = new FullBoard();

    public void init(String[] stage) {

        for (String string : stage) {
            System.out.println(string);
        }

        setLayout(new BorderLayout());

        left.init();
        left.setEventHandler(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source.equals(left.hintButton)) {
            if (left.isHintLeft()) {
                left.hintUse();
                fullBoard.testBoard.hintCall();
            }
        }
    }
}
