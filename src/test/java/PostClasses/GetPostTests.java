package PostClasses;

import PostServices.PostClient;
import PostServices.PostService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetPostTests {

    @Test
    public void shouldGetPostByPostId() {
        //Arrange
        String postId="60d0fe4f5311236168a109ca";
        Response response = new PostClient().getPostById(postId);

        //Act
        Post post = new PostService().getPostById(response);

        //Assert
        post.assertPostResponse(postId);
    }
}
