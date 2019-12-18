package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.Role;
import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeRoleHandler extends RequestHandler {
    public ChangeRoleHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String role = request.getParameter("role");
        String student = request.getParameter("worker");

        getUserService().getCertainUserRepo(student).setRole(Role.valueOf(role));

        RequestHandler requestHandler = new showStudentListHandler(getCommand(),getUserService());
        requestHandler.setUserService(getUserService());
        String desti = requestHandler.handleRequest(request,response);
        return desti;
    }
}
