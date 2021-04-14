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
		User user = new User("ravinder","$2a$10$Ift6z0o/8BB1p.ggECKnZObbtcZHj3USUSepU1PitHjqlHcfTOLlq",true,"admin/student");
		User user1 = new User("ravin","$2a$10$ozWXWmlvyr4hKf0jN5VjbuXbltOKGuK3jk746fXYIC2mnxDgSE3i2",true,"student");

//		ravi -> password [ravi]
//		ankit -> password [ankit]
//		i have used the bcrypted password so we dont PasswordEncoder here
		userRepository.save(user);
		userRepository.save(user1);
	}
}
