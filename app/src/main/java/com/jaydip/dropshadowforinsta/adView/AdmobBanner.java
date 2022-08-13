package com.jaydip.dropshadowforinsta.adView;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.RelativeLayout;

import com.jaydip.dropshadowforinsta.adView.listener.BannerListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class AdmobBanner {

    public static void show(Context context, String bannerID, RelativeLayout frame, final BannerListener listener) {
        if (frame.getChildCount() > 0)
            frame.removeAllViews();
        AdView adView = new AdView(context);
        AdSize adSize = getAdSize(context);
        adView.setAdSize(adSize);
        adView.setAdUnitId(bannerID);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                if (listener != null) listener.onAdFailed();
            }
        });
        adView.loadAd(new AdRequest.Builder().build());
        frame.addView(adView);
    }

    private static AdSize getAdSize(Context context) {
        // Determine the screen width (less decorations) to use for the ad width.
        Display display = ((Activity) context).getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;
        int adWidth = (int) (widthPixels / density);

        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adWidth);
    }
}
