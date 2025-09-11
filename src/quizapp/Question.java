package quizapp;

import java.util.ArrayList;

public class Question implements IQuestion {

    private String questionText;
    private ArrayList<QuestionOption> options = new ArrayList<>();

    private static final int MIN_QUESTION_CHARS = 10;
    private static final int MIN_QUESTION_OPTIONS = 2;

    private static final char QUESTION_MARK = '?';

    private int selectedQuestionOptionIndex = -1;

    public Question(String questionText){
        setQuestionText(questionText);
    }


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


    public String getUserResponse(String response) {
        StringBuilder feedback = new StringBuilder();

        feedback.delete(0, feedback.length());
        int option = (response.trim().charAt(0)) - 65;

        try {
            selectQuestionOption(option);
            feedback.append("Your answer was ");
            feedback.append(isCorrectOption() ? "correct" : "incorrect");
        }
        catch (Exception e) {

            for(int i = 0; i < options.size(); i++){
                if(!options.get(i).isCorrect()){
                    selectQuestionOption(i);
                    break;
                }
            }

            feedback.append("You entered an invalid answer");
        }
        return feedback.toString();
    }
}
