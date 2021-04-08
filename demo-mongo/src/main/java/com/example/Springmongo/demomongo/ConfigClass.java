package com.example.Springmongo.demomongo;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.*;
import com.mongodb.client.internal.MongoDatabaseImpl;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.CreateViewOptions;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConfigClass {

//    @Bean
//    public MongoDatabase getMovieDatabase(){
//        return new MongoDatabaseImpl("movies",null,null,null,null);
//    }
//
//    @Bean
//    public MongoDatabase getBookDatabase(){
//        return new MongoDatabaseImpl("book",null,null,null,);
//    }
}
