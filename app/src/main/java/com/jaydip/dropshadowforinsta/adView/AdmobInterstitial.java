package com.jaydip.dropshadowforinsta.adView;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;

import com.jaydip.dropshadowforinsta.adView.listener.InterstitialListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class AdmobInterstitial {
    public static String TAG = "AdmobInterstitial";
    private String adId = "";
    public InterstitialListener listener;
    Context context;
    InterstitialAd mInterstitialAd;

    private android.app.Dialog dialog;
    final int intervalTime = 10000;

    public AdmobInterstitial(Context context, String id) {
        this.context = context;
        this.adId = id;
        InterstitialAd.load(context, adId, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                super.onAdLoaded(interstitialAd);
                mInterstitialAd = interstitialAd;
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                mInterstitialAd = null;
            }

        });

    }

    public void showAd(final InterstitialListener interstitialListener) {
        this.listener = interstitialListener;
        dialog = ProgressDialog.show(context);
        if (mInterstitialAd != null) {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
            mInterstitialAd.show((Activity) context);
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    if (dialog != null && dialog.isShowing()) {
                        dialog.dismiss();
                    }
                    if (listener != null) {
                        listener.onAdClosed();
                    }
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    if (dialog != null && dialog.isShowing()) {
                        dialog.dismiss();
                    }
                    if (listener != null) {
                        listener.onAdFailed();
                    }
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    mInterstitialAd = null;
                }
            });
        }else {
            InterstitialAd.load(context, adId, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    super.onAdLoaded(interstitialAd);
                    mInterstitialAd = interstitialAd;
                    if (dialog != null && dialog.isShowing()) {
                        dialog.dismiss();
                    }
                    mInterstitialAd.show((Activity) context);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            if (dialog != null && dialog.isShowing()) {
                                dialog.dismiss();
                            }
                            if (listener != null) {
                                listener.onAdClosed();
                            }
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            if (dialog != null && dialog.isShowing()) {
                                dialog.dismiss();
                            }
                            if (listener != null) {
                                listener.onAdFailed();
                            }
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            mInterstitialAd = null;
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    mInterstitialAd = null;
                    if (dialog != null && dialog.isShowing()) {
                        dialog.dismiss();
                    }
                    if (listener != null) {
                        listener.onAdFailed();
                    }
                }

            });
        }
    }

}