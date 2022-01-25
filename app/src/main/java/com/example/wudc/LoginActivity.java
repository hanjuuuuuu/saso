package com.example.wudc;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 200;
    private CircleImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        profileImage = findViewById(R.id.profileImage);
        ImageButton true1 = findViewById(R.id.true1);
        EditText name = findViewById(R.id.name);


        true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString() .equals("")){
                    Toast.makeText(getApplicationContext(),"닉네임을 입력하세요",Toast.LENGTH_SHORT).show();
                }else{
                    SharedPreferences auto = getSharedPreferences("NAME", Activity.MODE_PRIVATE);
                    SharedPreferences.Editor autoLogin = auto.edit();
                    autoLogin.putString("inputId", name.getText().toString());

                    autoLogin.commit();
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);

                    Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent1);
                }

            }
        });

        /*profileImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        "image/*");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });*/

    }
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            profileImage.setImageURI(selectedImageUri);
        }
    }*/
}
