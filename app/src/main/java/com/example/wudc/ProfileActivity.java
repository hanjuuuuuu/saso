package com.example.wudc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;



public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView name = findViewById(R.id.name);
        ImageButton rename= findViewById(R.id.rename);
/*
        Intent inIntent = getIntent();
        String Data = inIntent.getStringExtra("Data");*/

        SharedPreferences auto = getSharedPreferences("NAME", Activity.MODE_PRIVATE);
        String id = auto.getString("inputId", null);
        name.setText(id);
/*
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String Data = bundle.getString("Data");
        name.setText(Data);*/





        rename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //profile2로 화면전환
                Intent intent = new Intent(ProfileActivity.this, Profile2Activity.class);
                startActivity(intent);
            }
        });
        /*
        CircleImageView profileImage = findViewById(R.id.profileImage);
        ImageButton tab2 = findViewById(R.id.tab2);



        //Uri selectedImageUri = Uri.parse(bundle.getString("uri"));
        //profileImage.setImageURI(selectedImageUri);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        profileImage.setImageBitmap(bitmap);
 */



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