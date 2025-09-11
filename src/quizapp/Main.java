package quizapp;

import java.io.Console;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        Quiz quiz = new Quiz("General Knowledge Quiz");
        quiz.addQuestion("How many provinces are in Canada?", 1, "5", "10", "15", "20");
        quiz.addQuestion("How many territories are in Canada?", 3, "0", "1", "2", "3");
        quiz.addQuestion("Canada is located on which continent?", 0, "North America", "South America", "Africa", "Antarctica");

        //for(Question question : quiz.getQuestions()) {
        while(quiz.hasNextQuestion()){
            Question question = quiz.nextQuestion();
            System.out.println(question.getQuestionText());
            System.out.println(question.getOptions());
            System.out.println("Answer: ");
            Console console = System.console();
            String answer = console.readLine().toUpperCase();
            System.out.println(question.getUserResponse(answer));

        }

        System.out.println(String.format("You scored %.0f out of %d\n", quiz.getScore(), quiz.getQuestions().size()));
    }
}
