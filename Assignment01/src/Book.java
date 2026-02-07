public class Book {
    private Sitrng isbn;
    private String title;
    private String author;

    public Book(Sitrng isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public Sitrng getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {

    }
}
