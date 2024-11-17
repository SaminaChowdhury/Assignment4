package com.example.assignment4;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ListView
        ListView customListView = findViewById(R.id.customListView);

        // Parent items with corresponding images
        List<String> parentItems = new ArrayList<>();
        parentItems.add("Pasta");
        parentItems.add("Maggi");
        parentItems.add("Cake");
        parentItems.add("Pancake");
        parentItems.add("Pizza");

        int[] images = {
                R.drawable.image1, // Image for Pasta
                R.drawable.image2, // Image for Maggi
                R.drawable.image3, // Image for Cake
                R.drawable.image4, // Image for Pancake
                R.drawable.image5  // Image for Pizza
        };

        // Subitems mapped to parent items
        HashMap<String, List<String>> subItems = new HashMap<>();
        subItems.put("Pasta", List.of("Penne", "Spaghetti", "Fettuccine"));
        subItems.put("Maggi", List.of("Classic", "Curry", "Masala"));
        subItems.put("Cake", List.of("Chocolate Cake", "Vanilla Cake", "Red Velvet"));
        subItems.put("Pancake", List.of("Buttermilk Pancake", "Blueberry Pancake", "Banana Pancake"));
        subItems.put("Pizza", List.of("Margherita", "Pepperoni", "BBQ Chicken"));

        // Custom adapter that combines parent and subitems
        ExpandableCustomAdapter adapter = new ExpandableCustomAdapter(this, parentItems, images, subItems);
        customListView.setAdapter(adapter);
    }
}
