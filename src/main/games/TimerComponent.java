package main.games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

@SuppressWarnings("serial")
public class TimerComponent extends JLabel {


    static LocalTime localTime;
    Timer t;

    TimerComponent() {
        super("", SwingConstants.CENTER);
        localTime = LocalTime.of(0, 0, 0);
        t = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setText(getTimeString());
            }
        });
        setFont(new Font("Sans Serif", Font.PLAIN, 24));
        t.start();
    }

    public  void clearClock() {
        localTime = LocalTime.of(0, 0, 0);
    }

    static String getTimeString() {
        localTime = localTime.plusSeconds(1);
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
        t.start();
    }
}