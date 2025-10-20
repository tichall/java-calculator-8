package calculator;

import calculator.view.ConsoleView;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        try {
            ConsoleView view = new ConsoleView();
            String input = view.readInput();
            view.displayResult(Calculator.calculate(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
