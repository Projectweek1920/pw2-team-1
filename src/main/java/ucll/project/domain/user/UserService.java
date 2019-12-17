package ucll.project.domain.user;
import ucll.project.db.WaitingList;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;


import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserRepository userRepo;
    private WaitingList waitingList = WaitingList.getInstance();

    public UserService(){
        User user = new User("Admin","Wout","De Boeck","WoutDeBoeck@gmail.com",Gender.MALE,Role.ADMIN);
        userRepo = new UserRepositoryMemory();
        userRepo.createUser(user,"P@ssw0rd");
    }

    public User getCertainUserRepo(String userName){
        User usertest = null;
        for(User user : userRepo.getAll()){
            if(user.getUserName().equals(userName)){
                usertest = user;
            }
        }
        return usertest;
    }

    public List<User> getUserRepo(){
        return this.userRepo.getAll();
    }

    public void addToWaitingList(User user){
        this.waitingList.addUser(user);
    }

    public List<User> getUsers() {
        return waitingList.getAll();
    }

    public void addUser(User user){
        this.waitingList.addUser(user);
    }

    public User nextUser() {
        //if user is jobstudent
        //deze staat op difficcult omdat het algo een beetje derp is atm.
        //TODO: bij fix algo difficult
        return waitingList.getDifficult().peek();
        //else if admin
        //return waitingList.getDifficult().peek();
    }

    public void clickNext() {
        waitingList.getDifficult().remove(nextUser());
        waitingList.getEasy().remove(nextUser());
    }
}
