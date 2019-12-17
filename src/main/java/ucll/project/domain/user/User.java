package ucll.project.domain.user;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends Person {
    private static int count = 0;
    private int userId;
    private boolean difficult = false;

    public User(){
        setUserId(++count);
        if (count >= 100) {
            count = 1;
        }
    }

    public User(String userName, String firstName, String lastName, String email, Gender gender) {
        super(userName, firstName, lastName, email, gender);
        setUserId(++count);
        System.out.println(count);
        if (count >= 100) {
            count = 1;
        }
    }

    // Getters and setters and toString

    public boolean isDifficult() {
        return difficult;
    }

    public void setDifficult(boolean difficult) {
        this.difficult = difficult;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
