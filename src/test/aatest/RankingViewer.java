package test.aatest;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RankingViewer {
	public void showRanking() {
		JFrame rankingFrame = new JFrame("랭킹");
		rankingFrame.setSize(400, 400);
		rankingFrame.setLayout(new BorderLayout());

		JPanel topPanel = new JPanel(new FlowLayout());
		JButton easyButton = new JButton("쉬움");
		JButton normalButton = new JButton("보통");
		JButton hardButton = new JButton("어려움");

		JTextArea rankingArea = new JTextArea(15, 30);
		rankingArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(rankingArea);

		easyButton.addActionListener(e -> loadRanking("easy_ranking.txt", rankingArea));
		normalButton.addActionListener(e -> loadRanking("normal_ranking.txt", rankingArea));
		hardButton.addActionListener(e -> loadRanking("hard_ranking.txt", rankingArea));

		topPanel.add(easyButton);
		topPanel.add(normalButton);
		topPanel.add(hardButton);

		rankingFrame.add(topPanel, BorderLayout.NORTH);
		rankingFrame.add(scrollPane, BorderLayout.CENTER);
		rankingFrame.revalidate();
		rankingFrame.repaint();
		rankingFrame.setVisible(true);
	}

	private void loadRanking(String filename, JTextArea rankingArea) {
		List<String> records = new ArrayList<>();

		try (Scanner scanner = new Scanner(new File(filename))) {
			while (scanner.hasNextLine()) {
				records.add(scanner.nextLine());
			}
		} catch (Exception e) {
			rankingArea.setText("랭킹 파일을 찾을 수 없습니다: " + filename);
			return;
		}

		Collections.sort(records, Comparator.comparingInt(record -> Integer.parseInt(record.split(",")[1])));

		rankingArea.setText("랭킹:\n");
		rankingArea.append("-----------------\n");
		int rank = 1;
		for (String record : records) {
			String[] data = record.split(",");
			rankingArea.append(rank + "등: " + data[0] + " - " + data[1] + "초\n");
			rank++;
		}
	}
}
