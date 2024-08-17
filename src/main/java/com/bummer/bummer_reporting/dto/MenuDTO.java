package com.bummer.bummer_reporting.dto;

import lombok.Data;

@Data
public class MenuDTO {
    private Long id;
    private String itemName;
    private String description;
    private Double price;
    private String cuisine;
}
