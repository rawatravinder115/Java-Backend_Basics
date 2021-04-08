package com.example.DemoJPA4.DemoJPA4.Models;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Iterator;
import java.util.Set;

@Entity
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    // [ Auto ]  -> implemented by hibernate
    // insert the first entry in table 1 -> 1
    // insert the first entry in table 2 -> 2
    // insert the second entry in table 1 -> 3

    // [ Identity ]  -> implemented by sql server
    // insert the first entry in table 1 -> 1
    // insert the first entry in table 2 -> 1
    // insert the second entry in table 1 -> 2

    // one ->  class in which yoy are present.
    // many -> another class.
    @OneToMany(mappedBy = "bookCategory",cascade =CascadeType.ALL )
    private Set<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public BookCategory(String name) {
        this.name = name;
    }

    public BookCategory(String name, Set<Book> books) {
        this.name = name;
        this.books = books;

        this.books.forEach(x -> x.setBookCategory(this)); // using java streams

//        Iterator it = books.iterator();
//        while(it.hasNext()){
//            Book book = (Book)it.next();
//            book.setBookCategory(this);
//        }

    }

    public BookCategory() {
    }
}
