package com.demo.jaden.employapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.jaden.employapplication.R;
import com.demo.jaden.employapplication.fragment.ConversationFragment;
import com.demo.jaden.employapplication.model.CoversationContent;

import java.util.List;

public class ConversationItemViewAdapter extends RecyclerView.Adapter<ConversationItemViewAdapter.ViewHolder> {

    private final List<CoversationContent.ConversationItem> mValues;
    private final ConversationFragment.OnFragmentInteractionListener mListener;

    public ConversationItemViewAdapter(List<CoversationContent.ConversationItem> mValues, ConversationFragment.OnFragmentInteractionListener mListener) {
        this.mValues = mValues;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frament_conversation_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {

        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onFragmentInteraction(viewHolder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        private CoversationContent.ConversationItem mItem;
        TextView name;
        TextView lastMsg;

        public ViewHolder(View view){
            super(view);
            mView = view;
            name = view.findViewById(R.id.user_name_view);
            lastMsg = view.findViewById(R.id.last_msg_view);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}