package com.example.wudc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

//활동기록 화면
public class RecordActivity extends AppCompatActivity {
    ImageButton btn_class;
    ImageButton btn_club;
    ImageButton btn_day;
    ImageButton btn_contest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        //사용할 id 연결
        btn_class = findViewById(R.id.btn_class);
        btn_club = findViewById(R.id.btn_club);
        btn_day = findViewById(R.id.btn_day);
        btn_contest = findViewById(R.id.btn_contest);

        //강의 버튼 누르면
        btn_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),RecordclassActivity.class);
                startActivity(intent);
            }
        });
        //동아리 버튼 누르면
        btn_club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),RecordclubActivity.class);
                startActivity(intent);
            }
        });
        //일상 버튼 누르면
        btn_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),RecorddayActivity.class);
                startActivity(intent);
            }
        });
        //공모전 버튼 누르면
        btn_contest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),RecordcontestActivity.class);
                startActivity(intent);
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
