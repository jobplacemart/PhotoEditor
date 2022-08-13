package com.jaydip.dropshadowforinsta.adsService;

import com.jaydip.dropshadowforinsta.BuildConfig;
import com.jaydip.dropshadowforinsta.adsModels.Models;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

        @GET(BuildConfig.APPLICATION_ID)
        Call <Models> getAdsDataList();

    }