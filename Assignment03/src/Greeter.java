import java.awt.FlowLayout;
import javax.swing.*;

/**
 * First window shown to the user. Displays a greeting flow and a button to open
 * login.
 */
public class Greeter extends JFrame {

    private final JFrame frame;
    private final JButton pressButton;
    private final JButton goToLoginButton;
    private final JLabel messageLabel;

    /**
     * Builds and shows the greeter UI.
     */
    public Greeter() {
        frame = getGreeting();
        pressButton = new JButton("Press");
        goToLoginButton = new JButton("Go to Login");
        messageLabel = new JLabel("");

        buildUi();
        frame.setVisible(true);
    }

    /**
     * Creates greeter.
     *
     * @return configured greeter frame
     */
    private JFrame getGreeting() {
        JFrame greeterFrame = new JFrame("Greetings");
        greeterFrame.setSize(400, 300);
        greeterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        greeterFrame.setLayout(new FlowLayout());
        return greeterFrame;
    }

    /**
     * Builds components and event handlers for the greeter window.
     */
    private void buildUi() {
        goToLoginButton.setVisible(false);

        pressButton.addActionListener(e -> onPressClicked());
        goToLoginButton.addActionListener(e -> onGoToLoginClicked());

        frame.add(pressButton);
        frame.add(goToLoginButton);
        frame.add(messageLabel);
    }

    /**
     * Handles clicks on the initial press button.
     */
    private void onPressClicked() {
        messageLabel.setText("Hello User!");
        System.out.println("Hello User");
        goToLoginButton.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Opens the login window.
     */
    private void onGoToLoginClicked() {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
