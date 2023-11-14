import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private final String questionText;
    private final List<String> options;
    private final int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int selectedOptionIndex) {
        return selectedOptionIndex == correctOptionIndex;
    }
}

public class QuizApp {
    private final List<Question> questions;
    private final Timer timer;
    private int currentQuestionIndex;
    private int score;

    public QuizApp() {
        questions = new ArrayList<>();
        timer = new Timer();
        currentQuestionIndex = 0;
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                endQuiz();
            }
        }, 60000); 

        displayQuestion(currentQuestionIndex);
    }

    public void displayQuestion(int questionIndex) {
        Question question = questions.get(questionIndex);
        System.out.println(question.getQuestionText());

        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        System.out.print("Enter the number of your answer: ");
        Scanner scanner = new Scanner(System.in);
        int selectedOption = scanner.nextInt();

        if (question.isCorrect(selectedOption - 1)) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong!");
        }

        currentQuestionIndex++;

        if (currentQuestionIndex < questions.size()) {
            displayQuestion(currentQuestionIndex);
        } else {
            endQuiz();
        }
    }

    public void endQuiz() {
        timer.cancel();
        System.out.println("Quiz Over!");
        System.out.println("Your score: " + score);
        System.out.println(score +" questions are correct out of 2");
    }

    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();

        Question question1 = new Question("What is the default value of a boolean variable in java?",
                List.of("NULL", "true", "false", "Zero"), 2);
        Question question2 = new Question("What is 7 + 3?",
                List.of("3", "10", "5", "6"), 1);

        quizApp.addQuestion(question1);
        quizApp.addQuestion(question2);

        quizApp.startQuiz();
    }
}
