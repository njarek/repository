package pl.jojco.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.jojco.pojo.Basket;

public class StartH2 {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("pl/jojco/database/h2.xml");
		context.start();
		
	}

}
