package bank;

public class BankService {
    private static final int MAX_SIZE = 10;

    private Account[] accounts;
    private int count;

    BankService() {
        count = 0;
        accounts = new Account[MAX_SIZE];
    }

    public void addAccount(Account account) {
        // 3. 계좌 최대 개수를 초과하면 추가를 무시한다.
        if (count < 10) {
            accounts[count++] = account;
        }
    }

    public int getTotalBalance() {
        int total = 0;
        for (Account account: accounts) {
            if (account == null) break;
            total += account.getBalance();
        }
        return total;
    }
}
