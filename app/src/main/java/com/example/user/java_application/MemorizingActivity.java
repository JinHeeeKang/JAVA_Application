package com.example.user.java_application;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MemorizingActivity extends AppCompatActivity {

    String[][] Mword = {{"destination"},{"confident"},{"prescription"},{"vegetarian"},{"population"},{"consciousness"}};
    String[] Hword = {"목적지","자신감있는","처방전","채식주의자","인구","의식"};
    //{"d","e","s","t","i","n","a","t","i","o","n"},{"c","o","n","f","i","d","e","n","t"}

    Button memo_end,touch_button;
    TextView memo_mark;
    TextView m_word;
    int num = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorizing);

        memo_mark = (TextView) findViewById(R.id.memo_mark);
        m_word = (TextView) findViewById(R.id.m_word);
        memo_end = (Button) findViewById(R.id.memo_end);
        touch_button = (Button) findViewById(R.id.touch_button);

        memo_mark.setText("암 기 공 부 (Memorizing)");
        touch_button.setText("HERE");

        Random rand = new Random();
        final int j = rand.nextInt(6);

        m_word.setText(Mword[j][0]);
            touch_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), CheckActivity.class);
                    intent.putExtra("Answer",Mword[j][0]);
                    intent.putExtra("meaning",Hword[j]);

                    Handler delayHandler = new Handler();
                    delayHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // TODO
                        }
                    }, 3000);
                    startActivity(intent);

                }
            });







        memo_end.setText("뒤 로 가 기");
        memo_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }
}
