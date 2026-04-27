import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    // -------- Constructor tests --------
    @Test
    void constructor_setsInitialBalance() {
        BankAccount account = new BankAccount(100.0);
        assertEquals(100.0, account.getBalance());
    }

    // Edge case: negative initial balance (allowed by current implementation)
    @Test
    void constructor_allowsNegativeInitialBalance_edgeCase() {
        BankAccount account = new BankAccount(-50.0);
        assertEquals(-50.0, account.getBalance());
    }

    // -------- deposit tests --------
    @Test
    void deposit_increasesBalance() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(25.0);
        assertEquals(125.0, account.getBalance());
    }

    // Edge case: depositing zero should not change balance
    @Test
    void deposit_zeroAmount_edgeCase() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(0.0);
        assertEquals(100.0, account.getBalance());
    }

    // -------- withdraw tests --------
    @Test
    void withdraw_decreasesBalance() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance());
    }

    // Edge case: withdrawing more than balance (overdraft allowed in current
    // design)
    @Test
    void withdraw_overdraft_edgeCase() {
        BankAccount account = new BankAccount(50.0);
        account.withdraw(100.0);
        assertEquals(-50.0, account.getBalance());
    }

    // -------- getBalance tests --------
    @Test
    void getBalance_returnsCurrentBalance() {
        BankAccount account = new BankAccount(200.0);
        assertEquals(200.0, account.getBalance());
    }

    // Edge case: balance is zero
    @Test
    void getBalance_zeroBalance_edgeCase() {
        BankAccount account = new BankAccount(0.0);
        assertEquals(0.0, account.getBalance());
    }
}