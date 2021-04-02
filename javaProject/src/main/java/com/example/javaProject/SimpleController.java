package com.example.javaProject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.*;

@RestController
public class SimpleController {


    @GetMapping("/hi")
    public String sayHi(){
        return "hello from the server";
    }

    // http://localhost:8080/searh?q=sachin  -->  // here q= query parameter.
    //https://api.github.com/users/shashipk  --> // here shashipk is path parameter (path param).
    @GetMapping("/searh")
    public String searchAWorld(@RequestParam String q ){
        DataStore db= new DataStore();
        return db.getFromDB(q);
    }

    DBUser db = new DBUser();

   /// http://localhost:8080/users   --> get api
    @GetMapping("/users")
    public List<User> getAllUsers(){
    return  db.getAllUser();
    }

//    //http://localhost:8080/users{id}   --> get api using id.
    @GetMapping("/users/{id}")
    public User getAUser(@PathVariable int id){
        return  db.getAUser(id);
    }

    // here is the code for the customizing the headers of the response
    // according to ourSelf.


//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getAUser(@PathVariable int id){
//        User user1=db.getAUser(id);
//        MultiValueMap<String , String> headers= new LinkedMultiValueMap<>();
//        headers.put("server", Collections.singletonList("codeofRavinder"));
//        HttpStatus status= HttpStatus.CREATED;
//        ResponseEntity<User> response = new ResponseEntity<User>(user1,headers,status);
//        return response;
//    }

    /// http://localhost:8080/user/q=name
    @GetMapping("/user")
    public User getAUser(@RequestParam String q){
        return  db.getAUserByName(q);
    }

    /// POST APIs =================================================

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createUser(@RequestBody User user){
        return db.addUser(user);  // for post api, we use "RequestBody"
    }

    /// DELETE APIs =======================================

    @DeleteMapping("users/{id}")
    public boolean deleteAUser(@PathVariable int id){
        return db.DeleteUser(id);
    }

    // 4xx -- Issue with client
    // 2xx -- fine
    // 5xx -- Issue with server
    // 3xx --

}
