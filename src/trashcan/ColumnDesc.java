package trashcan;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ColumnDesc extends JPanel{

//    void init(int rows,int cols,String[] img) {
//        setLayout(new GridLayout(cols, rows));
//
//
//        for (int i = 0; i < cols; i++) {
//            String[] split = img[i].split(" ");
//
//            for (int j = 0; j < split.length; j++) {
//                split[j] = split[j].length()+"";
//            }
//
//            System.out.println(Arrays.toString(split));
//            for (int j = rows-1; j >= 0; j--) {
//                JPanel tmp = new JPanel();
//                tmp.setBorder(BorderFactory.createEmptyBorder());
//                tmp.setBackground(Color.white);
//
//                JLabel tmpLabel = new JLabel();
//                tmpLabel.setText(split.length<=j?"":split[j]);
//                tmp.add(tmpLabel);
//                this.add(tmp);
//            }
//        }
//    }
    void init(int rows,int cols,String[] img) {
        setLayout(new GridLayout(cols, 1));

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
                tmpLabel.setText("<html><p style='line-height:200%'>"+string+"</p></html>");
                tmpLabel.setFont(tmpLabel.getFont().deriveFont(10.0f));

                tmp.add(tmpLabel);
                row.add(tmp);

                this.add(row);
            }
        }
    }


}
