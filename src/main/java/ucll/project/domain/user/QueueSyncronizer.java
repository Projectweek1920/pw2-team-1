package ucll.project.domain.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

public class QueueSyncronizer {
    private static QueueSyncronizer instance;
    private HashMap<HttpServletRequest, HttpServletResponse> doms = new HashMap<>();

    private QueueSyncronizer() {

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
