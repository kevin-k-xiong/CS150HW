import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    /**
     * Builds the main app window, panel routing, and shared managers.
     */
    public MainFrame() {
        setTitle("Budget App");
        setSize(720, 1280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        BudgetingManager budgetingManager = new BudgetingManager();
        BudgetingPanel budgetingPanel = new BudgetingPanel(budgetingManager);
        TransactionManager transactionManager = new TransactionManager(budgetingManager);
        SpendingPanel spendingPanel = new SpendingPanel(transactionManager, budgetingPanel::displayBudget);

        mainPanel.add(spendingPanel, "Spending");
        mainPanel.add(budgetingPanel, "Budget");

        add(mainPanel, BorderLayout.CENTER);
        add(new Navigation(cardLayout, mainPanel), BorderLayout.SOUTH);
        setVisible(true);
    }

}
