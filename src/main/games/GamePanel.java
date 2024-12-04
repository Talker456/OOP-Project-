package main.games;

import main.Decorator;
import main.StageSelectionPanel;
import main.start_menu.MenuPanel;
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

        JPanel topPanel = new JPanel();
        setTopPanel(topPanel);

        JPanel right = new JPanel();
        right.setPreferredSize(new Dimension(130,HEIGHT));
        JPanel south = new JPanel();
        south.setPreferredSize(new Dimension(WIDTH,50));

        this.add(left, BorderLayout.WEST);
        this.add(topPanel, BorderLayout.PAGE_START);
        this.add(fullBoard,BorderLayout.CENTER);
        this.add(right, BorderLayout.LINE_END);
        this.add(south, BorderLayout.PAGE_END);

    }

    private void setTopPanel(JPanel topPanel) {
        topPanel.setLayout(new BorderLayout());

        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        upperPanel.setBackground(new Color(35, 35, 35));
        upperPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(70, 130, 180)),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));

        JButton pauseButton = new JButton("Pause");
        pauseButton.setPreferredSize(new Dimension(120, 50));
        pauseButton.setBackground(new Color(70, 130, 180));
        pauseButton.setForeground(Color.WHITE);
        pauseButton.setFont(new Font("Arial", Font.BOLD, 20));
        pauseButton.setFocusPainted(false);
        pauseButton.addActionListener(e->{
            JDialog pauseDialog = createPauseDialog(e);
            pauseDialog.setVisible(true);
        });
        upperPanel.add(pauseButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel(currentStage.getName(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(new Color(255, 215, 0));
        upperPanel.add(titleLabel, BorderLayout.CENTER);

        JPanel marginBottom = new JPanel();
        marginBottom.setPreferredSize(new Dimension(WIDTH, 50));

        topPanel.add(upperPanel, BorderLayout.CENTER);
        topPanel.add(marginBottom, BorderLayout.SOUTH);

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
        JFrame frame = MainFrame.getInstance();

        LeftPanel.pauseClock();


        JDialog pauseDialog = new JDialog(frame, "Paused", true);
        pauseDialog.setSize(400, 300);
        pauseDialog.setLayout(new BoxLayout(pauseDialog.getContentPane(), BoxLayout.Y_AXIS));

        JPanel upperPanel = new JPanel();
        upperPanel.setPreferredSize(new Dimension(WIDTH,100));
        upperPanel.setBackground(new Color(35, 35, 35));
        upperPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(70, 130, 180)),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));


        JLabel pauseLabel = new JLabel("Paused", JLabel.CENTER);
        pauseLabel.setFont(new Font(("Arial"), Font.BOLD, 40));
        pauseLabel.setForeground(new Color(255, 215, 0));
        pauseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        upperPanel.add(pauseLabel);

        JButton resumeButton = new JButton("Resume");
        Decorator.setButtonStyle(resumeButton,20);
        resumeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButton = new JButton("Back");
        Decorator.setButtonStyle(backButton,20);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton resetButton = new JButton("Reset");
        Decorator.setButtonStyle(resetButton,20);
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Define the action to close the pause dialog
        resumeButton.addActionListener(e1 -> {
            LeftPanel.resumeClock();
            pauseDialog.dispose();
        });
        backButton.addActionListener(e1 -> {
            MainFrame.showPanel(new StageSelectionPanel(),"select");
            pauseDialog.dispose();
        });
        resetButton.addActionListener(e1->{
            GamePanel g = new GamePanel(currentStage);
            LeftPanel.resumeClock();
            MainFrame.showPanel(g,"game");
            pauseDialog.dispose();
        });

        pauseDialog.add(Box.createVerticalGlue());
        pauseDialog.add(upperPanel);
        pauseDialog.add(Box.createRigidArea(new Dimension(0, 20)));
        pauseDialog.add(resumeButton);
        pauseDialog.add(Box.createRigidArea(new Dimension(0, 20)));
        pauseDialog.add(backButton);
        pauseDialog.add(Box.createRigidArea(new Dimension(0, 20)));
        pauseDialog.add(resetButton);
        pauseDialog.add(Box.createRigidArea(new Dimension(0, 20)));

        pauseDialog.setLocationRelativeTo(frame);

        return pauseDialog;
    }

    public static Stage getCurrentStage() {
        return currentStage;
    }
}
