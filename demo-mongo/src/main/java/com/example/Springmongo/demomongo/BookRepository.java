package com.example.Springmongo.demomongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,Integer> {

//    @Query()         // it's totally optional
    public List<Book> findByAuthorName(String name);

}
