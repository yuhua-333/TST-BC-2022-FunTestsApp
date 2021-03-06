package com.example.funtestsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.funtestsapp.databinding.ActivitySqliteBinding;

public class SQLite extends Activity {

    private DBDefinitionManipulation dbOperation ;
    private EditText nameText;
    private EditText numText;
    private EditText idEntry;
    private TextView labelView;
    private TextView displayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        nameText = (EditText)findViewById(R.id.name);
        numText = (EditText)findViewById(R.id.num);
        idEntry = (EditText)findViewById(R.id.id_entry);

        labelView = (TextView)findViewById(R.id.label);
        displayView = (TextView)findViewById(R.id.display);

        Button ret = (Button) findViewById(R.id.button_return);

        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SQLite.this, menu.class);
                startActivity(intent);
            }
        });



        Button addButton = (Button)findViewById(R.id.add);
        Button queryAllButton = (Button)findViewById(R.id.query_all);
        Button clearButton = (Button)findViewById(R.id.clear);
        // Button deleteAllButton = (Button)findViewById(R.id.delete_all);

        Button queryButton = (Button)findViewById(R.id.query);
        Button deleteButton = (Button)findViewById(R.id.delete);
        Button updateButton = (Button)findViewById(R.id.update);


        addButton.setOnClickListener(addButtonListener);
        queryAllButton.setOnClickListener(queryAllButtonListener);
        clearButton.setOnClickListener(clearButtonListener);
        //deleteAllButton.setOnClickListener(deleteAllButtonListener);

        queryButton.setOnClickListener(queryButtonListener);
        deleteButton.setOnClickListener(deleteButtonListener);
        updateButton.setOnClickListener(updateButtonListener);

        dbOperation = new DBDefinitionManipulation(this);
        dbOperation.open();
    }

    View.OnClickListener addButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Topic topic = new Topic();
            topic.name = nameText.getText().toString();
            topic.num = numText.getText().toString();
            long colunm = dbOperation.insert(topic);
            if (colunm == -1 ){
                labelView.setText("?????????????????????");
            } else {
                labelView.setText("?????????????????????ID???"+String.valueOf(colunm));

            }
        }
    };

    View.OnClickListener queryAllButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Topic[] topics = dbOperation.queryAllData();
            if (topics == null){
                labelView.setText("?????????????????????");
                return;
            }
            labelView.setText("?????????");
            String msg = "";
            for (int i = 0 ; i<topics.length; i++){
                msg += topics[i].toString()+"\n";
            }
            displayView.setText(msg);
        }
    };

    View.OnClickListener clearButtonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            displayView.setText("");
        }
    };

    View.OnClickListener queryButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = Integer.parseInt(idEntry.getText().toString());
            Topic[] topics = dbOperation.queryOneData(id);

            if (topics == null){
                labelView.setText("???????????????ID???"+String.valueOf(id)+"?????????");
                return;
            }
            labelView.setText("?????????");
            displayView.setText(topics[0].toString());
        }
    };

    View.OnClickListener deleteButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            long id = Integer.parseInt(idEntry.getText().toString());
            long result = dbOperation.deleteOneData(id);
            String msg = "??????ID???"+idEntry.getText().toString()+"?????????" + (result>0?"??????":"??????");
            labelView.setText(msg);
        }
    };

    View.OnClickListener updateButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Topic topic = new Topic();
            topic.name = nameText.getText().toString();
            topic.num = numText.getText().toString();
            long id = Integer.parseInt(idEntry.getText().toString());
            long count = dbOperation.updateOneData(id, topic);
            if (count == -1 ){
                labelView.setText("???????????????");
            } else {
                labelView.setText("???????????????????????????"+String.valueOf(count)+"???");

            }
        }
    };
}