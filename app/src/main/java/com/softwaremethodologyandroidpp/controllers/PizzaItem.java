package com.softwaremethodologyandroidpp.controllers;

import com.softwaremethodologyandroidpp.Pizza;

public class PizzaItem {
    private Pizza pizza;
    private int image;

    public PizzaItem(Pizza pizza, int image){
        this.pizza = pizza;
        this.image = image;
    }

    public Pizza getPizza(){
        return this.pizza;
    }

    public int getImage() {
        return this.image;
    }

    public void setPizza(Pizza pizza){
        this.pizza = pizza;
    }

    public void setImage(int image){
        this.image = image;
    }
}
