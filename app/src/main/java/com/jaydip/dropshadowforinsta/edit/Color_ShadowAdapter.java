package com.jaydip.dropshadowforinsta.edit;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.jaydip.dropshadowforinsta.R;
import java.util.ArrayList;

public class Color_ShadowAdapter extends RecyclerView.Adapter<Color_ShadowAdapter.MyViewHolder> {
    public static int lastPosition = -1;
    public ArrayList<Integer> arrayList2 = new ArrayList<>();
    public final colorshadopwItemClickListener colorshadopwItemClickListener;
    public final Activity one;

    public Color_ShadowAdapter(ArrayList<Integer> arrayList, colorshadopwItemClickListener colorshadopwitemclicklistener, Activity activity) {
        this.arrayList2 = arrayList;
        this.colorshadopwItemClickListener = colorshadopwitemclicklistener;
        this.one = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frame_list_row, viewGroup, false));
    }

    public void onBindViewHolder(final MyViewHolder myViewHolder, final int i) {
        myViewHolder.iv.setBackgroundColor(this.arrayList2.get(i).intValue());
        if (i == 0) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color00));
        } else if (i == 1) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color111));
        } else if (i == 2) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color3));
        } else if (i == 3) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color4));
        } else if (i == 4) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color5));
        } else if (i == 5) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color6));
        } else if (i == 6) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color7));
        } else if (i == 7) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color8));
        } else if (i == 8) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color9));
        } else if (i == 9) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color10));
        } else if (i == 10) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color11));
        } else if (i == 11) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color12));
        } else if (i == 12) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color13));
        } else if (i == 13) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color14));
        } else if (i == 14) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color15));
        } else if (i == 15) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color1));
        } else if (i == 16) {
            myViewHolder.iv.setBackgroundColor(this.one.getResources().getColor(R.color.color2));
        }
        myViewHolder.iv.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                Color_ShadowAdapter.this.colorshadopwItemClickListener.onColorItemClick(Color_ShadowAdapter.this.arrayList2.get(i).intValue(), i);
                Color_ShadowAdapter.lastPosition = myViewHolder.getAdapterPosition();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.arrayList2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView iv;

        public MyViewHolder(View view) {
            super(view);
            this.iv = (ImageView) view.findViewById(R.id.iv);
        }
    }
}
