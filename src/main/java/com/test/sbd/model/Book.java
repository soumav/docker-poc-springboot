package com.test.sbd.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Book")
public class Book {
	
	@Transient
    public static final String SEQUENCE_NAME = "customSequences";
	
	@Id
	Long id;
	String name;
	String author;
	
}
