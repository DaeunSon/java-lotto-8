package lotto.domain.money;

public class Money {
    int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount){
        if (amount <= 0){
            throw new IllegalArgumentException("[ERROR] 금액은 0원보다 커야 합니다.");
        }
        if (amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매할 수 있습니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
