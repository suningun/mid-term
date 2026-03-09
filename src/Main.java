import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String correctUsername = "librarian";
        String correctPassword = "lib123";

        System.out.println("===== Library Management System =====");

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if(username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Login Successful!");

            int option;

            do {
                System.out.println("\n===== Welcome to the system =====");
                System.out.println("1. Book Management");
                System.out.println("2. Member Management");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. Overdue List");
                System.out.println("6. Logout");

                System.out.print("Enter your choice: ");
                option = scanner.nextInt();

                switch(option) {
                    case 1:
                        int choice;
                        do {
                            System.out.println("\n===== Manage Books =====");
                            System.out.println("1. Add Book");
                            System.out.println("2. Update Book");
                            System.out.println("3. Delete Book");
                            System.out.println("4. Search Book");
                            System.out.println("5. Return");

                            System.out.print("Enter your choice: ");
                            choice = scanner.nextInt();

                            switch(choice) {
                                case 1:
                                    System.out.println("Adding a new book...");
                                    break;
                                case 2:
                                    System.out.println("Updating book...");
                                    break;
                                case 3:
                                    System.out.println("Deleting book...");
                                    break;
                                case 4:
                                    System.out.println("Searching book...");
                                    break;
                                case 5:
                                    System.out.println("Returning to main menu...");
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }
                        } while(choice != 5);
                        break;

                    case 2:
                        int choice2;
                        do {
                            System.out.println("\n===== Manage Members =====");
                            System.out.println("1. Add Member");
                            System.out.println("2. Edit Member");
                            System.out.println("3. Delete Member");
                            System.out.println("4. Search Member");
                            System.out.println("5. View Borrowing history");
                            System.out.println("6. Return");

                            System.out.print("Enter your choice: ");
                            choice2 = scanner.nextInt();

                            switch(choice2) {
                                case 1:
                                    System.out.println("Adding a new member...");
                                    break;
                                case 2:
                                    System.out.println("Editing member information...");
                                    break;
                                case 3:
                                    System.out.println("Deleting member...");
                                    break;
                                case 4:
                                    System.out.println("Searching member...");
                                    break;
                                case 5:
                                    System.out.println("View member's borrowing history...");
                                    break;
                                case 6:
                                    System.out.println("Returning to main menu...");
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }
                        } while (choice2 != 6);
                        break;
                    case 3:
                        System.out.println("Borrow book...");
                        break;
                    case 4:
                        System.out.println("Return book...");
                        break;
                    case 5:
                        System.out.println("Overdue book...");
                        break;
                    case 6:
                        System.out.println("Logout...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }

            } while(option != 6);
        }
        else {
            System.out.println("Invalid Username or Password.");
        }
    }
}