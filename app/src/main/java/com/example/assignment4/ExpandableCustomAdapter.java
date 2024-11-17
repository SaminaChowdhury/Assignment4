package com.example.assignment4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableCustomAdapter extends BaseAdapter {

    private final Context context;
    private final List<String> parentItems;
    private final int[] images;
    private final HashMap<String, List<String>> subItems;
    private final HashMap<Integer, Boolean> expandedState;

    public ExpandableCustomAdapter(Context context, List<String> parentItems, int[] images, HashMap<String, List<String>> subItems) {
        this.context = context;
        this.parentItems = parentItems;
        this.images = images;
        this.subItems = subItems;
        this.expandedState = new HashMap<>();
    }

    @Override
    public int getCount() {
        return parentItems.size();
    }

    @Override
    public Object getItem(int position) {
        return parentItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.expandable_parent_item, parent, false);
        }

        // Parent item views
        TextView parentText = convertView.findViewById(R.id.parentText);
        ImageView parentImage = convertView.findViewById(R.id.parentImage);
        ListView subListView = convertView.findViewById(R.id.subListView);
        ImageView expandIcon = convertView.findViewById(R.id.expandIcon);

        // Set parent item data
        parentText.setText(parentItems.get(position));
        parentImage.setImageResource(images[position]);

        // Set up the subitems
        List<String> currentSubItems = subItems.get(parentItems.get(position));
        SubItemAdapter subItemAdapter = new SubItemAdapter(context, currentSubItems);
        subListView.setAdapter(subItemAdapter);

        // Toggle visibility of subListView
        boolean isExpanded = expandedState.getOrDefault(position, false);
        subListView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        expandIcon.setImageResource(isExpanded ? R.drawable.ic_arrow_up : R.drawable.ic_arrow_down);

        // Handle clicks to expand/collapse
        convertView.setOnClickListener(v -> {
            boolean newState = !expandedState.getOrDefault(position, false);
            expandedState.put(position, newState);
            notifyDataSetChanged(); // Refresh ListView to update visibility
        });

        return convertView;
    }
}
