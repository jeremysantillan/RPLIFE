package com.example.dobit.rplife.Home;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dobit.rplife.FocusActivity;
import com.example.dobit.rplife.R;

import java.util.ArrayList;

/**
 * Created by Basilan on 11/30/2016.
 */

public class RvAdapter2 extends RecyclerView.Adapter<RvAdapter2.MyViewHolder2> {
    int[] check = new int[20];
    int temp;
    Context context;
    ArrayList<Contents2> data;
    LayoutInflater inflater;
//    ImageView sidebar;

    public RvAdapter2(Context context, ArrayList<Contents2> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.temp, parent, false);

        MyViewHolder2 holder = new MyViewHolder2(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder2 myViewHolder2, final int position) {

        myViewHolder2.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check[temp] == 1){
                    myViewHolder2.sidebar.setImageResource(data.get(position).sidebar2);
//                   myViewHolder2.sidebar.setImageDrawable(R.drawable.orange_sidebar);

                }
                check[position] = 1;
                temp = position;
                Log.d("Gwapo3", temp+"");
                myViewHolder2.sidebar.setImageResource(data.get(position).sidebar);
                final Dialog dialog = new Dialog(context,R.style.Theme_D1NoTitleDim);
                dialog.setContentView(R.layout.activity_main);
                Button buttonStart = (Button) dialog.findViewById(R.id.startTimer);
                Button buttonCancel = (Button) dialog.findViewById(R.id.cancelTimer);
                dialog.show();

            }
        });

        myViewHolder2.something.setText(data.get(position).text);
        myViewHolder2.minutesOrHours.setText(data.get(position).minutesOrHours);
        myViewHolder2.dueDate.setText(data.get(position).dueDate);
        myViewHolder2.startTime.setText(data.get(position).startTime);
        myViewHolder2.endTime.setText(data.get(position).endTime);
        myViewHolder2.task.setText(data.get(position).task);
        myViewHolder2.difficulty.setImageResource(data.get(position).difficulty);
//        myViewHolder2.stamina.setImageResource(data.get(position).stamina);
//        myViewHolder2.image.setImageResource(data.get(position).image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {

        TextView something;
        TextView minutesOrHours;
        TextView dueDate;
        TextView startTime;
        TextView endTime;
        TextView task;
        ImageView difficulty;
        ImageView stamina;
        ImageView sidebar;
        ImageView sidebar2;
//        ImageView image;

        public MyViewHolder2(View itemView) {
            super(itemView);
            sidebar = (ImageView) itemView.findViewById(R.id.iv2);
//            sidebar2 = (ImageView) itemView.findViewById(R.id.ivSide);
            something = (TextView) itemView.findViewById(R.id.tv1);
            minutesOrHours = (TextView) itemView.findViewById(R.id.tvMinutesOrHours);
            dueDate = (TextView) itemView.findViewById(R.id.tvDueDate);
            startTime = (TextView) itemView.findViewById(R.id.tvStartTime);
            endTime = (TextView) itemView.findViewById(R.id.tvStopTime);
            task = (TextView) itemView.findViewById(R.id.tvTask);
            difficulty = (ImageView) itemView.findViewById(R.id.ivDifficulty);
            stamina = (ImageView) itemView.findViewById(R.id.ivStamina);
//            image = (ImageView) itemView.findViewById(R.id.iv1);
        }
    }


}
