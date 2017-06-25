package com.example.user.java_application;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity {

    Button check_end,check_button,chance;
    EditText in_word;
    TextView eng_word,han_word;
    TextView check_mark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);


        in_word = (EditText) findViewById(R.id.input_word);
        check_end = (Button) findViewById(R.id.check_end);
        chance = (Button) findViewById(R.id.chance_button);
        check_button = (Button) findViewById(R.id.check_button);
        eng_word = (TextView) findViewById(R.id.eng_word);
        han_word = (TextView) findViewById(R.id.han_word);
        check_mark = (TextView) findViewById(R.id.check_mark);

        check_mark.setText("정 답 확 인");
        check_button.setText("정 답 확 인");

        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer=getIntent().getExtras().getString("Answer");
                String meaning_word = getIntent().getExtras().getString("meaning");

                String in_str = in_word.getText().toString();
                if(in_str.equals(answer)){
                    Toast.makeText(CheckActivity.this,"정답!",Toast.LENGTH_SHORT).show();
                    eng_word.setText("단어 : "+answer);
                    han_word.setText("뜻 : "+meaning_word);

                    //finish();
                }
                else{
                    Toast.makeText(CheckActivity.this,"오답!",Toast.LENGTH_SHORT).show();
                }
                }

        });
        chance.setText("chance");
        chance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String answer=getIntent().getExtras().getString("Answer");
                eng_word.setText(answer);
                Handler delayHandler = new Handler();
                delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // TODO
                        eng_word.setText("");
                    }
                }, 1000);
            }
        });

        check_end.setText("뒤 로 가 기");
        check_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MemorizingActivity.class);
                startActivity(intent);

                finish();
            }
        });



    }
}
