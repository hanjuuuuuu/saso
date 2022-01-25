package com.example.wudc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);

        ImageView image = findViewById(R.id.image);

        RadioButton btn1 = findViewById(R.id.btn1);
        RadioButton btn2 =findViewById(R.id.btn2);
        RadioButton btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "font/malgun.ttf"); // font 폴더내에 있는 jua.ttf 파일을 typeface로 설정
                text1.setTypeface(typeface);
                text2.setTypeface(typeface);
                image.setImageResource(R.drawable.malgun);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "font/hmfm.ttf"); // font 폴더내에 있는 jua.ttf 파일을 typeface로 설정
                text1.setTypeface(typeface);
                text2.setTypeface(typeface);
                image.setImageResource(R.drawable.hmfm);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "font/munhwa.ttf"); // font 폴더내에 있는 jua.ttf 파일을 typeface로 설정
                text1.setTypeface(typeface);
                text2.setTypeface(typeface);
                image.setImageResource(R.drawable.munhwa);
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
