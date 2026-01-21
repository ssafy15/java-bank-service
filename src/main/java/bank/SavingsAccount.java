package bank;

public class SavingsAccount extends Account {
    private final double interestRate;

    public SavingsAccount(String owner, int balance, double interestRate){
        super(owner, balance);
        this.interestRate = 1.0 + interestRate;
    }

    @Override
    public void deposit(int amount) {
        balance = balance + (int)(amount * interestRate);
    }
}
