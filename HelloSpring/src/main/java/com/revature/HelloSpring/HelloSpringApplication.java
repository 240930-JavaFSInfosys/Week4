package com.revature.HelloSpring;

import com.revature.models.Pizza;
import com.revature.models.Topping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);

		//Create an ApplicationContext object based off our applicationContext.xml file
		//This object will serve as our Spring IoC Container, and manage our beans + dependency injection
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		ApplicationContext ac =
				new ClassPathXmlApplicationContext("annotationDrivenApplicationContext.xml");

		//We can now use our ApplicationContext (our Spring Container) to do a bunch of stuff with beans
		String[] beanNames = ac.getBeanDefinitionNames();
		for(String bean : beanNames){
			System.out.println(bean);
		}

		//Ask for a Topping bean and print it out
		Topping t = ac.getBean(Topping.class);
		System.out.println(t);

		//Nothing super interesting here^ we just have a Topping object with default values

		//Ask for a Pizza bean and print it out
		Pizza p = ac.getBean(Pizza.class);
		System.out.println(p);

		//WOW! We have a Pizza object with a Topping object DEPENDENCY INJECTED for us!
			//We have a whole Topping object instead of a null value right at instantiation
		//It was instantiated and set for us by Spring, since we made Topping a dependency of Pizza

		//Give some values to the Pizza bean
		p.setPizza_id(1);
		p.setCheeseType("Mozzarella");
		p.getTopping().setTopping_id(1);
		p.getTopping().setTopping_name("Pepperoni");
		System.out.println(p); //Print it out again

	}

}