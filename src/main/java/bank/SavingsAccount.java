package bank;

public class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(String owner, int balance, double interestRate){
        super(owner, balance);
        this.interestRate=interestRate;
    }

    @Override
    void deposit(int amount){
        super.deposit((int) (amount * (1+this.interestRate)));
    }
}
