package com.jaydip.dropshadowforinsta.gridmaker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.jaydip.dropshadowforinsta.R;
import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {
    private final ColorAdapterEvent callback;
    List<Integer> list;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    public ColorAdapter(ColorAdapterEvent colorAdapterEvent) {
        this.callback = colorAdapterEvent;
        ArrayList arrayList = new ArrayList();
        this.list = arrayList;
        arrayList.add(0);
        this.list.add(Integer.valueOf((int) R.color.color00));
        this.list.add(Integer.valueOf((int) R.color.color111));
        this.list.add(Integer.valueOf((int) R.color.color2));
        this.list.add(Integer.valueOf((int) R.color.color3));
        this.list.add(Integer.valueOf((int) R.color.color4));
        this.list.add(Integer.valueOf((int) R.color.color5));
        this.list.add(Integer.valueOf((int) R.color.color6));
        this.list.add(Integer.valueOf((int) R.color.color7));
        this.list.add(Integer.valueOf((int) R.color.color8));
        this.list.add(Integer.valueOf((int) R.color.color9));
        this.list.add(Integer.valueOf((int) R.color.color11));
        this.list.add(Integer.valueOf((int) R.color.color12));
        this.list.add(Integer.valueOf((int) R.color.color13));
        this.list.add(Integer.valueOf((int) R.color.color14));
        this.list.add(Integer.valueOf((int) R.color.color15));
        this.list.add(Integer.valueOf((int) R.color.color10));
        this.list.add(Integer.valueOf((int) R.color.color0));
        this.list.add(Integer.valueOf((int) R.color.color1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (i != 0) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_color, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_color_0, viewGroup, false);
        }
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        if (i != 0) {
            viewHolder.imgv.setColorFilter(viewHolder.imgv.getContext().getResources().getColor(this.list.get(i).intValue()));
        } else {
            viewHolder.imgv.setImageResource(R.drawable.ic_color_circle);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.jaydip.storymakerforinsta.gridmaker.ColorAdapter.AnonymousClass1 */

            public final void onClick(View view) {
                ColorAdapter.this.lambda$onBindViewHolder$0$ColorAdapter(i, view);
            }
        });
    }

    public void lambda$onBindViewHolder$0$ColorAdapter(int i, View view) {
        this.callback.onClickItem(this.list.get(i).intValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgv;

        public ViewHolder(View view) {
            super(view);
            this.imgv = (ImageView) view.findViewById(R.id.imgv);
        }
    }
}
