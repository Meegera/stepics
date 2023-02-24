package step_3_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConfirmWindow{
        public static void main(String[] args) {
            new Framee();
        }
    }
    class Framee extends JFrame {
        public Framee() {
            Panell panel = new Panell();
            this.setSize(800, 600);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Confirm Window");
            this.add(panel);
            this.pack();
            this.setVisible(true);
        }
    }

    class Panell extends JPanel {
        Panell() {
            this.setPreferredSize(new Dimension(800, 600));
            this.setFocusable(true);
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == 32) {
                        // 0 - yes
                        // 1 - no
                        int firstQ = JOptionPane.showConfirmDialog(getComponentPopupMenu(),
                                "Тебе нравится изучать java?",
                                "Confirm Window",
                                JOptionPane.YES_NO_OPTION);

                        int secondQ = JOptionPane.showConfirmDialog(getComponentPopupMenu(),
                                "Сегодня солнечно?",
                                "Confirm Window",
                                JOptionPane.YES_NO_OPTION);

                        JOptionPane.showMessageDialog(getComponentPopupMenu(),
                                ((firstQ == 0 && secondQ == 0) ? "Тебе нравится джава и сегодня солнечно))))" :
                                        (firstQ == 1 && secondQ == 0) ? "Тебе не нравится изучать, зато сегодня солнечно" :
                                                (firstQ == 0 && secondQ == 1) ? "Тебе нравится изучать, но сегодня не солнечно" :
                                                        "Тебе не нравится и не солнечно("),
                                "Confirm Window",
                                JOptionPane.INFORMATION_MESSAGE);

                    }

                }

            });
        }
    }
