package com.softwaremethodologyandroidpp.controllers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.softwaremethodologyandroidpp.Order;
import com.softwaremethodologyandroidpp.Pizza;
import com.softwaremethodologyandroidpp.R;
import com.softwaremethodologyandroidpp.StoreOrders;
import com.softwaremethodologyandroidpp.Topping;

import java.util.ArrayList;

public class CurrentOrderActivity extends AppCompatActivity {
    TextView currentOrderNumber;
    TextView subtotalLabel;
    TextView salesTaxLabel;
    TextView orderTotalLabel;
    Switch removePizzaSwitch;
    ListView currentOrderList;
    DataSingleton dataSingleton = DataSingleton.getInstance();

    Pizza pizzaToRemove;
    int indexToRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_order_activity);

        StoreOrders storeOrders = dataSingleton.getStoreOrders();
        Order currOrder = dataSingleton.getOrder();

        currentOrderNumber = findViewById(R.id.tv_order_number_field);
        subtotalLabel = findViewById(R.id.tv_subtotal_price);
        salesTaxLabel = findViewById(R.id.tv_sales_tax_price);
        orderTotalLabel = findViewById(R.id.tv_order_total_price);
        currentOrderList = findViewById(R.id.lv_current_order_list);
        removePizzaSwitch = findViewById(R.id.sw_removePizzaSwitch);

        indexToRemove = -1;

        if(currOrder != null){
            if(storeOrders == null){
                ArrayList<Order> orderList = new ArrayList<>();
                StoreOrders newStoreOrder = new StoreOrders(orderList);
                newStoreOrder.add(currOrder);
                dataSingleton.setStoreOrders(newStoreOrder);

                currentOrderNumber.setText(String.valueOf(currOrder.getOrderNumber()));

                ArrayList<Pizza> currentOrderPizzas = currOrder.getPizzaList();
                ArrayAdapter<Pizza> pizzaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, currentOrderPizzas);
                currentOrderList.setAdapter(pizzaAdapter);

                subtotalLabel.setText(String.valueOf(currOrder.getTotalPriceWithoutTax()));
                salesTaxLabel.setText(String.valueOf(currOrder.getSalesTaxOfTotal()));
                orderTotalLabel.setText(String.valueOf(currOrder.getTotalPriceWithSalesTax()));
            }
            else{
                storeOrders.add(currOrder);
                dataSingleton.setOrderAdded(true);
                dataSingleton.setStoreOrders(storeOrders);
                currentOrderNumber.setText(String.valueOf(currOrder.getOrderNumber()));

                ArrayList<Pizza> currentOrderPizzas = currOrder.getPizzaList();
                ArrayAdapter<Pizza> pizzaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, currentOrderPizzas);
                currentOrderList.setAdapter(pizzaAdapter);

                subtotalLabel.setText(String.valueOf(currOrder.getTotalPriceWithoutTax()));
                salesTaxLabel.setText(String.valueOf(currOrder.getSalesTaxOfTotal()));
                orderTotalLabel.setText(String.valueOf(currOrder.getTotalPriceWithSalesTax()));
            }
        }

        pizzaListViewAction();
    }

    public void pizzaListViewAction(){
        currentOrderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(!removePizzaSwitch.isChecked()){
                    Toast.makeText(getApplicationContext(), "Please turn remove mode on to remove", Toast.LENGTH_SHORT).show();
                }
                else{
                    pizzaToRemove = (Pizza)parent.getItemAtPosition(position);
                    indexToRemove = position;
                    Order currOrder = dataSingleton.getOrder();
                    if(currOrder == null){
                        Toast.makeText(getApplicationContext(), "Order already placed", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ArrayList <Pizza> orderPizzaList = currOrder.getPizzaList();
                    orderPizzaList.remove(indexToRemove);
                    currOrder.setPizzasList(orderPizzaList);
                    dataSingleton.setOrder(currOrder);

                    ArrayList<Pizza> currentOrderPizzas = currOrder.getPizzaList();
                    ArrayAdapter<Pizza> pizzaAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, currentOrderPizzas);
                    currentOrderList.setAdapter(pizzaAdapter);

                    subtotalLabel.setText(String.valueOf(currOrder.getTotalPriceWithoutTax()));
                    salesTaxLabel.setText(String.valueOf(currOrder.getSalesTaxOfTotal()));
                    orderTotalLabel.setText(String.valueOf(currOrder.getTotalPriceWithSalesTax()));
                    Toast.makeText(getApplicationContext(), "Pizza Removed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void backButtonAction(View view) {
        Order currOrder = dataSingleton.getOrder();
        if(currOrder != null){
            StoreOrders storeOrders = dataSingleton.getStoreOrders();
            storeOrders.remove(currOrder);
        }
        Intent intent = new Intent(CurrentOrderActivity.this, MainActivity.class);
        CurrentOrderActivity.this.startActivity(intent);
    }

    public void addToOrderButtonAction(View view) {
        Order currOrder = dataSingleton.getOrder();

        if(currOrder == null){
            Toast.makeText(getApplicationContext(), "Add a pizza to place order", Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayList <Pizza> orderPizzaList = currOrder.getPizzaList();

        if(orderPizzaList.size() == 0){
            Toast.makeText(getApplicationContext(), "Add a pizza to place order", Toast.LENGTH_SHORT).show();
            return;
        }

        alertDialogMessage();
    }

    public void alertDialogMessage(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Order Confirmation Message");
        alert.setMessage("Place the Order?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Order currOrder = dataSingleton.getOrder();
                currOrder = null;
                dataSingleton.setOrder(currOrder);
                dataSingleton.setOrderAdded(false);
                Toast.makeText(getApplicationContext(), "Order Placed", Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Continue Shopping", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
