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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton fab;
    CardView cv;
    RecyclerView recyclerView;
    //    RvAdapter adapter;
    RvAdapter2 adapter2;
    RvTabAdapter tabAdapter;
    ImageView tab;
    ImageView sidebar;
    ImageView header;
    MediaPlayer addTaskSound;
//    ArrayAdapter<Contents2> mAdapter;

    int check = 0;

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

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
//        cv = (CardView) findViewById(R.id.cv);
//        cv.setOnClickListener(this);
        tab = (ImageView) findViewById(R.id.ivTodo);
        tab.setOnClickListener(this);
        sidebar = (ImageView) findViewById(R.id.iv2);
        header = (ImageView) findViewById(R.id.ivHeader);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        adapter2 = new RvAdapter2(this, Data2.getData2());
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
//                Dialog dialog = new Dialog(MainActivity.this);
//                dialog.setTitle("Dialog");
//                dialog.setContentView(R.layout.activity_add_task);
//                dialog.show();
                addTaskSound.start();
                Intent intent = new Intent(MainActivity.this, AddTask.class);
                startActivity(intent);
                finish();
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