import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Ask how many subjects the user wants to enter
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        double totalMarks = 0; // will hold the sum of all marks

        // Step 2: Take marks for each subject (out of 100)
        for (int i = 1; i <= numberOfSubjects; i++) {
            double marks;

            // Loop until valid marks (0-100) are entered
            while (true) {
                System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
                marks = scanner.nextDouble();

                if (marks < 0 || marks > 100) {
                    System.out.println("Please enter a value between 0 and 100.");
                } else {
                    break; // valid input, exit the validation loop
                }
            }

            totalMarks += marks; // add this subject's marks to the running total
        }

        // Step 3: Calculate average percentage
        double averagePercentage = totalMarks / numberOfSubjects;

        // Step 4: Assign a grade based on the average percentage
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
        } else if (averagePercentage >= 40) {
            grade = "E";
        } else {
            grade = "F";
        }

        // Step 5: Display the results
        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numberOfSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

