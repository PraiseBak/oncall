package oncall.domain;

public enum Day {
    ONE(1,31),
    TWO(2,28),
    THREE(3,31),
    FOUR(4,30),
    FIVE(5,31),
    SIX(6,30),
    SEVEN(7,31),
    EIGHT(8,31),
    NINE(9,30),
    TEN(10,31),
    ELEVEN(11,30),
    TWELVE(12,31);

    int month;
    int day;

    Day(int month, int day) {
        this.month = month;
        this.day = day;
    }
}
