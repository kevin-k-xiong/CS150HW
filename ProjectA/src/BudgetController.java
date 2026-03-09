import java.math.BigDecimal;

public class BudgetController {
    private final BudgetingManager budgetingManager;

    public BudgetController(BudgetingManager budgetingManager) {
        this.budgetingManager = budgetingManager;
    }

    /**
     * Validates and saves a budget amount for the selected category.
     *
     * @param selectedCategory category name from the UI
     * @param amountText amount text from the UI
     * @return null when save succeeds; otherwise a validation error message
     */
    public String applyBudget(String selectedCategory, String amountText) {
        if (selectedCategory == null) {
            return "Select a category.";
        }

        BigDecimal amountValue = parsePositiveAmount(amountText);
        if (amountValue == null) {
            return "Enter a valid amount greater than 0.";
        }

        budgetingManager.setBudget(toCategory(selectedCategory), amountValue);
        return null;
    }

    private Category toCategory(String selectedCategory) {
        return budgetingManager.toCategory(selectedCategory);
    }

    private BigDecimal parsePositiveAmount(String amountText) {
        if (amountText == null || amountText.trim().isEmpty()) {
            return null;
        }
        try {
            BigDecimal parsed = new BigDecimal(amountText.trim());
            return parsed.compareTo(BigDecimal.ZERO) > 0 ? parsed : null;
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
