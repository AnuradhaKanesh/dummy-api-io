package UserClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
        @Setter
        private int statusCode;

        private String total;
        @JsonProperty("data")
        private List<Data> data;
        private String limit;
        private String page;

        @Getter
        public static class Data {
                private String firstName;
                private String lastName;
                private String id;
                private String title;
                private String picture;
        }
}
