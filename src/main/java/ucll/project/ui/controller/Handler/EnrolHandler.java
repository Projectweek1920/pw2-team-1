package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnrolHandler extends RequestHandler {
    public EnrolHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String vraag1 = request.getParameter("vraag1");
        String vraag2 = request.getParameter("vraag2");
        String vraag3 = request.getParameter("vraag3");




        System.out.println(vraag1 + vraag2 +vraag3);
        return "index.jsp";
    }
}
