package lotto.domain.lottoresult;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultCalculatorTest {

    @DisplayName("등수별 개수와 총상금을 올바르게 계산하는지 확인한다.")
    @Test
    void 등수별_개수와_총상금을_올바르게_계산하는지_확인한다() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));    // 6개 일치 -> 1등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));    // 5개 + 보너스 -> 2등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));    // 5개 -> 3등
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 9, 10)));   // 4개 -> 4등
        lottos.add(new Lotto(List.of(1, 2, 3, 11, 12, 13))); // 3개 -> 5등
        lottos.add(new Lotto(List.of(1, 2, 3, 14, 15, 16))); // 3개 -> 5등

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        LottoResultCalculator calculator = new LottoResultCalculator(lottos, winningLotto);

        // when
        EnumMap<Rank, Integer> rankCounts = calculator.computeRankCounts();
        int firstCount = rankCounts.getOrDefault(Rank.FIRST, 0);
        int secondCount = rankCounts.getOrDefault(Rank.SECOND, 0);
        int thirdCount = rankCounts.getOrDefault(Rank.THIRD, 0);
        int fourthCount = rankCounts.getOrDefault(Rank.FOURTH, 0);
        int fifthCount = rankCounts.getOrDefault(Rank.FIFTH, 0);
        int totalPrize = calculator.computeTotalPrize(rankCounts);

        // then
        assertEquals(1, firstCount);
        assertEquals(1, secondCount);
        assertEquals(1, thirdCount);
        assertEquals(1, fourthCount);
        assertEquals(2, fifthCount);
        assertEquals(2_000_000_000 + 30_000_000 + 1_500_000 + 50_000 + (2 * 5_000), totalPrize);
    }

    @DisplayName("수익률은 소수점 둘째 자리에서 반올림된다.")
    @Test
    void 수익률은_소수점_둘째_자리에서_반올림된다() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));    // 6개 일치 -> 1등

        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        LottoResultCalculator calculator = new LottoResultCalculator(lottos, winningLotto);

        // when
        EnumMap<Rank, Integer> rankCounts = calculator.computeRankCounts();
        int totalPrize = calculator.computeTotalPrize(rankCounts);
        double investment = lottos.size() * 1000.0;
        double yield = (totalPrize / investment) * 100;

        // then
        assertEquals(2000000000, totalPrize);
        assertEquals(200000000.00, Math.round(yield * 100.0) / 100.0);
    }

}