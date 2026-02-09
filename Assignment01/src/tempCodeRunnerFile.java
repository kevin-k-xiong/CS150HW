public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("34564357345", "Bobby and Tim", "me");
        Book book2 = new Book("84356435743", "Timmy and Bob", "otherme");
        library.addBook(book1);
        library.addBook(book2);

        Borrower b1 = new Borrower("001", "Tim");
        Borrower b2 = new Borrower("002", "Bob");
        library.registerBorrower(b1);
        library.registerBorrower(b2);