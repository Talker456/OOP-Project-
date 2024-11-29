package main.games;

import main.Decorator;
import main.StageSelectionPanel;
import test.Record;
import test.stage.Stage;
import main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    LeftPanel left;
    FullBoard fullBoard;
    static Stage currentStage;

    public GamePanel(Stage stage) {
        currentStage = stage;
        left = new LeftPanel();
        fullBoard = new FullBoard();

        setLayout(new BorderLayout());

        left.init();
        left.setEventHandler(this);
        fullBoard.init();

        JPanel north = new JPanel();
        setNorthPanel(north);

        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(130,HEIGHT));
        JPanel south = new JPanel();
        south.setPreferredSize(new Dimension(WIDTH,50));

        this.add(left, BorderLayout.WEST);
        this.add(north, BorderLayout.PAGE_START);
        this.add(fullBoard,BorderLayout.CENTER);
        this.add(right, BorderLayout.LINE_END);
        this.add(south, BorderLayout.PAGE_END);

    }

    private void setNorthPanel(JPanel north) {
        north.setLayout(new BorderLayout());
        JPanel northUpper = new JPanel(new GridLayout());

        JButton pause = new JButton("Pause");
        Decorator.setButtonStyle(pause,40);


        pause.addActionListener(e -> {
            JDialog pauseDialog = createPauseDialog(e);
            pauseDialog.setVisible(true);
        });

        JButton center = new JButton(currentStage.getName());
        Decorator.setButtonStyle(center,40);
        center.setEnabled(false);

        JButton rightButton = new JButton("Right");
        Decorator.setButtonStyle(rightButton,40);
        rightButton.setEnabled(false);

        northUpper.add(pause);
        northUpper.add(center);
        northUpper.add(rightButton);
        northUpper.setPreferredSize(new Dimension(WIDTH, 150));

        JPanel marginBottom = new JPanel();
        marginBottom.setPreferredSize(new Dimension(WIDTH,50));

        north.add(northUpper, BorderLayout.CENTER);
        north.add(marginBottom, BorderLayout.SOUTH);

        north.setPreferredSize(new Dimension(WIDTH,150));
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
        String name = MainFrame.getCurrentUser();
        Record record = new Record(name, stageName, difficulty, timeSpent);
        System.out.println("record = " + record);

        MainFrame.writeRecord(record.toString());
        MainFrame.getRecordManager().addRecord(record);

    }

    private JDialog createPauseDialog(ActionEvent e) {
        JFrame currentFrame=null;
        Window window = SwingUtilities.getWindowAncestor((Component) e.getSource());
        if (window instanceof JFrame) {
            currentFrame = (JFrame) window;
            System.out.println("Current Frame Title: " + currentFrame.getTitle());
        }

        LeftPanel.pauseClock();

        JDialog pauseDialog = new JDialog(currentFrame, "Paused", true);
        pauseDialog.setSize(600, 300);
        pauseDialog.setLayout(new BoxLayout(pauseDialog.getContentPane(), BoxLayout.Y_AXIS));

        JLabel pauseLabel = new JLabel("Paused", JLabel.CENTER);
        pauseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton resumeButton = new JButton("Resume");
        resumeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Define the action to close the pause dialog
        resumeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LeftPanel.resumeClock();
                pauseDialog.dispose();
            }
        });
        backButton.addActionListener(evt -> {
            StageSelectionPanel s = new StageSelectionPanel();
            JPanel cardPanel = MainFrame.getCardPanel();
            cardPanel.add(s, "select");
            MainFrame.getCardLayout().show(cardPanel,"select");
            pauseDialog.dispose();
        });

        pauseDialog.add(Box.createVerticalGlue());
        pauseDialog.add(pauseLabel);
        pauseDialog.add(Box.createRigidArea(new Dimension(0, 20)));
        pauseDialog.add(resumeButton);
        pauseDialog.add(Box.createVerticalGlue());
        pauseDialog.add(backButton);
        pauseDialog.add(Box.createVerticalGlue());

        pauseDialog.setLocationRelativeTo(currentFrame);

        return pauseDialog;
    }

    public static Stage getCurrentStage() {
        return currentStage;
    }
}
