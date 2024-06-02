package com.example.baseadapterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {

    private Context context;
    private String[] items;

    public MyCustomAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
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

        ViewHolder holder;

        if (convertView == null){
            // ConvertView: is a recycled view that you can reuse to improve the performances of your list
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout,parent,false);

            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.list_item);
            convertView.setTag(holder);

        }else {
            // Reusing the view (that's recycled)
            holder = (ViewHolder) convertView.getTag();
        }


        // Set the data to the view
        holder.textView.setText(items[position]);

        return convertView;

    }

    static class ViewHolder{
        // Holds references to the views within an item layout
        TextView textView;

    }
}
