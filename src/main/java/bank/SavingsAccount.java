package bank;

public class SavingsAccount extends Account{
	private double interestRate;

	public SavingsAccount(String owner, int balance, double interestRate) {
		super(owner, balance);
		this.interestRate = interestRate;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void deposit(int amount) {
		balance += amount*(interestRate+1); 
	}
	
	
	
}
