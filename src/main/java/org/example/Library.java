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
        System.out.println("Book added successfully.");
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
}
