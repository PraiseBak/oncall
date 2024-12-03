package oncall.repository;

import java.util.List;
import javax.print.DocFlavor.READER;
import oncall.domain.DayOfWeek;
import oncall.dto.WorkerInfo;

public class OnCallFormatter {

    private final static String RESULT_ONCALL_FORMAT = "%d월 %d일 %s %s\n";
    public static String formattedWorkersInfo(List<WorkerInfo> workerInfos) {
        StringBuilder stringBuilder = new StringBuilder();
        for(WorkerInfo workerInfo : workerInfos) {
            String dayOfWeek = workerInfo.dayOfWeek().getDayOfWeek();
            if(workerInfo.isSpecialWeekend()){
                dayOfWeek = dayOfWeek + "(휴일)";
            }
            stringBuilder.append(String.format(RESULT_ONCALL_FORMAT,workerInfo.month(),workerInfo.day(),dayOfWeek,workerInfo.nickname()));
        }
        return stringBuilder.toString();
    }
}
