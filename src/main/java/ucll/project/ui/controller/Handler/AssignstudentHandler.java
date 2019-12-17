package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.Gender;
import ucll.project.domain.user.Role;
import ucll.project.domain.user.UserService;
import ucll.project.domain.user.Worker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AssignstudentHandler extends RequestHandler {
    public AssignstudentHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String workerString = request.getParameter("worker");
        Worker worker = new Worker(userName,firstName,lastName,email,Gender.valueOf(gender),Role.valueOf(workerString));
        getUserService().addUserRepo(worker,"P@ssw0rd");
        return "studentList.jsp";



    }
}
