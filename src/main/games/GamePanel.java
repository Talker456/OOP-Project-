package main.games;

import main.GameControlFrame;
import main.Record;
import main.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    LeftPanel left;
    FullBoard fullBoard;

    public void init(Stage stage) {
        left = new LeftPanel();
        fullBoard = new FullBoard();

        setLayout(new BorderLayout());

        left.init();
        left.setEventHandler(this);
        fullBoard.init(stage);

        JPanel north = new JPanel();
        JButton back = new JButton("back");
        back.addActionListener(e-> GameControlFrame.showCard("select"));
        north.add(back);
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

    public static void terminate(){
        System.out.println("terminated");
        String timeSpent = LeftPanel.getTime();
        String difficulty = FullBoard.currentStage.getDifficulty();
        String stageName = FullBoard.currentStage.getName();
        String name = GameControlFrame.getUsername();
        Record record = new Record(name, stageName,difficulty, timeSpent);
        GameControlFrame.writeRecord(record.toString());
        GameControlFrame.addRecord(record);
    }
}
