package UserServies;

import UserClasses.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    public Response getAllUsersList() {
        return given()
                    .header("app-id", "620d42883e7637c8c8c9a216")
                .when()
                    .pathParam("limit", 10)
                .get("https://dummyapi.io/data/v1/user?{limit}");

    }
    public Response getRecentCreatedUsers() {
        return given()
                    .header("app-id", "620d42883e7637c8c8c9a216")
                .when()
                    .get("https://dummyapi.io/data/v1/user?created=1");

    }

    public Response CreateUser(CreateUserRequestBody body) {
        return given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id", "620d42883e7637c8c8c9a216")
                    .body(body)
                .when()
                    .post("https://dummyapi.io/data/v1/user/create");
    }

    public Response deleteUser(String userId) {
        return given()
                .header("app-id", "620d42883e7637c8c8c9a216")
                .when()
                .pathParam("user_id", userId)
                .delete("https://dummyapi.io/data/v1/user/{user_id}");
}

    public Response getUserById(String userId) {
        return given()
                    .header("app-id", "620d42883e7637c8c8c9a216")
                .when()
                    .pathParam("user_id", userId)
                    .get("https://dummyapi.io/data/v1/user/{user_id}");
    }
}
