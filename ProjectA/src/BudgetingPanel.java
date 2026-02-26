import java.awt.*;
import javax.swing.*;

public class BudgetingPanel extends JPanel {

    private JScrollPane budgetList;
    private JButton changeBtn;
    private JPanel tPanel;

    public BudgetingPanel() {
        setLayout(new BorderLayout()); // Control layout
        budgetingTopPanel();
    }

    public void budgetingTopPanel() {
        tPanel = new JPanel();
        tPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        changeBtn = new JButton("Add/Modify Budget");
        tPanel.add(changeBtn);

        add(tPanel, BorderLayout.NORTH);

    }

    public void displayBudget() {
        budgetList = new JScrollPane();
        // Finish and impokment the display category for budgeting
    }

}