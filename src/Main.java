import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String borrowedUserName = "";
        String borrowedBookTitle = "";
        boolean hasBorrowed = false;
        LocalDate savedDueDate = null;
        String correctPassword = "admin123";

        System.out.println("--- Admin Login ---");
        System.out.print("Enter Password: ");

        String userEntered = scanner.nextLine();

        if (userEntered.equals(correctPassword)) {
            System.out.println("Access Successful!");
            System.out.println("Welcome to the Dashboard.");
            int action;
            ArrayList<String> bookList = new ArrayList<>();
            bookList.add("Java Basics");
            bookList.add("OOP in Java");

            ArrayList<String> memberList = new ArrayList<>();
            memberList.add("John Doe");
            memberList.add("Jane Smith");





            do {
                System.out.println("Welcome to library management system!");
                System.out.println("Type a number to proceed: ");
                System.out.println("1: Book Management ");
                System.out.println("2: Member Management ");
                System.out.println("3: Borrow Book ");
                System.out.println("4: Return Book ");
                System.out.println("5: Overdue List ");
                System.out.println("6: Logout ");
                System.out.println("7: Exit ");

                System.out.print("Enter your choice: ");
                action = scanner.nextInt();
                switch (action) {
                    case 1:
                        System.out.println("\n--- Book Management ---");
                        System.out.println("1: Add Book\n2: Update Book\n3: Delete Book\n4: Search Book\n5: Return to Dashboard");
                        System.out.print("Enter your choice: ");
                        int bookAction = scanner.nextInt();
                        switch (bookAction) {
                            case 1:
                                System.out.print("Enter book title to add: ");
                                String newBook = scanner.nextLine();
                                bookList.add(newBook);
                                System.out.println("Book '" + newBook + "' added successfully!");
                                break;
                            case 2:
                                System.out.print("Enter the name of the book to update: ");
                                String oldName = scanner.nextLine();
                                if (bookList.contains(oldName)) {
                                    System.out.print("Enter the new title: ");
                                    String updatedName = scanner.nextLine();
                                    int index = bookList.indexOf(oldName);
                                    bookList.set(index, updatedName);
                                    System.out.println("Book updated!");
                                } else {
                                    System.out.println("Book not found.");
                                }
                                break;

                            case 3:
                                System.out.print("Enter book title to delete: ");
                                String deleteBook = scanner.nextLine();
                                if (bookList.remove(deleteBook)) {
                                    System.out.println("Book deleted.");
                                } else {
                                    System.out.println("Book not found.");
                                }
                                break;
                            case 4:
                                System.out.print("Search for book: ");
                                String searchName = scanner.nextLine();
                                if (bookList.contains(searchName)) {
                                    System.out.println("Found: '" + searchName + "' is in the library.");
                                } else {
                                    System.out.println("Not Found: '" + searchName + "' is not available.");
                                }
                                break;
                            case 5:
                                break; // Returns to main menu
                        }
                        break;


                    case 2:
                        System.out.println("\n--- Member Management ---");
                        System.out.println("1: Add Member\n2: Update Member\n3: Delete Member\n4: Search Member\n5: Return to Dashboard");
                        int memberAction = scanner.nextInt();
                        switch (memberAction) {
                            case 1:
                                System.out.print("Enter name of new member: ");
                                String newMember = scanner.nextLine();
                                memberList.add(newMember);
                                System.out.println("Member '" + newMember + "' registered successfully!");
                                break;
                            case 2:
                                System.out.print("Enter name of member to update: ");
                                String oldMember = scanner.nextLine();
                                if (memberList.contains(oldMember)) {
                                    System.out.print("Enter the correct name: ");
                                    String updatedMember = scanner.nextLine();
                                    int index = memberList.indexOf(oldMember);
                                    memberList.set(index, updatedMember);
                                    System.out.println("Member info updated!");
                                } else {
                                    System.out.println("Member not found.");
                                }
                                break;
                            case 3:
                                System.out.print("Enter member name to remove: ");
                                String deleteMember = scanner.nextLine();
                                if (memberList.remove(deleteMember)) {
                                    System.out.println("Member removed from system.");
                                } else {
                                    System.out.println("Member not found.");
                                }
                                break;
                            case 4:
                                System.out.print("Search for member: ");
                                String searchMember = scanner.nextLine();
                                if (memberList.contains(searchMember)) {
                                    System.out.println("Found: '" + searchMember + "' is a registered member.");
                                } else {
                                    System.out.println("Not Found: No record for '" + searchMember + "'.");
                                }
                                break;
                            case 5:
                                break; // Returns to main menu
                        }
                        break;

                    case 3:
                        System.out.print("Enter User Name: ");
                        String userNameInput = scanner.nextLine();

                        System.out.print("Enter Book Title: ");
                        String bookTitleInput = scanner.nextLine();

                        if (memberList.contains(userNameInput) && bookList.contains(bookTitleInput)) {
                            borrowedUserName = userNameInput;
                            borrowedBookTitle = bookTitleInput;
                            hasBorrowed = true;

                            LocalDate borrowDate = LocalDate.now();
                            LocalDate dueDate = borrowDate.plusDays(14);

                            bookList.remove(bookTitleInput);

                            System.out.println("\n--- Loan Created ---");
                            System.out.println("User: " + borrowedUserName);
                            System.out.println("Book: " + borrowedBookTitle);
                            System.out.println("Borrowed on: " + borrowDate);
                            System.out.println("Due date: " + dueDate);
                            System.out.println("Borrow successful!\n");

                            savedDueDate = LocalDate.now().plusDays(14);
                            }
                        else {
                            // If one of them is missing, show an error
                            System.out.println("\nError: Borrow Failed!");
                            if (!memberList.contains(userNameInput)) {
                                System.out.println("- Member '" + userNameInput + "' is not registered.");
                            }
                            if (!bookList.contains(bookTitleInput)) {
                                System.out.println("- Book '" + bookTitleInput + "' is not in our collection.");
                            }
                            }


                        break;

                    case 4:
                        System.out.println("\n--- Return Book ---");
                        System.out.print("Enter student's name to return a book: ");
                        String nameToReturn = scanner.nextLine();

                        if (!hasBorrowed || !nameToReturn.equalsIgnoreCase(borrowedUserName)) {
                            System.out.println("Error:" + nameToReturn + " didn't borrow any book!");
                        } else {
                            System.out.println("Loan found for " + borrowedUserName + "!");
                            System.out.println("Returning: " + borrowedBookTitle);

                            LocalDate today = LocalDate.now();
                            if (today.isAfter (savedDueDate)) {
                                long daysLate = java.time.temporal.ChronoUnit.DAYS.between(savedDueDate, today);
                                System.out.println(borrowedUserName + " is penalized!");
                                System.out.println("Days overdue: " + daysLate);
                                System.out.println("Fine applied.");}
                            else {
                                System.out.println("Return Successful! No penalty.");
                            }

                            bookList.add(borrowedBookTitle);
                            System.out.println("'" + borrowedBookTitle + "' is now back in the library.");

                            hasBorrowed = false;
                            borrowedUserName = "";
                            borrowedBookTitle = "";
                            savedDueDate = null;
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
                                System.out.println("Days Overdue: " + daysLate + " days");
                                System.out.println("Current Penalty: $" + (daysLate * 1.0) + "$");
                            } else {
                                System.out.println("Status: The current loan for '" + borrowedBookTitle + "' is not overdue.");
                                System.out.println("It is due on: " + savedDueDate);
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
