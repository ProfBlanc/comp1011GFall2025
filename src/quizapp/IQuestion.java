package quizapp;

public interface IQuestion {

    void selectQuestionOption(int questionOptionIndex);
    boolean isCorrect(QuestionOption selectedQuestionOption);

}
