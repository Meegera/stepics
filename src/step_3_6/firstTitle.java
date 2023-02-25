package step_3_6;

import javax.swing.*;
import java.awt.*;

public class firstTitle extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("First title");
        frame.setVisible(true);

        JLabel label = new JLabel("Моя первая надпись!");
        label.setFont(new Font("Calibri", Font.ITALIC, 50));
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label);
    }
}
