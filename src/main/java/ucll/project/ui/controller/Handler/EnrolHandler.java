package ucll.project.ui.controller.Handler;

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
        String vraag1 = request.getParameter("vraag1");
        String vraag2 = request.getParameter("vraag2");
        String vraag3 = request.getParameter("vraag3");

        User user = new User();

        if (vraag1.equals("andere") || vraag2.equals("andere") || vraag3.equals("andere")){
            //moeilijke user
            user.setDifficult();
        } else if(vraag1.equals("graduaat") && vraag2.equals("middelbaar")){
            user.setDifficult();
        }else if(vraag1.equals("postgraduaat") && vraag3.equals("andere")){
            user.setDifficult();
        }
        //crashes here
        System.out.println(getUserService().getUsers());
        getUserService().addToWaitingList(user);
        System.out.println(getUserService().getUsers());
        System.out.println(user.getUserId());
        System.out.println(user.isDifficult());





        System.out.println(vraag1 + vraag2 +vraag3);
        request.setAttribute("users", this.getUserService().getUsers());
        return "users.jsp";
    }
}
