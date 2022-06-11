package com.example.funtestsapp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button part1 = (Button)findViewById(R.id.part1);
        Button part3 = (Button)findViewById(R.id.part3);
        Button part4 = (Button)findViewById(R.id.part4);
        Button part2 = (Button)findViewById(R.id.part2);
        Button part5 = (Button)findViewById(R.id.part5);
        part1.setOnCreateContextMenuListener(this);

        part5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menu.this,Tarot.class);
                startActivity(intent);
            }
        });

        part4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(menu.this,BMI.class);
                startActivity(intent);
            }
        });

        part3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this,login.class);
                startActivity(intent);
            }
        });

        part2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(menu.this,mental.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(0,1,0,"体脂测试");
        menu.add(0,2,0,"心理测试");
        menu.add(0,3,0,"塔罗牌测试");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 1:
                Intent intent_b = new Intent(menu.this,BMI.class);
                startActivity(intent_b);
                break;
            case 2:
                Intent intent_m= new Intent(menu.this,mental.class);
                startActivity(intent_m);
                break;
            case 3:
                Intent intent_t = new Intent(menu.this,Tarot.class);
                startActivity(intent_t);
                //Toast.makeText(this,"塔罗牌测试在按键下方",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

}