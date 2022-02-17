package IntegratedTests;

import UserClasses.*;
import UserServies.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndIntegrationTests {

    String id = "";

    @Test
    public void createUserAndDeleteUserAndUserDoNotExist() {
        //create user
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder()
                .firstname("test").lastname("case").email("testcase1@gmail.com").build();

        CreateUserResponseBody createUserResponseBody = new UserService().createUser(requestBody);

        Assert.assertEquals(createUserResponseBody.getStatusCode(), 200);
        Assert.assertEquals(createUserResponseBody.getFirstName(), requestBody.getFirstName());
        Assert.assertEquals(createUserResponseBody.getLastName(), requestBody.getLastName());
        Assert.assertEquals(createUserResponseBody.getEmail(), requestBody.getEmail());

        id = createUserResponseBody.getId();
    }

    @Test
    public void deletUser() {

        //delete user
        int statusCode = new UserService().deleteUserById(id);
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void verifyUserIsDeleted() {
        //try to get deleted user
        int statusCode = new UserService().getUserById(id);
        Assert.assertEquals(statusCode, 404);
    }

}
