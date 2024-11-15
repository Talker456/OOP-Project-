package test.mptest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HardScene extends JFrame implements ActionListener {
	Container pane = getContentPane();
	JButton[][] button = new JButton[15][15];
	JLabel[][] lowNumber = new JLabel[8][15]; 
	JLabel[][] colNumber = new JLabel[8][15];
	String[][] low = { { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
			           { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
			           { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
			           { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
	                   { "0", "0", "0", "1", "1", "0", "0", "0", "1", "2", "0", "0", "0", "0", "0" }, 
	                   { "0", "0", "0", "2", "2", "2", "0", "1", "1", "1", "5", "5", "0", "0", "0" }, 
	                   { "0", "3", "3", "3", "2", "2", "2", "2", "1", "1", "2", "3", "7", "6", "6" }, 
	                   { "13", "9", "9", "1", "1", "1", "3", "1", "1", "1", "3", "2", "2", "3", "6" } };
	String[][] col = { { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
	                   { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
	                   { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
	                   { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" }, 
                       { "0", "0", "0", "0", "0", "0", "0", "3", "3", "0", "0", "0", "0", "0", "0" }, 
                       { "0", "0", "3", "1", "0", "0", "0", "1", "2", "3", "0", "0", "0", "0", "0" }, 
                       { "5", "3", "2", "2", "3", "4", "4", "1", "2", "4", "4", "6", "0", "1", "4" }, 
                       { "8", "6", "5", "5", "5", "3", "2", "1", "1", "1", "2", "4", "15", "1", "3" } };
	int[][] question = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			             { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	int[][] answer = { { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, 
                       { 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 }, 
                       { 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, 
                       { 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, 
                       { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, 
                       { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 }, 
                       { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
                       { 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1 }, 
                       { 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1 }, 
                       { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1 }, 
                       { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 }, 
                       { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1 }, 
                       { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
                       { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0 }, 
                       { 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0 } };
	
	public HardScene() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nonograms");
		pane.setLayout(null);
		setPreferredSize(new Dimension(1200, 1000));
		pane.setBackground(Color.LIGHT_GRAY);
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				button[i][j] = new JButton();
				button[i][j].setSize(40, 40);
				button[i][j].setLocation(400 + i * 40, 320 + j * 40);
				button[i][j].setBackground(Color.WHITE);
				button[i][j].addActionListener(this);
				button[i][j].setVisible(true);
				add(button[i][j]);
				question[i][j] = 0;
			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 15; j++) {
				lowNumber[i][j] = new JLabel(low[i][j]);
				lowNumber[i][j].setSize(40, 40);
				lowNumber[i][j].setLocation(420 + j * 40, 0 + i * 40);
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
				colNumber[i][j].setLocation(100 + i * 40, 320 + j * 40);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HardScene hardscene = new HardScene();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (e.getSource() == button[i][j]) {
					if (button[i][j].getBackground() == Color.WHITE) {
						button[i][j].setBackground(Color.BLACK);
						question[i][j] = 1;
					} else {
						button[i][j].setBackground(Color.WHITE);
						question[i][j] = 0;
					}
					// System.out.println("Button [" + i + "][" + j + "] clicked. Value: " +
					// question[i][j]);
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
					// System.out.println("Mismatch at [" + i + "][" + j + "].");
					return false;
				}
			}
		}
		return true;
	}
}
