package ucll.project.domain.user;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Worker extends Person{

    private Role role;
    private String loket;
    private transient String hashedPassword;

    public Worker(){

    }

    public Worker(String userName, String firstName, String lastName, String email, Gender gender, Role role){
        super(userName, firstName, lastName, email,gender);
        setRole(role);
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void hashAndSetPassword(String password) {
        if (password.length() < 4) {
            throw new IllegalArgumentException("Too short password!");
        }
        String hashed = getPasswordToHashedPassword(password);
        setHashedPassword(hashed);
    }

    // This function will hash the password
    protected String getPasswordToHashedPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
        digest.update(password.getBytes(StandardCharsets.UTF_8));
        String hash = DatatypeConverter.printHexBinary(digest.digest()).toUpperCase();
        return hash;
    }

    public boolean isValidPassword(String password) {
        if (getHashedPassword() == null) {
            return false;
        }
        return getPasswordToHashedPassword(password).equals(getHashedPassword());
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setLoket(String loket) {
        this.loket = loket;
    }

    public String showUserName(){
        return this.getUserName();
    }

    public String toString() {
        return "User(userId=" + ", userName=" + this.getUserName() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", email=" + this.getEmail() + ", gender=" + this.getGender() + ", role=" + this.getRole() + ", hashedPassword=" + this.getHashedPassword() + ")";
    }

    public String toShowString(){
        return "Username: " + this.getUserName() + " name: " + this.getFirstName() + "." + this.getLastName() + " role: " + this.getRole();
    }

    public String getLoket() {
        return loket;
    }

    public void setUserId(int anInt) {
        super.setUserName(anInt+"");
    }

    public int getUserId() {
        return 0;
    }
}
