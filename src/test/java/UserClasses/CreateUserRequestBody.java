package UserClasses;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
public class CreateUserRequestBody
{
        @Setter
        private int statusCode;

        private String lastName;
        private String firstName;
        private String email;

        public CreateUserRequestBody(Builder builder)
        {
               this.email= builder.email;
               this.firstName= builder.firstName;
               this.lastName= builder.lastName;
        }

        public static class Builder
        {
                private String lastName;
                private String firstName;
                private String email;

                public Builder()
                {
                        this.lastName="xyz";
                        this.firstName="abc";
                        this.email =String.format("%s@gmail.com", UUID.randomUUID());
                }
                public Builder lastname(String lastName)
                {
                        this.lastName = lastName;
                        return this;
                }
                public Builder firstname(String firstName)
                {
                        this.firstName = firstName;
                        return this;
                }
                public Builder email(String email)
                {
                        this.email = email;
                        return this;
                }

                public CreateUserRequestBody build()
                {
                       return new CreateUserRequestBody(this);
                }
        }

}
