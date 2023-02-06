import java.util.Scanner;

public class QuizMaker {
    public static void main(String[] args) throws InvalidQuizFormatException {
        Quiz quiz = Quiz.loadFromFile(args[0]);
        quiz.start();
    }
}
