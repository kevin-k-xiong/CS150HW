import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class BudgetingPanel extends JPanel {

    private JScrollPane budgetList;
    private JButton changeBtn;
    private JPanel tPanel;
    private JList<String> budgetItems;
    private JDialog catalog;
    private JButton selectBtn;

    public BudgetingPanel() {
        setLayout(new BorderLayout()); // Control layout
        budgetingTopPanel();
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

    }

    public void addOrModify() {
        Window mainFrame = SwingUtilities.getWindowAncestor(this);
        catalog = new JDialog(mainFrame, "Choose a Catagory", Dialog.ModalityType.APPLICATION_MODAL);
        catalog.setLayout(new BorderLayout());
        catalog.getContentPane().removeAll();
        catagoryList();
        catalog.pack(); // or pack()
        catalog.setLocationRelativeTo(this);
        catalog.setVisible(true);

    }

    public void catagoryList() { // Fix so that catagorylisdt shows pn when the user presses the add butotn
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

        catalog.add(budgetList, BorderLayout.CENTER);
        addSelectBtn();

    }

    // Get it so the select buttn actually chooses the selection.
    public void addSelectBtn() {
        selectBtn = new JButton("Select");

        selectBtn.addActionListener(e -> {
            String selectedCategory = budgetItems.getSelectedValue();
            if (budgetItems.getSelectedValue() != null) {
                catalog.dispose();
            }
            // TODO: use selectedCategory (save/update budget, etc.)
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(selectBtn);

        catalog.add(bottomPanel, BorderLayout.SOUTH);
    }

}