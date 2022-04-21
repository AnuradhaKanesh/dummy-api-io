import PostClasses.CreatePostRequestBody;
import PostClasses.CreatePostResponseBody;
import PostClasses.Post;
import PostServices.PostService;
import org.testng.annotations.Test;

public class GetPostTests {

    @Test
    public void shouldGetAllPostsOfOwnerByOwnerId() {
        //Arrange
        CreatePostRequestBody requestBody = new CreatePostRequestBody.Builder().build();
        CreatePostResponseBody createPostResponseBody = new PostService().createPost(requestBody);
        String ownerId = createPostResponseBody.getOwner().getId();

        //Act
        Post post = new PostService().getPostById(ownerId);

        //Assert
        post.assertPostResponse(ownerId);
    }
}
