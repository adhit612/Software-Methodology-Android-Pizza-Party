package com.softwaremethodologyandroidpp.controllers;

import com.softwaremethodologyandroidpp.Order;
import com.softwaremethodologyandroidpp.Pizza;
import com.softwaremethodologyandroidpp.StoreOrders;

import java.util.ArrayList;

/**
 * Class to manage data between multiple controllers.
 * @author Abhishek Thakare, Adhit Thakur.
 */
public final class DataSingleton {
    private static final DataSingleton instance = new DataSingleton();

    private Order order;
    private StoreOrders storeOrders;
    private boolean orderAdded = false;

    /**
     * Method to get instance for singleton.
     * @return instance for singleton.
     */
    public static synchronized DataSingleton getInstance(){
        return instance;
    }

    /**
     * Method to initialize the current order.
     * @param pizzaList the list to be added to order.
     */
    public void initializeOrder(ArrayList<Pizza> pizzaList){
        order = new Order(pizzaList);
    }

    /**
     * Getter method to return Order.
     * @return order.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Get the current order added to order.
     * @return order added.
     */
    public boolean getOrderAdded(){
        return orderAdded;
    }

    /**
     * Method to set the order that has been added.
     * @param bool Setting the state of adding.
     */
    public void setOrderAdded(boolean bool){
        orderAdded = bool;
    }

    /**
     * Method to set the order.
     * @param newOrder order to set the current one to.
     */
    public void setOrder(Order newOrder){
        order = newOrder;
    }

    /**
     * Method to initialize the store orders.
     * @param ordersList list to initialize the store orders with.
     */
    public void initializeStoreOrders(ArrayList <Order> ordersList){
        storeOrders = new StoreOrders(ordersList);
    }

    /**
     * Getter method for store orders.
     * @return the store order list.
     */
    public StoreOrders getStoreOrders(){
        return storeOrders;
    }

    /**
     * Method to set the store orders.
     * @param newStoreOrder new store orders to set.
     */
    public void setStoreOrders(StoreOrders newStoreOrder){
        storeOrders = newStoreOrder;
    }
}
