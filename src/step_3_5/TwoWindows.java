package step_3_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TwoWindows {
    public static void main(String[] args) {
        new Frame();
    }
}

class Frame extends JFrame {
    public Frame() {
        Panel panel = new Panel();
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Two Windows");
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}

class Panel extends JPanel {
    Panel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    JOptionPane.showMessageDialog(getComponentPopupMenu(),
                            "Your name is " + JOptionPane.showInputDialog(
                                    getComponentPopupMenu(),
                                    "Enter your name: "),
                            "2 Windows",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
