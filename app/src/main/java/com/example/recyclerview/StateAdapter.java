package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<State> states;
    private final OnStateClickListener onStateClickListen;

    public StateAdapter(LayoutInflater inflater, List<State> states, OnStateClickListener onStateClickListen) {
        this.inflater = inflater;
        this.states = states;
        this.onStateClickListen = onStateClickListen;
    }

    interface OnStateClickListener{
        void onStateClick(State state, int position);
    }

    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateAdapter.ViewHolder holder, int position) {
        State state = states.get(position);
        holder.flagImageView.setImageResource(state.getFlagResource());
        holder.nameTextView.setText(state.getName());
        holder.capitalTextView.setText(state.getCapital());
        holder.itemView.setOnClickListener(view -> {
            onStateClickListen.onStateClick(state, position);
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView flagImageView;
        final TextView nameTextView, capitalTextView;
        ViewHolder(View view){
            super(view);
            flagImageView = view.findViewById(R.id.flagImage);
            nameTextView = view.findViewById(R.id.nameText);
            capitalTextView = view.findViewById(R.id.capitalText);
        }
    }
}
