package PostServices;

import PostClasses.CreatePostRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostClient {

        public Response getPostById(String postId) {
            return given()
                        .header("app-id", "620d42883e7637c8c8c9a216")
                    .when()
                        .pathParam("post_id", postId)
                    .get("https://dummyapi.io/data/v1/user/{post_id}/post?limit=10");
        }

        public Response CreatePost(CreatePostRequestBody body) {
            return given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("app-id", "620d42883e7637c8c8c9a216")
                        .body(body)
                    .when()
                        .post("https://dummyapi.io/data/v1/post/create");
        }

}
