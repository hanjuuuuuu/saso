package com.example.wudc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String dbName = "Record.db";
    int dbVersion = 1;
    RecordDBHelper dbHelper;
    SQLiteDatabase db;
    ArrayList<String> Data = new ArrayList<String>();
    ArrayAdapter<String> Adapter;

    CalendarView calendar;
    TextView textview;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton addbtn = findViewById(R.id.addbtn);
        calendar = findViewById(R.id.calendar);
        textview = findViewById(R.id.textView6);


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {

                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;

                String date = selectYear + "년 " + (month + 1) + "월 " + dayOfMonth + "일";

                //dbHelper 선언 및 db 설정
                dbHelper = new RecordDBHelper(MainActivity.this, 1);
                db=dbHelper.getReadableDatabase();

                //if(date == dbHelper.getResult_check()) {
                    textview.setText(dbHelper.getResult());
               // }


                addbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                        intent.putExtra("selectedDate", date);

                        startActivity(intent); // 세컨드 액티비티 호출
                    }
                });


            }
        });

        ImageButton tab1 = findViewById(R.id.tab1);
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RecordActivity.class);
                startActivity(intent); // tab1 액티비티 호출
            }
        });

        ImageButton tab2 = findViewById(R.id.tab2);
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent); // tab1 액티비티 호출
            }
        });

        ImageButton tab3 = findViewById(R.id.tab3);
        tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
                startActivity(intent); // tab1 액티비티 호출
            }
        });

        ImageButton tab4 = findViewById(R.id.tab4);
        tab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent); // tab1 액티비티 호출
            }
        });

    }


}
