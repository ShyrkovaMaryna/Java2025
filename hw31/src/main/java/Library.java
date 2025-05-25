import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private final List<Book> books = new ArrayList<>();
    public boolean addBook(Book book) {
        Objects.requireNonNull(book, "[book] must not be null!");
        if (books.contains(book)) {
            return false;
        }
        books.add(book);
        return true;
    }
    public boolean removeBook(Book book) {
        Objects.requireNonNull(book, "[book] must not be null!");
        return books.remove(book);
    }
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
    public int getBookCount() {
        return books.size();
    }
}

