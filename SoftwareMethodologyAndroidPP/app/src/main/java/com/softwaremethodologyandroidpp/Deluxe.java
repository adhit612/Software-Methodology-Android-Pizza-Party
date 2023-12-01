package com.softwaremethodologyandroidpp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that manages Deluxe pizza.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public class Deluxe extends Pizza {

    private static final DecimalFormat decimalFormat = new DecimalFormat(
            "0" +
            ".00");

    /**
     * Method that handles initializing a Deluxe pizza.
     */
    public Deluxe() {
        this.extraSauce = false;
        this.extraCheese = false;
        this.toppings = new ArrayList<>(Arrays.asList(Topping.SAUSAGE,
                Topping.PEPPERONI, Topping.GREENPEPPER, Topping.ONION,
                Topping.MUSHROOM));
        this.sauce = Sauce.TOMATO;
    }

    /**
     * Method that handles getting the price for a size of pizza.
     *
     * @return price of pizza per size.
     */
    @Override
    public double getSizePrice() {
        if (this.size == Size.SMALL) {
            return 14.99;
        } else if (this.size == Size.MEDIUM) {
            return 16.99;
        } else {
            return 18.99;
        }
    }

    /**
     * Method that handles formatting total price of pizza.
     *
     * @return price of pizza formatted.
     */
    @Override
    public double price() {
        return Double.parseDouble(decimalFormat.format(getSizePrice()
                + extraCheeseAmount() + extraSauceAmount()));
    }

    /**
     * Method that handles getting toppings of pizza.
     *
     * @return toppings of pizza as string.
     */
    @Override
    public String getToppingsAsString() {
        String toppingsAsString = "";
        for (int i = 0; i < this.toppings.size(); i++) {
            if (i == this.toppings.size() - 1) {
                toppingsAsString += this.toppings.get(i).toString();
            } else {
                toppingsAsString += this.toppings.get(i).toString() + ", ";
            }
        }
        return toppingsAsString;
    }

    /**
     * Method that handles returning all toppings of pizza.
     *
     * @return pizza toppings from arraylist.
     */
    @Override
    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    /**
     * Method that handles returning whole pizza order as toString.
     *
     * @return pizza information in toString format.
     */
    @Override
    public String toString() {
        return "[Deluxe]" + "[" + getSizeAsString() + "]" + "[" +
                getSauceAsString() + "]: " + getToppingsAsString() +
                extraCheeseString() + extraSauceString() + ": " + "$" +
                price();
    }
}
