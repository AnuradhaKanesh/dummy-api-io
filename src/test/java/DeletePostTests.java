import PostClasses.DeletePostResponseBody;
import PostClasses.Post;
import PostServices.PostClient;
import PostServices.PostService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePostTests {


    @Test
    public void shouldDeletePostByPostId() {
        //Arrange
        String postId="620e4c04c7aeb926ebb94404";
        Response response = new PostClient().DeletePost(postId);

        //Act
        DeletePostResponseBody deletePostResponseBody= new PostService().deletePostById(response);

        //Assert
        Assert.assertEquals(deletePostResponseBody.getId(),postId);
        Assert.assertEquals(deletePostResponseBody.getStatusCode(),200);
    }
}
