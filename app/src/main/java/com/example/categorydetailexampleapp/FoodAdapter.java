package com.example.categorydetailexampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {
    public FoodAdapter(Context context, ArrayList<Food> foodList) {
        super(context, 0, foodList);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        Food myFood = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_food_row_layout_new, parent, false);
        }
        // Step 1: Connect XML references for YOUR custom view
        TextView nameText = convertView.findViewById(R.id.name);
        TextView priceText = convertView.findViewById(R.id.price);
        TextView descText = convertView.findViewById(R.id.descView);
        ImageView image = convertView.findViewById(R.id.imageView);


        // Step 2: Populate the specific row data into the variables you made in step 1

        nameText.setText(myFood.toString());
        priceText.setText(Double.toString(myFood.getPrice()));
        image.setImageResource(myFood.getImageResourceID());
        descText.setText(myFood.getDesc());

        // Step 3: Return the completed view to render on screen
        return convertView;
    }
}
