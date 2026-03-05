import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import javax.swing.*;

public class BudgetingManager {

    private JLabel popUp;

    private final EnumMap<Category, BigDecimal> budgets;

    public BudgetingManager() {
        budgets = new EnumMap<>(Category.class);
        for (Category category : Category.values()) {
            budgets.put(category, BigDecimal.ZERO);
        }

    }

    public void setBudget(Category category, BigDecimal amount) {

        amount = amount.setScale(2, RoundingMode.HALF_UP);

        budgets.put(category, amount);

    }

    public void popUpNotif() {
        popUp = new JLabel("Please enter an amount.");

    }

}
