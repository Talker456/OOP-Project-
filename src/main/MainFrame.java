package main;

import main.games.GamePanel;
import main.stage.EasyStage;
import main.stage.HardStage;
import main.stage.NormalStage;
import main.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    static ArrayList<Stage> stages = new ArrayList<>();
    static HashMap<String, ArrayList<Record>> records = new HashMap<>();

    static CardLayout cards = new CardLayout();
    static Container cardPanel;


    JPanel infoPanel;
    JPanel resultPanel;
    static GamePanel currentGamePanel;


    static String username;

    public void setupMainPanel() {
        //Temporary username
        username = "user1";

        readAllStages("stage.txt"); // move desired
        readAllRecords("record.txt"); // move desired

        setTitle("Demo");
        cardPanel = new JPanel(cards);

        infoPanel = new JPanel();
        JButton infoButton = new JButton("button");
        infoButton.addActionListener(e->{
            // modified
            StageSelection s = new StageSelection();
            s.init(username);
            cardPanel.add(s, "select");
            showCard("select");

        });
        infoPanel.add(infoButton);

        resultPanel = new JPanel();
        JButton resultButton = new JButton("button");
        resultButton.addActionListener(e->cards.show(cardPanel,"info"));


        cardPanel.add(infoPanel, "info");
        getContentPane().add(cardPanel);

    }

    public static void resetGamePanel() {
        if (currentGamePanel != null) {
            cardPanel.remove(currentGamePanel);
        }
    }

    public static void setCurrentGamePanel(GamePanel gamePanel) {
        currentGamePanel = gamePanel;
    }

    public void readAllStages(String path) {
        Scanner scanner = openFile(path);

        Stage stage = null;
        while (scanner.hasNext()) {
            int diff = scanner.nextInt();
            switch (diff) {
                case 1:
                    stage = new EasyStage();
                    break;
                case 2:
                    stage = new NormalStage();
                    break;
                case 3:
                    stage = new HardStage();
                    break;
            }
            stage.read(scanner);
            stages.add(stage);
        }
    }

    public void readAllRecords(String path) {

        Scanner scanner = openFile(path);
        Record r = null;
        ArrayList<Record> userRecords = null;

        while (scanner.hasNext()) {
            String username = scanner.next();
            if (records.containsKey(username)) {
                userRecords = records.get(username);
                r = new Record();
                r.read(scanner, username);
                userRecords.add(r);
            } else {
                userRecords = new ArrayList<>();
                r = new Record();
                r.read(scanner,username);
                userRecords.add(r);
                records.put(username, userRecords);
            }
        }

        System.out.println("Read all records");
    }

    public static ArrayList<Record> getUserRecord(String username) {
        return records.get(username);
    }

    public Scanner openFile(String path) {
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("not found " + path);
        }
        return s;
    }

    private void createAndShowGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMainPanel();
        setPreferredSize(new Dimension(800, 700));
        pack();
        setVisible(true);
    }

    public static void showCard(String key) {
        cards.show(cardPanel, key);
    }

    public static String getUsername() {
        return username;
    }


    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.createAndShowGUI();
    }
}


