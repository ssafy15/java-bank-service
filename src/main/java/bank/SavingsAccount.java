package bank;

public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount(String owner, int balance, double interestRate) {
        super(owner, balance);
        this.interestRate = interestRate;
    }

    @Override
    void deposit(int amount) {
        super.balance += (int) ((1.0 + interestRate) * (double) amount);
    }
}
