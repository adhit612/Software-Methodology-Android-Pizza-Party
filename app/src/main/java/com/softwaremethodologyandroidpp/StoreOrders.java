package com.softwaremethodologyandroidpp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Class that manages all orders of pizzas for whole store.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public class StoreOrders {
    private ArrayList<Order> orders;
    private int currOrderNumber;
    private static int nextOrderNumber;

    /**
     * Method that creating store orders of pizza.
     */
    public StoreOrders() {
    }

    /**
     * Method that creating store orders of pizza.
     *
     * @param orders, all orders of pizza.
     */
    public StoreOrders(ArrayList<Order> orders) {
        this.currOrderNumber = 1;
        this.orders = orders;
    }

    /**
     * Method that adds order to total orders.
     *
     * @param order, order added to total orders.
     */
    public void add(Order order) {
        order.setOrderNumber(this.currOrderNumber);
        this.orders.add(order);
        this.incrementOrderNumber();
    }

    /**
     * Method that removes an order from total orders.
     *
     * @param order, order to remove from total orders.
     */
    public void remove(Order order) {
        int indexToRemove = 0;
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getOrderNumber()
                    == order.getOrderNumber()) {
                indexToRemove = i;
            }
        }
        this.orders.remove(indexToRemove);
        decrementOrderNumber();
    }

    /**
     * Method that decrements the order numbers from total.
     */
    public void decrementOrderNumber() {
        this.currOrderNumber--;
    }

    /**
     * Method that increments the order numbers.
     */
    public void incrementOrderNumber() {
        this.currOrderNumber++;
    }

    /**
     * Method that gets all orders from arraylist.
     */
    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    /**
     * Method that returns the order numbers in string format.
     *
     * @return String format of order numbers.
     */
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.orders.size(); i++) {
            if (i == this.orders.size() - 1) {
                res += "Order number " + this.orders.get(i).
                        getOrderNumber() + "\n";
                res += this.orders.get(i).toString();
            }
            else {
                res += "Order number " + this.orders.get(i).
                        getOrderNumber() + "\n";
                res += this.orders.get(i).toString() + "\n";
            }
        }
        return res;
    }

    public void setOrders(ArrayList<Order> newOrders) {
        this.orders = newOrders;
    }
}
