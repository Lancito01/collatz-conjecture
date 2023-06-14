import java.util.Scanner;

public class CollatzConjecture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            try {
                System.out.print(
                        "Enter a number:\n\t> 1 to run the program just once.\n\t> 2 to run the program infinitely, starting from any number.\n> ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("Please enter a number that represents an option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
        int number;
        if (choice == 1) {
            number = chooseNumber(scanner, "");
            conjecture(number);
        } else if (choice == 2) {
            number = chooseNumber(scanner, "Enter the number to start from:\n> ");
            while (true) {
                System.out.println("\n> Running program with number " + number + "...");
                conjecture(number);
                number++;

                // try { // ! these lines will slow down the program
                // Thread.sleep(500);
                // } catch (InterruptedException e) {
                // e.printStackTrace();
                // }
            }
        }
    }

    public static void conjecture(int number) {
        int savedInput = number;
        int largestNumberAchieved = number;
        int numberOfSteps = 0;
        System.out.println(number);

        while (number != 1) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = number * 3 + 1;
            }

            numberOfSteps++;

            if (number > largestNumberAchieved) {
                largestNumberAchieved = number;
            }

            System.out.println(number);

            // try { // ! these lines will slow down the program
            // Thread.sleep(500);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
        }

        System.out.println("> It took " + numberOfSteps + " steps to reach 1 from " + savedInput + ".");
        System.out.println("> The largest number achieved was " + largestNumberAchieved + ".");
    }

    public static int chooseNumber(Scanner scanner, String message) {
        message = message.isBlank() ? "Enter a number:\n> " : message;
        int currentNumber = 0;
        while (currentNumber <= 0) {
            try {
                System.out.print(message);
                currentNumber = Integer.parseInt(scanner.nextLine());
                if (currentNumber <= 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
        return currentNumber;
    }
}
