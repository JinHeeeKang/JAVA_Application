package com.example.user.java_application;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemorizingActivity extends AppCompatActivity {

    String[] Mword = {"destination","confident","prescription","vegetarian","population","consciousness"};
    String[] Hword = {"목적지","자신감있는","처방전","채식주의자","인구","의식"};


    Button memo_end,memo_add,here_btn;
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
        memo_add= (Button) findViewById(R.id.memo_add);
        here_btn = (Button) findViewById(R.id.here_btn);

        memo_mark.setText("암 기 공 부 (Memorizing)");
        here_btn.setText("HERE");

        final List<String> MwordList = new ArrayList<String>();
        final List<String> HwordList = new ArrayList<String>();
        for(int p =0; p<num;p++){
           MwordList.add(Mword[p]);
           HwordList.add(Hword[p]);
       }

        Random rand = new Random();
        final int j = rand.nextInt(6);
        final int i = 0;
        m_word.setText( MwordList.get(j));

        memo_add.setText("단 어 추 가");
        memo_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eng_word = getIntent().getExtras().getString("eng");
                String kr_word = getIntent().getExtras().getString("kr");
                int n = MwordList.size();
                MwordList.add(n , eng_word);
                HwordList.add(n , kr_word);
                m_word.setText( MwordList.get(n));

            }
        });

        here_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), CheckActivity.class);
                    intent.putExtra("Answer",MwordList.get(j));
                    intent.putExtra("meaning",HwordList.get(j));

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
