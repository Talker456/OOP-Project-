package test.mptest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LevelScene extends JFrame implements ActionListener {
	Container pane = getContentPane();
	JButton undoButton, level1Button, level2Button, level3Button, level4Button, level5Button, level6Button, level7Button, level8Button, level9Button, level10Button, level11Button, level12Button;

	public LevelScene() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nonograms");
		pane.setLayout(null);
		setPreferredSize(new Dimension(900, 700));
		pane.setBackground(new Color(202, 238, 251));

		undoButton = new JButton("Undo");
		undoButton.setSize(100, 50);
		undoButton.setLocation(0, 0);
		undoButton.setBackground(new Color(255, 255, 255));
		undoButton.addActionListener(this);
		undoButton.setVisible(true);
		pane.add(undoButton);
		
		level1Button = new JButton("Level 1");
		level1Button.setSize(100, 50);
		level1Button.setLocation(100, 100);
		level1Button.setBackground(new Color(180, 229, 162));
		level1Button.addActionListener(this);
		level1Button.setVisible(true);
		pane.add(level1Button);

		level2Button = new JButton("Level 2");
		level2Button.setSize(100, 50);
		level2Button.setLocation(300, 100);
		level2Button.setBackground(new Color(180, 229, 162));
		level2Button.addActionListener(this);
		level2Button.setVisible(true);
		pane.add(level2Button);

		level3Button = new JButton("Level 3");
		level3Button.setSize(100, 50);
		level3Button.setLocation(500, 100);
		level3Button.setBackground(new Color(180, 229, 162));
		level3Button.addActionListener(this);
		level3Button.setVisible(true);
		pane.add(level3Button);

		level4Button = new JButton("Level 4");
		level4Button.setSize(100, 50);
		level4Button.setLocation(700, 100);
		level4Button.setBackground(new Color(180, 229, 162));
		level4Button.addActionListener(this);
		level4Button.setVisible(true);
		pane.add(level4Button);

		level5Button = new JButton("Level 5");
		level5Button.setSize(100, 50);
		level5Button.setLocation(100, 300);
		level5Button.setBackground(new Color(255, 255, 153));
		level5Button.addActionListener(this);
		level5Button.setVisible(true);
		pane.add(level5Button);

		level6Button = new JButton("Level 6");
		level6Button.setSize(100, 50);
		level6Button.setLocation(300, 300);
		level6Button.setBackground(new Color(255, 255, 153));
		level6Button.addActionListener(this);
		level6Button.setVisible(true);
		pane.add(level6Button);

		level7Button = new JButton("Level 7");
		level7Button.setSize(100, 50);
		level7Button.setLocation(500, 300);
		level7Button.setBackground(new Color(255, 255, 153));
		level7Button.addActionListener(this);
		level7Button.setVisible(true);
		pane.add(level7Button);

		level8Button = new JButton("Level 8");
		level8Button.setSize(100, 50);
		level8Button.setLocation(700, 300);
		level8Button.setBackground(new Color(255, 255, 153));
		level8Button.addActionListener(this);
		level8Button.setVisible(true);
		pane.add(level8Button);

		level9Button = new JButton("Level 9");
		level9Button.setSize(100, 50);
		level9Button.setLocation(100, 500);
		level9Button.setBackground(new Color(242, 170, 132));
		level9Button.addActionListener(this);
		level9Button.setVisible(true);
		pane.add(level9Button);

		level10Button = new JButton("Level 10");
		level10Button.setSize(100, 50);
		level10Button.setLocation(300, 500);
		level10Button.setBackground(new Color(242, 170, 132));
		level10Button.addActionListener(this);
		level10Button.setVisible(true);
		pane.add(level10Button);

		level11Button = new JButton("Level 11");
		level11Button.setSize(100, 50);
		level11Button.setLocation(500, 500);
		level11Button.setBackground(new Color(242, 170, 132));
		level11Button.addActionListener(this);
		level11Button.setVisible(true);
		pane.add(level11Button);

		level12Button = new JButton("Level 12");
		level12Button.setSize(100, 50);
		level12Button.setLocation(700, 500);
		level12Button.setBackground(new Color(242, 170, 132));
		level12Button.addActionListener(this);
		level12Button.setVisible(true);
		pane.add(level12Button);

		setResizable(false);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelScene levelscene = new LevelScene();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == undoButton) {
			MainScene mainscene = new MainScene();
			mainscene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level1Button) {
			Level1Scene level1scene = new Level1Scene();
			level1scene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level2Button) {
			Level2Scene level2scene = new Level2Scene();
			level2scene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level3Button) {
			Level3Scene level3scene = new Level3Scene();
			level3scene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level4Button) {
			Level4Scene level4scene = new Level4Scene();
			level4scene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level5Button) {
			Level5Scene level5scene = new Level5Scene();
			level5scene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level6Button) {
			Level6Scene level6scene = new Level6Scene();
			level6scene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level7Button) {
			Level7Scene level7scene = new Level7Scene();
			level7scene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level8Button) {
			Level8Scene level8scene = new Level8Scene();
			level8scene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level9Button) {
			Level9Scene level9scene = new Level9Scene();
			level9scene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level10Button) {
			Level10Scene level10scene = new Level10Scene();
			level10scene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level11Button) {
			Level11Scene level11scene = new Level11Scene();
			level11scene.setVisible(true);
			dispose();
		}
		if (e.getSource() == level12Button) {
			Level12Scene level12scene = new Level12Scene();
			level12scene.setVisible(true);
			dispose();
		}
	}

}
