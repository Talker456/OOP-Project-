package main.games;

import main.MainController;
import main.Record;
import main.StageSelectionFrame;
import main.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InGameFrame extends JFrame implements ActionListener {

    LeftPanel left;
    FullBoard fullBoard;
    static Stage currentStage;
    Font font = new Font("Arial", Font.BOLD, 20);

    public InGameFrame(Stage stage) {
        setTitle("NONOGRAMS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        left = new LeftPanel();
        fullBoard = new FullBoard();
        currentStage = stage;

        setLayout(new BorderLayout());

        left.init();
        left.setEventHandler(this);
        fullBoard.init(this);

        JPanel north = new JPanel();
        JButton back = new JButton("back");
        back.addActionListener(e -> {
            new StageSelectionFrame();
            dispose();
        });
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

        setVisible(true);
        setSize(new Dimension(800, 700));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source.equals(left.hintButton)) {
            if (left.isHintLeft()) {
                left.hintUse();
                fullBoard.board.hintCall();
            }
        }
    }

    public static void terminate(){
        System.out.println("terminated");
        String timeSpent = LeftPanel.getTime();
        String difficulty = currentStage.getDifficulty();
        String stageName = currentStage.getName();
        String name = MainController.getCurrentUser();
        Record record = new Record(name, stageName, difficulty, timeSpent);

        MainController.writeRecord(record.toString());
        MainController.getRecordManager().addRecord(record);

    }

    public static Stage getCurrentStage() {
        return currentStage;
    }

}
