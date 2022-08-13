package com.jaydip.dropshadowforinsta.creation;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
//import android.support.v4.media.session.PlaybackStateCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
//import com.adsdemo.AdmobAds;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobBannerUtil;
import com.jaydip.dropshadowforinsta.dashboard.Glob;
import com.jaydip.dropshadowforinsta.panorama.PSHomeActivity;
import java.io.File;
import java.util.ArrayList;

public class My_Creation_Activity extends AppCompatActivity {
    public static ArrayList<String> IMAGEALLARY = new ArrayList<>();
    public static int pos;
    private ImageView fback;
    private Galleryadapter galleryAdapter;
    GridView lv;

    RelativeLayout rl_banner;

    class C03712 implements AdapterView.OnItemClickListener {
        C03712() {
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            My_Creation_Activity.this.galleryAdapter.getItemId(i);
            My_Creation_Activity.pos = i;
            Dialog dialog = new Dialog(My_Creation_Activity.this, 16973839);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            My_Creation_Activity.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            double d = (double) displayMetrics.heightPixels;
            Double.isNaN(d);
            double d2 = (double) displayMetrics.widthPixels;
            Double.isNaN(d2);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setFlags(1024, 1024);
            dialog.setContentView(R.layout.activity_full_screen_view);
            Window window = dialog.getWindow();
            Double.isNaN(d2);
            Double.isNaN(d);
            window.setLayout((int) (d2 * 1.0d), (int) (d * 1.0d));
            dialog.setCanceledOnTouchOutside(true);
            ((ImageView) dialog.findViewById(R.id.iv_image)).setImageURI(Uri.parse(My_Creation_Activity.IMAGEALLARY.get(My_Creation_Activity.pos)));
            dialog.show();
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_creation);
        this.rl_banner = (RelativeLayout) findViewById(R.id.rl_banner);
        AdmobBannerUtil.loadBanner(this,rl_banner);
        this.lv = (GridView) findViewById(R.id.gridview);
        this.fback = (ImageView) findViewById(R.id.fback);
        IMAGEALLARY.clear();
        listAllImages(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/" + Glob.app_name + "/"));
        Galleryadapter galleryadapter = new Galleryadapter(this, IMAGEALLARY);
        this.galleryAdapter = galleryadapter;
        this.lv.setAdapter((ListAdapter) galleryadapter);
        this.fback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                My_Creation_Activity.this.onBackPressed();
            }
        });
        this.lv.setOnItemClickListener(new C03712());
    }

    private void listAllImages(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int length = listFiles.length - 1; length >= 0; length--) {
                String file2 = listFiles[length].toString();
                File file3 = new File(file2);
                Log.d("" + file3.length(), "" + file3.length());
                if (file3.length() <= 1024) {
                    Log.e("Invalid Image", "Delete Image");
                } else if (file3.toString().contains(".jpg") || file3.toString().contains(".png") || file3.toString().contains(".jpeg")) {
                    IMAGEALLARY.add(file2);
                }
                System.out.println(file2);
            }
            return;
        }
        System.out.println("Empty Folder");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), PSHomeActivity.class));
        finish();
    }
}
