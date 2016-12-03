package com.example.dobit.rplife.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dobit.rplife.R;

import java.util.ArrayList;

/**
 * Created by dobit on 12/3/2016.
 */

public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.MyQuestHolder> {
    Context context;
    ArrayList<QuestModel> data;
    LayoutInflater inflater;

    public QuestAdapter(Context context, ArrayList<QuestModel> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyQuestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.quest_row, parent, false);
        MyQuestHolder holder = new MyQuestHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyQuestHolder holder, int position) {
        holder.questImage.setImageResource(data.get(position).imageQuest);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyQuestHolder extends RecyclerView.ViewHolder{
        ImageView questImage;

        public MyQuestHolder(View itemView) {
            super(itemView);
            questImage = (ImageView) itemView.findViewById(R.id.ivQuest);
        }
    }
}
