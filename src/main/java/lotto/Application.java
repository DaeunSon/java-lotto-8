package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lottomachine.LottoMachine;
import lotto.domain.lottoresult.LottoResult;
import lotto.domain.lottoresult.LottoResultCalculator;
import lotto.domain.money.Money;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class Application {
    public static void main(String[] args) {
        //구입금액 입력받기
        try{
            Money money = new Money(inputMoney());
            LottoMachine lottoMachine = new LottoMachine(money);

            printPurchasedLottoCount(lottoMachine.countLottoTicket());

            //구입한 로또 출력하기
            lottoMachine.printPurchasedLottos();

            //당첨 번호 입력받기
            Lotto lotto = new Lotto(inputWinningNumbers());

            //보너스 번호 입력받기
            int bonusNumber = inputBonusNumber();

            //당첨 통계 출력하기
            printWinningStatisticsHeader();

            //당첨 로또 생성하기
            WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

            LottoResultCalculator calculator = new LottoResultCalculator(lottoMachine.getPurchasedLottos(), winningLotto);
            LottoResult result = new LottoResult(calculator, money);
            result.printLottoResults();
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
    }
}
