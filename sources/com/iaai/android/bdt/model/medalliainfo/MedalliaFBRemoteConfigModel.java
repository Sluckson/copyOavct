package com.iaai.android.bdt.model.medalliainfo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0012"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/medalliainfo/MedalliaFBRemoteConfigModel;", "", "is_medallia_enabled", "", "feedback_form_id", "", "(ZLjava/lang/String;)V", "getFeedback_form_id", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MedalliaFBRemoteConfigModel.kt */
public final class MedalliaFBRemoteConfigModel {
    @NotNull
    private final String feedback_form_id;
    private final boolean is_medallia_enabled;

    @NotNull
    public static /* synthetic */ MedalliaFBRemoteConfigModel copy$default(MedalliaFBRemoteConfigModel medalliaFBRemoteConfigModel, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = medalliaFBRemoteConfigModel.is_medallia_enabled;
        }
        if ((i & 2) != 0) {
            str = medalliaFBRemoteConfigModel.feedback_form_id;
        }
        return medalliaFBRemoteConfigModel.copy(z, str);
    }

    public final boolean component1() {
        return this.is_medallia_enabled;
    }

    @NotNull
    public final String component2() {
        return this.feedback_form_id;
    }

    @NotNull
    public final MedalliaFBRemoteConfigModel copy(boolean z, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "feedback_form_id");
        return new MedalliaFBRemoteConfigModel(z, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof MedalliaFBRemoteConfigModel) {
                MedalliaFBRemoteConfigModel medalliaFBRemoteConfigModel = (MedalliaFBRemoteConfigModel) obj;
                if (!(this.is_medallia_enabled == medalliaFBRemoteConfigModel.is_medallia_enabled) || !Intrinsics.areEqual((Object) this.feedback_form_id, (Object) medalliaFBRemoteConfigModel.feedback_form_id)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.is_medallia_enabled;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.feedback_form_id;
        return i + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MedalliaFBRemoteConfigModel(is_medallia_enabled=" + this.is_medallia_enabled + ", feedback_form_id=" + this.feedback_form_id + ")";
    }

    public MedalliaFBRemoteConfigModel(boolean z, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "feedback_form_id");
        this.is_medallia_enabled = z;
        this.feedback_form_id = str;
    }

    @NotNull
    public final String getFeedback_form_id() {
        return this.feedback_form_id;
    }

    public final boolean is_medallia_enabled() {
        return this.is_medallia_enabled;
    }
}
