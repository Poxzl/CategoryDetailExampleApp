package com.example.categorydetailexampleapp;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Food implements Parcelable {
    private String name;
    private double price;
    private String desc;
    private int imageResourceID = 0;

    public static final Food[] breakfastItems = {
            new Food("Pancakes", 2.99, "4 pancakes", R.drawable.pancakes),
            new Food("Waffles", 3.99, "4 pancakes", R.drawable.pancakes),
            new Food("Cookie", 2.99, "4 pancakes", R.drawable.pancakes),
    };

    public static final Food[] lunchItems = {
            new Food("Pizza", 5.99, "4 pancakes", R.drawable.pancakes),
            new Food("PB&J", 3.99, "4 pancakes", R.drawable.pancakes),
            new Food("Breadsticks", 3.99, "4 pancakes", R.drawable.pancakes),
    };
    public static final Food[] dinnerItems = {
            new Food("Wings", 8.99, "4 pancakes", R.drawable.pancakes),
            new Food("Club Sandwich", 10.99, "4 pancakes", R.drawable.pancakes),
            new Food("Chicken Tika Masala", 11.99, "4 pancakes", R.drawable.pancakes),
    };



    // A default constructor is required for the Parceable interface to work
    public Food() {
        name = "";
        price = 0;
        desc = "";
        imageResourceID = 0;
    }

    public Food(String food, double dollarPrice, String type, int image) {
        name = food;
        price = dollarPrice;
        desc = type;
        imageResourceID = image;
    }

    public String toString() {
        return this.name;
    }
    public double getPrice(){
        return price;
    }
    public String getDesc() {
        return desc;
    }
    public int getImageResourceID(){
        return imageResourceID;
    }
    public int setImageResourceID(int imageNum){
        return imageResourceID = imageNum;
    }

    /** This is a "constructor" of sorts that is needed with the Parceable interface to
     * tell the intent how to create a Food object when it is received from the intent
     * basically it is setting each instance variable as a String or Int
     * if the instance variables were objects themselves you would need to do more complex * code.  We need to read in the String, double, and int data.
     *
     * @param parcel    the parcel that is received from the intent
     */

    public Food(Parcel parcel) {
        name = parcel.readString();
        price = parcel.readDouble();
        desc = parcel.readString();
        imageResourceID = parcel.readInt();
    }

    /**
     * This is what is used when we send the Food object through an intent
     * It is also a method that is part of the Parceable interface and is needed
     * to set up the object that is being sent.  Then, when it is received, the
     * other Food constructor that accepts a Parcel reference can "unpack it"
     *
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeString(desc);
        dest.writeInt(imageResourceID);
    }

    // this code is needed for the Food class to work with Parcelable
    public static final Parcelable.Creator<Food> CREATOR = new
            Parcelable.Creator<Food>() {

                @Override
                public Food createFromParcel(Parcel parcel) {
                    return new Food(parcel);
                }

                @Override
                public Food[] newArray(int size) {
                    return new Food[0];
                }
            };

    /**
     * This method is required for the Parceable interface.  As of now, this method * is in the default state and doesn't really do anything.
     *
     * If your Parcelable class will have child classes, you'll need to
     * take some extra care with the describeContents() method. This would
     * let you identify the specific child class that should be created by
     * the Parcelable.Creator. You can read more about how this works on
     *  Stack Overflow with this link.
     *           https://stackoverflow.com/questions/4778834/purpose-of-describecontents-of-parcelable-interface
     * @return
     */

    @Override
    public int describeContents() {
        return 0;
    }


}
