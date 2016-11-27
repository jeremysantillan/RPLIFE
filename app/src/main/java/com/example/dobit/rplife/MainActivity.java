package com.example.dobit.rplife;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dobit.rplife.adapter.TaskAdapter;
import com.example.dobit.rplife.controller.TaskController;
import com.example.dobit.rplife.widget.CircleCountDownView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText etTime;
    protected CircleCountDownView countDownView;
    protected Button startTimerBt, cancelTimerBt;
    private TextView mTvMinutes;
    private TextView mTvSeconds;
    private TextView mTvTimer;
    int progress;
    int endTime;
    CountDownTimer countDownTimer;

    int count = 0;
    int seconds =59;
    int minutes;
    int hours=0;
    int time;

    Thread t;
    boolean stop = false;
    private volatile boolean isRunning = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // etTime = (EditText) findViewById(R.id.et_total_time);
        countDownView = (CircleCountDownView) findViewById(R.id.circle_count_down_view);
        startTimerBt = (Button) findViewById(R.id.startTimer);
        cancelTimerBt = (Button) findViewById(R.id.cancleTimer);
        mTvMinutes = (TextView) findViewById(R.id.tvMinutes);
        mTvSeconds = (TextView) findViewById(R.id.tvSec);

        // set click listeners
        startTimerBt.setOnClickListener(this);
        cancelTimerBt.setOnClickListener(this);

        ListView listView = (ListView) findViewById(R.id.listView);
        TaskController controller = new TaskController();
        TaskAdapter adapter = new TaskAdapter(this, R.layout.layout_listview_task,
                controller.getTask());
        listView.setAdapter(adapter);
    }

    protected void startCountDown(final View view) {

        //String timeInterval = etTime.getText().toString();



        //etTime.getText().clear();
        view.setVisibility(View.GONE); // hide button
        countDownView.setVisibility(View.VISIBLE); // show progress view
        cancelTimerBt.setVisibility(View.VISIBLE); // show cancel button

        progress = 1;
        endTime = 25; // up to finish time
        minutes = endTime-1;
        time= endTime*60;

        countDownTimer = new CountDownTimer(time * 1000 /*finishTime**/, 1000 /*interval**/) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDownView.setProgress(progress, time );
                progress = progress + 1;

                if(seconds >= 0)
                {

                    mTvMinutes.setText(minutes+"");
                    if(seconds <10){
                        mTvSeconds.setText("0"+seconds);
                        seconds--;
                        count++;
                    }else{
                        mTvSeconds.setText(seconds+"");
                        seconds--;
                        count++;
                    }

                }

                if(count == 60 && minutes != 0)
                {
                    minutes--;
                    count = 0;
                    mTvMinutes.setText(minutes+"");
                    seconds = 59;
                }

            }

            @Override
            public void onFinish() {
                countDownView.setProgress(progress, time);
                view.setVisibility(View.VISIBLE);
                cancelTimerBt.setVisibility(View.GONE);
                minutes=0;
                seconds=59;
            }
        };
        countDownTimer.start(); // start timer

        // hide softkeyboard
        View currentFocus = this.getCurrentFocus();
        if (currentFocus != null) {
            InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

//    protected void start(final View view){
//
//        view.setVisibility(View.GONE); // hide button
//        countDownView.setVisibility(View.VISIBLE); // show progress view
//        cancelTimerBt.setVisibility(View.VISIBLE); // show cancel button
//
//        progress = 1;
//        endTime = 25; // up to finish time
//        minutes = endTime-1;
//        time= endTime*60;
//        countDownTimer = new CountDownTimer(time * 1000 /*finishTime**/, 1000 /*interval**/) {
//
//
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//                countDownView.setProgress(progress, time);
//                progress = progress + 1;
//
//
//            }
//
//
//            @Override
//            public void onFinish() {
//                countDownView.setProgress(progress, time);
//                view.setVisibility(View.VISIBLE);
//                cancelTimerBt.setVisibility(View.GONE);
//                minutes=0;
//                seconds=59;
//            }
//        };
//        countDownTimer.start(); // start timer
//
//        // hide softkeyboard
//        View currentFocus = this.getCurrentFocus();
//        if (currentFocus != null) {
//            InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
//        }
//    }


    public void stopCountDown(View view) {

        countDownView.setProgress(time,time);
        countDownTimer.cancel();
        seconds=59;
        countDownView.setVisibility(View.INVISIBLE);
        cancelTimerBt.setVisibility(View.GONE);
        startTimerBt.setVisibility(View.VISIBLE);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startTimer:
                startCountDown(view);
                break;
            case R.id.cancleTimer:
                stopCountDown(view);
                break;
        }
    }





}
