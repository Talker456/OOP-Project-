package main.scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SigninScene extends JFrame implements ActionListener {
	Container pane = getContentPane();
	JButton undoButton, registerButton;
	
	public SigninScene()
	{
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
		
		JLabel password = new JLabel("비밀번호 :");
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
		
		registerButton = new JButton("Register");
		registerButton.setSize(100, 50);
		registerButton.setLocation(350, 300);
		registerButton.addActionListener(this);
		registerButton.setVisible(true);
		pane.add(registerButton);
		
		registerButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				String nickname = nicknameField.getText();
				String password = new String(passwordField.getPassword());
				if (isNicknameAvailable(nickname)) {
					saveToFile(nickname, password);
					JOptionPane.showMessageDialog(pane, "회원가입 성공!");
				}
				else {
					JOptionPane.showMessageDialog(pane, "중복된 닉네임입니다. 다른 닉네임을 입력하세요.");
				}
				
			}
		});
		
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	private static boolean isNicknameAvailable(String nickname) {
		// TODO Auto-generated method stub
		try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) { 
				if (line.startsWith("닉네임 : ")) { 
					String storedNickname = line.substring(line.indexOf("닉네임 : ") + 6); 
					if (nickname.equals(storedNickname)) { 
						return false; 
						} 
					} 
				} 
			} catch (IOException e) { 
				e.printStackTrace(); 
				} 
		return true;
	}

	private static void saveToFile(String nickname, String password) {
		// TODO Auto-generated method stub
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_data.txt", true))) {
			writer.write("닉네임 : " + nickname);
			writer.newLine();
			writer.write("비밀번호 : " + password);
			writer.newLine();
			writer.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SigninScene signinscene = new SigninScene();
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
