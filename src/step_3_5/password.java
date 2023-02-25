package step_3_5;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class password {
    public static void main(String[] args) {
        new FramePas();
    }
}
class FramePas extends JFrame {

    public FramePas() {

        //локализация кнопок
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.cancelButtonText", "Отмена");
        UIManager.put("OptionPane.okButtonText" , "Готово");

        if (JOptionPane.showConfirmDialog(this,
                "Добрый день, хотите зарегестрироваться?",
                "Регистрация)", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            System.exit(1);
        }

        UIManager.put("OptionPane.noButtonText", "закрыть");
        boolean isRight = false;
        String login = null;
        while (isRight == false) {
            try {
                login = JOptionPane.showInputDialog(this, "Введите логин: ");
                if (login.length() < 5 || login.contains(" ")) {
                    continue;
                } else {
                    isRight = true;
                }
            } catch (NullPointerException e) {
                System.exit(1);
            }

        }

        isRight = false;
        String password = null;
        while (isRight == false) {
            try {

                JPasswordField pF = new JPasswordField();
                pF.setEchoChar('*');
                if (JOptionPane.showConfirmDialog(this, pF, "Введите пароль: ", JOptionPane.YES_NO_OPTION) ==
                        JOptionPane.NO_OPTION) {
                    System.exit(1);
                }

                password = pF.getText();

                if ((password.length() <= 8) || password.contains(" ")) {
                    continue;
                } else if (password.length() > 8) {
                    int numC = 0;
                    int strC = 0;
                    for (int i = 0; i <= password.length(); i++) {
                        if (numC >= 1 && strC >= 1) {
                            isRight = true;
                        } else if (Character.isDigit(password.charAt(i))) {
                            numC++;
                        } else if (Character.isLetter(password.charAt(i))) {
                            strC++;
                        }
                    }
                }
            } catch (NullPointerException e) {
                continue;
            } catch (StringIndexOutOfBoundsException e) {
                continue;
            }

        }

        isRight = false;
        while (isRight == false) {
            JPasswordField pF = new JPasswordField();
            pF.setEchoChar('*');
            if (JOptionPane.showConfirmDialog(this, pF, "Повторите пароль: ", JOptionPane.YES_NO_OPTION) ==
                    JOptionPane.NO_OPTION) {
                System.exit(1);
            }

            String newPassword = pF.getText();
            if (newPassword.equals(password)) {
                isRight = true;
            } else {
                continue;
            }

        }

        String[] information = {"Ваше имя: " + login, "Ваш пароль: " + password};
        JOptionPane.showMessageDialog(this, information, "Регистрация)", JOptionPane.INFORMATION_MESSAGE, null);
        System.exit(1);

    }
}
