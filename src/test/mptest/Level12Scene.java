package test.mptest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Level12Scene extends JFrame implements ActionListener {
	Container pane = getContentPane();
	JButton undoButton;
	JLabel hintLabel;
	JButton[][] button = new JButton[15][15];
	JLabel[][] lowNumber = new JLabel[8][15]; 
	JLabel[][] colNumber = new JLabel[8][15];
	String[][] low = new String[8][15]; 
	String[][] col = new String[8][15];
	int[][] question = new int[15][15];
	int[][] answer = new int[15][15];
	int paint;
	
	public Level12Scene() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nonograms");
		pane.setLayout(null);
		setPreferredSize(new Dimension(1200, 1000));
		pane.setBackground(new Color(242, 170, 132));
		readFile("level12.txt");
		paint=calculatePaint();
		
		undoButton = new JButton("Undo");
		undoButton.setSize(100, 50);
		undoButton.setLocation(0, 0);
		undoButton.setBackground(new Color(255, 255, 255));
		undoButton.addActionListener(this);
		undoButton.setVisible(true);
		pane.add(undoButton);
		
		hintLabel = new JLabel("Hint : " + paint);
		hintLabel.setSize(300, 250);
		hintLabel.setFont(new Font("고딕", Font.PLAIN, 30));
		hintLabel.setLocation(250, 100);
		hintLabel.setVisible(true);
		pane.add(hintLabel);
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				button[i][j] = new JButton();
				button[i][j].setSize(40, 40);
				button[i][j].setLocation(400 + i * 40, 320 + j * 40);
				button[i][j].setBackground(Color.WHITE);
				button[i][j].addActionListener(this);
				button[i][j].addMouseListener(new MouseAdapter() { 
					@Override 
					public void mouseClicked(MouseEvent e) { 
						if (SwingUtilities.isRightMouseButton(e)) { 
							JButton clickButton = (JButton) e.getSource(); 
							if (clickButton.getText().equals("X")) { 
								clickButton.setText(""); 
								} 
							else { 
								clickButton.setText("X"); 
								clickButton.setFont(new Font("Arial", Font.BOLD, 9));
								} 
							} 
						} 
					});
				button[i][j].setVisible(true);
				add(button[i][j]);
				question[i][j] = 0;
			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 15; j++) {
				lowNumber[i][j] = new JLabel(low[i][j]);
				lowNumber[i][j].setSize(40, 40);
				lowNumber[i][j].setLocation(415 + j * 40, 0 + i * 40);
				lowNumber[i][j].setFont(new Font("고딕", Font.PLAIN, 20));
				if (low[i][j].equals("0") && !(i == 8)) {
					lowNumber[i][j].setVisible(false);
				}
				else {
					lowNumber[i][j].setVisible(true);
				}
				add(lowNumber[i][j]);
			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 15; j++) {
				colNumber[i][j] = new JLabel(col[i][j]);
				colNumber[i][j].setSize(40, 40);
				colNumber[i][j].setLocation(90 + i * 40, 320 + j * 40);
				colNumber[i][j].setFont(new Font("고딕", Font.PLAIN, 20));
				if (col[i][j].equals("0") && !(i == 8)) {
					colNumber[i][j].setVisible(false);
				}
				else {
					colNumber[i][j].setVisible(true);
				}
				add(colNumber[i][j]);
			}
		}
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	private void readFile(String fileName) { 
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { 
			String line; String section = ""; 
			int row = 0; 
			while ((line = br.readLine()) != null) { 
				if (line.equals("row")) { 
					section = "row"; row = 0; 
					} 
				else if (line.equals("col")) { 
					section = "col"; row = 0; 
					} 
				else if (line.equals("answer")) { 
					section = "answer"; row = 0; 
					} 
				else { 
					String[] parts = line.split(" "); 
					if (section.equals("row")) { 
						low[row] = parts; 
						} 
					else if (section.equals("col")) { 
						col[row] = parts; 
						} 
					else if (section.equals("answer")) { 
						for (int i = 0; i < parts.length; i++) { 
							answer[row][i] = Integer.parseInt(parts[i]); 
							} 
						} row++; 
						} 
				} 
			} catch (IOException e) { 
				e.printStackTrace(); 
				} 
		}
	
	private int calculatePaint() {
		int count = 0; 
		for (int i = 0; i < 15; i++) { 
			for (int j = 0; j < 15; j++) { 
				if (answer[i][j] == 1) { 
					count++; 
					} 
				} 
			} 
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Level12Scene level12scene = new Level12Scene();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == undoButton) {
			LevelScene levelscene = new LevelScene();
			levelscene.setVisible(true);
			dispose();
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (e.getSource() == button[i][j]) {
					if (button[i][j].getBackground() == Color.WHITE) {
						button[i][j].setBackground(Color.BLACK);
						button[i][j].setText("");
						question[i][j] = 1;
						paint--;
					} else if (button[i][j].getBackground() == Color.BLACK) {
						button[i][j].setBackground(Color.WHITE);
						question[i][j] = 0;
						paint++;
					} else if (button[i][j].getText().equals("X")) { 
						button[i][j].setText("");
					}
					hintLabel.setText("Hint : " + paint);
				}
			}
		}
		if (isAnswer()) {
			ClearScene clearscene = new ClearScene();
			clearscene.setVisible(true);
			dispose();
		}
	}

	private boolean isAnswer() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (question[i][j] != answer[j][i]) {
					return false;
				}
			}
		}
		return true;
	}
}