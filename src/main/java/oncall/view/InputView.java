package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.view.OutputView;

public class InputView {
    private static final String INPUT_NORMAL_DAY_WORKERS = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요";; ;
    private static final String INPUT_ONCALL_INIT = "비상 근무를 배정할 월과 시작 요일을 입력하세요>";
    private static final String INPUT_WEEKEND_DAY_WORKERS = "주말 비상 근무 순번대로 사원 닉네임을 입력하세요";;


    public static String inputOnCallInput() {
        OutputView.println(INPUT_ONCALL_INIT);
        return readLine();
    }

    public static String readLine(){
        return Console.readLine();
    }

    public static String inputWeekendDayWorkers() {
        OutputView.println(INPUT_WEEKEND_DAY_WORKERS);
        return readLine();
    }

    public static String inputNormalDayWorkers() {
        OutputView.println(INPUT_NORMAL_DAY_WORKERS);
        return readLine();
    }
}

