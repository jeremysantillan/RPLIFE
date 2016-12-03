package com.example.dobit.rplife.Home;

/**
 * Created by dobit on 12/3/2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dobit.rplife.R;

import java.util.ArrayList;

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

public class ChatTempAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static int ITEM_TYPE_LEFT = 0;
    public static int ITEM_TYPE_RIGHT = 1;

    Context context;
    ArrayList<ChatModel> data;
    LayoutInflater inflater;

    public ChatTempAdapter(Context context, ArrayList<ChatModel> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }



    @Override
    public int getItemViewType(int position) {
        if(position == 1 || position == 4){
            return ITEM_TYPE_RIGHT;
        }
        else
            return ITEM_TYPE_LEFT;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ITEM_TYPE_LEFT){
            View leftView = inflater.inflate(R.layout.chat_row, parent, false);
            ChatViewHolder chatViewHolder  = new ChatViewHolder(leftView);
            return chatViewHolder;
        }
        else {
            View rightView = inflater.inflate(R.layout.chat_row_right, parent, false);
            ChatRightHolder chatRightHolder  = new ChatRightHolder(rightView);
            return chatRightHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int itemType = getItemViewType(position);

        if(itemType == ITEM_TYPE_LEFT){
            ((ChatViewHolder)holder).face.setImageResource(data.get(position).image);
            ((ChatViewHolder)holder).message.setText(data.get(position).message);
            ((ChatViewHolder)holder).chatBubbleLeft.setImageResource(data.get(position).imageBubble);
        }
        else{
            ((ChatRightHolder)holder).rightFace.setImageResource(data.get(position).image);
            ((ChatRightHolder)holder).rightMessage.setText(data.get(position).message);
            ((ChatRightHolder)holder).chatBubbleRight.setImageResource(data.get(position).imageBubble);
        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    class  ChatViewHolder extends RecyclerView.ViewHolder{

        ImageView face;
        ImageView chatBubbleLeft;
        TextView message;

        public ChatViewHolder(View itemView) {
            super(itemView);
            chatBubbleLeft = (ImageView) itemView.findViewById(R.id.ivChatBubble);
            face = (ImageView) itemView.findViewById(R.id.ivFace);
            message = (TextView) itemView.findViewById(R.id.tvMessages);
        }
    }

    class ChatRightHolder extends RecyclerView.ViewHolder{
        ImageView rightFace;
        ImageView chatBubbleRight;
        TextView rightMessage;


        public ChatRightHolder(View itemView) {
            super(itemView);
            chatBubbleRight = (ImageView) itemView.findViewById(R.id.ivRightChatBubble);
            rightFace = (ImageView) itemView.findViewById(R.id.ivRightFace);
            rightMessage = (TextView) itemView.findViewById(R.id.tvRightChat);
        }
    }
}
