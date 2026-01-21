package bank;

public class BankService {
    private static final int MAX_SIZE = 10;

    // accounts 자체를 재할당 받을 일이 없으므로 final 키워드 사용
    private final Account[] accounts;

    // 현재 계좌 개수를 확인하기 위한 변수
    private int count;

    BankService() {
        count = 0;
        accounts = new Account[MAX_SIZE];
    }

    public void addAccount(Account account) {
        // 3. 계좌 최대 개수를 초과하면 추가를 무시한다.
        if (count < MAX_SIZE) {
            accounts[count++] = account;
        }
    }

    public int getTotalBalance() {
        int total = 0;
        // foreach로 null check 하는 대신 count로 처리
        for (int i = 0; i < count; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }
}
