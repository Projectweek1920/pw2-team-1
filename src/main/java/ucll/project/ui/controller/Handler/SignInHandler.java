package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInHandler extends RequestHandler {
    public SignInHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String destination = "";
        System.out.println("test");

        for(User user : getUserService().getUserRepo()){

            if (user.getUserName().equals(userName)){
                System.out.println(user.getHashedPassword());

                if (user.getHashedPassword().equals(user.getHashedPassword())){
                    request.setAttribute("user", user);
                    destination = "index.jsp";
                } else{
                    destination = "login.jsp";

                }
            }
        }

        return destination;
    }
}
