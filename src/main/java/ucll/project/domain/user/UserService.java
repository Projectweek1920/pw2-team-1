package ucll.project.domain.user;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.util.List;

public class UserService {
    private UserRepository userRepo;

    public UserService() {
        userRepo = new UserRepositoryDb();
    }

    public List<User> getUsers() {
        return userRepo.getAll();
    }
}
