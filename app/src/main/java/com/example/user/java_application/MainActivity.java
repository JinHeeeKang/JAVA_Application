package com.example.user.java_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button voca;
    Button memo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voca = (Button)findViewById(R.id.voca_button);
        memo = (Button)findViewById(R.id.memo_button);

        voca.setText("어 휘 공 부");
        memo.setText("암 기 공 부");

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
