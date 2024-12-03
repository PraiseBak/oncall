package oncall.dto;

public record WorkerInfo(String nickname, int month, int day,
                         oncall.domain.DayOfWeek dayOfWeek, boolean isWeekend, boolean isSpecialWeekend) {

    public boolean isSame(String nickname){
        return this.nickname.equals(nickname);

    }
}
