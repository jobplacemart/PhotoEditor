package com.jaydip.dropshadowforinsta.dashboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;

public class Glob {
    public static String Edit_Folder_name = "Drop Shadow For Instagram Grid Story Crop";
    public static String app_link = "https://play.google.com/store/apps/details?id=com.dropshadowforinsta.gridstorycropforinsta.storymakerforinsta";
    public static String app_name = "Drop Shadow For Instagram Grid Story Crop";
    public static Bitmap bitmap = null;
    public static boolean dialog = true;
    public static int dialog1;
    public static Bitmap finalBitmap;
    public static Bitmap gallerybitmap;
    public static Uri selectedUri;
    public static int selection;
    public static String shareuri;

    public static boolean getBoolPref(Context context, String str) {
        return context.getSharedPreferences(context.getPackageName(), 0).getBoolean(str, false);
    }

    public static int getPref(Context context, String str) {
        return context.getSharedPreferences(context.getPackageName(), 0).getInt(str, 1);
    }

    public static void setBoolPref(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static void setPref(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName(), 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }
}
