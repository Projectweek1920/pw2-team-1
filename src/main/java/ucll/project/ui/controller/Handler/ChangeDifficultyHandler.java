package ucll.project.ui.controller.Handler;

import ucll.project.db.WaitingList;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;
import ucll.project.domain.user.Worker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeDifficultyHandler extends RequestHandler {

    public ChangeDifficultyHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        User current = (User) request.getAttribute("user");
        current.setDifficult(true);
        User user = getUserService().nextEasyUser();



        if (user != null){
            request.setAttribute("JobStudent", getUserService().nextEasyUser());
            Worker worker = (Worker) request.getSession().getAttribute(("worker"));
            WaitingList.getInstance().removeNextEasyUser();
            user.setLoket(getUserService().getCertainUserRepo(worker.getUserName()).getLoket());
            WaitingList.getInstance().addUserAanDeBeurt(user);
            System.out.println(WaitingList.getInstance().getAanDeBeurt().size());
        }
        return "Jobstudent.jsp";
    }
}
