package com.example.dobit.rplife.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dobit.rplife.R;

public class HubChatActivity extends AppCompatActivity implements View.OnClickListener {

    Button quest;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        listView = (ListView) findViewById(R.id.lvChat);

    }

    @Override
    public void onClick(View view) {

    }
}
