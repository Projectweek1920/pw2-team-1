package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeHandler extends RequestHandler {
    public HomeHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }
}
