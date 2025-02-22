package org.example;

import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            //menu
            System.out.println("\n***Library Management System***");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid. Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    //add book
                    try {
                        System.out.print("Enter book ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author name: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter publication year: ");
                        int year = Integer.parseInt(scanner.nextLine());

                        Book newBook = new Book(id, title, author, year);
                        library.addBook(newBook);
                        System.out.println("Book added successfully.");
                    } catch (Exception e) {
                        System.out.println("Error adding book: " + e.getMessage());
                    }
                    break;

                case 2:
                    //show all books
                    library.displayBooks();
                    break;

                case 3:
                    //search for a book by title
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.searchBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("No book found with that title.");
                    }
                    break;

                case 4:
                    //delete book by ID
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    if (library.deleteBookById(deleteId)) {
                        System.out.println("Book deleted successfully.");
                    } else {
                        System.out.println("No book found with that ID.");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Done");
                    return;

                default:
                    System.out.println("Invalid. Please try again.");
            }
        }


    }
}