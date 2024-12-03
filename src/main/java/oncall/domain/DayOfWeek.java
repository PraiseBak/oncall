package oncall.domain;

public enum DayOfWeek {
    MONDAY("월"),
    THUSDAY("화"),
    WHENSEDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    String dayOfWeek;

    DayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public static boolean isWeekend(DayOfWeek dayOfWeek){
        return dayOfWeek == SATURDAY || dayOfWeek == SUNDAY;
    }

    public DayOfWeek addDayOfWeek(){
        DayOfWeek[] days =  DayOfWeek.values();
        for(int i=0;i<days.length;i++){
            if(days[i] == this){
                return days[(i + 1) % days.length];
            }
        }
        return null;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
