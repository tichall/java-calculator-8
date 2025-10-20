package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {
    public String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void displayResult(int result) {
        System.out.println("결과 : " + result);
    }
}
