package UserClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.testng.Assert;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponseBody {

    private String firstName;
    private String lastName;
    private String id;
    private String updatedDate;
    private String email;
    private String registerDate;

    @Setter
    private int statusCode;

    public void assertUser(CreateUserRequestBody requestBody) {
            Assert.assertEquals(this.getStatusCode(),201);
            Assert.assertEquals(this.getFirstName(),requestBody.getFirstName());
            Assert.assertEquals(this.getLastName(),requestBody.getLastName());
            Assert.assertEquals(this.getEmail(),requestBody.getEmail());
    }
}
