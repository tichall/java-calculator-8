package calculator;

public class Calculator {
    public static int calculate(String input) {
        if (isBlank(input)) {
            return 0;
        }

        NumberStringParser parser = new NumberStringParser(input);
        String[] numberStrings = parser.parse();
        return sum(numberStrings);
    }

    private static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static int sum(String[] numberStrings) {
        int result = 0;
        for (String numberString : numberStrings) {
            int number = parseAndValidateNumber(numberString);
            result += number;
        }
        return result;
    }

    private static int parseAndValidateNumber(String numberString) {
        try {
            int number = Integer.parseInt(numberString);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }
}
