package com.study.doc.xml.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Book {
    private String id;
    private String name;
    private String author;
    private String year;
    private String price;
    private String language;
}
