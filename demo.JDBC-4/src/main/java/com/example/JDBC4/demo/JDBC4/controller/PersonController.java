package com.example.JDBC4.demo.JDBC4.controller;

import com.example.JDBC4.demo.JDBC4.DAOs.Person;
import com.example.JDBC4.demo.JDBC4.DBManager.DBOperations;
import com.example.JDBC4.demo.JDBC4.Requests.CreateRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PersonController {


    //http://localhost:8080/getPersons
    @RequestMapping(value ="/getPersons",method= RequestMethod.GET)
    public List<Person> getPersons() throws SQLException {

        // calling dao to get objects from db.
       return  DBOperations.getPersons();
    }

    //curl -XPOST "127.0.0.1:8080/createTable?name=person" -> put command in cmd
    @RequestMapping(value="/createTable",method=RequestMethod.POST)
    public void createTable(@RequestParam(value = "name") String name) throws SQLException {
        DBOperations.createTable(name);
    }

    //http://localhost:8080/insertPerson
    @RequestMapping(value="/insertPerson",method=RequestMethod.POST)
    public  void insertPerson(@RequestBody CreateRequest request) throws SQLException {
        DBOperations.insertPerson(request);
     }
}
