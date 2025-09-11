package quizapp;

import java.util.ArrayList;

public class Quiz implements IQuiz {

    private String name;
    private double score;
    private ArrayList<Question> questions = new ArrayList<>();

    @Override
    public void nextQuestion() {

    }

    @Override
    public boolean hasNextQuestion() {
        return false;
    }

    @Override
    public void quizOver() {

    }
}
