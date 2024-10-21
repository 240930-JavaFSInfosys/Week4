package com.revature.models;

public class Pizza {

    private int pizza_id;
    private String cheeseType;
    private Topping topping;

    //boilerplate-----------------------
    public Pizza() {
    }

    public Pizza(int pizza_id, String cheeseType, Topping topping) {
        this.pizza_id = pizza_id;
        this.cheeseType = cheeseType;
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
