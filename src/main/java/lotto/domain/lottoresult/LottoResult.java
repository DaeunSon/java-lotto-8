package lotto.domain.lottoresult;

import lotto.domain.money.Money;
import lotto.domain.rank.Rank;

import java.util.EnumMap;

import static lotto.view.OutputView.printResults;

public class LottoResult {

    private final LottoResultCalculator calculator;
    private final Money money;

    public LottoResult(LottoResultCalculator calculator, Money money) {
        this.calculator = calculator;
        this.money = money;
    }

    public void printLottoResults(){
        EnumMap<Rank, Integer> rankCounts = calculator.computeRankCounts();
        int totalPrize = calculator.computeTotalPrize(rankCounts);
        double yieldPercent = calculateYieldPercent(totalPrize);

        LottoResultSummary summary = new LottoResultSummary(rankCounts, yieldPercent);
        printResults(summary);
    }

    private double calculateYieldPercent(int totalPrize) {
        return ((double) totalPrize / money.getAmount()) * 100;
    }
}
