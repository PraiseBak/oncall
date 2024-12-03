package oncall.domain;

public class OnCallManager {

    private final String INVALID_INPUT = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";
    private final OnCallDayManager onCallManager;
    private final DayWorkers normalDayWorkers;
    private final WeekendWorkers weekendWorkers;

    public OnCallManager(String input) {
        this.onCallManager = new OnCallDayManager(input);
    }

    public void setNormalDayWorker(String s){
        validateWorker(s);
        this.normalDayWorkers = ;
    }

    public void setWeekendDayWorker(String s){
        validateWeekendWorker(s);
        this.normalDayWorkers;
    }

    private void validateWeekendWorker(String s) {

    }

    private void validateWorker(String s) {

    }

}
