package step_3_3_4;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {

        new MyFrame();
    }

}

class MyFrame extends JFrame {

    public MyFrame() {

        MyPanel panel = new MyPanel();
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Простое перемещение");
        this.add(panel);
        this.pack();
        this.setVisible(true);

    }
}

