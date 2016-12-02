package com.example.a403.myapplication6;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity6 extends AppCompatActivity {

    Chronometer crn;
    Button btn_start, btn_end;
    RadioButton rdo_cal, rdo_time;
    CalendarView cal;
    TimePicker tp;
    TextView tv_year, tv_month, tv_day, tv_hour, tv_minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        setTitle("시간 예약");

        crn = (Chronometer) findViewById(R.id.crn);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_end = (Button) findViewById(R.id.btn_end);
        rdo_cal = (RadioButton) findViewById(R.id.rdo_cal);
        rdo_time = (RadioButton) findViewById(R.id.rdo_time);
        cal = (CalendarView) findViewById(R.id.cal);
        tp = (TimePicker) findViewById(R.id.tp);
        tv_year = (TextView) findViewById(R.id.tv_year);
        tv_month = (TextView) findViewById(R.id.tv_month);
        tv_day = (TextView) findViewById(R.id.tv_day);
        tv_hour = (TextView) findViewById(R.id.tv_hour);
        tv_minute = (TextView) findViewById(R.id.tv_minute);

        cal.setVisibility(View.INVISIBLE);
        tp.setVisibility(View.INVISIBLE);

        rdo_cal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cal.setVisibility(View.VISIBLE);
                tp.setVisibility(View.INVISIBLE);
            }
        });

        rdo_time.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cal.setVisibility(View.INVISIBLE);
                tp.setVisibility(View.VISIBLE);
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crn.setBase(SystemClock.elapsedRealtime());
                crn.start();
                crn.setTextColor(Color.RED);
            }
        });

        btn_end.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crn.stop();
                crn.setTextColor(Color.BLUE);

                java.util.Calendar curDate = java.util.Calendar.getInstance();
                curDate.setTimeInMillis(cal.getDate());
                tv_year.setText(Integer.toString(curDate.get(Calendar.YEAR)));
                tv_month.setText(Integer.toString(curDate.get(Calendar.MONTH)));
                tv_day.setText(Integer.toString(curDate.get(Calendar.DATE)));

                tv_hour.setText(Integer.toString(tp.getCurrentHour()));
                tv_minute.setText(Integer.toString(tp.getCurrentMinute()));
            }
        });
    }
}