package test.mptest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NormalScene extends JFrame implements ActionListener {
	Container pane = getContentPane();
	JButton[][] button = new JButton[10][10];
	JLabel[][] lowNumber = new JLabel[5][10]; 
	JLabel[][] colNumber = new JLabel[5][10];
	String[][] low = { { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
			           { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
			           { "0", "0", "0", "0", "2", "1", "0", "0", "0", "0" }, 
			           { "0", "0", "0", "3", "1", "3", "1", "1", "3", "1" },
			           { "6", "8", "9", "4", "3", "3", "3", "3", "3", "3" } };
	String[][] col = { { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
	                   { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
	                   { "0", "0", "0", "0", "0", "3", "0", "0", "0", "0" }, 
	                   { "3", "4", "4", "3", "3", "1", "4", "0", "0", "0" },
	                   { "1", "3", "1", "1", "3", "1", "2", "10", "8", "6" } };
	int[][] question = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	int[][] answer = { { 0, 0, 0, 1, 1, 1, 0, 0, 1, 0 }, 
                       { 0, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                       { 1, 1, 1, 1, 0, 0, 0, 0, 1, 0 },
                       { 1, 1, 1, 0, 0, 1, 0, 0, 0, 0 },
                       { 1, 1, 1, 0, 1, 1, 1, 0, 0, 0 },
                       { 1, 1, 1, 0, 0, 1, 0, 0, 0, 1 },
                       { 1, 1, 1, 1, 0, 0, 0, 0, 1, 1 },
                       { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                       { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                       { 0, 0, 1, 1, 1, 1, 1, 1, 0, 0 } };
	
	public NormalScene() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nonograms");
		pane.setLayout(null);
		setPreferredSize(new Dimension(1000, 700));
		pane.setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				button[i][j] = new JButton();
				button[i][j].setSize(40, 40);
				button[i][j].setLocation(400 + i * 40, 200 + j * 40);
				button[i][j].setBackground(Color.WHITE);
				button[i][j].addActionListener(this);
				button[i][j].setVisible(true);
				add(button[i][j]);
				question[i][j] = 0;
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				lowNumber[i][j] = new JLabel(low[i][j]);
				lowNumber[i][j].setSize(40, 40);
				lowNumber[i][j].setLocation(420 + j * 40, 0 + i * 40);
				if (low[i][j].equals("0") && !(i == 4)) {
					lowNumber[i][j].setVisible(false);
				}
				else {
					lowNumber[i][j].setVisible(true);
				}
				add(lowNumber[i][j]);
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				colNumber[i][j] = new JLabel(col[i][j]);
				colNumber[i][j].setSize(40, 40);
				colNumber[i][j].setLocation(220 + i * 40, 200 + j * 40);
				if (col[i][j].equals("0") && !(i == 4)) {
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
		NormalScene normalscene = new NormalScene();
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
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
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (question[i][j] != answer[j][i]) {
                	// System.out.println("Mismatch at [" + i + "][" + j + "].");
                    return false;
                }
            }
        }
        return true;
	}

}
