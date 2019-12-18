package ucll.project.domain.user;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private static User user;

    private static String username = "Wout123";
    private static String firstname = "Wout";
    private static String lastname = "De Boeck";
    private static String email = "wout.deboeck@gmail.com";
    private static Gender gender = Gender.MALE;

    @BeforeClass
    public static void setup()
    {
        user = new User(username, firstname, lastname, email, gender);
    }

    @Test
    public void userIdGetsSet()
    {
        assertEquals(1, user.getUserId());
    }

    @Test
    public void userIdIncrementsOnNewUser()
    {
        User user2 = new User(username, firstname, lastname, email, gender);

        assertEquals(2, user2.getUserId());
    }

    @Test
    public void userDifficultyCanBeSet()
    {
        user.setDifficult(true);

        assertEquals(true, user.isDifficult());
    }

}