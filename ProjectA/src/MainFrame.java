import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Budget App");
        setSize(720, 1280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new SpendingPanel(), "Spending");
        mainPanel.add(new BudgetingPanel(), "Budget");
        mainPanel.add(new SettingsPanel(), "Settings");

        add(mainPanel, BorderLayout.CENTER);
        add(new Navigation(cardLayout, mainPanel), BorderLayout.SOUTH);
        setVisible(true);
    }

}
