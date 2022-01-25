package com.example.wudc;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//동아리 활동 기록 화면
public class RecordclubActivity extends AppCompatActivity {
    ImageButton btn_cancel;
    TextView view_club;
    RecordDBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordclub);

        //사용할 id 연결
        btn_cancel = findViewById(R.id.btn_cancel2);
        view_club = findViewById(R.id.view_club);

        dbHelper = new RecordDBHelper(RecordclubActivity.this, 1);
        db=dbHelper.getReadableDatabase();
        view_club.setText(dbHelper.getResult_club());

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
