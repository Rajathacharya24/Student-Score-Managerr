import java.util.Scanner;

public class StudentINF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number Of Students: ");
        int size = sc.nextInt();

        String[] names = new String[size];
        int[] scores = new int[size];

        // Input
        for (int i = 0; i < size; i++) {
            System.out.print("Enter Name of Student " + (i + 1) + ": ");
            names[i] = sc.next();

            System.out.print("Enter Score of Student " + (i + 1) + ": ");
            scores[i] = sc.nextInt();
        }

        // Menu loop
        while (true) {
            System.out.println("\n=== STUDENT SCORE MANAGER MENU ===");
            System.out.println("1. Show All Students");
            System.out.println("2. Show Highest & Lowest Score");
            System.out.println("3. Show Average Score");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showAll(names, scores);
                    break;
                case 2:
                    showHighLow(scores, names);
                    break;
                case 3:
                    showAverage(scores);
                    break;
                case 4:
                    System.out.print("Enter name to search: ");
                    String target = sc.next();
                    searchStudent(target, names, scores);
                    break;
                case 5:
                    System.out.println("Exiting…");
                    sc.close();
                    return; // Exit program
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Display all students
    public static void showAll(String[] names, int[] scores) {
        System.out.println("\n--- All Students ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " → " + scores[i]);
        }
    }

    // Highest and lowest score
    public static void showHighLow(int[] scores, String[] names) {
        int max = scores[0];
        int min = scores[0];
        String maxName = names[0];
        String minName = names[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                maxName = names[i];
            }
            if (scores[i] < min) {
                min = scores[i];
                minName = names[i];
            }
        }

        System.out.println("\nHighest: " + maxName + " with " + max);
        System.out.println("Lowest: " + minName + " with " + min);
    }

    // Average score
    public static void showAverage(int[] scores) {
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double avg = sum / scores.length;
        System.out.println("\nAverage Score: " + avg);
    }

    // Search by name
    public static void searchStudent(String target, String[] names, int[] scores) {
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println("\nFound: " + names[i] + " → " + scores[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found!");
        }
    }
}
