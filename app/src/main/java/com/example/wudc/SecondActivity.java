package com.example.wudc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ImageButton falsebtn;
    ImageButton truebtn;
    ImageButton class_btn, club_btn, day_btn, contest_btn;
    ListView listView;

    TextView selectedDate;
    EditText club_name, contents, thoughts;
    ArrayList<String> Data = new ArrayList<String>();
    String sql, data;
    SQLiteDatabase db;
    ArrayAdapter<String> Adapter;
    RecordDBHelper dbHelper;
    String dbName = "Record.db";
    int dbVersion = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        club_name = findViewById(R.id.club_name);
        contents = findViewById(R.id.contents);
        thoughts = findViewById(R.id.thoughts);
        //listView = findViewById(R.id.listview);

        // 선택된 날짜 명시 (인텐트 사용)
        selectedDate = findViewById(R.id.selectedDate);
        Intent intent = getIntent();
        String date = intent.getExtras().getString("selectedDate");
        selectedDate.setText(date);

        // 버튼 변수 설정
        falsebtn = findViewById(R.id.falsebtn);
        truebtn = findViewById(R.id.truebtn);

        class_btn = findViewById(R.id.class_btn);
        club_btn = findViewById(R.id.club_btn);
        day_btn = findViewById(R.id.day_btn);
        contest_btn = findViewById(R.id.contest_btn);

        // 이 아래부터 종류별 저장
        class_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class_btn.setImageResource(R.drawable.buttonclass);
                club_btn.setImageResource(R.drawable.buttonclub2);
                day_btn.setImageResource(R.drawable.buttonday2);
                contest_btn.setImageResource(R.drawable.buttoncontest2);

                dbHelper = new RecordDBHelper(SecondActivity.this, 1);

                dbHelper.insert(selectedDate.getText().toString(), club_name.getText().toString(),"class",
                        contents.getText().toString(), thoughts.getText().toString());

            }
        });

        club_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class_btn.setImageResource(R.drawable.buttonclass2);
                club_btn.setImageResource(R.drawable.buttonclub);
                day_btn.setImageResource(R.drawable.buttonday2);
                contest_btn.setImageResource(R.drawable.buttoncontest2);

                dbHelper = new RecordDBHelper(SecondActivity.this, 1);

                dbHelper.insert(selectedDate.getText().toString(), club_name.getText().toString(),"club",
                        contents.getText().toString(), thoughts.getText().toString());

            }
        });

        day_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class_btn.setImageResource(R.drawable.buttonclass2);
                club_btn.setImageResource(R.drawable.buttonclub2);
                day_btn.setImageResource(R.drawable.buttonday);
                contest_btn.setImageResource(R.drawable.buttoncontest2);

                dbHelper = new RecordDBHelper(SecondActivity.this, 1);

                dbHelper.insert(selectedDate.getText().toString(), club_name.getText().toString(),"day",
                        contents.getText().toString(), thoughts.getText().toString());

            }
        });

        contest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class_btn.setImageResource(R.drawable.buttonclass2);
                club_btn.setImageResource(R.drawable.buttonclub2);
                day_btn.setImageResource(R.drawable.buttonday2);
                contest_btn.setImageResource(R.drawable.buttoncontest);

                dbHelper = new RecordDBHelper(SecondActivity.this, 1);

                dbHelper.insert(selectedDate.getText().toString(), club_name.getText().toString(),"contest",
                        contents.getText().toString(), thoughts.getText().toString());


            }
        });


        // 뒤로가기
        falsebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        //저장버튼 누르면 데이터 전달, 활동기록 화면으로 이동
        truebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),RecordActivity.class);
                startActivity(intent);

            }
        });




    }








}