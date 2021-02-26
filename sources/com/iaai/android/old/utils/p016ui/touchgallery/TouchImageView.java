package com.iaai.android.old.utils.p016ui.touchgallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"NewApi"})
/* renamed from: com.iaai.android.old.utils.ui.touchgallery.TouchImageView */
public class TouchImageView extends ImageView {
    static final int CLICK = 10;
    static final long DOUBLE_PRESS_INTERVAL = 600;
    static final int DRAG = 1;
    static final float FRICTION = 0.9f;
    static final int NONE = 0;
    static final int ZOOM = 2;
    boolean allowInert = false;
    float bmHeight;
    float bmWidth;
    float bottom;
    float height;
    PointF last = new PointF();
    PointF lastDelta = new PointF(0.0f, 0.0f);
    long lastDragTime = 0;
    long lastPressTime = 0;

    /* renamed from: m */
    float[] f567m;
    /* access modifiers changed from: private */
    public Timer mClickTimer;
    private Context mContext;
    /* access modifiers changed from: private */
    public View.OnClickListener mOnClickListener;
    /* access modifiers changed from: private */
    public Object mScaleDetector;
    /* access modifiers changed from: private */
    public Handler mTimerHandler = null;
    Matrix matrix = new Matrix();
    float matrixX;
    float matrixY;
    float maxScale = 3.0f;
    PointF mid = new PointF();
    float minScale = 1.0f;
    int mode = 0;
    float oldDist = 1.0f;
    public boolean onBottomSide = false;
    public boolean onLeftSide = false;
    public boolean onRightSide = false;
    public boolean onTopSide = false;
    float origHeight;
    float origWidth;
    private int positionForTouchImageView = -1;
    float redundantXSpace;
    float redundantYSpace;
    float right;
    float saveScale = 1.0f;
    Matrix savedMatrix = new Matrix();
    PointF start = new PointF();
    float velocity = 0.0f;
    private ImageView view;
    float width;
    private boolean zoomToOriginalSize = false;

    public boolean isZoomToOriginalSize() {
        return this.zoomToOriginalSize;
    }

    public void setZoomToOriginalSize(boolean z) {
        this.zoomToOriginalSize = z;
    }

    public TouchImageView(Context context) {
        super(context);
        super.setClickable(true);
        this.mContext = context;
        this.view = this;
        init();
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setClickable(true);
        this.mContext = context;
        this.view = this;
        init();
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.mTimerHandler = new TimeHandler(this);
        this.matrix.setTranslate(1.0f, 1.0f);
        this.f567m = new float[9];
        setImageMatrix(this.matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
        if (Build.VERSION.SDK_INT >= 8) {
            this.mScaleDetector = new ScaleGestureDetector(this.mContext, new ScaleListener());
        }
        setOnTouchListener(new View.OnTouchListener() {
            /* JADX WARNING: Removed duplicated region for block: B:41:0x01a4  */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x0225  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
                /*
                    r10 = this;
                    java.lang.String r11 = "click ----"
                    java.lang.String r0 = " onTouch---->"
                    android.util.Log.d(r0, r11)
                    com.iaai.android.old.utils.ui.touchgallery.WrapMotionEvent r0 = com.iaai.android.old.utils.p016ui.touchgallery.WrapMotionEvent.wrap(r12)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    java.lang.Object r1 = r1.mScaleDetector
                    if (r1 == 0) goto L_0x001e
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    java.lang.Object r1 = r1.mScaleDetector
                    android.view.ScaleGestureDetector r1 = (android.view.ScaleGestureDetector) r1
                    r1.onTouchEvent(r12)
                L_0x001e:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r1.fillMatrixXY()
                    android.graphics.PointF r1 = new android.graphics.PointF
                    float r2 = r0.getX()
                    float r3 = r0.getY()
                    r1.<init>(r2, r3)
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "value ----"
                    r2.append(r3)
                    int r3 = r0.getAction()
                    r3 = r3 & 255(0xff, float:3.57E-43)
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    java.lang.String r3 = " switch---->"
                    android.util.Log.d(r3, r2)
                    int r2 = r0.getAction()
                    r2 = r2 & 255(0xff, float:3.57E-43)
                    r3 = 1
                    r4 = 0
                    if (r2 == 0) goto L_0x0354
                    r5 = 1065353216(0x3f800000, float:1.0)
                    r6 = 1073741824(0x40000000, float:2.0)
                    r7 = 0
                    if (r2 == r3) goto L_0x024d
                    r11 = 1092616192(0x41200000, float:10.0)
                    r8 = 2
                    if (r2 == r8) goto L_0x00ab
                    r12 = 5
                    if (r2 == r12) goto L_0x0083
                    r11 = 6
                    if (r2 == r11) goto L_0x006a
                    goto L_0x037f
                L_0x006a:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r11.mode = r4
                    r11.velocity = r7
                    android.graphics.Matrix r11 = r11.savedMatrix
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r12 = r12.matrix
                    r11.set(r12)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r11.spacing(r0)
                    r11.oldDist = r12
                    goto L_0x037f
                L_0x0083:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r12.spacing(r0)
                    r12.oldDist = r1
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.oldDist
                    int r11 = (r12 > r11 ? 1 : (r12 == r11 ? 0 : -1))
                    if (r11 <= 0) goto L_0x037f
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r11 = r11.savedMatrix
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r12 = r12.matrix
                    r11.set(r12)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r12 = r11.mid
                    r11.midPoint(r12, r0)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r11.mode = r8
                    goto L_0x037f
                L_0x00ab:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r2.allowInert = r4
                    int r2 = r2.mode
                    if (r2 != r3) goto L_0x00fc
                    float r11 = r1.x
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r12 = r12.last
                    float r12 = r12.x
                    float r11 = r11 - r12
                    float r12 = r1.y
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r0 = r0.last
                    float r0 = r0.y
                    float r12 = r12 - r0
                    long r2 = java.lang.System.currentTimeMillis()
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r5 = r0.last
                    double r5 = r0.distanceBetween(r1, r5)
                    float r5 = (float) r5
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r6 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    long r6 = r6.lastDragTime
                    long r6 = r2 - r6
                    float r6 = (float) r6
                    float r5 = r5 / r6
                    r6 = 1063675494(0x3f666666, float:0.9)
                    float r5 = r5 * r6
                    r0.velocity = r5
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r0.lastDragTime = r2
                    r0.checkAndSetTranslate(r11, r12)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r0 = r0.lastDelta
                    r0.set(r11, r12)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r11 = r11.last
                    float r12 = r1.x
                    float r0 = r1.y
                    r11.set(r12, r0)
                    goto L_0x037f
                L_0x00fc:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    java.lang.Object r1 = r1.mScaleDetector
                    if (r1 != 0) goto L_0x037f
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    int r1 = r1.mode
                    if (r1 != r8) goto L_0x037f
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r1.spacing(r0)
                    int r12 = r12.getPointerCount()
                    if (r12 >= r8) goto L_0x0118
                    goto L_0x037f
                L_0x0118:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.oldDist
                    float r12 = r12 - r1
                    float r12 = java.lang.Math.abs(r12)
                    int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
                    if (r11 > 0) goto L_0x037f
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r11 = r11.oldDist
                    float r11 = r11 - r1
                    float r11 = java.lang.Math.abs(r11)
                    r12 = 1112014848(0x42480000, float:50.0)
                    int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
                    if (r11 <= 0) goto L_0x0136
                    goto L_0x037f
                L_0x0136:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r11 = r11.oldDist
                    float r11 = r1 / r11
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r12.oldDist = r1
                    float r12 = r12.saveScale
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r2 = r1.saveScale
                    float r2 = r2 * r11
                    r1.saveScale = r2
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r1.saveScale
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r2 = r2.maxScale
                    int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                    if (r1 <= 0) goto L_0x0162
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r11.maxScale
                    r11.saveScale = r1
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r11 = r11.maxScale
                L_0x0160:
                    float r11 = r11 / r12
                    goto L_0x0179
                L_0x0162:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r1.saveScale
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r2 = r2.minScale
                    int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                    if (r1 >= 0) goto L_0x0179
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r11.minScale
                    r11.saveScale = r1
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r11 = r11.minScale
                    goto L_0x0160
                L_0x0179:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r12.calcPadding()
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.origWidth
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r1.saveScale
                    float r12 = r12 * r1
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r1.width
                    int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
                    if (r12 <= 0) goto L_0x0225
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.origHeight
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r1.saveScale
                    float r12 = r12 * r1
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r1.height
                    int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
                    if (r12 > 0) goto L_0x01a4
                    goto L_0x0225
                L_0x01a4:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r12 = r12.midPointF(r0)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r0 = r0.matrix
                    float r1 = r12.x
                    float r12 = r12.y
                    r0.postScale(r11, r11, r1, r12)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r12.fillMatrixXY()
                    int r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                    if (r11 >= 0) goto L_0x0246
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r11 = r11.matrixX
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.right
                    float r12 = -r12
                    int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
                    if (r11 >= 0) goto L_0x01dd
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r11 = r11.matrix
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.matrixX
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r0 = r0.right
                    float r12 = r12 + r0
                    float r12 = -r12
                    r11.postTranslate(r12, r7)
                    goto L_0x01f1
                L_0x01dd:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r11 = r11.matrixX
                    int r11 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                    if (r11 <= 0) goto L_0x01f1
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r11 = r11.matrix
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.matrixX
                    float r12 = -r12
                    r11.postTranslate(r12, r7)
                L_0x01f1:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r11 = r11.matrixY
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.bottom
                    float r12 = -r12
                    int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
                    if (r11 >= 0) goto L_0x0210
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r11 = r11.matrix
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.matrixY
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r0 = r0.bottom
                    float r12 = r12 + r0
                    float r12 = -r12
                    r11.postTranslate(r7, r12)
                    goto L_0x0246
                L_0x0210:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r11 = r11.matrixY
                    int r11 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
                    if (r11 <= 0) goto L_0x0246
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r11 = r11.matrix
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.matrixY
                    float r12 = -r12
                    r11.postTranslate(r7, r12)
                    goto L_0x0246
                L_0x0225:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r12 = r12.matrix
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r0 = r0.width
                    float r0 = r0 / r6
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r1.height
                    float r1 = r1 / r6
                    r12.postScale(r11, r11, r0, r1)
                    int r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                    if (r11 >= 0) goto L_0x0246
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r12.fillMatrixXY()
                    if (r11 >= 0) goto L_0x0246
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r11.scaleMatrixToBounds()
                L_0x0246:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r11.checkSiding()
                    goto L_0x037f
                L_0x024d:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r12.allowInert = r3
                    r12.mode = r4
                    float r12 = r0.getX()
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r1 = r1.start
                    float r1 = r1.x
                    float r12 = r12 - r1
                    float r12 = java.lang.Math.abs(r12)
                    int r12 = (int) r12
                    float r0 = r0.getY()
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r1 = r1.start
                    float r1 = r1.y
                    float r0 = r0 - r1
                    float r0 = java.lang.Math.abs(r0)
                    int r0 = (int) r0
                    r1 = 10
                    if (r12 >= r1) goto L_0x037f
                    if (r0 >= r1) goto L_0x037f
                    long r0 = java.lang.System.currentTimeMillis()
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    long r2 = r12.lastPressTime
                    long r2 = r0 - r2
                    r8 = 600(0x258, double:2.964E-321)
                    int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                    if (r12 > 0) goto L_0x031e
                    java.lang.String r12 = " double---->"
                    android.util.Log.d(r12, r11)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    java.util.Timer r11 = r11.mClickTimer
                    if (r11 == 0) goto L_0x029f
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    java.util.Timer r11 = r11.mClickTimer
                    r11.cancel()
                L_0x029f:
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder
                    r11.<init>()
                    java.lang.String r12 = "saveScale ----"
                    r11.append(r12)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.saveScale
                    r11.append(r12)
                    java.lang.String r11 = r11.toString()
                    java.lang.String r12 = " double--saveScale-->"
                    android.util.Log.d(r12, r11)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r11 = r11.saveScale
                    int r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                    if (r11 != 0) goto L_0x02e4
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r11 = r11.maxScale
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.saveScale
                    float r11 = r11 / r12
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r12 = r12.matrix
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r0 = r0.start
                    float r0 = r0.x
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r1 = r1.start
                    float r1 = r1.y
                    r12.postScale(r11, r11, r0, r1)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r11.maxScale
                    r11.saveScale = r12
                    goto L_0x030d
                L_0x02e4:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r11 = r11.matrix
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.minScale
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r0 = r0.saveScale
                    float r12 = r12 / r0
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r0 = r0.minScale
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r1.saveScale
                    float r0 = r0 / r1
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r1 = r1.width
                    float r1 = r1 / r6
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r2 = r2.height
                    float r2 = r2 / r6
                    r11.postScale(r12, r0, r1, r2)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r11.minScale
                    r11.saveScale = r12
                L_0x030d:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r11.calcPadding()
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r11.checkAndSetTranslate(r7, r7)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r0 = 0
                    r11.lastPressTime = r0
                    goto L_0x0342
                L_0x031e:
                    java.lang.String r12 = " single---->"
                    android.util.Log.d(r12, r11)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r11.lastPressTime = r0
                    java.util.Timer r12 = new java.util.Timer
                    r12.<init>()
                    java.util.Timer unused = r11.mClickTimer = r12
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    java.util.Timer r11 = r11.mClickTimer
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView$Task r12 = new com.iaai.android.old.utils.ui.touchgallery.TouchImageView$Task
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r1 = 0
                    r12.<init>()
                    r0 = 300(0x12c, double:1.48E-321)
                    r11.schedule(r12, r0)
                L_0x0342:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r11 = r11.saveScale
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    float r12 = r12.minScale
                    int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
                    if (r11 != 0) goto L_0x037f
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r11.scaleMatrixToBounds()
                    goto L_0x037f
                L_0x0354:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r11.allowInert = r4
                    android.graphics.Matrix r11 = r11.savedMatrix
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r12 = r12.matrix
                    r11.set(r12)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r11 = r11.last
                    float r12 = r0.getX()
                    float r0 = r0.getY()
                    r11.set(r12, r0)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r11 = r11.start
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r12 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.PointF r12 = r12.last
                    r11.set(r12)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r11.mode = r3
                L_0x037f:
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    android.graphics.Matrix r12 = r11.matrix
                    r11.setImageMatrix(r12)
                    com.iaai.android.old.utils.ui.touchgallery.TouchImageView r11 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                    r11.invalidate()
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.C33501.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    public void resetScale() {
        Log.d(" resetScale---->", "click ----");
        fillMatrixXY();
        Matrix matrix2 = this.matrix;
        float f = this.minScale;
        float f2 = this.saveScale;
        matrix2.postScale(f / f2, f / f2, this.width / 2.0f, this.height / 2.0f);
        this.saveScale = this.minScale;
        calcPadding();
        checkAndSetTranslate(0.0f, 0.0f);
        scaleMatrixToBounds();
        setImageMatrix(this.matrix);
        invalidate();
    }

    public boolean pagerCanScroll() {
        Log.d("pagerCanScroll--->", "called--> ");
        if (this.mode == 0 && this.saveScale == this.minScale) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Log.d("onDraw--->", "called--> ");
        super.onDraw(canvas);
        if (this.allowInert) {
            float f = this.lastDelta.x * this.velocity;
            float f2 = this.lastDelta.y;
            float f3 = this.velocity;
            float f4 = f2 * f3;
            if (f <= this.width && f4 <= this.height) {
                this.velocity = f3 * FRICTION;
                if (((double) Math.abs(f)) >= 0.1d || ((double) Math.abs(f4)) >= 0.1d) {
                    checkAndSetTranslate(f, f4);
                    setImageMatrix(this.matrix);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkAndSetTranslate(float r6, float r7) {
        /*
            r5 = this;
            java.lang.String r0 = "checkAndSetTranslate--->"
            java.lang.String r1 = "called--> "
            android.util.Log.d(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "deltaX--> "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "deltaY--> "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            float r0 = r5.origWidth
            float r1 = r5.saveScale
            float r0 = r0 * r1
            int r0 = java.lang.Math.round(r0)
            float r0 = (float) r0
            float r1 = r5.origHeight
            float r2 = r5.saveScale
            float r1 = r1 * r2
            int r1 = java.lang.Math.round(r1)
            float r1 = (float) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "scaleWidth--> "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "scaleWidth--->"
            android.util.Log.d(r3, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "scaleHeight--> "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "scaleHeight--->"
            android.util.Log.d(r3, r2)
            r5.fillMatrixXY()
            float r2 = r5.width
            r3 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0092
            float r6 = r5.matrixY
            float r0 = r6 + r7
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0085
        L_0x0083:
            float r7 = -r6
            goto L_0x0090
        L_0x0085:
            float r0 = r6 + r7
            float r1 = r5.bottom
            float r2 = -r1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0090
            float r6 = r6 + r1
            goto L_0x0083
        L_0x0090:
            r6 = 0
            goto L_0x00d9
        L_0x0092:
            float r0 = r5.height
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00af
            float r7 = r5.matrixX
            float r0 = r7 + r6
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a2
        L_0x00a0:
            float r6 = -r7
            goto L_0x00ad
        L_0x00a2:
            float r0 = r7 + r6
            float r1 = r5.right
            float r2 = -r1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ad
            float r7 = r7 + r1
            goto L_0x00a0
        L_0x00ad:
            r7 = 0
            goto L_0x00d9
        L_0x00af:
            float r0 = r5.matrixX
            float r1 = r0 + r6
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x00b9
        L_0x00b7:
            float r6 = -r0
            goto L_0x00c4
        L_0x00b9:
            float r1 = r0 + r6
            float r2 = r5.right
            float r4 = -r2
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00c4
            float r0 = r0 + r2
            goto L_0x00b7
        L_0x00c4:
            float r0 = r5.matrixY
            float r1 = r0 + r7
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ce
        L_0x00cc:
            float r7 = -r0
            goto L_0x00d9
        L_0x00ce:
            float r1 = r0 + r7
            float r2 = r5.bottom
            float r3 = -r2
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00d9
            float r0 = r0 + r2
            goto L_0x00cc
        L_0x00d9:
            android.graphics.Matrix r0 = r5.matrix
            r0.postTranslate(r6, r7)
            r5.checkSiding()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.checkAndSetTranslate(float, float):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00a7, code lost:
        if (((-r7.matrixX) + r0) <= r2) goto L_0x00a9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkSiding() {
        /*
            r7 = this;
            r7.fillMatrixXY()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "x: "
            r0.append(r1)
            float r1 = r7.matrixX
            r0.append(r1)
            java.lang.String r1 = " y: "
            r0.append(r1)
            float r1 = r7.matrixY
            r0.append(r1)
            java.lang.String r1 = " left: "
            r0.append(r1)
            float r1 = r7.right
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            r0.append(r1)
            java.lang.String r1 = " top:"
            r0.append(r1)
            float r1 = r7.bottom
            float r1 = r1 / r2
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "checkSiding--->"
            android.util.Log.d(r1, r0)
            float r0 = r7.origWidth
            float r1 = r7.saveScale
            float r0 = r0 * r1
            int r0 = java.lang.Math.round(r0)
            float r0 = (float) r0
            float r1 = r7.origHeight
            float r2 = r7.saveScale
            float r1 = r1 * r2
            int r1 = java.lang.Math.round(r1)
            float r1 = (float) r1
            r2 = 0
            r7.onBottomSide = r2
            r7.onTopSide = r2
            r7.onRightSide = r2
            r7.onLeftSide = r2
            float r3 = r7.matrixX
            float r3 = -r3
            r4 = 1092616192(0x41200000, float:10.0)
            r5 = 1
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0068
            r7.onLeftSide = r5
        L_0x0068:
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Float r6 = java.lang.Float.valueOf(r0)
            r3[r2] = r6
            float r2 = r7.width
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r3[r5] = r2
            r2 = 2
            float r6 = r7.matrixX
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r3[r2] = r6
            java.lang.String r2 = "ScaleW: %f; W: %f, MatrixX: %f"
            java.lang.String r2 = java.lang.String.format(r2, r3)
            java.lang.String r3 = "GalleryViewPager"
            android.util.Log.d(r3, r2)
            float r2 = r7.width
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 < 0) goto L_0x009b
            float r3 = r7.matrixX
            float r3 = r3 + r0
            float r3 = r3 - r2
            int r2 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x00a9
        L_0x009b:
            float r2 = r7.width
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x00ab
            float r3 = r7.matrixX
            float r3 = -r3
            float r3 = r3 + r0
            int r0 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x00ab
        L_0x00a9:
            r7.onRightSide = r5
        L_0x00ab:
            float r0 = r7.matrixY
            float r0 = -r0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x00b4
            r7.onTopSide = r5
        L_0x00b4:
            float r0 = r7.matrixY
            float r0 = -r0
            float r2 = r7.height
            float r0 = r0 + r2
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x00c5
            r7.onBottomSide = r5
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.checkSiding():void");
    }

    /* access modifiers changed from: private */
    public void calcPadding() {
        Log.d(" calcPadding---->", "called ----");
        float f = this.width;
        float f2 = this.saveScale;
        this.right = ((f * f2) - f) - ((this.redundantXSpace * 2.0f) * f2);
        float f3 = this.height;
        this.bottom = ((f3 * f2) - f3) - ((this.redundantYSpace * 2.0f) * f2);
        Log.d(" calcPadding---->", "right ----" + this.right);
        Log.d(" calcPadding---->", "bottom ----" + this.bottom);
    }

    /* access modifiers changed from: private */
    public void fillMatrixXY() {
        Log.d(" fillMatrixXY---->", "called ----");
        this.matrix.getValues(this.f567m);
        float[] fArr = this.f567m;
        this.matrixX = fArr[2];
        this.matrixY = fArr[5];
        Log.d(" fillMatrixXY---->", "matrixX ----" + this.matrixX);
        Log.d(" fillMatrixXY---->", "matrixY ----" + this.matrixY);
    }

    /* access modifiers changed from: private */
    public void scaleMatrixToBounds() {
        Log.d(" scaleMatrixToBounds---->", "called ----");
        if (Math.abs(this.matrixX + (this.right / 2.0f)) > 0.5f) {
            this.matrix.postTranslate(-(this.matrixX + (this.right / 2.0f)), 0.0f);
        }
        if (Math.abs(this.matrixY + (this.bottom / 2.0f)) > 0.5f) {
            this.matrix.postTranslate(0.0f, -(this.matrixY + (this.bottom / 2.0f)));
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.bmWidth = (float) bitmap.getWidth();
        this.bmHeight = (float) bitmap.getHeight();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Log.d(" onMeasure---->", "called ----");
        super.onMeasure(i, i2);
        this.width = (float) View.MeasureSpec.getSize(i);
        this.height = (float) View.MeasureSpec.getSize(i2);
        Log.d(" onMeasure---->", "width ----" + this.width);
        Log.d(" onMeasure---->", "height ----" + this.height);
        float f = this.width / this.bmWidth;
        float f2 = this.height / this.bmHeight;
        Log.d(" onMeasure---->", "bmWidth ----" + this.bmWidth);
        Log.d(" onMeasure---->", "bmHeight ----" + this.bmHeight);
        Log.d(" onMeasure---->", "scaleX ----" + f);
        Log.d(" onMeasure---->", "scaleY ----" + f2);
        float min = Math.min(f, f2);
        this.matrix.setScale(min, min);
        setImageMatrix(this.matrix);
        this.saveScale = 1.0f;
        this.redundantYSpace = this.height - (this.bmHeight * min);
        this.redundantXSpace = this.width - (min * this.bmWidth);
        this.redundantYSpace /= 2.0f;
        this.redundantXSpace /= 2.0f;
        Log.d(" onMeasure---->", "redundantXSpace ----" + this.redundantXSpace);
        Log.d(" onMeasure---->", "redundantYSpace ----" + this.redundantYSpace);
        this.matrix.postTranslate(this.redundantXSpace, this.redundantYSpace);
        this.origWidth = this.width - (this.redundantXSpace * 2.0f);
        this.origHeight = this.height - (this.redundantYSpace * 2.0f);
        Log.d(" onMeasure---->", "origWidth ----" + this.origWidth);
        Log.d(" onMeasure---->", "origHeight ----" + this.origHeight);
        calcPadding();
        setImageMatrix(this.matrix);
    }

    /* access modifiers changed from: private */
    public double distanceBetween(PointF pointF, PointF pointF2) {
        Log.d(" distanceBetween---->", "called ----");
        return Math.sqrt(Math.pow((double) (pointF.x - pointF2.x), 2.0d) + Math.pow((double) (pointF.y - pointF2.y), 2.0d));
    }

    /* access modifiers changed from: private */
    public float spacing(WrapMotionEvent wrapMotionEvent) {
        Log.d(" spacing---->", "called ----");
        float y = wrapMotionEvent.getY(0) - wrapMotionEvent.getY(1);
        double x = (double) (wrapMotionEvent.getX(0) - wrapMotionEvent.getX(1));
        return (float) Math.sqrt((x * x) + ((double) (y * y)));
    }

    /* access modifiers changed from: private */
    public void midPoint(PointF pointF, WrapMotionEvent wrapMotionEvent) {
        Log.d(" midPoint---->", "called ----");
        pointF.set((wrapMotionEvent.getX(0) + wrapMotionEvent.getX(1)) / 2.0f, (wrapMotionEvent.getY(0) + wrapMotionEvent.getY(1)) / 2.0f);
    }

    /* access modifiers changed from: private */
    public PointF midPointF(WrapMotionEvent wrapMotionEvent) {
        Log.d(" midPointF---->", "called ----");
        return new PointF((wrapMotionEvent.getX(0) + wrapMotionEvent.getX(1)) / 2.0f, (wrapMotionEvent.getY(0) + wrapMotionEvent.getY(1)) / 2.0f);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    /* renamed from: com.iaai.android.old.utils.ui.touchgallery.TouchImageView$Task */
    private class Task extends TimerTask {
        private Task() {
        }

        public void run() {
            TouchImageView.this.mTimerHandler.sendEmptyMessage(0);
        }
    }

    /* renamed from: com.iaai.android.old.utils.ui.touchgallery.TouchImageView$ScaleListener */
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.mode = 2;
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x00c0  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0133  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onScale(android.view.ScaleGestureDetector r9) {
            /*
                r8 = this;
                java.lang.String r0 = " onScale---->"
                java.lang.String r1 = "called ----"
                android.util.Log.d(r0, r1)
                float r0 = r9.getScaleFactor()
                r1 = 1064514355(0x3f733333, float:0.95)
                float r0 = java.lang.Math.max(r1, r0)
                double r0 = (double) r0
                r2 = 4607407598781385933(0x3ff0cccccccccccd, double:1.05)
                double r0 = java.lang.Math.min(r0, r2)
                float r0 = (float) r0
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r1 = r1.saveScale
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r3 = r2.saveScale
                float r3 = r3 * r0
                r2.saveScale = r3
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r2.saveScale
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r3 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r3 = r3.maxScale
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L_0x0041
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r0.maxScale
                r0.saveScale = r2
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r0 = r0.maxScale
            L_0x003f:
                float r0 = r0 / r1
                goto L_0x0058
            L_0x0041:
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r2.saveScale
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r3 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r3 = r3.minScale
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 >= 0) goto L_0x0058
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r0.minScale
                r0.saveScale = r2
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r0 = r0.minScale
                goto L_0x003f
            L_0x0058:
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r1.width
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r3 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r3 = r3.saveScale
                float r2 = r2 * r3
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r3 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r3 = r3.width
                float r2 = r2 - r3
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r3 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r3 = r3.redundantXSpace
                r4 = 1073741824(0x40000000, float:2.0)
                float r3 = r3 * r4
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r5 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r5 = r5.saveScale
                float r3 = r3 * r5
                float r2 = r2 - r3
                r1.right = r2
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r1.height
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r3 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r3 = r3.saveScale
                float r2 = r2 * r3
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r3 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r3 = r3.height
                float r2 = r2 - r3
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r3 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r3 = r3.redundantYSpace
                float r3 = r3 * r4
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r5 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r5 = r5.saveScale
                float r3 = r3 * r5
                float r2 = r2 - r3
                r1.bottom = r2
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r1 = r1.origWidth
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r2.saveScale
                float r1 = r1 * r2
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r2.width
                r3 = 5
                r5 = 2
                r6 = 1065353216(0x3f800000, float:1.0)
                r7 = 0
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 <= 0) goto L_0x0133
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r1 = r1.origHeight
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r2.saveScale
                float r1 = r1 * r2
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r2.height
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 > 0) goto L_0x00c0
                goto L_0x0133
            L_0x00c0:
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r1 = r1.matrix
                float r2 = r9.getFocusX()
                float r9 = r9.getFocusY()
                r1.postScale(r0, r0, r2, r9)
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r9 = r9.matrix
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float[] r1 = r1.f567m
                r9.getValues(r1)
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float[] r9 = r9.f567m
                r9 = r9[r5]
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float[] r1 = r1.f567m
                r1 = r1[r3]
                int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r0 >= 0) goto L_0x01bf
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r0 = r0.right
                float r0 = -r0
                int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r0 >= 0) goto L_0x0101
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r0 = r0.matrix
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r2.right
                float r9 = r9 + r2
                float r9 = -r9
                r0.postTranslate(r9, r7)
                goto L_0x010d
            L_0x0101:
                int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r0 <= 0) goto L_0x010d
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r0 = r0.matrix
                float r9 = -r9
                r0.postTranslate(r9, r7)
            L_0x010d:
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r9 = r9.bottom
                float r9 = -r9
                int r9 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
                if (r9 >= 0) goto L_0x0125
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r9 = r9.matrix
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r0 = r0.bottom
                float r1 = r1 + r0
                float r0 = -r1
                r9.postTranslate(r7, r0)
                goto L_0x01bf
            L_0x0125:
                int r9 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
                if (r9 <= 0) goto L_0x01bf
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r9 = r9.matrix
                float r0 = -r1
                r9.postTranslate(r7, r0)
                goto L_0x01bf
            L_0x0133:
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r9 = r9.matrix
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r1 = r1.width
                float r1 = r1 / r4
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r2.height
                float r2 = r2 / r4
                r9.postScale(r0, r0, r1, r2)
                int r9 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r9 >= 0) goto L_0x01bf
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r0 = r0.matrix
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float[] r1 = r1.f567m
                r0.getValues(r1)
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float[] r0 = r0.f567m
                r0 = r0[r5]
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float[] r1 = r1.f567m
                r1 = r1[r3]
                if (r9 >= 0) goto L_0x01bf
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r9 = r9.origWidth
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r2.saveScale
                float r9 = r9 * r2
                int r9 = java.lang.Math.round(r9)
                float r9 = (float) r9
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r2 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r2 = r2.width
                int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r9 >= 0) goto L_0x019c
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r9 = r9.bottom
                float r9 = -r9
                int r9 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
                if (r9 >= 0) goto L_0x018f
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r9 = r9.matrix
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r0 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r0 = r0.bottom
                float r1 = r1 + r0
                float r0 = -r1
                r9.postTranslate(r7, r0)
                goto L_0x01bf
            L_0x018f:
                int r9 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
                if (r9 <= 0) goto L_0x01bf
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r9 = r9.matrix
                float r0 = -r1
                r9.postTranslate(r7, r0)
                goto L_0x01bf
            L_0x019c:
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r9 = r9.right
                float r9 = -r9
                int r9 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
                if (r9 >= 0) goto L_0x01b3
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r9 = r9.matrix
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r1 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                float r1 = r1.right
                float r0 = r0 + r1
                float r0 = -r0
                r9.postTranslate(r0, r7)
                goto L_0x01bf
            L_0x01b3:
                int r9 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                if (r9 <= 0) goto L_0x01bf
                com.iaai.android.old.utils.ui.touchgallery.TouchImageView r9 = com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.this
                android.graphics.Matrix r9 = r9.matrix
                float r0 = -r0
                r9.postTranslate(r0, r7)
            L_0x01bf:
                r9 = 1
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.utils.p016ui.touchgallery.TouchImageView.ScaleListener.onScale(android.view.ScaleGestureDetector):boolean");
        }
    }

    /* renamed from: com.iaai.android.old.utils.ui.touchgallery.TouchImageView$TimeHandler */
    static class TimeHandler extends Handler {
        private final WeakReference<TouchImageView> mService;

        TimeHandler(TouchImageView touchImageView) {
            this.mService = new WeakReference<>(touchImageView);
        }

        public void handleMessage(Message message) {
            Log.d(" handleMessage---->", "called ----");
            ((TouchImageView) this.mService.get()).performClick();
            if (((TouchImageView) this.mService.get()).mOnClickListener != null) {
                ((TouchImageView) this.mService.get()).mOnClickListener.onClick((View) this.mService.get());
            }
        }
    }
}
