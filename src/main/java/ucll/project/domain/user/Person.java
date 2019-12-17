package ucll.project.domain.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;

    public Person(){

    }

    public Person(String userName, String firstName, String lastName, String email, Gender gender) {
        setUserName(userName);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setGender(gender);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
        if (email.trim().isEmpty() || !mat.matches()) throw new IllegalArgumentException("invalid email");
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "";
    }
}
