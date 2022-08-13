package com.jaydip.dropshadowforinsta.shadowView;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public abstract class JdropshadowView {
    public float a = 0.8f;
    public float f2279b = 0.8f;
    public float f2280c = 0.0f;
    public float f2281d = 0.0f;

    public JdropshadowView(Bitmap bitmap, boolean z, int i, int i2) {
        if (z) {
            float max = 0.8f / Math.max(((float) bitmap.getWidth()) / ((float) i), ((float) bitmap.getHeight()) / ((float) i2));
            this.a = max;
            this.f2279b = max;
        }
        float f = this.f2280c;
        float f2 = this.f2279b;
        float f3 = f / f2;
        float f4 = this.f2281d / f2;
        float f5 = (float) i;
        float f6 = this.f2279b;
        if (((float) bitmap.getWidth()) * f6 > f5) {
            float f7 = -((((float) bitmap.getWidth()) * f6) - f5);
            if (this.f2280c < f7) {
                this.f2280c = f7;
                f3 = f7 / f6;
            }
            if (this.f2280c > 0.0f) {
                this.f2280c = 0.0f;
                f3 = 0.0f / this.f2279b;
            }
        } else {
            f3 = ((f5 - (((float) bitmap.getWidth()) * f6)) / 2.0f) / f6;
        }
        float f8 = (float) i2;
        char c = ((float) bitmap.getHeight()) * this.f2279b > f8 ? 1 : ((float) bitmap.getHeight()) * this.f2279b == f8 ? (char) 0 : 65535;
        float height = (float) bitmap.getHeight();
        if (c > 0) {
            float f9 = this.f2279b;
            float f10 = -((height * f9) - f8);
            if (this.f2281d < f10) {
                this.f2281d = f10;
                f4 = f10 / f9;
            }
            if (this.f2281d > 0.0f) {
                this.f2281d = 0.0f;
                f4 = 0.0f / f9;
            }
        } else {
            float f11 = this.f2279b;
            f4 = ((f8 - (height * f11)) / 2.0f) / f11;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate(f3, f4);
        float f12 = this.f2279b;
        matrix.postScale(f12, f12);
        DropShadowView.f1632b = matrix;
    }
}
