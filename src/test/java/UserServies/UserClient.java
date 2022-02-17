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

    public Response CreateUser(CreateUserRequestBody body) {
        return given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("app-id", "620d42883e7637c8c8c9a216")
                    .body(body)
                .when()
                    .post("https://dummyapi.io/data/v1/user/create");
    }

}