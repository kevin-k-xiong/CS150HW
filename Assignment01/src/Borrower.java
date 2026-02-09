
public class Borrower {
    private String id;
    private String name;

    /**
     * Creates a borrower with the given id and name.
     *
     * @param id   the borrower id
     * @param name the borrower name
     * @throws IllegalArgumentException if id or name is null or blank
     */
    public Borrower(String id, String name) {
        setId(id);
        setName(name);
    }

    /**
     * Returns the borrower id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the borrower id.
     *
     * @param id the new id
     * @throws IllegalArgumentException if id is null or blank
     */
    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id cannot be null or blank");
        }
        this.id = id;
    }

    /**
     * Returns the borrower name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the borrower name.
     *
     * @param name the new name
     * @throws IllegalArgumentException if name is null or blank
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        this.name = name;
    }

    /**
     * Compares borrowers by id only.
     *
     * @param o the other object
     * @return true if ids match
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Borrower)) {
            return false;
        }

        Borrower other = (Borrower) o;
        return this.id.equals(other.getId());
    }

    /**
     * Hash code based on id only.
     *
     * @return hash code
     */
    public int hashCode() {
        return id.hashCode();
    }
}
