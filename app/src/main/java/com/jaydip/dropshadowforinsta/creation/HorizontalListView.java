//package com.jaydip.storymakerforinsta.creation;
//
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.database.DataSetObserver;
//import android.graphics.Canvas;
//import android.graphics.Rect;
//import android.graphics.drawable.Drawable;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Parcelable;
//import android.util.AttributeSet;
//import android.view.GestureDetector;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.ScrollView;
//import android.widget.Scroller;
//import androidx.appcompat.widget.ActivityChooserView;
////import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
//import androidx.core.view.ViewCompat;
//import androidx.core.widget.EdgeEffectCompat;
//import com.jaydip.storymakerforinsta.R;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class HorizontalListView extends AdapterView<ListAdapter> {
//    private boolean f15594A = false;
//    private boolean f15595B = false;
//    private OnClickListener f15596C;
//    private DataSetObserver f15597D = new C32382(this);
//    private Runnable f15598E = new C32393(this);
//    protected Scroller f15599a = new Scroller(getContext());
//    protected ListAdapter f15600b;
//    protected int f15601c;
//    protected int f15602d;
//    private final C3240a f15603e;
//    private GestureDetector f15604f;
//    private int f15605g;
//    private List<Queue<View>> f15606h;
//    private boolean f15607i;
//    private Rect f15608j;
//    private View f15609k;
//    private int f15610l;
//    private Drawable f15611m;
//    private Integer f15612n;
//    private int f15613o;
//    private int f15614p;
//    private int f15615q;
//    private int f15616r;
//    private C3245e f15617s;
//    private int f15618t;
//    private boolean f15619u;
//    private C3244d f15620v;
//    private C3244d.C3243a f15621w;
//    private EdgeEffectCompat f15622x;
//    private EdgeEffectCompat f15623y;
//    private int f15624z;
//
//    public interface C3244d {
//
//        public enum C3243a {
//            SCROLL_STATE_IDLE,
//            SCROLL_STATE_TOUCH_SCROLL,
//            SCROLL_STATE_FLING
//        }
//
//        void m19419a(C3243a c3243a);
//    }
//
//    public interface C3245e {
//        void m19420a();
//    }
//
//    public void dispatchSetPressed(boolean z) {
//    }
//
//    public class C32371 implements OnTouchListener {
//        final HorizontalListView f15586a;
//
//        C32371(HorizontalListView horizontalListView) {
//            this.f15586a = horizontalListView;
//        }
//
//        public boolean onTouch(View view, MotionEvent motionEvent) {
//            return this.f15586a.f15604f.onTouchEvent(motionEvent);
//        }
//    }
//
//    class C32382 extends DataSetObserver {
//        final HorizontalListView f15587a;
//
//        C32382(HorizontalListView horizontalListView) {
//            this.f15587a = horizontalListView;
//        }
//
//        public void onChanged() {
//            this.f15587a.f15607i = true;
//            this.f15587a.f15619u = false;
//            this.f15587a.m19455f();
//            this.f15587a.invalidate();
//            this.f15587a.requestLayout();
//        }
//
//        public void onInvalidated() {
//            this.f15587a.f15619u = false;
//            this.f15587a.m19455f();
//            this.f15587a.m19445c();
//            this.f15587a.invalidate();
//            this.f15587a.requestLayout();
//        }
//    }
//
//    class C32393 implements Runnable {
//        final HorizontalListView f15588a;
//
//        C32393(HorizontalListView horizontalListView) {
//            this.f15588a = horizontalListView;
//        }
//
//        public void run() {
//            this.f15588a.requestLayout();
//        }
//    }
//
//    private class C3240a extends GestureDetector.SimpleOnGestureListener {
//        final HorizontalListView f15589a;
//
//        private C3240a(HorizontalListView horizontalListView) {
//            this.f15589a = horizontalListView;
//        }
//
//        public boolean onDown(MotionEvent motionEvent) {
//            return this.f15589a.m19463a(motionEvent);
//        }
//
//        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
//            return this.f15589a.m19464a(motionEvent, motionEvent2, f, f2);
//        }
//
//        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
//            this.f15589a.m19432a(true);
//            this.f15589a.setCurrentScrollState(C3244d.C3243a.SCROLL_STATE_TOUCH_SCROLL);
//            this.f15589a.m19455f();
//            this.f15589a.f15602d += (int) f;
//            this.f15589a.m19461i(Math.round(f));
//            this.f15589a.requestLayout();
//            return true;
//        }
//
//        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
//            this.f15589a.m19455f();
//            OnItemClickListener onItemClickListener = this.f15589a.getOnItemClickListener();
//            int m19444c = this.f15589a.m19444c((int) motionEvent.getX(), (int) motionEvent.getY());
//            if (m19444c >= 0 && !this.f15589a.f15594A) {
//                View childAt = this.f15589a.getChildAt(m19444c);
//                int i = this.f15589a.f15614p + m19444c;
//                if (onItemClickListener != null) {
//                    HorizontalListView horizontalListView = this.f15589a;
//                    onItemClickListener.onItemClick(horizontalListView, childAt, i, horizontalListView.f15600b.getItemId(i));
//                    return true;
//                }
//            }
//            if (this.f15589a.f15596C != null && !this.f15589a.f15594A) {
//                this.f15589a.f15596C.onClick(this.f15589a);
//            }
//            return false;
//        }
//
//        public void onLongPress(MotionEvent motionEvent) {
//            this.f15589a.m19455f();
//            int m19444c = this.f15589a.m19444c((int) motionEvent.getX(), (int) motionEvent.getY());
//            if (m19444c >= 0 && !this.f15589a.f15594A) {
//                View childAt = this.f15589a.getChildAt(m19444c);
//                OnItemLongClickListener onItemLongClickListener = this.f15589a.getOnItemLongClickListener();
//                if (onItemLongClickListener != null) {
//                    int i = this.f15589a.f15614p + m19444c;
//                    HorizontalListView horizontalListView = this.f15589a;
//                    if (onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i, horizontalListView.f15600b.getItemId(i))) {
//                        this.f15589a.performHapticFeedback(0);
//                    }
//                }
//            }
//        }
//    }
//
//    private static final class C3241b {
//        private C3241b() {
//        }
//
//        static {
//            if (Build.VERSION.SDK_INT < 11) {
//                throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
//            }
//        }
//
//        public static void m19417a(Scroller scroller, float f) {
//            if (scroller != null) {
//                scroller.setFriction(f);
//            }
//        }
//    }
//
//    public static final class C3242c {
//        private C3242c() {
//        }
//
//        static {
//            if (Build.VERSION.SDK_INT < 14) {
//                throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
//            }
//        }
//
//        public static float m19418a(Scroller scroller) {
//            return scroller.getCurrVelocity();
//        }
//    }
//
//    public HorizontalListView(Context context, AttributeSet attributeSet) {
//        super(context, attributeSet);
//        C3240a c3240a = new C3240a(this);
//        this.f15603e = c3240a;
//        this.f15606h = new ArrayList();
//        this.f15607i = false;
//        this.f15608j = new Rect();
//        this.f15609k = null;
//        this.f15610l = 0;
//        this.f15611m = null;
//        this.f15612n = null;
//        this.f15613o = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
//        this.f15617s = null;
//        this.f15618t = 0;
//        this.f15619u = false;
//        this.f15620v = null;
//        this.f15621w = C3244d.C3243a.SCROLL_STATE_IDLE;
//        this.f15622x = new EdgeEffectCompat(context);
//        this.f15623y = new EdgeEffectCompat(context);
//        this.f15604f = new GestureDetector(context, c3240a);
//        m19423a();
//        m19439b();
//        m19427a(context, attributeSet);
//        setWillNotDraw(false);
//        if (Build.VERSION.SDK_INT >= 11) {
//            C3241b.m19417a(this.f15599a, 0.009f);
//        }
//    }
//
//    private void m19423a() {
//        setOnTouchListener(new C32371(this));
//    }
//
//    /* access modifiers changed from: private */
//    /* access modifiers changed from: public */
//    private void m19432a(Boolean bool) {
//        if (this.f15595B != bool.booleanValue()) {
//            for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
//                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
//                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
//                    this.f15595B = bool.booleanValue();
//                    return;
//                }
//            }
//        }
//    }
//
//    private void m19427a(Context context, AttributeSet attributeSet) {
//        if (attributeSet != null) {
//            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalListView);
//            Drawable drawable = obtainStyledAttributes.getDrawable(1);
//            if (drawable != null) {
//                setDivider(drawable);
//            }
//            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, 0);
//            if (dimensionPixelSize != 0) {
//                setDividerWidth(dimensionPixelSize);
//            }
//            obtainStyledAttributes.recycle();
//        }
//    }
//
//    public Parcelable onSaveInstanceState() {
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
//        bundle.putInt("BUNDLE_ID_CURRENT_X", this.f15601c);
//        return bundle;
//    }
//
//    public void onRestoreInstanceState(Parcelable parcelable) {
//        if (parcelable instanceof Bundle) {
//            Bundle bundle = (Bundle) parcelable;
//            this.f15612n = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
//            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
//        }
//    }
//
//    public void setDivider(Drawable drawable) {
//        this.f15611m = drawable;
//        if (drawable != null) {
//            setDividerWidth(drawable.getIntrinsicWidth());
//        } else {
//            setDividerWidth(0);
//        }
//    }
//
//    public void setDividerWidth(int i) {
//        this.f15610l = i;
//        requestLayout();
//        invalidate();
//    }
//
//    private void m19439b() {
//        this.f15614p = -1;
//        this.f15615q = -1;
//        this.f15605g = 0;
//        this.f15601c = 0;
//        this.f15602d = 0;
//        this.f15613o = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
//        setCurrentScrollState(C3244d.C3243a.SCROLL_STATE_IDLE);
//    }
//
//    /* access modifiers changed from: private */
//    /* access modifiers changed from: public */
//    private void m19445c() {
//        m19439b();
//        removeAllViewsInLayout();
//        requestLayout();
//    }
//
//    public void setSelection(int i) {
//        this.f15616r = i;
//    }
//
//    public View getSelectedView() {
//        return m19457g(this.f15616r);
//    }
//
//    public void setAdapter(ListAdapter listAdapter) {
//        ListAdapter listAdapter2 = this.f15600b;
//        if (listAdapter2 != null) {
//            listAdapter2.unregisterDataSetObserver(this.f15597D);
//        }
//        if (listAdapter != null) {
//            this.f15619u = false;
//            this.f15600b = listAdapter;
//            listAdapter.registerDataSetObserver(this.f15597D);
//        }
//        m19424a(this.f15600b.getViewTypeCount());
//        m19445c();
//    }
//
//    @Override // android.widget.AdapterView
//    public ListAdapter getAdapter() {
//        return this.f15600b;
//    }
//
//    private void m19424a(int i) {
//        this.f15606h.clear();
//        for (int i2 = 0; i2 < i; i2++) {
//            this.f15606h.add(new LinkedList());
//        }
//    }
//
//    private View m19437b(int i) {
//        int itemViewType = this.f15600b.getItemViewType(i);
//        if (m19447c(itemViewType)) {
//            return this.f15606h.get(itemViewType).poll();
//        }
//        return null;
//    }
//
//    private void m19426a(int i, View view) {
//        int itemViewType = this.f15600b.getItemViewType(i);
//        if (m19447c(itemViewType)) {
//            this.f15606h.get(itemViewType).offer(view);
//        }
//    }
//
//    private boolean m19447c(int i) {
//        return i < this.f15606h.size();
//    }
//
//    private void m19431a(View view, int i) {
//        addViewInLayout(view, i, m19438b(view), true);
//        m19430a(view);
//    }
//
//    private void m19430a(View view) {
//        int i;
//        LayoutParams m19438b = m19438b(view);
//        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f15624z, getPaddingTop() + getPaddingBottom(), m19438b.height);
//        if (m19438b.width > 0) {
//            i = MeasureSpec.makeMeasureSpec(m19438b.width, BasicMeasure.EXACTLY);
//        } else {
//            i = MeasureSpec.makeMeasureSpec(0, 0);
//        }
//        view.measure(i, childMeasureSpec);
//    }
//
//    private LayoutParams m19438b(View view) {
//        LayoutParams layoutParams = view.getLayoutParams();
//        return layoutParams == null ? new LayoutParams(-2, -1) : layoutParams;
//    }
//
//    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
//        super.onLayout(z, i, i2, i3, i4);
//        if (this.f15600b != null) {
//            invalidate();
//            if (this.f15607i) {
//                int i5 = this.f15601c;
//                m19439b();
//                removeAllViewsInLayout();
//                this.f15602d = i5;
//                this.f15607i = false;
//            }
//            Integer num = this.f15612n;
//            if (num != null) {
//                this.f15602d = num.intValue();
//                this.f15612n = null;
//            }
//            if (this.f15599a.computeScrollOffset()) {
//                this.f15602d = this.f15599a.getCurrX();
//            }
//            int i6 = this.f15602d;
//            if (i6 < 0) {
//                this.f15602d = 0;
//                if (this.f15622x.isFinished()) {
//                    this.f15622x.onAbsorb((int) m19448d());
//                }
//                this.f15599a.forceFinished(true);
//                setCurrentScrollState(C3244d.C3243a.SCROLL_STATE_IDLE);
//            } else {
//                int i7 = this.f15613o;
//                if (i6 > i7) {
//                    this.f15602d = i7;
//                    if (this.f15623y.isFinished()) {
//                        this.f15623y.onAbsorb((int) m19448d());
//                    }
//                    this.f15599a.forceFinished(true);
//                    setCurrentScrollState(C3244d.C3243a.SCROLL_STATE_IDLE);
//                }
//            }
//            int i8 = this.f15601c - this.f15602d;
//            m19452e(i8);
//            m19449d(i8);
//            m19456f(i8);
//            this.f15601c = this.f15602d;
//            if (m19453e()) {
//                onLayout(z, i, i2, i3, i4);
//            } else if (!this.f15599a.isFinished()) {
//                ViewCompat.postOnAnimation(this, this.f15598E);
//            } else if (this.f15621w == C3244d.C3243a.SCROLL_STATE_FLING) {
//                setCurrentScrollState(C3244d.C3243a.SCROLL_STATE_IDLE);
//            }
//        }
//    }
//
//    public float getLeftFadingEdgeStrength() {
//        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
//        int i = this.f15601c;
//        if (i == 0) {
//            return 0.0f;
//        }
//        if (i < horizontalFadingEdgeLength) {
//            return ((float) i) / ((float) horizontalFadingEdgeLength);
//        }
//        return 1.0f;
//    }
//
//    public float getRightFadingEdgeStrength() {
//        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
//        int i = this.f15601c;
//        int i2 = this.f15613o;
//        if (i == i2) {
//            return 0.0f;
//        }
//        int i3 = i2 - i;
//        if (i3 < horizontalFadingEdgeLength) {
//            return ((float) i3) / ((float) horizontalFadingEdgeLength);
//        }
//        return 1.0f;
//    }
//
//    private float m19448d() {
//        if (Build.VERSION.SDK_INT >= 14) {
//            return C3242c.m19418a(this.f15599a);
//        }
//        return 30.0f;
//    }
//
//    public void onMeasure(int i, int i2) {
//        super.onMeasure(i, i2);
//        this.f15624z = i2;
//    }
//
//    private boolean m19453e() {
//        View rightmostChild;
//        if (m19460h(this.f15615q) && (rightmostChild = getRightmostChild()) != null) {
//            int i = this.f15613o;
//            int right = ((rightmostChild.getRight() - getPaddingLeft()) + this.f15601c) - getRenderWidth();
//            this.f15613o = right;
//            if (right < 0) {
//                this.f15613o = 0;
//            }
//            if (this.f15613o != i) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void m19449d(int i) {
//        View rightmostChild = getRightmostChild();
//        int i2 = 0;
//        m19425a(rightmostChild != null ? rightmostChild.getRight() : 0, i);
//        View leftmostChild = getLeftmostChild();
//        if (leftmostChild != null) {
//            i2 = leftmostChild.getLeft();
//        }
//        m19440b(i2, i);
//    }
//
//    private void m19452e(int i) {
//        int i2;
//        View leftmostChild = getLeftmostChild();
//        while (leftmostChild != null && leftmostChild.getRight() + i <= 0) {
//            int i3 = this.f15605g;
//            if (m19460h(this.f15614p)) {
//                i2 = leftmostChild.getMeasuredWidth();
//            } else {
//                i2 = this.f15610l + leftmostChild.getMeasuredWidth();
//            }
//            this.f15605g = i2 + i3;
//            m19426a(this.f15614p, leftmostChild);
//            removeViewInLayout(leftmostChild);
//            this.f15614p++;
//            leftmostChild = getLeftmostChild();
//        }
//        View rightmostChild = getRightmostChild();
//        while (rightmostChild != null && rightmostChild.getLeft() + i >= getWidth()) {
//            m19426a(this.f15615q, rightmostChild);
//            removeViewInLayout(rightmostChild);
//            this.f15615q--;
//            rightmostChild = getRightmostChild();
//        }
//    }
//
//    private void m19425a(int i, int i2) {
//        while (i + i2 + this.f15610l < getWidth() && this.f15615q + 1 < this.f15600b.getCount()) {
//            int i3 = this.f15615q + 1;
//            this.f15615q = i3;
//            if (this.f15614p < 0) {
//                this.f15614p = i3;
//            }
//            View view = this.f15600b.getView(i3, m19437b(i3), this);
//            m19431a(view, -1);
//            i += (this.f15615q == 0 ? 0 : this.f15610l) + view.getMeasuredWidth();
//            m19459h();
//        }
//    }
//
//    private void m19440b(int i, int i2) {
//        int i3;
//        while ((i + i2) - this.f15610l > 0 && (i3 = this.f15614p) >= 1) {
//            int i4 = i3 - 1;
//            this.f15614p = i4;
//            View view = this.f15600b.getView(i4, m19437b(i4), this);
//            m19431a(view, 0);
//            i -= this.f15614p == 0 ? view.getMeasuredWidth() : this.f15610l + view.getMeasuredWidth();
//            int i5 = this.f15605g;
//            int i6 = i + i2;
//            int measuredWidth = view.getMeasuredWidth();
//            if (i6 != 0) {
//                measuredWidth += this.f15610l;
//            }
//            this.f15605g = i5 - measuredWidth;
//        }
//    }
//
//    private void m19456f(int i) {
//        int childCount = getChildCount();
//        if (childCount > 0) {
//            int i2 = this.f15605g + i;
//            this.f15605g = i2;
//            for (int i3 = 0; i3 < childCount; i3++) {
//                View childAt = getChildAt(i3);
//                int paddingLeft = getPaddingLeft() + i2;
//                int paddingTop = getPaddingTop();
//                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
//                i2 += childAt.getMeasuredWidth() + this.f15610l;
//            }
//        }
//    }
//
//    private View getLeftmostChild() {
//        return getChildAt(0);
//    }
//
//    private View getRightmostChild() {
//        return getChildAt(getChildCount() - 1);
//    }
//
//    private View m19457g(int i) {
//        int i2 = this.f15614p;
//        if (i < i2 || i > this.f15615q) {
//            return null;
//        }
//        return getChildAt(i - i2);
//    }
//
//    /* access modifiers changed from: private */
//    /* access modifiers changed from: public */
//    private int m19444c(int i, int i2) {
//        int childCount = getChildCount();
//        for (int i3 = 0; i3 < childCount; i3++) {
//            getChildAt(i3).getHitRect(this.f15608j);
//            if (this.f15608j.contains(i, i2)) {
//                return i3;
//            }
//        }
//        return -1;
//    }
//
//    private boolean m19460h(int i) {
//        return i == this.f15600b.getCount() + -1;
//    }
//
//    private int getRenderHeight() {
//        return (getHeight() - getPaddingTop()) - getPaddingBottom();
//    }
//
//    private int getRenderWidth() {
//        return (getWidth() - getPaddingLeft()) - getPaddingRight();
//    }
//
//    public int getFirstVisiblePosition() {
//        return this.f15614p;
//    }
//
//    public int getLastVisiblePosition() {
//        return this.f15615q;
//    }
//
//    private void m19428a(Canvas canvas) {
//        EdgeEffectCompat edgeEffectCompat = this.f15622x;
//        if (edgeEffectCompat == null || edgeEffectCompat.isFinished() || !m19462i()) {
//            EdgeEffectCompat edgeEffectCompat2 = this.f15623y;
//            if (edgeEffectCompat2 != null && !edgeEffectCompat2.isFinished() && m19462i()) {
//                int save = canvas.save();
//                int width = getWidth();
//                canvas.rotate(90.0f, 0.0f, 0.0f);
//                canvas.translate((float) getPaddingTop(), (float) (-width));
//                this.f15623y.setSize(getRenderHeight(), getRenderWidth());
//                if (this.f15623y.draw(canvas)) {
//                    invalidate();
//                }
//                canvas.restoreToCount(save);
//                return;
//            }
//            return;
//        }
//        int save2 = canvas.save();
//        int height = getHeight();
//        canvas.rotate(-90.0f, 0.0f, 0.0f);
//        canvas.translate((float) ((-height) + getPaddingBottom()), 0.0f);
//        this.f15622x.setSize(getRenderHeight(), getRenderWidth());
//        if (this.f15622x.draw(canvas)) {
//            invalidate();
//        }
//        canvas.restoreToCount(save2);
//    }
//
//    private void m19441b(Canvas canvas) {
//        int childCount = getChildCount();
//        Rect rect = this.f15608j;
//        rect.top = getPaddingTop();
//        Rect rect2 = this.f15608j;
//        rect2.bottom = rect2.top + getRenderHeight();
//        for (int i = 0; i < childCount; i++) {
//            if (i != childCount - 1 || !m19460h(this.f15615q)) {
//                View childAt = getChildAt(i);
//                rect.left = childAt.getRight();
//                rect.right = childAt.getRight() + this.f15610l;
//                if (rect.left < getPaddingLeft()) {
//                    rect.left = getPaddingLeft();
//                }
//                if (rect.right > getWidth() - getPaddingRight()) {
//                    rect.right = getWidth() - getPaddingRight();
//                }
//                m19429a(canvas, rect);
//                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
//                    rect.left = getPaddingLeft();
//                    rect.right = childAt.getLeft();
//                    m19429a(canvas, rect);
//                }
//            }
//        }
//    }
//
//    private void m19429a(Canvas canvas, Rect rect) {
//        Drawable drawable = this.f15611m;
//        if (drawable != null) {
//            drawable.setBounds(rect);
//            this.f15611m.draw(canvas);
//        }
//    }
//
//    public void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        m19441b(canvas);
//    }
//
//    public void dispatchDraw(Canvas canvas) {
//        super.dispatchDraw(canvas);
//        m19428a(canvas);
//    }
//
//    public boolean m19464a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
//        this.f15599a.fling(this.f15602d, 0, (int) (-f), 0, 0, this.f15613o, 0, 0);
//        setCurrentScrollState(C3244d.C3243a.SCROLL_STATE_FLING);
//        requestLayout();
//        return true;
//    }
//
//    public boolean m19463a(MotionEvent motionEvent) {
//        int m19444c;
//        this.f15594A = !this.f15599a.isFinished();
//        this.f15599a.forceFinished(true);
//        setCurrentScrollState(C3244d.C3243a.SCROLL_STATE_IDLE);
//        m19455f();
//        if (!this.f15594A && (m19444c = m19444c((int) motionEvent.getX(), (int) motionEvent.getY())) >= 0) {
//            View childAt = getChildAt(m19444c);
//            this.f15609k = childAt;
//            if (childAt != null) {
//                childAt.setPressed(true);
//                refreshDrawableState();
//            }
//        }
//        return true;
//    }
//
//    /* access modifiers changed from: private */
//    /* access modifiers changed from: public */
//    private void m19455f() {
//        View view = this.f15609k;
//        if (view != null) {
//            view.setPressed(false);
//            refreshDrawableState();
//            this.f15609k = null;
//        }
//    }
//
//    public boolean onTouchEvent(MotionEvent motionEvent) {
//        if (motionEvent.getAction() == 1) {
//            Scroller scroller = this.f15599a;
//            if (scroller == null || scroller.isFinished()) {
//                setCurrentScrollState(C3244d.C3243a.SCROLL_STATE_IDLE);
//            }
//            m19432a(false);
//            m19458g();
//        } else if (motionEvent.getAction() == 3) {
//            m19455f();
//            m19458g();
//            m19432a(false);
//        }
//        return super.onTouchEvent(motionEvent);
//    }
//
//    private void m19458g() {
//        EdgeEffectCompat edgeEffectCompat = this.f15622x;
//        if (edgeEffectCompat != null) {
//            edgeEffectCompat.onRelease();
//        }
//        EdgeEffectCompat edgeEffectCompat2 = this.f15623y;
//        if (edgeEffectCompat2 != null) {
//            edgeEffectCompat2.onRelease();
//        }
//    }
//
//    private void m19459h() {
//        ListAdapter listAdapter;
//        if (this.f15617s != null && (listAdapter = this.f15600b) != null && listAdapter.getCount() - (this.f15615q + 1) < this.f15618t && !this.f15619u) {
//            this.f15619u = true;
//            this.f15617s.m19420a();
//        }
//    }
//
//    public void setOnClickListener(OnClickListener onClickListener) {
//        this.f15596C = onClickListener;
//    }
//
//    public void setOnScrollStateChangedListener(C3244d c3244d) {
//        this.f15620v = c3244d;
//    }
//
//    /* access modifiers changed from: private */
//    /* access modifiers changed from: public */
//    private void setCurrentScrollState(C3244d.C3243a c3243a) {
//        C3244d c3244d;
//        if (!(this.f15621w == c3243a || (c3244d = this.f15620v) == null)) {
//            c3244d.m19419a(c3243a);
//        }
//        this.f15621w = c3243a;
//    }
//
//    /* access modifiers changed from: private */
//    /* access modifiers changed from: public */
//    private void m19461i(int i) {
//        if (this.f15622x != null && this.f15623y != null) {
//            int i2 = this.f15601c + i;
//            Scroller scroller = this.f15599a;
//            if (scroller != null && !scroller.isFinished()) {
//                return;
//            }
//            if (i2 < 0) {
//                this.f15622x.onPull(((float) Math.abs(i)) / ((float) getRenderWidth()));
//                if (!this.f15623y.isFinished()) {
//                    this.f15623y.onRelease();
//                }
//            } else if (i2 > this.f15613o) {
//                this.f15623y.onPull(((float) Math.abs(i)) / ((float) getRenderWidth()));
//                if (!this.f15622x.isFinished()) {
//                    this.f15622x.onRelease();
//                }
//            }
//        }
//    }
//
//    private boolean m19462i() {
//        ListAdapter listAdapter = this.f15600b;
//        return listAdapter != null && !listAdapter.isEmpty() && this.f15613o > 0;
//    }
//}
