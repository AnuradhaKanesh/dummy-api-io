import UserClasses.CreateUserErrorResponseBody;
import UserClasses.CreateUserRequestBody;
import UserServies.UserService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateUserNegativeTests extends BaseClass{


    @Test
    public void shouldCreateUser() {
        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().email("abc.xyz@gmail.com").build();

        //Act
        CreateUserErrorResponseBody createUserErrorResponseBody = userService.createUserExpectingError(requestBody);

        //Assert
        createUserErrorResponseBody.assertCreateUserError();
    }
}
