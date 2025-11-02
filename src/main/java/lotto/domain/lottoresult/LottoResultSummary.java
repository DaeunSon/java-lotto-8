package lotto.domain.lottoresult;

import lotto.domain.rank.Rank;

import java.util.EnumMap;

public class LottoResultSummary {
    private final EnumMap<Rank, Integer> rankCounts;
    private final double yieldPercent;

    public LottoResultSummary(EnumMap<Rank, Integer> rankCounts, double yieldPercent) {
        this.rankCounts = new EnumMap<>(rankCounts);
        this.yieldPercent = yieldPercent;
    }

    public EnumMap<Rank, Integer> getRankCounts() {
        return new EnumMap<>(rankCounts);
    }

    public double getYieldPercent() {
        return yieldPercent;
    }
}
