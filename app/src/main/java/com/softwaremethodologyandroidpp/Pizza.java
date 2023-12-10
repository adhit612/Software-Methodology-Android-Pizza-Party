package com.softwaremethodologyandroidpp;

import java.util.*;

/**
 * Class that manages the general pizza.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings;
    protected Size size;
    protected Sauce sauce;
    protected double toppingsIncrement;
    protected boolean extraSauce;
    protected boolean extraCheese;

    /**
     * Method that handles the price of a pizza.
     */
    public abstract double price();

    /**
     * Method that handles getting price of pizza per size.
     */
    public abstract double getSizePrice();

    /**
     * Method that handles getting toppings of pizza in string format.
     */
    public abstract String getToppingsAsString();

    /**
     * Method that handles getting toppings of a pizza.
     */
    public abstract ArrayList<Topping> getToppings();

    /**
     * Method that returns pizza name to be used in recyclerview
     * @return String name of the pizza
     */
    public abstract String getPizzaNameAsString();

    /**
     * Method that handles setting toppings of a pizza.
     */
    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    /**
     * Method that handles extra cheese price.
     *
     * @return 1.00 if extra cheese is added, 0.0 otherwise
     */
    public double extraCheeseAmount() {
        if (extraCheese) {
            return 1.00;
        }
        else {
            return 0.0;
        }
    }

    /**
     * Method that handles extra sauce price.
     *
     * @return 1.00 if extra sauce is added, 0.0 otherwise.
     */
    public double extraSauceAmount() {
        if (extraSauce) {
            return 1.00;
        }
        else {
            return 0.0;
        }
    }

    /**
     * Method that handles extra cheese as a string.
     *
     * @return String saying if extra cheese is added.
     */
    public String extraCheeseString() {
        if (extraCheese) {
            return ", Extra cheese ";
        }
        else {
            return "";
        }
    }

    /**
     * Method that handles extra sauce as a string.
     *
     * @return String saying if extra sauce is added
     */
    public String extraSauceString() {
        if (extraSauce) {
            return ", Extra sauce";
        }
        else {
            return "";
        }
    }

    /**
     * Method that handles incrementing price by each extra topping.
     */
    public void incrementToppingsAmount() {
        this.toppingsIncrement += 1.49;
    }

    /**
     * Method that handles decrementing price by each extra topping.
     */
    public void decrementToppingsAmount() {
        this.toppingsIncrement -= 1.49;
    }

    /**
     * Method that handles getting the toppings that are extra.
     */
    public double getToppingsIncrement() {
        return this.toppingsIncrement;
    }

    /**
     * Method that handles setting size of pizza.
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Method that handles setting the sauce of pizza.
     */
    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    /**
     * Method that handles extra sauce of pizza.
     */
    public void addExtraSauce() {
        extraSauce = true;
    }

    /**
     * Method that handles removing extra sauce.
     */
    public void removeExtraSauce() {
        extraSauce = false;
    }

    /**
     * Method that handles adding extra cheese.
     */
    public void addExtraCheese() {
        extraCheese = true;
    }

    /**
     * Method that handles removing extra cheese.
     */
    public void removeExtraCheese() {
        extraCheese = false;
    }

    /**
     * Method that handles getting the size of pizza.
     *
     * @return size of pizza.
     */
    public Size getSize() {
        return this.size;
    }

    /**
     * Method that handles getting the sauce of the pizza.
     *
     * @return sauce of pizza.
     */
    public Sauce getSauce() {
        return this.sauce;
    }

    /**
     * Method that handles getting size of pizza as a string.
     *
     * @return size of pizza as string.
     */
    public String getSizeAsString() {
        return this.size.toString();
    }

    /**
     * Method that handles getting sauce of pizza as a string.
     *
     * @return sauce of pizza as string.
     */
    public String getSauceAsString() {
        return this.sauce.toString();
    }

    /**
     * Method that handles if two pizzas are equal to one another.
     *
     * @return false if the pizzas are not equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pizza) {
            Pizza pizza = (Pizza) obj;
            return this.getToppings().equals(pizza.getToppings()) &&
                    this.price() == pizza.price();
        }
        return false;
    }
}
