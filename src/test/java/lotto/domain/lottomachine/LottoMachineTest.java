package lotto.domain.lottomachine;

import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    @DisplayName("구입 금액으로 구매 가능한 로또 개수 계산이 올바른지 확인한다.")
    @Test
    void 구입_금액으로_구매_가능한_로또_개수_계산이_올바른지_확인한다() {
        // given
        Money money = new Money(5000);
        LottoMachine lottoMachine = new LottoMachine(money);

        // when
        int numberOfLottos = lottoMachine.countLottoTicket();

        // then
        assertEquals(5, numberOfLottos);
    }

    @DisplayName("각 발행 티켓이 6개의 유니크 번호(1~45 범위)를 포함하는지 확인한다.")
    @Test
    void 각_발행_티켓이_6개의_유니크_번호_1_45_범위를_포함하는지_확인한다() {
        // given
        Money money = new Money(3000);
        LottoMachine lottoMachine = new LottoMachine(money);

        List<Lotto> lottos = lottoMachine.getPurchasedLottos();
        assertEquals(3, lottos.size());

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, numbers.size());
            long distinctCount = numbers.stream().distinct().count();
            assertEquals(6, distinctCount);

            for (int n : numbers) {
                assertTrue(n >= 1 && n <= 45, "번호는 1~45 범위여야 합니다.");
            }
        }
    }

}