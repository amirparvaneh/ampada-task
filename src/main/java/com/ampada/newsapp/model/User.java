package com.ampada.newsapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@Accessors(chain = true)
@Document(collection = "User")
public class User {

    @Id
    private String id;
    @Field("username")
    private String username;
    @Field("password")
    private String password;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    private List<Roles> roles = List.of(Roles.USER);


//        @Override
//        public String getAuthority() {
//            return super.toString();
//        }
}
//}
