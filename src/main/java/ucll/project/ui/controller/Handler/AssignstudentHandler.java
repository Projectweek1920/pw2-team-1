package ucll.project.ui.controller.Handler;

import ucll.project.domain.user.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AssignstudentHandler extends RequestHandler {
    public AssignstudentHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();
        Worker worker = new Worker();

        try{
            setUserName(worker,request,errors);
            setFirstName(worker,request,errors);
            setLastName(worker,request,errors);
            setEmail(worker,request,errors);
            setGender(worker,request,errors);
            setRole(worker,request,errors);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (errors.size() == 0){
            try{
                getUserService().addUserRepo(worker,"P@ssw0rd");
                RequestHandler requestHandler = new showStudentListHandler(getCommand(),getUserService());
                requestHandler.setUserService(getUserService());
                String desti = requestHandler.handleRequest(request,response);
                return desti;
            } catch (DomainException exc) {
                request.setAttribute("error", exc.getMessage());
                request.setAttribute("errors",errors);
                return "assignstudent.jsp";
            }
        } else {
            request.setAttribute("errors", errors);
            return "assignstudent.jsp";
        }
    }

    protected void setUserName(Worker worker, HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        try {
            worker.setUserName(userName);
            request.setAttribute("Class", "has-success");
            request.setAttribute("userNamePV", userName);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("userNameClass", "has-error");
        }
    }

    protected void setFirstName(Worker worker, HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        try {
            worker.setFirstName(firstName);
            request.setAttribute("Class", "has-success");
            request.setAttribute("firstNamePV", firstName);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("firstNameClass", "has-error");
        }
    }

    protected void setLastName(Worker worker, HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String lastName = request.getParameter("lastName");
        try {
            worker.setLastName(lastName);
            request.setAttribute("Class", "has-success");
            request.setAttribute("lastNamePV", lastName);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("lastNameClass", "has-error");
        }
    }

    protected void setEmail(Worker worker, HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String email = request.getParameter("email");
        try {
            worker.setEmail(email);
            request.setAttribute("Class", "has-success");
            request.setAttribute("emailPV", email);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("emailClass", "has-error");
        }
    }

    protected void setGender(Worker worker, HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String gender = request.getParameter("gender");
        try {
            System.out.println(gender);
            worker.setGender(Gender.valueOf(gender));
            request.setAttribute("Class", "has-success");
            request.setAttribute("genderPV", gender);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("genderClass", "has-error");
        }
    }

    protected void setRole(Worker worker, HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String role = request.getParameter("worker");
        try {
            worker.setRole(Role.valueOf(role));
            request.setAttribute("Class", "has-success");
            request.setAttribute("rolePV", role);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("roleClass", "has-error");
        }
    }
}
