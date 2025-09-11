package quizapp;

import java.util.ArrayList;

public class Quiz implements IQuiz {

    private String name;
    private double score;
    private int quizQuestionIndex = -1;
    private ArrayList<Question> questions = new ArrayList<>();

    public Quiz(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    private void setScore(double score) {
        this.score = score;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }


    public void addQuestion(String qText, int correctIndex, String... opts){

        Question q = new Question(qText);
        ArrayList<QuestionOption> options = new ArrayList<>();

        for(String opt : opts){
            options.add(new QuestionOption(opt));
        }
        options.get(correctIndex).setCorrect(true);

        q.setOptions(options);

        questions.add(q);

    }


    public void setQuestions(ArrayList<Question> questions) {
        this.questions.clear();
        this.questions = questions;
    }

    @Override
    public Question nextQuestion() {
        return questions.get(++quizQuestionIndex);
    }

    @Override
    public boolean hasNextQuestion() {

        boolean calculateScore = !(quizQuestionIndex < questions.size() - 1);
        if (calculateScore) {
            quizOver();
        }
        return !calculateScore ;
    }

    @Override
    public void quizOver() {
        for(Question q : questions){
            score += q.isCorrectOption() ? 1 : 0;
        }
    }
}
