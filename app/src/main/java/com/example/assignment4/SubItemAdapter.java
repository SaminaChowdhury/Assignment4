package com.example.assignment4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SubItemAdapter extends BaseAdapter {

    private final Context context;
    private final List<String> subItems;

    public SubItemAdapter(Context context, List<String> subItems) {
        this.context = context;
        this.subItems = subItems;
    }

    @Override
    public int getCount() {
        return subItems.size();
    }

    @Override
    public Object getItem(int position) {
        return subItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.sub_item, parent, false);
        }

        TextView subItemText = convertView.findViewById(R.id.subItemText);
        subItemText.setText(subItems.get(position));

        return convertView;
    }
}
