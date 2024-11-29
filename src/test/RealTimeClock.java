package test;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RealTimeClock {
    private JButton timeLabel;

    public RealTimeClock(JButton button1) {
        this.timeLabel = button1;
    }

    public void startClock() {
        // Timer로 1초마다 시간을 업데이트
        Timer timer = new Timer(1000, e -> {
            // 현재 시간 구하기
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(new Date());
            timeLabel.setText(currentTime);  // JLabel에 시간 업데이트
        });

        timer.start();  // 타이머 시작
    }
}

