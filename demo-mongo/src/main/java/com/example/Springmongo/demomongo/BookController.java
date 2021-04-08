package com.example.Springmongo.demomongo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/getBooks")
    public List<Book>  getBook(){
        return bookRepository.findAll();
    }

//    @GetMapping("/insertBook")
//    public void insertBook(@RequestBody CreateRequest request){
//        Book book= new Book(request.getName(),request.getAuthorName(),request.getCost());
//        bookRepository.save(book);
//    }

    @GetMapping("/insertBook")
    public void insertBook(@RequestBody CreateRequest request){
        Book book= new Book(request.getName(),request.getAuthorName(),request.getCost(),request.get_count());
        bookRepository.save(book);
    }

    // getBookByAuthor?name=""
//    @GetMapping("/getBooksByAuthor")
//    public List<Book> getBookByAuthorName(@RequestParam(value="name") String name){
//        return bookRepository.findByAuthorName(name);
//    }

    // getBookByAuthor/""
    @GetMapping("/getBooksByAuthor/{name}")
    public List<Book> getBookByAuthorName(@PathVariable(value="name") String name){
        return bookRepository.findByAuthorName(name);
    }


}
