package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToComplexHandler extends RequestHandler {
    public ToComplexHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int userid = Integer.parseInt(request.getParameter("userid"));
        this.getUserService().markEasyAsComplex(userid);
        request.setAttribute("assignedUser", getUserService().getUserWithId(userid));
        request.setAttribute("markedAsComplex", true);
        return "Jobstudent.jsp";
    }
}
