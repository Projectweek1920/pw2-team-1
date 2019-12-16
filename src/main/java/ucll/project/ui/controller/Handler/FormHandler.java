package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormHandler extends RequestHandler {
    public FormHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "form.jsp";
    }
}
