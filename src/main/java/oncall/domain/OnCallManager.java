package oncall.domain;

import java.util.HashSet;
import oncall.exception.OnCallException;

public class OnCallManager {

    private final String INVALID_INPUT = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";
    private final OnCallDayManager onCallDayManager;
    private DayWorkers normalDayWorkers;
    private WeekendWorkers weekendWorkers;

    public OnCallManager(String input) {
        this.onCallDayManager = new OnCallDayManager(input);
    }

    public void setNormalDayWorker(String input){
        this.normalDayWorkers = new DayWorkers(input);
    }

    public void setWeekendDayWorker(String input){
        this.weekendWorkers = new WeekendWorkers(input);
    }
}
