package IntegratedTests;

import UserClasses.*;
import UserServies.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndIntegrationTests {


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

        String userId = createUserResponseBody.getId();

        //delete user
        int deleteStatusCode = new UserService().deleteUserById(userId);
        Assert.assertEquals(deleteStatusCode, 200);

        //try to get deleted user
        int getStatusCode = new UserService().getUserById(userId);
        Assert.assertEquals(getStatusCode, 404);
    }

}
