package com.example.DemoJPA4.DemoJPA4;

import com.example.DemoJPA4.DemoJPA4.Models.Book;
import com.example.DemoJPA4.DemoJPA4.Models.BookCategory;
import com.example.DemoJPA4.DemoJPA4.Repository.BookCategoryRepository;
import com.example.DemoJPA4.DemoJPA4.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoJpa4Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpa4Application.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookCategoryRepository bookCategoryRepository;

	@Override
	public void run(String... args) throws Exception {
////		bookRepository.save;
//		Book b1 = new Book();
//		b1.setId(1);
//		b1.setCost(30);
//		b1.setName("ABC");
//		b1.setAuthorName("Rahul");
//		bookRepository.save(b1);

		// saving multiple data at the time .
//		List<Book> books= new ArrayList<>();
//		Book b1 = new Book(2,"gfg","ravi",68);
//		Book b2 = new Book(1,"gfvgd","savi",86);
//
//		books.add(b1);
//		books.add(b2);
//
//		bookRepository.saveAll(books);

//		System.out.println(bookRepository.findAll());
//		System.out.println(bookRepository.findByAuthorName("ravi"));
//		System.out.println(bookRepository.findByCost(68));
//		System.out.println(bookRepository.findById(2));

		// exception --> because Author is not a property of book.java
//		System.out.println(bookRepository.findByAuthor("ravi"));
//		System.out.println(bookRepository.findByAuthors("ravi"));
//		System.out.println(bookRepository.findByCost(68));
//		System.out.println(bookRepository.findBycost(68));

		// both the func with same property parameter But one start with upper case and other with lower
		// so it will not matter how you write your property parameter but this is only for 1st latter.

		// to remove the temp files

		// for the @GeneratedValue Annotation
//		Book b1 =new Book("git","TIN",300);
//		bookRepository.save(b1);


		// but this give you error of Duplicate entry '1' for primary key because in db already a data is stored with id =1.
		// so use "create" in application.properties of earlier enteries wolud be deleted.

		Set<Book> books =new HashSet<>();
//		Book b1 = new Book("python","BOB",200);
//		Book b2 = new Book("Ruby on Rails","Lee",40);

//        Book b1 = new Book("HTML","BOB",200);
//        Book b2 = new Book("CSS","Louis",240,2);
        Book b2 = new Book("Jquery","Louis",240,5); // giving you a foreign key constraint fails because 5 (bookcategory) is not present in the main table. 
//		books.add(b1);
		books.add(b2);
//
//        bookRepository.save(b1);
        bookRepository.save(b2);
//		bookRepository.saveAll(books);

//		bookCategoryRepository.save(new BookCategory("no programming language"));
//
//		bookCategoryRepository.save(new BookCategory("programming language",books));

	}
}
