package bank;

public class BankService {
    private static final int MAX_SIZE = 10;

    private Account[] accounts = new Account[MAX_SIZE];
    private int existAccountCount = 0;

    void addAccount(Account account) {
        if(account == null || existAccountCount >= MAX_SIZE)
            return;

        accounts[existAccountCount++] = account;
    }

    public int getTotalBalance(){
        int totalBalance = 0;

        for(int i = 0 ; i < existAccountCount ; i++){
            totalBalance += accounts[i].getBalance();
        }

        return totalBalance;
    }
}
