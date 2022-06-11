package com.example.funtestsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mental extends Activity {
    private TextView tv;
    private TextView tvsum;
    private Button bt1;
    private Button bt2;
    private Button bt3;
    int count=0,sum1=0,sum2=0,sum3=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental);
        //1.找到按钮，文本框
        tv=this.findViewById(R.id.TextView);
        tvsum=this.findViewById(R.id.Text);
        bt1=this.findViewById(R.id.button1);
        bt2=this.findViewById(R.id.button2);
        bt3=this.findViewById(R.id.button3);
        //2.给按钮添加点击事件
        bt1.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
               count++;
               sum1++;
               if(count==1){
                   tv.setText("问题二：是否经常焦虑未发生的事情？");
               }
               if(count==2){
                   tv.setText("问题三：是否做事情时无法集中精力？");
               }
               if(count==3){
                   tv.setText("问题四：是否突然感到一阵心慌和害怕");
               }
               if(count==4){
                   tv.setText("问题五：是否时常觉得生活没有意思？");
               }
               if(sum1+sum2+sum3<=6&&count==5){
                   String myString = String.valueOf(sum1+sum2+sum3);
                   tvsum.setText(myString);
                   Intent intent1 = new Intent(mental.this, result.class);
                   startActivity(intent1);
                   count=0;sum1=0;sum2=0;sum3=0;
               }
                if(count==5&&6<sum1+sum2+sum3&&sum1+sum2+sum3<=10){
                    String myString = String.valueOf(sum1 + sum2 + sum3);
                    tvsum.setText(myString);
                    Intent intent2 = new Intent(mental.this, result2.class);
                    startActivity(intent2);
                    count = 0;sum1 = 0;sum2 = 0;sum3 = 0;
                }
                if(sum1+sum2+sum3>10&count==5){
                    String myString = String.valueOf(sum1+sum2+sum3);
                    tvsum.setText(myString);
                    Intent intent3 = new Intent(mental.this,result3.class);
                    startActivity(intent3);
                    count=0;sum1=0;sum2=0;sum3=0;
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                sum2+=2;
                if (count==1){
                    tv.setText("问题二：是否经常焦虑未发生的事情？");
                }
                if(count==2){
                    tv.setText("问题三：是否做事情时无法集中精力？");
                }
                if(count==3){
                    tv.setText("问题四：是否突然感到一阵心慌和害怕");
                }
                if(count==4){
                    tv.setText("问题五：是否时常觉得生活没有意思？");
                }
                if(sum1+sum2+sum3<=6&&count==5){
                    String myString = String.valueOf(sum1+sum2+sum3);
                    tvsum.setText(myString);
                    Intent intent1 = new Intent(mental.this, result.class);
                    startActivity(intent1);
                    count=0;sum1=0;sum2=0;sum3=0;
                }
                if(count==5&&6<sum1+sum2+sum3&&sum1+sum2+sum3<=10){
                    String myString = String.valueOf(sum1 + sum2 + sum3);
                    tvsum.setText(myString);
                    Intent intent2 = new Intent(mental.this, result2.class);
                    startActivity(intent2);
                    count = 0;sum1 = 0;sum2 = 0;sum3 = 0;
                }
                if(sum1+sum2+sum3>10&count==5){
                    String myString = String.valueOf(sum1+sum2+sum3);
                    tvsum.setText(myString);
                    Intent intent3 = new Intent(mental.this,result3.class);
                    startActivity(intent3);
                    count=0;sum1=0;sum2=0;sum3=0;
                }
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                sum3+=3;
                if (count==1){
                    tv.setText("问题二：是否经常焦虑未发生的事情？");
                }
                if(count==2){
                    tv.setText("问题三：是否做事情时无法集中精力？");
                }
                if(count==3){
                    tv.setText("问题四：是否突然感到一阵心慌和害怕");
                }
                if(count==4){
                    tv.setText("问题五：是否时常觉得生活没有意思？");
                }
                if(sum1+sum2+sum3<=6&&count==5){
                    String myString = String.valueOf(sum1+sum2+sum3);
                    tvsum.setText(myString);
                    Intent intent1 = new Intent(mental.this, result.class);
                    startActivity(intent1);
                    count=0;sum1=0;sum2=0;sum3=0;
                }
                if(count==5&&6<sum1+sum2+sum3&&sum1+sum2+sum3<=10){
                    String myString = String.valueOf(sum1 + sum2 + sum3);
                    tvsum.setText(myString);
                    Intent intent2 = new Intent(mental.this, result2.class);
                    startActivity(intent2);
                    count = 0;sum1 = 0;sum2 = 0;sum3 = 0;
                }
                if(sum1+sum2+sum3>10&&count==5){
                    String myString = String.valueOf(sum1+sum2+sum3);
                    tvsum.setText(myString);
                    Intent intent3 = new Intent(mental.this,result3.class);
                    startActivity(intent3);
                    count=0;sum1=0;sum2=0;sum3=0;
                }
            }
        });
    }
}