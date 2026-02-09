
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * Small library system that manages books, borrowers, and checkouts.
 */
public class Library {

    // We use an ArrayList for easier inseration order and faster iteration through
    // the
    // index.
    private ArrayList<Book> catalog = new ArrayList<>();

    // We use a HashMap so we dont have to scan every element
    private HashMap<String, Book> byIsbn = new HashMap<>();

    // We use a Hashset that way we only need to check if the element exists for it
    // to be available or not.
    private HashSet<Book> available = new HashSet<>();

    // We use a HashMap so that we can tie the borrower and the books they checked
    // out together.
    private HashMap<Borrower, LinkedList<Book>> borrowerBooks = new HashMap<>();

    /**
     * Adds a book to the library catalog if it is not already present.
     *
     * @param book the book to add
     * @throws IllegalArgumentException if book is null
     */
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException();
        }
        if (findByIsbn(book.getIsbn()) != null) {
            return;
        }

        catalog.add(book);
        byIsbn.put(book.getIsbn(), book);
        available.add(book);

    }

    /**
     * Finds a book by its ISBN.
     *
     * @param isbn the ISBN to look up
     * @return the matching book, or null if not found
     */
    public Book findByIsbn(String isbn) {
        Book b = byIsbn.get(isbn);

        if (b == null) {
            return null;
        }
        return b;

    }

    /**
     * Checks if the book with the given ISBN is currently available.
     *
     * @param isbn the ISBN to check
     * @return true if available, false otherwise
     */
    public boolean isAvailable(String isbn) {
        Book b = byIsbn.get(isbn);
        if (b != null && available.contains(b)) {
            return true;
        }
        return false;
    }

    /**
     * Registers a borrower with an empty checkout list.
     *
     * @param b the borrower to register
     * @throws IllegalArgumentException if borrower is null
     */
    public void registerBorrower(Borrower b) {

        if (b == null) {
            throw new IllegalArgumentException();
        }

        if (borrowerBooks.containsKey(b)) {
            return;
        } else {
            borrowerBooks.put(b, new LinkedList<Book>());
        }
    }

    /**
     * Checks out a book to a borrower.
     *
     * @param borrowerId the borrower id
     * @param isbn       the ISBN to check out
     * @return true if checkout succeeds, false if not available
     * @throws IllegalArgumentException if borrower or ISBN is unknown
     */
    public boolean checkout(String borrowerId, String isbn) {
        Book b = byIsbn.get(isbn);
        if (b == null)
            throw new IllegalArgumentException();

        Borrower found = findId(borrowerId);

        if (found == null) {
            throw new IllegalArgumentException();
        }

        if (available.contains(b)) {
            LinkedList<Book> list = borrowerBooks.get(found);
            list.add(b);
            available.remove(b);
            return true;
        }
        return false;

    }

    /**
     * Checks in a book by ISBN.
     *
     * @param isbn the ISBN to check in
     * @return true if the book was checked in, false if it was already available
     * @throws IllegalArgumentException if ISBN is unknown
     */
    public boolean checkin(String isbn) {
        Book b = byIsbn.get(isbn);

        if (b == null) {
            throw new IllegalArgumentException();
        }

        if (available.contains(b)) {
            return false;
        }

        for (Map.Entry<Borrower, LinkedList<Book>> entry : borrowerBooks.entrySet()) {
            LinkedList<Book> list = entry.getValue();
            if (list.contains(b)) {
                list.remove(b);
                available.add(b);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a copy of the borrower�s current book list.
     *
     * @param borrowerId the borrower id
     * @return a copy of the borrower�s list
     * @throws IllegalArgumentException if borrower is unknown
     */
    public LinkedList<Book> getBorrowerBooks(String borrowerId) {
        Borrower borrower = findId(borrowerId);

        if (borrower == null) {
            throw new IllegalArgumentException();
        }

        LinkedList<Book> list = borrowerBooks.get(borrower);
        return new LinkedList<Book>(list);

    }

    /**
     * Finds a borrower by id among registered borrowers.
     *
     * @param borrowerId the id to search for
     * @return the matching borrower, or null if not found
     */
    private Borrower findId(String borrowerId) {

        Borrower found = null;
        // Finds the id of borrower in borrowerBooks HashMap
        for (Borrower br : borrowerBooks.keySet()) {
            if (br.getId().equals(borrowerId)) {
                found = br;
                break;
            }

        }
        return found;
    }

}
