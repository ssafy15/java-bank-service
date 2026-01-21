package bank;

public class Account {
    private String name;
    private int balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance >= 0) this.balance = balance;
    }

    public Account() {
        this("null", 0);
    }
    public Account(String name) {
        this(name, 0);
    }
    public Account(String name, int balance) {
        setName(name);
        setBalance(balance);
    }

    @Override
    public String toString() {
        return this.name +  "님의 계좌 잔액: " + this.balance;
    }

    public void deposit(int i) {
        if (i > 0) setBalance(getBalance() + i);
    }

    public void withdraw(int i) {
        setBalance(getBalance() - i);
    }
}
