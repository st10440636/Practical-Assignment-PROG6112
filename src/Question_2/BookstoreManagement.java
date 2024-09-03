package Question_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookstoreManagement {

    private static BookDatabase bookDatabase = new BookDatabase();

    public static void main(String[] args) {
        // Display the main menu
        showMainMenu();
    }

    private static void showMainMenu() {
        String[] options = {"Add Book", "Search Book", "Delete Book", "Update Book", "Print Report", "Exit"};
        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Bookstore Management",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0: // Add Book
                addBook();
                break;
            case 1: // Search Book
                searchBook();
                break;
            case 2: // Delete Book
                deleteBook();
                break;
            case 3: // Update Book
                updateBook();
                break;
            case 4: // Print Report
                printBookReport();
                break;
            case 5: // Exit
                JOptionPane.showMessageDialog(null, "Exiting the application!");
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                showMainMenu();
                break;
        }
    }

    private static void addBook() {
        String bookID = JOptionPane.showInputDialog("Enter Book ID:");
        String title = JOptionPane.showInputDialog("Enter Book Title:");
        String author = JOptionPane.showInputDialog("Enter Book Author:");
        double price = 0;
        try {
            price = Double.parseDouble(JOptionPane.showInputDialog("Enter Book Price:"));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid price format. Please enter a valid number.");
            return;
        }

        Book newBook = new Book(bookID, title, author, price);
        bookDatabase.addBook(newBook);
        JOptionPane.showMessageDialog(null, "Book added successfully!");
        showMainMenu(); // Return to the main menu
    }

    private static void searchBook() {
        String bookID = JOptionPane.showInputDialog("Enter Book ID to search:");
        Book foundBook = bookDatabase.searchBook(bookID);
        if (foundBook != null) {
            JOptionPane.showMessageDialog(null, "Book found: " + foundBook);
        } else {
            JOptionPane.showMessageDialog(null, "Book not found.");
        }
        showMainMenu(); // Return to the main menu
    }

    private static void deleteBook() {
        String bookID = JOptionPane.showInputDialog("Enter Book ID to delete:");
        bookDatabase.deleteBook(bookID);
        JOptionPane.showMessageDialog(null, "Book deleted successfully!");
        showMainMenu(); // Return to the main menu
    }

    private static void updateBook() {
        String bookID = JOptionPane.showInputDialog("Enter Book ID to update:");
        if (bookID != null && !bookID.isEmpty()) {
            String newTitle = JOptionPane.showInputDialog("Enter new title:");
            String newAuthor = JOptionPane.showInputDialog("Enter new author:");
            double newPrice;
            try {
                newPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter new price:"));
                bookDatabase.updateBook(bookID, newTitle, newAuthor, newPrice);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid price format. Please enter a valid number.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Book ID cannot be empty.");
        }
        showMainMenu(); // Return to the main menu
    }

    private static void printBookReport() {
        bookDatabase.printBookReport();
        showMainMenu(); // Return to the main menu
    }
}

