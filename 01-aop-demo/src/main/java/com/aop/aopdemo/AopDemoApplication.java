package com.aop.aopdemo;

import com.aop.aopdemo.dao.AccountDAO;
import com.aop.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	// Spring Boot will automatically inject the dependency because @Bean annotation
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		return runner -> {

			demoBeforeAdvice(theAccountDAO, theMembershipDAO);

		};
	}

	private void demoBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
//		Call the business method
		theAccountDAO.addAccount();

//		Call the membership method
		theMembershipDAO.addAccount();

	}

}
