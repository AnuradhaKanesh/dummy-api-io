import UserClasses.CreateUserRequestBody;
import UserClasses.CreateUserResponseBody;
import UserClasses.User;
import UserServies.UserService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateUserTests {

    private UserService userService;

    @BeforeMethod
    public void before() {
        userService = new UserService();
    }

    @Test
    public void shouldCreateUser() {
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().firstname("Aditi").lastname("krishnan").build();

        //Act
        CreateUserResponseBody createUserResponseBody = userService.createUser(requestBody);

        //Assert
        createUserResponseBody.assertUser(requestBody);
    }
}
