package oncall.domain;

public enum OffDay {
    ONE(1,1),
    TWO(3,1),
    THREE(5,5),
    FOUR(6,6),
    FIVE(8,15),
    SIX(10,3),
    SEVEN(10,9),
    EIGHT(12,25),
    ;
    int month;
    int day;
    OffDay(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isWeekend(int month,int day){
        for(OffDay offDay : OffDay.values()){
            if(offDay.month == month && offDay.day == day){
                return true;
            }
        }
        return false;
    }
}
