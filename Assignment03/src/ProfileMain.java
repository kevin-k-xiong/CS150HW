public class ProfileMain {
    /**
     * Launches the profile view.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Profile profile = new Profile("Steve", 45, "Law");
        new ProfilePanel(profile);
    }
}
