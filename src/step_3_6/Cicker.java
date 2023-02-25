package step_3_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Cicker {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());//задаем менеджер расположения объектов, чтобы потом добавит 2 панели
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Кликер");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//определяем разрешение монитора
        int width=300, height=200;//задаем размер окна
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);//выставляем размеры окна
        JPanel panel = new JPanel (), panel2 = new JPanel ();
        JLabel label = new JLabel("0", SwingConstants.CENTER);//создаем надпись
        JButton button = new JButton("Нажми меня");
        button.addActionListener(new ActionListener() {//добавляем слушателя на кнопку
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(String.valueOf(Integer.parseInt(label.getText())+1));//прибавляем + 1 к надписи на кнопке
            }
        });
        frame.add(panel);
        panel.setLayout(new BorderLayout());//устанавливаем разметку для панели, чтобы надпись поместилась в центр
        panel.add(label,BorderLayout.CENTER);//добавляем надпись (по центру)
        panel.add(button,BorderLayout.SOUTH);//добавляем кнопку (вниз)
        frame.setVisible(true);//делаем форму видимой
    }
}
