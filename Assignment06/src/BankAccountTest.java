import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    void testInitialBalance() {
        BankAccount acc = new BankAccount(100.0);
        assertEquals(100.0, acc.getBalance(), 0.0001);
    }

    @Test
    void testDepositNormal() {
        BankAccount acc = new BankAccount(50.0);
        acc.deposit(25.0);
        assertEquals(75.0, acc.getBalance(), 0.0001);
    }

    @Test
    void testDepositZeroEdgeCase() {
        BankAccount acc = new BankAccount(50.0);
        acc.deposit(0.0);
        assertEquals(50.0, acc.getBalance(), 0.0001);
    }

    @Test
    void testWithdrawNormal() {
        BankAccount acc = new BankAccount(100.0);
        acc.withdraw(40.0);
        assertEquals(60.0, acc.getBalance(), 0.0001);
    }

    @Test
    void testWithdrawMoreThanBalanceEdgeCase() {
        BankAccount acc = new BankAccount(50.0);
        acc.withdraw(100.0);
        assertEquals(-50.0, acc.getBalance(), 0.0001);
    }

    @Test
    void testNegativeDepositEdgeCase() {
        BankAccount acc = new BankAccount(100.0);
        acc.deposit(-20.0);
        assertEquals(80.0, acc.getBalance(), 0.0001);
    }

    @Test
    void testNegativeWithdrawEdgeCase() {
        BankAccount acc = new BankAccount(100.0);
        acc.withdraw(-30.0);
        assertEquals(130.0, acc.getBalance(), 0.0001);
    }

    @Test
    void testMultipleOperations() {
        BankAccount acc = new BankAccount(0.0);
        acc.deposit(10.0);
        acc.withdraw(4.0);
        acc.deposit(2.0);
        assertEquals(8.0, acc.getBalance(), 0.0001);
    }
}