package PostServices;

import PostClasses.CreatePostRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostClient {

        public Response getPostByOwnerId(String owner_id) {
            return given()
                        .header("app-id", "620d42883e7637c8c8c9a216")
                    .when()
                        .pathParam("owner_id", owner_id)
                    .get("https://dummyapi.io/data/v1/user/{owner_id}/post?limit=10");
        }

        public Response createPost(CreatePostRequestBody body) {
            return given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("app-id", "620d42883e7637c8c8c9a216")
                        .body(body)
                    .when()
                        .post("https://dummyapi.io/data/v1/post/create");
        }

    public Response deletePost(String postId) {
        return given()
                    .header("app-id", "620d42883e7637c8c8c9a216")
                .when()
                    .pathParam("post_id", postId)
                    .delete("https://dummyapi.io/data/v1/post/{post_id}");
    }

}
