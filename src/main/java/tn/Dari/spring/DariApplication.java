package tn.Dari.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.Dari.spring.controller.AnnonceMeubleController;

import tn.Dari.spring.entity.User;
import tn.Dari.spring.service.UserServiceImpl;

@SpringBootApplication
public class DariApplication {

	public static void main(String[] args) {
		SpringApplication.run(DariApplication.class, args);
		
	}

}
