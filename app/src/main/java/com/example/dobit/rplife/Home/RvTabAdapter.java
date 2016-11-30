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
 * Created by Basilan on 11/30/2016.
 */

public class RvTabAdapter extends RecyclerView.Adapter<RvTabAdapter.MyTabViewHolder>{
    int[] check = new int[20];
    int temp;
    Context context;
    ArrayList<TabContents> data;
    LayoutInflater inflater;
    ImageView sidebar;

    public RvTabAdapter(Context context, ArrayList<TabContents> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyTabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tab_layout, parent, false);
        MyTabViewHolder holder = new MyTabViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyTabViewHolder holder, int position) {
        holder.something.setText(data.get(position).text);
        holder.minutesOrHours.setText(data.get(position).minutesOrHours);
        holder.every.setText(data.get(position).every);
        holder.startTime.setText(data.get(position).startTime);
        holder.endTime.setText(data.get(position).endTime);
        holder.task.setText(data.get(position).task);
        holder.difficulty.setImageResource(data.get(position).difficulty);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyTabViewHolder extends RecyclerView.ViewHolder {

        TextView something;
        TextView minutesOrHours;
        TextView every;
        TextView startTime;
        TextView endTime;
        TextView task;
        ImageView difficulty;
        ImageView stamina;
        ImageView sidebar;
        ImageView sidebar2;
//        ImageView image;

        public MyTabViewHolder(View itemView) {
            super(itemView);

            sidebar = (ImageView) itemView.findViewById(R.id.iv2);
            sidebar2 = (ImageView) itemView.findViewById(R.id.iv2);
            something = (TextView) itemView.findViewById(R.id.tv1);
            minutesOrHours = (TextView) itemView.findViewById(R.id.tvMinutesOrHours);
            every = (TextView) itemView.findViewById(R.id.tvDueDate);
            startTime = (TextView) itemView.findViewById(R.id.tvStartTime);
            endTime = (TextView) itemView.findViewById(R.id.tvStopTime);
            task = (TextView) itemView.findViewById(R.id.tvTask);
            difficulty = (ImageView) itemView.findViewById(R.id.ivDifficulty);
            stamina = (ImageView) itemView.findViewById(R.id.ivStamina);
//            image = (ImageView) itemView.findViewById(R.id.iv1);
        }
    }
}