package com.iaai.android;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.databinding.AcivityAccountSettingListBindingImpl;
import com.iaai.android.databinding.AcivityBdtMyAccountBindingImpl;
import com.iaai.android.databinding.AcivityManageBranchPrefBindingImpl;
import com.iaai.android.databinding.AcivityMyAccountListBindingImpl;
import com.iaai.android.databinding.ActivityAuctionMainBindingImpl;
import com.iaai.android.databinding.ActivityAuctionSalesListBindingImpl;
import com.iaai.android.databinding.ActivityAuctionSalesListLandBindingImpl;
import com.iaai.android.databinding.ActivityBdtAuctionMainBindingImpl;
import com.iaai.android.databinding.ActivityBdtFindVehicleBindingImpl;
import com.iaai.android.databinding.ActivityBdtForgotPasswordBindingImpl;
import com.iaai.android.databinding.ActivityBdtLoginBindingImpl;
import com.iaai.android.databinding.ActivityBdtMyAccountLayoutBindingImpl;
import com.iaai.android.databinding.ActivityBuyNowOfferListLandBindingImpl;
import com.iaai.android.databinding.ActivityDocumentMethodBindingImpl;
import com.iaai.android.databinding.ActivityEmailConfirmationBindingImpl;
import com.iaai.android.databinding.ActivityFastSearchFilterBindingImpl;
import com.iaai.android.databinding.ActivityFilterFragmentContainerBindingImpl;
import com.iaai.android.databinding.ActivityIaaiConditionReportLayoutBindingImpl;
import com.iaai.android.databinding.ActivityMyAccountLayoutBindingImpl;
import com.iaai.android.databinding.ActivityMyaccountBindingImpl;
import com.iaai.android.databinding.ActivityPremiumVehicleReportLayoutBindingImpl;
import com.iaai.android.databinding.ActivityProductDetailMvvmBindingImpl;
import com.iaai.android.databinding.ActivitySaleDocListBindingImpl;
import com.iaai.android.databinding.ActivitySearchPanelFindVehicleBindingImpl;
import com.iaai.android.databinding.ActivityToBePickedUpListLandBindingImpl;
import com.iaai.android.databinding.ActivityValidateOtpBindingImpl;
import com.iaai.android.databinding.ActivityWatchListLandBindingImpl;
import com.iaai.android.databinding.ContentSearchPanelFindVehicleBindingImpl;
import com.iaai.android.databinding.ContentSortSalesListBindingImpl;
import com.iaai.android.databinding.FragmentBdtAuctionMainLayoutBindingImpl;
import com.iaai.android.databinding.FragmentBdtFindVehicleLayoutBindingImpl;
import com.iaai.android.databinding.FragmentBuyNowBindingImpl;
import com.iaai.android.databinding.FragmentBuyNowOfferListBindingImpl;
import com.iaai.android.databinding.FragmentChromeSectionBindingImpl;
import com.iaai.android.databinding.FragmentCostCalculatorLayoutBindingImpl;
import com.iaai.android.databinding.FragmentDeliveryInstructionBindingImpl;
import com.iaai.android.databinding.FragmentFastSearchFilterBindingImpl;
import com.iaai.android.databinding.FragmentFilterBindingImpl;
import com.iaai.android.databinding.FragmentFindVehicleSearchLayoutBindingImpl;
import com.iaai.android.databinding.FragmentPrebidLayoutBindingImpl;
import com.iaai.android.databinding.FragmentProductDetailBindingImpl;
import com.iaai.android.databinding.FragmentRecommendedVehiclesBindingImpl;
import com.iaai.android.databinding.FragmentRefinerResultBindingImpl;
import com.iaai.android.databinding.FragmentRefinerResultLandBindingImpl;
import com.iaai.android.databinding.FragmentSalesDocumentBindingImpl;
import com.iaai.android.databinding.FragmentSavedSearchBindingImpl;
import com.iaai.android.databinding.FragmentSearchByVehicleBindingImpl;
import com.iaai.android.databinding.FragmentSelectCreditCardBindingImpl;
import com.iaai.android.databinding.FragmentSelectVehiclesBindingImpl;
import com.iaai.android.databinding.FragmentSelectVehiclesLandBindingImpl;
import com.iaai.android.databinding.FragmentToBePaidConfirmationBindingImpl;
import com.iaai.android.databinding.FragmentToBePaidReviewBindingImpl;
import com.iaai.android.databinding.FragmentTobePickedupListBindingImpl;
import com.iaai.android.databinding.FragmentWatchListBindingImpl;
import com.iaai.android.databinding.HeaderToPaidReviewBindingImpl;
import com.iaai.android.databinding.ItemAuctionDateLayoutBindingImpl;
import com.iaai.android.databinding.ItemAuctionSalesListBindingImpl;
import com.iaai.android.databinding.ItemBdtPaymentMethodsLayoutBindingImpl;
import com.iaai.android.databinding.ItemBreBadgePopupBindingImpl;
import com.iaai.android.databinding.ItemCreditCardDetailsBindingImpl;
import com.iaai.android.databinding.ItemFooterToBePaidReviewBindingImpl;
import com.iaai.android.databinding.ItemHeaderManageOfferListBindingImpl;
import com.iaai.android.databinding.ItemManageOfferListBindingImpl;
import com.iaai.android.databinding.ItemNetworkStateBindingImpl;
import com.iaai.android.databinding.ItemToPaidConfirmBindingImpl;
import com.iaai.android.databinding.ItemToPaidReviewBindingImpl;
import com.iaai.android.databinding.LayoutSaveSearchAlertPopupBindingImpl;
import com.iaai.android.databinding.LayoutSaveSearchPopupBindingImpl;
import com.iaai.android.databinding.LayoutSortLocationZipBindingImpl;
import com.iaai.android.databinding.OldActivityBdtLoginBindingImpl;
import com.iaai.android.databinding.RowHeaderDeliveryInstructionBindingImpl;
import com.iaai.android.databinding.RowItemAuctinSalesListHeaderBindingImpl;
import com.iaai.android.databinding.RowItemAuctionEmptySeparatorLayoutBindingImpl;
import com.iaai.android.databinding.RowItemAuctionMainListBindingImpl;
import com.iaai.android.databinding.RowItemAuctionMainListViewBindingImpl;
import com.iaai.android.databinding.RowItemChromeDataLayoutBindingImpl;
import com.iaai.android.databinding.RowItemClearfilterLayoutBindingImpl;
import com.iaai.android.databinding.RowItemConditionInfoBindingImpl;
import com.iaai.android.databinding.RowItemCostCalculatorBindingImpl;
import com.iaai.android.databinding.RowItemDeliveryBranchListBindingImpl;
import com.iaai.android.databinding.RowItemDeliveryInstructionBindingImpl;
import com.iaai.android.databinding.RowItemFastSearchFilterFacetCheckboxBindingImpl;
import com.iaai.android.databinding.RowItemFastSearchFilterFacetLocationBindingImpl;
import com.iaai.android.databinding.RowItemFastSearchFilterFacetRadioButtonBindingImpl;
import com.iaai.android.databinding.RowItemFastSearchFilterFacetRangeBindingImpl;
import com.iaai.android.databinding.RowItemFastSearchFilterGroupBindingImpl;
import com.iaai.android.databinding.RowItemFastSearchMoreFacetRadioButtonBindingImpl;
import com.iaai.android.databinding.RowItemFastSearchRefinerHeaderBindingImpl;
import com.iaai.android.databinding.RowItemLaneLayoutBindingImpl;
import com.iaai.android.databinding.RowItemLayoutLevel0BindingImpl;
import com.iaai.android.databinding.RowItemLayoutLevel1BindingImpl;
import com.iaai.android.databinding.RowItemLayoutLevel1SetBindingImpl;
import com.iaai.android.databinding.RowItemManageBranchPrefHeaderBindingImpl;
import com.iaai.android.databinding.RowItemManageOfferFilterBindingImpl;
import com.iaai.android.databinding.RowItemPartsBindingImpl;
import com.iaai.android.databinding.RowItemPopularCategoryLayoutBindingImpl;
import com.iaai.android.databinding.RowItemQuickFilterBindingImpl;
import com.iaai.android.databinding.RowItemQuickFilterFooterBindingImpl;
import com.iaai.android.databinding.RowItemRecommendedVehiclesBindingImpl;
import com.iaai.android.databinding.RowItemSalesLdocumentHeaderBindingImpl;
import com.iaai.android.databinding.RowItemSavedSearchBindingImpl;
import com.iaai.android.databinding.RowItemSearchSuggestionsBindingImpl;
import com.iaai.android.databinding.RowItemSortLayoutBindingImpl;
import com.iaai.android.databinding.RowItemSubFilterBindingImpl;
import com.iaai.android.databinding.RowItemVehicleImageNonHdBindingImpl;
import com.iaai.android.databinding.RowListItemManageBranchPrefBindingImpl;
import com.iaai.android.databinding.RowListItemSalesDocumentBindingImpl;
import com.iaai.android.databinding.RowListItemSelectVehiclesBindingImpl;
import com.iaai.android.databinding.RowMakeItemFilterBindingImpl;
import com.iaai.android.databinding.ToBePaidHeaderBindingImpl;
import com.iaai.android.databinding.ViewPagerProductDetailBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(111);
    private static final int LAYOUT_ACIVITYACCOUNTSETTINGLIST = 1;
    private static final int LAYOUT_ACIVITYBDTMYACCOUNT = 2;
    private static final int LAYOUT_ACIVITYMANAGEBRANCHPREF = 3;
    private static final int LAYOUT_ACIVITYMYACCOUNTLIST = 4;
    private static final int LAYOUT_ACTIVITYAUCTIONMAIN = 5;
    private static final int LAYOUT_ACTIVITYAUCTIONSALESLIST = 6;
    private static final int LAYOUT_ACTIVITYAUCTIONSALESLISTLAND = 7;
    private static final int LAYOUT_ACTIVITYBDTAUCTIONMAIN = 8;
    private static final int LAYOUT_ACTIVITYBDTFINDVEHICLE = 9;
    private static final int LAYOUT_ACTIVITYBDTFORGOTPASSWORD = 10;
    private static final int LAYOUT_ACTIVITYBDTLOGIN = 11;
    private static final int LAYOUT_ACTIVITYBDTMYACCOUNTLAYOUT = 12;
    private static final int LAYOUT_ACTIVITYBUYNOWOFFERLISTLAND = 13;
    private static final int LAYOUT_ACTIVITYDOCUMENTMETHOD = 14;
    private static final int LAYOUT_ACTIVITYEMAILCONFIRMATION = 15;
    private static final int LAYOUT_ACTIVITYFASTSEARCHFILTER = 16;
    private static final int LAYOUT_ACTIVITYFILTERFRAGMENTCONTAINER = 17;
    private static final int LAYOUT_ACTIVITYIAAICONDITIONREPORTLAYOUT = 18;
    private static final int LAYOUT_ACTIVITYMYACCOUNT = 20;
    private static final int LAYOUT_ACTIVITYMYACCOUNTLAYOUT = 19;
    private static final int LAYOUT_ACTIVITYPREMIUMVEHICLEREPORTLAYOUT = 21;
    private static final int LAYOUT_ACTIVITYPRODUCTDETAILMVVM = 22;
    private static final int LAYOUT_ACTIVITYSALEDOCLIST = 23;
    private static final int LAYOUT_ACTIVITYSEARCHPANELFINDVEHICLE = 24;
    private static final int LAYOUT_ACTIVITYTOBEPICKEDUPLISTLAND = 25;
    private static final int LAYOUT_ACTIVITYVALIDATEOTP = 26;
    private static final int LAYOUT_ACTIVITYWATCHLISTLAND = 27;
    private static final int LAYOUT_CONTENTSEARCHPANELFINDVEHICLE = 28;
    private static final int LAYOUT_CONTENTSORTSALESLIST = 29;
    private static final int LAYOUT_FRAGMENTBDTAUCTIONMAINLAYOUT = 30;
    private static final int LAYOUT_FRAGMENTBDTFINDVEHICLELAYOUT = 31;
    private static final int LAYOUT_FRAGMENTBUYNOW = 32;
    private static final int LAYOUT_FRAGMENTBUYNOWOFFERLIST = 33;
    private static final int LAYOUT_FRAGMENTCHROMESECTION = 34;
    private static final int LAYOUT_FRAGMENTCOSTCALCULATORLAYOUT = 35;
    private static final int LAYOUT_FRAGMENTDELIVERYINSTRUCTION = 36;
    private static final int LAYOUT_FRAGMENTFASTSEARCHFILTER = 37;
    private static final int LAYOUT_FRAGMENTFILTER = 38;
    private static final int LAYOUT_FRAGMENTFINDVEHICLESEARCHLAYOUT = 39;
    private static final int LAYOUT_FRAGMENTPREBIDLAYOUT = 40;
    private static final int LAYOUT_FRAGMENTPRODUCTDETAIL = 41;
    private static final int LAYOUT_FRAGMENTRECOMMENDEDVEHICLES = 42;
    private static final int LAYOUT_FRAGMENTREFINERRESULT = 43;
    private static final int LAYOUT_FRAGMENTREFINERRESULTLAND = 44;
    private static final int LAYOUT_FRAGMENTSALESDOCUMENT = 45;
    private static final int LAYOUT_FRAGMENTSAVEDSEARCH = 46;
    private static final int LAYOUT_FRAGMENTSEARCHBYVEHICLE = 47;
    private static final int LAYOUT_FRAGMENTSELECTCREDITCARD = 48;
    private static final int LAYOUT_FRAGMENTSELECTVEHICLES = 49;
    private static final int LAYOUT_FRAGMENTSELECTVEHICLESLAND = 50;
    private static final int LAYOUT_FRAGMENTTOBEPAIDCONFIRMATION = 51;
    private static final int LAYOUT_FRAGMENTTOBEPAIDREVIEW = 52;
    private static final int LAYOUT_FRAGMENTTOBEPICKEDUPLIST = 53;
    private static final int LAYOUT_FRAGMENTWATCHLIST = 54;
    private static final int LAYOUT_HEADERTOPAIDREVIEW = 55;
    private static final int LAYOUT_ITEMAUCTIONDATELAYOUT = 56;
    private static final int LAYOUT_ITEMAUCTIONSALESLIST = 57;
    private static final int LAYOUT_ITEMBDTPAYMENTMETHODSLAYOUT = 58;
    private static final int LAYOUT_ITEMBREBADGEPOPUP = 59;
    private static final int LAYOUT_ITEMCREDITCARDDETAILS = 60;
    private static final int LAYOUT_ITEMFOOTERTOBEPAIDREVIEW = 61;
    private static final int LAYOUT_ITEMHEADERMANAGEOFFERLIST = 62;
    private static final int LAYOUT_ITEMMANAGEOFFERLIST = 63;
    private static final int LAYOUT_ITEMNETWORKSTATE = 64;
    private static final int LAYOUT_ITEMTOPAIDCONFIRM = 65;
    private static final int LAYOUT_ITEMTOPAIDREVIEW = 66;
    private static final int LAYOUT_LAYOUTSAVESEARCHALERTPOPUP = 67;
    private static final int LAYOUT_LAYOUTSAVESEARCHPOPUP = 68;
    private static final int LAYOUT_LAYOUTSORTLOCATIONZIP = 69;
    private static final int LAYOUT_OLDACTIVITYBDTLOGIN = 70;
    private static final int LAYOUT_ROWHEADERDELIVERYINSTRUCTION = 71;
    private static final int LAYOUT_ROWITEMAUCTINSALESLISTHEADER = 72;
    private static final int LAYOUT_ROWITEMAUCTIONEMPTYSEPARATORLAYOUT = 73;
    private static final int LAYOUT_ROWITEMAUCTIONMAINLIST = 74;
    private static final int LAYOUT_ROWITEMAUCTIONMAINLISTVIEW = 75;
    private static final int LAYOUT_ROWITEMCHROMEDATALAYOUT = 76;
    private static final int LAYOUT_ROWITEMCLEARFILTERLAYOUT = 77;
    private static final int LAYOUT_ROWITEMCONDITIONINFO = 78;
    private static final int LAYOUT_ROWITEMCOSTCALCULATOR = 79;
    private static final int LAYOUT_ROWITEMDELIVERYBRANCHLIST = 80;
    private static final int LAYOUT_ROWITEMDELIVERYINSTRUCTION = 81;
    private static final int LAYOUT_ROWITEMFASTSEARCHFILTERFACETCHECKBOX = 82;
    private static final int LAYOUT_ROWITEMFASTSEARCHFILTERFACETLOCATION = 83;
    private static final int LAYOUT_ROWITEMFASTSEARCHFILTERFACETRADIOBUTTON = 84;
    private static final int LAYOUT_ROWITEMFASTSEARCHFILTERFACETRANGE = 85;
    private static final int LAYOUT_ROWITEMFASTSEARCHFILTERGROUP = 86;
    private static final int LAYOUT_ROWITEMFASTSEARCHMOREFACETRADIOBUTTON = 87;
    private static final int LAYOUT_ROWITEMFASTSEARCHREFINERHEADER = 88;
    private static final int LAYOUT_ROWITEMLANELAYOUT = 89;
    private static final int LAYOUT_ROWITEMLAYOUTLEVEL0 = 90;
    private static final int LAYOUT_ROWITEMLAYOUTLEVEL1 = 91;
    private static final int LAYOUT_ROWITEMLAYOUTLEVEL1SET = 92;
    private static final int LAYOUT_ROWITEMMANAGEBRANCHPREFHEADER = 93;
    private static final int LAYOUT_ROWITEMMANAGEOFFERFILTER = 94;
    private static final int LAYOUT_ROWITEMPARTS = 95;
    private static final int LAYOUT_ROWITEMPOPULARCATEGORYLAYOUT = 96;
    private static final int LAYOUT_ROWITEMQUICKFILTER = 97;
    private static final int LAYOUT_ROWITEMQUICKFILTERFOOTER = 98;
    private static final int LAYOUT_ROWITEMRECOMMENDEDVEHICLES = 99;
    private static final int LAYOUT_ROWITEMSALESLDOCUMENTHEADER = 100;
    private static final int LAYOUT_ROWITEMSAVEDSEARCH = 101;
    private static final int LAYOUT_ROWITEMSEARCHSUGGESTIONS = 102;
    private static final int LAYOUT_ROWITEMSORTLAYOUT = 103;
    private static final int LAYOUT_ROWITEMSUBFILTER = 104;
    private static final int LAYOUT_ROWITEMVEHICLEIMAGENONHD = 105;
    private static final int LAYOUT_ROWLISTITEMMANAGEBRANCHPREF = 106;
    private static final int LAYOUT_ROWLISTITEMSALESDOCUMENT = 107;
    private static final int LAYOUT_ROWLISTITEMSELECTVEHICLES = 108;
    private static final int LAYOUT_ROWMAKEITEMFILTER = 109;
    private static final int LAYOUT_TOBEPAIDHEADER = 110;
    private static final int LAYOUT_VIEWPAGERPRODUCTDETAIL = 111;

    static {
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.acivity_account_setting_list, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.acivity_bdt_my_account, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.acivity_manage_branch_pref, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.acivity_my_account_list, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_auction_main, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_auction_sales_list, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_auction_sales_list_land, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_bdt_auction_main, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_bdt_find_vehicle, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_bdt_forgot_password, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_bdt_login, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_bdt_my_account_layout, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_buy_now_offer_list_land, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_document_method, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_email_confirmation, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_fast_search_filter, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_filter_fragment_container, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_iaai_condition_report_layout, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_my_account_layout, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_myaccount, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_premium_vehicle_report_layout, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_product_detail_mvvm, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_sale_doc_list, 23);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_search_panel_find_vehicle, 24);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_to_be_picked_up_list_land, 25);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_validate_otp, 26);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.activity_watch_list_land, 27);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.content_search_panel_find_vehicle, 28);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.content_sort_sales_list, 29);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_bdt_auction_main_layout, 30);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_bdt_find_vehicle_layout, 31);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_buy_now, 32);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_buy_now_offer_list, 33);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_chrome_section, 34);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_cost_calculator_layout, 35);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_delivery_instruction, 36);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_fast_search_filter, 37);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_filter, 38);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_find_vehicle_search_layout, 39);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_prebid_layout, 40);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_product_detail, 41);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_recommended_vehicles, 42);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_refiner_result, 43);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_refiner_result_land, 44);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_sales_document, 45);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_saved_search, 46);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_search_by_vehicle, 47);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_select_credit_card, 48);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_select_vehicles, 49);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_select_vehicles_land, 50);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_to_be_paid_confirmation, 51);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_to_be_paid_review, 52);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_tobe_pickedup_list, 53);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.fragment_watch_list, 54);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.header_to_paid_review, 55);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.item_auction_date_layout, 56);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.item_auction_sales_list, 57);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.item_bdt_payment_methods_layout, 58);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.item_bre_badge_popup, 59);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.item_credit_card_details, 60);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.item_footer_to_be_paid_review, 61);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.item_header_manage_offer_list, 62);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.item_manage_offer_list, 63);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.item_network_state, 64);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.item_to_paid_confirm, 65);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.item_to_paid_review, 66);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.layout_save_search_alert_popup, 67);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.layout_save_search_popup, 68);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.layout_sort_location_zip, 69);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.old_activity_bdt_login, 70);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_header_delivery_instruction, 71);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_auctin_sales_list_header, 72);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_auction_empty_separator_layout, 73);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_auction_main_list, 74);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_auction_main_list_view, 75);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_chrome_data_layout, 76);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_clearfilter_layout, 77);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_condition_info, 78);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_cost_calculator, 79);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_delivery_branch_list, 80);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_delivery_instruction, 81);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_fast_search_filter_facet_checkbox, 82);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_fast_search_filter_facet_location, 83);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_fast_search_filter_facet_radio_button, 84);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_fast_search_filter_facet_range, 85);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_fast_search_filter_group, 86);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_fast_search_more_facet_radio_button, 87);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_fast_search_refiner_header, 88);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_lane_layout, 89);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_layout_level_0, 90);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_layout_level_1, 91);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_layout_level_1_set, 92);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_manage_branch_pref_header, 93);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_manage_offer_filter, 94);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_parts, 95);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_popular_category_layout, 96);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_quick_filter, 97);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_quick_filter_footer, 98);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_recommended_vehicles, 99);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_sales_ldocument_header, 100);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_saved_search, 101);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_search_suggestions, 102);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_sort_layout, 103);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_sub_filter, 104);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_item_vehicle_image_non_hd, 105);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_list_item_manage_branch_pref, 106);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_list_item_sales_document, 107);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_list_item_select_vehicles, 108);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.row_make_item_filter, 109);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.to_be_paid_header, 110);
        INTERNAL_LAYOUT_ID_LOOKUP.put(C2723R.C2728layout.view_pager_product_detail, 111);
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 1:
                if ("layout/acivity_account_setting_list_0".equals(obj)) {
                    return new AcivityAccountSettingListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for acivity_account_setting_list is invalid. Received: " + obj);
            case 2:
                if ("layout/acivity_bdt_my_account_0".equals(obj)) {
                    return new AcivityBdtMyAccountBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for acivity_bdt_my_account is invalid. Received: " + obj);
            case 3:
                if ("layout/acivity_manage_branch_pref_0".equals(obj)) {
                    return new AcivityManageBranchPrefBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for acivity_manage_branch_pref is invalid. Received: " + obj);
            case 4:
                if ("layout/acivity_my_account_list_0".equals(obj)) {
                    return new AcivityMyAccountListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for acivity_my_account_list is invalid. Received: " + obj);
            case 5:
                if ("layout/activity_auction_main_0".equals(obj)) {
                    return new ActivityAuctionMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_auction_main is invalid. Received: " + obj);
            case 6:
                if ("layout/activity_auction_sales_list_0".equals(obj)) {
                    return new ActivityAuctionSalesListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_auction_sales_list is invalid. Received: " + obj);
            case 7:
                if ("layout/activity_auction_sales_list_land_0".equals(obj)) {
                    return new ActivityAuctionSalesListLandBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_auction_sales_list_land is invalid. Received: " + obj);
            case 8:
                if ("layout/activity_bdt_auction_main_0".equals(obj)) {
                    return new ActivityBdtAuctionMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_bdt_auction_main is invalid. Received: " + obj);
            case 9:
                if ("layout/activity_bdt_find_vehicle_0".equals(obj)) {
                    return new ActivityBdtFindVehicleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_bdt_find_vehicle is invalid. Received: " + obj);
            case 10:
                if ("layout/activity_bdt_forgot_password_0".equals(obj)) {
                    return new ActivityBdtForgotPasswordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_bdt_forgot_password is invalid. Received: " + obj);
            case 11:
                if ("layout/activity_bdt_login_0".equals(obj)) {
                    return new ActivityBdtLoginBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_bdt_login is invalid. Received: " + obj);
            case 12:
                if ("layout/activity_bdt_my_account_layout_0".equals(obj)) {
                    return new ActivityBdtMyAccountLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_bdt_my_account_layout is invalid. Received: " + obj);
            case 13:
                if ("layout/activity_buy_now_offer_list_land_0".equals(obj)) {
                    return new ActivityBuyNowOfferListLandBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_buy_now_offer_list_land is invalid. Received: " + obj);
            case 14:
                if ("layout/activity_document_method_0".equals(obj)) {
                    return new ActivityDocumentMethodBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_document_method is invalid. Received: " + obj);
            case 15:
                if ("layout/activity_email_confirmation_0".equals(obj)) {
                    return new ActivityEmailConfirmationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_email_confirmation is invalid. Received: " + obj);
            case 16:
                if ("layout/activity_fast_search_filter_0".equals(obj)) {
                    return new ActivityFastSearchFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_fast_search_filter is invalid. Received: " + obj);
            case 17:
                if ("layout/activity_filter_fragment_container_0".equals(obj)) {
                    return new ActivityFilterFragmentContainerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_filter_fragment_container is invalid. Received: " + obj);
            case 18:
                if ("layout/activity_iaai_condition_report_layout_0".equals(obj)) {
                    return new ActivityIaaiConditionReportLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_iaai_condition_report_layout is invalid. Received: " + obj);
            case 19:
                if ("layout/activity_my_account_layout_0".equals(obj)) {
                    return new ActivityMyAccountLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_my_account_layout is invalid. Received: " + obj);
            case 20:
                if ("layout/activity_myaccount_0".equals(obj)) {
                    return new ActivityMyaccountBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_myaccount is invalid. Received: " + obj);
            case 21:
                if ("layout/activity_premium_vehicle_report_layout_0".equals(obj)) {
                    return new ActivityPremiumVehicleReportLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_premium_vehicle_report_layout is invalid. Received: " + obj);
            case 22:
                if ("layout/activity_product_detail_mvvm_0".equals(obj)) {
                    return new ActivityProductDetailMvvmBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_product_detail_mvvm is invalid. Received: " + obj);
            case 23:
                if ("layout/activity_sale_doc_list_0".equals(obj)) {
                    return new ActivitySaleDocListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_sale_doc_list is invalid. Received: " + obj);
            case 24:
                if ("layout/activity_search_panel_find_vehicle_0".equals(obj)) {
                    return new ActivitySearchPanelFindVehicleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_search_panel_find_vehicle is invalid. Received: " + obj);
            case 25:
                if ("layout/activity_to_be_picked_up_list_land_0".equals(obj)) {
                    return new ActivityToBePickedUpListLandBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_to_be_picked_up_list_land is invalid. Received: " + obj);
            case 26:
                if ("layout/activity_validate_otp_0".equals(obj)) {
                    return new ActivityValidateOtpBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_validate_otp is invalid. Received: " + obj);
            case 27:
                if ("layout/activity_watch_list_land_0".equals(obj)) {
                    return new ActivityWatchListLandBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_watch_list_land is invalid. Received: " + obj);
            case 28:
                if ("layout/content_search_panel_find_vehicle_0".equals(obj)) {
                    return new ContentSearchPanelFindVehicleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for content_search_panel_find_vehicle is invalid. Received: " + obj);
            case 29:
                if ("layout/content_sort_sales_list_0".equals(obj)) {
                    return new ContentSortSalesListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for content_sort_sales_list is invalid. Received: " + obj);
            case 30:
                if ("layout/fragment_bdt_auction_main_layout_0".equals(obj)) {
                    return new FragmentBdtAuctionMainLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_bdt_auction_main_layout is invalid. Received: " + obj);
            case 31:
                if ("layout/fragment_bdt_find_vehicle_layout_0".equals(obj)) {
                    return new FragmentBdtFindVehicleLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_bdt_find_vehicle_layout is invalid. Received: " + obj);
            case 32:
                if ("layout/fragment_buy_now_0".equals(obj)) {
                    return new FragmentBuyNowBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_buy_now is invalid. Received: " + obj);
            case 33:
                if ("layout/fragment_buy_now_offer_list_0".equals(obj)) {
                    return new FragmentBuyNowOfferListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_buy_now_offer_list is invalid. Received: " + obj);
            case 34:
                if ("layout/fragment_chrome_section_0".equals(obj)) {
                    return new FragmentChromeSectionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_chrome_section is invalid. Received: " + obj);
            case 35:
                if ("layout/fragment_cost_calculator_layout_0".equals(obj)) {
                    return new FragmentCostCalculatorLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_cost_calculator_layout is invalid. Received: " + obj);
            case 36:
                if ("layout/fragment_delivery_instruction_0".equals(obj)) {
                    return new FragmentDeliveryInstructionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_delivery_instruction is invalid. Received: " + obj);
            case 37:
                if ("layout/fragment_fast_search_filter_0".equals(obj)) {
                    return new FragmentFastSearchFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_fast_search_filter is invalid. Received: " + obj);
            case 38:
                if ("layout/fragment_filter_0".equals(obj)) {
                    return new FragmentFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_filter is invalid. Received: " + obj);
            case 39:
                if ("layout/fragment_find_vehicle_search_layout_0".equals(obj)) {
                    return new FragmentFindVehicleSearchLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_find_vehicle_search_layout is invalid. Received: " + obj);
            case 40:
                if ("layout/fragment_prebid_layout_0".equals(obj)) {
                    return new FragmentPrebidLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_prebid_layout is invalid. Received: " + obj);
            case 41:
                if ("layout/fragment_product_detail_0".equals(obj)) {
                    return new FragmentProductDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_product_detail is invalid. Received: " + obj);
            case 42:
                if ("layout/fragment_recommended_vehicles_0".equals(obj)) {
                    return new FragmentRecommendedVehiclesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_recommended_vehicles is invalid. Received: " + obj);
            case 43:
                if ("layout/fragment_refiner_result_0".equals(obj)) {
                    return new FragmentRefinerResultBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_refiner_result is invalid. Received: " + obj);
            case 44:
                if ("layout/fragment_refiner_result_land_0".equals(obj)) {
                    return new FragmentRefinerResultLandBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_refiner_result_land is invalid. Received: " + obj);
            case 45:
                if ("layout/fragment_sales_document_0".equals(obj)) {
                    return new FragmentSalesDocumentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_sales_document is invalid. Received: " + obj);
            case 46:
                if ("layout/fragment_saved_search_0".equals(obj)) {
                    return new FragmentSavedSearchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_saved_search is invalid. Received: " + obj);
            case 47:
                if ("layout/fragment_search_by_vehicle_0".equals(obj)) {
                    return new FragmentSearchByVehicleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_search_by_vehicle is invalid. Received: " + obj);
            case 48:
                if ("layout/fragment_select_credit_card_0".equals(obj)) {
                    return new FragmentSelectCreditCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_select_credit_card is invalid. Received: " + obj);
            case 49:
                if ("layout/fragment_select_vehicles_0".equals(obj)) {
                    return new FragmentSelectVehiclesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_select_vehicles is invalid. Received: " + obj);
            case 50:
                if ("layout/fragment_select_vehicles_land_0".equals(obj)) {
                    return new FragmentSelectVehiclesLandBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_select_vehicles_land is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 51:
                if ("layout/fragment_to_be_paid_confirmation_0".equals(obj)) {
                    return new FragmentToBePaidConfirmationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_to_be_paid_confirmation is invalid. Received: " + obj);
            case 52:
                if ("layout/fragment_to_be_paid_review_0".equals(obj)) {
                    return new FragmentToBePaidReviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_to_be_paid_review is invalid. Received: " + obj);
            case 53:
                if ("layout/fragment_tobe_pickedup_list_0".equals(obj)) {
                    return new FragmentTobePickedupListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tobe_pickedup_list is invalid. Received: " + obj);
            case 54:
                if ("layout/fragment_watch_list_0".equals(obj)) {
                    return new FragmentWatchListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_watch_list is invalid. Received: " + obj);
            case 55:
                if ("layout/header_to_paid_review_0".equals(obj)) {
                    return new HeaderToPaidReviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for header_to_paid_review is invalid. Received: " + obj);
            case 56:
                if ("layout/item_auction_date_layout_0".equals(obj)) {
                    return new ItemAuctionDateLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_auction_date_layout is invalid. Received: " + obj);
            case 57:
                if ("layout/item_auction_sales_list_0".equals(obj)) {
                    return new ItemAuctionSalesListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_auction_sales_list is invalid. Received: " + obj);
            case 58:
                if ("layout/item_bdt_payment_methods_layout_0".equals(obj)) {
                    return new ItemBdtPaymentMethodsLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_bdt_payment_methods_layout is invalid. Received: " + obj);
            case 59:
                if ("layout/item_bre_badge_popup_0".equals(obj)) {
                    return new ItemBreBadgePopupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_bre_badge_popup is invalid. Received: " + obj);
            case 60:
                if ("layout/item_credit_card_details_0".equals(obj)) {
                    return new ItemCreditCardDetailsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_credit_card_details is invalid. Received: " + obj);
            case 61:
                if ("layout/item_footer_to_be_paid_review_0".equals(obj)) {
                    return new ItemFooterToBePaidReviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_footer_to_be_paid_review is invalid. Received: " + obj);
            case 62:
                if ("layout/item_header_manage_offer_list_0".equals(obj)) {
                    return new ItemHeaderManageOfferListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_header_manage_offer_list is invalid. Received: " + obj);
            case 63:
                if ("layout/item_manage_offer_list_0".equals(obj)) {
                    return new ItemManageOfferListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_manage_offer_list is invalid. Received: " + obj);
            case 64:
                if ("layout/item_network_state_0".equals(obj)) {
                    return new ItemNetworkStateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_network_state is invalid. Received: " + obj);
            case 65:
                if ("layout/item_to_paid_confirm_0".equals(obj)) {
                    return new ItemToPaidConfirmBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_to_paid_confirm is invalid. Received: " + obj);
            case 66:
                if ("layout/item_to_paid_review_0".equals(obj)) {
                    return new ItemToPaidReviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_to_paid_review is invalid. Received: " + obj);
            case 67:
                if ("layout/layout_save_search_alert_popup_0".equals(obj)) {
                    return new LayoutSaveSearchAlertPopupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_save_search_alert_popup is invalid. Received: " + obj);
            case 68:
                if ("layout/layout_save_search_popup_0".equals(obj)) {
                    return new LayoutSaveSearchPopupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_save_search_popup is invalid. Received: " + obj);
            case 69:
                if ("layout/layout_sort_location_zip_0".equals(obj)) {
                    return new LayoutSortLocationZipBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_sort_location_zip is invalid. Received: " + obj);
            case 70:
                if ("layout/old_activity_bdt_login_0".equals(obj)) {
                    return new OldActivityBdtLoginBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for old_activity_bdt_login is invalid. Received: " + obj);
            case 71:
                if ("layout/row_header_delivery_instruction_0".equals(obj)) {
                    return new RowHeaderDeliveryInstructionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_header_delivery_instruction is invalid. Received: " + obj);
            case 72:
                if ("layout/row_item_auctin_sales_list_header_0".equals(obj)) {
                    return new RowItemAuctinSalesListHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_auctin_sales_list_header is invalid. Received: " + obj);
            case 73:
                if ("layout/row_item_auction_empty_separator_layout_0".equals(obj)) {
                    return new RowItemAuctionEmptySeparatorLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_auction_empty_separator_layout is invalid. Received: " + obj);
            case 74:
                if ("layout/row_item_auction_main_list_0".equals(obj)) {
                    return new RowItemAuctionMainListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_auction_main_list is invalid. Received: " + obj);
            case 75:
                if ("layout/row_item_auction_main_list_view_0".equals(obj)) {
                    return new RowItemAuctionMainListViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_auction_main_list_view is invalid. Received: " + obj);
            case 76:
                if ("layout/row_item_chrome_data_layout_0".equals(obj)) {
                    return new RowItemChromeDataLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_chrome_data_layout is invalid. Received: " + obj);
            case 77:
                if ("layout/row_item_clearfilter_layout_0".equals(obj)) {
                    return new RowItemClearfilterLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_clearfilter_layout is invalid. Received: " + obj);
            case 78:
                if ("layout/row_item_condition_info_0".equals(obj)) {
                    return new RowItemConditionInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_condition_info is invalid. Received: " + obj);
            case 79:
                if ("layout/row_item_cost_calculator_0".equals(obj)) {
                    return new RowItemCostCalculatorBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_cost_calculator is invalid. Received: " + obj);
            case 80:
                if ("layout/row_item_delivery_branch_list_0".equals(obj)) {
                    return new RowItemDeliveryBranchListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_delivery_branch_list is invalid. Received: " + obj);
            case 81:
                if ("layout/row_item_delivery_instruction_0".equals(obj)) {
                    return new RowItemDeliveryInstructionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_delivery_instruction is invalid. Received: " + obj);
            case 82:
                if ("layout/row_item_fast_search_filter_facet_checkbox_0".equals(obj)) {
                    return new RowItemFastSearchFilterFacetCheckboxBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_fast_search_filter_facet_checkbox is invalid. Received: " + obj);
            case 83:
                if ("layout/row_item_fast_search_filter_facet_location_0".equals(obj)) {
                    return new RowItemFastSearchFilterFacetLocationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_fast_search_filter_facet_location is invalid. Received: " + obj);
            case 84:
                if ("layout/row_item_fast_search_filter_facet_radio_button_0".equals(obj)) {
                    return new RowItemFastSearchFilterFacetRadioButtonBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_fast_search_filter_facet_radio_button is invalid. Received: " + obj);
            case 85:
                if ("layout/row_item_fast_search_filter_facet_range_0".equals(obj)) {
                    return new RowItemFastSearchFilterFacetRangeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_fast_search_filter_facet_range is invalid. Received: " + obj);
            case 86:
                if ("layout/row_item_fast_search_filter_group_0".equals(obj)) {
                    return new RowItemFastSearchFilterGroupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_fast_search_filter_group is invalid. Received: " + obj);
            case 87:
                if ("layout/row_item_fast_search_more_facet_radio_button_0".equals(obj)) {
                    return new RowItemFastSearchMoreFacetRadioButtonBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_fast_search_more_facet_radio_button is invalid. Received: " + obj);
            case 88:
                if ("layout/row_item_fast_search_refiner_header_0".equals(obj)) {
                    return new RowItemFastSearchRefinerHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_fast_search_refiner_header is invalid. Received: " + obj);
            case 89:
                if ("layout/row_item_lane_layout_0".equals(obj)) {
                    return new RowItemLaneLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_lane_layout is invalid. Received: " + obj);
            case 90:
                if ("layout/row_item_layout_level_0_0".equals(obj)) {
                    return new RowItemLayoutLevel0BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_layout_level_0 is invalid. Received: " + obj);
            case 91:
                if ("layout/row_item_layout_level_1_0".equals(obj)) {
                    return new RowItemLayoutLevel1BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_layout_level_1 is invalid. Received: " + obj);
            case 92:
                if ("layout/row_item_layout_level_1_set_0".equals(obj)) {
                    return new RowItemLayoutLevel1SetBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_layout_level_1_set is invalid. Received: " + obj);
            case 93:
                if ("layout/row_item_manage_branch_pref_header_0".equals(obj)) {
                    return new RowItemManageBranchPrefHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_manage_branch_pref_header is invalid. Received: " + obj);
            case 94:
                if ("layout/row_item_manage_offer_filter_0".equals(obj)) {
                    return new RowItemManageOfferFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_manage_offer_filter is invalid. Received: " + obj);
            case 95:
                if ("layout/row_item_parts_0".equals(obj)) {
                    return new RowItemPartsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_parts is invalid. Received: " + obj);
            case 96:
                if ("layout/row_item_popular_category_layout_0".equals(obj)) {
                    return new RowItemPopularCategoryLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_popular_category_layout is invalid. Received: " + obj);
            case 97:
                if ("layout/row_item_quick_filter_0".equals(obj)) {
                    return new RowItemQuickFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_quick_filter is invalid. Received: " + obj);
            case 98:
                if ("layout/row_item_quick_filter_footer_0".equals(obj)) {
                    return new RowItemQuickFilterFooterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_quick_filter_footer is invalid. Received: " + obj);
            case 99:
                if ("layout/row_item_recommended_vehicles_0".equals(obj)) {
                    return new RowItemRecommendedVehiclesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_recommended_vehicles is invalid. Received: " + obj);
            case 100:
                if ("layout/row_item_sales_ldocument_header_0".equals(obj)) {
                    return new RowItemSalesLdocumentHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_sales_ldocument_header is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding2(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 101:
                if ("layout/row_item_saved_search_0".equals(obj)) {
                    return new RowItemSavedSearchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_saved_search is invalid. Received: " + obj);
            case 102:
                if ("layout/row_item_search_suggestions_0".equals(obj)) {
                    return new RowItemSearchSuggestionsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_search_suggestions is invalid. Received: " + obj);
            case 103:
                if ("layout/row_item_sort_layout_0".equals(obj)) {
                    return new RowItemSortLayoutBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_sort_layout is invalid. Received: " + obj);
            case 104:
                if ("layout/row_item_sub_filter_0".equals(obj)) {
                    return new RowItemSubFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_sub_filter is invalid. Received: " + obj);
            case 105:
                if ("layout/row_item_vehicle_image_non_hd_0".equals(obj)) {
                    return new RowItemVehicleImageNonHdBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_item_vehicle_image_non_hd is invalid. Received: " + obj);
            case 106:
                if ("layout/row_list_item_manage_branch_pref_0".equals(obj)) {
                    return new RowListItemManageBranchPrefBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_list_item_manage_branch_pref is invalid. Received: " + obj);
            case 107:
                if ("layout/row_list_item_sales_document_0".equals(obj)) {
                    return new RowListItemSalesDocumentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_list_item_sales_document is invalid. Received: " + obj);
            case 108:
                if ("layout/row_list_item_select_vehicles_0".equals(obj)) {
                    return new RowListItemSelectVehiclesBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_list_item_select_vehicles is invalid. Received: " + obj);
            case 109:
                if ("layout/row_make_item_filter_0".equals(obj)) {
                    return new RowMakeItemFilterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for row_make_item_filter is invalid. Received: " + obj);
            case 110:
                if ("layout/to_be_paid_header_0".equals(obj)) {
                    return new ToBePaidHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for to_be_paid_header is invalid. Received: " + obj);
            case 111:
                if ("layout/view_pager_product_detail_0".equals(obj)) {
                    return new ViewPagerProductDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for view_pager_product_detail is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            int i3 = (i2 - 1) / 50;
            if (i3 == 0) {
                return internalGetViewDataBinding0(dataBindingComponent, view, i2, tag);
            }
            if (i3 == 1) {
                return internalGetViewDataBinding1(dataBindingComponent, view, i2, tag);
            }
            if (i3 != 2) {
                return null;
            }
            return internalGetViewDataBinding2(dataBindingComponent, view, i2, tag);
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys = new SparseArray<>(12);

        private InnerBrLookup() {
        }

        static {
            sKeys.put(0, "_all");
            sKeys.put(1, "reports");
            sKeys.put(2, "resultData");
            sKeys.put(3, "formattedResult");
            sKeys.put(4, "vehicleData");
            sKeys.put(5, "biddingInfo");
            sKeys.put(6, "viewModel");
            sKeys.put(7, "mobileNegotiation");
            sKeys.put(8, "location");
            sKeys.put(9, "paymentDue");
            sKeys.put(10, "vehicleSearchModel");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(111);

        private InnerLayoutIdLookup() {
        }

        static {
            sKeys.put("layout/acivity_account_setting_list_0", Integer.valueOf(C2723R.C2728layout.acivity_account_setting_list));
            sKeys.put("layout/acivity_bdt_my_account_0", Integer.valueOf(C2723R.C2728layout.acivity_bdt_my_account));
            sKeys.put("layout/acivity_manage_branch_pref_0", Integer.valueOf(C2723R.C2728layout.acivity_manage_branch_pref));
            sKeys.put("layout/acivity_my_account_list_0", Integer.valueOf(C2723R.C2728layout.acivity_my_account_list));
            sKeys.put("layout/activity_auction_main_0", Integer.valueOf(C2723R.C2728layout.activity_auction_main));
            sKeys.put("layout/activity_auction_sales_list_0", Integer.valueOf(C2723R.C2728layout.activity_auction_sales_list));
            sKeys.put("layout/activity_auction_sales_list_land_0", Integer.valueOf(C2723R.C2728layout.activity_auction_sales_list_land));
            sKeys.put("layout/activity_bdt_auction_main_0", Integer.valueOf(C2723R.C2728layout.activity_bdt_auction_main));
            sKeys.put("layout/activity_bdt_find_vehicle_0", Integer.valueOf(C2723R.C2728layout.activity_bdt_find_vehicle));
            sKeys.put("layout/activity_bdt_forgot_password_0", Integer.valueOf(C2723R.C2728layout.activity_bdt_forgot_password));
            sKeys.put("layout/activity_bdt_login_0", Integer.valueOf(C2723R.C2728layout.activity_bdt_login));
            sKeys.put("layout/activity_bdt_my_account_layout_0", Integer.valueOf(C2723R.C2728layout.activity_bdt_my_account_layout));
            sKeys.put("layout/activity_buy_now_offer_list_land_0", Integer.valueOf(C2723R.C2728layout.activity_buy_now_offer_list_land));
            sKeys.put("layout/activity_document_method_0", Integer.valueOf(C2723R.C2728layout.activity_document_method));
            sKeys.put("layout/activity_email_confirmation_0", Integer.valueOf(C2723R.C2728layout.activity_email_confirmation));
            sKeys.put("layout/activity_fast_search_filter_0", Integer.valueOf(C2723R.C2728layout.activity_fast_search_filter));
            sKeys.put("layout/activity_filter_fragment_container_0", Integer.valueOf(C2723R.C2728layout.activity_filter_fragment_container));
            sKeys.put("layout/activity_iaai_condition_report_layout_0", Integer.valueOf(C2723R.C2728layout.activity_iaai_condition_report_layout));
            sKeys.put("layout/activity_my_account_layout_0", Integer.valueOf(C2723R.C2728layout.activity_my_account_layout));
            sKeys.put("layout/activity_myaccount_0", Integer.valueOf(C2723R.C2728layout.activity_myaccount));
            sKeys.put("layout/activity_premium_vehicle_report_layout_0", Integer.valueOf(C2723R.C2728layout.activity_premium_vehicle_report_layout));
            sKeys.put("layout/activity_product_detail_mvvm_0", Integer.valueOf(C2723R.C2728layout.activity_product_detail_mvvm));
            sKeys.put("layout/activity_sale_doc_list_0", Integer.valueOf(C2723R.C2728layout.activity_sale_doc_list));
            sKeys.put("layout/activity_search_panel_find_vehicle_0", Integer.valueOf(C2723R.C2728layout.activity_search_panel_find_vehicle));
            sKeys.put("layout/activity_to_be_picked_up_list_land_0", Integer.valueOf(C2723R.C2728layout.activity_to_be_picked_up_list_land));
            sKeys.put("layout/activity_validate_otp_0", Integer.valueOf(C2723R.C2728layout.activity_validate_otp));
            sKeys.put("layout/activity_watch_list_land_0", Integer.valueOf(C2723R.C2728layout.activity_watch_list_land));
            sKeys.put("layout/content_search_panel_find_vehicle_0", Integer.valueOf(C2723R.C2728layout.content_search_panel_find_vehicle));
            sKeys.put("layout/content_sort_sales_list_0", Integer.valueOf(C2723R.C2728layout.content_sort_sales_list));
            sKeys.put("layout/fragment_bdt_auction_main_layout_0", Integer.valueOf(C2723R.C2728layout.fragment_bdt_auction_main_layout));
            sKeys.put("layout/fragment_bdt_find_vehicle_layout_0", Integer.valueOf(C2723R.C2728layout.fragment_bdt_find_vehicle_layout));
            sKeys.put("layout/fragment_buy_now_0", Integer.valueOf(C2723R.C2728layout.fragment_buy_now));
            sKeys.put("layout/fragment_buy_now_offer_list_0", Integer.valueOf(C2723R.C2728layout.fragment_buy_now_offer_list));
            sKeys.put("layout/fragment_chrome_section_0", Integer.valueOf(C2723R.C2728layout.fragment_chrome_section));
            sKeys.put("layout/fragment_cost_calculator_layout_0", Integer.valueOf(C2723R.C2728layout.fragment_cost_calculator_layout));
            sKeys.put("layout/fragment_delivery_instruction_0", Integer.valueOf(C2723R.C2728layout.fragment_delivery_instruction));
            sKeys.put("layout/fragment_fast_search_filter_0", Integer.valueOf(C2723R.C2728layout.fragment_fast_search_filter));
            sKeys.put("layout/fragment_filter_0", Integer.valueOf(C2723R.C2728layout.fragment_filter));
            sKeys.put("layout/fragment_find_vehicle_search_layout_0", Integer.valueOf(C2723R.C2728layout.fragment_find_vehicle_search_layout));
            sKeys.put("layout/fragment_prebid_layout_0", Integer.valueOf(C2723R.C2728layout.fragment_prebid_layout));
            sKeys.put("layout/fragment_product_detail_0", Integer.valueOf(C2723R.C2728layout.fragment_product_detail));
            sKeys.put("layout/fragment_recommended_vehicles_0", Integer.valueOf(C2723R.C2728layout.fragment_recommended_vehicles));
            sKeys.put("layout/fragment_refiner_result_0", Integer.valueOf(C2723R.C2728layout.fragment_refiner_result));
            sKeys.put("layout/fragment_refiner_result_land_0", Integer.valueOf(C2723R.C2728layout.fragment_refiner_result_land));
            sKeys.put("layout/fragment_sales_document_0", Integer.valueOf(C2723R.C2728layout.fragment_sales_document));
            sKeys.put("layout/fragment_saved_search_0", Integer.valueOf(C2723R.C2728layout.fragment_saved_search));
            sKeys.put("layout/fragment_search_by_vehicle_0", Integer.valueOf(C2723R.C2728layout.fragment_search_by_vehicle));
            sKeys.put("layout/fragment_select_credit_card_0", Integer.valueOf(C2723R.C2728layout.fragment_select_credit_card));
            sKeys.put("layout/fragment_select_vehicles_0", Integer.valueOf(C2723R.C2728layout.fragment_select_vehicles));
            sKeys.put("layout/fragment_select_vehicles_land_0", Integer.valueOf(C2723R.C2728layout.fragment_select_vehicles_land));
            sKeys.put("layout/fragment_to_be_paid_confirmation_0", Integer.valueOf(C2723R.C2728layout.fragment_to_be_paid_confirmation));
            sKeys.put("layout/fragment_to_be_paid_review_0", Integer.valueOf(C2723R.C2728layout.fragment_to_be_paid_review));
            sKeys.put("layout/fragment_tobe_pickedup_list_0", Integer.valueOf(C2723R.C2728layout.fragment_tobe_pickedup_list));
            sKeys.put("layout/fragment_watch_list_0", Integer.valueOf(C2723R.C2728layout.fragment_watch_list));
            sKeys.put("layout/header_to_paid_review_0", Integer.valueOf(C2723R.C2728layout.header_to_paid_review));
            sKeys.put("layout/item_auction_date_layout_0", Integer.valueOf(C2723R.C2728layout.item_auction_date_layout));
            sKeys.put("layout/item_auction_sales_list_0", Integer.valueOf(C2723R.C2728layout.item_auction_sales_list));
            sKeys.put("layout/item_bdt_payment_methods_layout_0", Integer.valueOf(C2723R.C2728layout.item_bdt_payment_methods_layout));
            sKeys.put("layout/item_bre_badge_popup_0", Integer.valueOf(C2723R.C2728layout.item_bre_badge_popup));
            sKeys.put("layout/item_credit_card_details_0", Integer.valueOf(C2723R.C2728layout.item_credit_card_details));
            sKeys.put("layout/item_footer_to_be_paid_review_0", Integer.valueOf(C2723R.C2728layout.item_footer_to_be_paid_review));
            sKeys.put("layout/item_header_manage_offer_list_0", Integer.valueOf(C2723R.C2728layout.item_header_manage_offer_list));
            sKeys.put("layout/item_manage_offer_list_0", Integer.valueOf(C2723R.C2728layout.item_manage_offer_list));
            sKeys.put("layout/item_network_state_0", Integer.valueOf(C2723R.C2728layout.item_network_state));
            sKeys.put("layout/item_to_paid_confirm_0", Integer.valueOf(C2723R.C2728layout.item_to_paid_confirm));
            sKeys.put("layout/item_to_paid_review_0", Integer.valueOf(C2723R.C2728layout.item_to_paid_review));
            sKeys.put("layout/layout_save_search_alert_popup_0", Integer.valueOf(C2723R.C2728layout.layout_save_search_alert_popup));
            sKeys.put("layout/layout_save_search_popup_0", Integer.valueOf(C2723R.C2728layout.layout_save_search_popup));
            sKeys.put("layout/layout_sort_location_zip_0", Integer.valueOf(C2723R.C2728layout.layout_sort_location_zip));
            sKeys.put("layout/old_activity_bdt_login_0", Integer.valueOf(C2723R.C2728layout.old_activity_bdt_login));
            sKeys.put("layout/row_header_delivery_instruction_0", Integer.valueOf(C2723R.C2728layout.row_header_delivery_instruction));
            sKeys.put("layout/row_item_auctin_sales_list_header_0", Integer.valueOf(C2723R.C2728layout.row_item_auctin_sales_list_header));
            sKeys.put("layout/row_item_auction_empty_separator_layout_0", Integer.valueOf(C2723R.C2728layout.row_item_auction_empty_separator_layout));
            sKeys.put("layout/row_item_auction_main_list_0", Integer.valueOf(C2723R.C2728layout.row_item_auction_main_list));
            sKeys.put("layout/row_item_auction_main_list_view_0", Integer.valueOf(C2723R.C2728layout.row_item_auction_main_list_view));
            sKeys.put("layout/row_item_chrome_data_layout_0", Integer.valueOf(C2723R.C2728layout.row_item_chrome_data_layout));
            sKeys.put("layout/row_item_clearfilter_layout_0", Integer.valueOf(C2723R.C2728layout.row_item_clearfilter_layout));
            sKeys.put("layout/row_item_condition_info_0", Integer.valueOf(C2723R.C2728layout.row_item_condition_info));
            sKeys.put("layout/row_item_cost_calculator_0", Integer.valueOf(C2723R.C2728layout.row_item_cost_calculator));
            sKeys.put("layout/row_item_delivery_branch_list_0", Integer.valueOf(C2723R.C2728layout.row_item_delivery_branch_list));
            sKeys.put("layout/row_item_delivery_instruction_0", Integer.valueOf(C2723R.C2728layout.row_item_delivery_instruction));
            sKeys.put("layout/row_item_fast_search_filter_facet_checkbox_0", Integer.valueOf(C2723R.C2728layout.row_item_fast_search_filter_facet_checkbox));
            sKeys.put("layout/row_item_fast_search_filter_facet_location_0", Integer.valueOf(C2723R.C2728layout.row_item_fast_search_filter_facet_location));
            sKeys.put("layout/row_item_fast_search_filter_facet_radio_button_0", Integer.valueOf(C2723R.C2728layout.row_item_fast_search_filter_facet_radio_button));
            sKeys.put("layout/row_item_fast_search_filter_facet_range_0", Integer.valueOf(C2723R.C2728layout.row_item_fast_search_filter_facet_range));
            sKeys.put("layout/row_item_fast_search_filter_group_0", Integer.valueOf(C2723R.C2728layout.row_item_fast_search_filter_group));
            sKeys.put("layout/row_item_fast_search_more_facet_radio_button_0", Integer.valueOf(C2723R.C2728layout.row_item_fast_search_more_facet_radio_button));
            sKeys.put("layout/row_item_fast_search_refiner_header_0", Integer.valueOf(C2723R.C2728layout.row_item_fast_search_refiner_header));
            sKeys.put("layout/row_item_lane_layout_0", Integer.valueOf(C2723R.C2728layout.row_item_lane_layout));
            sKeys.put("layout/row_item_layout_level_0_0", Integer.valueOf(C2723R.C2728layout.row_item_layout_level_0));
            sKeys.put("layout/row_item_layout_level_1_0", Integer.valueOf(C2723R.C2728layout.row_item_layout_level_1));
            sKeys.put("layout/row_item_layout_level_1_set_0", Integer.valueOf(C2723R.C2728layout.row_item_layout_level_1_set));
            sKeys.put("layout/row_item_manage_branch_pref_header_0", Integer.valueOf(C2723R.C2728layout.row_item_manage_branch_pref_header));
            sKeys.put("layout/row_item_manage_offer_filter_0", Integer.valueOf(C2723R.C2728layout.row_item_manage_offer_filter));
            sKeys.put("layout/row_item_parts_0", Integer.valueOf(C2723R.C2728layout.row_item_parts));
            sKeys.put("layout/row_item_popular_category_layout_0", Integer.valueOf(C2723R.C2728layout.row_item_popular_category_layout));
            sKeys.put("layout/row_item_quick_filter_0", Integer.valueOf(C2723R.C2728layout.row_item_quick_filter));
            sKeys.put("layout/row_item_quick_filter_footer_0", Integer.valueOf(C2723R.C2728layout.row_item_quick_filter_footer));
            sKeys.put("layout/row_item_recommended_vehicles_0", Integer.valueOf(C2723R.C2728layout.row_item_recommended_vehicles));
            sKeys.put("layout/row_item_sales_ldocument_header_0", Integer.valueOf(C2723R.C2728layout.row_item_sales_ldocument_header));
            sKeys.put("layout/row_item_saved_search_0", Integer.valueOf(C2723R.C2728layout.row_item_saved_search));
            sKeys.put("layout/row_item_search_suggestions_0", Integer.valueOf(C2723R.C2728layout.row_item_search_suggestions));
            sKeys.put("layout/row_item_sort_layout_0", Integer.valueOf(C2723R.C2728layout.row_item_sort_layout));
            sKeys.put("layout/row_item_sub_filter_0", Integer.valueOf(C2723R.C2728layout.row_item_sub_filter));
            sKeys.put("layout/row_item_vehicle_image_non_hd_0", Integer.valueOf(C2723R.C2728layout.row_item_vehicle_image_non_hd));
            sKeys.put("layout/row_list_item_manage_branch_pref_0", Integer.valueOf(C2723R.C2728layout.row_list_item_manage_branch_pref));
            sKeys.put("layout/row_list_item_sales_document_0", Integer.valueOf(C2723R.C2728layout.row_list_item_sales_document));
            sKeys.put("layout/row_list_item_select_vehicles_0", Integer.valueOf(C2723R.C2728layout.row_list_item_select_vehicles));
            sKeys.put("layout/row_make_item_filter_0", Integer.valueOf(C2723R.C2728layout.row_make_item_filter));
            sKeys.put("layout/to_be_paid_header_0", Integer.valueOf(C2723R.C2728layout.to_be_paid_header));
            sKeys.put("layout/view_pager_product_detail_0", Integer.valueOf(C2723R.C2728layout.view_pager_product_detail));
        }
    }
}
