import UserClasses.RecentCreatedUserResponseBody;
import UserServies.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetCreatedUserByAccountTests {

    @Test
    public void getListOfUsersTest()
    {
        //Arrange //Act
        RecentCreatedUserResponseBody createdUserResponseBody = new UserService().getCreatedUser();

        //Assert
        Assert.assertEquals(createdUserResponseBody.getStatusCode(),200);
        Assert.assertEquals(createdUserResponseBody.getData().stream()
                .findFirst().get().getId(),"620d5317488484a39a0fe6d1");
    }
}
