import java.util.*;

public class OnlineExaminationSystem {
    static Scanner sc = new Scanner(System.in);
    static int score = 0;

    public static void main(String[] args) {
        System.out.println("🧠 Welcome to Online Examination System");

        // Dummy login
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (username.equals("harsh") && password.equals("1234")) {
            System.out.println("✅ Login successful!\n");
            menu();
        } else {
            System.out.println("❌ Invalid Credentials.");
        }
    }

    public static void menu() {
        while (true) {
            System.out.println("\n📘 MENU:");
            System.out.println("1. Start Exam");
            System.out.println("2. View Result");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    startExam();
                    break;
                case 2:
                    viewResult();
                    break;
                case 3:
                    System.out.println("👋 Thank you for participating!");
                    return;
                default:
                    System.out.println("⚠️ Invalid Option.");
            }
        }
    }

    public static void startExam() {
        Map<String, String> questions = new LinkedHashMap<>();
        questions.put("Q1. What is the capital of India?\na) Mumbai\nb) Delhi\nc) Kolkata\nd) Chennai", "b");
        questions.put("Q2. Who developed Java?\na) Bjarne Stroustrup\nb) Dennis Ritchie\nc) James Gosling\nd) Guido van Rossum", "c");
        questions.put("Q3. Which is not a programming language?\na) HTML\nb) Java\nc) Python\nd) C++", "a");
        questions.put("Q4. What does JVM stand for?\na) Java Virtual Machine\nb) Java Verified Method\nc) Just Visual Memory\nd) Java Visual Machine", "a");
        questions.put("Q5. How many primitive data types in Java?\na) 6\nb) 7\nc) 8\nd) 9", "c");

        score = 0;
        sc.nextLine(); // Clear scanner

        for (Map.Entry<String, String> entry : questions.entrySet()) {
            System.out.println("\n" + entry.getKey());
            System.out.print("Enter your answer (a/b/c/d): ");
            String ans = sc.nextLine().toLowerCase();

            if (ans.equals(entry.getValue())) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + entry.getValue());
            }
        }

        System.out.println("\n📝 Exam finished!");
    }

    public static void viewResult() {
        System.out.println("🎯 Your Score: " + score + " out of 5");
        if (score >= 4) {
            System.out.println("🏆 Excellent!");
        } else if (score >= 2) {
            System.out.println("👍 Good Job!");
        } else {
            System.out.println("⚠️ Try Again.");
        }
    }
}