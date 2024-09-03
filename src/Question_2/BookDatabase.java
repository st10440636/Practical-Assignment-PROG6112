package Question_2;

import java.util.ArrayList;
import java.util.List;

public class BookDatabase {

    private List<Book> books = new ArrayList<>();

    // Add a book to the database
    public void addBook(Book book) {
        books.add(book);
    }

    // Search for a book by ID
    public Book searchBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    // Delete a book by ID
    public void deleteBook(String id) {
        Book bookToRemove = searchBook(id);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
        }
    }

    // Update a book's details
    public void updateBook(String id, String newTitle, String newAuthor, double newPrice) {
        Book bookToUpdate = searchBook(id);
        if (bookToUpdate != null) {
            bookToUpdate.setTitle(newTitle);
            bookToUpdate.setAuthor(newAuthor);
            bookToUpdate.setPrice(newPrice);
        }
    }

    // Print a report of all books
    public String printBookReport() {
        StringBuilder report = new StringBuilder();
        for (Book book : books) {
            report.append(book.toString()).append("\n");
        }
        return report.toString();
    }

    // Get a list of all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
