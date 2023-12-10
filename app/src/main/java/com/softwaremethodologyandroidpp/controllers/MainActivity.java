package com.softwaremethodologyandroidpp.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.softwaremethodologyandroidpp.R;

/**
 * Class to manage activity for main menu.
 * @author Abhishek Thakare, Adhit Thakur.
 */

public class MainActivity extends AppCompatActivity {

    /**
     * Method to initialize basic functionalities.
     * @param savedInstanceState If the activity is being re-initialized after
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method to change to specialities view.
     * @param view current view location.
     */
    public void specialtiesIVAction(View view) {
        Intent intent = new Intent(MainActivity.this,
                SpecialtiesActivity.class);
        MainActivity.this.startActivity(intent);
    }


    /**
     * Method to change to build own view.
     * @param view current view location.
     */
    public void buildOwnIVAction(View view) {
        Intent intent = new Intent(MainActivity.this,
                BuildOwnActivity.class);
        MainActivity.this.startActivity(intent);
    }


    /**
     * Method to change to current order view.
     * @param view current view location.
     */
    public void currentOrderIVAction(View view) {
        Intent intent = new Intent(MainActivity.this,
                CurrentOrderActivity.class);
        MainActivity.this.startActivity(intent);
    }

    /**
     * Method to change to store orders view.
     * @param view current view location.
     */
    public void storeOrdersIVAction(View view) {
        Intent intent = new Intent(MainActivity.this,
                StoreOrdersActivity.class);
        MainActivity.this.startActivity(intent);
    }
}