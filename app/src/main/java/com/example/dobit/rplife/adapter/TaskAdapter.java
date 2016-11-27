package com.example.dobit.rplife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.dobit.rplife.R;
import com.example.dobit.rplife.model.Task;

import java.util.List;

/**
 * Created by Basilan on 11/27/2016.
 */

public class TaskAdapter extends ArrayAdapter<Task> {
    private List<Task> mTaskList;
    private Context mContext;
    private int mResource;

    public TaskAdapter(Context context, int resource,
                       List<Task> taskList) {
        super(context, resource, taskList);
        mContext = context;
        mResource = resource;
        mTaskList = taskList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(mResource,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

            holder.checktask.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v ;
                    Task tsk = (Task) cb.getTag();

                }
            });
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        Task t = mTaskList.get(position);
        if(t != null){
            if(holder.tvTask != null){
                holder.tvTask.setText(t.getTaskName());
            }
        }
        return convertView;
    }

    private static class ViewHolder{
        TextView tvTask;
        CheckBox checktask;

        public ViewHolder(View view){
            tvTask = (TextView)view.findViewById(R.id.tvTask);
            checktask = (CheckBox)view.findViewById(R.id.chbxTask);
        }
    }


}