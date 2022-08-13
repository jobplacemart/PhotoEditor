package com.jaydip.dropshadowforinsta.edit;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.jaydip.dropshadowforinsta.R;

public class FrameListAdapter extends RecyclerView.Adapter<FrameListAdapter.MyViewHolder> {
    public static int lastPosition = -1;
    public FrameItemClickListener frameItemClickListener;
    public int[][] gradiantArray = {new int[]{Color.parseColor("#ffafbd"), Color.parseColor("#ffc3a0")}, new int[]{Color.parseColor("#2193b0"), Color.parseColor("#6dd5ed")}, new int[]{Color.parseColor("#cc2b5e"), Color.parseColor("#753a88")}, new int[]{Color.parseColor("#ee9ca7"), Color.parseColor("#ffdde1")}, new int[]{Color.parseColor("#42275a"), Color.parseColor("#734b6d")}, new int[]{Color.parseColor("#bdc3c7"), Color.parseColor("#2c3e50")}, new int[]{Color.parseColor("#de6262"), Color.parseColor("#ffb88c")}, new int[]{Color.parseColor("#06beb6"), Color.parseColor("#48b1bf")}, new int[]{Color.parseColor("#eb3349"), Color.parseColor("#f45c43")}, new int[]{Color.parseColor("#dd5e89"), Color.parseColor("#f7bb97")}, new int[]{Color.parseColor("#56ab2f"), Color.parseColor("#a8e063")}, new int[]{Color.parseColor("#614385"), Color.parseColor("#516395")}, new int[]{Color.parseColor("#eecda3"), Color.parseColor("#ef629f")}, new int[]{Color.parseColor("#eacda3"), Color.parseColor("#d6ae7b")}, new int[]{Color.parseColor("#02aab0"), Color.parseColor("#00cdac")}, new int[]{Color.parseColor("#d66d75"), Color.parseColor("#e29587")}, new int[]{Color.parseColor("#000428"), Color.parseColor("#004e92")}, new int[]{Color.parseColor("#ddd6f3"), Color.parseColor("#faaca8")}, new int[]{Color.parseColor("#7b4397"), Color.parseColor("#dc2430")}, new int[]{Color.parseColor("#43cea2"), Color.parseColor("#185a9d")}, new int[]{Color.parseColor("#ba5370"), Color.parseColor("#f4e2d8")}, new int[]{Color.parseColor("#ff512f"), Color.parseColor("#dd2476")}, new int[]{Color.parseColor("#4568dc"), Color.parseColor("#b06ab3")}, new int[]{Color.parseColor("#ec6f66"), Color.parseColor("#f3a183")}, new int[]{Color.parseColor("#ffd89b"), Color.parseColor("#19547b")}, new int[]{Color.parseColor("#3a1c71"), Color.parseColor("#ffaf7b")}, new int[]{Color.parseColor("#4ca1af"), Color.parseColor("#c4e0e5")}, new int[]{Color.parseColor("#ff5f6d"), Color.parseColor("#ffc371")}, new int[]{Color.parseColor("#36d1dc"), Color.parseColor("#5b86e5")}, new int[]{Color.parseColor("#c33764"), Color.parseColor("#1d2671")}, new int[]{Color.parseColor("#141e30"), Color.parseColor("#243b55")}, new int[]{Color.parseColor("#ff7e5f"), Color.parseColor("#feb47b")}, new int[]{Color.parseColor("#ed4264"), Color.parseColor("#ffedbc")}, new int[]{Color.parseColor("#2b5876"), Color.parseColor("#4e4376")}, new int[]{Color.parseColor("#ff9966"), Color.parseColor("#ff5e62")}, new int[]{Color.parseColor("#aa076b"), Color.parseColor("#61045f")}};
    public Context one;

    public FrameListAdapter(FrameItemClickListener frameItemClickListener2, Context context) {
        this.frameItemClickListener = frameItemClickListener2;
        this.one = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frame_list_row, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.iv.setImageDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gradiantArray[i]));
        myViewHolder.iv.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FrameListAdapter.this.lambda$onBindViewHolder$0$FrameListAdapter(i, myViewHolder, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$FrameListAdapter(int i, MyViewHolder myViewHolder, View view) {
        this.frameItemClickListener.onframeItemClick(this.gradiantArray, i);
        lastPosition = myViewHolder.getAdapterPosition();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.gradiantArray.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;

        public MyViewHolder(View view) {
            super(view);
            this.iv = (ImageView) view.findViewById(R.id.iv);
        }
    }
}
