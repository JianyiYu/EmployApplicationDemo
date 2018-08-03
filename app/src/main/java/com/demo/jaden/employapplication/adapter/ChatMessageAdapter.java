package com.demo.jaden.employapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.jaden.employapplication.R;
import com.demo.jaden.employapplication.model.MessageContent;

import java.util.List;

public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageAdapter.ViewHolder> {

    private List<MessageContent> msgList;

    public ChatMessageAdapter(List<MessageContent> list){
        this.msgList = list;
    }

    @Override
    public int getItemViewType(int position) {
        return msgList.get(position).getType();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
        View view;
        if(type == MessageContent.MESSAGE_TYPE_RECEIVED){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_msg_item_receive, parent, false);
        }
        else{
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_msg_item_send, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if(getItemViewType(i) == MessageContent.MESSAGE_TYPE_SEND){
            viewHolder.msgSend.setText(msgList.get(i).getMsg());
//            viewHolder.meImg.setImageResource();
        }
        else {
            viewHolder.msgReceived.setText(msgList.get(i).getMsg());
//            viewHolder.heImg.setImageResource();
        }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView msgReceived;
        private TextView msgSend;
        private ImageView heImg;
        private ImageView meImg;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            msgReceived = itemView.findViewById(R.id.message_received);
            msgSend = itemView.findViewById(R.id.message_send);
            heImg = itemView.findViewById(R.id.img_he);
            meImg = itemView.findViewById(R.id.img_me);
        }
    }
}
