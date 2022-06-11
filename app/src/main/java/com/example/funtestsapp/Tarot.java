package com.example.funtestsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tarot extends Activity {
    private TextView numtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarot);
        Button tarot = (Button)findViewById(R.id.tarotButton);
        numtv=this.findViewById(R.id.textView);
        tarot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num= (int) (Math.random()*10);
                String myString = String.valueOf(num);
                numtv.setText(myString);
                if(num>=0&&num<4){
                    Intent t1intent = new Intent(Tarot.this,taluo_result1.class);
                    startActivity(t1intent);
                }
                if(num>=4&&num<8){
                    Intent t2intent = new Intent(Tarot.this,taluo_result2.class);
                    startActivity(t2intent);
                }
                if(num == 8){
                    Intent t3intent = new Intent(Tarot.this,taluo_result3.class);
                    startActivity(t3intent);
                }
                if(num>=9&&num<=10){
                    Intent t4intent = new Intent(Tarot.this,taluo_tesult4.class);
                    startActivity(t4intent);
                }
            }
        });
    }
}