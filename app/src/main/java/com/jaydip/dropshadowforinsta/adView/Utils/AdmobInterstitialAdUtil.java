package com.jaydip.dropshadowforinsta.adView.Utils;

import android.content.Context;

import com.jaydip.dropshadowforinsta.adView.AdmobInterstitial;
import com.jaydip.dropshadowforinsta.adView.listener.InterstitialListener;

public class AdmobInterstitialAdUtil {
    private Context context;
    private AdmobInterstitial admobInterstitial;

    public AdmobInterstitialAdUtil(Context context) {
        this.context = context;
        admobInterstitial = new AdmobInterstitial(context, AdGlob.Interstitial);
    }

    public interface Callback {
        void OnClose(boolean isFail);
    }

    public void showInterstitial(final Callback callback) {

        showInterstitialAds(new Callback() {
            @Override
            public void OnClose(boolean isFail) {
                if (callback != null)
                    callback.OnClose(isFail);
            }
        });
    }

    private void showInterstitialAds(final Callback callback) {
        if (admobInterstitial != null)
            admobInterstitial.showAd(new InterstitialListener() {

                @Override
                public void onAdClosed() {
                    if (callback != null) {
                        callback.OnClose(false);
                    }
                }

                @Override
                public void onAdFailed() {
                    if (callback != null) {
                        callback.OnClose(true);
                    }
                }
            });
        else {
            if (callback != null)
                callback.OnClose(true);
        }
    }
}
