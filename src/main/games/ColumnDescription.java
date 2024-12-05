package main.games;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ColumnDescription extends JPanel{
    private float fontSize;

    void init(int rows,int cols,String[] img) {
        setLayout(new GridLayout(cols, 1));
        setFontSize(img.length);

        for (int i = 0; i < cols; i++) {
            JPanel row = new JPanel();
            row.setLayout(new GridLayout(1, rows));
            row.setBorder(BorderFactory.createBevelBorder(1));

            String[] split = img[i].split("0");

            for (int j = 0; j < split.length; j++) {
                split[j] = split[j].length()+"";
            }

            ArrayList<String> list = new ArrayList<>(Arrays.stream(split).toList());
            while (list.contains("0")) {
                list.remove("0");
            }
            String[] array = list.reversed().toArray(new String[0]);


            for (int j = rows-1; j >= 0; j--) {
                JPanel tmp = new JPanel();
                tmp.setBorder(BorderFactory.createEmptyBorder());
                tmp.setBackground(Color.white);

                JLabel tmpLabel = new JLabel();
                String string = array.length <= j ? "" : array[j];
                tmpLabel.setText(string);
                tmpLabel.setFont(tmpLabel.getFont().deriveFont(fontSize));
                tmpLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
                tmpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                tmp.add(tmpLabel);
                row.add(tmp);

                this.add(row);
            }
        }
    }

    public void setFontSize(int length) {
        switch (length) {
            case 5:
                fontSize=30.0f;
                break;
            case 10:
                fontSize = 25.0f;
                break;
            case 15:
                fontSize=18.0f;
                break;
            default:
                System.out.println("Wrong image length");
                break;
        }
    }

}
