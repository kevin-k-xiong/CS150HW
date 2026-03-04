import java.math.BigDecimal;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class BudgetingManager {

    private final EnumMap<Category, BigDecimal> budgets;

    public BudgetingManager() {
        budgets = new EnumMap<>(Category.class);
        for (Category category : Category.values()) {
            budgets.put(category, BigDecimal.ZERO);
        }

    }

    public void setBudget(Category category, BigDecimal amount) {
        if (category == null || amount == null || amount < 0) {

        }

    }

}
