package step_3_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JJSpinner {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Спиннер");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//определяем разрешение монитора
        int width=300, height=200;//задаем размер окна
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);//выставляем размеры окна
        JPanel panel = new JPanel ();//создаем панель
        JLabel label = new JLabel("0");//создаем надпись
        label.setAlignmentX(Component.CENTER_ALIGNMENT);//выравниваем ее по центру
        JButton button = new JButton("Ответить");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        JSpinner spinner = new JSpinner();
        spinner.setMaximumSize(new Dimension(100,50));//задаем ему максимальный размер, чтобы не растягивался по всей форме
        button.addActionListener(new ActionListener() {//добавляем слушателя на кнопку
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(String.valueOf(spinner.getValue()));//считываем значение из спиннера
            }
        });
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));//задаем менеджер для выравнивания
        panel.add(Box.createVerticalStrut(20));//между компонентами добавляем пустые промежутки
        panel.add(spinner);//добавляем спиннер
        panel.add(Box.createVerticalStrut(20));
        panel.add(button);//добавляем кнопку
        panel.add(Box.createVerticalStrut(20));
        panel.add(label);//добавляем надпись
        panel.add(Box.createVerticalStrut(20));
        frame.add(panel);//добавляем панель на форму
        frame.pack();//пакуем
        frame.setVisible(true);//делаем форму видимой
    }

}
