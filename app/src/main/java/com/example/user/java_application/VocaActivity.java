package com.example.user.java_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class VocaActivity extends AppCompatActivity {
    String[] Eword = {"preach","abolition","breakthrough","frequency","sodium","dependence","parent","alteration","vegetarian",
            "population","dismiss","parallel","depressed","dignity","dye"};
    String[] Hword = {"설교하다","폐지","돌파구","빈도","나트륨","의존","부모","변화","채식주의자",
            "인구","해고하다", "평행한","우울한","위엄","염색하다"};
    int num = 15;

    TextView voca_word,voca_mark;
    Button voca_end,voca_add;
    Button one,two,three,four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voca);

        final List<String> EwordList = new ArrayList<String>();
        final List<String> HwordList = new ArrayList<String>();
        for(int p =0; p<num;p++){
            EwordList.add(Eword[p]);
            HwordList.add(Hword[p]);
        }

        Intent intentt = getIntent();
        final int ret = intentt.getIntExtra("num",1);
        if(ret == 8){
            Toast.makeText(VocaActivity.this,"통과!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }



        voca_mark = (TextView)findViewById(R.id.voca_mark);
        voca_word = (TextView)findViewById(R.id.voca_word);

        voca_add = (Button) findViewById(R.id.voca_add);
        voca_end = (Button) findViewById(R.id.voca_end);
        one = (Button) findViewById(R.id.buttonOne);
        two = (Button) findViewById(R.id.buttonTwo);
        three = (Button) findViewById(R.id.buttonThree);
        four = (Button) findViewById(R.id.buttonFour);

        voca_mark.setText("단 어 공 부 (Vocabulary)");

        Random rand = new Random();

        final int j = rand.nextInt(4);

        int i = rand.nextInt(num);
        voca_word.setText(EwordList.get(i));
        switch (j){
            case 0 : one.setText(HwordList.get(i));two.setText(HwordList.get((i+1)%num));three.setText(HwordList.get((i+2)%num));four.setText(HwordList.get((i+3)%num));break;
            case 1 : two.setText(HwordList.get(i));one.setText(HwordList.get((i+1)%num));three.setText(HwordList.get((i+2)%num));four.setText(HwordList.get((i+3)%num));break;
            case 2 : three.setText(HwordList.get(i));two.setText(HwordList.get((i+1)%num));one.setText(HwordList.get((i+2)%num));four.setText(HwordList.get((i+3)%num));break;
            case 3 : four.setText(HwordList.get(i));two.setText(HwordList.get((i+1)%num));three.setText(HwordList.get((i+2)%num));one.setText(HwordList.get((i+3)%num));break;
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
       voca_add.setText("단 어 추 가");
        voca_add.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            String eng_word = getIntent().getExtras().getString("eng");
            String kr_word = getIntent().getExtras().getString("kr");
            int n = EwordList.size();
            EwordList.add(n , eng_word);
            HwordList.add(n , kr_word);
            voca_word.setText(EwordList.get(n));


            }
        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j == 0) {
                    Toast.makeText(VocaActivity.this,"정답!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), VocaActivity.class);
                    intent.putExtra("num",ret+1);
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
                    intent.putExtra("num",ret+1);
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
                    intent.putExtra("num",ret+1);
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
                    intent.putExtra("num",ret+1);
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
