public class Borrower {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Borrower)) {
            return false;
        }

        Borrower other = (Borrower) o;

        if (this.id.equals(other.getId())) {
            return true;
        } else {
            return false;
        }

    }

    public int hashCode() {
        return id.hashCode();
    }
}
