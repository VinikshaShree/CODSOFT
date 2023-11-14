import java.util.Scanner;

public class StudentGradeCalculatorWithExceptionHandling {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter marks for 5 subjects:");
            int totalMarks = 0;
            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.print("Subject " + i + ": ");
                    int subjectMark = scanner.nextInt();
                    
                    if (subjectMark < 0 || subjectMark > 100) {
                        throw new IllegalArgumentException("Marks must be between 0 and 100.");
                    }
                    
                    totalMarks += subjectMark;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear the invalid input from the scanner
                    i--; // Re-enter the current subject's mark
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    i--; // Re-enter the current subject's mark
                }
            }
            
            double averageMark = (double) totalMarks / 5;
            
            String grade;
            if (averageMark >= 90) {
                grade = "O";
            } else if (averageMark >= 80) {
                grade = "A";
            } else if (averageMark >= 70) {
                grade = "B";
            } else if (averageMark >= 60) {
                grade = "C";
            } else if (averageMark >=45 ) {
                grade="D";
            }
            else {
                grade = "U";
            }
            
            System.out.println("Average Mark: " + averageMark);
            System.out.println("Grade: " + grade);
        }
    }
}
