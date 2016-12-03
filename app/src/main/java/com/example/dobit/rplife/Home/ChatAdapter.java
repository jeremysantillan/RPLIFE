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

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    public static int ITEM_TYPE_LEFT = 0;
    public static int ITEM_TYPE_RIGHT = 1;

    Context context;
    ArrayList<ChatModel> data;
    LayoutInflater inflater;

    public ChatAdapter(Context context, ArrayList<ChatModel> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }



    @Override
    public int getItemViewType(int position) {
        if(position == 1){
            return ITEM_TYPE_RIGHT;
        }
        else
            return ITEM_TYPE_LEFT;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View leftView = inflater.inflate(R.layout.chat_row, parent, false);
            ChatViewHolder holder = new ChatViewHolder(leftView);
            return holder;
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        holder.face.setImageResource(data.get(position).image);
        holder.message.setText(data.get(position).message);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class  ChatViewHolder extends RecyclerView.ViewHolder{

        ImageView face;
        TextView message;

        public ChatViewHolder(View itemView) {
            super(itemView);

            face = (ImageView) itemView.findViewById(R.id.ivFace);
            message = (TextView) itemView.findViewById(R.id.tvMessages);
        }
    }

    class ChatRightHolder extends RecyclerView.ViewHolder{
        ImageView rightFace;
        TextView rightMessage;


        public ChatRightHolder(View itemView) {
            super(itemView);

            rightFace = (ImageView) itemView.findViewById(R.id.ivRightFace);
            rightMessage = (TextView) itemView.findViewById(R.id.tvRightChat);
        }
    }
}
