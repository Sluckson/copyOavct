package com.medallia.digital.mobilesdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

/* renamed from: com.medallia.digital.mobilesdk.q3 */
class C3679q3 extends FrameLayout {

    /* renamed from: A */
    private static final int f1638A = 255;

    /* renamed from: B */
    private static final float f1639B = 0.5f;

    /* renamed from: C */
    private static final float f1640C = 2.0E-4f;

    /* renamed from: D */
    private static final float f1641D = 0.002f;

    /* renamed from: E */
    private static final float f1642E = 0.2f;

    /* renamed from: a */
    private float f1643a;

    /* renamed from: b */
    private float f1644b;

    /* renamed from: c */
    private int f1645c;

    /* renamed from: d */
    private int f1646d;

    /* renamed from: e */
    private int f1647e;

    /* renamed from: f */
    private int f1648f;

    /* renamed from: g */
    private float f1649g = 0.0f;

    /* renamed from: h */
    private float f1650h = 0.0f;

    /* renamed from: i */
    private boolean f1651i = true;

    /* renamed from: j */
    private boolean f1652j = false;

    /* renamed from: k */
    private boolean f1653k = true;

    /* renamed from: l */
    private boolean f1654l = true;

    /* renamed from: m */
    private int[] f1655m;

    /* renamed from: n */
    private int[] f1656n;

    /* renamed from: o */
    private int f1657o;

    /* renamed from: p */
    private int f1658p;

    /* renamed from: q */
    private int f1659q;

    /* renamed from: r */
    private NinePatchDrawable f1660r;

    /* renamed from: s */
    private int f1661s;

    /* renamed from: t */
    private NinePatchDrawable f1662t;

    /* renamed from: u */
    private int f1663u;

    /* renamed from: v */
    private NinePatchDrawable f1664v;

    /* renamed from: w */
    private int f1665w;

    /* renamed from: x */
    private NinePatchDrawable f1666x;

    /* renamed from: y */
    private Rect f1667y = new Rect();

    /* renamed from: z */
    private int[] f1668z = new int[2];

    /* renamed from: com.medallia.digital.mobilesdk.q3$a */
    private static class C3680a extends View.BaseSavedState implements Parcelable {
        public static final Parcelable.Creator<C3680a> CREATOR = new C3681a();

        /* renamed from: a */
        float f1669a;

        /* renamed from: b */
        float f1670b;

        /* renamed from: c */
        boolean f1671c;

        /* renamed from: d */
        boolean f1672d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public boolean f1673e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public boolean f1674f;

        /* renamed from: com.medallia.digital.mobilesdk.q3$a$a */
        static class C3681a implements Parcelable.Creator<C3680a> {
            C3681a() {
            }

            public C3680a createFromParcel(Parcel parcel) {
                return new C3680a(parcel);
            }

            public C3680a[] newArray(int i) {
                return new C3680a[i];
            }
        }

        C3680a(Parcel parcel) {
            super(parcel);
            this.f1669a = parcel.readFloat();
            this.f1670b = parcel.readFloat();
            boolean z = true;
            this.f1671c = parcel.readByte() != 0;
            this.f1672d = parcel.readByte() != 0;
            this.f1673e = parcel.readByte() != 0;
            this.f1674f = parcel.readByte() == 0 ? false : z;
        }

        C3680a(Parcelable parcelable) {
            super(parcelable);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f1669a);
            parcel.writeFloat(this.f1670b);
            parcel.writeByte(this.f1671c ? (byte) 1 : 0);
            parcel.writeByte(this.f1672d ? (byte) 1 : 0);
            parcel.writeByte(this.f1673e ? (byte) 1 : 0);
            parcel.writeByte(this.f1674f ? (byte) 1 : 0);
        }
    }

    C3679q3(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3417R.styleable.md_MaterialShadowContainerView, i, i2);
        float dimension = obtainStyledAttributes.getDimension(C3417R.styleable.md_MaterialShadowContainerView_md_shadowTranslationZ, this.f1649g);
        float dimension2 = obtainStyledAttributes.getDimension(C3417R.styleable.md_MaterialShadowContainerView_md_shadowElevation, this.f1650h);
        int resourceId = obtainStyledAttributes.getResourceId(C3417R.styleable.md_MaterialShadowContainerView_md_spotShadowDrawablesList, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(C3417R.styleable.md_MaterialShadowContainerView_md_ambientShadowDrawablesList, 0);
        boolean z = obtainStyledAttributes.getBoolean(C3417R.styleable.md_MaterialShadowContainerView_md_forceUseCompatShadow, this.f1652j);
        boolean z2 = obtainStyledAttributes.getBoolean(C3417R.styleable.md_MaterialShadowContainerView_md_affectsDisplayedPosition, this.f1651i);
        boolean z3 = obtainStyledAttributes.getBoolean(C3417R.styleable.md_MaterialShadowContainerView_md_useAmbientShadow, this.f1653k);
        boolean z4 = obtainStyledAttributes.getBoolean(C3417R.styleable.md_MaterialShadowContainerView_md_useSpotShadow, this.f1654l);
        obtainStyledAttributes.recycle();
        this.f1655m = m1471a(getResources(), resourceId);
        this.f1656n = m1471a(getResources(), resourceId2);
        this.f1657o = m1466a(this.f1655m);
        this.f1658p = m1466a(this.f1656n);
        this.f1643a = getResources().getDisplayMetrics().density;
        this.f1644b = 1.0f / this.f1643a;
        this.f1649g = dimension;
        this.f1650h = dimension2;
        this.f1652j = z;
        this.f1651i = z2;
        this.f1653k = z3;
        this.f1654l = z4;
        m1473e(true);
    }

    /* renamed from: a */
    private static int m1466a(int[] iArr) {
        if (iArr != null) {
            return Math.max(0, iArr.length - 1);
        }
        return 0;
    }

    /* renamed from: a */
    private NinePatchDrawable m1467a(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable instanceof NinePatchDrawable) {
            return (NinePatchDrawable) drawable;
        }
        return null;
    }

    /* renamed from: a */
    private void m1468a(float f, float f2, boolean z) {
        float max = Math.max((f + f2) * this.f1644b, 0.0f);
        int i = (int) max;
        int min = Math.min(i, this.f1657o);
        int i2 = i + 1;
        int min2 = Math.min(i2, this.f1657o);
        int min3 = Math.min(i, this.f1658p);
        int min4 = Math.min(i2, this.f1658p);
        int[] iArr = this.f1655m;
        int i3 = iArr != null ? iArr[min] : 0;
        int[] iArr2 = this.f1655m;
        int i4 = iArr2 != null ? iArr2[min2] : 0;
        int[] iArr3 = this.f1656n;
        int i5 = iArr3 != null ? iArr3[min3] : 0;
        int[] iArr4 = this.f1656n;
        int i6 = iArr4 != null ? iArr4[min4] : 0;
        if (!(!z && i3 == this.f1659q && i4 == this.f1661s && i5 == this.f1663u && i6 == this.f1665w)) {
            if (i3 != this.f1659q) {
                this.f1660r = m1467a(i3);
                this.f1659q = i3;
            }
            NinePatchDrawable ninePatchDrawable = null;
            if (i4 != this.f1661s) {
                this.f1662t = i4 == i3 ? null : m1467a(i4);
                if (i4 == i3) {
                    i4 = 0;
                }
                this.f1661s = i4;
            }
            if (i5 != this.f1663u) {
                this.f1664v = m1467a(i5);
                this.f1663u = i5;
            }
            if (i6 != this.f1665w) {
                if (i6 != i5) {
                    ninePatchDrawable = m1467a(i6);
                }
                this.f1666x = ninePatchDrawable;
                if (i6 == i5) {
                    i6 = 0;
                }
                this.f1665w = i6;
            }
            m1477j();
            m1478k();
            m1479l();
        }
        int min5 = 255 - Math.min(Math.max((int) (((max - ((float) i)) * 255.0f) + 0.5f), 0), 255);
        int i7 = 255 - min5;
        NinePatchDrawable ninePatchDrawable2 = this.f1660r;
        if (ninePatchDrawable2 != null) {
            if (this.f1662t != null) {
                ninePatchDrawable2.setAlpha(min5);
            } else {
                ninePatchDrawable2.setAlpha(255);
            }
        }
        NinePatchDrawable ninePatchDrawable3 = this.f1662t;
        if (ninePatchDrawable3 != null) {
            ninePatchDrawable3.setAlpha(i7);
        }
        NinePatchDrawable ninePatchDrawable4 = this.f1664v;
        if (ninePatchDrawable4 != null) {
            if (this.f1666x != null) {
                ninePatchDrawable4.setAlpha(min5);
            } else {
                ninePatchDrawable4.setAlpha(255);
            }
        }
        NinePatchDrawable ninePatchDrawable5 = this.f1666x;
        if (ninePatchDrawable5 != null) {
            ninePatchDrawable5.setAlpha(i7);
        }
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* renamed from: a */
    private void m1469a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int min = Math.min(1, getChildCount());
        boolean z = (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) ? false : true;
        View view = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < min; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                View view2 = view;
                measureChildWithMargins(childAt, i, 0, i2, 0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int max = Math.max(i5, childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
                int max2 = Math.max(i6, childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
                int measuredState = childAt.getMeasuredState() | i7;
                if (!z || !(layoutParams.width == -1 || layoutParams.height == -1)) {
                    i5 = max;
                    i6 = max2;
                    i7 = measuredState;
                    view = view2;
                } else {
                    i5 = max;
                    i6 = max2;
                    i7 = measuredState;
                    view = childAt;
                }
            } else {
                View view3 = view;
            }
        }
        View view4 = view;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int max3 = Math.max(i6 + paddingTop, getSuggestedMinimumHeight());
        int max4 = Math.max(i5 + paddingLeft, getSuggestedMinimumWidth());
        Drawable foreground = getForeground();
        if (foreground != null) {
            max3 = Math.max(max3, foreground.getMinimumHeight());
            max4 = Math.max(max4, foreground.getMinimumWidth());
        }
        setMeasuredDimension(FrameLayout.resolveSizeAndState(max4, i3, i7), FrameLayout.resolveSizeAndState(max3, i4, i7 << 16));
        View view5 = view4;
        if (view5 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view5.getLayoutParams();
            view5.measure(marginLayoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec(((getMeasuredWidth() - paddingLeft) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824) : FrameLayout.getChildMeasureSpec(i3, paddingLeft + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), marginLayoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec(((getMeasuredHeight() - paddingTop) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824) : FrameLayout.getChildMeasureSpec(i4, paddingTop + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        }
    }

    /* renamed from: a */
    private void m1470a(NinePatchDrawable ninePatchDrawable, int i, int i2, int i3, int i4) {
        if (ninePatchDrawable != null) {
            Rect rect = this.f1667y;
            ninePatchDrawable.getPadding(rect);
            ninePatchDrawable.setBounds(i - rect.left, i2 - rect.top, i3 + rect.right, i4 + rect.bottom);
        }
    }

    /* renamed from: a */
    private int[] m1471a(Resources resources, int i) {
        if (i == 0 || isInEditMode()) {
            return null;
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        int[] iArr = new int[obtainTypedArray.length()];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = obtainTypedArray.getResourceId(i2, 0);
        }
        obtainTypedArray.recycle();
        return iArr;
    }

    /* renamed from: b */
    private void m1472b(float f, float f2, boolean z) {
        View view = null;
        if (z) {
            this.f1660r = null;
            this.f1659q = 0;
            this.f1662t = null;
            this.f1661s = 0;
            this.f1664v = null;
            this.f1663u = 0;
            this.f1666x = null;
            this.f1665w = 0;
            m1479l();
        }
        if (getChildCount() > 0) {
            view = getChildAt(0);
        }
        if (view != null) {
            ViewCompat.setTranslationZ(view, f);
            ViewCompat.setElevation(view, f2);
        }
    }

    /* renamed from: e */
    private void m1473e(boolean z) {
        if (mo55721e()) {
            m1468a(this.f1649g, this.f1650h, z);
        } else {
            m1472b(this.f1649g, this.f1650h, z);
        }
    }

    @SuppressLint({"RtlHardcoded"})
    /* renamed from: g */
    private void m1474g() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (layoutParams.gravity == -1) {
                layoutParams.gravity = 51;
            }
            childAt.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: h */
    private boolean m1475h() {
        return Build.VERSION.SDK_INT < 11 && !isInEditMode();
    }

    /* renamed from: i */
    public static boolean m1476i() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* renamed from: j */
    private void m1477j() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int top = childAt.getTop();
            int right = childAt.getRight();
            int bottom = childAt.getBottom();
            m1470a(this.f1660r, left, top, right, bottom);
            NinePatchDrawable ninePatchDrawable = this.f1664v;
            NinePatchDrawable ninePatchDrawable2 = this.f1662t;
            if (ninePatchDrawable != ninePatchDrawable2) {
                m1470a(ninePatchDrawable2, left, top, right, bottom);
            }
            m1470a(this.f1664v, left, top, right, bottom);
            NinePatchDrawable ninePatchDrawable3 = this.f1664v;
            NinePatchDrawable ninePatchDrawable4 = this.f1666x;
            if (ninePatchDrawable3 != ninePatchDrawable4) {
                m1470a(ninePatchDrawable4, left, top, right, bottom);
            }
        }
    }

    /* renamed from: k */
    private void m1478k() {
        float f;
        float f2;
        if (getChildCount() >= 1) {
            View childAt = getChildAt(0);
            childAt.getWindowVisibleDisplayFrame(this.f1667y);
            this.f1645c = this.f1667y.width() / 2;
            this.f1646d = 0;
            childAt.getLocationInWindow(this.f1668z);
            float f3 = this.f1649g + this.f1650h;
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (this.f1651i) {
                int width = childAt.getWidth();
                int height = childAt.getHeight();
                int[] iArr = this.f1668z;
                int i = iArr[1] + (height / 2);
                f2 = ((float) Math.sqrt((double) (((float) ((iArr[0] + (width / 2)) - this.f1645c)) * this.f1644b * f1640C))) * f3;
                f = (float) Math.sqrt((double) (((float) (i - this.f1646d)) * this.f1644b * 0.002f));
            } else {
                f2 = 0.0f;
                f = this.f1643a * 0.2f;
            }
            this.f1647e = (int) (f2 + translationX + 0.5f);
            this.f1648f = (int) ((f * f3) + translationY + 0.5f);
        }
    }

    /* renamed from: l */
    private boolean m1479l() {
        boolean z = true;
        boolean z2 = this.f1653k && !(this.f1664v == null && this.f1666x == null);
        boolean z3 = this.f1654l && !(this.f1660r == null && this.f1662t == null);
        if (z2 || z3 || getBackground() != null || getForeground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        return z;
    }

    /* renamed from: a */
    public float mo55711a() {
        return this.f1650h;
    }

    /* renamed from: a */
    public void mo55712a(float f) {
        if (this.f1650h != f) {
            this.f1650h = f;
            m1473e(false);
        }
    }

    /* renamed from: a */
    public void mo55713a(boolean z) {
        if (this.f1651i != z) {
            this.f1651i = z;
            if (mo55721e()) {
                m1473e(true);
            }
        }
    }

    /* renamed from: b */
    public float mo55714b() {
        return this.f1649g;
    }

    /* renamed from: b */
    public void mo55715b(float f) {
        if (this.f1649g != f) {
            this.f1649g = f;
            m1473e(false);
        }
    }

    /* renamed from: b */
    public void mo55716b(boolean z) {
        if (this.f1652j != z) {
            boolean e = mo55721e();
            this.f1652j = z;
            boolean e2 = mo55721e();
            if (e != e2) {
                if (e2 && m1476i()) {
                    m1472b(0.0f, 0.0f, true);
                }
                m1473e(true);
            }
        }
    }

    /* renamed from: c */
    public void mo55717c(boolean z) {
        if (this.f1653k != z) {
            this.f1653k = z;
            if (!m1479l()) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    /* renamed from: c */
    public boolean mo55718c() {
        return this.f1651i;
    }

    /* renamed from: d */
    public void mo55719d(boolean z) {
        if (this.f1654l != z) {
            this.f1654l = z;
            if (!m1479l()) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    /* renamed from: d */
    public boolean mo55720d() {
        return this.f1653k;
    }

    /* renamed from: e */
    public boolean mo55721e() {
        if (!m1476i()) {
            return true;
        }
        return this.f1652j;
    }

    /* renamed from: f */
    public boolean mo55722f() {
        return this.f1654l;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getChildCount() > 0 && getChildAt(0).getVisibility() == 0) {
            if (this.f1653k) {
                NinePatchDrawable ninePatchDrawable = this.f1664v;
                if (ninePatchDrawable != null) {
                    ninePatchDrawable.draw(canvas);
                }
                NinePatchDrawable ninePatchDrawable2 = this.f1666x;
                if (ninePatchDrawable2 != null) {
                    ninePatchDrawable2.draw(canvas);
                }
            }
            if (!this.f1654l) {
                return;
            }
            if (this.f1660r != null || this.f1662t != null) {
                int save = canvas.save();
                canvas.translate((float) this.f1647e, (float) this.f1648f);
                NinePatchDrawable ninePatchDrawable3 = this.f1660r;
                if (ninePatchDrawable3 != null) {
                    ninePatchDrawable3.draw(canvas);
                }
                NinePatchDrawable ninePatchDrawable4 = this.f1662t;
                if (ninePatchDrawable4 != null) {
                    ninePatchDrawable4.draw(canvas);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m1477j();
        m1478k();
        if (m1475h()) {
            m1474g();
        }
        if (!mo55721e()) {
            m1472b(this.f1649g, this.f1650h, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (m1475h()) {
            m1469a(i, i2);
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C3680a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C3680a aVar = (C3680a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.f1650h = aVar.f1670b;
        this.f1649g = aVar.f1669a;
        this.f1651i = aVar.f1671c;
        this.f1652j = aVar.f1672d;
        this.f1653k = aVar.f1673e;
        this.f1654l = aVar.f1674f;
        m1473e(true);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C3680a aVar = new C3680a(super.onSaveInstanceState());
        aVar.f1670b = this.f1650h;
        aVar.f1669a = this.f1649g;
        aVar.f1671c = this.f1651i;
        aVar.f1672d = this.f1652j;
        boolean unused = aVar.f1673e = this.f1653k;
        boolean unused2 = aVar.f1674f = this.f1654l;
        return aVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m1477j();
        m1478k();
    }
}
