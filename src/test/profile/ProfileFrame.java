package test.profile;

import test.start.MenuFrame;
import test.RecordManager;
import test.Record;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfileFrame extends JFrame implements ActionListener {
    Container pane = getContentPane();
    JButton undoButton;
    JLabel resultLabel;
    static String currentUser;
    RecordManager recordManager;

    public ProfileFrame(String username, RecordManager recordManager) {
        currentUser = username;
        this.recordManager = recordManager;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("NONOGRAMS");
        pane.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(900, 750));
        pane.setBackground(new Color(245, 245, 245));

        // Top panel with back button
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(35, 35, 35));
        topPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(70, 130, 180)),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));

        undoButton = new JButton("Back");
        undoButton.setPreferredSize(new Dimension(120, 50));
        undoButton.setBackground(new Color(70, 130, 180));
        undoButton.setForeground(Color.WHITE);
        undoButton.setFont(new Font("Arial", Font.BOLD, 20));
        undoButton.setFocusPainted(false);
        undoButton.addActionListener(this);
        topPanel.add(undoButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("MY PAGE", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(new Color(255, 215, 0));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        pane.add(topPanel, BorderLayout.NORTH);

        // Center panel for user information
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(245, 245, 245));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel profileTitle = new JLabel("User Information", SwingConstants.CENTER);
        profileTitle.setFont(new Font("Arial", Font.BOLD, 35));
        profileTitle.setForeground(new Color(100, 149, 237));
        profileTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(profileTitle);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        resultLabel = new JLabel();
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        resultLabel.setForeground(new Color(60, 60, 60));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 130, 180), 2, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        // Displaying current user information
        StringBuilder userInfo = new StringBuilder("<html><div style='text-align: center;'>닉네임: " + currentUser + "<br/><br/>도달한 스테이지:<br/><br/>");

        // Get user's records and append to the label
        // mainFrame.recordmanage desired
        ArrayList<Record> userRecords = recordManager.getUserRecord(currentUser);
        if (userRecords.isEmpty()) {
            userInfo.append("클리어한 스테이지가 없습니다.<br/>");
        } else {
            for (Record record : userRecords) {
                userInfo.append("스테이지: ").append(record.getStageName())
                        .append(", 난이도: ").append(record.getDifficulty())
                        .append(", 클리어 시간: ").append(record.getTime())
                        .append("<br/>");
            }
        }
        userInfo.append("</div></html>");

        resultLabel.setText(userInfo.toString());
        centerPanel.add(resultLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton viewAchievementsButton = new JButton("Achivements");
        viewAchievementsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewAchievementsButton.setFont(new Font("Arial", Font.BOLD, 20));
        viewAchievementsButton.setBackground(new Color(70, 130, 180));
        viewAchievementsButton.setForeground(Color.WHITE);
        viewAchievementsButton.setFocusPainted(false);
        viewAchievementsButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "기능 미구현", "Achievements", JOptionPane.INFORMATION_MESSAGE));
        centerPanel.add(viewAchievementsButton);

        pane.add(centerPanel, BorderLayout.CENTER);

        // Bottom panel for navigation
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.setBackground(new Color(35, 35, 35));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

//        JLabel clockLabel = new JLabel("2024-11-21 11:08:40", SwingConstants.CENTER); // Placeholder for the clock
//        clockLabel.setForeground(Color.WHITE);
//        clockLabel.setFont(new Font("Arial", Font.PLAIN, 15));
//        bottomPanel.add(clockLabel);

        JLabel nonogramsLabel = new JLabel("NONOGRAMS", SwingConstants.CENTER);
        nonogramsLabel.setForeground(Color.WHITE);
        nonogramsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bottomPanel.add(nonogramsLabel);

        JLabel myPageLabel = new JLabel("MY PAGE", SwingConstants.CENTER);
        myPageLabel.setForeground(new Color(255, 215, 0)); // Golden color for better emphasis
        myPageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bottomPanel.add(myPageLabel);

        pane.add(bottomPanel, BorderLayout.SOUTH);

        setResizable(false);
        pack();
        setVisible(true);
    }

    // Overloaded constructor to provide default RecordManager
    public ProfileFrame(String username) {
        this(username, new RecordManager());
    }

    public static void main(String[] args) {
        // Example usage with dummy RecordManager
        RecordManager recordManager = new RecordManager();
        ProfileFrame profilescene = new ProfileFrame(currentUser, recordManager);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == undoButton) {
            MenuFrame m = new MenuFrame(currentUser);
            m.setVisible(true);
            this.setVisible(false);
        }
    }
}
