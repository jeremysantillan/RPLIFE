package com.example.dobit.rplife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class InitializationActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton erudite;
    ImageButton elima;
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_initialization);
        erudite = (ImageButton) findViewById(R.id.btnErudite);
        elima = (ImageButton) findViewById(R.id.btnElima);
        next = (Button) findViewById(R.id.btnNext);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnNext:
                nextActivity();
                break;
        }
    }

    private void nextActivity(){
        Intent intent = new Intent(InitializationActivity.this, HomePageActivity.class);
        startActivity(intent);
    }
}
