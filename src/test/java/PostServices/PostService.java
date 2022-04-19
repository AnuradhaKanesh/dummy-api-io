package PostServices;

import PostClasses.CreatePostRequestBody;
import PostClasses.CreatePostResponseBody;
import PostClasses.DeletePostResponseBody;
import PostClasses.Post;
import io.restassured.response.Response;

public class PostService {

    public Post getPostById(String postId) {
        Response response = new PostClient().getPostById(postId);
        response.then().log().body();
        Post Post = response.as(Post.class);
        Post.setStatusCode(response.getStatusCode());
        return Post;
    }

    public DeletePostResponseBody deletePostById(String postId) {
        Response response = new PostClient().deletePost(postId);
        response.then().log().body();
        DeletePostResponseBody deletePost = response.as(DeletePostResponseBody.class);
        deletePost.setStatusCode(response.getStatusCode());
        return deletePost;
    }

    public CreatePostResponseBody createPost(CreatePostRequestBody requestBody) {
        Response response = new PostClient().createPost(requestBody);
        CreatePostResponseBody createPostResponseBody = response.as(CreatePostResponseBody.class);
        createPostResponseBody.setStatusCode(response.getStatusCode());
        return createPostResponseBody;
    }

}
