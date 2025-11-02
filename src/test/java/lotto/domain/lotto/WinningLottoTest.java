package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 3;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningLotto(winningLotto, bonusNumber);
        });

        assertEquals("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.", exception.getMessage());
    }

    @DisplayName("WinningLotto 정상 생성 시 당첨 번호와 보너스 번호를 올바르게 반환한다.")
    @Test
    void WinningLotto_정상_생성_시_당첨_번호와_보너스_번호를_올바르게_반환한다() {
        //given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        //when
        WinningLotto winningLottoObj = new WinningLotto(winningLotto, bonusNumber);

        //then
        assertEquals(List.of(1, 2, 3, 4, 5, 6), winningLottoObj.getWinningLottoNumbers());
        assertEquals(7, winningLottoObj.getBonusNumber());
    }
}