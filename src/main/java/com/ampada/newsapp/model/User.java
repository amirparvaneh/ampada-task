package com.ampada.newsapp.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Document(collection = "User")
public class User {

    @Id
    private Long id;
    private String userName;
    private String password;
}
