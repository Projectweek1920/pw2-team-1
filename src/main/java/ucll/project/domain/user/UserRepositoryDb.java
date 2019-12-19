
package ucll.project.domain.user;

import ucll.project.db.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryDb implements UserRepository {

    @Override
    public void createUser(Worker user, String password) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO \"Personeel\" " +
                     "(rnummer, firstname, lastname, role, loket) VALUES (?, ?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS))
        {
            //user.hashAndSetPassword(password);
            stmtSetUser(stmt, 1, user);
            if (stmt.executeUpdate() == 0) {
                throw new RuntimeException("Failed to create user");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                generatedKeys.next();
                user.setUserId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Worker get(int userId) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM \"user\" WHERE id = ?"))
        {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return userFromResult(rs);
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Worker> getAll() {
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM \"user\""))
        {
            List<Worker> users = new ArrayList<>();
            while (rs.next()) {
                users.add(userFromResult(rs));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Worker loginUser(String username, String password) throws InvalidLogin {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM \"user\" WHERE username = ?"))
        {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    throw new InvalidLogin("Invalid username");
                }

                Worker user = userFromResult(rs);
                if (!user.isValidPassword(password)) {
                    throw new InvalidLogin("Invalid password");
                }

                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Worker user) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE \"user\" SET " +
                     "username = ?, firstname = ?, lastname = ?, email = ?, gender = ?, role = ?, password = ? " +
                     "WHERE id = ? "))
        {
            int i = stmtSetUser(stmt, 1, user);
            stmt.setInt(i, user.getUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Worker user) {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM \"user\" WHERE id = ?"))
        {
            stmt.setInt(1, user.getUserId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Worker userFromResult(ResultSet rs) throws SQLException {
        Worker user = new Worker();
        user.setUserId(rs.getInt("id"));
        user.setUserName(rs.getString("username"));
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setRole(Role.valueOf(rs.getString("role")));
        return user;
    }

    private static int stmtSetUser(PreparedStatement stmt, int i, Worker user) throws SQLException {
        stmt.setString(i++, user.getUserName());
        stmt.setString(i++, user.getFirstName());
        stmt.setString(i++, user.getLastName());
        stmt.setString(i++, user.getRole().toString());
        stmt.setString(i++, user.getLoket().toString());
        return i;
    }
}
