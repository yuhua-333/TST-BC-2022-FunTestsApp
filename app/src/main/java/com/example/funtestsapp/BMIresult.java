package com.example.funtestsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BMIresult extends Activity {
    TextView textView;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);
        textView = (TextView) findViewById(R.id.textView);
        Bundle bundle = this.getIntent().getExtras();
        String msg = bundle.getString("msg");
        textView.setText(msg);
        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMIresult.this, menu.class);
                startActivity(intent);
            }
        });
    }
}