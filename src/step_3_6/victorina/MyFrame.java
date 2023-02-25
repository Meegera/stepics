package step_3_6.victorina;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MyFrame extends JFrame {

    private Font font;
    private Map<String, Map<String, Boolean>> questions;
    private QuizButton[] quizButtons = new QuizButton[4];
    private JLabel counter;
    private JLabel question;
    private boolean isReady = false;
    private boolean isStillPlaying = true;
    private static int score = 0;
    private int questionNumber = 1;

    public MyFrame() {

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Quiz");
        this.setLayout(new FlowLayout());

        font = new Font("Times New Roman", Font.PLAIN, 25);

        //Счетчик вопросов
        JPanel counterPanel = new JPanel();
        counterPanel.setPreferredSize(new Dimension(750, 40));
        counterPanel.setLayout(new BorderLayout());

        counter = new JLabel("Вопрос " + questionNumber + "/4");
        counter.setFont(font);
        counterPanel.add(counter, BorderLayout.EAST);

        //Панель вопросов
        JPanel questionPanel = new JPanel();
        questionPanel.setPreferredSize(new Dimension(650, 120));
        questionPanel.setBorder(new LineBorder(Color.black, 5, true));
        questionPanel.setBackground(Color.white);

        question = new JLabel();
        question.setFont(font);

        questionPanel.add(question);

        //Панель ответов
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(2, 2, 20, 20));
        answerPanel.setPreferredSize(new Dimension(650, 200));

        quizButtons[0] = new QuizButton();
        setSettingB(quizButtons[0]);
        quizButtons[1] = new QuizButton();
        setSettingB(quizButtons[1]);
        quizButtons[2] = new QuizButton();
        setSettingB(quizButtons[2]);
        quizButtons[3] = new QuizButton();
        setSettingB(quizButtons[3]);

        answerPanel.add(quizButtons[0]);
        answerPanel.add(quizButtons[1]);
        answerPanel.add(quizButtons[2]);
        answerPanel.add(quizButtons[3]);

        this.add(Box.createRigidArea(new Dimension(800, 30)));
        this.add(counterPanel);
        this.add(Box.createRigidArea(new Dimension(800, 30)));
        this.add(questionPanel);
        this.add(Box.createRigidArea(new Dimension(800, 30)));
        this.add(answerPanel);
        this.setVisible(true);

        startGame();

    }

    private void setSettingB(QuizButton b) {

        b.setFocusable(false);
        b.setFont(font);
        b.setBorder(new LineBorder(Color.black, 5, true));
        b.setBackground(Color.LIGHT_GRAY);
        b.addActionListener((e) -> {

            if (b.isRight()) {
                MyFrame.score += 1;
            }
            counter.setText("Вопрос " + ++questionNumber + "/4");
            System.out.println(MyFrame.score);
            startGame();
        });
    }

    private void startGame() {

        //Генерируем вопросы
        if (!isReady) {
            questions = getQuestions();
        } else if (questionNumber == 5) {
            for (QuizButton i : quizButtons) {
                i.setEnabled(false);
                i.setVisible(false);
            }
            isStillPlaying = false;
            question.setText("Ваш результат: " + MyFrame.score + "/4");
            counter.setText("");
        }

        if (isStillPlaying) {
            //Берем из Map вопрос
            String temp = null;
            for (Map.Entry<String, Map<String, Boolean>> entry : questions.entrySet()) {
                temp = (String) entry.getKey();
                question.setText(temp);

                //Берем по ключу вопросы и соответствующие им ответы с их правильностью
                int x = 0;
                for (Map.Entry<String, Boolean> entry1 : questions.get(temp).entrySet()) {
                    for (int i = x++; i < quizButtons.length; i++) {
                        quizButtons[i].setText((String) entry1.getKey());
                        quizButtons[i].setRight((Boolean) entry1.getValue());
                    }
                }
                break;
            }
            isReady = true;				//Вопросы готовы
            questions.remove(temp);     //Удаляем из Map вопрос, который добавили для исключения повторения
        }

    }

    public ConcurrentHashMap<String, Map<String, Boolean>> getQuestions() {

        ConcurrentHashMap<String, Map<String, Boolean>> q = new ConcurrentHashMap<>();
        q.put("Как ваше настроение?",
                new ConcurrentHashMap<String, Boolean>());
        q.get("Как ваше настроение?").put("Относительно", false);
        q.get("Как ваше настроение?").put("Не очень", false);
        q.get("Как ваше настроение?").put("Плохо", false);
        q.get("Как ваше настроение?").put("Превосходно", true);

        q.put("Java - это?",
                new ConcurrentHashMap<String, Boolean>());
        q.get("Java - это?").put("Тип протокола", false);
        q.get("Java - это?").put("Язык прогроммирования", true);
        q.get("Java - это?").put("Специальность", false);
        q.get("Java - это?").put("Твоя мечта", false);


        q.put("Что из этого не является музыкальным инструментом?",
                new ConcurrentHashMap<String, Boolean>());
        q.get("Что из этого не является музыкальным инструментом?").put("Ксилофон", false);
        q.get("Что из этого не является музыкальным инструментом?").put("Металлофон", false);
        q.get("Что из этого не является музыкальным инструментом?").put("Саксофон", false);
        q.get("Что из этого не является музыкальным инструментом?").put("Граммофон", true);


        q.put("Какая из этих сказок не написана Г. Х. Андерсеном?",
                new ConcurrentHashMap<String, Boolean>());
        q.get("Какая из этих сказок не написана Г. Х. Андерсеном?").put("Золушка", true);
        q.get("Какая из этих сказок не написана Г. Х. Андерсеном?").put("Дюймовочка", false);
        q.get("Какая из этих сказок не написана Г. Х. Андерсеном?").put("Русалочка", false);
        q.get("Какая из этих сказок не написана Г. Х. Андерсеном?").put("Огниво", false);

        return q;
    }
}