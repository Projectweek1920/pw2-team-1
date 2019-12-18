package ucll.project.domain.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

    private Person person;

    private String username = "Wout123";
    private String firstname = "Wout";
    private String lastname = "De Boeck";
    private String email = "wout.deboeck@gmail.com";
    private Gender gender = Gender.MALE;

    //setup

    @Before
    public void setUp() {
        person = new Person(username, firstname, lastname, email, gender);
    }

    //username

    @Test
    public void usernameGetsSet() {
        Assert.assertEquals(username, person.getUserName());
    }

    @Test
    public void usernameCanChange() {
        String newName = "Bob567";

        person.setUserName(newName);
        Assert.assertEquals(newName, person.getUserName());
    }

    @Test
    public void usernameSyntaxCheck() {
        boolean errorOccurred = false;

        try {
            person.setUserName("");
        } catch (DomainException e) {
            errorOccurred = true;
        }

        Assert.assertEquals(true, errorOccurred);
    }

    //firstname

    @Test
    public void firstnameGetsSet() {
        Assert.assertEquals(firstname, person.getFirstName());
    }

    @Test
    public void firstnameCanChange() {
        String newName = "Bob";

        person.setFirstName(newName);

        Assert.assertEquals(newName, person.getFirstName());
    }

    @Test
    public void firstnameSyntaxCheck() {
        boolean errorOccurred = false;

        try {
            person.setFirstName("");
        } catch (DomainException e) {
            errorOccurred = true;
        }

        Assert.assertEquals(true, errorOccurred);
    }

    //lastname

    @Test
    public void lastnameGetsSet() {
        Assert.assertEquals(lastname, person.getLastName());
    }

    @Test
    public void lastnameCanChange() {
        String newName = "Bobson";
        person.setLastName(newName);

        Assert.assertEquals(newName, person.getLastName());
    }

    @Test
    public void lastnameSyntaxCheck() {
        boolean errorOccurred = false;

        try {
            person.setLastName("");
        } catch (DomainException e) {
            errorOccurred = true;
        }

        Assert.assertEquals(true, errorOccurred);
    }

    //email

    @Test
    public void emailGetsSet() {
        Assert.assertEquals(email, person.getEmail());
    }

    @Test
    public void emailCanChange() {
        String newEmail = "bob.bobson@student.ucll.be";
        person.setEmail(newEmail);

        Assert.assertEquals(newEmail, person.getEmail());
    }

    @Test
    public void emailCantBeEmpty()
    {
        boolean errorOccurred = false;

        try
        {
            person.setEmail("");
        }
        catch(DomainException e)
        {
           errorOccurred = true;
        }

        Assert.assertEquals(true, errorOccurred);
    }

    @Test
    public void emailSyntaxChecked()
    {
        int errors = 0;

        try
        {
            person.setEmail("bob.bobsonstudent.ucll.be");
        }
        catch(DomainException e)
        {
            errors++;
        }

        try
        {
            person.setEmail("bobbobson@studentucllbe");
        }
        catch(DomainException e)
        {
            errors++;
        }

        Assert.assertEquals(2, errors);
    }

    //gender

    @Test
    public void genderGetsChecked()
    {
        Assert.assertEquals(gender, person.getGender());
    }

    @Test
    public void genderCanChange()
    {
        Gender newGender = Gender.FEMALE;
        person.setGender(newGender);

        Assert.assertEquals(newGender, person.getGender());
    }
}
