package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @DisplayName("일치하는 번호 개수와 보너스 볼 여부에 따라 올바른 등수가 반환된다.")
    @Test
    void 일치하는_번호_개수와_보너스_볼_여부에_따라_올바른_등수가_반환된다() {
        assertEquals(Rank.FIRST, Rank.fromMatchCount(6, false));
        assertEquals(Rank.SECOND, Rank.fromMatchCount(5, true));
        assertEquals(Rank.THIRD, Rank.fromMatchCount(5, false));
        assertEquals(Rank.FOURTH, Rank.fromMatchCount(4, false));
        assertEquals(Rank.FIFTH, Rank.fromMatchCount(3, false));
        assertEquals(Rank.MISS, Rank.fromMatchCount(2, false));
        assertEquals(Rank.MISS, Rank.fromMatchCount(0, false));
    }

    @DisplayName("등수별 상금이 기대값과 일치하는지 확인한다.")
    @Test
    void 등수별_상금이_기대값과_일치하는지_확인한다() {
        assertEquals(2_000_000_000, Rank.FIRST.getPrize());
        assertEquals(30_000_000, Rank.SECOND.getPrize());
        assertEquals(1_500_000, Rank.THIRD.getPrize());
        assertEquals(50_000, Rank.FOURTH.getPrize());
        assertEquals(5_000, Rank.FIFTH.getPrize());
        assertEquals(0, Rank.MISS.getPrize());
    }
}