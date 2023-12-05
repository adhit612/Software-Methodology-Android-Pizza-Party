package com.softwaremethodologyandroidpp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that manages building your own pizza.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public class BuildYourOwn extends Pizza {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0" +
            ".00");

    /**
     * Method that handles initializing building your own pizza.
     */
    public BuildYourOwn() {
        this.toppingsIncrement = 0.0;
        this.extraSauce = false;
        this.extraCheese = false;
    }

    /**
     * Method that handles getting the price for each size.
     *
     * @return price of pizza.
     */
    @Override
    public double getSizePrice() {
        if (this.size == Size.SMALL) {
            return 8.99;
        } else if (this.size == Size.MEDIUM) {
            return 10.99;
        } else {
            return 12.99;
        }
    }

    /**
     * Method that handles total price of pizza.
     *
     * @return price of pizza formatted.
     */
    @Override
    public double price() {
        return Double.parseDouble(decimalFormat.format(getSizePrice()
                + extraCheeseAmount() + extraSauceAmount() +
                getToppingsIncrement()));
    }

    /**
     * Method that handles getting toppings as a string.
     *
     * @return toppings as a string.
     */
    @Override
    public String getToppingsAsString() {
        String toppingsAsString = "";

        if (this.toppings == null) {
            return "";
        }

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
     * Method that handles returning all toppings of a pizza.
     *
     * @return all toppings.
     */
    @Override
    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    /**
     * Method that handles returning toString of whole pizza.
     *
     * @return toString of pizza information.
     */
    @Override
    public String toString() {
        if (this.extraCheese == false || this.extraSauce == false) {
            return "[Build Your Own]" + "[" + getSizeAsString() + "]" + "["
                    + getSauceAsString() + "]: " + getToppingsAsString() +
                    extraCheeseString().replace(",", "") +
                    extraSauceString().replace(",", "") +
                    ": " + "$" + price();
        }
        return "[Build Your Own]" + "[" + getSizeAsString() + "]" + "[" +
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
        return "Build Own";
    }
}




