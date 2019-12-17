package ucll.project.db;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ucll.project.domain.user.Gender;
import ucll.project.domain.user.Role;
import ucll.project.domain.user.User;

import static org.junit.Assert.*;

public class WaitingListTest {

    private WaitingList waitingList = WaitingList.getInstance();
    private User ok,Nok,Nok1,Nok2;

    @Before
    public void setUp() {
        ok = new User("x","x","x","x@x.com", Gender.MALE, Role.ADMIN);
        Nok = new User("x","x","x","x@x.com", Gender.MALE, Role.ADMIN);
        Nok1 = new User("x","x","x","x@x.com", Gender.MALE, Role.ADMIN);
        Nok2 = new User("x","x","x","x@x.com", Gender.MALE, Role.ADMIN);
        Nok.setDifficult(true);
        ok.setDifficult(false);
        Nok1.setDifficult(false);
        Nok2.setDifficult(true);
    }

    @Test
    public void testAddCorrectUser() {
        waitingList.addUser(ok);
        waitingList.addUser(Nok);
        waitingList.addUser(Nok1);
        waitingList.addUser(Nok2);

        Assert.assertEquals(ok,waitingList.getEasy().peek());
        Assert.assertEquals(Nok,waitingList.getDifficult().peek());
    }

}