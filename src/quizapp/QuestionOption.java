package quizapp;

public abstract class QuestionOption {

    private String optionText;
    private boolean correct;

    public QuestionOption(String optionText) {
        setOptionText(optionText);
    }

    public QuestionOption(String optionText, boolean correct) {
        this(optionText);
        setCorrect(correct);
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }
}
