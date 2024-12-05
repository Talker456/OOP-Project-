package main.games;

import main.stage.Stage;
import main.MainFrame;
import main.StageSelectionPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class Board extends JPanel implements ActionListener {
    static int size; //MOD
    static Pixel[][] cellPanel;
    static boolean state=true;
    String[] stageCopy;
    static char[][] currentState;
    Font font = new Font("Arial", Font.BOLD, 20);
    static Stage currentStage;

    void init(Stage stage) {
        currentStage = stage;
        String[] img = currentStage.getImage();
        size = img.length;
        cellPanel = new Pixel[size][size];
        stageCopy = Arrays.copyOf(img, img.length);
        currentState = new char[img.length][img.length];

        for (char[] chars : currentState) {
            Arrays.fill(chars, '0');
        }

        setLayout(new GridLayout(size, size));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cellPanel[i][j] = new Pixel(img[i].charAt(j), i, j);
                cellPanel[i][j].setText("");
                cellPanel[i][j].addActionListener(this);
                cellPanel[i][j].addMouseListener(adapter);
                cellPanel[i][j].setBorder(BorderFactory.createBevelBorder(0));
                add(cellPanel[i][j]);
            }
        }
    }

    static Pixel selected = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        Pixel p = (Pixel) e.getSource();
        selected = p;

        buttonEvent(p);
    }


    private static final MouseAdapter adapter = new MouseAdapter() {

        boolean mouseDown = false;

        @Override
        public void mouseEntered(MouseEvent e) {
            if(mouseDown)
                ((JButton) e.getSource()).doClick();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            ((JButton) e.getSource()).doClick(); // Click the initial button
            mouseDown = true;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDown = false;
        }
    };


    private void buttonEvent(Pixel p) {
        if (p.isEmpty() && p.buttonText.isEmpty()) {
            if (state) {
                p.setBackground(Color.darkGray);
                currentState[p.x][p.y] = '1';
                if (checkCleared()) {
                    terminate();
                }
            } else {
                p.setButtonText("X");
            }
        }else if (!p.isEmpty()) {
            if (state) {
                p.setBackground(Color.lightGray);
                currentState[p.x][p.y] = '0';
            }
        }
        else {
            if (!state) {
                p.setButtonText("");
            }
        }
    }

    private static class Pixel extends JButton {
        int x,y;
        boolean isCell;
        String buttonText;

        Pixel(char isCell,int x,int y) {
            this.x = x;
            this.y = y;
            this.isCell = (isCell == '1');
            this.buttonText = "";
            this.setBackground(Color.lightGray);
        }

        void setButtonText(String text) {
            this.buttonText = text;
            this.setText(buttonText);
        }

        boolean isEmpty() {
            return getBackground().equals(Color.lightGray);
        }
    }

    public static void setState(boolean flag) {
        state = flag;
    }

    public boolean checkCleared() {
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                if (stageCopy[i].charAt(j) != currentState[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void terminate() {
        GamePanel.terminate();


        JLabel label = new JLabel(currentStage.getName()+" CLEAR!");
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);


        JOptionPane optionPane = new JOptionPane(label, JOptionPane.PLAIN_MESSAGE);
        JDialog dialog = optionPane.createDialog(MainFrame.getInstance(), "NOTICE");
        dialog.setLocation(350, 300);
        dialog.setVisible(true);

        MainFrame.showPanel(new StageSelectionPanel(),"select");

    }

    public void hintCall() {
        Random r = new Random();
        int x,y;
        int count = 0;

        String difficulty = currentStage.getDifficulty();
        switch (difficulty) {
            case "Easy":
                count = 1;
                break;
            case "Normal":
                count = 4;
                break;
            case "Hard":
                count = 8;
                break;
        }

        for (int i = 0; i < count; i++) {
            do {
                x = r.nextInt(size);
                y = r.nextInt(size);
            } while (currentState[x][y] == '1' || !cellPanel[x][y].getText().isEmpty() );

            if (cellPanel[x][y].isCell) {
                cellPanel[x][y].setBackground(Color.darkGray);
                currentState[x][y] = '1';
            }else{
                cellPanel[x][y].setBackground(Color.lightGray);
                cellPanel[x][y].setButtonText("X");
                currentState[x][y] = '0';
            }


            if (checkCleared()) {
                terminate();
            }
        }
    }
}