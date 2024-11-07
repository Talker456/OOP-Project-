package trashcan;

import javax.swing.*;
import java.awt.*;

public class GBBFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    static JLabel scoreLabel;

    public void setupMainPanel() {
        JPanel top = new JPanel(new GridLayout(3, 1));
        TempPanels board = null;
        setTitle("Make Ten Game");
        Container pane = getContentPane(); // 여기서만 쓰이는 것은 지역변수로
        top.setPreferredSize(new Dimension(200, 1));
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
        String[] ex3 = {
                "000000000000000",
                "000000000000000",
                "000000010000000",
                "000000101000000",
                "000001000100000",
                "001111000111100",
                "001000101000100",
                "000100101001000",
                "000010000010000",
                "000010000010000",
                "000100111001000",
                "000101000101000",
                "000010000010000",
                "000000000000000",
                "000000000000000",
        };

        GBB g = new GBB();
        g.init(ex3);


        pane.add(g,BorderLayout.CENTER);

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
        GBBFrame frame = new GBBFrame();
        frame.createAndShowGUI();
    }
}


