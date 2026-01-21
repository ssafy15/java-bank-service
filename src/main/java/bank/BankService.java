package bank;

public class BankService {
    private static final int MAX_SIZE = 10;
    private int count = 0;
    private Account[] accounts;
    public BankService() {
        accounts = new Account[MAX_SIZE];
    }

    public Account[] getAccounts() {
        return accounts;
    }
    public void setAccounts(Account account) {
        this.accounts[count++] = account;
    }

    void addAccount(Account account){
        if(count < MAX_SIZE) setAccounts(account);
    }
    int getTotalBalance(){
        int totalBalance = 0;
        for (int i = 0; i < count; i++) {
            totalBalance += accounts[i].getBalance();
        }
        return totalBalance;
    }
}
