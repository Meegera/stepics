package step_3_7;

import javax.swing.*;
import java.awt.*;

public class TextMain {
    public static void main(String[] args) {
        TextEd mainWindow = new TextEd();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//определяем разрешение монитора
        int width=1000, height=500;//задаем размер окна
        mainWindow.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);//выставляем размеры окна
        mainWindow.setTitle("Редактор текста");
        mainWindow.setVisible(true);
    }
}
