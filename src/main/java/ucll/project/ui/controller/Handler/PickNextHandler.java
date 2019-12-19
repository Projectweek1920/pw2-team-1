package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PickNextHandler extends RequestHandler {
    public PickNextHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("student");
        if (user.equals("SIMPEL")){
            request.setAttribute("JobStudent", getUserService().nextEasyUser());
        } else {
            request.setAttribute("JobStudent", getUserService().nextDifficultUser());
        }
        return "Administration.jsp";
    }
}
