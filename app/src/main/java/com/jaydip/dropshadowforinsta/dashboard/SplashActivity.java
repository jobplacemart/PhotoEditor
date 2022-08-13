package com.jaydip.dropshadowforinsta.dashboard;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import com.adsdemo.AppOpenManager;
//import com.adsdemo.ServerdataDone;
//import com.adsdemo.Splash_Activity;
import com.jaydip.dropshadowforinsta.BuildConfig;
import com.jaydip.dropshadowforinsta.MyApplication;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.adView.Utils.AdGlob;
import com.jaydip.dropshadowforinsta.adView.Utils.AdmobInterstitialAdUtil;
import com.jaydip.dropshadowforinsta.adsModels.Models;
import com.jaydip.dropshadowforinsta.adsService.ApiCalls;
import com.jaydip.dropshadowforinsta.adsService.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    AdmobInterstitialAdUtil admobInterstitialAdUtil;

    String url = "https://ads-sdk.infyom.com/api/ads/";
    List<Models> setData = new ArrayList<>();
    String banner,interstitial,nativeAdvanced,appOpen;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mission_activity_splash);
        getWindow().setFlags(1024, 1024);

        try {
            getData();
        }catch (Exception e){
            Toast.makeText(SplashActivity.this, "Success", Toast.LENGTH_SHORT).show();
        }

        admobInterstitialAdUtil = new AdmobInterstitialAdUtil(this);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, Main2Activity.class));
                SplashActivity.this.finish();
            }
        }, 3000);
    }

    void getData() throws Exception{
        Service service = ApiCalls.getPostService(url).create(Service.class);
        Call<Models> dataList = service.getAdsDataList();
        dataList.enqueue(new Callback<Models>() {
            @Override
            public void onResponse(Call<Models> call, Response<Models> response) {
                setData.add(response.body());
                banner = setData.get(0).getData().get(0).getGoogle().getBanner();
                interstitial = setData.get(0).getData().get(0).getGoogle().getInterstitial();
                nativeAdvanced = setData.get(0).getData().get(0).getGoogle().getNative();
                appOpen = setData.get(0).getData().get(0).getGoogle().getAppOpen();

                if (banner == null) {
                    banner = "0a";
                }
                if (interstitial == null) {
                    interstitial = "0a";
                }
                if (nativeAdvanced == null) {
                    nativeAdvanced = "0a";
                }

                if (appOpen == null) {
                    appOpen = "0a";
                }

                AdGlob.Banner = banner;
                AdGlob.Interstitial = interstitial;
                AdGlob.Native_Advanced = nativeAdvanced;
                AdGlob.Open_App = appOpen;

                MyApplication.AD_UNIT_ID = AdGlob.Open_App.replace(BuildConfig.ADMOB_OPEN_AD, AdGlob.Open_App);
                MyApplication.init();

                Application application = getApplication();

                if (!(application instanceof MyApplication)) {
                    return;
                }

                Toast.makeText(SplashActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Models> call, Throwable t) {
//                Toast.makeText(SplashActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
