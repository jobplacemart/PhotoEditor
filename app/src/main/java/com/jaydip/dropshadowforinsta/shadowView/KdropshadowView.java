package com.jaydip.dropshadowforinsta.shadowView;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;

public class KdropshadowView implements ScaleGestureDetector.OnScaleGestureListener {
    public float a = 1.0f;
    public float f2282b = 0.2f;
    public float f2283c = 10.0f;
    public ScaleGestureDetector f2284d;

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = this.a * this.f2284d.getScaleFactor();
        if (scaleFactor > this.f2282b && scaleFactor <= this.f2283c) {
            this.a = scaleFactor;
            Matrix matrix = new Matrix();
            float focusX = this.f2284d.getFocusX();
            float focusY = this.f2284d.getFocusY();
            matrix.postTranslate(-focusX, -focusY);
            matrix.postScale(this.f2284d.getScaleFactor(), this.f2284d.getScaleFactor());
            matrix.postTranslate(focusX, focusY);
            bdropshadowView bdropshadowview = (bdropshadowView) this;
            DropShadowView dropShadowView = bdropshadowview.f2277e;
            DropShadowView.f1632b.postConcat(matrix);
            bdropshadowview.f2277e.invalidate();
        }
        return true;
    }
}
