package com.jaydip.dropshadowforinsta.adView.Utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jaydip.dropshadowforinsta.adView.AdmobNative;
import com.jaydip.dropshadowforinsta.adView.listener.NativeListener;

public class AdmobNativeUtil {

    public static void loadNative(final Context context, final RelativeLayout adContainer, ImageView spaceStart) {
        AdmobNative.loadNativeAdLong(context, AdGlob.Native_Advanced, adContainer, spaceStart, true, new NativeListener() {
            @Override
            public void onAdFailed() {
                android.util.Log.e("fksdsdkjs", "fiallll");
            }
        });
    }

}
