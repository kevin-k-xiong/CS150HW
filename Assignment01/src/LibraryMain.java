/**
 * @author Kevin X.
 */
public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();
        addDemoBooks(library);
        registerDemoBorrowers(library);
        demoAvailabilityAndCheckout(library);
        demoCheckin(library);
    }

    /**
     * Adds sample books to the library for demo purposes.
     *
     * @param library the library to populate with books
     */
    private static void addDemoBooks(Library library) {
        Book book1 = new Book("34564357345", "Bobby and Tim", "me");
        Book book2 = new Book("84356435743", "Timmy and Bob", "otherme");
        library.addBook(book1);
        library.addBook(book2);
    }

    /**
     * Registers sample borrowers with the library for demo purposes.
     *
     * @param library the library to register borrowers in
     */
    private static void registerDemoBorrowers(Library library) {
        Borrower b1 = new Borrower("001", "Tim");
        Borrower b2 = new Borrower("002", "Bob");
        library.registerBorrower(b1);
        library.registerBorrower(b2);
    }

    /**
     * Demonstrates availability checks and a checkout flow.
     *
     * @param library the library to run the demo against
     */
    private static void demoAvailabilityAndCheckout(Library library) {
        System.out.println(library.isAvailable("34564357345"));
        System.out.println(library.checkout("001", "34564357345"));
        System.out.println(library.isAvailable("34564357345"));
        System.out.println(library.getBorrowerBooks("001"));
    }

    /**
     * Demonstrates a check-in flow and availability after return.
     *
     * @param library the library to run the demo against
     */
    private static void demoCheckin(Library library) {
        System.out.println(library.checkin("34564357345"));
        System.out.println(library.isAvailable("34564357345"));
        System.out.println(library.getBorrowerBooks("001"));
    }
}
