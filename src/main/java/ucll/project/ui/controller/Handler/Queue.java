package ucll.project.ui.controller.Handler;

import ucll.project.db.WaitingList;
import ucll.project.domain.user.QueueSyncronizer;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;

public class Queue extends RequestHandler {
    public Queue(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("numbers", getNumbers());
        QueueSyncronizer.getInstance().addDom(request,response);
        return "waitingList.jsp";

    }

    public ArrayList<Integer> getNumbers(){
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            for (User u : WaitingList.getInstance().getAll()) {
                numbers.add(u.getUserId());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return numbers;
    }

}
