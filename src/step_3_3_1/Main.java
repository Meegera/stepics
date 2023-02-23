package step_3_3_1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}

class MyFrame extends JFrame{
    public MyFrame() {
        MyPanel panel = new MyPanel();
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Texture");
        this.add(panel);
        this.pack();
        this.setVisible(true);
    }
}

class MyPanel extends JPanel{
    TexturePaint p;

    MyPanel() {

        this.setPreferredSize(new Dimension(800, 600));
        try {
            BufferedImage i = ImageIO.read(new File("grass_texture.png"));
            p = new TexturePaint(i, new Rectangle(50, 50));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(p);
        g2.fillRect(0, 0, 800, 600);
    }
}
