package com.ampada.newsapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "cards")
@Data
public class Card {
    @Id
    private String id;
    private String cardTitle;
    private String boardId;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    private List<String> members;

}
