package com.example.dobit.rplife.Home;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dobit.rplife.HomePageActivity;
import com.example.dobit.rplife.R;

public class QuestActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    ChatAdapter chatAdapter;
    ChatTempAdapter tempAdapter;
    QuestAdapter2 questAdapter;
    GuildAdapter guildAdapter;
    ImageView footer;
    TextView tvGuild;
    TextView tvChat;
    TextView tvQuests;
    CardView cardView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quest);
        cardView = (CardView) findViewById(R.id.cvQuest);
        footer = (ImageView) findViewById(R.id.ivFooter);

        tvQuests = (TextView) findViewById(R.id.tvQuests);
        tvGuild = (TextView) findViewById(R.id.tvGuild);
        tvGuild.setOnClickListener(this);
        tvChat = (TextView) findViewById(R.id.tvChat);
        chatAdapter = new ChatAdapter(this, ChatData.getChatData());
        tempAdapter = new ChatTempAdapter(this, ChatData.getChatData());
        questAdapter = new QuestAdapter2(this, QuestData.getQuestData());
        guildAdapter = new GuildAdapter(this, GuildData.getGuildData());
        recyclerView = (RecyclerView) findViewById(R.id.rvQuest);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(questAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvGuild:
                tvGuild.setTextColor(Color.parseColor("#F96908"));
                tvQuests.setTextColor(Color.parseColor("#FFFFFF"));
                tvChat.setTextColor(Color.parseColor("#FFFFFF"));
                recyclerView.setAdapter(guildAdapter);
                footer.setImageDrawable(getResources().getDrawable(R.drawable.hub_footer));
                recyclerView.setBackgroundResource(R.color.RPLIFE_TXT_COLOR);
                break;

            case R.id.tvQuests:
                tvGuild.setTextColor(Color.parseColor("#FFFFFF"));
                tvChat.setTextColor(Color.parseColor("#FFFFFF"));
                tvQuests.setTextColor(Color.parseColor("#F96908"));
                recyclerView.setAdapter(questAdapter);
                footer.setImageDrawable(getResources().getDrawable(R.drawable.hub_footer));
                recyclerView.setBackgroundResource(R.color.RPLIFE_TXT_COLOR);
                break;

            case R.id.tvChat:
                tvGuild.setTextColor(Color.parseColor("#FFFFFF"));
                tvQuests.setTextColor(Color.parseColor("#FFFFFF"));
                tvChat.setTextColor(Color.parseColor("#F96908"));
                recyclerView.setAdapter(tempAdapter);
                recyclerView.setBackgroundResource(R.drawable.background);
                footer.setImageDrawable(getResources().getDrawable(R.drawable.chat_footer));

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(QuestActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
