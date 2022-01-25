package com.example.wudc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

//강의 활동 기록 화면
public class RecordclassActivity extends AppCompatActivity {
    ImageButton btn_cancel;
    TextView view_class;
    RecordDBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordclass);

        //사용할 id 연결
        btn_cancel = findViewById(R.id.btn_cancel1);
        view_class = findViewById(R.id.view_class);

        dbHelper = new RecordDBHelper(RecordclassActivity.this, 1);
        db=dbHelper.getReadableDatabase();
        view_class.setText(dbHelper.getResult_class());

        
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
