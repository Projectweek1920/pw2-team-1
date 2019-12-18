package ucll.project.domain.user;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class User extends Person {
    private static int count = 0;
    private int userId;
    private boolean difficult = false;
    private String loket;
    private LocalTime tijdVanInschrijving;

    public User() {
        setUserId(++count);
        if (count >= 100) {
            count = 1;
        }
        tijdVanInschrijving = LocalTime.now();
    }

    public User(String userName, String firstName, String lastName, String email, Gender gender) {
        super(userName, firstName, lastName, email, gender);
        setUserId(++count);
        System.out.println(count);
        if (count >= 100) {
            count = 1;
        }
        tijdVanInschrijving = LocalTime.now();
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

    public String getFirstNamee(){
        return getFirstName();
    }

    public String getLastNamee(){
        return getLastName();
    }

    public String getEmaile(){
        return getEmail();
    }
    public String getLoket() {
        return loket;
    }

    public void setLoket(String loket) {


    }
    @Override
    public String toString() {
        return String.valueOf(this.getUserId()) + "\n";

    }
    public String getTijdVanInschrijving() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        return tijdVanInschrijving.format(dtf);
    }

    public void setTijdVanInschrijving(LocalTime tijdVanInschrijving) {
        this.tijdVanInschrijving = tijdVanInschrijving;
    }
}
