package lotto.common.utils;

import java.util.Arrays;
import java.util.List;

public class NumberParser {


    public static List<Integer> parseLottoNumbers(String input){
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 공백일 수 없습니다.");
        }

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
