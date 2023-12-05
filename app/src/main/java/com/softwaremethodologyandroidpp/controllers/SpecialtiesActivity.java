package com.softwaremethodologyandroidpp.controllers;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.softwaremethodologyandroidpp.Deluxe;
import com.softwaremethodologyandroidpp.GlizzyGoblin;
import com.softwaremethodologyandroidpp.Meatzza;
import com.softwaremethodologyandroidpp.Pepperoni;
import com.softwaremethodologyandroidpp.Pizza;
import com.softwaremethodologyandroidpp.PoultryParty;
import com.softwaremethodologyandroidpp.R;
import com.softwaremethodologyandroidpp.Seafood;
import com.softwaremethodologyandroidpp.SpicyPhenom;
import com.softwaremethodologyandroidpp.StinkySally;
import com.softwaremethodologyandroidpp.Supreme;
import com.softwaremethodologyandroidpp.VeggieLovers;

import java.util.ArrayList;

public class SpecialtiesActivity extends AppCompatActivity {
    private ArrayList <PizzaItem> pizzaList = new ArrayList<>();
    private int [] pizzaImages = {R.drawable.randopizza,R.drawable.glizzygoblin,R.drawable.meatzzapizza,
    R.drawable.pepperonipizza,R.drawable.poultryparty,R.drawable.seafoodpizza,R.drawable.spicyphenom,R.drawable.stinkysally,
    R.drawable.supremepizza,R.drawable.veggielovers};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specialties_activity);
        RecyclerView specialtiesRecyclerView = findViewById(R.id.rv_specialties);
        setupMenuItems();
        specialtiesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        specialtiesRecyclerView.setAdapter(new ViewAdapter(getApplicationContext(),pizzaList));
    }

    public void backButtonAction(View view) {
        Intent intent = new Intent(SpecialtiesActivity.this, MainActivity.class);
        SpecialtiesActivity.this.startActivity(intent);
    }

    private void setupMenuItems(){
        int i = 0;
        pizzaList.add(new PizzaItem(new Deluxe(),pizzaImages[i]));
        i ++;
        pizzaList.add(new PizzaItem(new GlizzyGoblin(),pizzaImages[i]));
        i ++;
        pizzaList.add(new PizzaItem(new Meatzza(),pizzaImages[i]));
        i ++;
        pizzaList.add(new PizzaItem(new Pepperoni(),pizzaImages[i]));
        i ++;
        pizzaList.add(new PizzaItem(new PoultryParty(),pizzaImages[i]));
        i ++;
        pizzaList.add(new PizzaItem(new Seafood(),pizzaImages[i]));
        i ++;
        pizzaList.add(new PizzaItem(new SpicyPhenom(),pizzaImages[i]));
        i ++;
        pizzaList.add(new PizzaItem(new StinkySally(),pizzaImages[i]));
        i ++;
        pizzaList.add(new PizzaItem(new Supreme(),pizzaImages[i]));
        i ++;
        pizzaList.add(new PizzaItem(new VeggieLovers(),pizzaImages[i]));
    }
}
