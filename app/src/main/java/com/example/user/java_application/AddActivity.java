package com.example.user.java_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {
    TextView add_mark;
    Button add_end,add_voca,add_memo;
    EditText add_eng,add_kr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        add_eng = (EditText)findViewById(R.id.add_eng);
        add_kr = (EditText)findViewById(R.id.add_kr);
        add_voca = (Button)findViewById(R.id.add_voca);
        add_memo = (Button)findViewById(R.id.add_memo);
        add_end = (Button)findViewById(R.id.add_end);
        add_mark = (TextView)findViewById(R.id.add_mark);
        add_mark.setText("단 어 추 가");

        add_voca.setText("voca 추 가");
        add_voca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eng_word = add_eng.getText().toString();
                String kr_word = add_kr.getText().toString();

                Intent intent_add = new Intent(AddActivity.this, VocaActivity.class);
                intent_add.putExtra("eng", eng_word);
                intent_add.putExtra("kr", kr_word);
                startActivity(intent_add);

            }
        });
        add_memo.setText("memo 추 가");
        add_memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eng_word = add_eng.getText().toString();
                String kr_word = add_kr.getText().toString();

                Intent intent_add = new Intent(AddActivity.this, MemorizingActivity.class);
                intent_add.putExtra("eng", eng_word);
                intent_add.putExtra("kr", kr_word);
                startActivity(intent_add);

            }
        });

        add_end.setText("종 료");
        add_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                finish();
            }
        });





    }
}
