package bank;

public class BankService {
	private int MAX_COUNT = 10;
	private Account[] accounts = new Account[MAX_COUNT];
	private int size=0;
	
	void addAccount(Account account) {
		if (size<MAX_COUNT) {
			accounts[size] = account;
			size+=1;
		}
	}
	
	int getTotalBalance() {
		int cash=0;
		for(int i=0;i<size;i++) {
			cash+=accounts[i].getBalance();
		}
		return cash;
	}
	
}
