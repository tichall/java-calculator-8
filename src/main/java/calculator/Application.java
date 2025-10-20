package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    private static final List<String> defaultDelimiters = List.of(",", ":");
    private static final String delimiterRegex = String.join("|", defaultDelimiters);

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        String input = readInput();
        int sum = 0;

        if(isNotBlank(input)) {
            String[] numberStrings = input.split(delimiterRegex);

            for (String numberString : numberStrings) {
                try {
                    int number = Integer.parseInt(numberString);
                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
                }
            }
        }
        displayResult(sum);
    }


    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void displayResult(int result) {
        System.out.println("결과 : " + result);
    }

    public static boolean isNotBlank(String input) {
        return !input.trim().isEmpty();
    }
}
