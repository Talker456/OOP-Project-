package main.start_menu;

import main.MainFrame;
import main.ProfilePanel;
import main.RankingPanel;
import main.StageSelectionPanel;
import test.RealTimeClock;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel() {

        setLayout(new BorderLayout());

        // 1행 3열 패널
        JPanel southPanel = new JPanel(new GridLayout(1, 3));

        // 이미지 불러오기
        ImageIcon southIcon;
        try {
            southIcon = new ImageIcon(getClass().getResource("nonowhite.PNG"));
        } catch (NullPointerException e) {
            southIcon = new ImageIcon(); // 기본 아이콘
            System.out.println("이미지를 로드할 수 없습니다.");
        }

        // 이미지 크기 조정
        int buttonWidth = 200;
        int buttonHeight = 50;
        Image scaledImage = southIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        // 버튼 생성
        JButton button1 = new JButton();
        button1.setEnabled(false);
        RealTimeClock clock = new RealTimeClock(button1);
        clock.startClock(); // 시계 시작

        JButton button2 = new JButton();
        JButton button3 = new JButton("MY PAGE");

        button1.setForeground(Color.WHITE); // 글씨 색 설정
        button3.setForeground(Color.white);
        button3.addActionListener(e->{
//            CardLayout cardLayout = MainFrame.getCardLayout();
//            JPanel cardPanel = MainFrame.getCardPanel();
//            ProfilePanel p = new ProfilePanel();
//            cardPanel.add(p, "profile");
//            cardLayout.show(cardPanel,"profile");
            MainFrame.showPanel(new ProfilePanel(),"profile");
        });

        // 버튼 글씨 폰트 설정
        Font font = new Font("Arial", Font.BOLD, 20);
        button1.setFont(font);
        button3.setFont(font);

        // 버튼 배경색 설정
        button1.setBackground(Color.DARK_GRAY);
        button2.setBackground(Color.DARK_GRAY);
        button3.setBackground(Color.DARK_GRAY);
        button2.setOpaque(true); // 불투명하게 설정
        button2.setIcon(resizedIcon); // 버튼에 아이콘 설정
        button2.setEnabled(false); // 버튼 비활성화

        // 패널에 버튼 추가
        southPanel.add(button1);
        southPanel.add(button2);
        southPanel.add(button3);

        JPanel centerPanel = new JPanel(new GridLayout(2, 1));

        JButton rankbutton = new JButton();
        JButton stagebutton = new JButton();

        rankbutton.setBackground(Color.LIGHT_GRAY);
        rankbutton.addActionListener(e->{
            RankingPanel rankingPanel = new RankingPanel(MainFrame.getCurrentUser());
            JPanel cardPanel = MainFrame.getCardPanel();
            cardPanel.add(rankingPanel, "rank");
            MainFrame.getCardLayout().show(cardPanel,"rank");
        });

        stagebutton.setBackground(Color.LIGHT_GRAY);
        stagebutton.addActionListener(e -> {

            System.out.println("stage button hit");
            StageSelectionPanel selectionPanel = new StageSelectionPanel();
            JPanel cardPanel = MainFrame.getCardPanel();
            cardPanel.add(selectionPanel, "select");
            MainFrame.getCardLayout().show(cardPanel, "select");
        });

        // 센터 이미지 불러오기
        ImageIcon centerIcon;
        try {
            centerIcon = new ImageIcon(getClass().getResource("nonobackground.jpg"));
        } catch (NullPointerException e) {
            centerIcon = new ImageIcon();
        }
        int centerWidth = 700;
        int centerHeight = 700;
        Image centerImage = centerIcon.getImage().getScaledInstance(centerWidth, centerHeight, Image.SCALE_SMOOTH);
        ImageIcon putstageIcon = new ImageIcon(centerImage);

        ImageIcon rankIcon;
        try {
            rankIcon = new ImageIcon(getClass().getResource("rankbackground.jpg"));
        } catch (NullPointerException e) {
            rankIcon = new ImageIcon();
        }
        int rankWidth = 800;
        int rankHeight = 800;
        Image rankImage = rankIcon.getImage().getScaledInstance(rankWidth, rankHeight, Image.SCALE_SMOOTH);
        ImageIcon putrankIcon = new ImageIcon(rankImage);

        // 센터 패널에 버튼추가
        centerPanel.add(rankbutton);
        centerPanel.add(stagebutton);

        // 센터 버튼에 아이콘 설정
        stagebutton.setIcon(putstageIcon);
        rankbutton.setIcon(putrankIcon);

        // 동쪽 버튼 생성
        JButton westButton = new JButton("back");
        westButton.setBackground(Color.DARK_GRAY);
        westButton.setForeground(Color.WHITE);
        westButton.setFont(font);
        westButton.addActionListener(e->{
            LoginPanel l = new LoginPanel();
            JPanel cardPanel = MainFrame.getCardPanel();
            cardPanel.add(l, "login");
            MainFrame.getCardLayout().show(cardPanel,"login");

        });

        // 패널에 추가
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
        add(westButton, BorderLayout.WEST);
    }
}
