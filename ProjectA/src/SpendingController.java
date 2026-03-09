import java.math.BigDecimal;

public class SpendingController {
    private final TransactionManager transactionManager;

    public SpendingController(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * Validates and records a transaction.
     *
     * @param selectedCategory category name from the UI
     * @param amountText amount text from the UI
     * @return null when save succeeds; otherwise a validation error message
     */
    public String recordTransaction(String selectedCategory, String amountText) {
        if (selectedCategory == null) {
            return "Select a category.";
        }

        BigDecimal amountValue = parseNonNegativeAmount(amountText);
        if (amountValue == null) {
            return "Enter a valid non-negative amount.";
        }

        transactionManager.recordTransaction(Category.valueOf(selectedCategory), amountValue);
        return null;
    }

    private BigDecimal parseNonNegativeAmount(String amountText) {
        if (amountText == null || amountText.trim().isEmpty()) {
            return null;
        }
        try {
            BigDecimal parsed = new BigDecimal(amountText.trim());
            return parsed.compareTo(BigDecimal.ZERO) >= 0 ? parsed : null;
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
