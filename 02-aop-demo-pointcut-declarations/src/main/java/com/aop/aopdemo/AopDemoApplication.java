package com.aop.aopdemo;

import com.aop.aopdemo.dao.*;
import com.aop.aopdemo.services.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			AccountParameterDAO theAccountParameter,
			TrafficFortuneService trafficFortuneService) {
		return runner -> {

//			demoBeforeAdvice(theAccountDAO, theMembershipDAO, theWildcard, theBooleanAccount, theAccountParameter);
//			demoAfterReturningAdviceDAO(theAccountDAO);
//			demoAfterThrowingAdvice(theAccountDAO);
//			demoAfterAdvice(theAccountDAO);
//			demoAroundAdvice(trafficFortuneService);
//			demoAroundAdviceHandleException(trafficFortuneService);
			demoAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n--------------- MAIN APP : demoAroundAdviceRethrowException() ---------------");
		System.out.println("Calling  ----  >  getFortune()");

		boolean tripWire = true;  // < TRUE or FALSE checking

		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\n--------------- Today fortune is : " + data + " ---------------");
		System.out.println("Completed!!!!");
	}

	private void demoAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n--------------- MAIN APP : demoAroundAdviceHandleException() ---------------");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;  // < TRUE or FALSE checking
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\n--------------- Today fortune is : " + data + " ---------------");
		System.out.println("Completed!!!!");
	}


	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n--------------- MAIN APP : demoAroundAdvice() ---------------");
		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("\n--------------- Today fortune is : " + data + " ---------------");
		System.out.println("Completed!!!!");
	}

	private void demoAfterAdvice(AccountDAO theAccountDAO) {
//		Call method to find the accounts
		List<Account> theAccounts = null;

		try {
//			add a boolean flag to simulate exceptions
			boolean tripWire = true; // < TRUE or FALSE checking
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exception) {
			System.out.println("\n--------------- >>> Main app - Caught an Exception : " + exception + " <<< ---------------");
		}

//		Display the accounts
		System.out.println("\n--------------- >>> Main app - Demo after Advice <<< ---------------");
		System.out.println("");
		System.out.println(theAccounts);
		System.out.println("");
	}

	private void demoAfterThrowingAdvice(AccountDAO theAccountDAO) {
//		Call method to find the accounts
		List<Account> theAccounts = null;

		try {
//			add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exception) {
			System.out.println("\n\n--------------- >>> Main app - Caught an Exception : " + exception + " <<< ---------------");
		}

//		Display the accounts
		System.out.println("\n\n--------------- >>> Main app - Demo after Advice <<< ---------------");
		System.out.println("--------");
		System.out.println(theAccounts);
		System.out.println("--------");
	}

	private void demoAfterReturningAdviceDAO(AccountDAO theAccountDAO) {
//		Call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

//		Display the accounts
		System.out.println("\n\n============= >>> Main app - Demo after return <<< =============");
		System.out.println("--------");
		System.out.println(theAccounts);
		System.out.println("--------");
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
		testAccount.setName("Zukkii");
		testAccount.setLevel("DOG_GOD");
		theAccountParameter.addAccount(testAccount, true);


//		Call the accountDAO getter/setter methods
		theAccountDAO.setName("Foobar");
		theAccountDAO.setServiceCode("Silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

	}

}
