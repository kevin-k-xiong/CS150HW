import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
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

    public void setBudget(Category category, BigDecimal mAmount) {
        mAmount = mAmount.setScale(2, RoundingMode.HALF_UP);
        budgets.put(category, mAmount);

    }

    public void popUpNotif() {
        popUp = new JLabel("Please enter an amount.");

    }

    public Category toCategory(String selectedCategory) {
        return Category.valueOf(selectedCategory);
    }

}
