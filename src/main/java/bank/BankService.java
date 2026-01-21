package bank;

public class BankService {
    private Account[] accounts;
    private final int MAX_ACCOUNT;
    private int size;

    BankService(){
        MAX_ACCOUNT=10;
        accounts=new Account[MAX_ACCOUNT];
        size=0;
    }

    void addAccount(Account account){
        if(size < MAX_ACCOUNT) {
            accounts[size++] = account;
        }
    }

    int getTotalBalance(){
        int res=0;
        for(int i=0; i<size; i++){
            res+=accounts[i].getBalance();
        }
        return res;
    }
}
