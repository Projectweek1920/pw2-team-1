package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JobstudentHandler extends RequestHandler {
    public JobstudentHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(getUserService().nextEasyUser());
        //request.setAttribute("assignedUser", getUserService().nextEasyUser());
        return "Jobstudent.jsp";
    }
}
