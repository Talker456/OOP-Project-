package test;

import test.start.StartFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainController extends JFrame {

    static StageManager stageManager = new StageManager();
    static RecordManager recordManager = new RecordManager();

    static String currentUser;

    private CardLayout cardLayout;

    public static void setUsername(String username) {
        currentUser = username;
    }

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void print() {
        System.out.println("currentUser = " + currentUser);
    }

    public static void writeRecord(String string) {
        try (FileWriter writer = new FileWriter("record.txt", true)) {
            writer.write(string + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void setMainFrame() {
        setTitle("NONOGRAMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1200,1050));
        Container c = getContentPane();

        cardLayout = new CardLayout();

        setLayout(new BorderLayout());
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1, 5));
        setMenuPanel(menuPanel);

        c.add(menuPanel, BorderLayout.SOUTH);
    }

    private void setMenuPanel(JPanel menuPanel) {
        JButton loginButton = new JButton("LOGIN");
        menuPanel.add(loginButton);
        Decorator.setButtonStyle(loginButton);

        JButton rankingButton = new JButton("RANKING");
        Decorator.setButtonStyle(rankingButton);
        menuPanel.add(rankingButton);

        JButton profileButton = new JButton("My Page");
        Decorator.setButtonStyle(profileButton);
        menuPanel.add(profileButton);

        JButton TEMP = new JButton("TEMP");
        Decorator.setButtonStyle(TEMP);
        menuPanel.add(TEMP);

        JButton timer = new JButton("timer");
        Decorator.setButtonStyle(timer);
        menuPanel.add(timer);

    }


    void start() {
        stageManager.readAllStages(openFile("stage.txt"));
        recordManager.readAllRecord(openFile("record.txt"));

        new StartFrame(); // 시작
    }



    public static RecordManager getRecordManager() {
        return recordManager;
    }

    public static StageManager getStageManager() {
        return stageManager;
    }

    public Scanner openFile(String path) {
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }
        return s;
    }

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.start();
    }
}
