package ucll.project.domain.user;

import ucll.project.db.WaitingList;

import java.util.List;

public class UserService {
    private UserRepository userRepo;
    private WaitingList waitingList;

    public UserService(){
        userRepo = new UserRepositoryMemory();
        waitingList = new WaitingList();
    }

    public List<User> getUsers(){
        return userRepo.getAll();
    }
}
