import PostClasses.CreatePostRequestBody;
import PostClasses.CreatePostResponseBody;
import PostServices.PostService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreatePostTests {
    private PostService postService;

    @BeforeMethod
    public void before() {
        postService = new PostService();
    }

    @Test
    public void shouldCreatePost() {
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //Act
        CreatePostResponseBody createPostResponseBody = postService.createPost(requestBody);

        //Assert
        createPostResponseBody.assertCreatedPost(requestBody);
    }

}


