package PostClasses;

import lombok.Getter;
import lombok.Setter;

@Getter
public class DeletePostResponseBody {
        private String id;
        @Setter
        private int statusCode;
}
