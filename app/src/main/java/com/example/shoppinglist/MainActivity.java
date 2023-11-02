package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if(btnAbout == view){
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }

    }
}