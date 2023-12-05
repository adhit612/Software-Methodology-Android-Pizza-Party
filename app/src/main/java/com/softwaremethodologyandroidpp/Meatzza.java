package com.softwaremethodologyandroidpp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that manages the Meatzza speciality.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public class Meatzza extends Pizza {
    private static final DecimalFormat decimalFormat = new DecimalFormat(
            "0" +
            ".00");

    /**
     * Method that handles creating a Meatzza speciality pizza.
     */
    public Meatzza() {
        this.toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE,
                Topping.PEPPERONI, Topping.BEEF, Topping.HAM));
        this.sauce = Sauce.TOMATO;
    }

    /**
     * Method that handles getting the price of size for pizza.
     *
     * @return price of pizza per size.
     */
    @Override
    public double getSizePrice() {
        if (this.size == Size.SMALL) {
            return 16.99;
        }
        else if (this.size == Size.MEDIUM) {
            return 18.99;
        }
        else {
            return 20.99;
        }
    }

    /**
     * Method that handles formatting of total pizza price.
     *
     * @return price of pizza in formatted form.
     */
    @Override
    public double price() {
        return Double.parseDouble(decimalFormat.format(getSizePrice()
                + extraCheeseAmount() + extraSauceAmount()));
    }

    /**
     * Method that handles returing all toppings for a pizza in String.
     *
     * @return toppings of pizza in string.
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
     * Method that handles getting all toppings for a pizza.
     *
     * @return toppings of pizza from arraylist.
     */
    @Override
    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    /**
     * Method that handles printing whole pizza order in toString.
     *
     * @return toString of pizza information.
     */
    @Override
    public String toString() {
        return "[Meatzza]" + "[" + getSizeAsString() + "]" + "[" +
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
        return "Meatzza";
    }
}
