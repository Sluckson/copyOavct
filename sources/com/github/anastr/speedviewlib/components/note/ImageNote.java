package com.github.anastr.speedviewlib.components.note;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tB+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0014R\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/note/ImageNote;", "Lcom/github/anastr/speedviewlib/components/note/Note;", "context", "Landroid/content/Context;", "resource", "", "(Landroid/content/Context;I)V", "width", "height", "(Landroid/content/Context;III)V", "image", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;II)V", "imageRect", "Landroid/graphics/RectF;", "notePaint", "Landroid/graphics/Paint;", "build", "", "viewWidth", "drawContains", "canvas", "Landroid/graphics/Canvas;", "leftX", "", "topY", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: ImageNote.kt */
public final class ImageNote extends Note<ImageNote> {
    private final int height;
    private final Bitmap image;
    private final RectF imageRect;
    private final Paint notePaint;
    private final int width;

    @JvmOverloads
    public ImageNote(@NotNull Context context, @NotNull Bitmap bitmap) {
        this(context, bitmap, 0, 0, 12, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ImageNote(@NotNull Context context, @NotNull Bitmap bitmap, int i) {
        this(context, bitmap, i, 0, 8, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ImageNote(@NotNull Context context, @NotNull Bitmap bitmap, int i, int i2) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(bitmap, "image");
        this.image = bitmap;
        this.width = i;
        this.height = i2;
        this.imageRect = new RectF();
        boolean z = true;
        this.notePaint = new Paint(1);
        if (this.width > 0) {
            if (!(this.height <= 0 ? false : z)) {
                throw new IllegalArgumentException("height must be bigger than 0".toString());
            }
            return;
        }
        throw new IllegalArgumentException("width must be bigger than 0".toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageNote(Context context, Bitmap bitmap, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, bitmap, (i3 & 4) != 0 ? bitmap.getWidth() : i, (i3 & 8) != 0 ? bitmap.getHeight() : i2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ImageNote(@org.jetbrains.annotations.NotNull android.content.Context r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            android.content.res.Resources r0 = r9.getResources()
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeResource(r0, r10)
            java.lang.String r10 = "BitmapFactory.decodeReso…text.resources, resource)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r10)
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r1 = r8
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.anastr.speedviewlib.components.note.ImageNote.<init>(android.content.Context, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ImageNote(@org.jetbrains.annotations.NotNull android.content.Context r2, int r3, int r4, int r5) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            android.content.res.Resources r0 = r2.getResources()
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeResource(r0, r3)
            java.lang.String r0 = "BitmapFactory.decodeReso…text.resources, resource)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
            r1.<init>((android.content.Context) r2, (android.graphics.Bitmap) r3, (int) r4, (int) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.anastr.speedviewlib.components.note.ImageNote.<init>(android.content.Context, int, int, int):void");
    }

    public void build(int i) {
        noticeContainsSizeChange(this.width, this.height);
    }

    /* access modifiers changed from: protected */
    public void drawContains(@NotNull Canvas canvas, float f, float f2) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        this.imageRect.set(f, f2, ((float) this.width) + f, ((float) this.height) + f2);
        canvas.drawBitmap(this.image, (Rect) null, this.imageRect, this.notePaint);
    }
}
