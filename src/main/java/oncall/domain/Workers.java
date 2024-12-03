package oncall.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import oncall.exception.OnCallException;

public class Workers {
    private static final int MIN = 5;
    private static final int MAX = 35;
    private static final String SIZE_OVER = "최대 " + MAX + "명까지 가능합니다.";
    private static final String DUPLICATE_NICKNAME = "중복된 닉네임입니다";
    private static final int NICKNAME_MAX = 5;
    private static final String NICKNAME_LENGTH_ERROR = "닉네임은 1글자이상 최대 5글자이하여야합니다.";
    private final List<String> workersList;

    public Workers(String input) {
        validateWorker(input);
        String[] split = input.split(",");
        workersList = Arrays.stream(split).toList();
    }

    private void validateWorker(String input) {
        String[] sArr = input.split(",");
        HashSet<String> isDuplicateWorkers = new HashSet<>();
        validateWorkerSize(sArr);
        for(String s : sArr){
            if(isDuplicateWorkers.contains(s)){
                throw new OnCallException(DUPLICATE_NICKNAME);
            }
            isDuplicateWorkers.add(s);
            nicknameSizeValidate(s);
        }
    }

    private static void nicknameSizeValidate(String s) {
        if(s == null || s.isEmpty() || s.length() > NICKNAME_MAX){
            throw new OnCallException(NICKNAME_LENGTH_ERROR);
        }
    }

    private static void validateWorkerSize(String[] sArr) {
        if(sArr.length > MAX || sArr.length < MIN){
            throw new OnCallException(SIZE_OVER);
        }
    }

    public List<String> getWorkersList() {
        return workersList;
    }
}
