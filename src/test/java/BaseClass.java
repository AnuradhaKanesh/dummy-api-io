import PostServices.PostService;
import UserServies.UserService;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    public UserService userService;
    public PostService postService;

    @BeforeMethod
    public void before() {
        postService = new PostService();
        userService = new UserService();
    }
}
