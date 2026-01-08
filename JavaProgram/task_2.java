// task 2 :
// Student Grade Calculator

import java.util.Scanner;

public class task_2 {   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to the Student Grade Calculator!");

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        // Taking input for marks
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            int mark = scanner.nextInt();
            
            // Validate marks
            if (mark < 0 || mark > 100) {
                System.out.println(" Invalid marks entered! Marks should be between 0 and 100.");
                i--; // Ask again for the same subject
            } else {
                marks[i] = mark;
                totalMarks += mark;
            }
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Determine grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("\n Results:");
        System.out.println("Total Marks = " + totalMarks + " out of " + (numberOfSubjects * 100));
        System.out.printf("Average Percentage = %.2f%%\n", averagePercentage);
        System.out.println("Grade = " + grade);

        scanner.close();
    }
}