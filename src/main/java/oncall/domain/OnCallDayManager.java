package oncall.domain;

import oncall.exception.OnCallException;
import oncall.utility.NumberUtility;

public class OnCallDayManager {

    private final String INVALID_INPUT = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";
    private DayOfWeek dayOfWeek;
    private final Day day;

    public OnCallDayManager(String input) {
        String[] sArr = input.split(",");
        validate(sArr);
        this.day = getDayByMonth(Integer.parseInt(sArr[0]));
        this.dayOfWeek = getDayOfWeekByDay(sArr[1]);
    }

    private void validate(String[] sArr) {
        if(sArr.length != 2){
            throw new OnCallException(INVALID_INPUT);
        }
        String month = sArr[0];
        String day = sArr[1];
        if(!isExistsMonth(month)){
            throw new OnCallException(INVALID_INPUT);
        }
        if(!isExistsDayOfWeek(day)){
            throw new OnCallException(INVALID_INPUT);
        }
    }

    private boolean isExistsDayOfWeek(String dayOfWeek) {
        if (getDayOfWeekByDay(dayOfWeek) != null) {
            return true;
        }
        return false;
    }

    private boolean isExistsMonth(String month) {
        if(!NumberUtility.isNumber(month)){
            throw new OnCallException(INVALID_INPUT);
        }
        if (getDayByMonth(Integer.parseInt(month)) != null) {
            return true;
        }
        return false;
    }

    private Day getDayByMonth(int month) {
        Day[] days = Day.values();
        for(Day day : days){
            if(day.month == month){
                return day;
            }
        }
        return null;
    }

    private static DayOfWeek getDayOfWeekByDay(String dayOfWeek) {
        DayOfWeek[] values = DayOfWeek.values();
        for(DayOfWeek day : values){
            if(day.dayOfWeek.equals(dayOfWeek)){
                return day;
            }
        }
        return null;
    }

    public int getDayOfMonth() {
        return day.day;
    }

    public int getMonth(){
        return day.month;
    }

    public boolean isWeekend() {
        return DayOfWeek.isWeekend(dayOfWeek);
    }

    public boolean isSpecialWeekend(int curDay){
        return !isWeekend() && OffDay.isWeekend(day.month,curDay);
    }

    public void addDayOfWeekend(){
        dayOfWeek = dayOfWeek.addDayOfWeek();
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
