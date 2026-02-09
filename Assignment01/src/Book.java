public class Book {
    private String isbn;
    private String title;
    private String author;

    /**
     * Creates a new Book with the given ISBN, title, and author.
     * 
     * @param isbn   unique identifier for the book (non-null, non-blank)
     * @param title  book title (non-null, non-blank)
     * @param author book author (non-null, non-blank)
     * @throws IllegalArgumentException if any argument is null or blank
     */
    public Book(String isbn, String title, String author) {
        isValid(isbn);
        this.isbn = isbn;
        isValid(title);
        this.title = title;
        isValid(author);
        this.author = author;

    }

    /**
     * @return the ISBN for this book
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @return the title of this book
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the author of this book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return a readable string representation of this book
     */
    public String toString() {
        return "isbn: " + isbn + ", " + " title: " + title + ", " + "author: " + author;
    }

    /**
     * Two books are equal if they have the same ISBN.
     * 
     * @param o the object to compare
     * @return true if ISBNs are equal; false otherwise
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }

        Book other = (Book) o;
        if (this.isbn.equals(other.getIsbn())) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * @return hash code based on ISBN only
     */
    public int hashCode() {
        return isbn.hashCode();
    }

    /**
     * Validates that a string is not null or blank.
     * 
     * @param s string to validate
     * @throws IllegalArgumentException if invalid
     */
    private void isValid(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
