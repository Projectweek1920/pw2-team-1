package ucll.project.domain.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryMemory implements UserRepository {
    private Map<Integer, Worker> workers = new HashMap<Integer, Worker>();

    public UserRepositoryMemory() {
        DummyUserData.addData(this);
    }

    @Override
    public void createUser(Worker worker, String password) {
        for (Worker u : workers.values()) {
            if (u.getUserName().equals(worker.getUserName())) {
                throw new IllegalArgumentException("Username already in use");
            }
            if (u.getEmail().equals(worker.getEmail())) {
                throw new IllegalArgumentException("Email already in use");
            }
        }
        int userId = workers.size() + 1;
        worker.hashAndSetPassword(password);
        workers.put(userId, worker);
    }

    @Override
    public Worker get(int userId) {
        return workers.get(userId);
    }

    @Override
    public List<Worker> getAll() {
        return new ArrayList<Worker>(workers.values());
    }

    @Override
    public Worker loginUser(String username, String password) throws InvalidLogin {
        for (Worker u : workers.values()) {
            if (u.getEmail().equals(username) || u.getUserName().equals(username)) {
                if (u.isValidPassword(password)) {
                    return u;
                } else {
                    throw new InvalidLogin("Invalid password");
                }
            }
        }
        throw new InvalidLogin("Invalid username");
    }

    @Override
    public void update(Worker worker) {

    }

    @Override
    public void delete(Worker worker) {

    }
}
