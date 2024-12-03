package oncall.view;

public class OutputView {
    private final static String ERROR_PREFIX = "[ERROR] ";
    private static final String REMAIN_MACHINE_COIN = "자판기가 보유한 동전";

    public static void printError(String message) {
        println(ERROR_PREFIX + message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

}
