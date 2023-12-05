package com.softwaremethodologyandroidpp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that manages the Pepperoni pizza specialty.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public class Pepperoni extends Pizza {
    private static final DecimalFormat decimalFormat = new DecimalFormat(
            "0.00");

    /**
     * Method that handles creating a Pepperoni speciality pizza.
     */
    public Pepperoni() {
        this.toppings = new ArrayList<>(Arrays.asList(Topping.PEPPERONI));
        this.sauce = Sauce.TOMATO;
    }

    /**
     * Method that handles getting the price of pizza per size.
     *
     * @return price of pizza per size.
     */
    @Override
    public double getSizePrice() {
        if (this.size == Size.SMALL) {
            return 10.99;
        }
        else if (this.size == Size.MEDIUM) {
            return 12.99;
        }
        else {
            return 14.99;
        }
    }

    /**
     * Method that handles formatting price of pizza.
     *
     * @return price of pizza formatted.
     */
    @Override
    public double price() {
        return Double.parseDouble(decimalFormat.format(
                getSizePrice() + extraCheeseAmount() +
                        extraSauceAmount()));
    }

    /**
     * Method that handles getting all toppings of pizza as a String.
     *
     * @return toppings of pizza formatted in String.
     */
    @Override
    public String getToppingsAsString() {
        String toppingsAsString = "";
        for (int i = 0; i < this.toppings.size(); i++) {
            if (i == this.toppings.size() - 1) {
                toppingsAsString += this.toppings.get(i).toString();
            }
            else {
                toppingsAsString += this.toppings.get(i).toString() + ", ";
            }
        }
        return toppingsAsString;
    }

    /**
     * Method that handles getting all toppings of a pizza.
     *
     * @return all toppings of pizza from arraylist.
     */
    @Override
    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    /**
     * Method that handles returning information about pizza as a toString.
     *
     * @return toString of pizza information.
     */
    @Override
    public String toString() {
        return "[Pepperoni]" + "[" + getSizeAsString() + "]" + "[" +
                getSauceAsString() + "]: " + getToppingsAsString() +
                extraCheeseString() + extraSauceString() + ": " + "$" +
                price();
    }

    /**
     * Method that returns String name of pizza
     * @return String name of the pizza
     */
    @Override
    public String getPizzaNameAsString(){
        return "Pepperoni";
    }
}
