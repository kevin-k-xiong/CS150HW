import java.awt.*;
import javax.swing.*;

public class BudgetingPanel extends JPanel {

    private JScrollPane budgetList;
    private JButton changeBtn;
    private JPanel tPanel;
    private JList<String> budgetItems;
    private JDialog catalog;
    private JList list;

    public BudgetingPanel() {
        setLayout(new BorderLayout()); // Control layout
        budgetingTopPanel();
        displayBudget();
    }

    public void budgetingTopPanel() {
        tPanel = new JPanel();
        tPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        changeBtn = new JButton("Add/Modify Budget");
        tPanel.add(changeBtn);
        changeBtn.addActionListener(e -> addOrModify());

        add(tPanel, BorderLayout.NORTH);

    }

    public void displayBudget() {

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Housing");
        listModel.addElement("Food");
        listModel.addElement("Transportation");
        listModel.addElement("Utilities");
        listModel.addElement("Savings");

        budgetItems = new JList<>(listModel);
        budgetItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        budgetList = new JScrollPane(budgetItems);
        budgetList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        budgetList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(budgetList, BorderLayout.CENTER);

    }

    public void addOrModify() {
        Window mainFrame = SwingUtilities.getWindowAncestor(this);
        catalog = new JDialog(mainFrame, "Choose a Catagory", Dialog.ModalityType.APPLICATION_MODAL);
        catalog.setSize(300, 200); // or pack()
        catalog.setLocationRelativeTo(this);
        catalog.setVisible(true);

    }

    public void catagoryList() {
        list = new JList<>(Category.values());
    }

}