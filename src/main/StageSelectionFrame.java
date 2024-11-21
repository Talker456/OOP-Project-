package main;


import main.start.MenuFrame;

import javax.swing.*;
import java.awt.*;

public class StageSelectionFrame extends JFrame {
    Font font = new Font("Arial", Font.BOLD, 20);

    public static void main(String[] args) {
        new StageSelectionFrame();
    }

    public StageSelectionFrame() {
        setTitle("NONOGRAMS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        setLayout(new BorderLayout());

        JButton back = new JButton("Back");
        back.setFont(font);
        back.setBackground(Color.darkGray);
        back.setForeground(Color.white);
        back.setSize(50,HEIGHT);
        back.addActionListener(e->{
            new MenuFrame(MainController.getCurrentUser());
            dispose();
        });

        JPanel bottom = new JPanel();
        setBottomPanel(bottom);

        StageSelectionCenter center = new StageSelectionCenter();
        center.init(this);

//        c.add(top,BorderLayout.PAGE_START);
        c.add(back, BorderLayout.WEST);
        c.add(center,BorderLayout.CENTER);
        c.add(bottom,BorderLayout.PAGE_END);

        setSize(800, 700);
        setVisible(true);
    }

    private void setBottomPanel(JPanel bottom) {
        bottom.setPreferredSize(new Dimension(WIDTH, 50));
        bottom.setLayout(new GridLayout(1, 3));
        JButton bottomButton1 = new JButton("User : "+ MainController.getCurrentUser());
        bottomButton1.setEnabled(false);
        bottomButton1.setForeground(Color.white);
        bottomButton1.setBackground(Color.darkGray);
        bottomButton1.setFont(font);

        JButton bottomButton2 = new JButton("NONOGRAMs");
        bottomButton2.setForeground(Color.lightGray);
        bottomButton2.setFont(font);
        bottomButton2.setEnabled(false);
        bottomButton2.setBackground(Color.darkGray);

        JButton bottomButton3 = new JButton("STAGES");
        bottomButton3.setFont(font);
        bottomButton3.setForeground(Color.white);
        bottomButton3.setBackground(Color.darkGray);
        bottomButton3.setEnabled(false);

        bottom.add(bottomButton1);
        bottom.add(bottomButton2);
        bottom.add(bottomButton3);
    }

    private void setTopPanel(JPanel top) {
        top.setLayout(new GridLayout(1, 3));
        top.setPreferredSize(new Dimension(WIDTH,50));

        JButton leftButton = new JButton("user : " + MainController.getCurrentUser());
        leftButton.setForeground(Color.white);
        leftButton.setBackground(Color.darkGray);
        leftButton.setFont(font);
        leftButton.setEnabled(false);

        JButton centerButton = new JButton("Select Stage");
        centerButton.setForeground(Color.white);
        centerButton.setBackground(Color.darkGray);
        centerButton.setFont(font);
        centerButton.setEnabled(false);

        JButton rightButton = new JButton("RIGHT");
        rightButton.setForeground(Color.white);
        rightButton.setBackground(Color.darkGray);
        rightButton.setFont(font);
        rightButton.setEnabled(false);

        top.add(leftButton);
        top.add(centerButton);
        top.add(rightButton);
    }
}
