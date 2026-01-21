package bank;

public class  SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String owner, int balance, double interestRate) {
        super(owner, balance);
        this.interestRate = interestRate;
    }

    // 메서드 재정의
    @Override
    public void deposit(int amount) {
        this.balance = (int) (this.balance + this.balance * (1 + interestRate));
    }
}
