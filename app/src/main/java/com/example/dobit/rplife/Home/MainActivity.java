package com.example.dobit.rplife.Home;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.dobit.rplife.BossFight;
import com.example.dobit.rplife.ProfileActvity;
import com.example.dobit.rplife.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{

    FloatingActionButton fab;
    CardView cv;
    RecyclerView recyclerView;
    //    RvAdapter adapter;
    RvAdapter2 adapter2;
    RvTabAdapter tabAdapter;
    ImageView hub;
    ImageView tab;
    ImageView sidebar;
    ImageView header;
    MediaPlayer addTaskSound;
    TextView min;
    EditText title;
    EditText description;
    EditText dueDate;
    EditText timeStart;
    EditText timeEnd;
    ImageView add;
    ImageView cancel;
    SeekBar seekBar;
    String sTitle;
    String sDueDate;
    String sTimeStart;
    String sTimeEnd;
    Dialog dialog;
    ArrayList<Contents2> contents2 = new ArrayList<>();
    MediaPlayer bossFightSound;
    ImageView mImgvProfilePic;
//    ArrayAdapter<Contents2> mAdapter;
    ImageView btnPartyView;

    int check = 0;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
//        Contents2 stored = getIntent().getParcelableExtra("myData");
//
//        Log.d("Testing1", stored.getText());
//        Log.d("Testing2", stored.getDueDate());
//        Log.d("Testing3", stored.getStartTime());
        hub = (ImageView) findViewById(R.id.ivHub);
        hub.setOnClickListener(this);
        bossFightSound = MediaPlayer.create(this, R.raw.defend);
        mImgvProfilePic = (ImageView)findViewById(R.id.ivCharacterFace);
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
        flag = 1;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tabAdapter = new RvTabAdapter(this, TabData.getTabData());
        adapter2.notifyDataSetChanged();
        recyclerView.setAdapter(adapter2);
        addTaskSound = MediaPlayer.create(this, R.raw.whatcha);

        btnPartyView = (ImageView) findViewById(R.id.btn_partyview);
        btnPartyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bossFightSound.start();
                Intent intent = new Intent(MainActivity.this, BossFight.class);
                startActivity(intent);
            }
        });

        //profile page
        mImgvProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActvity.class);
                startActivity(intent);
            }
        });

//        recyclerView = (RecyclerView) findViewById(R.id.rv);
//        adapter = new RvAdapter(this, Data.getData());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
                addTaskSound.start();
                dialog = new Dialog(MainActivity.this,R.style.Theme_D1NoTitleDim);
                dialog.setContentView(R.layout.activity_add_task);
               // dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                add = (ImageView) dialog.findViewById(R.id.ivAddNewTask);
                add.isClickable();
                add.setOnClickListener(this);
                cancel = (ImageView) dialog.findViewById(R.id.ivCancel);
                cancel.setOnClickListener(this);
                seekBar = (SeekBar) dialog.findViewById(R.id.seeker);
                seekBar.setOnSeekBarChangeListener(this);
                min = (TextView) dialog.findViewById(R.id.tvMin);
                title = (EditText) dialog.findViewById(R.id.etTitle);
                description = (EditText) dialog.findViewById(R.id.etDesc);
                dueDate = (EditText) dialog.findViewById(R.id.etDueDate);
                timeStart = (EditText) dialog.findViewById(R.id.etTimeStart);
                timeEnd = (EditText) dialog.findViewById(R.id.etTimeEnd);

                dialog.show();
               // addTaskSound.start();
//                Intent intent = new Intent(HomePageActivity.this, AddTask.class);
//                startActivity(intent);
                break;

            case R.id.ivAddNewTask:
                sDueDate = dueDate.getText().toString();
                sTimeStart = timeStart.getText().toString();
                sTimeEnd = timeEnd.getText().toString();
                sTitle = title.getText().toString();
                adapter2 = new RvAdapter2(this, this.getData());
                recyclerView.setAdapter(adapter2);
                adapter2.notifyDataSetChanged();
                dialog.dismiss();
                break;

            case  R.id.ivHub:
                Intent intent = new Intent(MainActivity.this, QuestActivity.class);
                startActivity(intent);
        }
    }

    public ArrayList<Contents2> getData(){

        Contents2 current;

        if(flag == 0) {
            String[] text = {"30", "40", "60"};
            String[] mOrH = {"minutes", "minutes", "minutes"};
            String[] dueDate = {"12/15/16", "12/16/16", "12/18/16"};
            String[] startTime = {"1:00 PM", "2:00 PM", "5:00 PM"};
            String[] endTime = {"1:30 PM", "2:40 PM", "6:00 PM"};
            String[] task = {"Eat pizza", "Buy present", "Meet group"};
            int[] sidebar = {R.drawable.orange_sidebar, R.drawable.orange_sidebar, R.drawable.orange_sidebar};
            int[] sidebar2 = {R.drawable.green_card_sidebar, R.drawable.green_card_sidebar, R.drawable.green_card_sidebar};
            int[] difficulty = {R.drawable.green_difficulty_bar, R.drawable.yellow_difficulty_bar, R.drawable.red_difficulty_bar};
            int[] stamina = {R.drawable.staminabar3, R.drawable.staminabar2, R.drawable.staminabar1};


            for (int i = 0; i < 3; i++) {
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
        }

        else {
            current = new Contents2();
            current.text = "30";
            current.sidebar = R.drawable.green_card_sidebar;
            current.sidebar2 = R.drawable.orange_sidebar;
            current.startTime = sTimeStart;
            current.endTime = sTimeEnd;
            current.dueDate = sDueDate;
            current.difficulty = R.drawable.red_difficulty_bar;
            current.stamina = R.drawable.staminabar3;
            current.task = sTitle;
            current.minutesOrHours = "minutes";
            contents2.add(current);
        }
        return contents2;
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