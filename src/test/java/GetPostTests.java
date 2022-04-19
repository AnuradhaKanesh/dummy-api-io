import PostClasses.Post;
import PostServices.PostClient;
import PostServices.PostService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetPostTests {

    @Test
    public void shouldGetPostByPostId() {
        //Arrange
        String postId="60d0fe4f5311236168a109ca";


        //Act
        Post post = new PostService().getPostById(postId);

        //Assert
        post.assertPostResponse(postId);
    }
}
