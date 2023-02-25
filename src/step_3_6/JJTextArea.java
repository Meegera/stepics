package step_3_6;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class JJTextArea {
    public static void main(String[] args) {
        Framee frame = new Framee();
    }
}

class Framee extends JFrame {

    public Framee() {

        Panell panel = new Panell();
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setVisible(true);

    }
}

class Panell extends JPanel {

    Panell() {

        this.setPreferredSize(new Dimension(600, 500));
        this.setFocusable(true);

        JTextField tF = new JTextField();
        tF.setPreferredSize(new Dimension(500, 40));

        JButton b = new JButton("Записать");
        b.setPreferredSize(new Dimension(100, 30));
        b.setFocusable(false);

        JTextArea area = new JTextArea(20,50);
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setEnabled(true);

        b.addActionListener((e) -> area.setText(area.getText() + "\n" + tF.getText()));

        this.add(tF);
        this.add(b);
        this.add(scroll);


    }
}