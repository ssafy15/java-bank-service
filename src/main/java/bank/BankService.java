package bank;

import java.util.Arrays;

public class BankService {
    protected final int MAX_SIZE = 10;  // 최대 10개의 계좌 허용

    private Account[] accounts = new Account[10];
    private int accountSize = 0;  // 생성된 account의 수를 추적하기 위한 변수

    public void addAccount(Account account) {
        if (accountSize == MAX_SIZE) return;  // 계좌 최대 개수 초과 시 무시

        accounts[accountSize++] = account;
    }

    public int getTotalBalance() {
        int totalBalance = 0;

        for (int i = 0; i < accountSize; i++) {
            totalBalance += accounts[i].getBalance();
        }

        return totalBalance;
    }
}
