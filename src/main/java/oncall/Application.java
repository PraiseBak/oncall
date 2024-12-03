package oncall;


import oncall.controller.OnCallController;
import oncall.exception.OnCallException;
import oncall.repository.OnCallRepository;
import oncall.service.OnCallService;
import oncall.view.InputView;
import oncall.view.OutputView;

record StartDay(int month,int day){

}

public class Application {

    private final static OnCallController oncallController = new OnCallController(new OnCallService(new OnCallRepository()));
    public static void main(String[] args) {
        inputStartDay();
        inputNormalDayWorkers();
        inputWeekendDayWorkers();
        printWorkersSchedule();
    }

    private static void printWorkersSchedule() {
        String result = oncallController.calculateWorkersSchedule();
        OutputView.println(result);
    }

    private static void inputWeekendDayWorkers() {
        while (true){
            try{
                String s = InputView.inputWeekendDayWorkers();
                oncallController.initWeekendWorkers(s);
                return;
            }catch (IllegalArgumentException e){
                throw new OnCallException(e.getMessage());
            }
        }
    }

    private static void inputNormalDayWorkers() {
        while (true){
            try{
                String s = InputView.inputNormalDayWorkers();
                oncallController.initNormalDayWorkers(s);
                return;
            }catch (IllegalArgumentException e){
                throw new OnCallException(e.getMessage());
            }
        }
    }

    public static void inputStartDay(){
        while (true){
            try{
                String s = InputView.inputOnCallInput();
                oncallController.initStartDay(s);
                return;
            }catch (IllegalArgumentException e){
                throw new OnCallException(e.getMessage());
            }
        }
    }
}
