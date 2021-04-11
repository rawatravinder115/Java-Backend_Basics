package com.example.Securityjpa.Securityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityJpaApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("ravi","$2a$10$RZ1WuodG1zKHrKREKyNjIe.mzZeI86lVRmOozrccIjLL1YJ0HvIzu",true,"admin/student");
		User user1 = new User("ankit","$2a$10$Iqfj1JlbdlwBlw.wRoU7vOr6YFDiqCr3X/oAGNekwCfoIwAIUoTiW",true,"student");

//		ravi -> password [ravi]
//		ankit -> password [ankit]
//		i have used the bcrypted password so we dont PasswordEncoder here
		userRepository.save(user);
		userRepository.save(user1);
	}
}
