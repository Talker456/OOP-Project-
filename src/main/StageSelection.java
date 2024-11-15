package main;

import main.scenes.MainScene;

import javax.swing.*;
import java.awt.*;

public class StageSelection extends JPanel {

    public void init(String username,JButton back) {

        setLayout(new BorderLayout());
        JPanel upper = new JPanel();
        setUpperLabel(username, upper,back);



        JPanel lower = new JPanel();
        lower.setPreferredSize(new Dimension(WIDTH, 50));

        StageSelectionCenter center = new StageSelectionCenter();
        center.init();

        this.add(upper,BorderLayout.PAGE_START);
        this.add(center,BorderLayout.CENTER);
        this.add(lower,BorderLayout.PAGE_END);

        setPreferredSize(new Dimension(800, 700));
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
