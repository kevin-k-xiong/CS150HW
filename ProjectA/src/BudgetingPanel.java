import java.awt.*;
import java.math.BigDecimal;
import javax.swing.*;

public class BudgetingPanel extends JPanel {

    // Scroll container that holds the list of budget categories in the popup.
    private JScrollPane budgetList;

    // Button on the main panel to open the add/modify budget popup.
    private JButton changeBtn;

    // Top panel for controls (currently just the change button).
    private JPanel tPanel;

    // List of category names shown inside the popup dialog.
    private JList<String> budgetItems;

    // Modal popup dialog used to choose category and type budget amount.
    private JDialog catalog;

    // Button in popup that confirms category + amount input.
    private JButton selectBtn;

    // Text field where user types the budget amount.
    private JTextField amount;

    // Small panel that groups the "Budget" label and amount text field.
    private JPanel amountInput;

    public BudgetingPanel() {
        setLayout(new BorderLayout()); // Control layout
        budgetingTopPanel();
    }

    /**
     * Creates the modify button
     */
    public void budgetingTopPanel() {
        tPanel = new JPanel();
        tPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        changeBtn = new JButton("Add/Modify Budget");
        tPanel.add(changeBtn);

        // Open budget popup when user clicks the top button.
        changeBtn.addActionListener(e -> addOrModify());

        add(tPanel, BorderLayout.NORTH);

    }

    public void displayBudget() {
        // Intended place to render saved budgets in the main panel.
    }

    /**
     * Shows the window to modify the budget categories
     */
    public void addOrModify() {
        Window mainFrame = SwingUtilities.getWindowAncestor(this);
        catalog = new JDialog(mainFrame, "Choose a Catagory", Dialog.ModalityType.APPLICATION_MODAL);
        catalog.setLayout(new BorderLayout());
        catalog.getContentPane().removeAll();

        catagoryList();

        catalog.pack(); // Sizes dialog to fit added components.
        catalog.setLocationRelativeTo(this); // Centers popup relative to current panel.
        catalog.setVisible(true);

    }

    /**
     * Shows the list of categories
     */
    public void catagoryList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Housing");
        listModel.addElement("Food");
        listModel.addElement("Transportation");
        listModel.addElement("Utilities");
        listModel.addElement("Savings");

        budgetItems = new JList<>(listModel);

        // User can select only one category at a time.
        budgetItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        budgetList = new JScrollPane(budgetItems);
        budgetList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        budgetList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        catalog.add(budgetList, BorderLayout.CENTER);

        enterBudget();
        addSelectBtn();

    }

    // Get it so the select buttn actually chooses the selection.
    public void addSelectBtn() {
        selectBtn = new JButton("Select");

        selectBtn.addActionListener(e -> {

            // Current category chosen from list.
            String selectedCategory = budgetItems.getSelectedValue();

            // Current text typed in amount field
            String amountText = amount.getText().trim();

            checkIfValid(selectedCategory, amountText);

            // TODO: use selectedCategory (save/update budget, etc.)
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(selectBtn);

        catalog.add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Validates the user's category selection and amount input.
     *
     * @param selectedCategory category chosen in the list
     * @param amountText       text entered for budget amount
     */
    public void checkIfValid(String selectedCategory, String amountText) {
        // True only if user selected a category.
        boolean hasCategory = selectedCategory != null;

        // True only if amount text is not empty.
        boolean hasText = !amountText.isEmpty();

        // Parsed numeric amount
        BigDecimal amountValue = null;

        // Tracks whether amount text is a valid number.
        boolean isNumeric = false;

        // Tracks whether amount is non-negative.
        boolean isNonNegative = false;

        if (hasText) {
            try {
                // Attempt to parse amount text into BigDecimal.
                amountValue = new BigDecimal(amountText);
                isNumeric = true;

                // True only if amount is greater than zero.
                isNonNegative = amountValue.compareTo(BigDecimal.ZERO) > 0;
            } catch (NumberFormatException ignored) {
                // Parsing failed; keep isNumeric false.
                isNumeric = false;
            }
        }

        boolean isValid = hasCategory && hasText && isNumeric && isNonNegative;

        // Close dialog only when all validation checks pass.
        if (isValid) {
            catalog.dispose();
        }
    }

    public void enterBudget() {
        // Row at top of popup for budget amount input.
        amountInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
        amountInput.add(new JLabel("Enter a Budget"));

        // Text field where user types number (12 columns wide).
        amount = new JTextField(12);
        amountInput.add(amount);

        catalog.add(amountInput, BorderLayout.NORTH);
    }

}
