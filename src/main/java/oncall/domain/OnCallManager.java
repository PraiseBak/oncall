package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import oncall.dto.WorkerInfo;
import oncall.exception.OnCallException;

public class OnCallManager {

    private final String INVALID_INPUT = "유효하지 않은 입력 값입니다. 다시 입력해 주세요.";
    private final OnCallDayManager onCallDayManager;
    private final String INVALID_WORKS_INFO = "바꿀 순번이 존재하지 않습니다.";
    private DayWorkers normalDayWorkers;
    private WeekendWorkers weekendWorkers;

    public OnCallManager(String input) {
        this.onCallDayManager = new OnCallDayManager(input);
    }

    public void setNormalDayWorker(String input){
        this.normalDayWorkers = new DayWorkers(input);
    }

    public void setWeekendDayWorker(String input){
        this.weekendWorkers = new WeekendWorkers(input);
    }

    public List<WorkerInfo> insertWorkers() {
        List<WorkerInfo> workerInfos = new ArrayList<>();
        for(int i=1;i<=onCallDayManager.getDayOfMonth();i++){
            boolean isWeekend = onCallDayManager.isWeekend();
            boolean isSpecialWeekend = onCallDayManager.isSpecialWeekend(i);
            String worker = getWorker(isWeekend, isSpecialWeekend);
            workerInfos.add(new WorkerInfo(worker,onCallDayManager.getMonth(),i,onCallDayManager.getDayOfWeek(),isWeekend,isSpecialWeekend));
            onCallDayManager.addDayOfWeekend();
        }
        return workerInfos;
    }


    private String getWorker(boolean isWeekend, boolean isSpecialWeekend) {
        if(isSpecialWeekend || isWeekend){
            return weekendWorkers.getWorker();
        }
        return normalDayWorkers.getWorker();
    }

    public void arrangeWorkers(List<WorkerInfo> workerInfos) {
        WorkerInfo prev = null;
        for(int i=0;i<workerInfos.size();i++){
            WorkerInfo workerInfo = workerInfos.get(i);
            if(prev != null && prev.isSame(workerInfo.nickname())){
                changeWorkerInfo(i,workerInfos,workerInfo);
            }
            prev = workerInfos.get(i);
        }
    }

    private void changeWorkerInfo(int cur, List<WorkerInfo> workerInfos, WorkerInfo curWorkerInfo) {
        int nextIdx = changeNextWeekendInfo(workerInfos,cur+1,curWorkerInfo);
        if(nextIdx == -1){
            throw new OnCallException(INVALID_WORKS_INFO);
        }
        WorkerInfo workerInfo = workerInfos.get(cur);
        WorkerInfo workerInfoNext = workerInfos.get(nextIdx);
        workerInfos.set(cur,new WorkerInfo(workerInfoNext.nickname(), workerInfo.month(), workerInfo.day(),workerInfo.dayOfWeek(),
                workerInfo.isWeekend(), workerInfo.isSpecialWeekend()));
        workerInfos.set(nextIdx,new WorkerInfo(workerInfo.nickname(), workerInfoNext.month(), workerInfoNext.day(),workerInfoNext.dayOfWeek(),
                workerInfoNext.isWeekend(), workerInfoNext.isSpecialWeekend()));
        System.out.println();
    }

    private int changeNextWeekendInfo(List<WorkerInfo> workerInfos, int nextIdx, WorkerInfo curWorkerInfo) {
        for (int i = nextIdx; i < workerInfos.size(); i++) {
            WorkerInfo next = workerInfos.get(i);
            if((next.isWeekend() || next.isSpecialWeekend()) == (curWorkerInfo.isWeekend()) || curWorkerInfo.isSpecialWeekend()){
                return i;
            }
        }
        return -1;
    }
}
