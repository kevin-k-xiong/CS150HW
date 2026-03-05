import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class TransactionManager {

    private final EnumMap<Category, BigDecimal> transactions;
    private final List<String> transactionLog;
    private final BudgetingManager budgetingManager;

    /**
     * Creates a transaction manager linked to budgeting totals.
     *
     * @param budgetingManager shared budgeting manager used for spent tracking
     */
    public TransactionManager(BudgetingManager budgetingManager) {
        this.budgetingManager = budgetingManager;
        transactions = new EnumMap<>(Category.class);
        transactionLog = new ArrayList<>();
        for (Category category : Category.values()) {
            transactions.put(category, BigDecimal.ZERO);
        }

    }

    /**
     * Records spending for a category.
     *
     * @param category transaction category
     * @param amount transaction amount
     */
    public void recordTransaction(Category category, BigDecimal amount) {
        if (category == null || amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid transaction input");
        }
        BigDecimal current = transactions.getOrDefault(category, BigDecimal.ZERO);
        transactions.put(category, current.add(amount));
        budgetingManager.recordSpending(category, amount);

        BigDecimal normalized = amount.setScale(2, RoundingMode.HALF_UP);
        transactionLog.add(category + " - $" + normalized);
    }

    /**
     * Returns accumulated totals per category for chart rendering.
     *
     * @return read-only map of category totals
     */
    public Map<Category, BigDecimal> getAllTransactions() {
        return Collections.unmodifiableMap(transactions);
    }

    /**
     * Returns a chronological log of transaction entries.
     *
     * @return read-only transaction log text
     */
    public List<String> getTransactionLog() {
        return Collections.unmodifiableList(transactionLog);
    }

}
