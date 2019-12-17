package ucll.project.domain.user;
import ucll.project.db.WaitingList;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;


import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserRepository userRepo;
    private WaitingList waitingList;
    private ArrayList arrayList = new ArrayList();


    public UserService(){
        userRepo = new UserRepositoryMemory();
        waitingList = new WaitingList();
    }

    public void addToWaitingList(User user){
        this.waitingList.addUser(user);
    }

    public List<User> getUsers() {
        return waitingList.getAll();
    }

    public void addUser(User user){
        this.arrayList.add(user);
    }

    public ArrayList<User> getAll(){
        return arrayList;
    }



}
