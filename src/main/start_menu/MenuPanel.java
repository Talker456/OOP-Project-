package main.start_menu;

import main.MainFrame;
import main.ProfilePanel;
import main.RankingPanel;
import main.StageSelectionPanel;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel() {

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(35, 35, 35));
        topPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(70, 130, 180)),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));

        JButton undoButton = new JButton("Back");
        undoButton.setPreferredSize(new Dimension(120, 50));
        undoButton.setBackground(new Color(70, 130, 180));
        undoButton.setForeground(Color.WHITE);
        undoButton.setFont(new Font("Arial", Font.BOLD, 20));
        undoButton.setFocusPainted(false);
        undoButton.addActionListener(e->{
            LoginPanel l = new LoginPanel();
            JPanel cardPanel = MainFrame.getCardPanel();
            cardPanel.add(l, "login");
            MainFrame.getCardLayout().show(cardPanel,"login");

        });
        topPanel.add(undoButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("MENU", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(new Color(255, 215, 0));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);


        // 1행 3열 패널
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.setBackground(new Color(35, 35, 35));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel clockLabel = new JLabel();
        Font font = new Font("Arial", Font.BOLD, 20);
        clockLabel.setFont(font);
        clockLabel.setBackground(new Color(35, 35, 35));
        clockLabel.setForeground(Color.white);
        RealTimeClock clock = new RealTimeClock(clockLabel);
        clock.startClock();
        bottomPanel.add(clockLabel);


        JLabel nonogramsLabel = new JLabel("NONOGRAMS", SwingConstants.CENTER);
        nonogramsLabel.setForeground(Color.WHITE);
        nonogramsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bottomPanel.add(nonogramsLabel);

        JLabel myPageLabel = new JLabel("MENU", SwingConstants.CENTER);
        myPageLabel.setForeground(new Color(255, 215, 0)); // Golden color for better emphasis
        myPageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bottomPanel.add(myPageLabel);

        add(bottomPanel, BorderLayout.SOUTH);
//
        // 공통된 버튼 설정 메서드로 반복 코드 줄이

        BackgroundPanel centerPanel = new BackgroundPanel("characterbackground2.jpg");
        centerPanel.setLayout(new GridBagLayout()); // GridBagLayout 설정
        GridBagConstraints gbc = new GridBagConstraints();

        Font bigFont = new Font("Arial", Font.BOLD, 25);

        // 공통 설정
        gbc.insets = new Insets(0, 50, 0, 50); // 버튼 간격 설정 (좌우 50 픽셀)
        gbc.gridy = 0; // 같은 행에 배치

        // GO TO STAGE 버튼
        JButton rankbutton = new JButton("GO TO STAGE");
        rankbutton.setFont(bigFont);
        rankbutton.setForeground(Color.white);
        rankbutton.setBackground(new Color(35, 35, 35));
        rankbutton.setPreferredSize(new Dimension(200, 220));
        gbc.gridx = 0; // 첫 번째 열
        centerPanel.add(rankbutton, gbc);

        // RANKING 버튼
        JButton stagebutton = new JButton("RANKING");
        stagebutton.setFont(bigFont);
        stagebutton.setForeground(Color.white);
        stagebutton.setBackground(new Color(35, 35, 35));
        stagebutton.setPreferredSize(new Dimension(200, 220));
        gbc.gridx = 1; // 두 번째 열
        centerPanel.add(stagebutton, gbc);

        // MY PAGE 버튼
        JButton mypagebutton = new JButton("MY PAGE");
        mypagebutton.setFont(bigFont);
        mypagebutton.setForeground(Color.white);
        mypagebutton.setBackground(new Color(35, 35, 35));
        mypagebutton.setPreferredSize(new Dimension(200, 220));
        gbc.gridx = 2; // 세 번째 열
        centerPanel.add(mypagebutton, gbc);

        // 각 버튼에 호버 효과 추가
        addHoverEffect(rankbutton, new Color(70, 130, 180)); // 원하는 배경색
        addHoverEffect(stagebutton, new Color(70, 130, 180));
        addHoverEffect(mypagebutton, new Color(70, 130, 180));

        // 버튼 클릭 리스너 추가
        rankbutton.addActionListener(e -> {
            System.out.println("stage button hit");
            StageSelectionPanel selectionPanel = new StageSelectionPanel();
            JPanel cardPanel = MainFrame.getCardPanel();
            cardPanel.add(selectionPanel, "select");
            MainFrame.getCardLayout().show(cardPanel, "select");
        });

        stagebutton.addActionListener(e -> {
            System.out.println("rank button hit");
            RankingPanel rankingPanel = new RankingPanel();
            JPanel cardPanel = MainFrame.getCardPanel();
            cardPanel.add(rankingPanel, "rank");
            MainFrame.getCardLayout().show(cardPanel, "rank");
        });

        mypagebutton.addActionListener(e -> {
            CardLayout cardLayout = MainFrame.getCardLayout();
            JPanel cardPanel = MainFrame.getCardPanel();
            ProfilePanel p = new ProfilePanel();
            cardPanel.add(p, "profile");
            cardLayout.show(cardPanel, "profile");
        });

        add(centerPanel, BorderLayout.CENTER);
    }
    private void addHoverEffect(JButton button, Color hoverColor) {
//        button.setOpaque(false); // 기본 상태를 투명하게 설정
//        button.setContentAreaFilled(false);
        button.setBorderPainted(true); // 테두리 활성화
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(35, 35, 35), 5)); // 기본 테두리 설정

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setOpaque(true); // 마우스가 올라오면 배경 활성화
                button.setBackground(hoverColor); // 원하는 배경색
                button.setContentAreaFilled(true);
                button.setForeground(new Color(241, 221, 111));
                button.setBorder(BorderFactory.createLineBorder(new Color(241, 221, 111), 5)); // 마우스 오버 시 테두리 색상 변경
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
//                button.setOpaque(false); // 마우스가 나가면 다시 투명하게
//                button.setContentAreaFilled(false);
                button.setBackground(new Color(35, 35, 35));
                button.setForeground(Color.white);
                button.setBorder(BorderFactory.createLineBorder(new Color(35, 35, 35), 5)); // 기본 테두리로 돌아감
            }
        });
    }
}
