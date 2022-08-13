package com.jaydip.dropshadowforinsta.dashboard;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobBannerUtil;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobInterstitialAdUtil;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobNativeUtil_300;
import com.jaydip.dropshadowforinsta.creation.My_Creation_Activity;
import com.jaydip.dropshadowforinsta.panorama.PSHomeActivity;

import java.io.File;

@SuppressLint("WrongConstant")
public class Main2Activity extends AppCompatActivity{

    RelativeLayout rlGetStart;
    RelativeLayout rlAlbum;
    RelativeLayout rlWifiCalling;
    AdmobInterstitialAdUtil admobInterstitialAdUtil;
    RelativeLayout rlNative;
    ImageView imageSpace;
    RelativeLayout rlBanner;

    Dialog backDialog;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mission_activity_main2);
        getWindow().setFlags(1024, 1024);
        rlBanner = (RelativeLayout) findViewById(R.id.rl_banner);
        rlNative = (RelativeLayout) findViewById(R.id.rl_native);
        imageSpace = (ImageView) findViewById(R.id.iv_space);
        AdmobNativeUtil_300.loadNative(this,rlNative,imageSpace);
        AdmobBannerUtil.loadBanner(this,rlBanner);
        admobInterstitialAdUtil = new AdmobInterstitialAdUtil(Main2Activity.this);
        if (Build.VERSION.SDK_INT >= 23 && !(ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.INTERNET") == 0 && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_NETWORK_STATE") == 0 && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_WIFI_STATE") == 0 && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.RECORD_AUDIO") == 0 && ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.CAMERA") == 0)) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.RECORD_AUDIO", "android.permission.CAMERA"}, 10);
        }
        initBackDialog();
        rlGetStart = (RelativeLayout) findViewById(R.id.rl_get_start);
        rlGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
                    @Override
                    public void OnClose(boolean isFail) {
                        startActivity(new Intent(Main2Activity.this,PSHomeActivity.class));
                    }
                });
            }
        });
        rlAlbum = (RelativeLayout) findViewById(R.id.rl_album);
        rlAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
                    @Override
                    public void OnClose(boolean isFail) {
                        startActivity(new Intent(Main2Activity.this, My_Creation_Activity.class));
                    }
                });
            }
        });

        rlWifiCalling= (RelativeLayout) findViewById(R.id.rl_wifi_calling);
        rlWifiCalling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.jaydip.wificalling")));
            }
        });
    }

    @SuppressLint("NewApi")
    void initBackDialog() {
        backDialog = new Dialog(this);
        backDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        backDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        backDialog.setContentView(R.layout.dialog_back);
        backDialog.setCancelable(false);

        TextView btnExit = (TextView) backDialog.findViewById(R.id.btn_exit);
        TextView btnNo = (TextView) backDialog.findViewById(R.id.btn_no);
        ImageView spaceExit = (ImageView) backDialog.findViewById(R.id.space_exit);
        RelativeLayout nativeExit  = (RelativeLayout) backDialog.findViewById(R.id.native_exit);

        AdmobInterstitialAdUtil admobInterstitialAdUtil;
        admobInterstitialAdUtil = new AdmobInterstitialAdUtil(this);
        AdmobNativeUtil_300.loadNative(this,nativeExit,spaceExit);

        btnExit.setOnClickListener(h -> {
            admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
                @Override
                public void OnClose(boolean isFail) {
                    Intent intent1 = new Intent(Main2Activity.this, ExitActivity.class);
                    startActivity(intent1);
                }
            });
            backDialog.dismiss();
        });

        btnNo.setOnClickListener(v -> {
            backDialog.dismiss();
        });

    }

    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    @Override
    public void onBackPressed() {
        backDialog.show();
    }
}
