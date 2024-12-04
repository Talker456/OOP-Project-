package main.start_menu;

import main.MainFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LoginPanel extends JPanel {
    public LoginPanel() {
        setLayout(new BorderLayout());

        System.out.println("construct login");
        BackgroundPanel startPanel = new BackgroundPanel("characterbackground.jpg");


        JLabel titleLabel = new JLabel("NONOGRAMS");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 80));
        titleLabel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JTextField nicknameField = new JTextField(20);
        nicknameField.setFont(new Font("Serif", Font.BOLD, 16));
        nicknameField.setPreferredSize(new Dimension(280, 40));
        nicknameField.setMaximumSize(new Dimension(280, 40));
        nicknameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        nicknameField.setBorder(new LineBorder(Color.BLACK, 2));

        JButton startButton = new JButton("LOG IN");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setBackground(Color.DARK_GRAY);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Diolog", Font.BOLD, 13));

        JLabel textLabel = new JLabel("닉네임을 입력하세요.");
        textLabel.setFont(new Font("Serif", Font.ITALIC, 20));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));
        startPanel.setPreferredSize(new Dimension(WIDTH, 850));

        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.Y_AXIS));


        startPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        startPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nicknameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        startPanel.add(Box.createVerticalGlue());
        startPanel.add(titleLabel);
        startPanel.add(Box.createRigidArea(new Dimension(0, 25)));
        startPanel.add(textLabel);
        startPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        startPanel.add(nicknameField);
        startPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        startPanel.add(startButton);
        startPanel.add(Box.createVerticalGlue());

        startButton.addActionListener(e -> {
            String name = nicknameField.getText();
            MainFrame.setUsername(name);
            MainFrame.showPanel(new MenuPanel(),"menu");
        });

        add(startPanel,BorderLayout.CENTER);
    }

    public class BackgroundPanel extends JPanel {
        private Image backgroundImage;



        public BackgroundPanel(String imagePath) {

            backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}