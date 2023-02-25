package step_3_6;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Fontt {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Изменение размера надписи");

        JLabel label = new JLabel("Моя первая надпись!");
        label.setFont(new Font("Calibri", Font.ITALIC, 50));

        JSlider slider = new JSlider(5, 100, 50);
        slider.setPreferredSize(new Dimension(950, 50));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(15);
        slider.setPaintLabels(true);
        slider.setFont(new Font("Calibri", Font.ITALIC, 20));
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {

                label.setFont(new Font("Calibri", Font.ITALIC, slider.getValue()));

            }
        });

        panel.add(Box.createRigidArea(new Dimension(1000, 200)));
        panel.add(label);
        panel.add(slider);

        frame.add(panel);
        frame.setVisible(true);

        panel.setPreferredSize(new Dimension(800, 600));
        panel.setFocusable(true);
    }
}
