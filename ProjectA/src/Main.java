import javax.swing.SwingUtilities;

public class Main {
    /**
     * Launches the Swing application on the EDT.
     *
     * @param args command-line args (unused)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}
