package com.aop.aopdemo;

import com.aop.aopdemo.dao.*;
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
	public CommandLineRunner commandLineRunner(
			AccountDAO theAccountDAO,
			MembershipDAO theMembershipDAO,
			WildcardDAO theWildcard,
			BooleanAccountDAO theBooleanAccount,
			AccountParameterDAO theAccountParameter) {
		return runner -> {

			demoBeforeAdvice(theAccountDAO, theMembershipDAO, theWildcard, theBooleanAccount, theAccountParameter);

		};
	}

	private void demoBeforeAdvice(
			AccountDAO theAccountDAO,
			MembershipDAO theMembershipDAO,
			WildcardDAO theWildcard,
			BooleanAccountDAO theBooleanAccount,
			AccountParameterDAO theAccountParameter) {
//		Call the business method
		theAccountDAO.addAccount();
		theAccountDAO.doWork();

//		Call the membership method
		theMembershipDAO.addAccount();

		theWildcard.addWithWildcard();

		theBooleanAccount.addAccount();
		theBooleanAccount.goToSleep();

		Account testAccount = new Account();
		theAccountParameter.addAccount(testAccount, true);


//		Call the accountDAO getter/setter methods
		theAccountDAO.setName("Foobar");
		theAccountDAO.setServiceCode("Silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

	}

}
