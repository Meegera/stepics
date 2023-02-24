package step_3_3_4;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    private Image image;
    private int x = 0;
    private int y = 0;

    MyPanel() {

        this.setPreferredSize(new Dimension(800, 600));
        this.setFocusable(true);

        try {
            image = ImageIO.read(new File("luntic.jpg"));
            image = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);//Создает масштабированную версию этого изображения
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e.getKeyCode());
                switch(e.getKeyCode()) {
                    case (40):
                        if (y + 50 < 600)
                            y = y + 50;
                        repaint();
                        break;
                    case (38):
                        if (y - 50 >= 0)
                            y = y - 50;
                        repaint();
                        break;
                    case (39):
                        if (x + 50 < 800)
                            x = x + 50;
                        repaint();
                        break;
                    case (37):
                        if (x - 50 >= 0)
                            x = x - 50;
                        repaint();
                        break;
                }
            }
        });
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.white);
        g2.fillRect(0, 0, 800, 600);
        g2.drawImage(image, x, y, this);
    }
}