package com.example.dobit.rplife.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.dobit.rplife.R;

import java.util.ArrayList;

public class AddTask extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    TextView min;
    EditText title;
    EditText description;
    EditText dueDate;
    EditText timeStart;
    EditText timeEnd;
    ImageView add;
    ImageView cancel;
    SeekBar seekBar;
    ArrayList<Contents2> contents2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_task);
        add = (ImageView) findViewById(R.id.ivAddNewTask);
        add.setOnClickListener(this);
        cancel = (ImageView) findViewById(R.id.ivCancel);
        cancel.setOnClickListener(this);
        seekBar = (SeekBar) findViewById(R.id.seeker);
        seekBar.setOnSeekBarChangeListener(this);
        min = (TextView) findViewById(R.id.tvMin);
        title = (EditText) findViewById(R.id.etTitle);
        description = (EditText) findViewById(R.id.etDesc);
        dueDate = (EditText) findViewById(R.id.etDueDate);
        timeStart = (EditText) findViewById(R.id.etTimeStart);
        timeEnd = (EditText) findViewById(R.id.etTimeEnd);
        contents2 = new ArrayList<>();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        min.setText("" + seekBar.getProgress());
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivAddNewTask:
                String sTitle;
                String sDueDate;
                String sTimeStart;
                String sTimeEnd;

                sDueDate = dueDate.getText().toString();
                sTimeStart = timeStart.getText().toString();
                sTimeEnd = timeEnd.getText().toString();
                sTitle = title.getText().toString();

                Contents2 contents2 = new Contents2();
                contents2.setText("20");
                contents2.setMinutesOrHours("minutes");
                contents2.setDueDate(sDueDate);
                contents2.setStartTime(sTimeStart);
                contents2.setEndTime(sTimeEnd);
                contents2.setTask(sTitle);
                contents2.setSidebar(R.drawable.green_card_sidebar);
                contents2.setSidebar2(R.drawable.orange_sidebar);
                contents2.setDifficulty(R.drawable.green_difficulty_bar);
                contents2.setStamina(R.drawable.staminabar1);
                Intent intent = new Intent(this, ReplicaMain.class);
                intent.putExtra("myData", contents2);
                startActivity(intent);
        }
    }
}
