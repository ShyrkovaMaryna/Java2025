import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class LibraryTest {
    @Test
    void testAddBook() {
        Library library = new Library();
        Book book = new Book("Kobzar", "Taras Shevchenko");
        library.addBook(book);
        assertEquals(1, library.getBookCount());
        assertTrue(library.getBooks().contains(book));
    }
    @Test
    void testRemoveBook() {
        Library library = new Library();
        Book book = new Book("Kobzar", "Taras Shevchenko");
        library.addBook(book);
        assertTrue(library.removeBook(book));
        assertEquals(0, library.getBookCount());
    }
    @Test
    void testGetBooks() {
        Library library = new Library();
        Book book1 = new Book("Kobzar", "Taras Shevchenko");
        Book book2 = new Book("300 poems", "Lina Kostenko");
        library.addBook(book1);
        library.addBook(book2);
        List<Book> books = library.getBooks();
        assertEquals(2, books.size());
    }
}

