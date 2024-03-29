package ucll.project.domain.user;
import ucll.project.db.WaitingList;

import java.util.List;

public class UserService {
    private UserRepository userRepo;
    private WaitingList waitingList = WaitingList.getInstance();

    public UserService(){
        userRepo = new UserRepositoryDb();
    }

    public Worker getCertainUserRepo(String userName){
        Worker usertest = null;
        for(Worker worker : userRepo.getAll()){
            if(worker.getUserName().equals(userName)){
                usertest = worker;
            }
        }
        return usertest;
    }

    public List<Worker> getUserRepo(){
        return this.userRepo.getAll();
    }

    public void addUserRepo(Worker worker,String password){
        userRepo.createUser(worker,password);
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
    public User nextEasyUser() {
        //if user is jobstudent
        //deze staat op difficcult omdat het algo een beetje derp is atm.
        //TODO: bij fix algo difficult
        return waitingList.getEasy().peek();
        //else if admin
        //return waitingList.getDifficult().peek();
    }

    public User nextDifficultUser() {
        return waitingList.getDifficult().peek();
    }

    public void clickNextEasy() {
        waitingList.getEasy().remove(nextEasyUser());
    }
    public void clickNextDifficult(){
        waitingList.getDifficult().remove(nextDifficultUser());
    }


    public void markEasyAsComplex(int userid) {
        waitingList.addDifficultAsFirst(getUserWithId(userid));
    }

    public User getUserWithId(int userid){
        User temp = null;
        for(User u : waitingList.getAanDeBeurt()){
            if(u.getUserId()==userid){
                temp = u;
                break;
            }
        }
        return temp;
    }
}
