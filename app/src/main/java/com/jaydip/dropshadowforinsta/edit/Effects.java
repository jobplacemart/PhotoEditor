package com.jaydip.dropshadowforinsta.edit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/* access modifiers changed from: package-private */
public class Effects {
    Effects() {
    }

    public static Bitmap applyEffectNone(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect1(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{0.213f, 0.715f, 0.072f, 0.0f, 0.0f, 0.213f, 0.715f, 0.072f, 0.0f, 0.0f, 0.213f, 0.715f, 0.072f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect2(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(getColorMatrixSepia()));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    private static ColorMatrix getColorMatrixSepia() {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.setScale(1.0f, 1.0f, 0.8f, 1.0f);
        colorMatrix.postConcat(colorMatrix2);
        return colorMatrix;
    }

    public static Bitmap applyEffect3(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.8f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect4(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{3.2f, 0.0f, 0.0f, 0.0f, -280.5f, 0.0f, 3.2f, 0.0f, 0.0f, -280.5f, 0.0f, 0.0f, 3.2f, 0.0f, -280.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect5(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.5f, 0.0f, 0.0f, 0.0f, -63.75f, 0.0f, 1.5f, 0.0f, 0.0f, -63.75f, 0.0f, 0.0f, 1.5f, 0.0f, -63.75f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect6(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect7(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, -0.1f, -0.1f, -0.1f, 0.0f, 1.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect8(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 60.0f, 0.0f, 0.0f, 0.0f, 0.0f, 60.0f, 0.0f, 0.0f, 0.0f, 0.0f, 90.0f, -0.213f, -0.715f, -0.072f, 0.0f, 255.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect9(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -60.0f, 0.0f, 1.0f, 0.0f, 0.0f, -60.0f, 0.0f, 0.0f, 1.0f, 0.0f, -90.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect10(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -60.0f, 0.0f, 1.0f, 0.0f, 0.0f, -60.0f, 0.0f, 0.0f, 1.0f, 0.0f, -90.0f, 0.213f, 0.715f, 0.072f, 0.0f, 255.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect11(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -60.0f, 0.0f, 1.0f, 0.0f, 0.0f, -60.0f, 0.0f, 0.0f, 1.0f, 0.0f, -90.0f, -0.213f, -0.715f, -0.072f, 0.0f, 255.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect12(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 90.0f, 0.213f, 0.715f, 0.072f, 0.0f, 255.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect13(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect14(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.375f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.390625f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.1640625f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.6796875f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect15(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.5234375f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.203125f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.015625f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.28125f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect16(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.0390625f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.3671875f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.4921875f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect17(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.5625f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.565625f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.5234375f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect18(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{0.9609375f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.6171875f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.40625f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.8046875f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect19(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{0.7109375f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.34375f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.35625f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.9921875f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect20(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.0703125f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.25f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.140625f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.4140625f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect21(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.1953125f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.671875f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.3984375f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.7265625f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }

    public static Bitmap applyEffect22(Bitmap bitmap) {
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new float[]{1.1953125f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.671875f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.3984375f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.8671875f, 0.0f}));
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(copy).drawBitmap(copy, 0.0f, 0.0f, paint);
        return copy;
    }
}
