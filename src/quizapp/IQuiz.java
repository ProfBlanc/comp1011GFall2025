package quizapp;

public interface IQuiz {

    Question nextQuestion();
    boolean hasNextQuestion();
    void quizOver();
}
