package com.iaai.android.bdt.model.toBePaid.saleDocument;

import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import com.iaai.android.old.utils.constants.Constants;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/saleDocument/RowModelForSetSaleDoc;", "", "type", "", "branch", "", "isExpanded", "", "(ILjava/lang/String;Z)V", "stock", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "(ILcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;Z)V", "getBranch", "()Ljava/lang/String;", "setBranch", "(Ljava/lang/String;)V", "()Z", "setExpanded", "(Z)V", "getStock", "()Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "setStock", "(Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;)V", "type$annotations", "()V", "getType", "()I", "setType", "(I)V", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RowModelForSetSaleDoc.kt */
public final class RowModelForSetSaleDoc {
    public static final int BRANCH = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int STOCK = 2;
    @NotNull
    public String branch;
    private boolean isExpanded;
    @NotNull
    public TitleInstructionItem stock;
    private int type;

    public static /* synthetic */ void type$annotations() {
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/saleDocument/RowModelForSetSaleDoc$Companion;", "", "()V", "BRANCH", "", "STOCK", "RowType", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RowModelForSetSaleDoc.kt */
    public static final class Companion {

        @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/saleDocument/RowModelForSetSaleDoc$Companion$RowType;", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
        @Retention(AnnotationRetention.SOURCE)
        @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
        /* compiled from: RowModelForSetSaleDoc.kt */
        public @interface RowType {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public final String getBranch() {
        String str = this.branch;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants.EXTRA_BRANCH);
        }
        return str;
    }

    public final void setBranch(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.branch = str;
    }

    @NotNull
    public final TitleInstructionItem getStock() {
        TitleInstructionItem titleInstructionItem = this.stock;
        if (titleInstructionItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stock");
        }
        return titleInstructionItem;
    }

    public final void setStock(@NotNull TitleInstructionItem titleInstructionItem) {
        Intrinsics.checkParameterIsNotNull(titleInstructionItem, "<set-?>");
        this.stock = titleInstructionItem;
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public final void setExpanded(boolean z) {
        this.isExpanded = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RowModelForSetSaleDoc(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z);
    }

    public RowModelForSetSaleDoc(int i, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_BRANCH);
        this.type = i;
        this.branch = str;
        this.isExpanded = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RowModelForSetSaleDoc(int i, TitleInstructionItem titleInstructionItem, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, titleInstructionItem, (i2 & 4) != 0 ? false : z);
    }

    public RowModelForSetSaleDoc(int i, @NotNull TitleInstructionItem titleInstructionItem, boolean z) {
        Intrinsics.checkParameterIsNotNull(titleInstructionItem, "stock");
        this.type = i;
        this.stock = titleInstructionItem;
        this.isExpanded = z;
    }
}
