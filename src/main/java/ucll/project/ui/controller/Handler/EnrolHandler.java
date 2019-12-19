package ucll.project.ui.controller.Handler;

import org.apache.commons.lang3.ObjectUtils;
import ucll.project.domain.user.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class EnrolHandler extends RequestHandler {
    public EnrolHandler(String command, UserService userService) {
        super(command, userService);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();
        User user = new User();
        Boolean answercheck = false;

        try{
            setFirstName(user,request,errors);
            setLastName(user,request,errors);
            setEmail(user,request,errors);
            setGender(user,request,errors);
            user.setDifficult(false);
            setVraag1(answercheck,user,request,errors);
            if (answercheck == true){
                setVraag2(user,request,errors);
            }
            setVraag3(user,request,errors);
            setVraag4(user,request,errors);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (errors.size() == 0){
            try{
                getUserService().addToWaitingList(user);
                request.setAttribute("submitted","block");

                RequestHandler requestHandler = new FormHandler(getCommand(),getUserService());
                requestHandler.setUserService(getUserService());
                String desti = requestHandler.handleRequest(request,response);
                return desti;
            } catch (DomainException exc) {
                request.setAttribute("error", exc.getMessage());
                request.setAttribute("errors",errors);
                return "form.jsp";
            }
        } else {
            request.setAttribute("errors", errors);
            return "form.jsp";
        }
    }

    protected void setFirstName(User user, HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        try {
            user.setFirstName(firstName);
            request.setAttribute("Class", "has-success");
            request.setAttribute("firstNamePV", firstName);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("firstNameClass", "has-error");
        }
    }

    protected void setLastName(User user, HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String lastName = request.getParameter("lastName");
        try {
            user.setLastName(lastName);
            request.setAttribute("Class", "has-success");
            request.setAttribute("lastNamePV", lastName);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("lastNameClass", "has-error");
        }
    }

    protected void setEmail(User user, HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String email = request.getParameter("email");
        try {
            user.setEmail(email);
            request.setAttribute("Class", "has-success");
            request.setAttribute("emailPV", email);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("emailClass", "has-error");
        }
    }

    protected void setGender(User user, HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String gender = "MALE";
        try {
            user.setGender(Gender.valueOf(gender));
            request.setAttribute("Class", "has-success");
            if (Gender.valueOf(gender) == Gender.MALE){
                request.setAttribute("gendermalePV", "checked");
            } else if(Gender.valueOf(gender) == Gender.FEMALE){
                request.setAttribute("genderfemalePV", "checked");
            }
            request.setAttribute("genderPV", gender);
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("genderClass", "has-error");
        } catch (NullPointerException exc){
            errors.add("Gender is empty!");
            request.setAttribute("genderClass", "has-error");
        }
    }

    protected void setVraag1(Boolean answercheck ,User user,HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String vraag1 = request.getParameter("vraag1");
        try {
            request.setAttribute("Class", "has-success");
            if (vraag1.equals("graduaat")){
                request.setAttribute("graduaatPV","checked");
            } else if (vraag1.equals("postgraduaat")){
                request.setAttribute("postgraduaatPV","checked");
            } else if (vraag1.equals("andereOPO")) {
                request.setAttribute("andereOPOPV", "checked");
                answercheck = true;
                user.setDifficult(true);
            }
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("vraag1Class", "has-error");
        } catch (NullPointerException exc){
            errors.add("Question one is empty!");
            request.setAttribute("vraagClass", "has-error");
        }
    }

    protected void setVraag2(User user,HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String vraag2 = request.getParameter("vraag2");
        try {
            request.setAttribute("Class", "has-success");
            if (vraag2.equals("middelbaar")){
                request.setAttribute("middelbaarPV","checked");
            } else if (vraag2.equals("bachelor")){
                request.setAttribute("bachelorPV","checked");
            } else if (vraag2.equals("andereVOPO")) {
                user.setDifficult(true);
                request.setAttribute("andereVOPOPV", "checked");
            }
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("vraag2Class", "has-error");
        } catch (NullPointerException exc){
            errors.add("Question 2 is empty!");
            request.setAttribute("vraag2Class", "has-error");
        }
    }

    protected void setVraag3(User user,HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String vraag3 = request.getParameter("vraag3");
        try {
            request.setAttribute("Class", "has-success");
            if (vraag3.equals("NL")){
                request.setAttribute("NLPV","checked");
            } else if (vraag3.equals("andereT")){
                request.setAttribute("andereTPV","checked");
                user.setDifficult(true);
            }
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("vraag3Class", "has-error");
        } catch (NullPointerException exc){
            errors.add("Question 3 is empty!");
            request.setAttribute("vraag3Class", "has-error");
        }
    }

    protected void setVraag4(User user,HttpServletRequest request,ArrayList<String> errors) throws ServletException, IOException {
        String vraag4 = request.getParameter("vraag4");
        try {
            request.setAttribute("Class", "has-success");
            if (vraag4.equals("YES")){
                request.setAttribute("YESPV","checked");
                user.setDifficult(true);
            } else if (vraag4.equals("NO")){
                request.setAttribute("NOPV","checked");
            }
        } catch (DomainException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("vraag4Class", "has-error");
        } catch (NullPointerException exc){
            errors.add("Question 4 is empty!");
            request.setAttribute("vraag1Class", "has-error");
        }
    }


}
