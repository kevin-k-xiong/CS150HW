import java.awt.*;

import javax.swing.*;

public class ProfilePanel {

    /**
     * Creates a profile panel with a default profile.
     */
    public ProfilePanel() {
        this(new Profile("Student"));
    }

    /**
     * Creates and shows the profile frame.
     *
     * @param profile profile data to display
     */
    public ProfilePanel(Profile profile) {
        JFrame profileFrame = new JFrame("Profile");
        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profileFrame.setSize(400, 300);
        profileFrame.setLocationRelativeTo(null);

        JPanel content = buildContent(profile);
        profileFrame.setContentPane(content);
        profileFrame.setVisible(true);
    }

    /**
     * Builds the content panel for the given profile.
     *
     * @param profile profile data
     * @return configured content panel
     */
    private JPanel buildContent(Profile profile) {
        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        root.setBackground(colorForAge(profile.getAge()));

        JLabel iconLabel = new JLabel(resolveDefaultIcon());
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconLabel.setPreferredSize(new Dimension(100, 100));
        root.add(iconLabel, BorderLayout.WEST);

        JPanel infoPanel = new JPanel(new GridLayout(3, 1, 0, 8));
        infoPanel.setOpaque(false);

        JLabel nameLabel = new JLabel("Name: " + profile.getName());
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD, 16f));
        infoPanel.add(nameLabel);
        infoPanel.add(new JLabel("Age: " + profile.getAge()));
        infoPanel.add(new JLabel("Major: " + profile.getMajor()));

        root.add(infoPanel, BorderLayout.CENTER);
        return root;
    }

    /**
     * Resolves a default icon from UI defaults.
     *
     * @return icon to display
     */
    private Icon resolveDefaultIcon() {
        Icon icon = UIManager.getIcon("OptionPane.informationIcon");
        if (icon != null) {
            return icon;
        }
        return new ImageIcon();
    }

    /**
     * Chooses a background color based on age.
     *
     * @param age profile age
     * @return background color
     */
    private Color colorForAge(int age) {
        if (age < 20) {
            return new Color(255, 0, 0);
        }
        if (age <= 25) {
            return new Color(0, 255, 0);
        }
        return new Color(0, 200, 255);
    }
}
