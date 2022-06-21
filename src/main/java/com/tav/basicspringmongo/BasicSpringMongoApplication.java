package com.tav.basicspringmongo;

import com.tav.basicspringmongo.entities.User;
import com.tav.basicspringmongo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicSpringMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicSpringMongoApplication.class, args);
	}

}
