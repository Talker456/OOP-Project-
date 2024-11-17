package main;


import main.start.MenuScreen;

import javax.swing.*;
import java.awt.*;

public class StageSelectionFrame extends JFrame {

    public static void main(String[] args) {
        new StageSelectionFrame();
    }

    public StageSelectionFrame() {
        System.out.println("STAGE SELECTION ON");

        setTitle("NONOGRAMS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        setLayout(new BorderLayout());
        JButton backButton = new JButton("back");
        backButton.addActionListener(e->{
            new MenuScreen("name"); // username!!!
            this.dispose();
        });

        JPanel upper = new JPanel();
        setUpperLabel(MainController.getCurrentUser(), upper,backButton);

        JPanel lower = new JPanel();
        lower.setPreferredSize(new Dimension(WIDTH, 50));

        StageSelectionCenter center = new StageSelectionCenter();
        center.init(this);

        c.add(upper,BorderLayout.PAGE_START);
        c.add(center,BorderLayout.CENTER);
        c.add(lower,BorderLayout.PAGE_END);

        setSize(800, 700);
        setVisible(true);
    }

    private void setUpperLabel(String username, JPanel upper,JButton back) {
        upper.setLayout(new GridLayout(1, 3));
        upper.setPreferredSize(new Dimension(WIDTH,50));
        JLabel nameLabel = new JLabel("user:" + username);
        nameLabel.setVerticalTextPosition(SwingConstants.CENTER);
        JLabel tempLabel = new JLabel("temp");
        tempLabel.setVerticalTextPosition(SwingConstants.CENTER);


        upper.add(nameLabel);
        upper.add(tempLabel);
        upper.add(back);
    }
}
