package oncall.service;

import java.util.List;
import oncall.domain.OnCallManager;
import oncall.dto.WorkerInfo;
import oncall.repository.OnCallFormatter;
import oncall.repository.OnCallRepository;

public class OnCallService {
    private final OnCallRepository onCallRepository;

    public OnCallService(OnCallRepository onCallRepository){
        this.onCallRepository = onCallRepository;
    }

    public void initStartDay(String s) {
        OnCallManager onCallManager = new OnCallManager(s);
        onCallRepository.saveOnCallManager(onCallManager);
    }

    public void initNormalDayWorkers(String s){
        onCallRepository.getOnCallManager().setNormalDayWorker(s);
    }

    public void initWeekendDayWorkers(String s){
        onCallRepository.getOnCallManager().setWeekendDayWorker(s);
    }

    public String calculateWorkersSchedule() {
        OnCallManager onCallManager = onCallRepository.getOnCallManager();
        List<WorkerInfo> workerInfos = onCallManager.insertWorkers();
        onCallManager.arrangeWorkers(workerInfos);
        return OnCallFormatter.formattedWorkersInfo(workerInfos);

    }
}
