package UserClasses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class RecentCreatedUserResponseBody {
        private String total;
        private List<Data> data;
        private String limit;
        private String page;

        @Setter
        private int statusCode;

        @Getter
        public static class Data {
                private String firstName;
                private String lastName;
                private String id;
        }
}
