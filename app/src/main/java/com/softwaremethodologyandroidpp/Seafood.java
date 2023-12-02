package com.softwaremethodologyandroidpp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that manages Seafood specialty pizza.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public class Seafood extends Pizza {
    private static final DecimalFormat decimalFormat = new DecimalFormat("0" +
            ".00");

    /**
     * Method that handles creating a Seafood speciality pizza.
     */
    public Seafood() {
        this.toppings = new ArrayList<>(Arrays.asList(Topping.SHRIMP,
                Topping.SQUID, Topping.CRABMEATS));
        this.sauce = Sauce.ALFREDO;
    }

    /**
     * Method that handles getting size price of pizza.
     *
     * @return price of pizza.
     */
    @Override
    public double getSizePrice() {
        if (this.size == Size.SMALL) {
            return 17.99;
        }
        else if (this.size == Size.MEDIUM) {
            return 19.99;
        }
        else {
            return 21.99;
        }
    }

    /**
     * Method that handles getting the price of a pizza.
     *
     * @return total formatted price.
     */
    @Override
    public double price() {
        return Double.parseDouble(decimalFormat.format(getSizePrice()
                + extraCheeseAmount() + extraSauceAmount()));
    }

    /**
     * Method that handles getting the toppings of a pizza in String format.
     *
     * @return toppings of pizza in String format.
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
     * Method that handles getting toppings of pizza.
     *
     * @return toppings of pizza.
     */
    @Override
    public ArrayList<Topping> getToppings() {
        return this.toppings;
    }

    /**
     * Method that handles getting all information about the pizza in
     * toString form.
     *
     * @return toString of pizza order.
     */
    @Override
    public String toString() {
        return "[Seafood" + "]" + "[" + getSizeAsString() + "]" + "[" +
                getSauceAsString() + "]: " + getToppingsAsString() +
                extraCheeseString() + extraSauceString() + ": " + "$" +
                price();
    }
}
