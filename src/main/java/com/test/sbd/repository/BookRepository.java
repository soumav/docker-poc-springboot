package com.test.sbd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.sbd.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Long> {

}
