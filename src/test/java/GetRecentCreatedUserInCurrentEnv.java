import UserClasses.CreateUserRequestBody;
import UserClasses.CreateUserResponseBody;
import UserClasses.RecentCreatedUserResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRecentCreatedUserInCurrentEnv extends BaseClass {

    @Test
    public void shouldGetRecentCreatedUserInCurrentEnv() {
        //Arrange
        CreateUserRequestBody request = new CreateUserRequestBody.Builder().firstname("test").lastname("krishnan").build();
        CreateUserResponseBody response = userService.createUser(request);


        // Act
        RecentCreatedUserResponseBody createdUserResponseBody = userService.getCreatedUser();

        //Assert
        Assert.assertEquals(createdUserResponseBody.getStatusCode(), 200);

        String recentUserId = createdUserResponseBody.getData().stream().reduce((first, second) -> second)
                .orElse(null).getId();
        Assert.assertEquals(recentUserId, response.getId());
    }
}
