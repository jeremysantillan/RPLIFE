package com.example.dobit.rplife.Home;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.dobit.rplife.R;

import java.util.ArrayList;

public class ReplicaMain extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton fab;
    CardView cv;
    RecyclerView recyclerView;
    //    RvAdapter adapter;
    RvAdapter2 adapter2;
    RvTabAdapter tabAdapter;
    ImageView tab;
    ImageView sidebar;
    ImageView header;
    Contents2 stored;
    MediaPlayer addTaskSound;
//    ArrayAdapter<Contents2> mAdapter;

    int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        stored = getIntent().getParcelableExtra("myData");
//
//        Log.d("Testing1", stored.getText());
//        Log.d("Testing2", stored.getDueDate());
//        Log.d("Testing3", stored.getStartTime());

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
//        cv = (CardView) findViewById(R.id.cv);
//        cv.setOnClickListener(this);
        tab = (ImageView) findViewById(R.id.ivTodo);
        tab.setOnClickListener(this);
        sidebar = (ImageView) findViewById(R.id.iv2);
        header = (ImageView) findViewById(R.id.ivHeader);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        adapter2 = new RvAdapter2(this, this.getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tabAdapter = new RvTabAdapter(this, TabData.getTabData());
//        adapter2.notifyDataSetChanged();
        recyclerView.setAdapter(adapter2);
        //addTaskSound = MediaPlayer.create(this, R.raw.link_start);



//        recyclerView = (RecyclerView) findViewById(R.id.rv);
//        adapter = new RvAdapter(this, Data.getData());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public ArrayList<Contents2> getData(){
        ArrayList<Contents2> contents2 = new ArrayList<>();
        Contents2 current = new Contents2();
        String[] text = {"30", "40", "60"};
        String[] mOrH = {"minutes", "minutes", "minutes"};
        String[] dueDate = {"12/15/16", "12/16/16", "12/18/16"};
        String[] startTime = {"1:00 PM", "2:00 PM", "5:00 PM"};
        String[] endTime = {"1:30 PM", "2:40 PM", "6:00 PM"};
        String[] task = {"Eat pizza", "Buy present", "Meet with group"};
        int[] sidebar = {R.drawable.orange_sidebar, R.drawable.orange_sidebar, R.drawable.orange_sidebar};
        int[] sidebar2 = {R.drawable.green_card_sidebar, R.drawable.green_card_sidebar, R.drawable.green_card_sidebar};
        int[] difficulty = {R.drawable.green_difficulty_bar, R.drawable.yellow_difficulty_bar, R.drawable.red_difficulty_bar};
        int[] stamina = {R.drawable.staminabar3, R.drawable.staminabar2, R.drawable.staminabar1};



        for (int i = 0; i < 3; i++)
        {
            current = new Contents2();
            current.sidebar2 = sidebar2[i];
            current.sidebar = sidebar[i];
            current.text = text[i];
            current.minutesOrHours = mOrH[i];
            current.dueDate = dueDate[i];
            current.startTime = startTime[i];
            current.endTime = endTime[i];
            current.difficulty = difficulty[i];
            current.stamina = stamina[i];
            current.task = task[i];
            contents2.add(current);
        }

        current = new Contents2();
        current.text = stored.getText();
        current.sidebar = stored.getSidebar();
        current.sidebar2 = stored.getSidebar2();
        current.startTime = stored.getStartTime();
        current.endTime = stored.getEndTime();
        current.dueDate = stored.getDueDate();
        current.difficulty = stored.getDifficulty();
        current.stamina = stored.getStamina();
        current.task = stored.getTask();
        current.minutesOrHours = stored.getMinutesOrHours();
        contents2.add(current);
        return contents2;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivTodo:
                changeTab();
                changeHeader();
                changeCards();
//                tab.setImageDrawable(getResources().getDrawable(R.drawable.habits_highlight));
                break;

            case R.id.fab:
                //addTaskSound.start();
                Intent intent = new Intent(ReplicaMain.this, AddTask.class);
                startActivity(intent);
                break;
//            case  R.id.cv:
//                sidebar.setImageDrawable(getResources().getDrawable(R.drawable.orange_sidebar));
        }
    }

    public void changeHeader(){
        if(check == 1){
            header.setImageDrawable(getResources().getDrawable(R.drawable.habits_header_stuff));
        }
        else {
            header.setImageDrawable(getResources().getDrawable(R.drawable.header_stuff));
        }
    }

    public void changeTab(){
        if(check == 1){
            tab.setImageDrawable(getResources().getDrawable(R.drawable.todolist_highlight));
            check = 0;
        }
        else{
            tab.setImageDrawable(getResources().getDrawable(R.drawable.habits_highlight));
            check = 1;
        }
    }

    public void changeCards(){
        if(check == 1){
            recyclerView.setAdapter(tabAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        else{
            recyclerView.setAdapter(adapter2);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

//    @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        int action = motionEvent.getActionMasked();
//
//
//        switch (action){
//            case MotionEvent.ACTION_DOWN:
//                initialX = motionEvent.getX();
//                initialY = motionEvent.getY();
//                break;
//
//            case MotionEvent.ACTION_UP:
//                float finalX = motionEvent.getX();
//                float finalY = motionEvent.getY();
//
//                if(initialX > finalX){
//                    tab.setImageDrawable(getResources().getDrawable(R.drawable.habits_highlight));
//                }
//
//                else if (initialX < finalX){
//                    tab.setImageDrawable(getResources().getDrawable(R.drawable.todolist_highlight));
//                }
//        }
//        return super.onTouchEvent(motionEvent);
//    }
}
