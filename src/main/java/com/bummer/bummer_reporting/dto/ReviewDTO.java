package com.bummer.bummer_reporting.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReviewDTO {
    private Long id;
    private String reviewBlob;
    private Integer upvotes;
    private Integer downvotes;
    private Integer reportType;
    private String timestamp;
    private List<String> reviewKeywords;
    private List<CommentsDTO> reviewReplies;

}
