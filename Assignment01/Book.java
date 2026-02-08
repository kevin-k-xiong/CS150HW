public class Book {
    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        isValid(isbn);
        this.isbn = isbn;
        isValid(title);
        this.title = title;
        isValid(author);
        this.author = author;

    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return "isbn: " + isbn + ", " + " title: " + title + ", " + "author: " + author;
    }

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

    public int hashCode() {
        return isbn.hashCode();
    }

    private void isValid(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Invalid Input");
        }
    }
}
