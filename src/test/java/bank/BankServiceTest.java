package bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
class BankServiceTest {
    @Test
    void account_기본_생성자_테스트() {
        Account account = new Account("민호");

        assertEquals(0, account.getBalance());
        assertEquals("민호님의 계좌 잔액: 0", account.toString());
    }

    @Test
    void account_잔액_음수_초기화_방지() {
        Account account = new Account("민호", -100);

        assertEquals(0, account.getBalance());
    }

    @Test
    void deposit_및_withdraw_기본_동작() {
        Account account = new Account("민호", 100);

        account.deposit(50);
        assertEquals(150, account.getBalance());

        account.withdraw(70);
        assertEquals(80, account.getBalance());
    }

    @Test
    void withdraw_잔액_부족시_무시() {
        Account account = new Account("민호", 50);

        account.withdraw(100);

        assertEquals(50, account.getBalance());
    }

    @Test
    void deposit_0_이하_무시() {
        Account account = new Account("민호", 100);

        account.deposit(0);
        account.deposit(-10);

        assertEquals(100, account.getBalance());
    }

    @Test
    void savingsAccount_이자_적용_입금() {
        Account account = new SavingsAccount("민호", 100, 0.1);

        account.deposit(100);

        // 100 + (100 * 1.1) = 210
        assertEquals(210, account.getBalance());
    }

    @Test
    void bankService_계좌_추가_및_총합_계산() {
        BankService service = new BankService();

        service.addAccount(new Account("A", 100));
        service.addAccount(new SavingsAccount("B", 200, 0.5));

        // B 계좌는 아직 deposit 없음
        assertEquals(300, service.getTotalBalance());
    }

    @Test
    void bankService_다형성_검증() {
        BankService service = new BankService();

        Account a1 = new Account("A", 100);
        Account a2 = new SavingsAccount("B", 100, 0.2);

        service.addAccount(a1);
        service.addAccount(a2);

        a2.deposit(100); // SavingsAccount override deposit

        assertEquals(100 + 220, service.getTotalBalance());
    }

    @Test
    void bankService_최대_계좌_초과_무시() {
        BankService service = new BankService();

        for (int i = 0; i < 12; i++) {
            service.addAccount(new Account("user" + i, 10));
        }

        assertEquals(100, service.getTotalBalance()); // 10 * 10
    }

    @Test
    void instanceof_및_다운캐스팅_가능해야_함() {
        Account account = new SavingsAccount("민호", 100, 0.3);

        assertTrue(account instanceof SavingsAccount);

        SavingsAccount sa = (SavingsAccount) account;
        sa.deposit(100);

        assertEquals(230, sa.getBalance());
    }

}