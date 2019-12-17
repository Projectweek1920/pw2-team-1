package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;
import ucll.project.domain.user.Worker;

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

        for(Worker worker : getUserService().getUserRepo()){

            if (worker.getUserName().equals(userName)){
                Worker user1 = new Worker();
                user1.hashAndSetPassword(password);
                if (worker.getHashedPassword().equals(user1.getHashedPassword())){
                    worker.setLoket(loket);
                    request.getSession().setAttribute("worker",worker);
                    destination = "index.jsp";
                    System.out.println(worker.getRole());
                } else{
                    destination = "login.jsp";

                }
            }
        }

        return destination;
    }
}
