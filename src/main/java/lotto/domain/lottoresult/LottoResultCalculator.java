package lotto.domain.lottoresult;

import lotto.domain.rank.Rank;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.Lotto;

import java.util.EnumMap;
import java.util.List;

public class LottoResultCalculator {

    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;

    public LottoResultCalculator(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public EnumMap<Rank, Integer> computeRankCounts() {
        EnumMap<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

        rankCounts.put(Rank.FIFTH, 0);
        rankCounts.put(Rank.FOURTH, 0);
        rankCounts.put(Rank.THIRD, 0);
        rankCounts.put(Rank.SECOND, 0);
        rankCounts.put(Rank.FIRST, 0);
        rankCounts.put(Rank.MISS, 0);

        for (Lotto lotto : lottos) {
            int match = countMatchingNumbers(lotto);
            boolean bonusMatched = lotto.getNumbers().contains(winningLotto.getBonusNumber());
            Rank rank = Rank.fromMatchCount(match, bonusMatched);
            rankCounts.merge(rank, 1, Integer::sum);
        }
        return rankCounts;
    }

    public int computeTotalPrize(EnumMap<Rank, Integer> rankCounts) {
        int total = 0;
        for (Rank rank : Rank.values()) {
            int count = rankCounts.getOrDefault(rank, 0);
            total += rank.getPrize() * count;
        }
        return total;
    }

    private int countMatchingNumbers(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getWinningLottoNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
