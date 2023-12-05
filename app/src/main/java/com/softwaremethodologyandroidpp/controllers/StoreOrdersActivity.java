package com.softwaremethodologyandroidpp.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.softwaremethodologyandroidpp.R;

public class StoreOrdersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders_activity);
    }

    public void backButtonAction(View view) {
        Intent intent = new Intent(StoreOrdersActivity.this, MainActivity.class);
        StoreOrdersActivity.this.startActivity(intent);
    }
}
