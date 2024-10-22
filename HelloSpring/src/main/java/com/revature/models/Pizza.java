package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //again, a stereotype annotations, we want this class to be a bean
@Scope("prototype") //Changing the scope from singleton to prototype so we can have multiple pizza objects
public class Pizza {

    private int pizza_id;
    private String cheeseType;

    //@Autowired //Field Injection - BAD! Breaks Encapsulation (but it still works)
    private Topping topping; //Topping is a dependency of Pizza!

    //boilerplate-----------------------
    public Pizza() {
    }

    public Pizza(int pizza_id, String cheeseType, Topping topping) {
        this.pizza_id = pizza_id;
        this.cheeseType = cheeseType;
        this.topping = topping;
    }

    //For construction injection (which I prefer), we need a constructor for dependencies
    @Autowired //Constructor Injection - BEST PRACTICE
    public Pizza(Topping topping) {
        this.topping = topping;
    }

    public int getPizza_id() {
        return pizza_id;
    }

    public void setPizza_id(int pizza_id) {
        this.pizza_id = pizza_id;
    }

    public String getCheeseType() {
        return cheeseType;
    }

    public void setCheeseType(String cheeseType) {
        this.cheeseType = cheeseType;
    }

    public Topping getTopping() {
        return topping;
    }

    //@Autowired //Setter Injection - Usually used if there are optional dependencies
    //Fun fact: Setter Injection is the default when we use XML-based bean configuration
    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizza_id=" + pizza_id +
                ", cheeseType='" + cheeseType + '\'' +
                ", topping=" + topping +
                '}';
    }
}