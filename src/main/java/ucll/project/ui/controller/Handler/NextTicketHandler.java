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
        getUserService().clickNextEasy();
        request.setAttribute("JobStudent", getUserService().nextEasyUser());
        System.out.println("test");
        return "Jobstudent.jsp";
    }
}
