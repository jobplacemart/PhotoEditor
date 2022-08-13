package com.jaydip.dropshadowforinsta.shadowView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import androidx.core.view.ViewCompat;

public class DropShadowView extends View {
    public static Matrix f1632b = new Matrix();
    public Paint f;
    public ScaleGestureDetector f1633c;
    public GestureDetector f1634d;
    public Context f1635e;
    public Paint g;
    public Paint h;
    public Bitmap i;
    public Bitmap j;
    public int k;
    public int l;
    public float m = 0.01f;
    public float n = 0.01f;
    public Bitmap o;
    public Bitmap p;

    public class a extends JdropshadowView {
        public a(Bitmap bitmap, boolean z, int i, int i2) {
            super(bitmap, z, i, i2);
        }
    }

    public DropShadowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1635e = context;
        this.o = getBlankBitmap();
        Paint paint = new Paint(2);
        this.h = paint;
        paint.setColor(Color.parseColor("#EDE7F6"));
        this.f = new Paint(2);
        Paint paint2 = new Paint(2);
        this.g = paint2;
        paint2.setMaskFilter(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.NORMAL));
        bdropshadowView bdropshadowview = new bdropshadowView(this);
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(context, bdropshadowview);
        this.f1633c = scaleGestureDetector;
        bdropshadowview.f2284d = scaleGestureDetector;
        this.f1634d = new GestureDetector(context, new cdropshadowView(this));
    }

    private Bitmap getBlankBitmap() {
        if (this.p == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.f1635e).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            this.p = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
        }
        return this.p;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(this.h);
        canvas.drawBitmap(this.o, 0.0f, 0.0f, new Paint(2));
        canvas.concat(f1632b);
        if (this.i != null) {
            canvas.drawBitmap(this.j, ((float) this.k) * this.m, ((float) this.l) * this.n, this.g);
            canvas.drawBitmap(this.i, 0.0f, 0.0f, this.f);
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            new a(bitmap, true, getWidth(), getHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1633c.onTouchEvent(motionEvent);
        this.f1634d.onTouchEvent(motionEvent);
        return true;
    }

    public void setBgBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.o = bitmap;
        }
        invalidate();
    }

    public void setBgColor(int i2) {
        this.h.setShader(null);
        this.h.setColor(i2);
        invalidate();
    }

    public void setBlurRadius(int i2) {
        if (i2 > 0) {
            this.g.setMaskFilter(new BlurMaskFilter((float) i2, BlurMaskFilter.Blur.NORMAL));
        }
        invalidate();
    }

    public void setScale(float f2) {
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        f1632b.preConcat(matrix);
        invalidate();
    }

    public void setShadowAlpha(int i2) {
        this.g.setAlpha(i2);
        invalidate();
    }

    public void setShadowColor(int i2) {
        this.j.eraseColor(i2);
        invalidate();
    }

    public void setShadowX(int i2) {
        this.m = ((float) i2) / 100.0f;
        invalidate();
    }

    public void setShadowxy(int i2, int i3) {
        this.m = ((float) i2) / 100.0f;
        this.n = ((float) i3) / 100.0f;
        invalidate();
    }

    public void setShadowY(int i2) {
        this.n = ((float) i2) / 100.0f;
        invalidate();
    }

    public void setUserBitmap(Bitmap bitmap) {
        this.i = bitmap;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        this.j = createBitmap;
        createBitmap.eraseColor(ViewCompat.MEASURED_STATE_MASK);
        this.k = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.l = height;
        int i2 = this.k;
        if (i2 > height) {
            this.k = height;
        } else {
            this.l = i2;
        }
        invalidate();
    }
}
