package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NextTicketHandler extends RequestHandler {

    public NextTicketHandler (String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        getUserService().clickNext();
        request.setAttribute("JobStudent", getUserService().nextUser());
        return "Jobstudent.jsp";
    }
}
