package com.softwaremethodologyandroidpp.controllers;

import com.softwaremethodologyandroidpp.Pizza;

/**
 * Class to manage a pizza item for recycler view.
 * @author Abhishek Thakare, Adhit Thakur.
 */

public class PizzaItem {
    private Pizza pizza;
    private int image;

    /**
     * Constructor to set up item.
     * @param pizza pizza for item.
     * @param image image associated to pizza.
     */
    public PizzaItem(Pizza pizza, int image){
        this.pizza = pizza;
        this.image = image;
    }

    /**
     * Getter method for pizza.
     * @return Pizza of item.
     */
    public Pizza getPizza(){
        return this.pizza;
    }

    /**
     * Getter method for image for pizza.
     * @return image associated to pizza.
     */
    public int getImage() {
        return this.image;
    }

    /**
     * Setter method for Pizza.
     * @param pizza pizza to set the new pizza to.
     */
    public void setPizza(Pizza pizza){
        this.pizza = pizza;
    }

    /**
     * Setter method for image.
     * @param image image to set the Pizza's image to.
     */
    public void setImage(int image){
        this.image = image;
    }
}
