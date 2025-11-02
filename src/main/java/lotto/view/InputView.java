package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import static lotto.common.utils.NumberParser.parseLottoNumbers;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputMoney(){
        System.out.println(INPUT_MONEY_MESSAGE);
        String line = Console.readLine();
        try{
            int amount = Integer.parseInt(line);
            return amount;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    public static List<Integer> inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return parseLottoNumbers(Console.readLine());
    }

    public static int inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }


}
