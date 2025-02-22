package org.example;

import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    //Adding a new book
    public void addBook(Book book){
        books.add(book);
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
