package bank;

public class Account {
    protected String owner;
    protected int balance;

    // 인스턴스 초기화 블록
    {
        System.out.println("Account created");
    }

    public Account(String owner) {
        this(owner, 0);
    }

    public Account(String owner, int balance) {
        this.owner = owner;
        this.balance = Math.max(balance, 0);  // 잔액이 음수로 들어올 시 0으로 초기화
    }

    public void deposit(int amount) {
        if (isInValidAmount(amount)) return;

        this.balance += amount;
    }

    public void withdraw(int amount) {
        if (isInValidAmount(amount)) return;

        // 잔액 부족이 예상될 시 무시
        if (this.balance < amount) return;

        this.balance -= amount;
    }

    // deposit, withdraw에서 동일하게 사용되는 로직이므로 메서드로 분리
    private boolean isInValidAmount(int amount) {
        return amount <= 0;
    }

    public int getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return String.format("%s님의 계좌 잔액: %d", owner, balance);
    }
}
