package org.example;

import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    //Adding a new book
    public boolean addBook(int id, String title, String author, int year) {
        //if ID is already exist
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println("Error: Book with ID " + id + " already exists.");
                return false; // ID already taken, return false
            }
        }

        // If ID not taken
        Book newBook = new Book(id, title, author, year);
        books.add(newBook);
//        System.out.println("Book added successfully.");
        return true;
    }

    //Displaying all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books are available at the moment.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    //Searching for a book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    //Deleting a book by id
    public boolean deleteBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    // Save books to a file (optional)
    public void saveToFile(String filename) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filename)) {
            for (Book book : books) {
                writer.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    // Load books from a file (optional)
    public void loadFromFile(String filename) {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];
                int year = Integer.parseInt(parts[3]);
                boolean added = addBook(id, title, author, year);
                if (!added) {
                    System.out.println("Book was not added due to duplicate ID.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }



}
