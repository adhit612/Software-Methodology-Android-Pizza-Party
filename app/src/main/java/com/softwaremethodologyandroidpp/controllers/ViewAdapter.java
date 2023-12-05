package com.softwaremethodologyandroidpp.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softwaremethodologyandroidpp.R;
import com.softwaremethodologyandroidpp.Topping;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewHolder>{
    Context context;
    List<PizzaItem> items;

    private static final int ONE = 1;

    public ViewAdapter(Context context, List<PizzaItem>items){
        this.context = context;
        this.items = items;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.pizza_item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.specialtyPizzaImage.setImageResource(items.get(position).getImage());
        holder.specialtySauceDisplay.setText(items.get(position).getPizza().getSauceAsString());

        holder.specialtyPizzaName.setText(items.get(position).getPizza().getPizzaNameAsString());

        holder.pizzaQuantityText.setText(String.valueOf(ONE));
        holder.pizzaQuantityText.setEnabled(false);

        ArrayList<Topping> toppingsItems = items.get(position).getPizza().getToppings();
        ArrayAdapter<Topping> toppingAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, toppingsItems);
        holder.toppingsList.setAdapter(toppingAdapter);

        String [] sizeItems = {"Pick","Small","Medium","Large"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, sizeItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.sizeSpinner.setSelection(0,false);
        holder.sizeSpinner.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
