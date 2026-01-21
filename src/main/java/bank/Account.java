package bank;

public class Account {
	protected String owner;
	protected int balance;
	public Account(String owner) {
		this(owner,0);
		
	}
	
	public Account(String owner, int balance) {
		this.owner = owner;
		if (balance<0) balance = 0;
		this.balance = balance;
		initializedMessage();
	}
	
	public void initializedMessage() {
		System.out.println("Account created");
	}
	
	void deposit(int amount) {
		//예금하다.
		if (validateInputAmount(amount)) balance = balance + amount;
	}
	
	void withdraw(int amount) {
		//인출하다.
		if (validateInputAmount(amount) & balance-amount>=0) {
			balance = balance -amount;
		}
		
	}
	
	boolean validateInputAmount(int amount) {
		if (amount<0) {
			return false;
		}
		return true;
	}
	
	int getBalance() {
		return balance;
	}
	
	@Override
	public String toString() {
		return "%s님의 계좌 잔액: %d".formatted(owner, balance);
	}
	
	
}
