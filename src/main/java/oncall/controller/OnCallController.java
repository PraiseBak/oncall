package oncall.controller;

import oncall.service.OnCallService;

public class OnCallController {
    private final OnCallService onCallService;

    public OnCallController(OnCallService onCallService) {
        this.onCallService = onCallService;
    }

    public void initStartDay(String s) {
        onCallService.initStartDay(s);
    }
}
