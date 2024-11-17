package com.example.assignment4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment4.R;

public class CustomAdapter extends BaseAdapter {

    private final Context context;
    private final String[] items;
    private final int[] images;

    public CustomAdapter(Context context, String[] items, int[] images) {
        this.context = context;
        this.items = items;
        this.images = images;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.itemImage);
        TextView textView = convertView.findViewById(R.id.itemText);

        imageView.setImageResource(images[position]);
        textView.setText(items[position]);

        return convertView;
    }
}
