package lotto.view;

import lotto.domain.lottoresult.LottoResultSummary;
import lotto.domain.rank.Rank;

import java.util.Map;

public class OutputView {
    private static final String PURCHASED_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DASHES_MESSAGE = "---";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private static final Rank[] DISPLAY_ORDER = {
            Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST
    };

    public static void printPurchasedLottoCount(int count) {
        System.out.println(count + PURCHASED_LOTTO_MESSAGE);
    }

    public static void printWinningStatisticsHeader() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DASHES_MESSAGE);
    }

    public static void printTotalYield(double yield) {
        System.out.printf(TOTAL_YIELD_MESSAGE + "%n", yield);
    }

    private static final Map<Rank, String> LABEL_MAP = Map.of(
            Rank.FIFTH, "3개 일치 (5,000원)",
            Rank.FOURTH, "4개 일치 (50,000원)",
            Rank.THIRD, "5개 일치 (1,500,000원)",
            Rank.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)",
            Rank.FIRST, "6개 일치 (2,000,000,000원)"
    );

    public static void printResults(LottoResultSummary summary) {
        summary.getRankCounts().forEach((k, v) -> {});
        for (Rank rank : DISPLAY_ORDER) {
            int count = summary.getRankCounts().getOrDefault(rank, 0);
            System.out.printf("%s - %d개%n", LABEL_MAP.get(rank), count);
        }
        printTotalYield(summary.getYieldPercent());
    }

}
