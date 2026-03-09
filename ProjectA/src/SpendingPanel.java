import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class SpendingPanel extends JPanel {
    private static final Color BG_MAIN = new Color(72, 78, 84);
    private static final Color BG_TOP = new Color(60, 66, 72);
    private static final Color BG_CARD = new Color(88, 95, 102);
    private static final Color TEXT_PRIMARY = new Color(242, 244, 246);

    private JPanel tPanel;
    private JButton spendBtn;
    private JDialog budgets;
    private final TransactionManager transactionManager;
    private final SpendingController spendingController;
    private final Runnable onTransactionSaved;
    private JPanel pieChartPanel;
    private JPanel transactionListPanel;
    private JScrollPane transactionScroll;

    /**
     * Creates a spending panel with standalone managers.
     */
    public SpendingPanel() {
        this(new TransactionManager(new BudgetingManager()), null);
    }

    /**
     * Creates a spending panel with a provided transaction manager.
     *
     * @param transactionManager manager used to store and summarize transactions
     */
    public SpendingPanel(TransactionManager transactionManager) {
        this(transactionManager, null);
    }

    /**
     * Creates a spending panel and optional callback for post-save refresh actions.
     *
     * @param transactionManager manager used for transaction storage
     * @param onTransactionSaved callback invoked after a successful save
     */
    public SpendingPanel(TransactionManager transactionManager, Runnable onTransactionSaved) {
        this.transactionManager = transactionManager;
        this.spendingController = new SpendingController(transactionManager);
        this.onTransactionSaved = onTransactionSaved;
        setLayout(new BorderLayout());
        setBackground(BG_MAIN);
        spendingTopPanel();
        spendingBodyPanel();
        refreshDisplay();
    }

    /**
     * Builds the top toolbar with the add/modify transaction button.
     */
    public void spendingTopPanel() {
        tPanel = new JPanel();
        tPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tPanel.setBackground(BG_TOP);
        spendBtn = new JButton("Add/Modify Transaction");
        tPanel.add(spendBtn);
        spendBtn.addActionListener(e -> modifyTransaction());

        add(tPanel, BorderLayout.NORTH);
    }

    /**
     * Builds the pie chart area and scrollable transaction history area.
     */
    private void spendingBodyPanel() {
        JPanel bodyPanel = new JPanel(new BorderLayout());
        bodyPanel.setBackground(BG_MAIN);

        pieChartPanel = new PieChartPanel();
        pieChartPanel.setBackground(BG_CARD);
        pieChartPanel.setPreferredSize(new Dimension(600, 320));
        bodyPanel.add(pieChartPanel, BorderLayout.CENTER);

        transactionListPanel = new JPanel();
        transactionListPanel.setLayout(new BoxLayout(transactionListPanel, BoxLayout.Y_AXIS));
        transactionListPanel.setBackground(BG_MAIN);

        transactionScroll = new JScrollPane(transactionListPanel);
        transactionScroll.setBorder(BorderFactory.createEmptyBorder());
        transactionScroll.getViewport().setBackground(BG_MAIN);
        transactionScroll.setPreferredSize(new Dimension(600, 220));
        transactionScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        transactionScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        bodyPanel.add(transactionScroll, BorderLayout.SOUTH);

        add(bodyPanel, BorderLayout.CENTER);
    }

    /**
     * Opens the add transaction dialog.
     */
    public void modifyTransaction() {
        Window mainFrame = SwingUtilities.getWindowAncestor(this);
        budgets = new JDialog(mainFrame, "Add Transaction", Dialog.ModalityType.APPLICATION_MODAL);
        budgets.setLayout(new BorderLayout());
        budgets.getContentPane().removeAll();
        budgets.getContentPane().setBackground(BG_MAIN);

        JList<String> categoryList = new JList<>(createCategoryListModel());
        categoryList.setBackground(BG_CARD);
        categoryList.setForeground(TEXT_PRIMARY);
        categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane categoryScroll = new JScrollPane(categoryList);
        categoryScroll.getViewport().setBackground(BG_CARD);
        categoryScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        categoryScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        budgets.add(categoryScroll, BorderLayout.CENTER);

        JPanel amountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        amountPanel.setBackground(BG_TOP);
        amountPanel.add(new JLabel("Amount:"));
        JTextField amountField = new JTextField(12);
        amountPanel.add(amountField);
        budgets.add(amountPanel, BorderLayout.NORTH);

        JButton selectBtn = new JButton("Select");
        selectBtn.addActionListener(e -> submitTransaction(categoryList.getSelectedValue(), amountField.getText()));

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(BG_TOP);
        bottomPanel.add(selectBtn);
        budgets.add(bottomPanel, BorderLayout.SOUTH);

        budgets.pack(); // or pack()
        budgets.setLocationRelativeTo(this);
        budgets.setVisible(true);
    }

    /**
     * Validates user input and saves a transaction when valid.
     *
     * @param selectedCategory selected category text
     * @param amountText raw amount text
     */
    private void submitTransaction(String selectedCategory, String amountText) {
        String validationError = spendingController.recordTransaction(selectedCategory, amountText);
        if (validationError != null) {
            showValidationMessage(validationError);
            return;
        }

        refreshDisplay();
        if (onTransactionSaved != null) {
            onTransactionSaved.run();
        }
        budgets.dispose();
    }

    /**
     * Rebuilds the transaction history list and repaints the pie chart.
     */
    private void refreshDisplay() {
        transactionListPanel.removeAll();

        JLabel title = new JLabel("Transaction History");
        title.setFont(new Font("SansSerif", Font.BOLD, 16));
        title.setForeground(TEXT_PRIMARY);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        transactionListPanel.add(title);
        transactionListPanel.add(Box.createVerticalStrut(8));

        List<String> history = transactionManager.getTransactionLog();
        if (history.isEmpty()) {
            JLabel empty = new JLabel("No transactions yet");
            empty.setForeground(TEXT_PRIMARY);
            empty.setAlignmentX(Component.LEFT_ALIGNMENT);
            transactionListPanel.add(empty);
        }

        for (int i = history.size() - 1; i >= 0; i--) {
            JLabel row = new JLabel(history.get(i));
            row.setForeground(TEXT_PRIMARY);
            row.setAlignmentX(Component.LEFT_ALIGNMENT);
            transactionListPanel.add(row);
        }

        transactionListPanel.revalidate();
        transactionListPanel.repaint();
        pieChartPanel.repaint();
    }

    /**
     * Creates the category model for transaction selection.
     *
     * @return list model populated with all categories
     */
    private DefaultListModel<String> createCategoryListModel() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Category category : Category.values()) {
            listModel.addElement(category.name());
        }
        return listModel;
    }

    /**
     * Displays input validation feedback in the transaction dialog.
     *
     * @param message message text to display
     */
    private void showValidationMessage(String message) {
        JOptionPane.showMessageDialog(budgets, message);
    }

    /**
     * Pie chart renderer for transaction distribution by category.
     */
    private class PieChartPanel extends JPanel {
        private final Color[] palette = {
                new Color(31, 119, 180), new Color(255, 127, 14), new Color(44, 160, 44),
                new Color(214, 39, 40), new Color(148, 103, 189), new Color(140, 86, 75),
                new Color(227, 119, 194), new Color(127, 127, 127), new Color(188, 189, 34),
                new Color(23, 190, 207)
        };

        /**
         * Paints the pie chart, inline slice labels, and legend.
         *
         * @param g graphics context
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Map<Category, BigDecimal> values = transactionManager.getAllTransactions();
            BigDecimal total = BigDecimal.ZERO;
            for (BigDecimal amount : values.values()) {
                if (amount != null && amount.compareTo(BigDecimal.ZERO) > 0) {
                    total = total.add(amount);
                }
            }

            int diameter = Math.min(getWidth(), getHeight()) - 80;
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;

            if (total.compareTo(BigDecimal.ZERO) == 0) {
                g2.setColor(Color.GRAY);
                g2.drawOval(x, y, diameter, diameter);
                g2.drawString("No transactions yet", x + diameter / 2 - 50, y + diameter / 2);
                g2.dispose();
                return;
            }

            int startAngle = 0;
            int i = 0;
            int legendX = 24;
            int legendY = 24;
            int legendBox = 12;
            int legendGap = 18;
            for (Map.Entry<Category, BigDecimal> entry : values.entrySet()) {
                BigDecimal amount = entry.getValue();
                if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
                    continue;
                }

                double percent = amount.divide(total, 6, RoundingMode.HALF_UP).doubleValue();
                int arcAngle = (int) Math.round(percent * 360);

                Color sliceColor = palette[i % palette.length];
                g2.setColor(sliceColor);
                g2.fillArc(x, y, diameter, diameter, startAngle, arcAngle);

                // Draw label inside slice for readable segment sizes.
                if (percent >= 0.05) {
                    int midAngle = startAngle + (arcAngle / 2);
                    double radians = Math.toRadians(-midAngle);
                    int labelRadius = (int) (diameter * 0.30);
                    int labelX = x + (diameter / 2) + (int) (Math.cos(radians) * labelRadius);
                    int labelY = y + (diameter / 2) + (int) (Math.sin(radians) * labelRadius);

                    String sliceLabel = String.format("%s %.1f%%",
                            entry.getKey().name().replace('_', ' '),
                            percent * 100.0);
                    g2.setColor(Color.BLACK);
                    g2.drawString(sliceLabel, labelX - 24, labelY);
                }

                startAngle += arcAngle;

                // Draw legend entry: color chip + category name + percentage.
                g2.setColor(sliceColor);
                g2.fillRect(legendX, legendY + (i * legendGap), legendBox, legendBox);
                g2.setColor(Color.BLACK);
                String label = String.format("%s (%.1f%%)", entry.getKey().name(), percent * 100.0);
                g2.drawString(label, legendX + legendBox + 8, legendY + (i * legendGap) + legendBox - 1);
                i++;
            }

            g2.setColor(Color.BLACK);
            g2.drawOval(x, y, diameter, diameter);
            g2.dispose();
        }
    }
}
