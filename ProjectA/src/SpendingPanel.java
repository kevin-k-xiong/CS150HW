import javax.swing.*;
import java.awt.*;

public class SpendingPanel extends JPanel {

    private JPanel tPanel;
    private JButton spendBtn;
    private JScrollPane spendList;
    private JDialog budgets;

    public SpendingPanel() {
        setLayout(new BorderLayout());
        spendingTopPanel();
    }

    public void spendingTopPanel() {
        tPanel = new JPanel();
        tPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        spendBtn = new JButton("Add/Modify Transaction");
        tPanel.add(spendBtn);
        spendBtn.addActionListener(e -> modifyTransaction());

        add(tPanel, BorderLayout.NORTH);
    }

    public void modifyTransaction() {
        Window mainFrame = SwingUtilities.getWindowAncestor(this);
        budgets = new JDialog(mainFrame, "Choose a Catagory", Dialog.ModalityType.APPLICATION_MODAL);
        budgets.setLayout(new BorderLayout());
        budgets.getContentPane().removeAll();
        budgets.pack(); // or pack()
        budgets.setLocationRelativeTo(this);
        budgets.setVisible(true);
    }
}
