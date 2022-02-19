package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

@NoArgsConstructor
@Setter
@Getter
public class BookDTO {
    
    private Integer id;
    private String name;
    private String description;
    private String author;
    private String genre;
}
