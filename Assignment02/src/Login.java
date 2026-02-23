import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Login window that collects credentials and opens the counter screen on
 * success.
 */
public class Login {

    private final JFrame frame;
    private final JTextField emailField;
    private final JPasswordField passwordField;
    private final JLabel statusLabel;

    /**
     * Builds and shows the login UI.
     */
    public Login() {
        frame = createFrame();
        emailField = new JTextField(15);
        passwordField = new JPasswordField(15);
        statusLabel = createLabel();

        JPanel content = buildContentPanel();
        frame.add(content);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Creates and configures the login frame.
     *
     * @return configured login frame
     */
    private JFrame createFrame() {
        JFrame loginFrame = new JFrame("Login Screen");
        loginFrame.setSize(400, 300);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return loginFrame;
    }

    /**
     * Creates the label used to show login status messages.
     *
     * @return status label
     */
    private JLabel createLabel() {
        JLabel label = new JLabel(" ");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return label;
    }

    /**
     * Builds the top-level content panel for the login screen.
     *
     * @return assembled content panel
     */
    private JPanel buildContentPanel() {
        JPanel winLayout = new JPanel();
        winLayout.setLayout(new BoxLayout(winLayout, BoxLayout.Y_AXIS));

        JPanel formPanel = buildFormPanel();
        JPanel buttonPanel = buildButtonPanel();

        winLayout.add(Box.createVerticalStrut(20));
        winLayout.add(formPanel);
        winLayout.add(Box.createVerticalStrut(12));
        winLayout.add(buttonPanel);
        winLayout.add(Box.createVerticalStrut(8));
        winLayout.add(statusLabel);

        return winLayout;
    }

    /**
     * Builds the email/password form panel.
     *
     * @return form panel
     */
    private JPanel buildFormPanel() {
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 8, 8));

        JLabel emailBox = new JLabel("Email:");
        JLabel passBox = new JLabel("Password:");

        formPanel.add(emailBox);
        formPanel.add(emailField);
        formPanel.add(passBox);
        formPanel.add(passwordField);
        formPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        return formPanel;
    }

    /**
     * Builds the panel containing the login action button.
     *
     * @return button panel
     */
    private JPanel buildButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> onLoginClicked());
        buttonPanel.add(loginButton);
        buttonPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        return buttonPanel;
    }

    /**
     * Validates user credentials and transitions to the counter window on success.
     */
    private void onLoginClicked() {
        String userInput = emailField.getText().trim();
        String passInput = new String(passwordField.getPassword()).trim();

        if (User.validateCredentials(userInput, passInput)) {
            statusLabel.setText("Login successful");
            SwingUtilities.invokeLater(() -> new Counter());
            frame.dispose();
        } else {
            statusLabel.setText("Invalid email or password");
        }
    }
}
