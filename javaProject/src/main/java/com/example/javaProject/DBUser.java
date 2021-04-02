package com.example.javaProject;

import org.springframework.context.annotation.EnableMBeanExport;

import java.util.ArrayList;
import java.util.List;

public class DBUser {

    private List<User> userTable= new ArrayList<User>();
    public DBUser(){
        userTable.add(new User(1,"ramu",30));
        userTable.add(new User(2,"raka",40));
    }

    public List<User> getAllUser(){
        return userTable;
    }

    public User getAUser(int id){
        for(User user :userTable){
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public  User getAUserByName(String name){
        for(User user :userTable){
            if (user.getName().equals(name))
                return user;
        }
        return null;
    }

    public boolean addUser(User user){
        userTable.add(user);
        return  true;
    }

    public  boolean DeleteUser(int id){
        for(User user :userTable){
            if (user.getId() == id) {
                userTable.remove(user);
                return true;
            }
        }
        return false;
    }

}
