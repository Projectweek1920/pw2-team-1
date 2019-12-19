package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.DomainException;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;
import ucll.project.domain.user.Worker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SignInHandler extends RequestHandler {
    public SignInHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String destination = "";



        for(Worker worker : getUserService().getUserRepo()){

            if (worker.getUserName().equals(userName)){
                Worker user1 = new Worker();
                user1.hashAndSetPassword(password);
                if (worker.getHashedPassword().equals(user1.getHashedPassword())){
                    try{
                        setLoket(worker,request,errors);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    request.getSession().setAttribute("worker",worker);
                    destination = "index.jsp";
                } else{
                    destination = "login.jsp";

                }
            }
        }

        if (errors.size() == 0){
            try{
                return "index.jsp";
            } catch (DomainException exc) {
                request.setAttribute("error", exc.getMessage());
                request.setAttribute("errors",errors);
                return "login.jsp";
            }
        } else {
            request.setAttribute("errors", errors);
            return "login.jsp";
        }

    }

    protected void setLoket(Worker worker, HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String loket = request.getParameter("loket");
        try {
            worker.setLoket(loket);
            request.setAttribute("Class", "has-success");
            request.setAttribute("loketPV", loket);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("loketClass", "has-error");
        }
    }
}
