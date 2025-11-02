package lotto.domain.lottomachine;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
   private final Money money;
   private final List<Lotto> lottos;

   private final static int LOTTO_PRICE = 1000;

    public LottoMachine(Money money) {
        this.money = money;
        this.lottos = generateLottos();
    }

    //로또 생성
    private List<Lotto> generateLottos(){
        List<Lotto> lottos = new ArrayList<>();

        for(int i =0 ;i<countLottoTicket();i++){
            List<Integer> lottoNumbers = getRandomLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        };

        return lottos;
    }

    public void printPurchasedLottos(){
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public List<Lotto> getPurchasedLottos(){
        return lottos;
    }


    //로또 구매 개수 계산
    public int countLottoTicket(){
        return money.getAmount() / LOTTO_PRICE;
    }

    private static List<Integer> getRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
