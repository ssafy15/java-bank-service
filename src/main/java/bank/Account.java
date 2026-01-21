package bank;

public class Account {
    private static final String CREATED_MESSAGE = "Account created";

    private String owner;
    protected int balance;

    {
        System.out.println(CREATED_MESSAGE);
    }

    public Account(String owner) {
        this(owner, 0);
    }

    public Account(String owner, int balance) {
        int verifiedBalance = changeNotNegative(balance);
        this.owner = owner;
        this.balance = verifiedBalance;
    }

    private int changeNotNegative(int balance) {
        return balance < 0 ? 0 : balance;
    }

    public void deposit(int amount) {
        if(isNotPositive(amount))
            return;
        balance += amount;
    }

    public void withdraw(int amount){
        if(isNotPositive(amount))
           return;
        if(isWithdrawable(amount))
            balance -= amount;
    }

    private boolean isNotPositive(int amount) {
        return amount <= 0;
    }

    private boolean isWithdrawable(int amount) {
        return balance >= amount;
    }

    public int getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        return owner + "님의 계좌 잔액: " + balance;
    }
}
