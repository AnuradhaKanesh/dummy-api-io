import PostClasses.CreatePostRequestBody;
import PostClasses.CreatePostResponseBody;
import PostClasses.DeletePostResponseBody;
import PostServices.PostService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePostTests {

    @Test
    public void shouldCreateAndDeletePostByPostId() {
        //Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();
        CreatePostResponseBody createPostResponseBody = new PostService().createPost(requestBody);
        String postId = createPostResponseBody.getId();

        //Act
        DeletePostResponseBody deletePostResponseBody= new PostService().deletePostById(postId);

        //Assert
        Assert.assertEquals(deletePostResponseBody.getId(),postId);
        Assert.assertEquals(deletePostResponseBody.getStatusCode(),200);
    }
}
