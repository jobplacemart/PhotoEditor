package com.jaydip.dropshadowforinsta.gridmaker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.jaydip.dropshadowforinsta.R;
import java.util.List;

public class CropSizeAdapter extends RecyclerView.Adapter<CropSizeAdapter.ViewHolder> {
    private static final int CODE_SELECTED = 11;
    private static final int CODE_UN_SELECTED = 22;
    private final AdapterEvent callback;
    private final List<CropSize> list;

    public CropSizeAdapter(List<CropSize> list2, AdapterEvent adapterEvent) {
        this.list = list2;
        this.callback = adapterEvent;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.list.get(i).isSelected() ? 11 : 22;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        if (i == 11) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_crop_size_seleted, viewGroup, false);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_crop_size, viewGroup, false);
        }
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(this.list.get(i).toString());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /* class com.jaydip.storymakerforinsta.gridmaker.CropSizeAdapter.AnonymousClass1 */

            public final void onClick(View view) {
                CropSizeAdapter.this.lambda$onBindViewHolder$0$CropSizeAdapter(i, view);
            }
        });
    }

    public void lambda$onBindViewHolder$0$CropSizeAdapter(int i, View view) {
        for (int i2 = 0; i2 < this.list.size(); i2++) {
            this.list.get(i2).setSelected(false);
        }
        this.list.get(i).setSelected(true);
        notifyDataSetChanged();
        this.callback.onItemClick(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.tvSize);
        }
    }
}
