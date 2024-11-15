package test.mptest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClearScene extends JFrame implements ActionListener {
	Container pane = getContentPane();
	JButton levelButton, quitButton;

	public ClearScene() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nonograms");
		pane.setLayout(null);
		setPreferredSize(new Dimension(900, 700));
		pane.setBackground(new Color(202, 238, 251));

		JLabel success = new JLabel("SUCCESS!");
		success.setSize(350, 150);
		success.setFont(new Font("고딕", Font.PLAIN, 30));
		success.setLocation(350, 100);
		success.setVisible(true);
		add(success);

		levelButton = new JButton("Again");
		levelButton.setSize(100, 50);
		levelButton.setLocation(200, 400);
		levelButton.addActionListener(this);
		levelButton.setVisible(true);
		pane.add(levelButton);

		quitButton = new JButton("Quit");
		quitButton.setSize(100, 50);
		quitButton.setLocation(550, 400);
		quitButton.addActionListener(this);
		quitButton.setVisible(true);
		pane.add(quitButton);

		setResizable(false);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClearScene clearscene = new ClearScene();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == levelButton) {
			LevelScene levelscene = new LevelScene();
			levelscene.setVisible(true);
			dispose();
		}
		if (e.getSource() == quitButton) {
			System.exit(0);
		}
	}
}
