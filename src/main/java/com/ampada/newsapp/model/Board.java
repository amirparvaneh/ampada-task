package com.ampada.newsapp.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Accessors(chain = true)
@Document(collection = "Board")
public class Board {

    @Id
    private String id;
    private String boardName;
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdOn;
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date modifiedOn;
    private User creatorId;

}
