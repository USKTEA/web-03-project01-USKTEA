package controller;

import models.GameProcessor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class GameController {
    private GameProcessor gameProcessor;
    private JPanel gameText;

    public GameController(JPanel gameText) {
        this.gameProcessor = new GameProcessor();
        this.gameText = gameText;
    }

    public void start() {
        gameText.removeAll();

        int[] numbers = gameProcessor.start();

        JLabel quiz = new JLabel(numbers[0] + " X " + numbers[1] + " = ?", JLabel.CENTER);
        quiz.setFont(new Font("NanumGothic", Font.BOLD, 25));
        gameText.add(quiz);
    }

    public int check(String answer) {
        return gameProcessor.check(answer);
    }
}
