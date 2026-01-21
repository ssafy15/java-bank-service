package bank;

public class Account {
    private String owner;
    private int balance;

    Account(String owner){
        this(owner, 0);
    }

    Account(String owner, int balance){
        this.owner=owner;
        this.balance=(balance > 0) ? balance : 0;
    }

    void deposit(int amount) {
        this.balance+= (amount > 0) ? amount : 0;
    }
    void withdraw(int amount){
        this.balance-=(amount < this.balance && amount > 0) ? amount : 0;
    }
    int getBalance(){
        return this.balance;
    }

    @Override
    public String toString() {
        return this.owner + "님의 계좌 잔액: " + this.balance;
    }
}
