package test.mptest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class EasyScene extends JFrame implements ActionListener {
		Container pane = getContentPane();
		JButton[][] button = new JButton[5][5];
		JLabel[][] lowNumber = new JLabel[3][5]; 
		JLabel[][] colNumber = new JLabel[3][5];
		String[][] low = { { "0", "0", "0", "0", "0" }, 
				           { "0", "0", "2", "0", "0" }, 
				           { "2", "3", "1", "3", "2" } };
		String[][] col = { { "0", "0", "0", "0", "0" }, 
				           { "0", "0", "1", "0", "1" }, 
				           { "1", "3", "1", "5", "1" } };
		int[][] question = { { 0, 0, 0, 0, 0 }, 
				             { 0, 0, 0, 0, 0 }, 
				             { 0, 0, 0, 0, 0 }, 
				             { 0, 0, 0, 0, 0 }, 
				             { 0, 0, 0, 0, 0 } };
		int[][] answer = { { 0, 0, 1, 0, 0 }, 
				           { 0, 1, 1, 1, 0 }, 
				           { 0, 1, 0, 1, 0 }, 
				           { 1, 1, 1, 1, 1 }, 
				           { 1, 0, 0, 0, 1 } };

		public EasyScene() {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("Nonograms");
			pane.setLayout(null);
			setPreferredSize(new Dimension(800, 600));
			pane.setBackground(Color.LIGHT_GRAY);
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					button[i][j] = new JButton();
					button[i][j].setSize(50, 50);
					button[i][j].setLocation(350 + i * 50, 250 + j * 50);
					button[i][j].setBackground(Color.WHITE);
					button[i][j].addActionListener(this);
//					button[i][j].addMouseListener(new MouseAdapter() { 
//						@Override 
//						public void mousePressed(MouseEvent e) { 
//							if (SwingUtilities.isRightMouseButton(e)) { 
//								((JButton) e.getSource()).setText("X"); 
//								} 
//							} 
//						});
					button[i][j].setVisible(true);
					add(button[i][j]);
					question[i][j] = 0;
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 5; j++) {
					lowNumber[i][j] = new JLabel(low[i][j]);
					lowNumber[i][j].setSize(50, 50);
					lowNumber[i][j].setLocation(375 + j * 50, 100 + i * 50);
					if (low[i][j].equals("0") && !(i == 2)) {
						lowNumber[i][j].setVisible(false);
					}
					else {
						lowNumber[i][j].setVisible(true);
					}
					add(lowNumber[i][j]);
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 5; j++) {
					colNumber[i][j] = new JLabel(col[i][j]);
					colNumber[i][j].setSize(50, 50);
					colNumber[i][j].setLocation(225 + i * 50, 250 + j * 50);
					if (col[i][j].equals("0") && !(i == 2)) {
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
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			EasyScene easyscene = new EasyScene();
		}
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (e.getSource() == button[i][j]) {
						if (button[i][j].getBackground() == Color.WHITE) {
							button[i][j].setBackground(Color.BLACK);
							question[i][j] = 1;
						} else {
							button[i][j].setBackground(Color.WHITE);
							question[i][j] = 0;
						}
						// System.out.println("Button [" + i + "][" + j + "] clicked. Value: " + question[i][j]);
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
			for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 5; j++) {
	                if (question[i][j] != answer[j][i]) {
	                	// System.out.println("Mismatch at [" + i + "][" + j + "].");
	                    return false;
	                }
	            }
	        }
	        return true;
		}
}
