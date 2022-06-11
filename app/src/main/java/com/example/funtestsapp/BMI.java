package com.example.funtestsapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;

public class BMI extends Activity {
    Button button;
    EditText height;
    EditText weight;
    RadioButton boy;
    RadioButton girl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        boy = (RadioButton) findViewById(R.id.btnMan);
        girl = (RadioButton) findViewById(R.id.btnWoman);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new mclick());
    }
    class mclick implements View.OnClickListener {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View view) {
            String h = height.getText().toString();
            String w = weight.getText().toString();
            String msg = "";
            String bmi = "";
            double res = 0, heightNum = 0, weightNum = 0;
            if (!h.isEmpty() && !w.isEmpty()) {
                heightNum = Double.parseDouble(h);  // 强制类型转换，把括号里的类型变成double
                weightNum = Double.parseDouble(w);
                res = 10000 * weightNum / (heightNum * heightNum);
                DecimalFormat df = new DecimalFormat("#.00");
                bmi = df.format(res);
                System.out.println(bmi);
            }
            Log.i("bmi",bmi);
            msg="你的BMI值是".toString();
            if (boy.isChecked()) {
                if (res>35){
                    msg+=bmi+"\n"+"先生，您的体脂过高，体型属于重度肥胖。".toString();
                }else if (res>30){
                    msg+=bmi+"\n"+"先生，您的体脂偏高，体型属于肥胖。".toString();
                }else if (res>25){
                    msg+=bmi+"\n"+"先生，您的体脂有些偏高，体型属于超重".toString();
                }else if (res>20){
                    msg+=bmi+"\n"+"先生，您的体脂正常，体型属于适中。".toString();
                }else{
                    msg+=bmi+"\n"+"先生，您的体脂过低，体型属于偏瘦。".toString();
                }
            }

            if (girl.isChecked()) {
                if (res>34){
                    msg+=bmi+"\n"+"女士，您的体脂过高，体型属于重度肥胖。".toString();
                }else if (res>29){
                    msg+=bmi+"\n"+"女士，您的体脂偏高，体型属于肥胖。".toString();
                }else if (res>24){
                    msg+=bmi+"\n"+"女士，您的体脂有些偏高，体型属于超重。".toString();
                }else if (res>19){
                    msg+=bmi+"\n"+"女士，您的体脂正常，体型属于适中。".toString();
                }else{
                    msg+=bmi+"\n"+"女士，您的体脂过低，体型属于偏瘦。".toString();
                }
            }
            System.out.println(msg);
            Intent intent=new Intent(BMI.this,BMIresult.class);
            Bundle bundle=new Bundle();
            bundle.putString("msg",msg);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}