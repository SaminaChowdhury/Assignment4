package com.example.assignment4;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment4.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpandableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        ExpandableListView expandableListView = findViewById(R.id.expandableListView);

        // Define parent items
        List<Map<String, String>> groupList = new ArrayList<>();
        groupList.add(createGroup("Fruits"));
        groupList.add(createGroup("Vegetables"));

        // Define child items
        List<List<Map<String, String>>> childList = new ArrayList<>();

        List<Map<String, String>> fruitChildren = new ArrayList<>();
        fruitChildren.add(createChild("Apple"));
        fruitChildren.add(createChild("Banana"));
        fruitChildren.add(createChild("Cherry"));
        childList.add(fruitChildren);

        List<Map<String, String>> vegetableChildren = new ArrayList<>();
        vegetableChildren.add(createChild("Carrot"));
        vegetableChildren.add(createChild("Broccoli"));
        vegetableChildren.add(createChild("Spinach"));
        childList.add(vegetableChildren);

        // Create adapter
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groupList,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"Group"},
                new int[]{android.R.id.text1},
                childList,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"Child"},
                new int[]{android.R.id.text1}
        );

        expandableListView.setAdapter(adapter);
    }

    private Map<String, String> createGroup(String name) {
        Map<String, String> group = new HashMap<>();
        group.put("Group", name);
        return group;
    }

    private Map<String, String> createChild(String name) {
        Map<String, String> child = new HashMap<>();
        child.put("Child", name);
        return child;
    }
}
