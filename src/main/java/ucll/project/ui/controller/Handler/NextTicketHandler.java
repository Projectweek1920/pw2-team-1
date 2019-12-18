package ucll.project.ui.controller.Handler;

import org.openqa.selenium.support.ui.Wait;
import ucll.project.db.WaitingList;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;
import ucll.project.domain.user.Worker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NextTicketHandler extends RequestHandler {

    public NextTicketHandler (String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        User user = getUserService().nextEasyUser();
        if (user != null){
            request.setAttribute("JobStudent", getUserService().nextEasyUser());
            Worker worker = (Worker) request.getSession().getAttribute(("worker"));
            WaitingList.getInstance().removeNextEasyUser();
            user.setLoket(getUserService().getCertainUserRepo(worker.getUserName()).getLoket());
            WaitingList.getInstance().addUserAanDeBeurt(user);
            System.out.println(WaitingList.getInstance().getAanDeBeurt().size());
        }
        RequestHandler requestHandler = new JobstudentHandler(getCommand(),getUserService());
        requestHandler.setUserService(getUserService());
        String desti = requestHandler.handleRequest(request,response);
        return desti;
    }
}
