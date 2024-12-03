package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.view.OutputView;

public class InputView {
    private static String INPUT_ONCALL_INIT = "비상 근무를 배정할 월과 시작 요일을 입력하세요>";


    public static String inputOnCallInput() {
        OutputView.println(INPUT_ONCALL_INIT);
        return readLine();
    }

    public static String readLine(){
        return Console.readLine();
    }

}
