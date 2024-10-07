import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introdu o expresie sau scrie 'stop' pentru a iesi: ");

        while (true) {
            // citim linia din cmd
            String input = scanner.nextLine();

            // verificam daca s-a scris "stop"
            if (input.trim().equalsIgnoreCase("stop")) {
                break;
            }

            try {
                // parsam inputul expresiei
                ComplexExpression expression = parser.parseExpression(input);
                System.out.println("\033[32mExpresia este valida!\033[0m");

                // executam operatia expresiei
                expression.executeAll();
            } catch (Exception e) {
                // afisam eroarea
                System.out.println("\033[31m" + e.getMessage() + "\033[0m\n");
            }
        }

        System.out.println("Incheiere program...");
    }
}