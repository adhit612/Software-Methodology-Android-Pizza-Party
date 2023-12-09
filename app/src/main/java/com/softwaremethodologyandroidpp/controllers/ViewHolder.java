package com.softwaremethodologyandroidpp.controllers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softwaremethodologyandroidpp.Deluxe;
import com.softwaremethodologyandroidpp.GlizzyGoblin;
import com.softwaremethodologyandroidpp.Meatzza;
import com.softwaremethodologyandroidpp.Order;
import com.softwaremethodologyandroidpp.Pepperoni;
import com.softwaremethodologyandroidpp.Pizza;
import com.softwaremethodologyandroidpp.PizzaMaker;
import com.softwaremethodologyandroidpp.PoultryParty;
import com.softwaremethodologyandroidpp.R;
import com.softwaremethodologyandroidpp.Seafood;
import com.softwaremethodologyandroidpp.Size;
import com.softwaremethodologyandroidpp.SpicyPhenom;
import com.softwaremethodologyandroidpp.StinkySally;
import com.softwaremethodologyandroidpp.Supreme;
import com.softwaremethodologyandroidpp.VeggieLovers;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.logging.Handler;

/**
 * Class that manages the listeners for a row on the Recylcer View.
 * @author Abhishek Thakare, Adhit Thakur.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView specialtyPizzaImage;
    Spinner sizeSpinner;
    String sizeSpinnerSelectedSize;
    TextView specialtySauceDisplay;
    Switch extraCheeseSwitch;
    Switch extraSauceSwitch;
    EditText enterQuantityText;
    Button addButton;
    TextView specialtyPizzaName;
    ListView toppingsList;
    TextView priceTextField;
    EditText pizzaQuantityText;

    Pizza pizzaToBeAdded;
    DataSingleton dataSingleton = DataSingleton.getInstance();

    Boolean validIntegerEntered;
    int quantity;

    /**
     * Constructor to set up UI items.
     * @param itemView view of row.
     */
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        specialtyPizzaImage = itemView.findViewById(R.id.iv_specialty_pizza_recycler);
        sizeSpinner = itemView.findViewById(R.id.s_sizes);
        specialtySauceDisplay = itemView.findViewById(R.id.tv_specialty_sauce_display);
        extraCheeseSwitch = itemView.findViewById(R.id.sw_extra_cheese);
        extraSauceSwitch = itemView.findViewById(R.id.sw_extra_sauce);
        enterQuantityText = itemView.findViewById(R.id.pt_enter_quantity);
        addButton = itemView.findViewById(R.id.b_add_button);
        specialtyPizzaName = itemView.findViewById(R.id.tv_specialty_pizza_name);
        toppingsList = itemView.findViewById(R.id.lv_toppings_list);
        priceTextField = itemView.findViewById(R.id.tv_price_field);
        pizzaQuantityText = itemView.findViewById(R.id.pt_enter_quantity);

        quantity = 0;
        validIntegerEntered = false;

        sizeSpinnerAction();
        extraCheeseSwitchAction();
        extraSauceSwitchAction();
        pizzaQuantityTextAction();
        addButtonAction();
    }

    /**
     * Setting the pizza in each row.
     * @param pizzaName name of pizza.
     */
    public void setPizzaToBeAdded(String pizzaName) {
        PizzaMaker pizzaMaker = new PizzaMaker();
        pizzaToBeAdded = pizzaMaker.createPizza(pizzaName);
    }

    /**
     * Method to handle size spinner action.
     */
    public void sizeSpinnerAction(){
        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setPizzaToBeAdded((String)specialtyPizzaName.getText());
                String [] sizeItems = {"Pick","Small","Medium","Large"};
                sizeSpinnerSelectedSize = sizeItems[position];
                if(pizzaToBeAdded != null) {
                    if (!(sizeSpinnerSelectedSize.equals("") || sizeSpinnerSelectedSize == null || sizeSpinnerSelectedSize.equals("Pick"))) {
                        if (sizeSpinnerSelectedSize.equals("Small")) {
                            pizzaToBeAdded.setSize(Size.SMALL);
                            priceTextField.setText(String.valueOf(pizzaToBeAdded.price()));
                        } else if (sizeSpinnerSelectedSize.equals("Medium")) {
                            pizzaToBeAdded.setSize(Size.MEDIUM);
                            priceTextField.setText(String.valueOf(pizzaToBeAdded.price()));
                        } else if (sizeSpinnerSelectedSize.equals("Large")) {
                            pizzaToBeAdded.setSize(Size.LARGE);
                            priceTextField.setText(String.valueOf(pizzaToBeAdded.price()));
                        }
                        Toast.makeText(selectedItemView.getContext(),
                                specialtyPizzaName.getText() + " size " + sizeSpinnerSelectedSize, Toast.LENGTH_SHORT).show();
                        pizzaQuantityText.setEnabled(true);
                    }
                    else if(sizeSpinnerSelectedSize.equals("Pick")){
                        pizzaQuantityText.setEnabled(false);
                        priceTextField.setText("");
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    /**
     * Method to handle cheese spinner action.
     */
    public void extraCheeseSwitchAction(){
        extraCheeseSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pizzaToBeAdded == null || sizeSpinnerSelectedSize.equals("Pick") || sizeSpinnerSelectedSize.equals("") || sizeSpinnerSelectedSize == null){
                    Toast.makeText(v.getContext(),
                            specialtyPizzaName.getText() + ": please select size!", Toast.LENGTH_SHORT).show();
                    extraCheeseSwitch.setChecked(false);
                }
                else {
                    if (extraCheeseSwitch.isChecked()) {
                        pizzaToBeAdded.addExtraCheese();
                        priceTextField.setText(String.valueOf(pizzaToBeAdded.price()));
                    } else {
                        pizzaToBeAdded.removeExtraCheese();
                        priceTextField.setText(String.valueOf(pizzaToBeAdded.price()));
                    }
                }
            }
        });
    }

    /**
     * Method to handle sauce spinner action.
     */
    public void extraSauceSwitchAction(){
        extraSauceSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pizzaToBeAdded == null || sizeSpinnerSelectedSize.equals("Pick") || sizeSpinnerSelectedSize.equals("") || sizeSpinnerSelectedSize == null){
                    Toast.makeText(v.getContext(),
                            specialtyPizzaName.getText() + ": please select size!", Toast.LENGTH_SHORT).show();
                    extraSauceSwitch.setChecked(false);
                }
                else {
                    if (extraSauceSwitch.isChecked()) {
                        pizzaToBeAdded.addExtraSauce();
                        priceTextField.setText(String.valueOf(pizzaToBeAdded.price()));
                    } else {
                        pizzaToBeAdded.removeExtraSauce();
                        priceTextField.setText(String.valueOf(pizzaToBeAdded.price()));
                    }
                }
            }
        });
    }

    /**
     * Method to handle quantity text action.
     */
    public void pizzaQuantityTextAction(){
        pizzaQuantityText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                try {
                    int enteredValue = Integer.parseInt(charSequence.toString());
                    validIntegerEntered = true;
                    quantity = enteredValue;
                } catch (NumberFormatException e) {
                    Toast.makeText(((View) pizzaQuantityText.getParent()).getContext(),
                            "Please enter a valid integer", Toast.LENGTH_SHORT).show();
                    validIntegerEntered = false;
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    int enteredValue = Integer.parseInt(editable.toString());
                    validIntegerEntered = true;
                    quantity = enteredValue;
                } catch (NumberFormatException e) {
                    Toast.makeText(((View) pizzaQuantityText.getParent()).getContext(),
                            "Please enter a valid integer", Toast.LENGTH_SHORT).show();
                    validIntegerEntered = false;
                }
            }
        });
    }

    /**
     * Method to handle back to main menu action.
     */
    public void addButtonAction(){
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pizzaToBeAdded == null || sizeSpinnerSelectedSize.equals("Pick") || sizeSpinnerSelectedSize.equals("") || sizeSpinnerSelectedSize == null){
                    Toast.makeText(v.getContext(), specialtyPizzaName.getText()
                            + ": please select size!", Toast.LENGTH_SHORT).show();
                }
                else if(!validIntegerEntered){
                    Toast.makeText(v.getContext(), specialtyPizzaName.getText()
                            + ": please enter valid quantity!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Order order = dataSingleton.getOrder();
                    if (order == null) {
                        ArrayList<Pizza> pizzaList = new ArrayList<>();
                        for(int i = 0; i < quantity; i ++){
                            pizzaList.add(pizzaToBeAdded);
                        }
                        Order newOrder = new Order(pizzaList);
                        dataSingleton.setOrder(newOrder);
                    } else {
                        for(int i = 0; i < quantity; i ++) {
                            order.add(pizzaToBeAdded);
                        }
                        dataSingleton.setOrder(order);
                    }
                    Toast.makeText(v.getContext(), specialtyPizzaName.getText() + ":"
                            + "(" + quantity + ") Pizza has been added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
