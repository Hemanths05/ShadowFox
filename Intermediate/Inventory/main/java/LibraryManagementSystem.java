package main.java;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
        System.out.println("Library Management System");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Add Book");
        System.out.println("4. Borrow Book");
        System.out.println("5. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                System.out.println("Enter email:");
                String email = scanner.nextLine();
                User.registerUser(username, password, email, "Member");
                break;
            case 2:
                System.out.println("Enter username:");
                String loginUsername = scanner.nextLine();
                System.out.println("Enter password:");
                String loginPassword = scanner.nextLine();
                User user = User.loginUser(loginUsername, loginPassword);
                if (user != null) {
                    System.out.println("Welcome " + user.getUsername());
                } else {
                    System.out.println("Invalid credentials.");
                }
                break;
            case 3:
                System.out.println("Enter book title:");
                String title = scanner.nextLine();
                System.out.println("Enter author:");
                String author = scanner.nextLine();
                System.out.println("Enter genre:");
                String genre = scanner.nextLine();
                System.out.println("Enter ISBN:");
                String isbn = scanner.nextLine();
                System.out.println("Enter published year:");
                int publishedYear = scanner.nextInt();
                scanner.nextLine();
                if (Book.addBook(title, author, genre, isbn, publishedYear)) {
                    System.out.println("Book added successfully.");
                } else {
                    System.out.println("Failed to add the book.");
                }
                break;
            case 4:
                System.out.println("Enter your username:");
                String borrowerUsername = scanner.nextLine();
                System.out.println("Enter your password:");
                String borrowerPassword = scanner.nextLine();
                User borrower = User.loginUser(borrowerUsername, borrowerPassword);
                if (borrower != null) {
                    System.out.println("Enter book title to borrow:");
                    String borrowTitle = scanner.nextLine();
                    Book bookToBorrow = Book.getBookByTitle(borrowTitle);
                    if (bookToBorrow != null && bookToBorrow.getStatus().equals("Available")) {
                        if (Borrowing.borrowBook(borrower.getId(), bookToBorrow.getId())) {
                            System.out.println("Book borrowed successfully.");
                        } else {
                            System.out.println("Failed to borrow the book.");
                        }
                    } else {
                        System.out.println("Book is not available or doesn't exist.");
                    }
                } else {
                    System.out.println("Invalid credentials.");
                }
                break;
            case 5:
                running = false;
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option.");
        }
        System.out.println();
    }
        scanner.close();
    }
}
