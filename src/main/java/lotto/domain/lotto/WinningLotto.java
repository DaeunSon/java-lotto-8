package lotto.domain.lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        validateBonusNumber(bonusNumber);
    }

    public List<Integer> getWinningLottoNumbers(){
        return this.winningLotto.getNumbers();
    }

    public int getBonusNumber(){
        return this.bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber){
        if (winningLotto.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
