package com.example.dobit.rplife.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dobit.rplife.R;

import java.util.ArrayList;

/**
 * Created by dobit on 12/3/2016.
 */

public class QuestAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static int ITEM_TYPE_SMALL = 0;
    public static int ITEM_TYPE_LARGE = 1;

    Context context;
    ArrayList<QuestModel> data;
    LayoutInflater inflater;

    public QuestAdapter2(Context context, ArrayList<QuestModel> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 2 || position == 3){
            return ITEM_TYPE_LARGE;
        }
        else
            return ITEM_TYPE_SMALL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ITEM_TYPE_LARGE){
            View largeView = inflater.inflate(R.layout.quest_large_row, parent, false);
            QuestLargeHolder questLargeHolder = new QuestLargeHolder(largeView);
            return questLargeHolder;
        }
        else{
            View smallView = inflater.inflate(R.layout.quest_row, parent, false);
            QuestViewHolder questViewHolder = new QuestViewHolder(smallView);
            return questViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int itemType = getItemViewType(position);
        
        if(itemType == ITEM_TYPE_LARGE){
            ((QuestLargeHolder)holder).questLarge.setImageResource(data.get(position).imageQuest);
        }
        else
            ((QuestViewHolder)holder).quest.setImageResource(data.get(position).imageQuest);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class  QuestViewHolder extends RecyclerView.ViewHolder{

        ImageView quest;

        public QuestViewHolder(View itemView) {
            super(itemView);
            quest = (ImageView) itemView.findViewById(R.id.ivQuest);
        }
    }

    class QuestLargeHolder extends RecyclerView.ViewHolder{
        ImageView questLarge;
        
        public QuestLargeHolder(View itemView) {
            super(itemView);
            questLarge = (ImageView) itemView.findViewById(R.id.ivQuestLarge);
        }
    }
}
