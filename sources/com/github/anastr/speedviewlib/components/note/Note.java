package com.github.anastr.speedviewlib.components.note;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.anastr.speedviewlib.components.note.Note;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\b&\u0018\u0000 E*\u0010\b\u0000\u0010\u0001 \u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0003DEFB\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u000bH&J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0013J\u001e\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u0013J \u0010.\u001a\u00020 2\u0006\u0010+\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0013H$J\u0006\u00101\u001a\u00020\u0007J\u0006\u00102\u001a\u00020\u0013J\u0006\u00103\u001a\u00020\u001dJ\u0018\u00104\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0004J\u0013\u00105\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010:J+\u0010;\u001a\u00028\u00002\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u0013¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020 H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/note/Note;", "N", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "align", "Lcom/github/anastr/speedviewlib/components/note/Note$Align;", "backgroundBitmap", "Landroid/graphics/Bitmap;", "backgroundColor", "", "getBackgroundColor", "()I", "backgroundPaint", "Landroid/graphics/Paint;", "containsH", "containsW", "cornersRound", "", "density", "noteH", "noteW", "paddingBottom", "paddingLeft", "paddingRight", "paddingTop", "paint", "position", "Lcom/github/anastr/speedviewlib/components/note/Note$Position;", "triangleHeight", "bitmapBottom", "", "c", "Landroid/graphics/Canvas;", "bitmapLeft", "bitmapRight", "bitmapTop", "build", "viewWidth", "dpTOpx", "dp", "draw", "canvas", "posX", "posY", "drawContains", "leftX", "topY", "getAlign", "getCornersRound", "getPosition", "noticeContainsSizeChange", "setAlign", "(Lcom/github/anastr/speedviewlib/components/note/Note$Align;)Lcom/github/anastr/speedviewlib/components/note/Note;", "setBackgroundColor", "(I)Lcom/github/anastr/speedviewlib/components/note/Note;", "setCornersRound", "(F)Lcom/github/anastr/speedviewlib/components/note/Note;", "setPadding", "left", "top", "right", "bottom", "(FFFF)Lcom/github/anastr/speedviewlib/components/note/Note;", "setPosition", "(Lcom/github/anastr/speedviewlib/components/note/Note$Position;)Lcom/github/anastr/speedviewlib/components/note/Note;", "updateBackgroundBitmap", "Align", "Companion", "Position", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: Note.kt */
public abstract class Note<N extends Note<? extends N>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int INFINITE = -1;
    private Align align;
    private Bitmap backgroundBitmap;
    private final Paint backgroundPaint = new Paint(1);
    private int containsH;
    private int containsW;
    private float cornersRound;
    private final float density;
    private int noteH;
    private int noteW;
    private float paddingBottom;
    private float paddingLeft;
    private float paddingRight;
    private float paddingTop;
    private final Paint paint = new Paint(1);
    private Position position;
    private float triangleHeight;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/note/Note$Align;", "", "(Ljava/lang/String;I)V", "Left", "Top", "Right", "Bottom", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
    /* compiled from: Note.kt */
    public enum Align {
        Left,
        Top,
        Right,
        Bottom
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/note/Note$Position;", "", "(Ljava/lang/String;I)V", "TopIndicator", "CenterIndicator", "BottomIndicator", "TopSpeedometer", "CenterSpeedometer", "QuarterSpeedometer", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
    /* compiled from: Note.kt */
    public enum Position {
        TopIndicator,
        CenterIndicator,
        BottomIndicator,
        TopSpeedometer,
        CenterSpeedometer,
        QuarterSpeedometer
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Align.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[Align.values().length];

        static {
            $EnumSwitchMapping$0[Align.Left.ordinal()] = 1;
            $EnumSwitchMapping$0[Align.Top.ordinal()] = 2;
            $EnumSwitchMapping$0[Align.Right.ordinal()] = 3;
            $EnumSwitchMapping$0[Align.Bottom.ordinal()] = 4;
            $EnumSwitchMapping$1[Align.Left.ordinal()] = 1;
            $EnumSwitchMapping$1[Align.Top.ordinal()] = 2;
            $EnumSwitchMapping$1[Align.Right.ordinal()] = 3;
            $EnumSwitchMapping$1[Align.Bottom.ordinal()] = 4;
        }
    }

    public abstract void build(int i);

    /* access modifiers changed from: protected */
    public abstract void drawContains(@NotNull Canvas canvas, float f, float f2);

    protected Note(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        this.density = resources.getDisplayMetrics().density;
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        this.backgroundBitmap = createBitmap;
        this.position = Position.CenterIndicator;
        this.align = Align.Top;
        this.cornersRound = 5.0f;
        this.triangleHeight = dpTOpx(12.0f);
        this.backgroundPaint.setColor((int) 4292270039L);
        setPadding(dpTOpx(7.0f), dpTOpx(7.0f), dpTOpx(7.0f), dpTOpx(7.0f));
    }

    public final int getBackgroundColor() {
        return this.backgroundPaint.getColor();
    }

    public final float dpTOpx(float f) {
        return f * this.density;
    }

    /* access modifiers changed from: protected */
    public final void noticeContainsSizeChange(int i, int i2) {
        this.containsW = i;
        this.containsH = i2;
        if (this.align == Align.Top || this.align == Align.Bottom) {
            this.noteW = (int) (((float) i) + this.paddingLeft + this.paddingRight);
            this.noteH = (int) (((float) i2) + this.paddingTop + this.paddingBottom + this.triangleHeight);
        } else {
            this.noteW = (int) (((float) i) + this.paddingLeft + this.paddingRight + this.triangleHeight);
            this.noteH = (int) (((float) i2) + this.paddingTop + this.paddingBottom);
        }
        updateBackgroundBitmap();
    }

    private final void updateBackgroundBitmap() {
        int i;
        int i2 = this.noteW;
        if (i2 > 0 && (i = this.noteH) > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
            Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(note… Bitmap.Config.ARGB_8888)");
            this.backgroundBitmap = createBitmap;
            Canvas canvas = new Canvas(this.backgroundBitmap);
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.align.ordinal()];
            if (i3 == 1) {
                bitmapLeft(canvas);
            } else if (i3 == 2) {
                bitmapTop(canvas);
            } else if (i3 == 3) {
                bitmapRight(canvas);
            } else if (i3 == 4) {
                bitmapBottom(canvas);
            }
        }
    }

    private final void bitmapLeft(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, ((float) this.noteW) - this.triangleHeight, (float) this.noteH);
        Path path = new Path();
        path.moveTo((float) this.noteW, ((float) this.noteH) / 2.0f);
        float f = (float) 1;
        path.lineTo(rectF.right - f, (((float) this.noteH) / 2.0f) - dpTOpx(9.0f));
        path.lineTo(rectF.right - f, (((float) this.noteH) / 2.0f) + dpTOpx(9.0f));
        canvas.drawPath(path, this.backgroundPaint);
        float f2 = this.cornersRound;
        canvas.drawRoundRect(rectF, f2, f2, this.backgroundPaint);
    }

    private final void bitmapTop(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.noteW, ((float) this.noteH) - this.triangleHeight);
        Path path = new Path();
        path.moveTo(((float) this.noteW) / 2.0f, (float) this.noteH);
        float f = (float) 1;
        path.lineTo((((float) this.noteW) / 2.0f) - dpTOpx(9.0f), rectF.bottom - f);
        path.lineTo((((float) this.noteW) / 2.0f) + dpTOpx(9.0f), rectF.bottom - f);
        canvas.drawPath(path, this.backgroundPaint);
        float f2 = this.cornersRound;
        canvas.drawRoundRect(rectF, f2, f2, this.backgroundPaint);
    }

    private final void bitmapRight(Canvas canvas) {
        RectF rectF = new RectF(this.triangleHeight + 0.0f, 0.0f, (float) this.noteW, (float) this.noteH);
        Path path = new Path();
        path.moveTo(0.0f, ((float) this.noteH) / 2.0f);
        float f = (float) 1;
        path.lineTo(rectF.left + f, (((float) this.noteH) / 2.0f) - dpTOpx(9.0f));
        path.lineTo(rectF.left + f, (((float) this.noteH) / 2.0f) + dpTOpx(9.0f));
        canvas.drawPath(path, this.backgroundPaint);
        float f2 = this.cornersRound;
        canvas.drawRoundRect(rectF, f2, f2, this.backgroundPaint);
    }

    private final void bitmapBottom(Canvas canvas) {
        RectF rectF = new RectF(0.0f, this.triangleHeight + 0.0f, (float) this.noteW, (float) this.noteH);
        Path path = new Path();
        path.moveTo(((float) this.noteW) / 2.0f, 0.0f);
        float f = (float) 1;
        path.lineTo((((float) this.noteW) / 2.0f) - dpTOpx(9.0f), rectF.top + f);
        path.lineTo((((float) this.noteW) / 2.0f) + dpTOpx(9.0f), rectF.top + f);
        canvas.drawPath(path, this.backgroundPaint);
        float f2 = this.cornersRound;
        canvas.drawRoundRect(rectF, f2, f2, this.backgroundPaint);
    }

    public final void draw(@NotNull Canvas canvas, float f, float f2) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        int i = WhenMappings.$EnumSwitchMapping$1[this.align.ordinal()];
        if (i == 1) {
            canvas.drawBitmap(this.backgroundBitmap, f - ((float) this.noteW), f2 - (((float) this.noteH) / 2.0f), this.paint);
            drawContains(canvas, (f - ((float) this.noteW)) + this.paddingLeft, (f2 - (((float) this.noteH) / 2.0f)) + this.paddingTop);
        } else if (i == 2) {
            canvas.drawBitmap(this.backgroundBitmap, f - (((float) this.noteW) / 2.0f), f2 - ((float) this.noteH), this.paint);
            drawContains(canvas, f - (((float) this.containsW) / 2.0f), (f2 - ((float) this.noteH)) + this.paddingTop);
        } else if (i == 3) {
            canvas.drawBitmap(this.backgroundBitmap, f, f2 - (((float) this.noteH) / 2.0f), this.paint);
            drawContains(canvas, f + this.triangleHeight + this.paddingLeft, (f2 - (((float) this.noteH) / 2.0f)) + this.paddingTop);
        } else if (i == 4) {
            canvas.drawBitmap(this.backgroundBitmap, f - (((float) this.noteW) / 2.0f), f2, this.paint);
            drawContains(canvas, f - (((float) this.containsW) / 2.0f), f2 + this.triangleHeight + this.paddingTop);
        }
    }

    @NotNull
    public final N setBackgroundColor(int i) {
        this.backgroundPaint.setColor(i);
        return this;
    }

    public final float getCornersRound() {
        return this.cornersRound;
    }

    @NotNull
    public final N setCornersRound(float f) {
        boolean z = false;
        if (f >= ((float) 0)) {
            z = true;
        }
        if (z) {
            this.cornersRound = f;
            return this;
        }
        throw new IllegalArgumentException("cornersRound cannot be negative".toString());
    }

    @NotNull
    public final Align getAlign() {
        return this.align;
    }

    @NotNull
    public final N setAlign(@NotNull Align align2) {
        Intrinsics.checkParameterIsNotNull(align2, "align");
        this.align = align2;
        return this;
    }

    @NotNull
    public final Position getPosition() {
        return this.position;
    }

    @NotNull
    public final N setPosition(@NotNull Position position2) {
        Intrinsics.checkParameterIsNotNull(position2, Constants_MVVM.EXTRA_ITEM_POSITION);
        this.position = position2;
        return this;
    }

    @NotNull
    public final N setPadding(float f, float f2, float f3, float f4) {
        this.paddingLeft = f;
        this.paddingTop = f2;
        this.paddingRight = f3;
        this.paddingBottom = f4;
        noticeContainsSizeChange(this.containsW, this.containsH);
        return this;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/note/Note$Companion;", "", "()V", "INFINITE", "", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
    /* compiled from: Note.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
