package trashcan;

import javax.swing.*;
import java.awt.*;

public class TempFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    static JLabel scoreLabel;

    public void setupMainPanel() {
        JPanel top = new JPanel(new GridLayout(1, 3));
        TempPanels board = null;
        setTitle("Make Ten Game");
        Container pane = getContentPane(); // 여기서만 쓰이는 것은 지역변수로
        top.setPreferredSize(new Dimension(300, 50));
        board = new TempPanels();

        JLabel topLabel = new JLabel("Make Ten");
        topLabel.setFont(topLabel.getFont().deriveFont(24.0f));
        scoreLabel = new JLabel("점수: 0");
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(24.0f));
        top.add(scoreLabel, BorderLayout.CENTER);
        top.add(topLabel);

        JPanel posPane = new JPanel(new BorderLayout());
        posLabel = new JLabel("<html>현재위치 (0, 0)&nbsp</html>");
        posLabel.setFont(posLabel.getFont().deriveFont(28.0f));
        posPane.add(posLabel, BorderLayout.LINE_END);
        top.add(posPane, BorderLayout.LINE_END);

        pane.add(top, BorderLayout.LINE_START);

        String[] ex = {
                "10101",
                "01010",
                "10101",
                "01010",
                "10101"
        };
        board.init(ex);
//        pane.add(board, BorderLayout.CENTER);

        DividedBoard db = new DividedBoard();
        db.init(ex);

        GBB g = new GBB();
        g.init(ex);

        JPanel left = new JPanel();
        left.setBackground(Color.RED);
        left.setPreferredSize(new Dimension(50,100));
        JPanel upper = new JPanel();
        upper.setPreferredSize(new Dimension(100,50));
        JPanel lower = new JPanel();
        lower.setPreferredSize(new Dimension(100,50));
        pane.add(upper,BorderLayout.PAGE_START);
        pane.add(g,BorderLayout.CENTER);
        pane.add(lower, BorderLayout.PAGE_END);
        pane.add(left, BorderLayout.LINE_END);

    }

    static void addScore() {
        String scoreText = scoreLabel.getText().substring(4);
        scoreLabel.setText("점수: " + (Integer.parseInt(scoreText) + 10));
    }

    static JLabel posLabel;

    static void setPosLabel(int x, int y) {
        posLabel.setText("<html>현재위치 (" + x + ", " + y + ")&nbsp</html>");
    }

    private void createAndShowGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMainPanel();
        setPreferredSize(new Dimension(800, 600));
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        TempFrame frame = new TempFrame();
        frame.createAndShowGUI();
    }
}

