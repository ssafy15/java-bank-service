package bank;

public class SavingsAccount extends Account {
    double interestRate;

    public SavingsAccount(String name, int balance ,double interestRate) {
        super(name,balance);
        setInterestRate(interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(int money) {
        super.deposit((int) (money * this.interestRate) + getBalance());
    }
}
