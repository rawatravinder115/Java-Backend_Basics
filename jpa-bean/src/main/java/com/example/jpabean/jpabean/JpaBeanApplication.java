package com.example.jpabean.jpabean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaBeanApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpaBeanApplication.class, args);

		// this is way of creating our own bean
//		// please comment out the jpa dependency in pom.xml because don't define the database here and this will give us the
//        // error  --> Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
//		//
//		//Reason: Failed to determine a suitable driver class
//
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		//  by this we can make our own bean which can be register with @Component
//
//		ctx.register(MyConfig.class);   // here we register our custom bean.
//		ctx.refresh(); // after register always refresh
//
//		HelloWorld obj1 = ctx.getBean(HelloWorld.class);
////		HelloWorld obj2 = ctx.getBean(HelloWorld.class);
//
////		obj1.setMsg("this is an object 1");
////		obj1.setData("AVBSD");
//
//		System.out.println(obj1);
////		System.out.println(obj2); // output by this also same as obj1 because due to beans,object is created once .
//
	}

}
