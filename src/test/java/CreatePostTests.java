import PostClasses.CreatePostRequestBody;
import PostClasses.CreatePostResponseBody;
import PostServices.PostService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreatePostTests extends BaseClass{


    @Test
    public void shouldCreatePost() {
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();

        //Act
        CreatePostResponseBody createPostResponseBody = postService.createPost(requestBody);

        //Assert
        createPostResponseBody.assertCreatedPost(requestBody);
    }

}


