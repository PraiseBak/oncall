package oncall.repository;

import java.util.List;
import oncall.domain.OnCallManager;

public class OnCallRepository {

    private OnCallManager onCallManager;

    public OnCallManager getOnCallManager() {
        return onCallManager;
    }

    public void saveOnCallManager(OnCallManager onCallManager) {
        this.onCallManager = onCallManager;
    }
}
