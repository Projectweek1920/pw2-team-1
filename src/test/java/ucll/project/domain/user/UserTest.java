package ucll.project.domain.user;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest
{

    private static User user;

    private static String username = "Wout123";
    private static String firstname = "Wout";
    private static String lastname = "De Boeck";
    private static String email = "wout.deboeck@gmail.com";
    private static Gender gender = Gender.MALE;

    private static int id;

    @BeforeClass
    public static void setup()
    {
        user = new User(username, firstname, lastname, email, gender);

        id = user.getUserId();
    }

    @Test
    public void userIdGetsSet()
    {
        assertEquals(id, user.getUserId());
    }

    @Test
    public void userIdIncrementsOnNewUser()
    {
        User user2 = new User(username, firstname, lastname, email, gender);

        assertEquals(id + 1, user2.getUserId());
    }

    @Test
    public void userDifficultyCanBeSet()
    {
        user.setDifficult(true);

        assertEquals(true, user.isDifficult());
    }

}