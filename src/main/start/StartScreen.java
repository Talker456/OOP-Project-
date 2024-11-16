package main.start;

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JFrame {
    private static final long serialVersionUID = 1L;

    public StartScreen() {
        setTitle("NONOGRAMS");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  // 레이아웃을 null로 설정하여 직접 위치 지정

        // 배경 이미지 불러오기 및 크기 축소
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("nonogray.PNG"));
        Image img = originalIcon.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        // 배경 이미지 JLabel에 설정
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(-10, -100, 800, 700);
        add(backgroundLabel);  // JLabel을 JFrame에 추가

        // 네모 박스 패널 생성
        JPanel boxPanel = new JPanel();
        boxPanel.setBounds(225, 330, 350, 150); // 박스 위치와 크기 설정
        boxPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // 박스 외곽선 설정
        add(boxPanel);

        // 텍스트 레이블 설정
        JLabel textLabel = new JLabel("닉네임을 입력하세요.");
        textLabel.setFont(new Font("Serif", Font.ITALIC, 20));
        textLabel.setBounds(310, 285, 300, 40);  // 위치와 크기 설정
        add(textLabel);

        // 텍스트 입력 필드 설정
        JTextField nameField = new JTextField(20);
        nameField.setFont(new Font("Serif", Font.BOLD, 16));
        nameField.setBounds(260, 350, 280, 35);  // 위치와 크기 설정
        add(nameField);

        // 로그인 버튼 설정
        JButton startButton = new JButton("LOG IN");
        startButton.setBackground(Color.DARK_GRAY);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Dilog", Font.BOLD, 12));
        startButton.setBounds(300, 400, 200, 30);
        add(startButton);

        setVisible(true);  // 창을 보이게 설정

        // 로그인 버튼 클릭 시 메뉴 화면으로 전환
        startButton.addActionListener(e -> {
            new MenuScreen(nameField.getText());  // 메뉴 화면 생성
            setVisible(false); // 현재 창을 숨김
        });
    }

    public static void main(String[] args) {
        new StartScreen();// 시작 화면 생성
    }
}


