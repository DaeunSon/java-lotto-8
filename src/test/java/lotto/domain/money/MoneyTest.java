package lotto.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Money(1500);
        });
    }

    @DisplayName("구입 금액이 0원 이하이면 예외가 발생한다.")
    @Test
    void 구입_금액이_0원_이하면_예외가_발생한다() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Money(0);
        });
    }
}