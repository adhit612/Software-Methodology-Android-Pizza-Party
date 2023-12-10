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
import com.softwaremethodologyandroidpp.PizzaMaker;
import com.softwaremethodologyandroidpp.PoultryParty;
import com.softwaremethodologyandroidpp.R;
import com.softwaremethodologyandroidpp.Seafood;
import com.softwaremethodologyandroidpp.SpicyPhenom;
import com.softwaremethodologyandroidpp.StinkySally;
import com.softwaremethodologyandroidpp.Supreme;
import com.softwaremethodologyandroidpp.VeggieLovers;

import java.util.ArrayList;


/**
 * Class to manage the Specialties Activity view.
 * @author Abhishek Thakare, Adhit Thakur.
 */

public class SpecialtiesActivity extends AppCompatActivity {
    private ArrayList <PizzaItem> pizzaList = new ArrayList<>();
    private int [] pizzaImages = {R.drawable.randopizza,R.drawable.glizzygoblin,
            R.drawable.meatzzapizza, R.drawable.pepperonipizza,
            R.drawable.poultryparty,R.drawable.seafoodpizza,
            R.drawable.spicyphenom,R.drawable.stinkysally,
            R.drawable.supremepizza,R.drawable.veggielovers};

    /**
     * Method to initialize store orders.
     * @param savedInstanceState If the activity is being re-initialized after
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specialties_activity);
        RecyclerView specialtiesRecyclerView =
                findViewById(R.id.rv_specialties);
        setupMenuItems();
        specialtiesRecyclerView.setLayoutManager
                (new LinearLayoutManager(this));
        specialtiesRecyclerView.setAdapter
                (new ViewAdapter(getApplicationContext(),pizzaList));
    }

    /**
     * On Action Listener for back button to go to main menu.
     * @param view view of action.
     */
    public void backButtonAction(View view) {
        Intent intent = new Intent(SpecialtiesActivity.this,
                MainActivity.class);
        SpecialtiesActivity.this.startActivity(intent);
    }

    /**
     * Helper method to set up pizza that will be added.
     */
    private void setupMenuItems(){
        PizzaMaker pizzaMaker = new PizzaMaker();
        int i = 0;
        Pizza selectedPizza = pizzaMaker.createPizza("Deluxe");
        pizzaList.add(new PizzaItem(selectedPizza,pizzaImages[i]));
        i ++;
        selectedPizza = pizzaMaker.createPizza("Glizzy Goblin");
        pizzaList.add(new PizzaItem(selectedPizza,pizzaImages[i]));
        i ++;
        selectedPizza = pizzaMaker.createPizza("Meatzza");
        pizzaList.add(new PizzaItem(selectedPizza,pizzaImages[i]));
        i ++;
        selectedPizza = pizzaMaker.createPizza("Pepperoni");
        pizzaList.add(new PizzaItem(selectedPizza,pizzaImages[i]));
        i ++;
        selectedPizza = pizzaMaker.createPizza("Poultry Party");
        pizzaList.add(new PizzaItem(selectedPizza,pizzaImages[i]));
        i ++;
        selectedPizza = pizzaMaker.createPizza("Seafood");
        pizzaList.add(new PizzaItem(selectedPizza,pizzaImages[i]));
        i ++;
        selectedPizza = pizzaMaker.createPizza("Spicy Phenom");
        pizzaList.add(new PizzaItem(selectedPizza,pizzaImages[i]));
        i ++;
        selectedPizza = pizzaMaker.createPizza("Stinky Sally");
        pizzaList.add(new PizzaItem(selectedPizza,pizzaImages[i]));
        i ++;
        selectedPizza = pizzaMaker.createPizza("Supreme");
        pizzaList.add(new PizzaItem(selectedPizza,pizzaImages[i]));
        i ++;
        selectedPizza = pizzaMaker.createPizza("Veggie Lovers");
        pizzaList.add(new PizzaItem(selectedPizza,pizzaImages[i]));
    }
}
