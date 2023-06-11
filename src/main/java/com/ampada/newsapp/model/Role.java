package com.ampada.newsapp.model;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Document(collection = "Role")
public class Role {
    private String USER;
    private String ADMIN;
}
