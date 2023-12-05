package com.softwaremethodologyandroidpp.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.softwaremethodologyandroidpp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void specialtiesIVAction(View view) {
        Intent intent = new Intent(MainActivity.this, SpecialtiesActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void buildOwnIVAction(View view) {
        Intent intent = new Intent(MainActivity.this, BuildOwnActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void currentOrderIVAction(View view) {
        Intent intent = new Intent(MainActivity.this, CurrentOrderActivity.class);
        MainActivity.this.startActivity(intent);
    }

    public void storeOrdersIVAction(View view) {
        Intent intent = new Intent(MainActivity.this, StoreOrdersActivity.class);
        MainActivity.this.startActivity(intent);
    }
}