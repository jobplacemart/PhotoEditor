package com.jaydip.dropshadowforinsta.adView;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.jaydip.dropshadowforinsta.adView.listener.RewardListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class AdmobReward {
    private static String TAG = "AdmobReward";
    private String adId;
    private android.app.Dialog dialog;
    private Activity context;
    private RewardedAd rewardedAd;

    public AdmobReward(Activity context, String adId) {
        this.context = context;
        this.adId = adId;
        RewardedAd.load(context, adId, new AdRequest.Builder().build(), new RewardedAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

            }

            @Override
            public void onAdLoaded(@NonNull RewardedAd rewarded) {
                rewardedAd = rewarded;
            }
        });
    }

    public void show(final RewardListener rewardListner) {
        final boolean[] rewarded = new boolean[]{false};
        dialog = ProgressDialog.show(context);
        if (rewardedAd != null) {
            rewardedAd.show(context, new OnUserEarnedRewardListener() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    rewarded[0] = true;
                }
            });
            rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdShowedFullScreenContent() {
                    rewardedAd = null;
                    if (dialog != null && dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    try {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    } catch (Exception e) {

                    }
                    rewardListner.onAdFailed();
                }

                @Override
                public void onAdDismissedFullScreenContent() {
                    rewardListner.onAdClosed(rewarded[0]);
                }
            });
        } else {
            RewardedAd.load(context, adId, new AdRequest.Builder().build(), new RewardedAdLoadCallback() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    rewardedAd = null;
                    try {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    } catch (Exception e) {

                    }
                    rewardListner.onAdFailed();
                }

                @Override
                public void onAdLoaded(@NonNull RewardedAd reward) {
                    rewardedAd = reward;
                    rewardedAd.show(context, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            rewarded[0] = true;
                        }
                    });
                    rewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdShowedFullScreenContent() {
                            rewardedAd = null;
                            if (dialog != null && dialog.isShowing()) {
                                dialog.dismiss();
                            }
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            try {
                                if (dialog != null && dialog.isShowing()) {
                                    dialog.dismiss();
                                }
                            } catch (Exception e) {

                            }
                            rewardListner.onAdFailed();
                        }

                        @Override
                        public void onAdDismissedFullScreenContent() {
                            rewardListner.onAdClosed(rewarded[0]);
                        }
                    });
                }
            });
        }

    }
}