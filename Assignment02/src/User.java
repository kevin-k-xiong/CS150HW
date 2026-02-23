/**
 * Simple user model that stores credentials and performs credential validation.
 */
public class User {

    private final String email;
    private final String password;

    private static final User STORED_USER = new User("abcdefg@uwec.edu", "cs150");

    /**
     * Creates a user model.
     *
     * @param email user email
     * @param password user password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Returns the user's email.
     *
     * @return email value
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the user's password.
     *
     * @return password value
     */
    public String getPassword() {
        return password;
    }

    /**
     * Checks whether the provided credentials match this user's credentials.
     *
     * @param inputEmail email to validate
     * @param inputPassword password to validate
     * @return {@code true} when both email and password match
     */
    public boolean matches(String inputEmail, String inputPassword) {
        return getEmail().equals(inputEmail) && getPassword().equals(inputPassword);
    }

    /**
     * Validates credentials against the single stored login user.
     *
     * @param inputEmail email to validate
     * @param inputPassword password to validate
     * @return {@code true} when credentials are valid
     */
    public static boolean validateCredentials(String inputEmail, String inputPassword) {
        return STORED_USER.matches(inputEmail, inputPassword);
    }
}
