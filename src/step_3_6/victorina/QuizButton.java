package step_3_6.victorina;

import javax.swing.JButton;

public class QuizButton extends JButton {
    private String answer;
    private boolean isRight;
    public QuizButton() {
    }
    public QuizButton(String answer, boolean isRight) {
        this.answer = answer;
        this.isRight = isRight;
        this.setText(answer);
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public boolean isRight() {
        return isRight;
    }
    public void setRight(boolean isRight) {
        this.isRight = isRight;
    }
}

