import javax.swing.*;
import java.awt.*;

public class Navigation extends JPanel {

    /**
     * Creates bottom navigation buttons and wires card switching actions.
     *
     * @param cardLayout shared card layout used by the main container
     * @param mainPanel  container that hosts all app screens
     */
    public Navigation(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new GridLayout(1, 3));

        JButton spendingBtn = createNavButton("Spending");
        spendingBtn.setSize(getPreferredSize());
        JButton budgetBtn = createNavButton("Budget");

        spendingBtn.addActionListener(e -> cardLayout.show(mainPanel, "Spending"));
        budgetBtn.addActionListener(e -> cardLayout.show(mainPanel, "Budget"));

        add(spendingBtn);
        add(budgetBtn);

    }

    /**
     * Creates a navigation button with consistent styling.
     *
     * @param label button text
     * @return configured navigation button
     */
    private JButton createNavButton(String label) {
        return new JButton(label);
    }
}
