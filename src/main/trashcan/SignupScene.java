package main.trashcan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SignupScene extends JFrame implements ActionListener {
	Container pane = getContentPane();
	JButton undoButton, loginButton;
	
	public SignupScene() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Nonograms");
		pane.setLayout(null);
		setPreferredSize(new Dimension(800, 600));
		pane.setBackground(new Color(202, 238, 251));
		
		undoButton = new JButton("Undo");
		undoButton.setSize(100, 50);
		undoButton.setLocation(0, 0);
		undoButton.setBackground(new Color(255, 255, 255));
		undoButton.addActionListener(this);
		undoButton.setVisible(true);
		pane.add(undoButton);
		
		JLabel nickname = new JLabel("닉네임 : ");
		nickname.setSize(150, 50);
		nickname.setFont(new Font("고딕", Font.PLAIN, 30));
		nickname.setLocation(0, 200);
		nickname.setVisible(true);
		pane.add(nickname);
		
		JTextField nicknameField = new JTextField(15);
		nicknameField.setSize(150, 50);
		nicknameField.setFont(new Font("고딕", Font.PLAIN, 20)); 
		nicknameField.setLocation(150, 200);
		nicknameField.setVisible(true);
		pane.add(nicknameField);
		
		JLabel password = new JLabel("비밀번호:");
		password.setSize(150, 50);
		password.setFont(new Font("고딕", Font.PLAIN, 30));
		password.setLocation(0, 300);
		password.setVisible(true);
		pane.add(password);
		
		JPasswordField passwordField = new JPasswordField(20);
		passwordField.setSize(150, 50);
		passwordField.setLocation(150, 300);
		passwordField.setVisible(true);
		pane.add(passwordField);
		
		loginButton = new JButton("Log In");
		loginButton.setSize(100, 50);
		loginButton.setLocation(350, 300);
		loginButton.addActionListener(this);
		loginButton.setVisible(true);
		pane.add(loginButton);
		
		loginButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				String loginNickname = nicknameField.getText();
				String loginPassword = new String(passwordField.getPassword());
				if (validateLogin(loginNickname, loginPassword)) { 
					JOptionPane.showMessageDialog(pane, "로그인 성공!"); 
				} 
				else { 
					JOptionPane.showMessageDialog(pane, "로그인 실패! 이메일 또는 비밀번호를 확인하세요."); 
				}
			}
		});
		
		setResizable(false);
		pack();
		setVisible(true);
	}

	private static boolean validateLogin(String loginNickname, String loginPassword) {
		// TODO Auto-generated method stub
		try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) { 
				if (line.startsWith("닉네임 : ")) {
					String registeredNickname = line.substring(line.indexOf("닉네임 : ") + 6);
					String registeredPassword = reader.readLine().substring("비밀번호 : ".length()); 
					reader.readLine();
					if (loginNickname.equals(registeredNickname) && loginPassword.equals(registeredPassword)) { 
						return true; 
					} 
				}
			} 
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SignupScene signupscene = new SignupScene();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == undoButton) {
			MainScene mainscene = new MainScene();
			mainscene.setVisible(true);
			dispose();
		}
	}

}
