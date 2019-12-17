package ucll.project.domain.user;

import ucll.project.ui.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QueueSyncronizer {
    private static QueueSyncronizer instance;
    private Controller controller;
    private HashMap<HttpServletRequest, HttpServletResponse> doms = new HashMap<>();

    private QueueSyncronizer() {

    }

    public void updateListeners() throws ServletException, IOException, InterruptedException {
        while(true){
            for(Map.Entry<HttpServletRequest, HttpServletResponse> entry : doms.entrySet()){
                this.controller.processRequest(entry.getKey(),entry.getValue());
            }
            wait(7000);
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public static synchronized QueueSyncronizer getInstance(){
        if(instance==null){
            instance= new QueueSyncronizer();
        }
        return instance;
    }

    public HashMap<HttpServletRequest, HttpServletResponse> getDoms() {
        return doms;
    }

    public void addDom(HttpServletRequest request, HttpServletResponse response) {
        this.doms.put(request,response);
    }

    public boolean inDomList(HttpServletRequest request, HttpServletResponse response){
        return (this.doms.containsKey(request)&&this.doms.get(request)==response);
    }
}
