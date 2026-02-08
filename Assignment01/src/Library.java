import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Library {

    private ArrayList<Book> catalog = new ArrayList<>();

    private HashMap<String, Book> byIsbn = new HashMap<>();

    private HashSet<Book> available = new HashSet<>();

    private HashMap<Borrower, LinkedList<Book>> borrowerBooks = new HashMap<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Error: Invalid Input");
        }
        if (findByIsbn(book.getIsbn()) != null) {
            return;
        }

        catalog.add(book);
        byIsbn.put(book.getIsbn(), book);
        available.add(book);

    }

    public Book findByIsbn(String isbn) {

    }

    public boolean isAvailable(String isbn) {

    }

    public void registerBorrower(Borrower b) {

    }

    public boolean checkout(String borrowerId, String isbn) {

    }

    public boolean checkin(String isbn) {

    }

    public LinkedList<Book> getBorrowerBooks(String borrowerId) {

    }
}
