
package com.jaydip.dropshadowforinsta.adsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Google {

    @SerializedName("app_id")
    @Expose
    private String appId;
    @SerializedName("interstitial")
    @Expose
    private String interstitial;
    @SerializedName("native")
    @Expose
    private String _native;
    @SerializedName("banner")
    @Expose
    private String banner;
    @SerializedName("rewarded")
    @Expose
    private String rewarded;
    @SerializedName("app_open")
    @Expose
    private String appOpen;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getInterstitial() {
        return interstitial;
    }

    public void setInterstitial(String interstitial) {
        this.interstitial = interstitial;
    }

    public String getNative() {
        return _native;
    }

    public void setNative(String _native) {
        this._native = _native;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getRewarded() {
        return rewarded;
    }

    public void setRewarded(String rewarded) {
        this.rewarded = rewarded;
    }

    public String getAppOpen() {
        return appOpen;
    }

    public void setAppOpen(String appOpen) {
        this.appOpen = appOpen;
    }

}
