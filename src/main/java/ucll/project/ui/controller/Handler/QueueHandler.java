package ucll.project.ui.controller.Handler;

import ucll.project.db.WaitingList;
import ucll.project.domain.user.QueueSyncronizer;
import ucll.project.domain.user.User;
import ucll.project.domain.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class QueueHandler extends RequestHandler {
    public QueueHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("names", getNames());
        request.setAttribute("ready", getReady());
        QueueSyncronizer.getInstance().addDom(request,response);
        return "waitingList.jsp";

    }

    public ArrayList<String> getNames(){
        ArrayList<String> names = new ArrayList<>();
        try {
            for (User u : WaitingList.getInstance().getAll()) {
                names.add(u.getFormatName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return names;
    }

    public ArrayList<User> getReady(){
        ArrayList<User> names = new ArrayList<>();
        try {
            for (User u : WaitingList.getInstance().getAanDeBeurt()) {
                names.add(u);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return names;
    }

}
