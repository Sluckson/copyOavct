package com.github.anastr.speedviewlib.components;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.anastr.speedviewlib.Gauge;
import com.lowagie.text.ElementTags;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u00011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B3\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\r\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020\u000bH\u0016J\u0015\u0010,\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b-J\u0016\u0010.\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010/\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u000bH\u0016R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010\f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0018\"\u0004\b'\u0010\u001a¨\u00062"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/Section;", "Landroid/os/Parcelable;", "section", "(Lcom/github/anastr/speedviewlib/components/Section;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "startOffset", "", "endOffset", "color", "", "width", "style", "Lcom/github/anastr/speedviewlib/components/Style;", "(FFIFLcom/github/anastr/speedviewlib/components/Style;)V", "_endOffset", "_startOffset", "value", "getColor", "()I", "setColor", "(I)V", "getEndOffset", "()F", "setEndOffset", "(F)V", "gauge", "Lcom/github/anastr/speedviewlib/Gauge;", "padding", "getPadding", "setPadding", "getStartOffset", "setStartOffset", "getStyle", "()Lcom/github/anastr/speedviewlib/components/Style;", "setStyle", "(Lcom/github/anastr/speedviewlib/components/Style;)V", "getWidth", "setWidth", "clearGauge", "", "clearGauge$speedviewlib_release", "describeContents", "inGauge", "inGauge$speedviewlib_release", "setStartEndOffset", "writeToParcel", "flags", "CREATOR", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
/* compiled from: Section.kt */
public final class Section implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private float _endOffset;
    private float _startOffset;
    private int color;
    private Gauge gauge;
    private float padding;
    @NotNull
    private Style style;
    private float width;

    @JvmOverloads
    public Section(float f, float f2, int i) {
        this(f, f2, i, 0.0f, (Style) null, 24, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public Section(float f, float f2, int i, float f3) {
        this(f, f2, i, f3, (Style) null, 16, (DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    @JvmOverloads
    public Section(float f, float f2, int i, float f3, @NotNull Style style2) {
        Intrinsics.checkParameterIsNotNull(style2, "style");
        this.width = f3;
        this._startOffset = f;
        this._endOffset = f2;
        this.color = i;
        this.style = style2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Section(float f, float f2, int i, float f3, Style style2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, i, (i2 & 8) != 0 ? 0.0f : f3, (i2 & 16) != 0 ? Style.BUTT : style2);
    }

    public final float getWidth() {
        return this.width;
    }

    public final void setWidth(float f) {
        this.width = f;
        Gauge gauge2 = this.gauge;
        if (gauge2 != null) {
            gauge2.invalidateGauge();
        }
    }

    public final float getPadding() {
        return this.padding;
    }

    public final void setPadding(float f) {
        this.padding = f;
        Gauge gauge2 = this.gauge;
        if (gauge2 != null) {
            gauge2.invalidateGauge();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Section(@NotNull Section section) {
        this(section.getStartOffset(), section.getEndOffset(), section.color, section.width, section.style);
        Intrinsics.checkParameterIsNotNull(section, ElementTags.SECTION);
        setPadding(section.padding);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Section(@org.jetbrains.annotations.NotNull android.os.Parcel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            float r2 = r8.readFloat()
            float r3 = r8.readFloat()
            int r4 = r8.readInt()
            float r5 = r8.readFloat()
            java.io.Serializable r0 = r8.readSerializable()
            if (r0 == 0) goto L_0x002a
            r6 = r0
            com.github.anastr.speedviewlib.components.Style r6 = (com.github.anastr.speedviewlib.components.Style) r6
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            float r8 = r8.readFloat()
            r7.setPadding(r8)
            return
        L_0x002a:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type com.github.anastr.speedviewlib.components.Style"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.anastr.speedviewlib.components.Section.<init>(android.os.Parcel):void");
    }

    public final float getStartOffset() {
        return this._startOffset;
    }

    public final void setStartOffset(float f) {
        setStartEndOffset(f, getEndOffset());
    }

    public final float getEndOffset() {
        return this._endOffset;
    }

    public final void setEndOffset(float f) {
        setStartEndOffset(getStartOffset(), f);
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int i) {
        this.color = i;
        Gauge gauge2 = this.gauge;
        if (gauge2 != null) {
            gauge2.invalidateGauge();
        }
    }

    @NotNull
    public final Style getStyle() {
        return this.style;
    }

    public final void setStyle(@NotNull Style style2) {
        Intrinsics.checkParameterIsNotNull(style2, "value");
        this.style = style2;
        Gauge gauge2 = this.gauge;
        if (gauge2 != null) {
            gauge2.invalidateGauge();
        }
    }

    public final void setStartEndOffset(float f, float f2) {
        this._startOffset = f;
        this._endOffset = f2;
        Gauge gauge2 = this.gauge;
        if (gauge2 != null) {
            gauge2.checkSection$speedviewlib_release(this);
        }
        Gauge gauge3 = this.gauge;
        if (gauge3 != null) {
            gauge3.invalidateGauge();
        }
    }

    @NotNull
    public final Section inGauge$speedviewlib_release(@NotNull Gauge gauge2) {
        Intrinsics.checkParameterIsNotNull(gauge2, "gauge");
        this.gauge = gauge2;
        return this;
    }

    public final void clearGauge$speedviewlib_release() {
        this.gauge = null;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeFloat(getStartOffset());
        parcel.writeFloat(getEndOffset());
        parcel.writeInt(this.color);
        parcel.writeFloat(this.width);
        parcel.writeSerializable(Integer.valueOf(this.style.ordinal()));
        parcel.writeFloat(this.padding);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo66933d2 = {"Lcom/github/anastr/speedviewlib/components/Section$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/github/anastr/speedviewlib/components/Section;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/github/anastr/speedviewlib/components/Section;", "speedviewlib_release"}, mo66934k = 1, mo66935mv = {1, 1, 16})
    /* compiled from: Section.kt */
    public static final class CREATOR implements Parcelable.Creator<Section> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public Section createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new Section(parcel);
        }

        @NotNull
        public Section[] newArray(int i) {
            return new Section[i];
        }
    }
}
