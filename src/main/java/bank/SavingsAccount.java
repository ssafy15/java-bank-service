package bank;

public class SavingsAccount extends Account{
    // interestRate가 변경되어야 한다는 요구사항이 없으므로 final 키워드 사용
    // 외부에서 interestRate에 접근해야 하는 요구사항이 없으므로 접근 제한자로 private를 채택하여 캡슐화.
    private final double interestRate;

    public SavingsAccount(String owner, int balance, double interestRate) {
        super(owner, balance);
        this.interestRate = interestRate;
    }

    @Override
    void deposit(int amount) {
        final double interest = interestRate * (double) amount;
        // 올림/내림 관련된 요구사항이 없으므로 단순 타입 캐스팅
        super.deposit( (int)interest + super.getBalance() );
    }
}
