package com.jaydip.dropshadowforinsta.adView.Utils;

import android.content.Context;
import android.widget.RelativeLayout;

import com.jaydip.dropshadowforinsta.adView.AdmobBanner;
import com.jaydip.dropshadowforinsta.adView.listener.BannerListener;

public class AdmobBannerUtil {
    public static void loadBanner(final Context context, final RelativeLayout adContainer) {
        AdmobBanner.show(context, AdGlob.Banner, adContainer, new BannerListener() {
            @Override
            public void onAdFailed() {
                loadBanner(context, adContainer);
            }
        });
    }
}
