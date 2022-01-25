package com.example.wudc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ActionMode;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Logo extends AppCompatActivity {
    ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    logoImage = findViewById(R.id.logoImage);
                    Animation alphaAnim = AnimationUtils.loadAnimation(Logo.this, R.anim.alpha2);
                    logoImage.startAnimation(alphaAnim);
                    Thread.sleep(2000);
                    Animation alphaAnim2 = AnimationUtils.loadAnimation(Logo.this, R.anim.alpha);
                    logoImage.startAnimation(alphaAnim2);
                    isIntro();
                } catch (Exception e) {
                }
            }
        }).start();

    }
    private void isIntro(){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();

    }


}


