package com.example.JDBC4.demo.JDBC4.DBManager;

import com.example.JDBC4.demo.JDBC4.DAOs.Person;
import com.example.JDBC4.demo.JDBC4.Requests.CreateRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.JDBCType.VARCHAR;


public class DBOperations {

    public static volatile Connection connection; // volatile is used here from making the multiple connection
                                                    // connection variable in main memory

    public static Connection getConnection() throws SQLException {
    if (connection == null){
        synchronized (DBOperations.class){ // class level lock.
            if (connection == null){
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/person_4","root","rawatravi");
                //jdbc = java database connectivity using mysql.
                // 3306 is db port
                // 127.0.0.1 is a db Ip- Address
            }
        }
    }
        return connection;
    }


    public static void closeConnection() throws SQLException {
        if (connection != null){
            synchronized (DBOperations.class){
                if (connection != null){
                    connection=null;
                }
            }
        }
    }

    public static void createTable(String name) throws SQLException {

        getConnection();
//      statement --> The object used for executing a static SQL statement and returning the results it produces.
        Statement statement = connection.createStatement();
        boolean isCreated =statement.execute("CREATE TABLE " + name + " ( id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), age INT, " +
                "address VARCHAR(50))");

//        ("CREATE TABLE " + name + " ( id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), age INT, " +
//                "address VARCHAR(50))"

        if(isCreated) {
            System.out.println("table "+ name +" is successfully created");
        }

        closeConnection();

    }

    public static void insertPerson(CreateRequest request ) throws SQLException {

        getConnection();
//      preparedStatement -> An object that represents a precompiled SQL statement <P>A SQL statement is precompiled and stored in a <code>PreparedStatement</code> object.
//      This object can then be used to efficiently execute this statement multiple times.
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO person(id,name,age,address) VALUES (null,?,?,?)");
        preparedStatement.setString(1,request.getName());
        preparedStatement.setInt(2,request.getAge());
        preparedStatement.setString(3,request.getAddress());

        int rows_affected = preparedStatement.executeUpdate();

        if(rows_affected > 0) {
            System.out.println("successfully inserted the record");
        }else {
            System.out.println("unable to insert the record");
        }
        closeConnection();

//        Person person= new Person(request.getName(),request.getAge(),request.getAddrress());
//        Statement statement = connection.createStatement();
//        int rows_affected =statement.executeUpdate("INSERT INTO person VALUES()");
    }

    public Person getPersonById(){
        return null;
    }

    public static List<Person> getPersons() throws SQLException {

        // getting persons from the DB.
        getConnection();
//        Statement --> The object used for executing a static SQL statement and returning the results it produces.
        Statement statement= connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * FROM person");
        List<Person> persons= new ArrayList<>();
        while(resultSet.next()){
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String add = resultSet.getString(4);

            int id = resultSet.getInt(1);
            Person person= new Person(id,name,age,add);
            System.out.println(person);

            persons.add(person);
        }
        closeConnection();
        return persons;
    }

    public static  void deletePerson(int id){

    }

    public static void updatePerson(Person person){

    }
}

