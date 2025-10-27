import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(" Welcome to the Student Grade Calculator! ");
        
   
        System.out.print("Enter the number of subjects: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please run again and enter a valid number.");
            scanner.close();
            return;
        }
        int numSubjects = scanner.nextInt();
        
        if (numSubjects <= 0) {
            System.out.println("Number of subjects must be greater than zero.");
            scanner.close();
            return;
        }

        int totalMarks = 0;
        int maxMarksPerSubject = 100;

        
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in Subject " + i + " (out of " + maxMarksPerSubject + "): ");
            
            if (scanner.hasNextInt()) {
                int marks = scanner.nextInt();
                
                
                if (marks >= 0 && marks <= maxMarksPerSubject) {
                    totalMarks += marks; 
                } else {
                    System.out.println("Warning: Marks must be between 0 and " + maxMarksPerSubject + ". Skipping invalid entry.");
                    i--; 
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
                i--; 
            }
        }

        
        double averagePercentage = (double) totalMarks / numSubjects;

        
        String grade = calculateGrade(averagePercentage);

        
        System.out.println("\n--- Student Result Summary ---");
        System.out.println("Total Subjects: " + numSubjects);
        System.out.println("Total Marks: " + totalMarks + " / " + (numSubjects * maxMarksPerSubject));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Corresponding Grade: " + grade);
        System.out.println("------------------------------");

        scanner.close();
    }

    private static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+ (Excellent)";
        } else if (percentage >= 80) {
            return "A (Very Good)";
        } else if (percentage >= 70) {
            return "B (Good)";
        } else if (percentage >= 60) {
            return "C (Fair)";
        } else if (percentage >= 50) {
            return "D (Pass)";
        } else {
            return "F (Fail)";
        }
    }
}
