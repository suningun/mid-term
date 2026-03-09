import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String correctPassword = "admin123";
        System.out.println("--- Admin Login ---");
        System.out.print("Enter Password: ");

        String userEntered = input.nextLine();

        if (userEntered.equals(correctPassword)) {
            System.out.println("Access Successful!");
            System.out.println("Welcome to the Dashboard.");
            Scanner scanner = new Scanner(System.in);
            int action;
            String borrowedUserName;
            String borrowedBookTitle;
            boolean hasBorrowed = false;
            LocalDate savedDueDate = null;


            do {
                System.out.print("Welcome to library management system!\n");
                System.out.print("Type a number to proceed: \n");
                System.out.print("1: Book Management\n" +
                        "2: Member Management\n" +
                        "3: Borrow Book\n" +
                        "4: Return Book\n" +
                        "5: Overdue List\n" +
                        "6: Logout\n" +
                        "7: Exit\n");
                System.out.println("Enter your choice: ");
                action = scanner.nextInt();
                switch (action) {
                    case 1:
                        System.out.println("\n--- Book Management ---");
                        System.out.println("1: Add Book\n2: Update Book\n3: Delete Book\n4: Search Book\n5: Return to Dashboard");
                        int bookAction = scanner.nextInt();
                        switch(bookAction) {
                            case 1: System.out.println("Adding book..."); break;
                            case 2: System.out.println("Updating book..."); break;
                            case 3: System.out.println("Deleting book..."); break;
                            case 4: System.out.println("Searching book..."); break;
                            case 5: break; // Returns to main menu
                        }
                        break;


                    case 2:
                        System.out.println("\n--- Member Management ---");
                        System.out.println("1: Add Member\n2: Update Member\n3: Delete Member\n4: Search Member\n5: Return to Dashboard");
                        int memberAction = scanner.nextInt();
                        switch(memberAction) {
                            case 1: System.out.println("Adding member..."); break;
                            case 2: System.out.println("Updating member..."); break;
                            case 3: System.out.println("Deleting member..."); break;
                            case 4: System.out.println("Searching member..."); break;
                            case 5: break; // Returns to main menu
                        }
                        break;

                    case 3:
                        System.out.print("Enter User Name: ");
                        borrowedUserName = scanner.nextLine();

                        System.out.print("Enter Book Title: ");
                        borrowedBookTitle = scanner.nextLine();

                        LocalDate borrowDate = LocalDate.now();
                        LocalDate dueDate = borrowDate.plusDays(14);

                        System.out.println("\n--- Loan Created ---");
                        System.out.println("User: " + borrowedUserName);
                        System.out.println("Book: " + borrowedBookTitle);
                        System.out.println("Borrowed on: " + borrowDate);
                        System.out.println("Due date: " + dueDate);
                        System.out.println("Borrow successful!\n");
                        hasBorrowed = true;
                        savedDueDate = LocalDate.now().plusDays(14);
                        break;

                    case 4:
                        System.out.print("Enter student's name to return a book: ");
                        String nameInput = scanner.nextLine();

                        if (!hasBorrowed || !nameInput.equalsIgnoreCase(borrowedUserName)) {
                            System.out.println("Error:" + nameInput + " didn't borrow any book!");
                        } else {
                            System.out.println("Loan found for " + borrowedUserName + "!");
                            System.out.println("Returning: " + borrowedBookTitle);

                            int overdate = dueDate - dueDate;
                            if (dueDate <15) {
                                System.out.println("Return Successful!");}
                            else {
                                System.out.println ( borrowedUserName + " are penalised");
                            }



                            hasBorrowed = false;
                            borrowedUserName = "";
                            borrowedBookTitle = "";
                        }
                        break;

                    case 5: // Overdue List
                        System.out.println("\n--- Checking Overdue Records ---");

                        // Check if there is even a loan to look at
                        if (!hasBorrowed) {
                            System.out.println("No active loans found.");
                        } else {
                            LocalDate today = LocalDate.now();

                            // Use .isAfter() to check if today is past the due date
                            if (today.isAfter(savedDueDate)) {
                                System.out.println("OVERDUE RECORD FOUND:");
                                System.out.println("User: " + borrowedUserName);
                                System.out.println("Book: " + borrowedBookTitle);
                                System.out.println("Due Date was: " + savedDueDate);

                                // Optional: Calculate the fine ($1 per day)
                                long daysLate = java.time.temporal.ChronoUnit.DAYS.between(savedDueDate, today);
                                System.out.println("Fine Amount: $" + daysLate);
                            } else {
                                System.out.println("All loans are currently up to date (not overdue).");
                            }
                        }
                        break;

                }
            } while (action != 6);
        }
        else {
            System.out.println("Incorrect Password. Access Denied.");
            }

        }

    }
