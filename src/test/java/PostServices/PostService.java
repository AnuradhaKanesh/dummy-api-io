package PostServices;

import PostClasses.CreatePostRequestBody;
import PostClasses.CreatePostResponseBody;
import PostClasses.DeletePostResponseBody;
import PostClasses.Post;
import io.restassured.response.Response;

public class PostService {

    public Post getPostById(String ownerId) {
        Response response = new PostClient().getPostByOwnerId(ownerId);
        response.then().log().body();
        Post post = response.as(Post.class);
        post.setStatusCode(response.getStatusCode());
        return post;
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
