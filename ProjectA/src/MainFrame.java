import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Budget App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new Spending(), "Spending");
        mainPanel.add(new Budgeting(), "Budget");
        mainPanel.add(new Settings(), "Settings");

        add(mainPanel, BorderLayout.CENTER);
        add(new Navigation(cardLayout, mainPanel), BorderLayout.SOUTH);
        setVisible(true);
    }

}
