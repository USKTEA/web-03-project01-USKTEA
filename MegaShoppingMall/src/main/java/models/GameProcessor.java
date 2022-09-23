package models;

import java.util.Random;

public class GameProcessor {
    private int answer;
    private int award = 30;

    public GameProcessor() {}

    public int[] start() {
        int x = new Random().nextInt(10);
        int y = new Random().nextInt(10);

        answer = x * y;

        return new int[]{x, y};
    }

    public int check(String input) {
        int inputAnswer = Integer.parseInt(input);
        int currentAnswer = answer;

        if (inputAnswer == currentAnswer) {
            return award;
        }

        return 0;
    }
}
