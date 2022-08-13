package com.jaydip.dropshadowforinsta.edit;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.jaydip.dropshadowforinsta.R;

public class FrameListAdapter1 extends RecyclerView.Adapter<FrameListAdapter1.MyViewHolder> {
    private static int lastPosition = -1;
    public String[] colorArray = {"#000000", "#ffffff", "#EDE7F6", "#607D8B", "#9E9E9E", "#795548", "#FF5722", "#FF9800", "#FFC107", "#FFEB3B", "#CDDC39", "#8BC34A", "#4CAF50", "#009688", "#00BCD4", "#03A9F4", "#2196F3", "#3F51B5", "#673AB7", "#9C27B0", "#E91E63", "#f44336"};
    private final FrameItemClickListener frameItemClickListener;
    private final Context one;

    public FrameListAdapter1(FrameItemClickListener frameItemClickListener2, Context context) {
        this.frameItemClickListener = frameItemClickListener2;
        this.one = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frame_list_row, viewGroup, false));
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.iv.setBackgroundColor(Color.parseColor(this.colorArray[i]));
        myViewHolder.iv.setOnClickListener(new View.OnClickListener() {

            public final void onClick(View view) {
                FrameListAdapter1.this.lambda$onBindViewHolder$0$FrameListAdapter1(i, myViewHolder, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$FrameListAdapter1(int i, MyViewHolder myViewHolder, View view) {
        this.frameItemClickListener.onframeItemClick1(this.colorArray, i);
        lastPosition = myViewHolder.getAdapterPosition();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.colorArray.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv;

        public MyViewHolder(View view) {
            super(view);
            this.iv = (ImageView) view.findViewById(R.id.iv);
        }
    }
}
