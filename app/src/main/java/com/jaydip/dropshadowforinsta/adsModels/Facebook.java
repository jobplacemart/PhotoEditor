
package com.jaydip.dropshadowforinsta.adsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Facebook {

    @SerializedName("interstitial")
    @Expose
    private Object interstitial;
    @SerializedName("native")
    @Expose
    private Object _native;
    @SerializedName("banner")
    @Expose
    private Object banner;

    public Object getInterstitial() {
        return interstitial;
    }

    public void setInterstitial(Object interstitial) {
        this.interstitial = interstitial;
    }

    public Object getNative() {
        return _native;
    }

    public void setNative(Object _native) {
        this._native = _native;
    }

    public Object getBanner() {
        return banner;
    }

    public void setBanner(Object banner) {
        this.banner = banner;
    }

}
