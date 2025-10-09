package com.example.lab5_starter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CityArrayAdapter extends ArrayAdapter<City> {
    private ArrayList<City> cities;
    private Context context;

    private int selectedPosition = -1;

    public CityArrayAdapter(Context context, ArrayList<City> cities){
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_city, parent, false);
        }

        City city = cities.get(position);
        TextView cityName = view.findViewById(R.id.textCityName);
        TextView cityProvince = view.findViewById(R.id.textCityProvince);

        cityName.setText(city.getName());
        cityProvince.setText(city.getProvince());

        if (position == selectedPosition) {
            view.setBackgroundColor(Color.LTGRAY);
        } else {
            view.setBackgroundColor(Color.WHITE);
        }


        return view;
    }

    public void setSelectedPosition(int position) {
        if(selectedPosition != position) {
            selectedPosition = position;
            notifyDataSetChanged();
        }
    }

}
