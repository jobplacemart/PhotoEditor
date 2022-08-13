package com.jaydip.dropshadowforinsta.creation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobBannerUtil;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobInterstitialAdUtil;
import com.jaydip.dropshadowforinsta.dashboard.Glob;

import java.io.File;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView finalimg;
    ImageView ivHomeIcon;
    ImageView iv_Share_More;
    ImageView iv_instagram;
    ImageView iv_face_book;
    ImageView iv_whatsapp;
    public File outputFile;

    ImageView ivBack;
    RelativeLayout rlBanner;
    AdmobInterstitialAdUtil admobInterstitialAdUtil;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_share);
        getWindow().setFlags(1024, 1024);
        bindview();
        rlBanner = (RelativeLayout) findViewById(R.id.rl_banner);
        AdmobBannerUtil.loadBanner(this,rlBanner);
        admobInterstitialAdUtil = new AdmobInterstitialAdUtil(ShareActivity.this);
        ivBack = (ImageView) findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void bindview() {
        ImageView imageView = (ImageView) findViewById(R.id.ivHomeIcon);
        this.ivHomeIcon = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShareActivity.this.lambda$bindview$0$ShareActivity(view);
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.finalimg);
        this.finalimg = imageView2;
        imageView2.setImageBitmap(Glob.finalBitmap);
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_instagram);
        this.iv_instagram = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) findViewById(R.id.iv_face_book);
        this.iv_face_book = imageView4;
        imageView4.setOnClickListener(this);
        ImageView imageView5 = (ImageView) findViewById(R.id.iv_whatsapp);
        this.iv_whatsapp = imageView5;
        imageView5.setOnClickListener(this);
    }

    public void lambda$bindview$0$ShareActivity(View view) {
        admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
            @Override
            public void OnClose(boolean isFail) {
                startActivity(new Intent(ShareActivity.this,My_Creation_Activity.class));
            }
        });
    }

    public void onClick(View view) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
//        intent.putExtra("android.intent.extra.TEXT", Glob.app_name + " Created By : " + Glob.app_link);
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this, "com.jaydip.storymakerforinsta.provider", new File(Glob.shareuri)));
        int id = view.getId();
        if (id == R.id.iv_instagram) {
            try {
                intent.setPackage("com.instagram.android");
                startActivity(intent);
            } catch (Exception unused) {
                Toast.makeText(getApplicationContext(), "Instragram doesn't installed", Toast.LENGTH_LONG).show();
            }
        }
        if (id == R.id.iv_face_book) {
            try {
                intent.setPackage("com.facebook.katana");
                startActivity(intent);
            } catch (Exception unused) {
                Toast.makeText(getApplicationContext(), "facebook doesn't installed", Toast.LENGTH_LONG).show();
            }
        }
        if (id == R.id.iv_whatsapp) {
            try {
                intent.setPackage("com.whatsapp");
                startActivity(intent);
            } catch (Exception unused) {
                Toast.makeText(getApplicationContext(), "whatsapp doesn't installed", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
