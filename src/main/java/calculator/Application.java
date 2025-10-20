package calculator;

import calculator.view.ConsoleView;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        ConsoleView view = new ConsoleView();

        String input = view.readInput();
        int sum = 0;

        if (isNotBlank(input)) {
            NumberStringParser numberStringParser = new NumberStringParser(input);
            String[] numberStrings = numberStringParser.parse();

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
        view.displayResult(sum);
    }

    public static boolean isNotBlank(String input) {
        return !input.trim().isEmpty();
    }
}
