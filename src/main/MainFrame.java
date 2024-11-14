package main;

import main.stage.EasyStage;
import main.stage.HardStage;
import main.stage.NormalStage;
import main.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    ArrayList<Stage> stages = new ArrayList<>();

    static CardLayout cards = new CardLayout();
    static Container cardPanel;
    JPanel infoPanel;
    JPanel resultPanel;

    public void readAllStages(String path) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("not found " + path);
        }

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

    public void setupMainPanel() {
        readAllStages("stage.txt");

        setTitle("Demo");
        Container pane = getContentPane();
        cardPanel = new JPanel(cards);

        Random r = new Random();
        infoPanel = new JPanel();
        JButton infoButton = new JButton("button");
        infoButton.addActionListener(e->{
            GamePanel gp = new GamePanel();
            gp.init(stages.get(r.nextInt(stages.size())));
            cardPanel.add(gp, "game");
            cards.show(cardPanel, "game");
        });
        infoPanel.add(infoButton);

        resultPanel = new JPanel();
        JButton resultButton = new JButton("button");
        resultButton.addActionListener(e->cards.show(cardPanel,"info"));


        cardPanel.add(infoPanel, "info");
        getContentPane().add(cardPanel);
    }

    private void createAndShowGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMainPanel();
        setPreferredSize(new Dimension(800, 700));
        pack();
        setVisible(true);
    }

    public static void showMain() {
        cards.show(cardPanel, "info");
    }


    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.createAndShowGUI();
    }
}


