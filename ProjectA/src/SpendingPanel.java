import javax.swing.*;
import java.awt.*;

public class SpendingPanel extends JPanel {

    private JPanel tPanel;
    private JButton spendBtn;

    public SpendingPanel() {
        setLayout(new BorderLayout());
        spendingTopPanel();
    }

    public void spendingTopPanel() {
        tPanel = new JPanel();
        tPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        spendBtn = new JButton("Add/Modify Transaction");
        tPanel.add(spendBtn);

        add(tPanel, BorderLayout.NORTH);
    }
}
