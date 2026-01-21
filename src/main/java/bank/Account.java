package bank;

public class Account {
    // owner가 변경되어야 하는 요구사항이 없으므로 final 키워드 적용
    private final String owner;
    private int balance;

    {
        System.out.println("Account created");
    }

    public Account(String owner) {
        this.owner = owner;
    }

    public Account(String owner, int balance) {
        // 1. 잔액은 항상 0 이상이어야 한다
        this.balance = Math.max(balance, 0);
        this.owner = owner;
    }

    void deposit(int amount) {
        // 2. 입금/출금 금액이 0 이하일 경우 동작을 무시한다.
        if (amount <= 0) return;
        balance += amount;
    }

    void withdraw(int amount) {
        // 2. 입금/출금 금액이 0 이하일 경우 동작을 무시한다.
        if (amount <= 0) return;

        int exceptBalance = balance - amount;

        // 1. 잔액은 항상 0 이상이어야 한다
        if ( 0 <= exceptBalance ) {
            balance = exceptBalance;
        }
    }

    int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return owner+"님의 계좌 잔액: "+balance;
    }
}
