package oncall.service;

import oncall.domain.OnCallManager;
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
}
