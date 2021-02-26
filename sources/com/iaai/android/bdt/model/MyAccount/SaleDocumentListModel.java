package com.iaai.android.bdt.model.MyAccount;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.DiffUtil;
import com.google.android.exoplayer2.C1119C;
import com.google.gson.annotations.SerializedName;
import com.lowagie.text.pdf.PdfFormField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b~\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010'\u001a\u00020\b\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010*\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010,\u001a\u00020\u000f\u0012\u0006\u0010-\u001a\u00020\u000f¢\u0006\u0002\u0010.J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010b\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010AJ\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010AJ\u0010\u0010t\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010AJ\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010AJ\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010AJ\t\u0010|\u001a\u00020\bHÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010AJ\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010AJ\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0001\u001a\u00020\u000fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u000fHÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00104J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00104J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00104J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00104Jö\u0003\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010'\u001a\u00020\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000fHÆ\u0001¢\u0006\u0003\u0010\u0001J\n\u0010\u0001\u001a\u00020\bHÖ\u0001J\u0016\u0010\u0001\u001a\u00020\u000f2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\bHÖ\u0001J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001J\u001e\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u00100R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00100R\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00105\u001a\u0004\b7\u00104R\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00105\u001a\u0004\b9\u00104R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u00100R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u00100R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00100R\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u00100R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00105\u001a\u0004\b>\u00104R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00105\u001a\u0004\b?\u00104R\u0015\u0010#\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010AR\u0015\u0010&\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010B\u001a\u0004\bC\u0010AR\u0015\u0010*\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010B\u001a\u0004\bD\u0010AR\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00105\u001a\u0004\bE\u00104R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010B\u001a\u0004\bF\u0010AR\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00100R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u0015\u0010)\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010B\u001a\u0004\bI\u0010AR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u00100R\u0011\u0010'\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00105\u001a\u0004\bM\u00104R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00105\u001a\u0004\bN\u00104R\u0015\u0010 \u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010B\u001a\u0004\bO\u0010AR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u00100R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u00100R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u00100R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u00100R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u00100R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u00100R\u0013\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u00100R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010B\u001a\u0004\bW\u0010AR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u00100R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u00100R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u00100R\u001a\u0010,\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010[\"\u0004\b\\\u0010]R\u001a\u0010-\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010[\"\u0004\b^\u0010]R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u00100¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListModel;", "Landroid/os/Parcelable;", "ThumbnailUrl", "", "VehicleDescription", "StockNumber", "VIN", "BranchCode", "", "BranchName", "EmployeeId", "SalvageID", "BuyerId", "OAAuctionItemId", "OffsiteSaleInd", "", "TitleDeliveryMethodCode", "SalvageSaleID", "BuyerTitleHandlingInstructionID", "TitleStatus", "AdditionalNotes", "RepresentativeName", "CompanyName", "FedexAccountNumber", "Address1", "Address2", "PhoneNumber", "City", "State1", "ZipCode", "Country", "UseMailingInd", "ShowStockNoUrl", "DtPickedUp", "TrackingNumber", "InstructionOverrideInd", "BuyerNotes", "OwnerName", "IsStockFinance", "RowNumber", "state2", "PublicBuyerRestrictionStateInd", "IsTitleMailingAddressChanged", "TransportationShippingFee", "isFeeVisible", "isSelected", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;ZZ)V", "getAdditionalNotes", "()Ljava/lang/String;", "getAddress1", "getAddress2", "getBranchCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBranchName", "getBuyerId", "getBuyerNotes", "getBuyerTitleHandlingInstructionID", "getCity", "getCompanyName", "getCountry", "getDtPickedUp", "getEmployeeId", "getFedexAccountNumber", "getInstructionOverrideInd", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIsStockFinance", "getIsTitleMailingAddressChanged", "getOAAuctionItemId", "getOffsiteSaleInd", "getOwnerName", "getPhoneNumber", "getPublicBuyerRestrictionStateInd", "getRepresentativeName", "getRowNumber", "()I", "getSalvageID", "getSalvageSaleID", "getShowStockNoUrl", "getState1", "getStockNumber", "getThumbnailUrl", "getTitleDeliveryMethodCode", "getTitleStatus", "getTrackingNumber", "getTransportationShippingFee", "getUseMailingInd", "getVIN", "getVehicleDescription", "getZipCode", "()Z", "setFeeVisible", "(Z)V", "setSelected", "getState2", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;ZZ)Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListModel;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: SaleDocumentListModel.kt */
public final class SaleDocumentListModel implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static DiffUtil.ItemCallback<SaleDocumentListModel> DIFF_CALLBACK = new SaleDocumentListModel$Companion$DIFF_CALLBACK$1();
    @Nullable
    private final String AdditionalNotes;
    @Nullable
    private final String Address1;
    @Nullable
    private final String Address2;
    @Nullable
    private final Integer BranchCode;
    @Nullable
    private final String BranchName;
    @Nullable
    private final Integer BuyerId;
    @Nullable
    private final String BuyerNotes;
    @Nullable
    private final Integer BuyerTitleHandlingInstructionID;
    @Nullable
    private final String City;
    @Nullable
    private final String CompanyName;
    @Nullable
    private final String Country;
    @Nullable
    private final String DtPickedUp;
    @Nullable
    private final Integer EmployeeId;
    @Nullable
    private final Integer FedexAccountNumber;
    @Nullable
    private final Boolean InstructionOverrideInd;
    @Nullable
    private final Boolean IsStockFinance;
    @Nullable
    private final Boolean IsTitleMailingAddressChanged;
    @Nullable
    private final Integer OAAuctionItemId;
    @Nullable
    private final Boolean OffsiteSaleInd;
    @Nullable
    private final String OwnerName;
    @Nullable
    private final String PhoneNumber;
    @Nullable
    private final Boolean PublicBuyerRestrictionStateInd;
    @Nullable
    private final String RepresentativeName;
    private final int RowNumber;
    @Nullable
    private final Integer SalvageID;
    @Nullable
    private final Integer SalvageSaleID;
    @Nullable
    private final Boolean ShowStockNoUrl;
    @SerializedName("State")
    @Nullable
    private final String State1;
    @Nullable
    private final String StockNumber;
    @Nullable
    private final String ThumbnailUrl;
    @Nullable
    private final String TitleDeliveryMethodCode;
    @Nullable
    private final String TitleStatus;
    @Nullable
    private final String TrackingNumber;
    @Nullable
    private final String TransportationShippingFee;
    @Nullable
    private final Boolean UseMailingInd;
    @Nullable
    private final String VIN;
    @Nullable
    private final String VehicleDescription;
    @Nullable
    private final String ZipCode;
    private boolean isFeeVisible;
    private boolean isSelected;
    @SerializedName("state")
    @Nullable
    private final String state2;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Boolean bool3;
            Boolean bool4;
            Boolean bool5;
            Boolean bool6;
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            Boolean bool7 = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString5 = parcel.readString();
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf3 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf4 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf5 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            String readString6 = parcel.readString();
            Integer valueOf6 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf7 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            Integer valueOf8 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            String readString15 = parcel.readString();
            String readString16 = parcel.readString();
            String readString17 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool2 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool2 = null;
            }
            if (parcel.readInt() != 0) {
                bool3 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool3 = null;
            }
            String readString18 = parcel.readString();
            String readString19 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool4 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool4 = null;
            }
            String readString20 = parcel.readString();
            String readString21 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool5 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool5 = null;
            }
            int readInt = parcel.readInt();
            String readString22 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool6 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool6 = null;
            }
            if (parcel.readInt() != 0) {
                bool7 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new SaleDocumentListModel(readString, readString2, readString3, readString4, valueOf, readString5, valueOf2, valueOf3, valueOf4, valueOf5, bool, readString6, valueOf6, valueOf7, readString7, readString8, readString9, readString10, valueOf8, readString11, readString12, readString13, readString14, readString15, readString16, readString17, bool2, bool3, readString18, readString19, bool4, readString20, readString21, bool5, readInt, readString22, bool6, bool7, parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new SaleDocumentListModel[i];
        }
    }

    @NotNull
    public static /* synthetic */ SaleDocumentListModel copy$default(SaleDocumentListModel saleDocumentListModel, String str, String str2, String str3, String str4, Integer num, String str5, Integer num2, Integer num3, Integer num4, Integer num5, Boolean bool, String str6, Integer num6, Integer num7, String str7, String str8, String str9, String str10, Integer num8, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Boolean bool2, Boolean bool3, String str18, String str19, Boolean bool4, String str20, String str21, Boolean bool5, int i, String str22, Boolean bool6, Boolean bool7, String str23, boolean z, boolean z2, int i2, int i3, Object obj) {
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        Integer num9;
        Integer num10;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        Boolean bool8;
        Boolean bool9;
        Boolean bool10;
        Boolean bool11;
        String str45;
        String str46;
        String str47;
        String str48;
        Boolean bool12;
        String str49;
        String str50;
        String str51;
        Boolean bool13;
        Boolean bool14;
        int i4;
        int i5;
        String str52;
        String str53;
        Boolean bool15;
        Boolean bool16;
        Boolean bool17;
        Boolean bool18;
        String str54;
        SaleDocumentListModel saleDocumentListModel2 = saleDocumentListModel;
        int i6 = i2;
        int i7 = i3;
        String str55 = (i6 & 1) != 0 ? saleDocumentListModel2.ThumbnailUrl : str;
        String str56 = (i6 & 2) != 0 ? saleDocumentListModel2.VehicleDescription : str2;
        String str57 = (i6 & 4) != 0 ? saleDocumentListModel2.StockNumber : str3;
        String str58 = (i6 & 8) != 0 ? saleDocumentListModel2.VIN : str4;
        Integer num11 = (i6 & 16) != 0 ? saleDocumentListModel2.BranchCode : num;
        String str59 = (i6 & 32) != 0 ? saleDocumentListModel2.BranchName : str5;
        Integer num12 = (i6 & 64) != 0 ? saleDocumentListModel2.EmployeeId : num2;
        Integer num13 = (i6 & 128) != 0 ? saleDocumentListModel2.SalvageID : num3;
        Integer num14 = (i6 & 256) != 0 ? saleDocumentListModel2.BuyerId : num4;
        Integer num15 = (i6 & 512) != 0 ? saleDocumentListModel2.OAAuctionItemId : num5;
        Boolean bool19 = (i6 & 1024) != 0 ? saleDocumentListModel2.OffsiteSaleInd : bool;
        String str60 = (i6 & 2048) != 0 ? saleDocumentListModel2.TitleDeliveryMethodCode : str6;
        Integer num16 = (i6 & 4096) != 0 ? saleDocumentListModel2.SalvageSaleID : num6;
        Integer num17 = (i6 & 8192) != 0 ? saleDocumentListModel2.BuyerTitleHandlingInstructionID : num7;
        String str61 = (i6 & 16384) != 0 ? saleDocumentListModel2.TitleStatus : str7;
        if ((i6 & 32768) != 0) {
            str24 = str61;
            str25 = saleDocumentListModel2.AdditionalNotes;
        } else {
            str24 = str61;
            str25 = str8;
        }
        if ((i6 & 65536) != 0) {
            str26 = str25;
            str27 = saleDocumentListModel2.RepresentativeName;
        } else {
            str26 = str25;
            str27 = str9;
        }
        if ((i6 & 131072) != 0) {
            str28 = str27;
            str29 = saleDocumentListModel2.CompanyName;
        } else {
            str28 = str27;
            str29 = str10;
        }
        if ((i6 & 262144) != 0) {
            str30 = str29;
            num9 = saleDocumentListModel2.FedexAccountNumber;
        } else {
            str30 = str29;
            num9 = num8;
        }
        if ((i6 & 524288) != 0) {
            num10 = num9;
            str31 = saleDocumentListModel2.Address1;
        } else {
            num10 = num9;
            str31 = str11;
        }
        if ((i6 & 1048576) != 0) {
            str32 = str31;
            str33 = saleDocumentListModel2.Address2;
        } else {
            str32 = str31;
            str33 = str12;
        }
        if ((i6 & 2097152) != 0) {
            str34 = str33;
            str35 = saleDocumentListModel2.PhoneNumber;
        } else {
            str34 = str33;
            str35 = str13;
        }
        if ((i6 & 4194304) != 0) {
            str36 = str35;
            str37 = saleDocumentListModel2.City;
        } else {
            str36 = str35;
            str37 = str14;
        }
        if ((i6 & 8388608) != 0) {
            str38 = str37;
            str39 = saleDocumentListModel2.State1;
        } else {
            str38 = str37;
            str39 = str15;
        }
        if ((i6 & 16777216) != 0) {
            str40 = str39;
            str41 = saleDocumentListModel2.ZipCode;
        } else {
            str40 = str39;
            str41 = str16;
        }
        if ((i6 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            str42 = str41;
            str43 = saleDocumentListModel2.Country;
        } else {
            str42 = str41;
            str43 = str17;
        }
        if ((i6 & 67108864) != 0) {
            str44 = str43;
            bool8 = saleDocumentListModel2.UseMailingInd;
        } else {
            str44 = str43;
            bool8 = bool2;
        }
        if ((i6 & 134217728) != 0) {
            bool9 = bool8;
            bool10 = saleDocumentListModel2.ShowStockNoUrl;
        } else {
            bool9 = bool8;
            bool10 = bool3;
        }
        if ((i6 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            bool11 = bool10;
            str45 = saleDocumentListModel2.DtPickedUp;
        } else {
            bool11 = bool10;
            str45 = str18;
        }
        if ((i6 & 536870912) != 0) {
            str46 = str45;
            str47 = saleDocumentListModel2.TrackingNumber;
        } else {
            str46 = str45;
            str47 = str19;
        }
        if ((i6 & 1073741824) != 0) {
            str48 = str47;
            bool12 = saleDocumentListModel2.InstructionOverrideInd;
        } else {
            str48 = str47;
            bool12 = bool4;
        }
        String str62 = (i6 & Integer.MIN_VALUE) != 0 ? saleDocumentListModel2.BuyerNotes : str20;
        if ((i7 & 1) != 0) {
            str49 = str62;
            str50 = saleDocumentListModel2.OwnerName;
        } else {
            str49 = str62;
            str50 = str21;
        }
        if ((i7 & 2) != 0) {
            str51 = str50;
            bool13 = saleDocumentListModel2.IsStockFinance;
        } else {
            str51 = str50;
            bool13 = bool5;
        }
        if ((i7 & 4) != 0) {
            bool14 = bool13;
            i4 = saleDocumentListModel2.RowNumber;
        } else {
            bool14 = bool13;
            i4 = i;
        }
        if ((i7 & 8) != 0) {
            i5 = i4;
            str52 = saleDocumentListModel2.state2;
        } else {
            i5 = i4;
            str52 = str22;
        }
        if ((i7 & 16) != 0) {
            str53 = str52;
            bool15 = saleDocumentListModel2.PublicBuyerRestrictionStateInd;
        } else {
            str53 = str52;
            bool15 = bool6;
        }
        if ((i7 & 32) != 0) {
            bool16 = bool15;
            bool17 = saleDocumentListModel2.IsTitleMailingAddressChanged;
        } else {
            bool16 = bool15;
            bool17 = bool7;
        }
        if ((i7 & 64) != 0) {
            bool18 = bool17;
            str54 = saleDocumentListModel2.TransportationShippingFee;
        } else {
            bool18 = bool17;
            str54 = str23;
        }
        return saleDocumentListModel.copy(str55, str56, str57, str58, num11, str59, num12, num13, num14, num15, bool19, str60, num16, num17, str24, str26, str28, str30, num10, str32, str34, str36, str38, str40, str42, str44, bool9, bool11, str46, str48, bool12, str49, str51, bool14, i5, str53, bool16, bool18, str54, (i7 & 128) != 0 ? saleDocumentListModel2.isFeeVisible : z, (i7 & 256) != 0 ? saleDocumentListModel2.isSelected : z2);
    }

    @Nullable
    public final String component1() {
        return this.ThumbnailUrl;
    }

    @Nullable
    public final Integer component10() {
        return this.OAAuctionItemId;
    }

    @Nullable
    public final Boolean component11() {
        return this.OffsiteSaleInd;
    }

    @Nullable
    public final String component12() {
        return this.TitleDeliveryMethodCode;
    }

    @Nullable
    public final Integer component13() {
        return this.SalvageSaleID;
    }

    @Nullable
    public final Integer component14() {
        return this.BuyerTitleHandlingInstructionID;
    }

    @Nullable
    public final String component15() {
        return this.TitleStatus;
    }

    @Nullable
    public final String component16() {
        return this.AdditionalNotes;
    }

    @Nullable
    public final String component17() {
        return this.RepresentativeName;
    }

    @Nullable
    public final String component18() {
        return this.CompanyName;
    }

    @Nullable
    public final Integer component19() {
        return this.FedexAccountNumber;
    }

    @Nullable
    public final String component2() {
        return this.VehicleDescription;
    }

    @Nullable
    public final String component20() {
        return this.Address1;
    }

    @Nullable
    public final String component21() {
        return this.Address2;
    }

    @Nullable
    public final String component22() {
        return this.PhoneNumber;
    }

    @Nullable
    public final String component23() {
        return this.City;
    }

    @Nullable
    public final String component24() {
        return this.State1;
    }

    @Nullable
    public final String component25() {
        return this.ZipCode;
    }

    @Nullable
    public final String component26() {
        return this.Country;
    }

    @Nullable
    public final Boolean component27() {
        return this.UseMailingInd;
    }

    @Nullable
    public final Boolean component28() {
        return this.ShowStockNoUrl;
    }

    @Nullable
    public final String component29() {
        return this.DtPickedUp;
    }

    @Nullable
    public final String component3() {
        return this.StockNumber;
    }

    @Nullable
    public final String component30() {
        return this.TrackingNumber;
    }

    @Nullable
    public final Boolean component31() {
        return this.InstructionOverrideInd;
    }

    @Nullable
    public final String component32() {
        return this.BuyerNotes;
    }

    @Nullable
    public final String component33() {
        return this.OwnerName;
    }

    @Nullable
    public final Boolean component34() {
        return this.IsStockFinance;
    }

    public final int component35() {
        return this.RowNumber;
    }

    @Nullable
    public final String component36() {
        return this.state2;
    }

    @Nullable
    public final Boolean component37() {
        return this.PublicBuyerRestrictionStateInd;
    }

    @Nullable
    public final Boolean component38() {
        return this.IsTitleMailingAddressChanged;
    }

    @Nullable
    public final String component39() {
        return this.TransportationShippingFee;
    }

    @Nullable
    public final String component4() {
        return this.VIN;
    }

    public final boolean component40() {
        return this.isFeeVisible;
    }

    public final boolean component41() {
        return this.isSelected;
    }

    @Nullable
    public final Integer component5() {
        return this.BranchCode;
    }

    @Nullable
    public final String component6() {
        return this.BranchName;
    }

    @Nullable
    public final Integer component7() {
        return this.EmployeeId;
    }

    @Nullable
    public final Integer component8() {
        return this.SalvageID;
    }

    @Nullable
    public final Integer component9() {
        return this.BuyerId;
    }

    @NotNull
    public final SaleDocumentListModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Boolean bool, @Nullable String str6, @Nullable Integer num6, @Nullable Integer num7, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Integer num8, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str18, @Nullable String str19, @Nullable Boolean bool4, @Nullable String str20, @Nullable String str21, @Nullable Boolean bool5, int i, @Nullable String str22, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable String str23, boolean z, boolean z2) {
        return new SaleDocumentListModel(str, str2, str3, str4, num, str5, num2, num3, num4, num5, bool, str6, num6, num7, str7, str8, str9, str10, num8, str11, str12, str13, str14, str15, str16, str17, bool2, bool3, str18, str19, bool4, str20, str21, bool5, i, str22, bool6, bool7, str23, z, z2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SaleDocumentListModel) {
                SaleDocumentListModel saleDocumentListModel = (SaleDocumentListModel) obj;
                if (Intrinsics.areEqual((Object) this.ThumbnailUrl, (Object) saleDocumentListModel.ThumbnailUrl) && Intrinsics.areEqual((Object) this.VehicleDescription, (Object) saleDocumentListModel.VehicleDescription) && Intrinsics.areEqual((Object) this.StockNumber, (Object) saleDocumentListModel.StockNumber) && Intrinsics.areEqual((Object) this.VIN, (Object) saleDocumentListModel.VIN) && Intrinsics.areEqual((Object) this.BranchCode, (Object) saleDocumentListModel.BranchCode) && Intrinsics.areEqual((Object) this.BranchName, (Object) saleDocumentListModel.BranchName) && Intrinsics.areEqual((Object) this.EmployeeId, (Object) saleDocumentListModel.EmployeeId) && Intrinsics.areEqual((Object) this.SalvageID, (Object) saleDocumentListModel.SalvageID) && Intrinsics.areEqual((Object) this.BuyerId, (Object) saleDocumentListModel.BuyerId) && Intrinsics.areEqual((Object) this.OAAuctionItemId, (Object) saleDocumentListModel.OAAuctionItemId) && Intrinsics.areEqual((Object) this.OffsiteSaleInd, (Object) saleDocumentListModel.OffsiteSaleInd) && Intrinsics.areEqual((Object) this.TitleDeliveryMethodCode, (Object) saleDocumentListModel.TitleDeliveryMethodCode) && Intrinsics.areEqual((Object) this.SalvageSaleID, (Object) saleDocumentListModel.SalvageSaleID) && Intrinsics.areEqual((Object) this.BuyerTitleHandlingInstructionID, (Object) saleDocumentListModel.BuyerTitleHandlingInstructionID) && Intrinsics.areEqual((Object) this.TitleStatus, (Object) saleDocumentListModel.TitleStatus) && Intrinsics.areEqual((Object) this.AdditionalNotes, (Object) saleDocumentListModel.AdditionalNotes) && Intrinsics.areEqual((Object) this.RepresentativeName, (Object) saleDocumentListModel.RepresentativeName) && Intrinsics.areEqual((Object) this.CompanyName, (Object) saleDocumentListModel.CompanyName) && Intrinsics.areEqual((Object) this.FedexAccountNumber, (Object) saleDocumentListModel.FedexAccountNumber) && Intrinsics.areEqual((Object) this.Address1, (Object) saleDocumentListModel.Address1) && Intrinsics.areEqual((Object) this.Address2, (Object) saleDocumentListModel.Address2) && Intrinsics.areEqual((Object) this.PhoneNumber, (Object) saleDocumentListModel.PhoneNumber) && Intrinsics.areEqual((Object) this.City, (Object) saleDocumentListModel.City) && Intrinsics.areEqual((Object) this.State1, (Object) saleDocumentListModel.State1) && Intrinsics.areEqual((Object) this.ZipCode, (Object) saleDocumentListModel.ZipCode) && Intrinsics.areEqual((Object) this.Country, (Object) saleDocumentListModel.Country) && Intrinsics.areEqual((Object) this.UseMailingInd, (Object) saleDocumentListModel.UseMailingInd) && Intrinsics.areEqual((Object) this.ShowStockNoUrl, (Object) saleDocumentListModel.ShowStockNoUrl) && Intrinsics.areEqual((Object) this.DtPickedUp, (Object) saleDocumentListModel.DtPickedUp) && Intrinsics.areEqual((Object) this.TrackingNumber, (Object) saleDocumentListModel.TrackingNumber) && Intrinsics.areEqual((Object) this.InstructionOverrideInd, (Object) saleDocumentListModel.InstructionOverrideInd) && Intrinsics.areEqual((Object) this.BuyerNotes, (Object) saleDocumentListModel.BuyerNotes) && Intrinsics.areEqual((Object) this.OwnerName, (Object) saleDocumentListModel.OwnerName) && Intrinsics.areEqual((Object) this.IsStockFinance, (Object) saleDocumentListModel.IsStockFinance)) {
                    if ((this.RowNumber == saleDocumentListModel.RowNumber) && Intrinsics.areEqual((Object) this.state2, (Object) saleDocumentListModel.state2) && Intrinsics.areEqual((Object) this.PublicBuyerRestrictionStateInd, (Object) saleDocumentListModel.PublicBuyerRestrictionStateInd) && Intrinsics.areEqual((Object) this.IsTitleMailingAddressChanged, (Object) saleDocumentListModel.IsTitleMailingAddressChanged) && Intrinsics.areEqual((Object) this.TransportationShippingFee, (Object) saleDocumentListModel.TransportationShippingFee)) {
                        if (this.isFeeVisible == saleDocumentListModel.isFeeVisible) {
                            if (this.isSelected == saleDocumentListModel.isSelected) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.ThumbnailUrl;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.VehicleDescription;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.StockNumber;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.VIN;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.BranchCode;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        String str5 = this.BranchName;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num2 = this.EmployeeId;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.SalvageID;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.BuyerId;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.OAAuctionItemId;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Boolean bool = this.OffsiteSaleInd;
        int hashCode11 = (hashCode10 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str6 = this.TitleDeliveryMethodCode;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num6 = this.SalvageSaleID;
        int hashCode13 = (hashCode12 + (num6 != null ? num6.hashCode() : 0)) * 31;
        Integer num7 = this.BuyerTitleHandlingInstructionID;
        int hashCode14 = (hashCode13 + (num7 != null ? num7.hashCode() : 0)) * 31;
        String str7 = this.TitleStatus;
        int hashCode15 = (hashCode14 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.AdditionalNotes;
        int hashCode16 = (hashCode15 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.RepresentativeName;
        int hashCode17 = (hashCode16 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.CompanyName;
        int hashCode18 = (hashCode17 + (str10 != null ? str10.hashCode() : 0)) * 31;
        Integer num8 = this.FedexAccountNumber;
        int hashCode19 = (hashCode18 + (num8 != null ? num8.hashCode() : 0)) * 31;
        String str11 = this.Address1;
        int hashCode20 = (hashCode19 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.Address2;
        int hashCode21 = (hashCode20 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.PhoneNumber;
        int hashCode22 = (hashCode21 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.City;
        int hashCode23 = (hashCode22 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.State1;
        int hashCode24 = (hashCode23 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.ZipCode;
        int hashCode25 = (hashCode24 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.Country;
        int hashCode26 = (hashCode25 + (str17 != null ? str17.hashCode() : 0)) * 31;
        Boolean bool2 = this.UseMailingInd;
        int hashCode27 = (hashCode26 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.ShowStockNoUrl;
        int hashCode28 = (hashCode27 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        String str18 = this.DtPickedUp;
        int hashCode29 = (hashCode28 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.TrackingNumber;
        int hashCode30 = (hashCode29 + (str19 != null ? str19.hashCode() : 0)) * 31;
        Boolean bool4 = this.InstructionOverrideInd;
        int hashCode31 = (hashCode30 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        String str20 = this.BuyerNotes;
        int hashCode32 = (hashCode31 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.OwnerName;
        int hashCode33 = (hashCode32 + (str21 != null ? str21.hashCode() : 0)) * 31;
        Boolean bool5 = this.IsStockFinance;
        int hashCode34 = (((hashCode33 + (bool5 != null ? bool5.hashCode() : 0)) * 31) + Integer.valueOf(this.RowNumber).hashCode()) * 31;
        String str22 = this.state2;
        int hashCode35 = (hashCode34 + (str22 != null ? str22.hashCode() : 0)) * 31;
        Boolean bool6 = this.PublicBuyerRestrictionStateInd;
        int hashCode36 = (hashCode35 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Boolean bool7 = this.IsTitleMailingAddressChanged;
        int hashCode37 = (hashCode36 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        String str23 = this.TransportationShippingFee;
        if (str23 != null) {
            i = str23.hashCode();
        }
        int i2 = (hashCode37 + i) * 31;
        boolean z = this.isFeeVisible;
        if (z) {
            z = true;
        }
        int i3 = (i2 + (z ? 1 : 0)) * 31;
        boolean z2 = this.isSelected;
        if (z2) {
            z2 = true;
        }
        return i3 + (z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "SaleDocumentListModel(ThumbnailUrl=" + this.ThumbnailUrl + ", VehicleDescription=" + this.VehicleDescription + ", StockNumber=" + this.StockNumber + ", VIN=" + this.VIN + ", BranchCode=" + this.BranchCode + ", BranchName=" + this.BranchName + ", EmployeeId=" + this.EmployeeId + ", SalvageID=" + this.SalvageID + ", BuyerId=" + this.BuyerId + ", OAAuctionItemId=" + this.OAAuctionItemId + ", OffsiteSaleInd=" + this.OffsiteSaleInd + ", TitleDeliveryMethodCode=" + this.TitleDeliveryMethodCode + ", SalvageSaleID=" + this.SalvageSaleID + ", BuyerTitleHandlingInstructionID=" + this.BuyerTitleHandlingInstructionID + ", TitleStatus=" + this.TitleStatus + ", AdditionalNotes=" + this.AdditionalNotes + ", RepresentativeName=" + this.RepresentativeName + ", CompanyName=" + this.CompanyName + ", FedexAccountNumber=" + this.FedexAccountNumber + ", Address1=" + this.Address1 + ", Address2=" + this.Address2 + ", PhoneNumber=" + this.PhoneNumber + ", City=" + this.City + ", State1=" + this.State1 + ", ZipCode=" + this.ZipCode + ", Country=" + this.Country + ", UseMailingInd=" + this.UseMailingInd + ", ShowStockNoUrl=" + this.ShowStockNoUrl + ", DtPickedUp=" + this.DtPickedUp + ", TrackingNumber=" + this.TrackingNumber + ", InstructionOverrideInd=" + this.InstructionOverrideInd + ", BuyerNotes=" + this.BuyerNotes + ", OwnerName=" + this.OwnerName + ", IsStockFinance=" + this.IsStockFinance + ", RowNumber=" + this.RowNumber + ", state2=" + this.state2 + ", PublicBuyerRestrictionStateInd=" + this.PublicBuyerRestrictionStateInd + ", IsTitleMailingAddressChanged=" + this.IsTitleMailingAddressChanged + ", TransportationShippingFee=" + this.TransportationShippingFee + ", isFeeVisible=" + this.isFeeVisible + ", isSelected=" + this.isSelected + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.ThumbnailUrl);
        parcel.writeString(this.VehicleDescription);
        parcel.writeString(this.StockNumber);
        parcel.writeString(this.VIN);
        Integer num = this.BranchCode;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.BranchName);
        Integer num2 = this.EmployeeId;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num3 = this.SalvageID;
        if (num3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num4 = this.BuyerId;
        if (num4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num5 = this.OAAuctionItemId;
        if (num5 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.OffsiteSaleInd;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.TitleDeliveryMethodCode);
        Integer num6 = this.SalvageSaleID;
        if (num6 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num6.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num7 = this.BuyerTitleHandlingInstructionID;
        if (num7 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num7.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.TitleStatus);
        parcel.writeString(this.AdditionalNotes);
        parcel.writeString(this.RepresentativeName);
        parcel.writeString(this.CompanyName);
        Integer num8 = this.FedexAccountNumber;
        if (num8 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num8.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.Address1);
        parcel.writeString(this.Address2);
        parcel.writeString(this.PhoneNumber);
        parcel.writeString(this.City);
        parcel.writeString(this.State1);
        parcel.writeString(this.ZipCode);
        parcel.writeString(this.Country);
        Boolean bool2 = this.UseMailingInd;
        if (bool2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool3 = this.ShowStockNoUrl;
        if (bool3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.DtPickedUp);
        parcel.writeString(this.TrackingNumber);
        Boolean bool4 = this.InstructionOverrideInd;
        if (bool4 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.BuyerNotes);
        parcel.writeString(this.OwnerName);
        Boolean bool5 = this.IsStockFinance;
        if (bool5 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool5.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.RowNumber);
        parcel.writeString(this.state2);
        Boolean bool6 = this.PublicBuyerRestrictionStateInd;
        if (bool6 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool6.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool7 = this.IsTitleMailingAddressChanged;
        if (bool7 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool7.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.TransportationShippingFee);
        parcel.writeInt(this.isFeeVisible ? 1 : 0);
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    public SaleDocumentListModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Boolean bool, @Nullable String str6, @Nullable Integer num6, @Nullable Integer num7, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Integer num8, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str18, @Nullable String str19, @Nullable Boolean bool4, @Nullable String str20, @Nullable String str21, @Nullable Boolean bool5, int i, @Nullable String str22, @Nullable Boolean bool6, @Nullable Boolean bool7, @Nullable String str23, boolean z, boolean z2) {
        this.ThumbnailUrl = str;
        this.VehicleDescription = str2;
        this.StockNumber = str3;
        this.VIN = str4;
        this.BranchCode = num;
        this.BranchName = str5;
        this.EmployeeId = num2;
        this.SalvageID = num3;
        this.BuyerId = num4;
        this.OAAuctionItemId = num5;
        this.OffsiteSaleInd = bool;
        this.TitleDeliveryMethodCode = str6;
        this.SalvageSaleID = num6;
        this.BuyerTitleHandlingInstructionID = num7;
        this.TitleStatus = str7;
        this.AdditionalNotes = str8;
        this.RepresentativeName = str9;
        this.CompanyName = str10;
        this.FedexAccountNumber = num8;
        this.Address1 = str11;
        this.Address2 = str12;
        this.PhoneNumber = str13;
        this.City = str14;
        this.State1 = str15;
        this.ZipCode = str16;
        this.Country = str17;
        this.UseMailingInd = bool2;
        this.ShowStockNoUrl = bool3;
        this.DtPickedUp = str18;
        this.TrackingNumber = str19;
        this.InstructionOverrideInd = bool4;
        this.BuyerNotes = str20;
        this.OwnerName = str21;
        this.IsStockFinance = bool5;
        this.RowNumber = i;
        this.state2 = str22;
        this.PublicBuyerRestrictionStateInd = bool6;
        this.IsTitleMailingAddressChanged = bool7;
        this.TransportationShippingFee = str23;
        this.isFeeVisible = z;
        this.isSelected = z2;
    }

    @Nullable
    public final String getThumbnailUrl() {
        return this.ThumbnailUrl;
    }

    @Nullable
    public final String getVehicleDescription() {
        return this.VehicleDescription;
    }

    @Nullable
    public final String getStockNumber() {
        return this.StockNumber;
    }

    @Nullable
    public final String getVIN() {
        return this.VIN;
    }

    @Nullable
    public final Integer getBranchCode() {
        return this.BranchCode;
    }

    @Nullable
    public final String getBranchName() {
        return this.BranchName;
    }

    @Nullable
    public final Integer getEmployeeId() {
        return this.EmployeeId;
    }

    @Nullable
    public final Integer getSalvageID() {
        return this.SalvageID;
    }

    @Nullable
    public final Integer getBuyerId() {
        return this.BuyerId;
    }

    @Nullable
    public final Integer getOAAuctionItemId() {
        return this.OAAuctionItemId;
    }

    @Nullable
    public final Boolean getOffsiteSaleInd() {
        return this.OffsiteSaleInd;
    }

    @Nullable
    public final String getTitleDeliveryMethodCode() {
        return this.TitleDeliveryMethodCode;
    }

    @Nullable
    public final Integer getSalvageSaleID() {
        return this.SalvageSaleID;
    }

    @Nullable
    public final Integer getBuyerTitleHandlingInstructionID() {
        return this.BuyerTitleHandlingInstructionID;
    }

    @Nullable
    public final String getTitleStatus() {
        return this.TitleStatus;
    }

    @Nullable
    public final String getAdditionalNotes() {
        return this.AdditionalNotes;
    }

    @Nullable
    public final String getRepresentativeName() {
        return this.RepresentativeName;
    }

    @Nullable
    public final String getCompanyName() {
        return this.CompanyName;
    }

    @Nullable
    public final Integer getFedexAccountNumber() {
        return this.FedexAccountNumber;
    }

    @Nullable
    public final String getAddress1() {
        return this.Address1;
    }

    @Nullable
    public final String getAddress2() {
        return this.Address2;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.PhoneNumber;
    }

    @Nullable
    public final String getCity() {
        return this.City;
    }

    @Nullable
    public final String getState1() {
        return this.State1;
    }

    @Nullable
    public final String getZipCode() {
        return this.ZipCode;
    }

    @Nullable
    public final String getCountry() {
        return this.Country;
    }

    @Nullable
    public final Boolean getUseMailingInd() {
        return this.UseMailingInd;
    }

    @Nullable
    public final Boolean getShowStockNoUrl() {
        return this.ShowStockNoUrl;
    }

    @Nullable
    public final String getDtPickedUp() {
        return this.DtPickedUp;
    }

    @Nullable
    public final String getTrackingNumber() {
        return this.TrackingNumber;
    }

    @Nullable
    public final Boolean getInstructionOverrideInd() {
        return this.InstructionOverrideInd;
    }

    @Nullable
    public final String getBuyerNotes() {
        return this.BuyerNotes;
    }

    @Nullable
    public final String getOwnerName() {
        return this.OwnerName;
    }

    @Nullable
    public final Boolean getIsStockFinance() {
        return this.IsStockFinance;
    }

    public final int getRowNumber() {
        return this.RowNumber;
    }

    @Nullable
    public final String getState2() {
        return this.state2;
    }

    @Nullable
    public final Boolean getPublicBuyerRestrictionStateInd() {
        return this.PublicBuyerRestrictionStateInd;
    }

    @Nullable
    public final Boolean getIsTitleMailingAddressChanged() {
        return this.IsTitleMailingAddressChanged;
    }

    @Nullable
    public final String getTransportationShippingFee() {
        return this.TransportationShippingFee;
    }

    public final boolean isFeeVisible() {
        return this.isFeeVisible;
    }

    public final void setFeeVisible(boolean z) {
        this.isFeeVisible = z;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListModel$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListModel;", "getDIFF_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDIFF_CALLBACK", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SaleDocumentListModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback<SaleDocumentListModel> getDIFF_CALLBACK() {
            return SaleDocumentListModel.DIFF_CALLBACK;
        }

        public final void setDIFF_CALLBACK(@NotNull DiffUtil.ItemCallback<SaleDocumentListModel> itemCallback) {
            Intrinsics.checkParameterIsNotNull(itemCallback, "<set-?>");
            SaleDocumentListModel.DIFF_CALLBACK = itemCallback;
        }
    }
}
