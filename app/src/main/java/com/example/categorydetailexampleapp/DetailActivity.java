package com.example.categorydetailexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        try {
            TextView name = findViewById(R.id.nameView);
            TextView price = findViewById(R.id.priceView);
            TextView type = findViewById(R.id.descView);
            ImageView image = findViewById(R.id.imageView);

            // This gets the particular Detailed object we are displaying
            // In this case, it is a Food object.
            Food myFood = intent.getParcelableExtra("Chosen Food");
            // This page will display the specific Detailed data for what your app is showing.
            // Get references to the xml views for name, price, desc, and photo
            // set values on the screen based on the object that was passed to this Detail activity

            name.setText(myFood.toString());
            type.setText(myFood.getDesc());
            price.setText(Double.toString(myFood.getPrice()) + "$");
            image.setImageResource(myFood.getImageResourceID());

            if (myFood.getImageResourceID() == 0) {
                // set a default pic or decide what to do in this case.
            }
            else {
        // replace the ___ with your ImageView variable
                myFood.setImageResourceID(myFood.getImageResourceID());
            }

        }
        catch (Exception e) {
            Log.i("Denna", "Food app not working!");
        }

    }
}