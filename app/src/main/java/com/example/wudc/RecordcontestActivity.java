package com.example.wudc;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Date;
import java.util.List;

import static java.sql.DriverManager.println;

//공모전 활동 기록 화면
public class RecordcontestActivity extends AppCompatActivity {
    ImageButton btn_cancel;
    TextView view_contest;
    RecordDBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordcontest);

        //사용할 id 연결
        btn_cancel = findViewById(R.id.btn_cancel3);
        view_contest = findViewById(R.id.view_contest);

        dbHelper = new RecordDBHelper(RecordcontestActivity.this, 1);
        db=dbHelper.getReadableDatabase();
        view_contest.setText(dbHelper.getResult_contest());

        //취소 버튼 누르면
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),RecordActivity.class);
                startActivity(intent);
            }
        });



    }

}
