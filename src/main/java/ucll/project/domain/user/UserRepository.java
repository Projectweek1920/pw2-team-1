package ucll.project.domain.user;

import java.util.List;

public interface UserRepository {

    // CREATE
    void createUser(Worker worker, String password);

    // READ ONE
    Worker get(int workerId);

    // READ ALL
    List<Worker> getAll();

    // LOGIN (= GET but with password check)
    Worker loginUser(String username, String password) throws InvalidLogin;

    // UPDATE
    void update(Worker worker);

    // DELETE
    void delete(Worker worker);
}
