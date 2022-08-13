
package com.jaydip.dropshadowforinsta.adsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("google")
    @Expose
    private Google google;
    @SerializedName("facebook")
    @Expose
    private Facebook facebook;
    @SerializedName("start_ups")
    @Expose
    private StartUps startUps;

    public Google getGoogle() {
        return google;
    }

    public void setGoogle(Google google) {
        this.google = google;
    }

    public Facebook getFacebook() {
        return facebook;
    }

    public void setFacebook(Facebook facebook) {
        this.facebook = facebook;
    }

    public StartUps getStartUps() {
        return startUps;
    }

    public void setStartUps(StartUps startUps) {
        this.startUps = startUps;
    }

}