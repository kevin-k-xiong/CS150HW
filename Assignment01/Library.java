public class Library {

    private ArrayList<Book> catalog = new ArrayList<>();

    private HashMap<String, Book> byIsbn = new HashMap<>();

    private HashSet<Book> isAvailable = new HashSet<>();

    private HashMap<Borrower, LinkedList<Book>> borrowerBooks = new HashMap<>();

    public void addBook(Book book) {

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
