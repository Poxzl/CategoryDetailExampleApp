package com.example.categorydetailexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final Food[] myBreakfast = {
            new Food("Pancakes", 6.99, "4 pancakes", R.drawable.pancakes),
            new Food("Waffles", 7.50, "Crispy Golden Brown", R.drawable.waffles)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}