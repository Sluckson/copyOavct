package com.iaai.android.bdt.feature.account.salesdocument;

import android.content.Intent;
import android.view.View;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryMethodActivity;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SalesDocumentFragment.kt */
final class SalesDocumentFragment$initializeUI$1 implements View.OnClickListener {
    final /* synthetic */ SalesDocumentFragment this$0;

    SalesDocumentFragment$initializeUI$1(SalesDocumentFragment salesDocumentFragment) {
        this.this$0 = salesDocumentFragment;
    }

    public final void onClick(View view) {
        String str;
        String str2;
        String str3;
        this.this$0.stockList.clear();
        List<SaleDocumentListModel> saleDocumentListModelList = this.this$0.getSaleDocumentListModelList();
        if (saleDocumentListModelList != null) {
            for (SaleDocumentListModel saleDocumentListModel : saleDocumentListModelList) {
                String additionalNotes = saleDocumentListModel.getAdditionalNotes();
                String address1 = saleDocumentListModel.getAddress1();
                String address2 = saleDocumentListModel.getAddress2();
                Integer branchCode = saleDocumentListModel.getBranchCode();
                int intValue = branchCode != null ? branchCode.intValue() : 0;
                String branchName = saleDocumentListModel.getBranchName();
                String str4 = branchName != null ? branchName : "";
                Integer buyerId = saleDocumentListModel.getBuyerId();
                int intValue2 = buyerId != null ? buyerId.intValue() : 0;
                String buyerNotes = saleDocumentListModel.getBuyerNotes();
                Integer buyerTitleHandlingInstructionID = saleDocumentListModel.getBuyerTitleHandlingInstructionID();
                int intValue3 = buyerTitleHandlingInstructionID != null ? buyerTitleHandlingInstructionID.intValue() : 0;
                String city = saleDocumentListModel.getCity();
                String companyName = saleDocumentListModel.getCompanyName();
                String country = saleDocumentListModel.getCountry();
                String dtPickedUp = saleDocumentListModel.getDtPickedUp();
                Integer employeeId = saleDocumentListModel.getEmployeeId();
                int intValue4 = employeeId != null ? employeeId.intValue() : 0;
                String valueOf = String.valueOf(saleDocumentListModel.getFedexAccountNumber());
                Boolean instructionOverrideInd = saleDocumentListModel.getInstructionOverrideInd();
                boolean booleanValue = instructionOverrideInd != null ? instructionOverrideInd.booleanValue() : false;
                Boolean isStockFinance = saleDocumentListModel.getIsStockFinance();
                boolean booleanValue2 = isStockFinance != null ? isStockFinance.booleanValue() : false;
                Boolean isTitleMailingAddressChanged = saleDocumentListModel.getIsTitleMailingAddressChanged();
                boolean booleanValue3 = isTitleMailingAddressChanged != null ? isTitleMailingAddressChanged.booleanValue() : false;
                Integer oAAuctionItemId = saleDocumentListModel.getOAAuctionItemId();
                int intValue5 = oAAuctionItemId != null ? oAAuctionItemId.intValue() : 0;
                Boolean offsiteSaleInd = saleDocumentListModel.getOffsiteSaleInd();
                boolean booleanValue4 = offsiteSaleInd != null ? offsiteSaleInd.booleanValue() : false;
                String ownerName = saleDocumentListModel.getOwnerName();
                String phoneNumber = saleDocumentListModel.getPhoneNumber();
                Boolean publicBuyerRestrictionStateInd = saleDocumentListModel.getPublicBuyerRestrictionStateInd();
                boolean booleanValue5 = publicBuyerRestrictionStateInd != null ? publicBuyerRestrictionStateInd.booleanValue() : false;
                String representativeName = saleDocumentListModel.getRepresentativeName();
                int rowNumber = saleDocumentListModel.getRowNumber();
                Integer salvageID = saleDocumentListModel.getSalvageID();
                int intValue6 = salvageID != null ? salvageID.intValue() : 0;
                Integer salvageSaleID = saleDocumentListModel.getSalvageSaleID();
                int intValue7 = salvageSaleID != null ? salvageSaleID.intValue() : 0;
                Boolean showStockNoUrl = saleDocumentListModel.getShowStockNoUrl();
                boolean booleanValue6 = showStockNoUrl != null ? showStockNoUrl.booleanValue() : false;
                String state1 = saleDocumentListModel.getState1();
                String stockNumber = saleDocumentListModel.getStockNumber();
                if (stockNumber != null) {
                    str = stockNumber;
                } else {
                    str = "";
                }
                String titleDeliveryMethodCode = saleDocumentListModel.getTitleDeliveryMethodCode();
                String titleStatus = saleDocumentListModel.getTitleStatus();
                String trackingNumber = saleDocumentListModel.getTrackingNumber();
                String transportationShippingFee = saleDocumentListModel.getTransportationShippingFee();
                String valueOf2 = String.valueOf(saleDocumentListModel.getUseMailingInd());
                String vin = saleDocumentListModel.getVIN();
                if (vin != null) {
                    str2 = vin;
                } else {
                    str2 = "";
                }
                String vehicleDescription = saleDocumentListModel.getVehicleDescription();
                if (vehicleDescription != null) {
                    str3 = vehicleDescription;
                } else {
                    str3 = "";
                }
                String zipCode = saleDocumentListModel.getZipCode();
                String thumbnailUrl = saleDocumentListModel.getThumbnailUrl();
                boolean isSelected = saleDocumentListModel.isSelected();
                TitleInstructionItem titleInstructionItem = r3;
                TitleInstructionItem titleInstructionItem2 = new TitleInstructionItem(additionalNotes, address1, address2, intValue, str4, intValue2, buyerNotes, intValue3, city, companyName, country, dtPickedUp, intValue4, valueOf, booleanValue, booleanValue2, booleanValue3, intValue5, booleanValue4, ownerName, phoneNumber, booleanValue5, representativeName, rowNumber, intValue6, intValue7, booleanValue6, state1, str, titleDeliveryMethodCode, titleStatus, trackingNumber, transportationShippingFee, valueOf2, str2, str3, zipCode, thumbnailUrl, isSelected);
                this.this$0.stockList.add(titleInstructionItem);
            }
        }
        Intent intent = new Intent(SalesDocumentFragment.access$getSalesDocumentActivity$p(this.this$0), DeliveryMethodActivity.class);
        ArrayList access$getStockList$p = this.this$0.stockList;
        if (access$getStockList$p != null) {
            intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_LIST, access$getStockList$p);
            intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_BRANCH_LIST, Constants_MVVM.SetDeliveryAction.IS_FROM_PAYPAl_LIST.getValue());
            this.this$0.startActivityForResult(intent, 41);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<out android.os.Parcelable>");
    }
}
