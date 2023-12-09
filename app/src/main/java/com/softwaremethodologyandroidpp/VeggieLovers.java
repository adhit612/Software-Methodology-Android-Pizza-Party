package com.softwaremethodologyandroidpp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class that manages VeggieLovers pizza.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */

public class VeggieLovers extends Pizza{
    private static final DecimalFormat decimalFormat = new DecimalFormat(
            "0" +
                    ".00");

    /**
     * Method that creates Supreme speciality pizza.
     */
    public VeggieLovers() {
        this.toppings = new ArrayList<>(Arrays.asList(Topping.GREENPEPPER,Topping.ONION,Topping.MUSHROOM,Topping.BLACKOLIVE));
        this.sauce = Sauce.TOMATO;
    }

    /**
     * Method that gets the price of different sizes of pizzas.
     *
     * @return price of pizza.
     */
    @Override
    public double getSizePrice() {
        if (this.size == Size.SMALL) {
            return 14.99;
        }
        else if (this.size == Size.MEDIUM) {
            return 16.99;
        }
        else {
            return 18.99;
        }
    }

    /**
     * Method that gets the price of different sizes of pizzas.
     *
     * @return price of pizza in formatted order.
     */
    @Override
    public double price() {
        return Double.parseDouble(decimalFormat.format(getSizePrice()
                + extraCheeseAmount() + extraSauceAmount()));
    }

    /**
     * Method that gets all toppings of a pizza in string.
     *
     * @return string format of all toppings.
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
     * Method that gets the toppings of a pizza.
     *
     * @return all toppings of pizza.
     */
    @Override
    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    /**
     * Method that gets all information about a pizza.
     *
     * @return String of pizza order full.
     */
    @Override
    public String toString() {
        return "[VeggieLovers]" + "[" + getSizeAsString() + "]" + "[" +
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
        return "Veggie Lovers";
    }
}
