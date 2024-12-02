package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragPaintButtonsExample extends JFrame {
    private static final int GRID_SIZE = 10; // Size of the grid (10x10)
    private static final int CELL_SIZE = 50; // Size of each button
    private JButton[][] buttons = new JButton[GRID_SIZE][GRID_SIZE];

    public DragPaintButtonsExample() {
        setTitle("Drag to Paint Buttons Example");
        setSize(GRID_SIZE * CELL_SIZE, GRID_SIZE * CELL_SIZE);
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                JButton button = new JButton();
                button.setBackground(Color.WHITE);
                button.setOpaque(true);
                button.setBorderPainted(false);
                buttons[i][j] = button;
                panel.add(button);
            }
        }

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleMouseEvent(e);
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                handleMouseEvent(e);
            }
        });

        add(panel);
    }

    private void handleMouseEvent(MouseEvent e) {
        Component component = e.getComponent().getComponentAt(e.getPoint());
        if (component instanceof JButton) {
            JButton button = (JButton) component;
            button.setBackground(Color.RED);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
    }

}

class Main {

    private static final MouseAdapter adapter = new MouseAdapter() {

        boolean mouseDown = false;

        @Override
        public void mouseEntered(MouseEvent e) {
            if(mouseDown)
                ((JButton) e.getSource()).doClick();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            ((JButton) e.getSource()).doClick(); // Click the initial button
            mouseDown = true;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDown = false;
        }
    };

    public static void main(String[] args) {

        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");

        b1.addMouseListener(adapter);
        b2.addMouseListener(adapter);
        b3.addMouseListener(adapter);

        b1.addActionListener(e -> System.out.println(((JButton) e.getSource()).getText()));
        b2.addActionListener(e -> System.out.println(((JButton) e.getSource()).getText()));
        b3.addActionListener(e -> System.out.println(((JButton) e.getSource()).getText()));

        JFrame jf = new JFrame();

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.add(b1);
        jf.add(b2);
        jf.add(b3);

        jf.setLayout(new GridLayout(0, 3));
        jf.pack();
        jf.setVisible(true);
    }
}
