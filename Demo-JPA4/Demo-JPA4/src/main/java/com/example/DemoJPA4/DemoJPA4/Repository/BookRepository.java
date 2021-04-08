package com.example.DemoJPA4.DemoJPA4.Repository;


import com.example.DemoJPA4.DemoJPA4.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> { // jpa only for sql databases
    // remember when you are defining repository, specify two things (type of object you want ot save,data type of primary key).
    // Integer = object here we use it because Syntex need object .

// to fetch all the books with name = "ABC"

//    @Query("select * from book where book.name = name")
//    List<Book> findByName(String name)

//    public List<Book> findByAuthorName(String name);
//    List<Book> findByCost(int cost);
//    Book findById(int id);

//    {
    // when ever you specify the func findBy..  and after that you gave the property
    // name {any name which is a valid property name } will not give any error and gave appropriately result.
//    }

    // native sql language -> always consider column name
    @Query(value="select * from Book b where b.Author_name=:name",nativeQuery = true) // here we take AuthorName as a Author_name because hibernate convert// camel case into the (underscore + gap) that's we write it like that.
    public List<Book> findByAuthor(String name);

    // jpql -> java persistence query language because it do mapping from the java object it doesn't consider the column name.
    // name should same as the java object(property name).
    @Query(value="select b from Book b where b.authorName =:authors_name")
    public List<Book> findByAuthors(String authors_name);

    List<Book> findByCost(int cost);
    List<Book> findBycost(int cost);



}