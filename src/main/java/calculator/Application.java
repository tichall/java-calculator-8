package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        String input = readInput();
        int sum = 0;
        displayResult(sum);
    }

    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void displayResult(int result) {
        System.out.println("결과 : " + result);
    }
}
