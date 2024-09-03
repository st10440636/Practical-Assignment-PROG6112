 package Question_2;

 import junit.framework.TestCase;
 import java.util.List;

 public class BookDatabase_Tests extends TestCase {

     private BookDatabase bookDatabase;

     @Override
     protected void setUp() throws Exception {
         super.setUp();
         bookDatabase = new BookDatabase();
     }

     public void testBookDatabase() {
         assertNotNull("BookDatabase instance should be created.", bookDatabase);
     }

     public void testAddBook() {
         Book book = new Book("1", "Title1", "Author1", 29.99);
         bookDatabase.addBook(book);
         
         Book retrievedBook = bookDatabase.searchBook("1");
         assertNotNull("Book should be found after adding.", retrievedBook);
         assertEquals("Book title should match.", "Title1", retrievedBook.getTitle());
     }

     public void testSearchBook() {
         Book book = new Book("2", "Title2", "Author2", 39.99);
         bookDatabase.addBook(book);
         
         Book retrievedBook = bookDatabase.searchBook("2");
         assertNotNull("Book should be found.", retrievedBook);
         assertEquals("Book author should match.", "Author2", retrievedBook.getAuthor());
     }

     public void testDeleteBook() {
         Book book = new Book("3", "Title3", "Author3", 49.99);
         bookDatabase.addBook(book);
         
         bookDatabase.deleteBook("3");
         Book retrievedBook = bookDatabase.searchBook("3");
         assertNull("Book should be deleted.", retrievedBook);
     }

     public void testUpdateBook() {
         Book book = new Book("4", "Title4", "Author4", 59.99);
         bookDatabase.addBook(book);
         
         bookDatabase.updateBook("4", "NewTitle", "NewAuthor", 69.99);
         Book updatedBook = bookDatabase.searchBook("4");
         assertNotNull("Book should be found after updating.", updatedBook);
         assertEquals("Updated title should match.", "NewTitle", updatedBook.getTitle());
         assertEquals("Updated price should match.", 69.99, updatedBook.getPrice());
     }

     public void testPrintBookReport() {
         bookDatabase.addBook(new Book("5", "Title5", "Author5", 79.99));
         bookDatabase.addBook(new Book("6", "Title6", "Author6", 89.99));
         
         String report = bookDatabase.printBookReport();
         assertTrue("Report should contain Title5.", report.contains("Title5"));
         assertTrue("Report should contain Title6.", report.contains("Title6"));
     }

     public void testGetAllBooks() {
         Book book1 = new Book("7", "Title7", "Author7", 99.99);
         Book book2 = new Book("8", "Title8", "Author8", 109.99);
         bookDatabase.addBook(book1);
         bookDatabase.addBook(book2);
         
         List<Book> books = bookDatabase.getAllBooks();
         assertEquals("There should be 2 books in the database.", 2, books.size());
         assertTrue("Book1 should be in the list.", books.contains(book1));
         assertTrue("Book2 should be in the list.", books.contains(book2));
     }
 }
