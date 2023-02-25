package step_3_7;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        reg mainWindow = new reg();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationByPlatform(true);//устанавливаем местоположение
        mainWindow.setTitle("Регистрация");
        mainWindow.pack();//упаковываем все на форме
        mainWindow.setVisible(true);// Отображаем созданное окно
    }
}