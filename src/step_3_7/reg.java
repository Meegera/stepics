package step_3_7;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class reg extends JFrame{
    private JPanel panel;
    private JTextField textField1; //ФИО
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JSpinner spinner1;
    private JButton button;
    private JRadioButton RB1;
    private JRadioButton RB2;
    private JSlider slider1;
    private JComboBox comboBox1;
    private JCheckBox cb1;
    private JCheckBox cb2;
    private JCheckBox cb3;
    private JList list1;
    private JTextField textField2; //о себе

    public reg(){
        this.getContentPane().add(panel);//добавляем панель на форму
        spinner1.setModel(new SpinnerNumberModel(18,18,100,1));//устанавливаем парамерты спинеру, т.к. в редакторе этого нет

        Color red = new Color(205, 92, 92);//красный

        button.addActionListener(e -> {//слушатель нажатия на кнопку
            boolean error = false;
            if (textField1.getText().length()==0){
                textField1.setBackground(red);
                error=true;
            }else
                textField1.setBackground(Color.white);

            if (!Arrays.equals(passwordField1.getPassword(), passwordField2.getPassword())) {//проверка равности паролей
                passwordField1.setBackground(red);
                passwordField2.setBackground(red);
                error=true;
            }
            else {
                passwordField1.setBackground(Color.white);
                passwordField2.setBackground(Color.white);
            }

            if (!error) {
                int[] selectedIndices = list1.getSelectedIndices();//вытаскиваем все выбранные элементы из листа
                String list="";
                for (int i = 0; i < selectedIndices.length; i++)
                    list+=" "+list1.getModel().getElementAt(selectedIndices[i]);

                new JOptionPane().showMessageDialog(panel,// создаем информационное окно
                        "ФИО - "+textField1.getText()+"\n" +
                                "Пароль - "+new String(passwordField1.getPassword())+"\n" +
                                "Пол - "+(RB1.isSelected()?"Мужской":"Женский")+"\n" +
                                "Возраст - "+spinner1.getValue()+"\n" +
                                "Образование - "+comboBox1.getSelectedItem()+"\n" +
                                "Интересы - "+(cb1.isSelected()?cb1.getText()+"  ":"")+(cb2.isSelected()?cb2.getText()+"  ":"")+(cb3.isSelected()?cb3.getText()+"  ":"")+"\n" +
                                "Знание java - "+slider1.getValue()+"\n" +
                                "Немного о себе - "+textField2.getText()+"\n" +
                                "Что для Вас важно? - "+list+"\n"
                        , "Ваши данные", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);//выходим из программы
            }
        });
    }
}
