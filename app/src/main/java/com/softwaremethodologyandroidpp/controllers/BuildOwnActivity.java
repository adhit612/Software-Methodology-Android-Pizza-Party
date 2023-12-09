package com.softwaremethodologyandroidpp.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.softwaremethodologyandroidpp.Order;
import com.softwaremethodologyandroidpp.Pizza;
import com.softwaremethodologyandroidpp.PizzaMaker;
import com.softwaremethodologyandroidpp.R;
import com.softwaremethodologyandroidpp.Sauce;
import com.softwaremethodologyandroidpp.Size;
import com.softwaremethodologyandroidpp.Topping;

import java.util.ArrayList;

/**
 * Class that manages activity for BuildYourOwn class.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public class BuildOwnActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView textSize;
    Spinner spinnerSize;
    String spinnerSelectedSize;
    TextView textSauce;
    RadioGroup radioGroup;
    String sauceType;
    RadioButton radioButtonTom;
    RadioButton radioButtonAlf;
    TextView textExtras;
    String extraCheese = "No";
    String extraSauce = "No";
    CheckBox checkBoxCheese;
    CheckBox checkBoxSauce;
    ListView listView;
    ArrayList<Topping> finalList = new ArrayList<>();
    int toppingCounter = 0;
    TextView textPrice;
    Button buttonAdd;
    private Pizza pizzaToBeAdded;
    private DataSingleton dataSingleton = DataSingleton.getInstance();
    public static final int MAX_TOPPING = 7;
    public static final int MIN_TOPPING = 3;

    /**
     * Method that handles running operations when activity is loaded
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.build_own_activity);
        init();
        spinnerSetup();
        radioGroupAction();
        checkBoxSauceAction();
        checkBoxCheeseAction();

        ArrayList<Topping> list = new ArrayList<>();
        list.add(Topping.BEEF);
        list.add(Topping.HAM);
        list.add(Topping.BLACKOLIVE);
        list.add(Topping.CHICKEN);
        list.add(Topping.CRABMEATS);
        list.add(Topping.GREENPEPPER);
        list.add(Topping.HOTSAUCE);
        list.add(Topping.MUSHROOM);
        list.add(Topping.ONION);
        list.add(Topping.PEPPERONI);
        list.add(Topping.SAUSAGE);
        list.add(Topping.SHRIMP);
        list.add(Topping.SQUID);
        ArrayAdapter<Topping> arrayAdapter = new ArrayAdapter<>(
                BuildOwnActivity.this,
                android.R.layout.simple_list_item_multiple_choice, list);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(arrayAdapter);
        listViewToppingAction();

        addButtonAction();
    }

    /**
     * Method that handles initializing all variables when activity is started
     */
    public void init() {
        textSize = findViewById(R.id.textsize);
        spinnerSize = findViewById(R.id.spinnersize);
        textSauce = findViewById(R.id.textSauce);
        radioGroup = findViewById(R.id.radiogroupsauce);
        radioButtonTom = findViewById(R.id.rbuttontom);
        radioButtonAlf = findViewById(R.id.rbuttonalf);
        textExtras = findViewById(R.id.textExtras);
        checkBoxCheese = findViewById(R.id.checkBoxCheese);
        checkBoxSauce = findViewById(R.id.checkBoxSauce);
        listView = findViewById(R.id.listviewTop);
        textPrice = findViewById(R.id.textviewPrice);
        buttonAdd = findViewById(R.id.buttonAdd);
        PizzaMaker pizzaMaker = new PizzaMaker();
        pizzaToBeAdded = pizzaMaker.createPizza("Build Your Own");
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(false);
        }
        checkBoxSauce.setEnabled(false);
        checkBoxCheese.setEnabled(false);
    }

    /**
     * Method that handles initializing the spinner for use
     */
    public void spinnerSetup() {
        String[] sizeItems = {"Pick", "Small", "Medium", "Large"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, sizeItems);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        spinnerSize.setSelection(0, false);
        spinnerSize.setAdapter(adapter);
        spinnerSize.setOnItemSelectedListener(this);
        sauceType = "Pick";
    }

    /**
     * Method that handles the action behind the radio group buttons
     */
    public void radioGroupAction() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioGroup.getCheckedRadioButtonId() != -1) {
                    Button radioButton = radioGroup.findViewById(i);
                    sauceType = radioButton.getText().toString();
                    if (sauceType.equals("Tomato")) {
                        pizzaToBeAdded.setSauce(Sauce.TOMATO);
                    }
                    if (sauceType.equals("Alfredo")) {
                        pizzaToBeAdded.setSauce(Sauce.ALFREDO);
                    }
                    checkBoxSauce.setEnabled(true);
                    checkBoxCheese.setEnabled(true);
                }
            }
        });
    }

    /**
     * Method that handles the action behind the check box for sauce
     */
    public void checkBoxSauceAction() {
        checkBoxSauce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxSauce.isChecked()) {
                    extraSauce = "Yes";
                    pizzaToBeAdded.addExtraSauce();
                    textPrice.setText(String.valueOf
                            (pizzaToBeAdded.price()));
                }
                else {
                    extraSauce = "No";
                    pizzaToBeAdded.removeExtraSauce();
                    textPrice.setText(String.valueOf
                            (pizzaToBeAdded.price()));
                }
            }
        });
    }

    /**
     * Method that handles the action behind the check box for cheese
     */
    public void checkBoxCheeseAction() {
        checkBoxCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxCheese.isChecked()) {
                    extraCheese = "Yes";
                    pizzaToBeAdded.addExtraCheese();
                    textPrice.setText(String.valueOf
                            (pizzaToBeAdded.price()));
                }
                else {
                    extraCheese = "No";
                    pizzaToBeAdded.removeExtraCheese();
                    textPrice.setText(String.valueOf
                            (pizzaToBeAdded.price()));
                }

            }
        });
    }

    /**
     * Method that handles the action behind selecting toppings in the listview
     */
    public void listViewToppingAction() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Topping top = (Topping) adapterView.getItemAtPosition(i);
                if (listView.isItemChecked(i)) {
                    if (toppingCounter >= MAX_TOPPING) {
                        Toast.makeText(BuildOwnActivity.this,
                                "7 toppings maximum!",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (finalList.size() < MAX_TOPPING) {
                            finalList.add(top);
                        }
                        else {
                            Toast.makeText(BuildOwnActivity.this,
                                    "7 toppings maximum!",
                                    Toast.LENGTH_SHORT).show();
                        }
                        if (toppingCounter >= MIN_TOPPING) {
                            pizzaToBeAdded.incrementToppingsAmount();
                        }
                        textPrice.setText(String.valueOf
                                (pizzaToBeAdded.price()));
                        toppingCounter++;

                    }
                }
                else {
                    toppingCounter--;
                    finalList.remove(top);
                    if (toppingCounter >= MIN_TOPPING) {
                        pizzaToBeAdded.decrementToppingsAmount();
                    }
                    textPrice.setText(String.valueOf
                            (pizzaToBeAdded.price()));

                }
            }
        });
    }

    /**
     * Method that handles the action behind adding a pizza to an order
     */
    public void addButtonAction() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (finalList.size() < MIN_TOPPING) {
                    Toast.makeText(BuildOwnActivity.this, "At least 3 toppings needed!", Toast.LENGTH_SHORT).show();
                }
                else if (toppingCounter >= MAX_TOPPING) {
                    Toast.makeText(BuildOwnActivity.this, "7 toppings maximum!", Toast.LENGTH_SHORT).show();
                }
                else if (spinnerSelectedSize.equals("Pick")) {
                    Toast.makeText(BuildOwnActivity.this, "Pick a size!", Toast.LENGTH_SHORT).show();
                }
                else if (sauceType.equals("Pick")) {
                    Toast.makeText(BuildOwnActivity.this, "Pick a sauce!", Toast.LENGTH_SHORT).show();
                }
                else if (pizzaToBeAdded != null) {
                    Order order = dataSingleton.getOrder();
                    if (order == null) {
                        ArrayList<Pizza> pizzaList = new ArrayList<>();
                        pizzaToBeAdded.setToppings(finalList);
                        pizzaList.add(pizzaToBeAdded);
                        Order newOrder = new Order(pizzaList);
                        dataSingleton.setOrder(newOrder);
                    }
                    else {
                        pizzaToBeAdded.setToppings(finalList);
                        order.add(pizzaToBeAdded);
                        dataSingleton.setOrder(order);
                    }
                    Toast.makeText(BuildOwnActivity.this, "Added to order!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(BuildOwnActivity.this, BuildOwnActivity.class);
                    BuildOwnActivity.this.startActivity(intent);
                }
            }
        });
    }

    /**
     * Method that handles the spinner action for pizza sizes
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        if (!spinnerSize.getSelectedItem().toString().equals("Pick")) {
            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                radioGroup.getChildAt(i).setEnabled(true);
            }
        }
        spinnerSelectedSize = parent.getItemAtPosition(position).toString();
        if (spinnerSelectedSize.equals("Small")) {
            pizzaToBeAdded.setSize(Size.SMALL);
            textPrice.setText(String.valueOf(pizzaToBeAdded.price()));
        }
        if (spinnerSelectedSize.equals("Medium")) {
            pizzaToBeAdded.setSize(Size.MEDIUM);
            textPrice.setText(String.valueOf(pizzaToBeAdded.price()));
        }
        if (spinnerSelectedSize.equals("Large")) {
            pizzaToBeAdded.setSize(Size.LARGE);
            textPrice.setText(String.valueOf(pizzaToBeAdded.price()));
        }
    }

    /**
     * Method that can be used for spinner
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    /**
     * Method that handles going to the main activity when back is clicked
     */
    public void backButtonAction(View view) {
        Intent intent = new Intent(BuildOwnActivity.this, MainActivity.class);
        BuildOwnActivity.this.startActivity(intent);
    }
}
