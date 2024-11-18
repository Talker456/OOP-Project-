package main;

import main.stage.EasyStage;
import main.stage.HardStage;
import main.stage.NormalStage;
import main.stage.Stage;
import main.start.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class GameControlFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    static ArrayList<Stage> stages;
    static HashMap<String, ArrayList<Record>> records;

    static CardLayout cards = new CardLayout();
    static Container cardPanel;

    static JButton backButton = new JButton("Back");

    static String username;

    public void setupMainPanel(String currentUserName) {
        stages = new ArrayList<>();
        records = new HashMap<>();

        //Temporary username
        username = currentUserName;

        readAllStages("stage.txt"); // move desired
        readAllRecords("record.txt"); // move desired

        setTitle("Nonogram");
        cardPanel = new JPanel(cards);

        backButton.addActionListener(e->{
            MenuFrame m = new MenuFrame(username);
            m.setVisible(true);
            dispose();
        });

        StageSelection s = new StageSelection();
        s.init(username,backButton);
        cardPanel.add(s, "select");
        showCard("select");


        getContentPane().add(cardPanel);

        setPreferredSize(new Dimension(800, 700));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);

    }

    public static HashMap<String,ArrayList<Record>> getRecords() {
        return records;
    }

    public static void writeRecord(String name) {
        String filePath = "record.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))) {
            writer.write(name);
            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
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
                r.altRead(scanner, username);
                userRecords.add(r);
            } else {
                userRecords = new ArrayList<>();
                r = new Record();
                r.altRead(scanner,username);
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
        setupMainPanel(username);
        setPreferredSize(new Dimension(800, 700));
        pack();
        setVisible(true);
    }

    public static void showCard(String key) {
        cards.show(cardPanel, key);
    }

    public static void updateAndShow() {
        StageSelection s = new StageSelection();
        s.init(username,backButton);
        cardPanel.add(s, "select");
        showCard("select");
    }

    //GameControlFrame.getRecords().get(name).add(record);
    public static void addRecord(Record record) {
        if (records.get(username) == null) {
            ArrayList<Record> list = new ArrayList<>();
            list.add(record);
            records.put(username, list);
        }else{
            records.get(username).add(record);
        }
    }



    public static String getUsername() {
        return username;
    }


    public static void main(String[] args) {
        GameControlFrame frame = new GameControlFrame();
        frame.createAndShowGUI();
    }
}


