package com.myapplicationdev.android.sgholidays;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowHolidays extends AppCompatActivity {
    TextView tvName;
    TextView tvDate;
    TextView tvType;
    ArrayList<Holiday> secularHoliday;
    ArrayList<Holiday> ethnicHoliday;
    ArrayAdapter aa;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);

        lv = (ListView) this.findViewById(R.id.lvHolidays);
        tvType = (TextView) this.findViewById(R.id.tvType);
        tvName = (TextView) this.findViewById(R.id.tvName);
        tvDate = (TextView) this.findViewById(R.id.tvDate);

        secularHoliday = new ArrayList<Holiday>();
        secularHoliday.add(new Holiday("Labour Day", "1 May 2017", "labour_day.png"));
        secularHoliday.add(new Holiday("New Year's Day", "1 Jan 2017", "new_year.png"));


        ethnicHoliday = new ArrayList<Holiday>();
        ethnicHoliday.add(new Holiday("Chinese New Year", "28-29 Jan 2017", "cny.png"));
        ethnicHoliday.add(new Holiday("Good Friday", "14 April 2017", "good_friday.png"));

        Intent i = getIntent();
        String type = i.getStringExtra(Intent.EXTRA_TEXT);

        if(type.equals("Secular")){
            tvType.setText("Secular");
            aa = new HolidayAdapter(this, R.layout.row, secularHoliday);
        } else {
            tvType.setText("Ethnic & Religion");
            aa = new HolidayAdapter(this, R.layout.row, ethnicHoliday);
        }

        lv.setAdapter(aa);
    }

}
