package main;

import main.start_menu.LoginPanel;
import main.RecordManager;
import main.StageManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainFrame extends JFrame {
    private static MainFrame instance;

    static StageManager stageManager = new StageManager();
    static RecordManager recordManager = new RecordManager();

    static String currentUser;

    private static CardLayout cardLayout;
    private static JPanel cardPanel;

    JPanel loginPanel;

    public static void setUsername(String username) {
        currentUser = username;
    }

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void writeRecord(String string) {
        try (FileWriter writer = new FileWriter("record.txt", true)) {
            writer.write(string + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private MainFrame() {
        setTitle("NONOGRAMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void setMainFrame() {
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        stageManager.readAllStages(openFile("stage.txt"));
        recordManager.readAllRecord(openFile("record.txt"));

        loginPanel = new LoginPanel();

        cardPanel.add(loginPanel, "login");

        add(cardPanel, BorderLayout.CENTER);

        setSize(1000,850);
        setVisible(true);
    }

    public static RecordManager getRecordManager() {
        return recordManager;
    }

    public static StageManager getStageManager() {
        return stageManager;
    }

    public static CardLayout getCardLayout() {
        return cardLayout;
    }

    public static JPanel getCardPanel() {
        return cardPanel;
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

    public static void showPanel(JPanel panel, String constraint) {
        cardPanel.add(panel, constraint);
        cardLayout.show(cardPanel,constraint);
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }


    public static void main(String[] args) {
        MainFrame main = MainFrame.getInstance();
        main.setMainFrame();
    }
}
