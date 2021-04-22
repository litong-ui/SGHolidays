package com.myapplicationdev.android.sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday>{

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvType;
    private TextView tvDate;
    private ImageView imageView;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvType = (TextView) rowView.findViewById(R.id.tvName);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        imageView = (ImageView) rowView.findViewById(R.id.imageView);

        Holiday currentHoliday = holiday.get(position);

        tvType.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());

        if(currentHoliday.getName().equals("New Year's Day")) {
            imageView.setImageResource(R.drawable.new_year);
        }
        else if(currentHoliday.getName().equals("Labour Day")){
            imageView.setImageResource(R.drawable.labour_day);
        }
        else if(currentHoliday.getName().equals("Chinese New Year")){
            imageView.setImageResource(R.drawable.cny);
        }
        else if(currentHoliday.getName().equals("Good Friday")){
            imageView.setImageResource(R.drawable.good_friday);
        }

        return rowView;
    }
}
