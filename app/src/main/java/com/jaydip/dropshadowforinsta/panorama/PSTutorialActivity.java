package com.jaydip.dropshadowforinsta.panorama;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.jaydip.dropshadowforinsta.R;

public class PSTutorialActivity extends AppCompatActivity {
    ImageView btnNext;
    public TextView btnSkip;
    public TextView btn_done;
    private TextView[] dots;
    private LinearLayout dotsLayout;
    public int[] layouts;
    public MyViewPagerAdapter myViewPagerAdapter;
    public ViewPager viewPager;
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrollStateChanged(int i) {
        }

        @Override
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override
        public void onPageSelected(int i) {
            PSTutorialActivity.this.addBottomDots(i);
            if (i == PSTutorialActivity.this.layouts.length - 1) {
                PSTutorialActivity.this.btnNext.setBackgroundResource(R.drawable.ic_done);
                PSTutorialActivity.this.btnSkip.setVisibility(8);
                PSTutorialActivity.this.btn_done.setVisibility(0);
                return;
            }
            PSTutorialActivity.this.btnNext.setBackgroundResource(R.drawable.ic_next);
            PSTutorialActivity.this.btnSkip.setVisibility(0);
            PSTutorialActivity.this.btn_done.setVisibility(8);
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tutorial);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
        this.viewPager = (ViewPager) findViewById(R.id.view_pager);
        this.dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        this.btnSkip = (TextView) findViewById(R.id.btn_skip);
        this.btnNext = (ImageView) findViewById(R.id.btn_next);
        this.btn_done = (TextView) findViewById(R.id.btn_done);
        this.btnNext.setBackgroundResource(R.drawable.ic_next);
        this.layouts = new int[]{R.layout.layout_tutorial_0, R.layout.layout_tutorial_1, R.layout.layout_tutorial_2, R.layout.layout_tutorial_3, R.layout.layout_tutorial_4};
        addBottomDots(0);
        changeStatusBarColor();
        MyViewPagerAdapter myViewPagerAdapter2 = new MyViewPagerAdapter();
        this.myViewPagerAdapter = myViewPagerAdapter2;
        this.viewPager.setAdapter(myViewPagerAdapter2);
        this.viewPager.addOnPageChangeListener(this.viewPagerPageChangeListener);
        this.btnSkip.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                PSTutorialActivity.this.launchHomeScreen();
            }
        });
        this.btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                int item = PSTutorialActivity.this.getItem(1);
                if (item < PSTutorialActivity.this.layouts.length) {
                    PSTutorialActivity.this.viewPager.setCurrentItem(item);
                } else {
                    PSTutorialActivity.this.launchHomeScreen();
                }
            }
        });
        this.btn_done.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                PSTutorialActivity.this.launchHomeScreen();
            }
        });
    }

    public void addBottomDots(int i) {
        TextView[] textViewArr;
        this.dots = new TextView[this.layouts.length];
        this.dotsLayout.removeAllViews();
        int i2 = 0;
        while (true) {
            textViewArr = this.dots;
            if (i2 >= textViewArr.length) {
                break;
            }
            textViewArr[i2] = new TextView(this);
            this.dots[i2].setText(Html.fromHtml("&#8226;"));
            this.dots[i2].setTextSize(35.0f);
            this.dots[i2].setTextColor(getResources().getColor(R.color.white));
            this.dotsLayout.addView(this.dots[i2]);
            i2++;
        }
        if (textViewArr.length > 0) {
            textViewArr[i].setTextColor(getResources().getColor(R.color.active_color));
        }
    }

    public int getItem(int i) {
        return this.viewPager.getCurrentItem() + i;
    }

    public void launchHomeScreen() {
        onBackPressed();
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater2 = (LayoutInflater) PSTutorialActivity.this.getSystemService("layout_inflater");
            this.layoutInflater = layoutInflater2;
            View inflate = layoutInflater2.inflate(PSTutorialActivity.this.layouts[i], viewGroup, false);
            viewGroup.addView(inflate);
            if (i == 5) {
                PSTutorialActivity.this.launchHomeScreen();
            }
            return inflate;
        }

        @Override
        public int getCount() {
            return PSTutorialActivity.this.layouts.length;
        }

        @Override
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }
    }
}
