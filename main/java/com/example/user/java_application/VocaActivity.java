package com.example.user.java_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class VocaActivity extends AppCompatActivity {
    String[] Eword = {"send","cat","dog","chair","desk","notebook","parent","redundant","vegetarian","population","dismiss"};
    String[] Hword = {"보내다","고양이","개","의자","책상","공책","부모","정리해고당한","채식주의자","인구","해고하다"};
    int num = 11;

    TextView voca_word,voca_mark;
    Button voca_end;
    Button one,two,three,four;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voca);

        voca_mark = (TextView)findViewById(R.id.voca_mark);

        voca_word = (TextView)findViewById(R.id.voca_word);

        voca_end = (Button) findViewById(R.id.voca_end);
        one = (Button) findViewById(R.id.buttonOne);
        two = (Button) findViewById(R.id.buttonTwo);
        three = (Button) findViewById(R.id.buttonThree);
        four = (Button) findViewById(R.id.buttonFour);

        voca_mark.setText("Vocabulary");

        Random rand = new Random();

        final int j = rand.nextInt(4);

        int i = rand.nextInt(num);
        voca_word.setText(Eword[i]);

        switch (j){
            case 0 : one.setText(Hword[i]);two.setText(Hword[(i+1)%num]);three.setText(Hword[(i+2)%num]);four.setText(Hword[(i+3)%num]);break;
            case 1 : two.setText(Hword[i]);one.setText(Hword[(i+1)%num]);three.setText(Hword[(i+2)%num]);four.setText(Hword[(i+3)%num]);break;
            case 2 : three.setText(Hword[i]);two.setText(Hword[(i+1)%num]);one.setText(Hword[(i+2)%num]);four.setText(Hword[(i+3)%num]);break;
            case 3 : four.setText(Hword[i]);two.setText(Hword[(i+1)%num]);three.setText(Hword[(i+2)%num]);one.setText(Hword[(i+3)%num]);break;
        }


        voca_end.setText("뒤 로 가 기");
        voca_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                finish();
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j == 0) {
                    Toast.makeText(VocaActivity.this,"정답!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), VocaActivity.class);
                    startActivity(intent);

                    finish();
                }
                else{
                    Toast.makeText(VocaActivity.this,"오답!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j == 1) {
                    Toast.makeText(VocaActivity.this,"정답!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), VocaActivity.class);
                    startActivity(intent);

                    finish();
                }
                else{
                    Toast.makeText(VocaActivity.this,"오답!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j == 2) {
                    Toast.makeText(VocaActivity.this,"정답!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), VocaActivity.class);
                    startActivity(intent);

                    finish();
                }
                else{
                    Toast.makeText(VocaActivity.this,"오답!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j == 3) {
                    Toast.makeText(VocaActivity.this,"정답!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), VocaActivity.class);
                    startActivity(intent);

                    finish();
                }
                else{
                    Toast.makeText(VocaActivity.this,"오답!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
