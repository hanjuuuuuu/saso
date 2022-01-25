package com.example.wudc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile2Activity extends AppCompatActivity {
    private final int REQUEST_CODE = 200;
    private CircleImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        EditText name = findViewById(R.id.name);
        ImageButton false1 = findViewById(R.id.false1);
        ImageButton true1 = findViewById(R.id.true1);
        ImageButton tab2 = findViewById(R.id.tab2);
        profileImage = findViewById(R.id.profileImage);


        false1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String Data = name.getText().toString();
                bundle.putString("Data",Data);
                /*Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("Data",name.getText().toString());
                startActivity(intent);
                finish();*/
                Toast.makeText(getApplicationContext(),"수정 완료!", Toast.LENGTH_SHORT).show();
            }
        });

        profileImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        "image/*");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
/*
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });*/
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            profileImage.setImageURI(selectedImageUri);
        }
    }
}