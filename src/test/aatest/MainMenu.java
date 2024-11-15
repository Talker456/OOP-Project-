package test.aatest;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
	private JFrame frame;
	private String userId;

	public void createAndShowGUI() {
		frame = new JFrame("노노그램 게임");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLayout(new BorderLayout());

		userId = JOptionPane.showInputDialog(frame, "아이디를 입력하세요:", "ID 입력", JOptionPane.PLAIN_MESSAGE);
		if (userId == null || userId.trim().isEmpty()) {
			JOptionPane.showMessageDialog(frame, "아이디가 입력되지 않았습니다");
			userId = "익명";
		}

		initTopPanel();
		showDifficultyOptions();

		frame.setVisible(true);
	}

	private void initTopPanel() {
		JPanel topPanel = new JPanel(new BorderLayout());
		JButton rankButton = new JButton("랭킹");
		JButton helpButton = new JButton("게임 설명");
		JButton endButton = new JButton("게임 종료");

		rankButton.addActionListener(e -> showRanking());
		helpButton.addActionListener(e -> new HelpDialog(frame).show());
		endButton.addActionListener(e -> System.exit(0));

		topPanel.add(rankButton, BorderLayout.WEST);
		topPanel.add(helpButton, BorderLayout.CENTER);
		topPanel.add(endButton, BorderLayout.EAST);
		frame.add(topPanel, BorderLayout.NORTH);
	}

	private void showDifficultyOptions() {
		JPanel difficultyPanel = new JPanel(new FlowLayout());
		JButton easyButton = new JButton("쉬움");
		JButton normalButton = new JButton("보통");
		JButton hardButton = new JButton("어려움");

		easyButton.addActionListener(e -> startGame("easy.txt"));
		normalButton.addActionListener(e -> startGame("normal.txt"));
		hardButton.addActionListener(e -> startGame("hard.txt"));

		difficultyPanel.add(easyButton);
		difficultyPanel.add(normalButton);
		difficultyPanel.add(hardButton);
		frame.add(difficultyPanel, BorderLayout.SOUTH);
	}

	private void startGame(String filename) {
		frame.setVisible(false);
		MainFrame gameFrame = new MainFrame(userId, filename);
		gameFrame.createAndShowGUI();
	}

	private void showRanking() {
		new RankingViewer().showRanking();
	}
}
