import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class BudgetingManager {

    private final EnumMap<Category, BigDecimal> budgets;
    private final EnumMap<Category, BigDecimal> spent;

    /**
     * Initializes budget and spent maps with zero values for every category.
     */
    public BudgetingManager() {
        budgets = new EnumMap<>(Category.class);
        spent = new EnumMap<>(Category.class);
        for (Category category : Category.values()) {
            budgets.put(category, BigDecimal.ZERO);
            spent.put(category, BigDecimal.ZERO);
        }

    }

    /**
     * Sets the budget limit for a category.
     *
     * @param category the budget category to update
     * @param mAmount the limit amount to store
     */
    public void setBudget(Category category, BigDecimal mAmount) {
        if (category == null || mAmount == null || mAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid budget input");
        }

        mAmount = mAmount.setScale(2, RoundingMode.HALF_UP);
        budgets.put(category, mAmount);

    }

    /**
     * Adds a spending amount to a category.
     *
     * @param category the category where spending occurred
     * @param amount the amount spent
     */
    public void recordSpending(Category category, BigDecimal amount) {
        if (category == null || amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid spending input");
        }

        BigDecimal normalized = amount.setScale(2, RoundingMode.HALF_UP);
        BigDecimal current = spent.getOrDefault(category, BigDecimal.ZERO);
        spent.put(category, current.add(normalized));
    }

    /**
     * Converts category text into the matching enum value.
     *
     * @param selectedCategory category name from UI
     * @return matching {@link Category} enum value
     */
    public Category toCategory(String selectedCategory) {
        return Category.valueOf(selectedCategory);
    }

    /**
     * Returns all budget limits by category.
     *
     * @return read-only map of category budgets
     */
    public Map<Category, BigDecimal> getAllBudgets() {
        return Collections.unmodifiableMap(budgets);

    }

    /**
     * Returns the mutable backing budget map.
     *
     * @return mutable budget map
     */
    public EnumMap<Category, BigDecimal> getBudgets() {
        return budgets;
    }

    /**
     * Returns total spent for one category.
     *
     * @param category category to query
     * @return spent total for the category
     */
    public BigDecimal getSpent(Category category) {
        return spent.getOrDefault(category, BigDecimal.ZERO);
    }

    /**
     * Returns remaining budget for one category.
     *
     * @param category category to query
     * @return budget limit minus total spent
     */
    public BigDecimal getRemaining(Category category) {
        return budgets.getOrDefault(category, BigDecimal.ZERO)
                .subtract(spent.getOrDefault(category, BigDecimal.ZERO));
    }

    /**
     * Returns all spending totals by category.
     *
     * @return read-only map of spent totals
     */
    public Map<Category, BigDecimal> getAllSpent() {
        return Collections.unmodifiableMap(spent);
    }

}
