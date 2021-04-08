package com.example.DemoJPA4.DemoJPA4.Models;

import javax.persistence.*;

@Entity
//@Table(name="my_book")
public class Book {

    // for every class containing the @Entity Annotation will have the default as well
    // as user defined constructor.

    // if you are not defining a user defined Constructor then no need to define default
    // because java will automatically generate it.

    @Id  // -> to make it primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // for auto incrementation of Id by hibernate.
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // for auto incrementation of Id by mysql.
    private int id;

//    @Column(name = "book_name")   // to change the column name use column annotation.
    private String name;
    private String authorName; // hibernate take Camel case as a under+gap.
//    @Column(name = "price")
    private int cost;

    @ManyToOne
    @JoinColumn  // join the primary key of this table.
    private BookCategory bookCategory;

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Book(int id, String name, String authorName, int cost) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
    }

    public Book(String name, String authorName, int cost) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
    }

    public Book(String name, String authorName, int cost, int bookCategory) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
        this.bookCategory = new BookCategory(); //you current BookCategory is null and you cant set it with int  bcoz this is a object and you passed int so must have to
        this.bookCategory.setId(bookCategory); // initialize data first.
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "{ name = " + this.getName() + ", authorname = "+this.authorName +", cost = "+this.cost+" }";
    }




}

