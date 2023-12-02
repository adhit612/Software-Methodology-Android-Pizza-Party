package com.softwaremethodologyandroidpp;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Class that manages an order of pizzas.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public class Order {
    private ArrayList<Pizza> pizzas;
    private int orderNumber;
    public static final double SALES_TAX = 0.06625;
    private static final DecimalFormat decimalFormat = new DecimalFormat(
            "0" +
            ".00");

    /**
     * Method that handles setting order.
     *
     * @param pizzas all pizzas in arraylist.
     */
    public Order(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    /**
     * Method that handles adding pizza to order.
     *
     * @param pizza pizza added to order.
     */
    public void add(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    /**
     * Method that handles removing a pizza from an order.
     *
     * @param pizza pizza that will be removed.
     */
    public void remove(Pizza pizza) {
        this.pizzas.remove(pizza);
    }

    /**
     * Method that handles getting the order number of a pizza.
     *
     * @return order number of pizza.
     */
    public int getOrderNumber() {
        return this.orderNumber;
    }

    /**
     * Method that handles setting the order number of a pizza.
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Method that handles returning total price of order.
     *
     * @return toString of order total.
     */
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.pizzas.size(); i++) {
            if (i == this.pizzas.size() - 1) {
                res += this.pizzas.get(i).toString();
            } else {
                res += this.pizzas.get(i).toString() + "\n";
            }
        }
        res += "\n";
        res += "Order total: $" + String.valueOf(getTotalPriceWithSalesTax())
                + "\n";
        return res;
    }

    /**
     * Method that handles getting total price without tax.
     *
     * @return price without tax.
     */
    public double getTotalPriceWithoutTax() {
        double total = 0.0;
        for (int i = 0; i < this.pizzas.size(); i++) {
            total += this.pizzas.get(i).price();
        }
        return Double.parseDouble(decimalFormat.format(total));
    }

    /**
     * Method that handles getting total price with tax.
     *
     * @return price with tax.
     */
    public double getTotalPriceWithSalesTax() {
        return Double.parseDouble(decimalFormat.format(
                getTotalPriceWithoutTax() + (getTotalPriceWithoutTax() * SALES_TAX)));
    }

    /**
     * Method that handles getting tax value for entire order.
     *
     * @return price with total tax.
     */
    public double getSalesTaxOfTotal() {
        return Double.parseDouble(decimalFormat.format(
                getTotalPriceWithoutTax() * SALES_TAX));
    }

    /**
     * Method that handles getting list of pizzas in order.
     *
     * @return all pizzas in order.
     */
    public ArrayList<Pizza> getPizzaList() {
        return this.pizzas;
    }

    /**
     * Method that handles creating list of pizzas to be added to.
     *
     * @param newList all pizzas in a list
     */
    public void setPizzasList(ArrayList<Pizza> newList) {
        this.pizzas = newList;
    }
}
