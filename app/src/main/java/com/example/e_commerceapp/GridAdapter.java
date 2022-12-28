package com.example.e_commerceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] x;
    int[] image;

    LayoutInflater inflater;

    public GridAdapter(Context context, String[] store, int[] image) {
        this.context = context;
        this.x = store;
        this.image = image;
    }

    @Override
    public int getCount() {
        return x.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView==null){
            convertView=inflater.inflate(R.layout.grid_item,null);
        }
        ImageView imageView=convertView.findViewById(R.id.image_gridview);
        TextView textView=convertView.findViewById(R.id.textgrid);

        imageView.setImageResource(image[position]);
        textView.setText(x[position]);
        return convertView;
    }
}

