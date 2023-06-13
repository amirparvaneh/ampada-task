package com.ampada.newsapp.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "boards")
@Data
public class Board {
    @Id
    private String id;
    private String boardName;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    private String creatorId;
}
