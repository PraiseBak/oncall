package oncall.domain;

public enum DayOfWeek {
    MONDAY("월"),
    THUSDAY("화"),
    WHENSEDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일")

    String dayOfWeek;

    DayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
