package com.example.wudc;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//일상 활동 기록 화면
public class RecorddayActivity extends AppCompatActivity {
    ImageButton btn_cancel;
    RecordDBHelper dbHelper;
    TextView view_day;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordday);

        //사용할 id 연결
        btn_cancel = findViewById(R.id.btn_cancel4);
        view_day = findViewById(R.id.view_day);

        dbHelper = new RecordDBHelper(RecorddayActivity.this, 1);
        db=dbHelper.getReadableDatabase();
        view_day.setText(dbHelper.getResult_day());

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
