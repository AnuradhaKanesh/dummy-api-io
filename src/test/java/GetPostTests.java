import PostClasses.CreatePostRequestBody;
import PostClasses.CreatePostResponseBody;
import PostClasses.Post;
import PostServices.PostClient;
import PostServices.PostService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetPostTests {

    @Test
    public void shouldCreateAndGetPostByPostId() {
        //Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();
        CreatePostResponseBody createPostResponseBody = new PostService().createPost(requestBody);
        String postId = createPostResponseBody.getId();

        //Act
        Post post = new PostService().getPostById(postId);

        //Assert
        post.assertPostResponse(postId);
    }
}
