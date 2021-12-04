package com.example.carwashticket;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Mobil> Mobil;
    public CustomListAdapter(Activity activity, List<Mobil>
            Mobil) {
        this.activity = activity;
        this.Mobil = Mobil;
    }
    @Override
    public int getCount() {
        return Mobil.size();
    }
    @Override
    public Object getItem(int location) {
        return Mobil.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView plat = (TextView)
                convertView.findViewById(R.id.text_plat);
        TextView owner = (TextView)
                convertView.findViewById(R.id.text_owner);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Mobil m = Mobil.get(position);
        plat.setText("License Plate : "+ m.get_plat());
        owner.setText("Owner : "+ m.get_owner());
        return convertView;
    }
}
