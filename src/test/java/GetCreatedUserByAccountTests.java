import PostClasses.CreatePostRequestBody;
import PostClasses.CreatePostResponseBody;
import UserClasses.CreateUserRequestBody;
import UserClasses.CreateUserResponseBody;
import UserClasses.RecentCreatedUserResponseBody;
import UserServies.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.Stream;

public class GetCreatedUserByAccountTests extends BaseClass {

    @Test
    public void shouldGetRecentCreatedUser() {
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
