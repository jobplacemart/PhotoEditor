package com.jaydip.dropshadowforinsta.shadowView;

import android.view.GestureDetector;
import android.view.MotionEvent;

public abstract class ddropshadowView implements GestureDetector.OnGestureListener {
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        cdropshadowView cdropshadowview = (cdropshadowView) this;
        DropShadowView dropShadowView = cdropshadowview.f2278b;
        DropShadowView.f1632b.postTranslate(-f, -f2);
        cdropshadowview.f2278b.invalidate();
        return true;
    }
}
