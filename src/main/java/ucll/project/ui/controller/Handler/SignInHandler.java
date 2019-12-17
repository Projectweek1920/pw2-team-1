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
        String loket = request.getParameter("loket");
        String destination = "";

        for(User user : getUserService().getUserRepo()){

            if (user.getUserName().equals(userName)){
                User user1 = new User();
                user1.hashAndSetPassword(password);
                if (user.getHashedPassword().equals(user1.getHashedPassword())){
                    user.setLoket(loket);
                    request.getSession().setAttribute("user",user);
                    destination = "index.jsp";
                    System.out.println(user.getRole());
                } else{
                    destination = "login.jsp";

                }
            }
        }

        return destination;
    }
}
