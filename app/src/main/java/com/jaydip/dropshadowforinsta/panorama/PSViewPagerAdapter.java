package com.jaydip.dropshadowforinsta.panorama;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.jaydip.dropshadowforinsta.R;
import java.util.ArrayList;

public class PSViewPagerAdapter extends PagerAdapter {
    private final Context context;
    ArrayList<String> images;
    private LayoutInflater layoutInflater;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public PSViewPagerAdapter(Context context2, ArrayList<String> arrayList) {
        this.context = context2;
        this.images = arrayList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.images.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return super.getItemPosition(obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater2 = (LayoutInflater) this.context.getSystemService("layout_inflater");
        this.layoutInflater = layoutInflater2;
        View inflate = layoutInflater2.inflate(R.layout.custom_layout, (ViewGroup) null);
        ((ImageView) inflate.findViewById(R.id.imageView)).setImageURI(Uri.parse(this.images.get(i)));
        viewGroup.addView(inflate, 0);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
