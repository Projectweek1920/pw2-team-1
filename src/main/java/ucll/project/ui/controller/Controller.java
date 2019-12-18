package ucll.project.ui.controller;

import ucll.project.domain.user.NotAuthorizedException;
import ucll.project.domain.user.QueueSyncronizer;
import ucll.project.domain.user.UserService;
import ucll.project.ui.controller.Handler.HandlerFactory;
import ucll.project.ui.controller.Handler.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private UserService service;
    private HandlerFactory handlerFactory;


    @Override
    public void init() throws ServletException {
        super.init();
        QueueSyncronizer.getInstance().setController(this);
        handlerFactory = new HandlerFactory();
        service = new UserService();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String command = request.getParameter("command");
            if (command == null || command.trim().isEmpty()) {
                command = "Index";
            }
            RequestHandler handler = handlerFactory.getHandler(command, service);
            String destination = handler.handleRequest(request, response);
            handler.forwardRequest(destination, request, response);
        } catch (NotAuthorizedException e) {
            request.setAttribute("notAuthorized", "You have insufficient rights to have a look at the requested page.");
        }
    }
}

