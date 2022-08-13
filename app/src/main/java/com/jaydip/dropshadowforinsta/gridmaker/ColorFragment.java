package com.jaydip.dropshadowforinsta.gridmaker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jaydip.dropshadowforinsta.R;

public class ColorFragment extends Fragment {
    ColorAdapterEvent colorAdapterEvent;
    private RecyclerView rcv;

    public ColorFragment(ColorAdapterEvent colorAdapterEvent2) {
        this.colorAdapterEvent = colorAdapterEvent2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_color, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rcv);
        this.rcv = recyclerView;
        recyclerView.setAdapter(new ColorAdapter(this.colorAdapterEvent));
        this.rcv.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        return inflate;
    }
}
