package com.jaydip.dropshadowforinsta.gridmaker;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SquareAdapterViewPager extends FragmentStatePagerAdapter {
    private ColorAdapterEvent callback;
    BlurFragmentEvent callbackBlur;
    private final String[] strings = {"Blur", "Color"};

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    public SquareAdapterViewPager(FragmentManager fragmentManager, BlurFragmentEvent blurFragmentEvent, ColorAdapterEvent colorAdapterEvent) {
        super(fragmentManager);
        this.callbackBlur = blurFragmentEvent;
        this.callback = colorAdapterEvent;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (i == 0) {
            return new BlurFragment(this.callbackBlur);
        }
        return new ColorFragment(this.callback);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.strings[i];
    }
}
