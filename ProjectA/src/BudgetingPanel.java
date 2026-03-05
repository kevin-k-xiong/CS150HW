import java.awt.*;
import java.math.BigDecimal;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class BudgetingPanel extends JPanel {
    private static final Color BG_MAIN = new Color(72, 78, 84);
    private static final Color BG_TOP = new Color(60, 66, 72);
    private static final Color BG_CARD = new Color(88, 95, 102);
    private static final Color TEXT_PRIMARY = new Color(242, 244, 246);
    private static final Color TEXT_SECONDARY = new Color(222, 226, 230);

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

    // Panel used to display all budgets
    private JPanel budgetDisplayPanel;

    // Text field where user types the budget amount.
    private JTextField amount;

    // Small panel that groups the "Budget" label and amount text field.
    private JPanel amountInput;

    private final BudgetingManager bManager;

    /**
     * Creates a budgeting panel with its own manager instance.
     */
    public BudgetingPanel() {
        this(new BudgetingManager());
    }

    /**
     * Creates a budgeting panel linked to a shared budgeting manager.
     *
     * @param budgetingManager manager used for budget persistence and summaries
     */
    public BudgetingPanel(BudgetingManager budgetingManager) {
        this.bManager = budgetingManager;
        setLayout(new BorderLayout()); // Control layout
        setBackground(BG_MAIN);
        budgetingTopPanel();
        budgetingLowerPanel();

    }

    /**
     * Creates the top toolbar and wires the add/modify action.
     */
    private void budgetingTopPanel() {
        tPanel = new JPanel();
        tPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tPanel.setBackground(BG_TOP);
        changeBtn = new JButton("Add/Modify Budget");
        tPanel.add(changeBtn);

        // Open budget popup when user clicks the top button.
        changeBtn.addActionListener(e -> addOrModify());

        add(tPanel, BorderLayout.NORTH);

    }

    /**
     * Creates the lower scrollable area where budget cards are displayed.
     */
    private void budgetingLowerPanel() {
        budgetDisplayPanel = new JPanel();
        budgetDisplayPanel.setLayout(new BoxLayout(budgetDisplayPanel, BoxLayout.Y_AXIS));
        budgetDisplayPanel.setBorder(new EmptyBorder(8, 10, 8, 10));
        budgetDisplayPanel.setBackground(BG_MAIN);

        JScrollPane displayScroll = new JScrollPane(budgetDisplayPanel);
        displayScroll.getViewport().setBackground(BG_MAIN);
        displayScroll.setBorder(BorderFactory.createEmptyBorder());
        displayBudget();
        add(displayScroll, BorderLayout.CENTER); // lower/main area of BudgetingPanel
    }

    /**
     * Rebuilds and redraws the budget summary list.
     */
    public void displayBudget() {
        budgetDisplayPanel.removeAll();

        JLabel title = new JLabel("Budget Summary");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(TEXT_PRIMARY);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        budgetDisplayPanel.add(title);
        budgetDisplayPanel.add(Box.createVerticalStrut(8));

        displayHelper();

        budgetDisplayPanel.revalidate();
        budgetDisplayPanel.repaint();
    }

    /**
     * Renders one card per category with limit, spent, and remaining amounts.
     */
    public void displayHelper() {
        Map<Category, BigDecimal> allBudgets = bManager.getAllBudgets();

        for (Map.Entry<Category, BigDecimal> entry : allBudgets.entrySet()) {
            Category category = entry.getKey();
            BigDecimal limit = entry.getValue();
            BigDecimal spent = bManager.getSpent(category);
            BigDecimal remaining = bManager.getRemaining(category);

            JPanel card = createBudgetCard(category, limit, spent, remaining);
            budgetDisplayPanel.add(card);
            budgetDisplayPanel.add(Box.createVerticalStrut(8));
        }

    }

    /**
     * Shows the window to modify the budget categories
     */
    private void addOrModify() {
        Window mainFrame = SwingUtilities.getWindowAncestor(this);
        catalog = new JDialog(mainFrame, "Choose a Catagory", Dialog.ModalityType.APPLICATION_MODAL);
        catalog.setLayout(new BorderLayout());
        catalog.getContentPane().removeAll();
        catalog.getContentPane().setBackground(BG_MAIN);

        catagoryList();

        catalog.pack(); // Sizes dialog to fit added components.
        catalog.setLocationRelativeTo(this); // Centers popup relative to current panel.
        catalog.setVisible(true);

    }

    /**
     * Shows the list of categories
     */
    public void catagoryList() {
        budgetItems = new JList<>(createCategoryListModel());
        budgetItems.setBackground(BG_CARD);
        budgetItems.setForeground(TEXT_PRIMARY);

        // User can select only one category at a time.
        budgetItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        budgetList = new JScrollPane(budgetItems);
        budgetList.getViewport().setBackground(BG_CARD);
        budgetList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        budgetList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        catalog.add(budgetList, BorderLayout.CENTER);

        enterBudget();
        addSelectBtn();

    }

    // Get it so the select buttn actually chooses the selection.
    /**
     * Creates the dialog submit button and wires validation/save behavior.
     */
    private void addSelectBtn() {
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
        bottomPanel.setBackground(BG_TOP);
        bottomPanel.add(selectBtn);

        catalog.add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Validates the user's category selection and amount input.
     *
     * @param selectedCategory category chosen in the list
     * @param amountText       text entered for budget amount
     */
    private void checkIfValid(String selectedCategory, String amountText) {
        BigDecimal amountValue = parsePositiveAmount(amountText);
        validaterCont(selectedCategory, amountValue);
    }

    /**
     * Finalizes budget save when validation succeeds.
     *
     * @param selectedCategory selected category text
     * @param amountValue parsed amount, or {@code null} when invalid
     */
    private void validaterCont(String selectedCategory, BigDecimal amountValue) {
        if (selectedCategory == null) {
            showValidationMessage("Select a category.");
            return;
        }
        if (amountValue == null) {
            showValidationMessage("Enter a valid amount greater than 0.");
            return;
        }

        Category enumCategory = bManager.toCategory(selectedCategory);
        bManager.setBudget(enumCategory, amountValue);
        displayBudget();
        catalog.dispose();
    }

    /**
     * Adds amount input controls to the budget dialog.
     */
    private void enterBudget() {
        // Row at top of popup for budget amount input.
        amountInput = new JPanel(new FlowLayout(FlowLayout.LEFT));
        amountInput.setBackground(BG_TOP);
        amountInput.add(new JLabel("Enter a Budget"));

        // Text field where user types number (12 columns wide).
        amount = new JTextField(12);
        amountInput.add(amount);

        catalog.add(amountInput, BorderLayout.NORTH);
    }

    /**
     * Builds the category list model shown in the budget dialog.
     *
     * @return list model with all configurable categories
     */
    private DefaultListModel<String> createCategoryListModel() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Housing");
        listModel.addElement("Food");
        listModel.addElement("Entertainment");
        listModel.addElement("Transportation");
        listModel.addElement("Utilities");
        listModel.addElement("Savings");
        listModel.addElement("Personal_Care");
        listModel.addElement("Miscellaneous");
        listModel.addElement("Electronics");
        listModel.addElement("Clothes");
        return listModel;
    }

    /**
     * Parses and validates positive budget input text.
     *
     * @param amountText raw user input
     * @return parsed amount when valid; otherwise {@code null}
     */
    private BigDecimal parsePositiveAmount(String amountText) {
        if (amountText == null || amountText.trim().isEmpty()) {
            return null;
        }
        try {
            BigDecimal parsed = new BigDecimal(amountText.trim());
            return parsed.compareTo(BigDecimal.ZERO) > 0 ? parsed : null;
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    /**
     * Shows a validation message in the budget dialog.
     *
     * @param message message text to display
     */
    private void showValidationMessage(String message) {
        JOptionPane.showMessageDialog(catalog, message);
    }

    /**
     * Creates one budget summary card for the given category values.
     *
     * @param category category being rendered
     * @param limit configured budget limit
     * @param spent total spent amount
     * @param remaining remaining budget amount
     * @return configured budget summary card
     */
    private JPanel createBudgetCard(Category category, BigDecimal limit, BigDecimal spent, BigDecimal remaining) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setBackground(BG_CARD);
        card.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(210, 210, 210), 1),
                new EmptyBorder(8, 10, 8, 10)));
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 110));
        card.setPreferredSize(new Dimension(0, 110));

        JLabel categoryLabel = new JLabel(category.name().replace('_', ' '));
        categoryLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        categoryLabel.setForeground(TEXT_PRIMARY);
        categoryLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel limitLabel = new JLabel("Limit: $" + limit);
        limitLabel.setForeground(TEXT_SECONDARY);
        limitLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel spentLabel = new JLabel("Spent: $" + spent);
        spentLabel.setForeground(TEXT_SECONDARY);
        spentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel remainingLabel = new JLabel("Remaining: $" + remaining);
        remainingLabel.setForeground(TEXT_SECONDARY);
        remainingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(categoryLabel);
        card.add(Box.createVerticalStrut(4));
        card.add(limitLabel);
        card.add(spentLabel);
        card.add(remainingLabel);
        return card;
    }

}
