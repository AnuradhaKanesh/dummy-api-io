package PostClasses;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;

@Getter
public class CreatePostResponseBody {
    @Setter
    private int statusCode;

    private String id;
    private Owner owner;
    private String image;
    private String link;
    private String publishDate;
    private String text;
    private String updatedDate;
    private int likes;
    private List<String> tags;

    @Getter
    public static class Owner {
        private String id;
        private String firstName;
        private String lastName;
        private String title;
        private String picture;
    }

    public void assertCreatedPost(CreatePostRequestBody requestBody) {
        Assert.assertEquals(this.getStatusCode(),200);
        Assert.assertEquals(this.getOwner().getId(),requestBody.getOwner());
        Assert.assertEquals(this.getImage(),requestBody.getImage());
        Assert.assertEquals(this.getLikes(),requestBody.getLikes());
        Assert.assertEquals(this.getTags(),requestBody.getTags());
        Assert.assertEquals(this.getText(),requestBody.getText());
    }

}
