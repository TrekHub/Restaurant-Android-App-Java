package com.example.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {

    private String[] restaurants = new String[]{"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    private String[] cuisines = new String[] {"Vegan Food", "Breakfast",
            "Fishs Dishs", "Scandinavian", "Coffee",
            "English Food", "Burgers", "Fast Food",
            "Noodle Soups", "Mexican", "BBQ", "Cuban",
            "Bar Food", "Sports Bar", "Breakfast", "Mexican" };



    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listview) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);
        MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        mListView.setAdapter(adapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public  void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                String restaurant = ((TextView)view).getText().toString();
                Log.v("RestaurantActivity", "In the onItemClickListener!");
                Toast.makeText(RestaurantsActivity.this, restaurant,Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the restaurants near: " + location);
    }





}