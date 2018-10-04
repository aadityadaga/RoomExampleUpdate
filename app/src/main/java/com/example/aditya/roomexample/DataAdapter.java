package com.example.aditya.roomexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aditya.roomexample.Model.User;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.CustomViewHolder> {
    private Context mContext;
    private List<User> mList;

    public DataAdapter(Context context, List<User> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(mContext).inflate(R.layout.activity_data_model, viewGroup, false);
        return new CustomViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewHolder, int i) {
        viewHolder.mtvEmail.setText(mList.get(i).getEmail());
        viewHolder.mTvName.setText(mList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView mtvEmail, mTvName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mtvEmail = itemView.findViewById(R.id.tv_email);
            mTvName = itemView.findViewById(R.id.tv_name);

        }
    }
}
