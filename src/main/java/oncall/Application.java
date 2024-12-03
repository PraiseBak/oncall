package oncall;


import oncall.controller.OnCallController;
import oncall.exception.OnCallException;
import oncall.repository.OnCallRepository;
import oncall.service.OnCallService;
import oncall.view.InputView;

record StartDay(int month,int day){

}

public class Application {

    private final static OnCallController oncallController = new OnCallController(new OnCallService(new OnCallRepository()));
    public static void main(String[] args) {
        inputStartDay();
    }


    public void inputStartDay(){
        while (true){
            try{
                String s = InputView.inputOnCallInput();
                oncallController.initStartDay(s);

            }catch (IllegalArgumentException e){
                throw new OnCallException(e.getMessage());
            }
        }

    }

}
