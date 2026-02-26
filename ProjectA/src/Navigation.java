import javax.swing.*;
import java.awt.*;

public class Navigation extends JPanel {

    public Navigation(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new GridLayout(1, 3));

        JButton spendingBtn = new JButton("Spending");
        spendingBtn.setSize(getPreferredSize());
        JButton budgetBtn = new JButton("Budget");
        JButton settingBtn = new JButton("Settings");

        spendingBtn.addActionListener(e -> cardLayout.show(mainPanel, "Spending"));
        budgetBtn.addActionListener(e -> cardLayout.show(mainPanel, "Budget"));
        settingBtn.addActionListener(e -> cardLayout.show(mainPanel, "Settings"));

        add(spendingBtn);
        add(budgetBtn);
        add(settingBtn);
    }
}
