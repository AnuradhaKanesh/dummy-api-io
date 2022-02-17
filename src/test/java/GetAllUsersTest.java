import UserClasses.User;
import UserServies.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllUsersTest {

    @Test
    public void getListOfUsersTest()
    {
        User users = new UserService().getAllUsersList();

        Assert.assertEquals(users.getStatusCode(),200);
    }


}
