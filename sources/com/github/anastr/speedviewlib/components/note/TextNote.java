package com.github.anastr.speedviewlib.components.note;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010H\u0014J\u0006\u0010\u0019\u001a\u00020\u0010J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/note/TextNote;", "Lcom/github/anastr/speedviewlib/components/note/Note;", "context", "Landroid/content/Context;", "noteText", "", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "notePaint", "Landroid/text/TextPaint;", "textColor", "", "getTextColor", "()I", "textLayout", "Landroid/text/StaticLayout;", "textSize", "", "build", "", "viewWidth", "drawContains", "canvas", "Landroid/graphics/Canvas;", "leftX", "topY", "getTextSize", "setTextColor", "setTextSize", "setTextTypeFace", "typeface", "Landroid/graphics/Typeface;", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: TextNote.kt */
public final class TextNote extends Note<TextNote> {
    private final TextPaint notePaint = new TextPaint(1);
    private final CharSequence noteText;
    private StaticLayout textLayout;
    private float textSize = this.notePaint.getTextSize();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextNote(@NotNull Context context, @Nullable CharSequence charSequence) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.noteText = charSequence;
        if (this.noteText != null) {
            this.notePaint.setTextAlign(Paint.Align.LEFT);
            return;
        }
        throw new IllegalArgumentException("noteText cannot be null.".toString());
    }

    public final int getTextColor() {
        return this.notePaint.getColor();
    }

    public void build(int i) {
        this.textLayout = new StaticLayout(this.noteText, this.notePaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout == null) {
            Intrinsics.throwNpe();
        }
        int lineCount = staticLayout.getLineCount();
        int i2 = 0;
        for (int i3 = 0; i3 < lineCount; i3++) {
            float f = (float) i2;
            StaticLayout staticLayout2 = this.textLayout;
            if (staticLayout2 == null) {
                Intrinsics.throwNpe();
            }
            i2 = (int) Math.max(f, staticLayout2.getLineWidth(i3));
        }
        StaticLayout staticLayout3 = this.textLayout;
        if (staticLayout3 == null) {
            Intrinsics.throwNpe();
        }
        noticeContainsSizeChange(i2, staticLayout3.getHeight());
    }

    /* access modifiers changed from: protected */
    public void drawContains(@NotNull Canvas canvas, float f, float f2) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        canvas.save();
        canvas.translate(f, f2);
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout == null) {
            Intrinsics.throwNpe();
        }
        staticLayout.draw(canvas);
        canvas.restore();
    }

    public final float getTextSize() {
        return this.textSize;
    }

    @NotNull
    public final TextNote setTextSize(float f) {
        this.textSize = f;
        this.notePaint.setTextSize(f);
        return this;
    }

    @NotNull
    public final TextNote setTextTypeFace(@NotNull Typeface typeface) {
        Intrinsics.checkParameterIsNotNull(typeface, "typeface");
        this.notePaint.setTypeface(typeface);
        return this;
    }

    @NotNull
    public final TextNote setTextColor(int i) {
        this.notePaint.setColor(i);
        return this;
    }
}
