package quizapp;

import java.util.ArrayList;

public abstract class Question implements IQuestion {

    private String questionText;
    private ArrayList<QuestionOption> options = new ArrayList<>();

    private static final int MIN_QUESTION_CHARS = 10;
    private static final int MIN_QUESTION_OPTIONS = 2;

    private static final char QUESTION_MARK = '?';

    private int selectedQuestionOptionIndex = -1;


    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {

        if(questionText.length() < MIN_QUESTION_CHARS || questionText.trim().charAt(questionText.length() - 1) != QUESTION_MARK){
            throw new IllegalArgumentException("Invalid question text");
        }

        this.questionText = questionText;
    }

    public String getOptions() {
//        String name = "Ben";  //String name = new String("Ben");
//        name = "Mr Ben";  // moves to another memeory address, creates String variable String name = new String("Mr Ben")

        StringBuffer toDisplay = new StringBuffer();

        for(int i = 0; i < options.size(); i++){
           char letter = (char)(65 + i);
            toDisplay.append(
                    String.format("%c) %s\n", letter, options.get(i).getOptionText())
            );
        }

        return toDisplay.toString();

    }

    public void setOptions(ArrayList<QuestionOption> options) {
        if(options.size() < MIN_QUESTION_OPTIONS){
            throw new IllegalArgumentException("Too few question options");
        }

        this.options.clear();
        this.options.addAll(options);
    }

    @Override
    public void selectQuestionOption(int questionOptionIndex) {
        if(questionOptionIndex < 0 || questionOptionIndex >= options.size()){
            throw new IllegalArgumentException("Invalid question option index");
        }
        selectedQuestionOptionIndex = questionOptionIndex;

    }

    @Override
    public boolean isCorrectOption() {
        return options.get(selectedQuestionOptionIndex).isCorrect();
    }
}
