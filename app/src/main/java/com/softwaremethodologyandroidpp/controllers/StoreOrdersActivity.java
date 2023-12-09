package com.softwaremethodologyandroidpp.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.softwaremethodologyandroidpp.Order;
import com.softwaremethodologyandroidpp.Pizza;
import com.softwaremethodologyandroidpp.R;
import com.softwaremethodologyandroidpp.StoreOrders;
import com.softwaremethodologyandroidpp.Topping;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Class that manages activity for StoreOrders class.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public class StoreOrdersActivity extends AppCompatActivity {
    TextView textPrice;
    Spinner spinner;
    ListView listView;
    Button cancelButton;
    private DataSingleton dataSingleton = DataSingleton.getInstance();
    ArrayList<Pizza> currentOrderPizzas;
    ArrayAdapter<Pizza> pizzaAdapter;
    ArrayList<Integer> orderNumbersToBeAdded;

    /**
     * Method that handles running the activity when activity is loaded
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders_activity);

        init();
        spinnerAndListSetup();
        cancelButtonAction();
    }

    /**
     * Method that handles initializing all variables when activity is started
     */
    public void init() {
        textPrice = findViewById(R.id.textpriceorder);
        spinner = findViewById(R.id.spinnerPrice);
        listView = findViewById(R.id.listviewOrders);
        cancelButton = findViewById(R.id.buttonCancel);
    }

    /**
     * Method that handles setup for the spinner and ListView
     */
    public void spinnerAndListSetup() {
        StoreOrders storeOrders = dataSingleton.getStoreOrders();
        orderNumbersToBeAdded = new ArrayList<>();
        if (storeOrders != null) {
            ArrayList<Order> orderList = storeOrders.getOrders();
            for (int i = 0; i < orderList.size(); i++) {
                orderNumbersToBeAdded.add(orderList.get(i).getOrderNumber());
            }
            ArrayAdapter<Integer> adapterSpinner = new ArrayAdapter<>
                    (this, android.R.layout.simple_spinner_item,
                            orderNumbersToBeAdded);
            adapterSpinner.setDropDownViewResource
                    (android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapterSpinner);
            spinner.setOnItemSelectedListener
                    (new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    Order order = orderList.get(i);
                    Log.d("HELLO", order.toString());
                    currentOrderPizzas = order.getPizzaList();
                    pizzaAdapter = new ArrayAdapter<>
                            (StoreOrdersActivity.this,
                                    android.R.layout.simple_list_item_1,
                                    currentOrderPizzas);
                    listView.setAdapter(pizzaAdapter);
                    textPrice.setText(String.valueOf(order.
                            getTotalPriceWithSalesTax()));
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }

    /**
     * Method that handles the action behind canceling an order
     */
    public void cancelButtonAction() {
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedOrderNumber = spinner.getSelectedItem().
                        toString();
                int num = Integer.parseInt(selectedOrderNumber);
                StoreOrders storeOrders = dataSingleton.getStoreOrders();
                ArrayList<Order> orders = storeOrders.getOrders();
                int indexToRemove = -1;
                for (int i = 0; i < orders.size(); i++) {
                    if (orders.get(i).getOrderNumber() == num) {
                        indexToRemove = i;
                        break;
                    }
                }
                orders.remove(indexToRemove);
                storeOrders.setOrders(orders);
                dataSingleton.setStoreOrders(storeOrders);
                pizzaAdapter.clear();
                pizzaAdapter.notifyDataSetChanged();
                for (int i = 0; i < orderNumbersToBeAdded.size(); i++) {
                    if (orderNumbersToBeAdded.get(i) == num) {
                        indexToRemove = i;
                    }
                }
                orderNumbersToBeAdded.remove(indexToRemove);
                ArrayAdapter<Integer> adapterSpinner = new ArrayAdapter<>
                        (StoreOrdersActivity.this,
                                android.R.layout.simple_spinner_item,
                                orderNumbersToBeAdded);
                adapterSpinner.setDropDownViewResource
                        (android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapterSpinner);
                if (spinner.getSelectedItem() == null) {
                    textPrice.setText("");
                }
            }
        });
    }

    /**
     * Method that handles going back to Main Activity when back button is clicked
     * @param view
     */
    public void backButtonAction(View view) {
        Intent intent = new Intent(StoreOrdersActivity.this,
                MainActivity.class);
        StoreOrdersActivity.this.startActivity(intent);
    }
}
