package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.Gender;
import ucll.project.domain.user.Role;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnrolHandler extends RequestHandler {
    public EnrolHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");

        String vraag1 = request.getParameter("vraag1");
        String vraag2 = request.getParameter("vraag2");
        String vraag3 = request.getParameter("vraag3");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setGender(Gender.valueOf(gender));
        user.setRole(Role.USER);
        user.setDifficult(false);
        if (vraag1.equals("andere") || vraag2.equals("andere") || vraag3.equals("andere")){
            //moeilijke user
            user.setDifficult(true);
        }

        getUserService().addToWaitingList(user);

        request.setAttribute("users", getUserService().getUsers());
        return "users.jsp";
    }
}
