package com.iaai.android.bdt.model.digitalNegotiation;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BG\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0005¢\u0006\u0002\u0010\nJ\u001d\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0005HÆ\u0003JV\u0010\u0016\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/digitalNegotiation/DigitalNegotiationListClass;", "Ljava/io/Serializable;", "MobileNegotiationsList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/digitalNegotiation/MobileNegotiationsList;", "Lkotlin/collections/ArrayList;", "IsCountersInitiated", "", "NegotiationsBidHistory", "Lcom/iaai/android/bdt/model/digitalNegotiation/NegotiationsBidHistory;", "(Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/util/ArrayList;)V", "getIsCountersInitiated", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMobileNegotiationsList", "()Ljava/util/ArrayList;", "setMobileNegotiationsList", "(Ljava/util/ArrayList;)V", "getNegotiationsBidHistory", "component1", "component2", "component3", "copy", "(Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/util/ArrayList;)Lcom/iaai/android/bdt/model/digitalNegotiation/DigitalNegotiationListClass;", "equals", "other", "", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DigitalNegotiationListClass.kt */
public final class DigitalNegotiationListClass implements Serializable {
    @Nullable
    private final Boolean IsCountersInitiated;
    @Nullable
    private ArrayList<MobileNegotiationsList> MobileNegotiationsList;
    @Nullable
    private final ArrayList<NegotiationsBidHistory> NegotiationsBidHistory;

    @NotNull
    public static /* synthetic */ DigitalNegotiationListClass copy$default(DigitalNegotiationListClass digitalNegotiationListClass, ArrayList<MobileNegotiationsList> arrayList, Boolean bool, ArrayList<NegotiationsBidHistory> arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = digitalNegotiationListClass.MobileNegotiationsList;
        }
        if ((i & 2) != 0) {
            bool = digitalNegotiationListClass.IsCountersInitiated;
        }
        if ((i & 4) != 0) {
            arrayList2 = digitalNegotiationListClass.NegotiationsBidHistory;
        }
        return digitalNegotiationListClass.copy(arrayList, bool, arrayList2);
    }

    @Nullable
    public final ArrayList<MobileNegotiationsList> component1() {
        return this.MobileNegotiationsList;
    }

    @Nullable
    public final Boolean component2() {
        return this.IsCountersInitiated;
    }

    @Nullable
    public final ArrayList<NegotiationsBidHistory> component3() {
        return this.NegotiationsBidHistory;
    }

    @NotNull
    public final DigitalNegotiationListClass copy(@Nullable ArrayList<MobileNegotiationsList> arrayList, @Nullable Boolean bool, @Nullable ArrayList<NegotiationsBidHistory> arrayList2) {
        return new DigitalNegotiationListClass(arrayList, bool, arrayList2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DigitalNegotiationListClass)) {
            return false;
        }
        DigitalNegotiationListClass digitalNegotiationListClass = (DigitalNegotiationListClass) obj;
        return Intrinsics.areEqual((Object) this.MobileNegotiationsList, (Object) digitalNegotiationListClass.MobileNegotiationsList) && Intrinsics.areEqual((Object) this.IsCountersInitiated, (Object) digitalNegotiationListClass.IsCountersInitiated) && Intrinsics.areEqual((Object) this.NegotiationsBidHistory, (Object) digitalNegotiationListClass.NegotiationsBidHistory);
    }

    public int hashCode() {
        ArrayList<MobileNegotiationsList> arrayList = this.MobileNegotiationsList;
        int i = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        Boolean bool = this.IsCountersInitiated;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        ArrayList<NegotiationsBidHistory> arrayList2 = this.NegotiationsBidHistory;
        if (arrayList2 != null) {
            i = arrayList2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "DigitalNegotiationListClass(MobileNegotiationsList=" + this.MobileNegotiationsList + ", IsCountersInitiated=" + this.IsCountersInitiated + ", NegotiationsBidHistory=" + this.NegotiationsBidHistory + ")";
    }

    public DigitalNegotiationListClass(@Nullable ArrayList<MobileNegotiationsList> arrayList, @Nullable Boolean bool, @Nullable ArrayList<NegotiationsBidHistory> arrayList2) {
        this.MobileNegotiationsList = arrayList;
        this.IsCountersInitiated = bool;
        this.NegotiationsBidHistory = arrayList2;
    }

    @Nullable
    public final ArrayList<MobileNegotiationsList> getMobileNegotiationsList() {
        return this.MobileNegotiationsList;
    }

    public final void setMobileNegotiationsList(@Nullable ArrayList<MobileNegotiationsList> arrayList) {
        this.MobileNegotiationsList = arrayList;
    }

    @Nullable
    public final Boolean getIsCountersInitiated() {
        return this.IsCountersInitiated;
    }

    @Nullable
    public final ArrayList<NegotiationsBidHistory> getNegotiationsBidHistory() {
        return this.NegotiationsBidHistory;
    }
}
