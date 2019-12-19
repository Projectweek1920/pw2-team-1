package ucll.project.ui.controller.Handler;

import ucll.project.db.WaitingList;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;
import ucll.project.domain.user.Worker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PickNextHandler extends RequestHandler {
    public PickNextHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String user1 = request.getParameter("student");
        if (user1.equals("SIMPEL")){
            User user = getUserService().nextEasyUser();
            if (user != null){
                request.setAttribute("assignedUser", getUserService().nextEasyUser());
                Worker worker = (Worker) request.getSession().getAttribute(("worker"));
                user.setLoket(worker.getLoket());
                WaitingList.getInstance().addUserAanDeBeurt(user);
                WaitingList.getInstance().removeNextEasyUser();
                user.setLoket(getUserService().getCertainUserRepo(worker.getUserName()).getLoket());
            }
        } else {
            User user = getUserService().nextDifficultUser();
            if (user != null){
                request.setAttribute("assignedUser", getUserService().nextDifficultUser());
                Worker worker = (Worker) request.getSession().getAttribute(("worker"));
                WaitingList.getInstance().removeNextDifficultUser();
                user.setLoket(worker.getLoket());
                WaitingList.getInstance().addUserAanDeBeurt(user);
            }
        }
        RequestHandler requestHandler = new ShowAdministrationHandler(getCommand(),getUserService());
        requestHandler.setUserService(getUserService());
        String desti = requestHandler.handleRequest(request,response);
        return desti;
    }
}
