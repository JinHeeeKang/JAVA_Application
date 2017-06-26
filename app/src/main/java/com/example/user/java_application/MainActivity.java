package com.example.user.java_application;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button voca,memo;
    Button add_btn;
    ImageView main_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, SplashActivity.class));


        voca = (Button)findViewById(R.id.voca_button);
        memo = (Button)findViewById(R.id.memo_button);
        add_btn = (Button)findViewById(R.id.add_btn);
        main_image = (ImageView)findViewById(R.id.main_image);

        voca.setText("어 휘");
        memo.setText("암 기");
        add_btn.setText("단 어 입 력");

        Drawable drawable = getResources().getDrawable(
                R.drawable.images);
        main_image.setImageDrawable(drawable);


        add_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_a = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent_a);
            }
        });

        voca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), VocaActivity.class);
                startActivity(intent);
            }
        });
        memo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent2 = new Intent(getApplicationContext(), MemorizingActivity.class);
                startActivity(intent2);

            }
        });

    }
}
