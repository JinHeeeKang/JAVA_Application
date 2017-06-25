package com.example.user.java_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MemorizingActivity extends AppCompatActivity {

    Button memo_end;
    TextView memo_mark;
    TextView touch_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorizing);

        memo_mark = (TextView)findViewById(R.id.memo_mark);
        touch_text = (TextView)findViewById(R.id.touch_text);
        memo_end = (Button) findViewById(R.id.memo_end);

        memo_mark.setText("Memorizing");

        touch_text.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == 1) {

                    return true;
                }else{
                    return false;
                }
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
