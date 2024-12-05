package main.games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

@SuppressWarnings("serial")
public class TimerComponent extends JLabel {


    static LocalTime localTime;
    static Timer t;

    TimerComponent() {
        super("", SwingConstants.CENTER);
        t=null;
        localTime = LocalTime.of(0, 0, 0);
        setFont(new Font("Sans Serif", Font.PLAIN, 24));


            t = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setText(getTimeString());
                }
            });
            t.start();
    }

    public  void clearClock() {
        t.stop();
        localTime = LocalTime.of(0, 0, 0);
    }

    static String getTimeString() {
        localTime = localTime.plusSeconds(1);
        System.out.println(localTime.toString());
        return localTime.toString();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 50);
    }

    public void pause() {
        t.stop();
    }

    public void resume() {
        t.restart();
    }
}