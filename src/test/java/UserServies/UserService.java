package UserServies;

import UserClasses.*;
import io.restassured.response.Response;

public class UserService {

    public User getAllUsersList() {
        Response response = new UserClient().getAllUsersList();
        response.then().log().body();
        User user = response.as(User.class);
        user.setStatusCode(response.getStatusCode());

        return user;
    }

    public CreateUserResponseBody createUser(CreateUserRequestBody requestBody) {
        Response response = new UserClient().CreateUser(requestBody);
        CreateUserResponseBody createUserResponseBody = response.as(CreateUserResponseBody.class);
        createUserResponseBody.setStatusCode(response.getStatusCode());

        return createUserResponseBody;
    }

    public CreateUserErrorResponseBody createUserExpectingError(CreateUserRequestBody requestBody) {
        Response response = new UserClient().CreateUser(requestBody);
        CreateUserErrorResponseBody createUserErrorResponseBody = response.as(CreateUserErrorResponseBody.class);
        createUserErrorResponseBody.setStatusCode(response.getStatusCode());
        response.then().log().body();
        return createUserErrorResponseBody;
    }

    public RecentCreatedUserResponseBody getCreatedUser() {
        Response response = new UserClient().getRecentCreatedUsers();
        response.then().log().body();
        RecentCreatedUserResponseBody createdUserResponseBody = response.as(RecentCreatedUserResponseBody.class);
        createdUserResponseBody.setStatusCode(response.getStatusCode());
        return createdUserResponseBody;
    }
}
