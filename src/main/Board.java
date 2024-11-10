package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class Board extends JPanel implements ActionListener {
    static int rowSize; //MOD
    static int colSize; //MOD
    static Pixel[][] cellPanel;
    static boolean state=true;
    String[] stageCopy;
    static char[][] currentState;

    void init(String[] img) {
        rowSize = img.length;
        colSize = img.length;
        cellPanel = new Pixel[rowSize][colSize];
        stageCopy = Arrays.copyOf(img, img.length);
        currentState = new char[img.length][img.length];

        for (char[] chars : currentState) {
            Arrays.fill(chars, '0');
        }

        setLayout(new GridLayout(rowSize, colSize));

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                cellPanel[i][j] = new Pixel(img[i].charAt(j),i,j);
                cellPanel[i][j].setText("");
                cellPanel[i][j].addActionListener(this);
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
        System.out.println("terminated");
        int hintUsed = 3 - LeftPanel.getHintLeft();
        Record record = new Record("name", "diff", "time", hintUsed);
        System.out.println(record);
    }

    public void hintCall() {
        Random r = new Random();
        int x,y;

        do {
            x = r.nextInt(rowSize);
            y = r.nextInt(colSize);
        } while (currentState[x][y] == '1' || !cellPanel[x][y].isCell );

        System.out.println("x = " + x);
        System.out.println("y = " + y);

        cellPanel[x][y].setBackground(Color.darkGray);
        currentState[x][y] = '1';
        if (checkCleared()) {
            terminate();
        }
    }
}