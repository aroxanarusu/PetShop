package com.example.PetShop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.provider.HibernateUtils;

@SpringBootApplication
public class PetShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetShopApplication.class, args);

	}



}
