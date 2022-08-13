
package com.jaydip.dropshadowforinsta.adsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class StartUps {

    @SerializedName("app_id")
    @Expose
    private Object appId;

    public Object getAppId() {
        return appId;
    }

    public void setAppId(Object appId) {
        this.appId = appId;
    }

}
