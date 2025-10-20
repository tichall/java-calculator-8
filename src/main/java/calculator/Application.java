package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final List<String> defaultDelimiters = List.of(",", ":");
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static String customDelimiter = "";
    private static String delimiterRegex = String.join("|", defaultDelimiters);

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String input = readInput();
        int sum = 0;
        String targetString = input;
        List<String> numberStrings = new ArrayList<>();

        if (isNotBlank(input)) {
            if (existsCustomDelimiter(input)) {
                targetString = input.substring(
                        input.indexOf(CUSTOM_DELIMITER_SUFFIX) + CUSTOM_DELIMITER_SUFFIX.length());
                delimiterRegex = customDelimiter;
            }

            numberStrings.addAll(Arrays.asList(targetString.split(delimiterRegex)));

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

    public static boolean existsCustomDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int lastIndexOfCustomDelimiter = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

            if (lastIndexOfCustomDelimiter == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정이 유효하지 않습니다.");
            }

            customDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), lastIndexOfCustomDelimiter);
            validateDelimiterIsNotNumeric(customDelimiter);
            return true;
        }
        return false;
    }

    public static void validateDelimiterIsNotNumeric(String delimiter) {
        try {
            Double.parseDouble(delimiter);
            throw new IllegalArgumentException("커스텀 지정자로 숫자를 사용할 수 없습니다.");
        } catch (NumberFormatException ignore) {

        }
    }
}
