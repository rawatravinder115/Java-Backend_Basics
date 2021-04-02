package com.example.javaProject;
import  java.util.HashMap;

public class DataStore {

    private  HashMap<String , String> store = new HashMap<String, String>();
    public DataStore(){
        store.put("sachin","A great Batsman");
        store.put("ravi","A great man");
        store.put("gfg","great and free website");
    }

    public String getFromDB(String word){
        return store.get(word);
    }
}
