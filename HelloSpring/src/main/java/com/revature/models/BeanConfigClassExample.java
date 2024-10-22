package com.revature.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//If we wanted to use a Java Class for bean config, we need the @Configuration annotation
@Configuration
public class BeanConfigClassExample {

    //NOTE: THIS ACCOMPLISHES THE SAME THING AS OUR applicationContext.xml - registering beans
    //Just Class-based instead of XML-based

    //We would specify our beans here with the @Bean annotation
    @Bean
    public Topping topping(){
        return new Topping(1, "Pepperoni");
    }

    //Pizza has Topping as a dependency
    @Bean
    public Pizza pizza(){
        return new Pizza(1, "Mozzarella", topping());
    }

    //ETC..

    /* Then we could make an ApplicationContext object in our main method like this:

    ApplicationContext ac = new AnnotationConfigApplicationContext(BeanConfigClassExample.class); */

}
