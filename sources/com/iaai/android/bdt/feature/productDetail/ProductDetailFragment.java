package com.iaai.android.bdt.feature.productDetail;

import android.app.Application;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.braintreepayments.api.models.BinData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.github.anastr.speedviewlib.TubeSpeedometer;
import com.github.anastr.speedviewlib.components.Section;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.base.DynamicLinkCallback;
import com.iaai.android.bdt.base.PermissionHelper;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity;
import com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity;
import com.iaai.android.bdt.feature.landing.LandingBRESectionActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity;
import com.iaai.android.bdt.feature.productDetail.vehicleimage.NonHDFullImagesActivity;
import com.iaai.android.bdt.feature.productDetail.vehicleimage.Product360ImageActivity;
import com.iaai.android.bdt.feature.productDetail.vehicleimage.ProductHDImageActivity;
import com.iaai.android.bdt.feature.utilsActivity.WebViewActivity;
import com.iaai.android.bdt.model.productDetail.VehicledetailsNonUS;
import com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ConditionInfo;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ConditionInformation;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ConditionReports;
import com.iaai.android.bdt.model.productDetail.biddingInfo.DisplayValue;
import com.iaai.android.bdt.model.productDetail.biddingInfo.Image;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ImageInformation;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailErrorModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse;
import com.iaai.android.bdt.model.productDetail.biddingInfo.Reports;
import com.iaai.android.bdt.model.productDetail.biddingInfo.SaleInfo;
import com.iaai.android.bdt.model.productDetail.biddingInfo.SaleInformation;
import com.iaai.android.bdt.model.productDetail.biddingInfo.VINInfo;
import com.iaai.android.bdt.model.productDetail.biddingInfo.VehicleGradeInformation;
import com.iaai.android.bdt.model.productDetail.biddingInfo.VinDetails;
import com.iaai.android.bdt.model.productDetail.biddingInfo.WarningTextModel;
import com.iaai.android.bdt.model.productDetail.buyNowOffer.BDTBuyNowOfferResult;
import com.iaai.android.bdt.model.productDetail.partsSection.PartsSectionResponse;
import com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.bdt.utils.NonHDImagesMode;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.databinding.FragmentProductDetailBinding;
import com.iaai.android.old.managers.BidManager;
import com.iaai.android.old.managers.TermsOfUseBlendedSaleManager;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.UiUtils;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import dagger.android.support.AndroidSupportInjection;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p052cz.msebera.android.httpclient.protocol.HTTP;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ¼\u00022\u00020\u00012\u00020\u0002:\u0002¼\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020\u00052\b\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020\u0005H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0015\u0010\u0001\u001a\u00020\u00052\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u001a\u0010\u0001\u001a\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010IH\u0002J\u001a\u0010\u0001\u001a\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010IH\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0007H\u0002J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010 \u0001\u001a\u00020\u0005H\u0002J\n\u0010¡\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010¢\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010£\u0001\u001a\u00030\u0001H\u0002J\n\u0010¤\u0001\u001a\u00030\u0001H\u0002J\n\u0010¥\u0001\u001a\u00030\u0001H\u0002J7\u0010¦\u0001\u001a\u00020\u001a2\u0007\u0010§\u0001\u001a\u00020\u00072\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u001a2\u0007\u0010©\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020\u001aH\u0002J\n\u0010«\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010¬\u0001\u001a\u00030\u00012\u0007\u0010­\u0001\u001a\u00020\u0005H\u0002J\n\u0010®\u0001\u001a\u00030\u0001H\u0002J\u0015\u0010¯\u0001\u001a\u00020\u00052\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010°\u0001\u001a\u00020\u0005H\u0002J\u0013\u0010±\u0001\u001a\u00030\u00012\u0007\u0010²\u0001\u001a\u00020\u0007H\u0002J\n\u0010³\u0001\u001a\u00030\u0001H\u0002J\n\u0010´\u0001\u001a\u00030\u0001H\u0002J\u001d\u0010µ\u0001\u001a\u00030\u00012\u0007\u0010¶\u0001\u001a\u00020\u001a2\b\u0010·\u0001\u001a\u00030¸\u0001H\u0002J\"\u0010¹\u0001\u001a\u00030\u00012\n\u0010º\u0001\u001a\u0005\u0018\u00010»\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001H\u0002J\n\u0010¾\u0001\u001a\u00030\u0001H\u0002J\n\u0010¿\u0001\u001a\u00030\u0001H\u0002J\u0016\u0010À\u0001\u001a\u00030\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001H\u0002J\u0016\u0010Á\u0001\u001a\u00030\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0002J&\u0010Ä\u0001\u001a\u00030\u00012\u0007\u0010Å\u0001\u001a\u00020\u00052\u0007\u0010Æ\u0001\u001a\u00020\u00072\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0002J\u001e\u0010É\u0001\u001a\u00030\u00012\b\u0010Ê\u0001\u001a\u00030Ë\u00012\b\u0010Ì\u0001\u001a\u00030Í\u0001H\u0002J\n\u0010Î\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ï\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ð\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010Ñ\u0001\u001a\u00030\u00012\u0007\u0010Æ\u0001\u001a\u00020\u0007H\u0002J\n\u0010Ò\u0001\u001a\u00030\u0001H\u0002J\n\u0010Ó\u0001\u001a\u00030\u0001H\u0002J\u0016\u0010Ô\u0001\u001a\u00030\u00012\n\u0010Õ\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J(\u0010Ö\u0001\u001a\u00030\u00012\u0007\u0010×\u0001\u001a\u00020\u001a2\u0007\u0010Ø\u0001\u001a\u00020\u001a2\n\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u0001H\u0016J\u0014\u0010Û\u0001\u001a\u00030\u00012\b\u0010Ü\u0001\u001a\u00030Ý\u0001H\u0016J\u0014\u0010Þ\u0001\u001a\u00030\u00012\b\u0010ß\u0001\u001a\u00030à\u0001H\u0016J\u0016\u0010á\u0001\u001a\u00030\u00012\n\u0010Õ\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J.\u0010â\u0001\u001a\u0005\u0018\u00010ã\u00012\b\u0010ä\u0001\u001a\u00030å\u00012\n\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u00012\n\u0010Õ\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\n\u0010è\u0001\u001a\u00030\u0001H\u0016J\n\u0010é\u0001\u001a\u00030\u0001H\u0016J3\u0010ê\u0001\u001a\u00030\u00012\u0007\u0010×\u0001\u001a\u00020\u001a2\u000e\u0010ë\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070ì\u00012\b\u0010í\u0001\u001a\u00030î\u0001H\u0016¢\u0006\u0003\u0010ï\u0001J\n\u0010ð\u0001\u001a\u00030\u0001H\u0016J \u0010ñ\u0001\u001a\u00030\u00012\b\u0010ò\u0001\u001a\u00030ã\u00012\n\u0010Õ\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0013\u0010ó\u0001\u001a\u00030\u00012\u0007\u0010ô\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010õ\u0001\u001a\u00030\u00012\u0007\u0010ö\u0001\u001a\u00020\u0007H\u0016J\n\u0010÷\u0001\u001a\u00030\u0001H\u0002J\n\u0010ø\u0001\u001a\u00030\u0001H\u0002J\n\u0010ù\u0001\u001a\u00030\u0001H\u0002J\n\u0010ú\u0001\u001a\u00030\u0001H\u0002J\n\u0010û\u0001\u001a\u00030\u0001H\u0002J\u0019\u0010ü\u0001\u001a\u00030\u00012\t\u0010ý\u0001\u001a\u0004\u0018\u00010!¢\u0006\u0003\u0010þ\u0001J\n\u0010ÿ\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u0005H\u0016J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u0007H\u0002J\t\u0010\u0002\u001a\u00020\u0007H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u0005H\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u0005H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\u0016\u0010\u0002\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0014\u0010\u0002\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010\u0002\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\u0016\u0010\u0002\u001a\u00030\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0002J&\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010 \u0001\u001a\u00020\u00052\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u0014\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0002H\u0002J\u001f\u0010\u0002\u001a\u00030\u00012\n\u0010\u0002\u001a\u0005\u0018\u00010\u00022\u0007\u0010\u0002\u001a\u00020\u0007H\u0002J\u0014\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0002H\u0002J\u0014\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0002H\u0002J\n\u0010 \u0002\u001a\u00030\u0001H\u0002J\n\u0010¡\u0002\u001a\u00030\u0001H\u0002J\u0016\u0010¢\u0002\u001a\u00030\u00012\n\u0010£\u0002\u001a\u0005\u0018\u00010¤\u0002H\u0002J\u0015\u0010¥\u0002\u001a\u00030\u00012\t\u0010¦\u0002\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010§\u0002\u001a\u00030\u00012\n\u0010¨\u0002\u001a\u0005\u0018\u00010©\u0002H\u0002J\u0016\u0010ª\u0002\u001a\u00030\u00012\n\u0010¨\u0002\u001a\u0005\u0018\u00010©\u0002H\u0002J\u0016\u0010«\u0002\u001a\u00030\u00012\n\u0010¨\u0002\u001a\u0005\u0018\u00010©\u0002H\u0002J\u001c\u0010¬\u0002\u001a\u00030\u00012\u0007\u0010­\u0002\u001a\u00020\u00052\u0007\u0010­\u0001\u001a\u00020\u001aH\u0002J\u0013\u0010®\u0002\u001a\u00030\u00012\u0007\u0010¯\u0002\u001a\u00020\u0007H\u0002J\u0016\u0010°\u0002\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0013\u0010±\u0002\u001a\u00030\u00012\u0007\u0010ª\u0001\u001a\u00020\u001aH\u0002J%\u0010²\u0002\u001a\u00030\u00012\u000f\u0010³\u0002\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010I2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u0010´\u0002\u001a\u00030\u00012\b\u0010`\u001a\u0004\u0018\u00010\u00072\b\u0010z\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010µ\u0002\u001a\u00030\u00012\n\u0010¶\u0002\u001a\u0005\u0018\u00010·\u0002H\u0002J\n\u0010¸\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010¹\u0002\u001a\u00030\u00012\u0007\u0010º\u0002\u001a\u00020\u0005H\u0002J&\u0010»\u0002\u001a\u00030\u00012\u0007\u0010Å\u0001\u001a\u00020\u00052\u0007\u0010Æ\u0001\u001a\u00020\u00072\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX.¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020J0IX.¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX.¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010V\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0004\n\u0002\u0010WR\u001e\u0010X\u001a\u00020Y8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u000e\u0010^\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010_\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0004\n\u0002\u0010WR\u000e\u0010`\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010c\u001a\u00020dX.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u000e\u0010i\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010n\u001a\b\u0012\u0004\u0012\u00020o0IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020sX.¢\u0006\u0002\n\u0000R\u001e\u0010t\u001a\u00020u8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u000e\u0010z\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X.¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006½\u0002"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/ProductDetailFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "Lcom/iaai/android/bdt/base/DynamicLinkCallback;", "()V", "IsUpstreamBranchStock", "", "TAG", "", "kotlin.jvm.PlatformType", "action", "auctionDate", "auctionId", "awardMessage", "baseActivity", "Lcom/iaai/android/bdt/base/BaseActivity;", "baseFragment", "bidManager", "Lcom/iaai/android/old/managers/BidManager;", "getBidManager", "()Lcom/iaai/android/old/managers/BidManager;", "setBidManager", "(Lcom/iaai/android/old/managers/BidManager;)V", "bidStatusIcon", "branchCode", "branchName", "buyNowOfferAmount", "", "buyNowPrice", "chromeIndicator", "conditionInfoAdapter", "Lcom/iaai/android/bdt/feature/productDetail/ConditionInfoAdapter;", "conditionReport", "currentBid", "", "displaySaleTaxWarning", "displaySaleTextMessage", "downloadCompleteReceiver", "Landroid/content/BroadcastReceiver;", "engineURL", "engineVideoIndex", "estimatedBid", "estimatedFinalCost", "formattedMyMax", "ibfAwardMessage", "ibfPaymentDueDate", "ibfPickUpDate", "image360URL", "imageListener", "Lcom/synnapps/carouselview/ImageListener;", "isAuctionComplete", "isBidLive", "isBuyNowButtonClick", "isEngineVideoPresent", "isKeyImagePresent", "isLoggedIn", "isPartsIndicator", "isPreBidButtonClick", "isPublic", "isTimedAuction", "isTransportationQuotesAvailable", "isViewAvalibale", "isViewMore", "isWatchingButtonClick", "itemId", "keyIndex", "liveDate", "liveDateString", "make", "model", "myMax", "partsInfoAdapter", "Lcom/iaai/android/bdt/feature/productDetail/PartsInfoAdapter;", "partsList", "", "Lcom/iaai/android/bdt/model/productDetail/partsSection/PartsSectionResponse;", "paymentDueDate", "permissionHelper", "Lcom/iaai/android/bdt/base/PermissionHelper;", "pickUpDate", "preBidCurrentBid", "preBidErrorMsg", "preBidIncrement", "preBidTimeRemaining", "saleInformation", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/SaleInformation;", "salesForceVehicleConditionGradeURL", "salvageId", "Ljava/lang/Integer;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "shouldFetchPartsInfo", "startingBid", "stockNumber", "tboInd", "tenantCode", "termsOfUseManager", "Lcom/iaai/android/old/managers/TermsOfUseBlendedSaleManager;", "getTermsOfUseManager", "()Lcom/iaai/android/old/managers/TermsOfUseBlendedSaleManager;", "setTermsOfUseManager", "(Lcom/iaai/android/old/managers/TermsOfUseBlendedSaleManager;)V", "timeLeftToBuy", "tireIndex", "totalCount", "userId", "userTimezoneAbb", "vehicleImages", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/Image;", "vehicleLoc", "vehicleStatus", "viewModel", "Lcom/iaai/android/bdt/feature/productDetail/ProductDetailViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "vin", "vininfoAdapter", "Lcom/iaai/android/bdt/feature/productDetail/VinInfoAdapter;", "year", "yearModel", "zip", "acceptBuyNowOfferServiceCall", "", "addToWatchList", "checkDownloadStatus", "enqueId", "", "checkForInValidUser", "checkGustUser", "checkNetworkConnection", "checkUserValidAndBidBuyClick", "prebidInformation", "Lcom/iaai/android/bdt/model/productDetail/prebid/PrebidInformation;", "clearCostCalculatorSharedPreference", "declineBuyNowOfferServiceCall", "disableActionAreaButtons", "disableWatchButton", "displayConditionInfo", "conditionInfoList", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionInfo;", "displayVinDetailsInfo", "vinInfoList", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VINInfo;", "enableActionAreaButtons", "fetchPartsInfo", "fetchProductDetail", "formatWarningTextToHTML", "textView", "Landroid/widget/TextView;", "warningText", "getBundleForActionArea", "Landroid/os/Bundle;", "isBuyNow", "isPreBid", "getChromeSectionData", "handleBuyNowOfferDisplaySection", "handleGradeContainerVisibility", "handlePermissionCallbacksForWriteStorage", "iBidLive", "inflateSalesInfo", "label", "value", "remoteSaleInfoText", "visibility", "initializeNonUsUI", "initializeShareForTablet", "isVisible", "initializeUI", "isAuctionCompleted", "isPartsInfoAvailable", "launch360ImageActivity", "imager_URL", "launchHDImageActivity", "launchIBidLive", "launchNonHDActivity", "position", "mode", "Lcom/iaai/android/bdt/utils/NonHDImagesMode;", "loadConditionInfo", "conditionInformation", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionInformation;", "conditionReports", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionReports;", "loadFindParts", "loadPartsInfo", "loadReport", "loadVehicleGradeInformation", "vehicleGradeInformation", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VehicleGradeInformation;", "loadVehicleImageUrlForAndroidOS7", "fromNetwork", "url", "imageView", "Landroid/widget/ImageView;", "makeLinkClickable", "strBuilder", "Landroid/text/SpannableStringBuilder;", "span", "Landroid/text/style/URLSpan;", "navigateToBuyNowPage", "navigateToBuyNowPageIfAlreadyLogin", "navigateToCostCalculator", "navigateToLicencedBorkerPage", "navigateToPreBidPage", "navigateToPreBidPageIfAlreadyLogin", "onActivityCreated", "savedInstanceState", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onViewCreated", "view", "playEngineVideoSound", "engineVideo", "postShortLinkURL", "shortLinkURL", "removeFromWatchList", "sendFireBaseEventBuyNowOfferSuccess", "setInitialiseUIAsPerTenant", "setNonUsLabelText", "setOnClickListeners", "setTubeSpeedOmeter", "tubeSpeedometerValue", "(Ljava/lang/Float;)V", "setUpShareButtonClick", "setUserVisibleHint", "isVisibleToUser", "setVisibilityUKCanUI", "tenentCode", "shareStockVerbiage", "showAcceptBuyNowOfferDailog", "showDeclineBuyNowOfferDailog", "showEmptyState", "isShowEmptyState", "showLoadingIndicator", "loading", "startDownloadService", "stockIsBuyNowSold", "stockIsPreBid", "stockIsTimedAuction", "subscribeToViewModel", "uiNeedToUpdateAsUserLoggedIn", "updateActionBarForBidAndBuyNow", "bundle", "updateBidLiveSection", "bidLiveData", "Lcom/iaai/android/bdt/utils/Constants_MVVM$BidAction;", "updateBiddingInfo", "biddingInformation", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/BiddingInformation;", "seriesName", "updateBiddingNotes", "notesText", "Landroid/text/Spanned;", "updateBiddingWarnings", "warningsTextModel", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/WarningTextModel;", "updateCarouselViewHeightOnLandscape", "updateCostCalculatorActionArea", "updateNonUSVehicleDetails", "response", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailResponse;", "updateNonUSVehicleImage", "imageUrl", "updateNonUsConditionalDetails", "vehicledetailsNonUS", "Lcom/iaai/android/bdt/model/productDetail/VehicledetailsNonUS;", "updateNonUsSellingInformation", "updateNonUsVehicleTitle", "updatePartsButtonUI", "isClickable", "updatePartsErrorSection", "message", "updatePreBidActionArea", "updateSaleInfo", "updateStatusWarnings", "warnings", "updateStockAndVinNumber", "updateVINInfo", "vinDetails", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VinDetails;", "updateVehicleImageCarousel", "updateWatchUI", "watchStatus", "vehicleImageUrl", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
public final class ProductDetailFragment extends BaseFragment implements DynamicLinkCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SAMPLE = "sample";
    private boolean IsUpstreamBranchStock;
    private final String TAG = ProductDetailFragment.class.getSimpleName();
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String action = "";
    private String auctionDate = "";
    private String auctionId = "";
    private String awardMessage = "";
    /* access modifiers changed from: private */
    public BaseActivity baseActivity;
    /* access modifiers changed from: private */
    public BaseFragment baseFragment;
    @NotNull
    public BidManager bidManager;
    /* access modifiers changed from: private */
    public String bidStatusIcon = "O";
    /* access modifiers changed from: private */
    public String branchCode = "";
    private String branchName = "";
    /* access modifiers changed from: private */
    public int buyNowOfferAmount;
    private String buyNowPrice = "";
    /* access modifiers changed from: private */
    public boolean chromeIndicator;
    /* access modifiers changed from: private */
    public ConditionInfoAdapter conditionInfoAdapter;
    /* access modifiers changed from: private */
    public String conditionReport = "";
    /* access modifiers changed from: private */
    public float currentBid;
    private boolean displaySaleTaxWarning;
    private String displaySaleTextMessage = "";
    private final BroadcastReceiver downloadCompleteReceiver = new ProductDetailFragment$downloadCompleteReceiver$1(this);
    /* access modifiers changed from: private */
    public String engineURL = "";
    private int engineVideoIndex;
    private String estimatedBid = "";
    private String estimatedFinalCost = "";
    /* access modifiers changed from: private */
    public String formattedMyMax = "";
    private String ibfAwardMessage = "";
    private String ibfPaymentDueDate = "";
    private String ibfPickUpDate = "";
    /* access modifiers changed from: private */
    public String image360URL = "";
    private ImageListener imageListener = new ProductDetailFragment$imageListener$1(this);
    private boolean isAuctionComplete;
    /* access modifiers changed from: private */
    public boolean isBidLive;
    /* access modifiers changed from: private */
    public boolean isBuyNowButtonClick;
    /* access modifiers changed from: private */
    public boolean isEngineVideoPresent;
    /* access modifiers changed from: private */
    public boolean isKeyImagePresent;
    /* access modifiers changed from: private */
    public boolean isLoggedIn;
    /* access modifiers changed from: private */
    public boolean isPartsIndicator;
    /* access modifiers changed from: private */
    public boolean isPreBidButtonClick;
    private boolean isPublic;
    /* access modifiers changed from: private */
    public boolean isTimedAuction;
    /* access modifiers changed from: private */
    public boolean isTransportationQuotesAvailable;
    /* access modifiers changed from: private */
    public boolean isViewAvalibale;
    private boolean isViewMore;
    /* access modifiers changed from: private */
    public boolean isWatchingButtonClick;
    /* access modifiers changed from: private */
    public String itemId = "";
    /* access modifiers changed from: private */
    public int keyIndex;
    private String liveDate = "";
    /* access modifiers changed from: private */
    public String liveDateString = "";
    /* access modifiers changed from: private */
    public String make = "";
    /* access modifiers changed from: private */
    public String model = "";
    private String myMax = "";
    /* access modifiers changed from: private */
    public PartsInfoAdapter partsInfoAdapter;
    /* access modifiers changed from: private */
    public List<PartsSectionResponse> partsList;
    private String paymentDueDate = "";
    /* access modifiers changed from: private */
    public PermissionHelper permissionHelper;
    private String pickUpDate = "";
    /* access modifiers changed from: private */
    public String preBidCurrentBid = "";
    /* access modifiers changed from: private */
    public String preBidErrorMsg;
    private String preBidIncrement = "";
    private String preBidTimeRemaining = "";
    /* access modifiers changed from: private */
    public SaleInformation saleInformation;
    /* access modifiers changed from: private */
    public String salesForceVehicleConditionGradeURL;
    /* access modifiers changed from: private */
    public Integer salvageId;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private boolean shouldFetchPartsInfo;
    /* access modifiers changed from: private */
    public Integer startingBid = 0;
    /* access modifiers changed from: private */
    public String stockNumber = "";
    /* access modifiers changed from: private */
    public boolean tboInd;
    /* access modifiers changed from: private */
    public String tenantCode = "";
    @NotNull
    public TermsOfUseBlendedSaleManager termsOfUseManager;
    private String timeLeftToBuy = "";
    /* access modifiers changed from: private */
    public int tireIndex;
    /* access modifiers changed from: private */
    public int totalCount;
    private String userId = "";
    /* access modifiers changed from: private */
    public String userTimezoneAbb = "";
    /* access modifiers changed from: private */
    public List<Image> vehicleImages = CollectionsKt.emptyList();
    private String vehicleLoc = "";
    /* access modifiers changed from: private */
    public String vehicleStatus = "";
    private ProductDetailViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    /* access modifiers changed from: private */
    public String vin = "";
    /* access modifiers changed from: private */
    public VinInfoAdapter vininfoAdapter;
    /* access modifiers changed from: private */
    public String year = "";
    private String yearModel = "";
    /* access modifiers changed from: private */
    public String zip = "";

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Constants_MVVM.BidAction.values().length];

        static {
            $EnumSwitchMapping$0[Constants_MVVM.BidAction.BID_LIVE.ordinal()] = 1;
            $EnumSwitchMapping$0[Constants_MVVM.BidAction.JOIN.ordinal()] = 2;
            $EnumSwitchMapping$0[Constants_MVVM.BidAction.DEFAULT.ordinal()] = 3;
        }
    }

    @JvmStatic
    @NotNull
    public static final ProductDetailFragment newInstance(@NotNull String str) {
        return Companion.newInstance(str);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ ConditionInfoAdapter access$getConditionInfoAdapter$p(ProductDetailFragment productDetailFragment) {
        ConditionInfoAdapter conditionInfoAdapter2 = productDetailFragment.conditionInfoAdapter;
        if (conditionInfoAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conditionInfoAdapter");
        }
        return conditionInfoAdapter2;
    }

    public static final /* synthetic */ PartsInfoAdapter access$getPartsInfoAdapter$p(ProductDetailFragment productDetailFragment) {
        PartsInfoAdapter partsInfoAdapter2 = productDetailFragment.partsInfoAdapter;
        if (partsInfoAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partsInfoAdapter");
        }
        return partsInfoAdapter2;
    }

    public static final /* synthetic */ List access$getPartsList$p(ProductDetailFragment productDetailFragment) {
        List<PartsSectionResponse> list = productDetailFragment.partsList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partsList");
        }
        return list;
    }

    public static final /* synthetic */ PermissionHelper access$getPermissionHelper$p(ProductDetailFragment productDetailFragment) {
        PermissionHelper permissionHelper2 = productDetailFragment.permissionHelper;
        if (permissionHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        return permissionHelper2;
    }

    public static final /* synthetic */ VinInfoAdapter access$getVininfoAdapter$p(ProductDetailFragment productDetailFragment) {
        VinInfoAdapter vinInfoAdapter = productDetailFragment.vininfoAdapter;
        if (vinInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vininfoAdapter");
        }
        return vinInfoAdapter;
    }

    @NotNull
    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return factory;
    }

    public final void setViewModelFactory(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkParameterIsNotNull(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    @NotNull
    public final TermsOfUseBlendedSaleManager getTermsOfUseManager() {
        TermsOfUseBlendedSaleManager termsOfUseBlendedSaleManager = this.termsOfUseManager;
        if (termsOfUseBlendedSaleManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("termsOfUseManager");
        }
        return termsOfUseBlendedSaleManager;
    }

    public final void setTermsOfUseManager(@NotNull TermsOfUseBlendedSaleManager termsOfUseBlendedSaleManager) {
        Intrinsics.checkParameterIsNotNull(termsOfUseBlendedSaleManager, "<set-?>");
        this.termsOfUseManager = termsOfUseBlendedSaleManager;
    }

    @NotNull
    public final BidManager getBidManager() {
        BidManager bidManager2 = this.bidManager;
        if (bidManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bidManager");
        }
        return bidManager2;
    }

    public final void setBidManager(@NotNull BidManager bidManager2) {
        Intrinsics.checkParameterIsNotNull(bidManager2, "<set-?>");
        this.bidManager = bidManager2;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        this.baseFragment = this;
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.baseActivity = (BaseActivity) activity;
            if (context instanceof BaseActivity) {
                this.baseActivity = (BaseActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.base.BaseActivity");
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/ProductDetailFragment$Companion;", "", "()V", "KEY_SAMPLE", "", "newInstance", "Lcom/iaai/android/bdt/feature/productDetail/ProductDetailFragment;", "url", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ProductDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ProductDetailFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            ProductDetailFragment productDetailFragment = new ProductDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ProductDetailFragment.KEY_SAMPLE, str);
            productDetailFragment.setArguments(bundle);
            return productDetailFragment;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragment = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m16of(fragment, factory).get(ProductDetailViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ailViewModel::class.java)");
        this.viewModel = (ProductDetailViewModel) viewModel2;
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application != null) {
            Injector injector = ((IaaiApplication) application).getInjector();
            Object instance = injector.getInstance(TermsOfUseBlendedSaleManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance, "injector.getInstance(Ter…dSaleManager::class.java)");
            this.termsOfUseManager = (TermsOfUseBlendedSaleManager) instance;
            Object instance2 = injector.getInstance(BidManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance2, "injector.getInstance(BidManager::class.java)");
            this.bidManager = (BidManager) instance2;
            this.permissionHelper = new PermissionHelper(fragment, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 100);
            BaseActivity baseActivity2 = this.baseActivity;
            if (baseActivity2 == null) {
                Intrinsics.throwNpe();
            }
            baseActivity2.registerReceiver(this.downloadCompleteReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            BaseActivity baseActivity3 = this.baseActivity;
            if (baseActivity3 instanceof ManageOfferListActivity) {
                if (baseActivity3 != null) {
                    ImageView imageView = (ImageView) ((ManageOfferListActivity) baseActivity3)._$_findCachedViewById(C2723R.C2726id.ivToolTip);
                    Intrinsics.checkExpressionValueIsNotNull(imageView, "manageOfferListActivity.ivToolTip");
                    imageView.setVisibility(8);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity");
                }
            }
            clearCostCalculatorSharedPreference();
            BaseActivity baseActivity4 = this.baseActivity;
            if (baseActivity4 == null) {
                Intrinsics.throwNpe();
            }
            Application application2 = baseActivity4.getApplication();
            Intrinsics.checkExpressionValueIsNotNull(application2, "baseActivity!!.application");
            Context applicationContext = application2.getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "baseActivity!!.application.applicationContext");
            this.conditionInfoAdapter = new ConditionInfoAdapter(applicationContext, new ProductDetailFragment$onCreate$1(this));
            BaseActivity baseActivity5 = this.baseActivity;
            if (baseActivity5 == null) {
                Intrinsics.throwNpe();
            }
            Application application3 = baseActivity5.getApplication();
            Intrinsics.checkExpressionValueIsNotNull(application3, "baseActivity!!.application");
            Context applicationContext2 = application3.getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext2, "baseActivity!!.application.applicationContext");
            this.vininfoAdapter = new VinInfoAdapter(applicationContext2, new ProductDetailFragment$onCreate$2(this));
            BaseActivity baseActivity6 = this.baseActivity;
            if (baseActivity6 == null) {
                Intrinsics.throwNpe();
            }
            Application application4 = baseActivity6.getApplication();
            Intrinsics.checkExpressionValueIsNotNull(application4, "baseActivity!!.application");
            Context applicationContext3 = application4.getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext3, "baseActivity!!.application.applicationContext");
            this.partsInfoAdapter = new PartsInfoAdapter(applicationContext3);
            subscribeToViewModel();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.IaaiApplication");
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        this.isViewAvalibale = true;
        ((CarouselView) _$_findCachedViewById(C2723R.C2726id.cvVehicleImages)).addOnPageChangeListener(new ProductDetailFragment$onViewCreated$1(this));
    }

    public final void setTubeSpeedOmeter(@Nullable Float f) {
        ((TubeSpeedometer) _$_findCachedViewById(C2723R.C2726id.tubeSpeedometer)).setMinMaxSpeed(1.0f, 5.0f);
        ArrayList<Section> sections = ((TubeSpeedometer) _$_findCachedViewById(C2723R.C2726id.tubeSpeedometer)).getSections();
        Section section = sections.get(0);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        section.setColor(ContextCompat.getColor(activity.getApplicationContext(), C2723R.C2724color.bdt_red));
        Section section2 = sections.get(1);
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity2, "activity!!");
        section2.setColor(ContextCompat.getColor(activity2.getApplicationContext(), C2723R.C2724color.bdt_red));
        Section section3 = sections.get(2);
        FragmentActivity activity3 = getActivity();
        if (activity3 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity3, "activity!!");
        section3.setColor(ContextCompat.getColor(activity3.getApplicationContext(), C2723R.C2724color.bdt_red));
        ((TubeSpeedometer) _$_findCachedViewById(C2723R.C2726id.tubeSpeedometer)).setSpeedAt(f != null ? f.floatValue() : 0.0f);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.isViewAvalibale = false;
        _$_clearFindViewByIdCache();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentProductDetailBinding fragmentProductDetailBinding = (FragmentProductDetailBinding) DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_product_detail, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(fragmentProductDetailBinding, "mBinding");
        return fragmentProductDetailBinding.getRoot();
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        this.itemId = arguments.getString(Constants.EXTRA_ITEM_ID).toString();
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            Intrinsics.throwNpe();
        }
        this.totalCount = arguments2.getInt(Constants_MVVM.EXTRA_TOTAL_COUNT);
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            Intrinsics.throwNpe();
        }
        if (arguments3.getString("countryCode") != null) {
            Bundle arguments4 = getArguments();
            if (arguments4 == null) {
                Intrinsics.throwNpe();
            }
            this.tenantCode = arguments4.getString("countryCode").toString();
        }
        setVisibilityUKCanUI(this.tenantCode);
        setInitialiseUIAsPerTenant();
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        Application application = baseActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…ation.applicationContext)");
        this.userId = userIdPreferencesMVVM;
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwNpe();
        }
        Application application2 = baseActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application2, "baseActivity!!.application");
        Boolean isLoggedInPreferencesMVVM = IAASharedPreference.getIsLoggedInPreferencesMVVM(application2.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(isLoggedInPreferencesMVVM, "IAASharedPreference.getI…ation.applicationContext)");
        this.isLoggedIn = isLoggedInPreferencesMVVM.booleanValue();
        checkNetworkConnection();
    }

    private final void setInitialiseUIAsPerTenant() {
        if (Intrinsics.areEqual((Object) this.tenantCode, (Object) "UK") || Intrinsics.areEqual((Object) this.tenantCode, (Object) "CA")) {
            initializeNonUsUI();
        } else {
            initializeUI();
        }
    }

    private final void initializeNonUsUI() {
        setNonUsLabelText();
        setOnClickListeners();
    }

    private final void setNonUsLabelText() {
        if (Intrinsics.areEqual((Object) this.tenantCode, (Object) "CA")) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_bid_information);
            Intrinsics.checkExpressionValueIsNotNull(textView, "txt_bid_information");
            String string = getString(C2723R.string.lbl_bid_information_ca);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.lbl_bid_information_ca)");
            textView.setText(Activity_ExtensionKt.setTextHTML(string));
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_visit_impact_link);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "txt_visit_impact_link");
            String string2 = getString(C2723R.string.lbl_visit_impact_ca);
            Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.lbl_visit_impact_ca)");
            textView2.setText(Activity_ExtensionKt.setTextHTML(string2));
        } else {
            TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_bid_information);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "txt_bid_information");
            String string3 = getString(C2723R.string.lbl_bid_information_uk);
            Intrinsics.checkExpressionValueIsNotNull(string3, "getString(R.string.lbl_bid_information_uk)");
            textView3.setText(Activity_ExtensionKt.setTextHTML(string3));
            TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_visit_impact_link);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "txt_visit_impact_link");
            String string4 = getString(C2723R.string.lbl_visit_impact_uk);
            Intrinsics.checkExpressionValueIsNotNull(string4, "getString(R.string.lbl_visit_impact_uk)");
            textView4.setText(Activity_ExtensionKt.setTextHTML(string4));
        }
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvLoss);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "nonUs_tvLoss");
        textView5.setText(getString(C2723R.string.lbl_loss) + ':');
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvPrimaryDamage);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "nonUs_tvPrimaryDamage");
        textView6.setText(getString(C2723R.string.primary_damage) + ':');
        TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvSecondaryDamage);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "nonUs_tvSecondaryDamage");
        textView7.setText(getString(C2723R.string.secondary_damage) + ':');
        TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvOdometer);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "nonUs_tvOdometer");
        textView8.setText(getString(C2723R.string.odo_meter) + ':');
        TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvStartCode);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "nonUs_tvStartCode");
        textView9.setText(getString(C2723R.string.start_code) + ':');
        TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvKey);
        Intrinsics.checkExpressionValueIsNotNull(textView10, "nonUs_tvKey");
        textView10.setText(getString(C2723R.string.lbl_key_fob) + ':');
        TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvAirBagDeployment);
        Intrinsics.checkExpressionValueIsNotNull(textView11, "nonUs_tvAirBagDeployment");
        textView11.setText(getString(C2723R.string.lbl_air_bag_deployment) + ':');
        TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvAirBag);
        Intrinsics.checkExpressionValueIsNotNull(textView12, "nonUs_tvAirBag");
        textView12.setText(getString(C2723R.string.lbl_air_bags) + ':');
    }

    private final void setVisibilityUKCanUI(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "CA") || Intrinsics.areEqual((Object) str, (Object) "UK")) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.layout_US_product_detail_container);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "layout_US_product_detail_container");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.layout_nonUS_product_detail_container);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "layout_nonUS_product_detail_container");
            linearLayout2.setVisibility(0);
            return;
        }
        LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.layout_US_product_detail_container);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "layout_US_product_detail_container");
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.layout_nonUS_product_detail_container);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "layout_nonUS_product_detail_container");
        linearLayout4.setVisibility(8);
    }

    private final void setOnClickListeners() {
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.img_close)).setOnClickListener(new ProductDetailFragment$setOnClickListeners$1(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.layout_visit_impact)).setOnClickListener(new ProductDetailFragment$setOnClickListeners$2(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ukcan_ivConditionToolTip1)).setOnClickListener(new ProductDetailFragment$setOnClickListeners$3(this));
    }

    public void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkParameterIsNotNull(configuration, "newConfig");
        if (configuration.orientation == 2) {
            updateCarouselViewHeightOnLandscape();
        } else {
            CarouselView carouselView = (CarouselView) _$_findCachedViewById(C2723R.C2726id.cvVehicleImages);
            Intrinsics.checkExpressionValueIsNotNull(carouselView, "cvVehicleImages");
            ViewGroup.LayoutParams layoutParams = carouselView.getLayoutParams();
            layoutParams.height = getResources().getDimensionPixelSize(C2723R.dimen.vehicle_images_height_carousel);
            CarouselView carouselView2 = (CarouselView) _$_findCachedViewById(C2723R.C2726id.cvVehicleImages);
            Intrinsics.checkExpressionValueIsNotNull(carouselView2, "cvVehicleImages");
            carouselView2.setLayoutParams(layoutParams);
        }
        super.onConfigurationChanged(configuration);
    }

    private final void updateCarouselViewHeightOnLandscape() {
        CarouselView carouselView = (CarouselView) _$_findCachedViewById(C2723R.C2726id.cvVehicleImages);
        Intrinsics.checkExpressionValueIsNotNull(carouselView, "cvVehicleImages");
        ViewGroup.LayoutParams layoutParams = carouselView.getLayoutParams();
        layoutParams.height = getResources().getDimensionPixelSize(C2723R.dimen.carousel_view_height_in_landscape);
        CarouselView carouselView2 = (CarouselView) _$_findCachedViewById(C2723R.C2726id.cvVehicleImages);
        Intrinsics.checkExpressionValueIsNotNull(carouselView2, "cvVehicleImages");
        carouselView2.setLayoutParams(layoutParams);
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        PermissionHelper permissionHelper2 = this.permissionHelper;
        if (permissionHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        permissionHelper2.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: private */
    public final void handlePermissionCallbacksForWriteStorage() {
        PermissionHelper permissionHelper2 = this.permissionHelper;
        if (permissionHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        permissionHelper2.denied(new ProductDetailFragment$handlePermissionCallbacksForWriteStorage$1(this));
        PermissionHelper permissionHelper3 = this.permissionHelper;
        if (permissionHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        permissionHelper3.requestIndividual(ProductDetailFragment$handlePermissionCallbacksForWriteStorage$2.INSTANCE);
        PermissionHelper permissionHelper4 = this.permissionHelper;
        if (permissionHelper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        permissionHelper4.requestAll(new ProductDetailFragment$handlePermissionCallbacksForWriteStorage$3(this));
    }

    /* access modifiers changed from: private */
    public final void startDownloadService() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str = this.make + "_" + this.stockNumber;
        StringBuilder sb = new StringBuilder();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        Intrinsics.checkExpressionValueIsNotNull(externalStorageDirectory, "Environment.getExternalStorageDirectory()");
        sb.append(externalStorageDirectory.getAbsolutePath());
        sb.append("/IaaBuyer/");
        sb.append(str);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdir();
        }
        for (Image url : this.vehicleImages) {
            Uri fromFile = Uri.fromFile(file);
            Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(dir)");
            String path = fromFile.getPath();
            arrayList.add(url.getUrl());
            arrayList2.add(path);
        }
        Intent putExtra = new Intent(this.baseActivity, DownloadVehicleImageService.class).putExtra(Constants_MVVM.EXTRA_DOWNLOAD_PATH, arrayList).putExtra(Constants_MVVM.EXTRA_DESTINATION_PATH, arrayList2).putExtra(Constants_MVVM.EXTRA_DOWNLOAD_IMAGE_NAME, str);
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        baseActivity2.startService(putExtra);
        ImageView imageView = (ImageView) _$_findCachedViewById(C2723R.C2726id.vehicleImageDownload);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "vehicleImageDownload");
        imageView.setClickable(false);
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.vehicleImageDownload)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_vehicle_downloading, (Resources.Theme) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0080, code lost:
        r0 = (r0 = r0.getResources()).getConfiguration();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initializeUI() {
        /*
            r5 = this;
            android.content.res.Resources r0 = r5.getResources()
            r1 = 2131034121(0x7f050009, float:1.767875E38)
            boolean r0 = r0.getBoolean(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0021
            java.lang.String r2 = r5.itemId
            java.lang.String r3 = ""
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            r2 = r2 ^ r1
            if (r2 == 0) goto L_0x001d
            r5.initializeShareForTablet(r1)
            goto L_0x0021
        L_0x001d:
            r2 = 0
            r5.initializeShareForTablet(r2)
        L_0x0021:
            if (r0 == 0) goto L_0x0076
            com.iaai.android.bdt.base.BaseActivity r0 = r5.baseActivity
            boolean r2 = r0 instanceof com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity
            if (r2 != 0) goto L_0x0049
            boolean r2 = r0 instanceof com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity
            if (r2 != 0) goto L_0x0049
            boolean r2 = r0 instanceof com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity
            if (r2 != 0) goto L_0x0049
            boolean r2 = r0 instanceof com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity
            if (r2 != 0) goto L_0x0049
            boolean r2 = r0 instanceof com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity
            if (r2 != 0) goto L_0x0049
            boolean r2 = r0 instanceof com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity
            if (r2 != 0) goto L_0x0049
            boolean r2 = r0 instanceof com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity
            if (r2 != 0) goto L_0x0049
            boolean r2 = r0 instanceof com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity
            if (r2 != 0) goto L_0x0049
            boolean r0 = r0 instanceof com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity
            if (r0 == 0) goto L_0x0076
        L_0x0049:
            int r0 = com.iaai.android.C2723R.C2726id.cvVehicleImages
            android.view.View r0 = r5._$_findCachedViewById(r0)
            com.synnapps.carouselview.CarouselView r0 = (com.synnapps.carouselview.CarouselView) r0
            java.lang.String r2 = "cvVehicleImages"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.content.res.Resources r3 = r5.getResources()
            r4 = 2131165327(0x7f07008f, float:1.7944868E38)
            int r3 = r3.getDimensionPixelSize(r4)
            r0.height = r3
            int r3 = com.iaai.android.C2723R.C2726id.cvVehicleImages
            android.view.View r3 = r5._$_findCachedViewById(r3)
            com.synnapps.carouselview.CarouselView r3 = (com.synnapps.carouselview.CarouselView) r3
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r2)
            r3.setLayoutParams(r0)
            goto L_0x009b
        L_0x0076:
            com.iaai.android.bdt.base.BaseActivity r0 = r5.baseActivity
            if (r0 == 0) goto L_0x008d
            android.content.res.Resources r0 = r0.getResources()
            if (r0 == 0) goto L_0x008d
            android.content.res.Configuration r0 = r0.getConfiguration()
            if (r0 == 0) goto L_0x008d
            int r0 = r0.orientation
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x008e
        L_0x008d:
            r0 = 0
        L_0x008e:
            r2 = 2
            if (r0 != 0) goto L_0x0092
            goto L_0x009b
        L_0x0092:
            int r0 = r0.intValue()
            if (r0 != r2) goto L_0x009b
            r5.updateCarouselViewHeightOnLandscape()
        L_0x009b:
            int r0 = com.iaai.android.C2723R.C2726id.vehicleImageListView
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$1 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$1
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.vehicleImageDownload
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$2 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$2
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.btnPreBid
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$3 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$3
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.llWatchLayout
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$4 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$4
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.llCostCalculator
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$5 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$5
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.btnEdit
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$6 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$6
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.llUnWatchLayout
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$7 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$7
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.cvVehicleImages
            android.view.View r0 = r5._$_findCachedViewById(r0)
            com.synnapps.carouselview.CarouselView r0 = (com.synnapps.carouselview.CarouselView) r0
            com.synnapps.carouselview.ImageListener r2 = r5.imageListener
            r0.setImageListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.cvVehicleImages
            android.view.View r0 = r5._$_findCachedViewById(r0)
            com.synnapps.carouselview.CarouselView r0 = (com.synnapps.carouselview.CarouselView) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$8 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$8
            r2.<init>(r5)
            com.synnapps.carouselview.ImageClickListener r2 = (com.synnapps.carouselview.ImageClickListener) r2
            r0.setImageClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.iv360Image
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$9 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$9
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.ivHdImage
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$10 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$10
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.ivKey
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$11 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$11
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.ivTireTread
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$12 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$12
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.ivEngineVideo
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$13 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$13
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.salesInfoViewMore
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$14 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$14
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.condition_viewMore
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$15 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$15
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.VinViewMore
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$16 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$16
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.bidding_ViewMore
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$17 r2 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$17
            r2.<init>(r5)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            int r0 = com.iaai.android.C2723R.C2726id.btn_Vehicle
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "btn_Vehicle"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r0.setSelected(r1)
            int r0 = com.iaai.android.C2723R.C2726id.btn_Vehicle
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$18 r1 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$18
            r1.<init>(r5)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = com.iaai.android.C2723R.C2726id.tv_parts
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$19 r1 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$19
            r1.<init>(r5)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = com.iaai.android.C2723R.C2726id.tv_parts_login
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_parts_login"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r1 = 8
            r0.setPaintFlags(r1)
            int r0 = com.iaai.android.C2723R.C2726id.tv_parts_login
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$20 r1 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$20
            r1.<init>(r5)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = com.iaai.android.C2723R.C2726id.btnBidLive
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$21 r1 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$21
            r1.<init>(r5)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = com.iaai.android.C2723R.C2726id.btnChromeData
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$22 r1 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$22
            r1.<init>(r5)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            int r0 = com.iaai.android.C2723R.C2726id.iaa_interact_learn_more
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$23 r1 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$initializeUI$23
            r1.<init>(r5)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.productDetail.ProductDetailFragment.initializeUI():void");
    }

    /* access modifiers changed from: private */
    public final void navigateToCostCalculator() {
        updateActionBarForBidAndBuyNow(false, false, getBundleForActionArea(false, false));
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            BaseActivity baseActivity2 = this.baseActivity;
            if (baseActivity2 != null) {
                if (baseActivity2 == null) {
                    Intrinsics.throwNpe();
                }
                Application application = baseActivity2.getApplication();
                Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
                Boolean salesInfoViewLessPreferencesMVVM = IAASharedPreference.getSalesInfoViewLessPreferencesMVVM(application.getApplicationContext());
                Intrinsics.checkExpressionValueIsNotNull(salesInfoViewLessPreferencesMVVM, "IAASharedPreference.getS…ation.applicationContext)");
                if (salesInfoViewLessPreferencesMVVM.booleanValue()) {
                    TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.txtSalesInfoViewMore);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "txtSalesInfoViewMore");
                    textView.setText(getString(C2723R.string.lbl_view_less));
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_sales_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_up));
                    updateSaleInfo(0);
                } else {
                    TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.txtSalesInfoViewMore);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "txtSalesInfoViewMore");
                    textView2.setText(getString(C2723R.string.lbl_view_more));
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_sales_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_down));
                    updateSaleInfo(8);
                }
                BaseActivity baseActivity3 = this.baseActivity;
                if (baseActivity3 == null) {
                    Intrinsics.throwNpe();
                }
                Application application2 = baseActivity3.getApplication();
                Intrinsics.checkExpressionValueIsNotNull(application2, "baseActivity!!.application");
                Boolean vCConditionViewLessPreferencesMVVM = IAASharedPreference.getVCConditionViewLessPreferencesMVVM(application2.getApplicationContext());
                Intrinsics.checkExpressionValueIsNotNull(vCConditionViewLessPreferencesMVVM, "IAASharedPreference.getV…ation.applicationContext)");
                if (vCConditionViewLessPreferencesMVVM.booleanValue()) {
                    TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.txtVCCondiViewMore);
                    Intrinsics.checkExpressionValueIsNotNull(textView3, "txtVCCondiViewMore");
                    textView3.setText(getString(C2723R.string.lbl_view_less));
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_VCcondition_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_up));
                    ConditionInfoAdapter conditionInfoAdapter2 = this.conditionInfoAdapter;
                    if (conditionInfoAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("conditionInfoAdapter");
                    }
                    if (conditionInfoAdapter2.getItemCount() > 0) {
                        ConditionInfoAdapter conditionInfoAdapter3 = this.conditionInfoAdapter;
                        if (conditionInfoAdapter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("conditionInfoAdapter");
                        }
                        conditionInfoAdapter3.notifyDataSetChanged();
                    }
                } else {
                    TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.txtVCCondiViewMore);
                    Intrinsics.checkExpressionValueIsNotNull(textView4, "txtVCCondiViewMore");
                    textView4.setText(getString(C2723R.string.lbl_view_more));
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_VCcondition_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_down));
                    ConditionInfoAdapter conditionInfoAdapter4 = this.conditionInfoAdapter;
                    if (conditionInfoAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("conditionInfoAdapter");
                    }
                    if (conditionInfoAdapter4.getItemCount() > 0) {
                        ConditionInfoAdapter conditionInfoAdapter5 = this.conditionInfoAdapter;
                        if (conditionInfoAdapter5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("conditionInfoAdapter");
                        }
                        conditionInfoAdapter5.notifyDataSetChanged();
                    }
                }
                BaseActivity baseActivity4 = this.baseActivity;
                if (baseActivity4 == null) {
                    Intrinsics.throwNpe();
                }
                Application application3 = baseActivity4.getApplication();
                Intrinsics.checkExpressionValueIsNotNull(application3, "baseActivity!!.application");
                Boolean vinDetailsViewLessPreferencesMVVM = IAASharedPreference.getVinDetailsViewLessPreferencesMVVM(application3.getApplicationContext());
                Intrinsics.checkExpressionValueIsNotNull(vinDetailsViewLessPreferencesMVVM, "IAASharedPreference.getV…ation.applicationContext)");
                if (vinDetailsViewLessPreferencesMVVM.booleanValue()) {
                    TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.txtVinViewMore);
                    Intrinsics.checkExpressionValueIsNotNull(textView5, "txtVinViewMore");
                    textView5.setText(getString(C2723R.string.lbl_view_less));
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_vin_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_up));
                    VinInfoAdapter vinInfoAdapter = this.vininfoAdapter;
                    if (vinInfoAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vininfoAdapter");
                    }
                    if (vinInfoAdapter.getItemCount() > 0) {
                        VinInfoAdapter vinInfoAdapter2 = this.vininfoAdapter;
                        if (vinInfoAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("vininfoAdapter");
                        }
                        vinInfoAdapter2.notifyDataSetChanged();
                    }
                    PartsInfoAdapter partsInfoAdapter2 = this.partsInfoAdapter;
                    if (partsInfoAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("partsInfoAdapter");
                    }
                    if (partsInfoAdapter2.getItemCount() > 0) {
                        PartsInfoAdapter partsInfoAdapter3 = this.partsInfoAdapter;
                        if (partsInfoAdapter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("partsInfoAdapter");
                        }
                        partsInfoAdapter3.notifyDataSetChanged();
                    }
                } else {
                    TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.txtVinViewMore);
                    Intrinsics.checkExpressionValueIsNotNull(textView6, "txtVinViewMore");
                    textView6.setText(getString(C2723R.string.lbl_view_more));
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_vin_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_down));
                    VinInfoAdapter vinInfoAdapter3 = this.vininfoAdapter;
                    if (vinInfoAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vininfoAdapter");
                    }
                    if (vinInfoAdapter3.getItemCount() > 0) {
                        VinInfoAdapter vinInfoAdapter4 = this.vininfoAdapter;
                        if (vinInfoAdapter4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("vininfoAdapter");
                        }
                        vinInfoAdapter4.notifyDataSetChanged();
                    }
                    PartsInfoAdapter partsInfoAdapter4 = this.partsInfoAdapter;
                    if (partsInfoAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("partsInfoAdapter");
                    }
                    if (partsInfoAdapter4.getItemCount() > 0) {
                        PartsInfoAdapter partsInfoAdapter5 = this.partsInfoAdapter;
                        if (partsInfoAdapter5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("partsInfoAdapter");
                        }
                        partsInfoAdapter5.notifyDataSetChanged();
                    }
                }
                BaseActivity baseActivity5 = this.baseActivity;
                if (baseActivity5 == null) {
                    Intrinsics.throwNpe();
                }
                Application application4 = baseActivity5.getApplication();
                Intrinsics.checkExpressionValueIsNotNull(application4, "baseActivity!!.application");
                Boolean biddingInfoViewLessPreferencesMVVM = IAASharedPreference.getBiddingInfoViewLessPreferencesMVVM(application4.getApplicationContext());
                Intrinsics.checkExpressionValueIsNotNull(biddingInfoViewLessPreferencesMVVM, "IAASharedPreference.getB…ation.applicationContext)");
                if (biddingInfoViewLessPreferencesMVVM.booleanValue()) {
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_bidding_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_up));
                    LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.whocanbid);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout, "whocanbid");
                    linearLayout.setVisibility(0);
                    ((TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle)).setSingleLine(false);
                    TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
                    Intrinsics.checkExpressionValueIsNotNull(textView7, "tvBidStatusSubTitle");
                    textView7.setEllipsize((TextUtils.TruncateAt) null);
                } else {
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_bidding_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_down));
                    LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.whocanbid);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "whocanbid");
                    linearLayout2.setVisibility(8);
                    if (Intrinsics.areEqual((Object) this.bidStatusIcon, (Object) ExifInterface.LONGITUDE_WEST)) {
                        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle)).setSingleLine(false);
                        TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
                        Intrinsics.checkExpressionValueIsNotNull(textView8, "tvBidStatusSubTitle");
                        textView8.setEllipsize((TextUtils.TruncateAt) null);
                    } else {
                        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle)).setSingleLine(true);
                        TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
                        Intrinsics.checkExpressionValueIsNotNull(textView9, "tvBidStatusSubTitle");
                        textView9.setEllipsize(TextUtils.TruncateAt.END);
                    }
                }
                BaseActivity baseActivity6 = this.baseActivity;
                if (baseActivity6 == null) {
                    Intrinsics.throwNpe();
                }
                Application application5 = baseActivity6.getApplication();
                Intrinsics.checkExpressionValueIsNotNull(application5, "baseActivity!!.application");
                uiNeedToUpdateAsUserLoggedIn(application5.getApplicationContext());
                if (!this.isAuctionComplete) {
                    BaseActivity baseActivity7 = this.baseActivity;
                    if (baseActivity7 == null) {
                        Intrinsics.throwNpe();
                    }
                    Application application6 = baseActivity7.getApplication();
                    Intrinsics.checkExpressionValueIsNotNull(application6, "baseActivity!!.application");
                    String estimateCostValue = IAASharedPreference.getEstimateCostValue(application6.getApplicationContext(), this.itemId);
                    Intrinsics.checkExpressionValueIsNotNull(estimateCostValue, "IAASharedPreference.getE…plicationContext, itemId)");
                    this.estimatedBid = estimateCostValue;
                    BaseActivity baseActivity8 = this.baseActivity;
                    if (baseActivity8 == null) {
                        Intrinsics.throwNpe();
                    }
                    Application application7 = baseActivity8.getApplication();
                    Intrinsics.checkExpressionValueIsNotNull(application7, "baseActivity!!.application");
                    String estimateFinalCostValue = IAASharedPreference.getEstimateFinalCostValue(application7.getApplicationContext(), this.itemId);
                    Intrinsics.checkExpressionValueIsNotNull(estimateFinalCostValue, "IAASharedPreference.getE…plicationContext, itemId)");
                    this.estimatedFinalCost = estimateFinalCostValue;
                    if (this.estimatedBid.length() > 0) {
                        if (this.estimatedFinalCost.length() > 0) {
                            LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llCostCalculator);
                            Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llCostCalculator");
                            linearLayout3.setVisibility(8);
                            LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llEstimatedCostValue);
                            Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llEstimatedCostValue");
                            linearLayout4.setVisibility(0);
                            TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.estimateFinalCost);
                            Intrinsics.checkExpressionValueIsNotNull(textView10, "estimateFinalCost");
                            textView10.setText("Estimated Final Cost: " + this.estimatedFinalCost);
                            TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.estimateBid);
                            Intrinsics.checkExpressionValueIsNotNull(textView11, "estimateBid");
                            textView11.setText("Based on an estimated bid of $" + this.estimatedBid);
                        }
                    }
                    if (this.isLoggedIn) {
                        SessionManager sessionManager2 = this.sessionManager;
                        if (sessionManager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
                        }
                        if (!Intrinsics.areEqual((Object) sessionManager2.getCurrentSessionBuyerId(), (Object) "0")) {
                            LinearLayout linearLayout5 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llCostCalculator);
                            Intrinsics.checkExpressionValueIsNotNull(linearLayout5, "llCostCalculator");
                            linearLayout5.setVisibility(0);
                            LinearLayout linearLayout6 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llEstimatedCostValue);
                            Intrinsics.checkExpressionValueIsNotNull(linearLayout6, "llEstimatedCostValue");
                            linearLayout6.setVisibility(8);
                        }
                    }
                }
            }
            setUpShareButtonClick();
        }
    }

    private final void uiNeedToUpdateAsUserLoggedIn(Context context) {
        Boolean isLoggedInPreferencesMVVM = IAASharedPreference.getIsLoggedInPreferencesMVVM(context);
        Intrinsics.checkExpressionValueIsNotNull(isLoggedInPreferencesMVVM, "IAASharedPreference.getI…nPreferencesMVVM(context)");
        this.isLoggedIn = isLoggedInPreferencesMVVM.booleanValue();
        if (Intrinsics.areEqual((Object) this.userId, (Object) "") && (!Intrinsics.areEqual((Object) IAASharedPreference.getUserIdPreferencesMVVM(context), (Object) ""))) {
            String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(context);
            Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…dPreferencesMVVM(context)");
            this.userId = userIdPreferencesMVVM;
            fetchProductDetail();
        }
    }

    private final void subscribeToViewModel() {
        ProductDetailViewModel productDetailViewModel = this.viewModel;
        if (productDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<ProductDetailResponse> nonUsProductDetailResponse = productDetailViewModel.getNonUsProductDetailResponse();
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        nonUsProductDetailResponse.observe(baseActivity2, new ProductDetailFragment$subscribeToViewModel$1(this));
        ProductDetailViewModel productDetailViewModel2 = this.viewModel;
        if (productDetailViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<ProductDetailErrorModel> nonUsProductDetailError = productDetailViewModel2.getNonUsProductDetailError();
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwNpe();
        }
        nonUsProductDetailError.observe(baseActivity3, new ProductDetailFragment$subscribeToViewModel$2(this));
        ProductDetailViewModel productDetailViewModel3 = this.viewModel;
        if (productDetailViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<ProductDetailResponse> productDetailResponse = productDetailViewModel3.getProductDetailResponse();
        BaseActivity baseActivity4 = this.baseActivity;
        if (baseActivity4 == null) {
            Intrinsics.throwNpe();
        }
        productDetailResponse.observe(baseActivity4, new ProductDetailFragment$subscribeToViewModel$3(this));
        ProductDetailViewModel productDetailViewModel4 = this.viewModel;
        if (productDetailViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<ProductDetailErrorModel> productDetailError = productDetailViewModel4.getProductDetailError();
        BaseActivity baseActivity5 = this.baseActivity;
        if (baseActivity5 == null) {
            Intrinsics.throwNpe();
        }
        productDetailError.observe(baseActivity5, new ProductDetailFragment$subscribeToViewModel$4(this));
        ProductDetailViewModel productDetailViewModel5 = this.viewModel;
        if (productDetailViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Boolean> showLoading = productDetailViewModel5.getShowLoading();
        BaseActivity baseActivity6 = this.baseActivity;
        if (baseActivity6 == null) {
            Intrinsics.throwNpe();
        }
        showLoading.observe(baseActivity6, new ProductDetailFragment$subscribeToViewModel$5(this));
        ProductDetailViewModel productDetailViewModel6 = this.viewModel;
        if (productDetailViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Boolean> showEmptyState = productDetailViewModel6.getShowEmptyState();
        BaseActivity baseActivity7 = this.baseActivity;
        if (baseActivity7 == null) {
            Intrinsics.throwNpe();
        }
        showEmptyState.observe(baseActivity7, new ProductDetailFragment$subscribeToViewModel$6(this));
        ProductDetailViewModel productDetailViewModel7 = this.viewModel;
        if (productDetailViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<WarningTextModel> biddingWarningText = productDetailViewModel7.getBiddingWarningText();
        BaseActivity baseActivity8 = this.baseActivity;
        if (baseActivity8 == null) {
            Intrinsics.throwNpe();
        }
        biddingWarningText.observe(baseActivity8, new ProductDetailFragment$subscribeToViewModel$7(this));
        ProductDetailViewModel productDetailViewModel8 = this.viewModel;
        if (productDetailViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Spanned> biddingNotesText = productDetailViewModel8.getBiddingNotesText();
        BaseActivity baseActivity9 = this.baseActivity;
        if (baseActivity9 == null) {
            Intrinsics.throwNpe();
        }
        biddingNotesText.observe(baseActivity9, new ProductDetailFragment$subscribeToViewModel$8(this));
        ProductDetailViewModel productDetailViewModel9 = this.viewModel;
        if (productDetailViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<List<PartsSectionResponse>> partsInfoResponse = productDetailViewModel9.getPartsInfoResponse();
        BaseActivity baseActivity10 = this.baseActivity;
        if (baseActivity10 == null) {
            Intrinsics.throwNpe();
        }
        partsInfoResponse.observe(baseActivity10, new ProductDetailFragment$subscribeToViewModel$9(this));
        ProductDetailViewModel productDetailViewModel10 = this.viewModel;
        if (productDetailViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> partsError = productDetailViewModel10.getPartsError();
        BaseActivity baseActivity11 = this.baseActivity;
        if (baseActivity11 == null) {
            Intrinsics.throwNpe();
        }
        partsError.observe(baseActivity11, new ProductDetailFragment$subscribeToViewModel$10(this));
        ProductDetailViewModel productDetailViewModel11 = this.viewModel;
        if (productDetailViewModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<ImageInformation> imagesResponse = productDetailViewModel11.getImagesResponse();
        BaseActivity baseActivity12 = this.baseActivity;
        if (baseActivity12 == null) {
            Intrinsics.throwNpe();
        }
        imagesResponse.observe(baseActivity12, new ProductDetailFragment$subscribeToViewModel$11(this));
        ProductDetailViewModel productDetailViewModel12 = this.viewModel;
        if (productDetailViewModel12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<UpdateWatchListResponse> watchStatusResponse = productDetailViewModel12.getWatchStatusResponse();
        BaseActivity baseActivity13 = this.baseActivity;
        if (baseActivity13 == null) {
            Intrinsics.throwNpe();
        }
        watchStatusResponse.observe(baseActivity13, new ProductDetailFragment$subscribeToViewModel$12(this));
        ProductDetailViewModel productDetailViewModel13 = this.viewModel;
        if (productDetailViewModel13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> watchStatusError = productDetailViewModel13.getWatchStatusError();
        BaseActivity baseActivity14 = this.baseActivity;
        if (baseActivity14 == null) {
            Intrinsics.throwNpe();
        }
        watchStatusError.observe(baseActivity14, new ProductDetailFragment$subscribeToViewModel$13(this));
        ProductDetailViewModel productDetailViewModel14 = this.viewModel;
        if (productDetailViewModel14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Constants_MVVM.BidAction> bidLiveData = productDetailViewModel14.getBidLiveData();
        BaseActivity baseActivity15 = this.baseActivity;
        if (baseActivity15 == null) {
            Intrinsics.throwNpe();
        }
        bidLiveData.observe(baseActivity15, new ProductDetailFragment$subscribeToViewModel$14(this));
        ProductDetailViewModel productDetailViewModel15 = this.viewModel;
        if (productDetailViewModel15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<BDTBuyNowOfferResult> acceptBuyNowOfferResponse = productDetailViewModel15.getAcceptBuyNowOfferResponse();
        BaseActivity baseActivity16 = this.baseActivity;
        if (baseActivity16 == null) {
            Intrinsics.throwNpe();
        }
        acceptBuyNowOfferResponse.observe(baseActivity16, new ProductDetailFragment$subscribeToViewModel$15(this));
        ProductDetailViewModel productDetailViewModel16 = this.viewModel;
        if (productDetailViewModel16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> acceptBuyNowOfferError = productDetailViewModel16.getAcceptBuyNowOfferError();
        BaseActivity baseActivity17 = this.baseActivity;
        if (baseActivity17 == null) {
            Intrinsics.throwNpe();
        }
        acceptBuyNowOfferError.observe(baseActivity17, new ProductDetailFragment$subscribeToViewModel$16(this));
        ProductDetailViewModel productDetailViewModel17 = this.viewModel;
        if (productDetailViewModel17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> declineBuyNowOfferResponse = productDetailViewModel17.getDeclineBuyNowOfferResponse();
        BaseActivity baseActivity18 = this.baseActivity;
        if (baseActivity18 == null) {
            Intrinsics.throwNpe();
        }
        declineBuyNowOfferResponse.observe(baseActivity18, new ProductDetailFragment$subscribeToViewModel$17(this));
        ProductDetailViewModel productDetailViewModel18 = this.viewModel;
        if (productDetailViewModel18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> declineBuyNowOfferError = productDetailViewModel18.getDeclineBuyNowOfferError();
        BaseActivity baseActivity19 = this.baseActivity;
        if (baseActivity19 == null) {
            Intrinsics.throwNpe();
        }
        declineBuyNowOfferError.observe(baseActivity19, new ProductDetailFragment$subscribeToViewModel$18(this));
    }

    /* access modifiers changed from: private */
    public final void updateNonUSVehicleDetails(ProductDetailResponse productDetailResponse) {
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2723R.C2726id.svDataContainer);
        Intrinsics.checkExpressionValueIsNotNull(scrollView, "svDataContainer");
        scrollView.setVisibility(0);
        String str = null;
        VehicledetailsNonUS vehicledetailsNonUS = productDetailResponse != null ? productDetailResponse.getVehicledetailsNonUS() : null;
        if (vehicledetailsNonUS != null) {
            str = vehicledetailsNonUS.getImageUrl();
        }
        updateNonUSVehicleImage(str);
        updateNonUsVehicleTitle(vehicledetailsNonUS);
        updateNonUsConditionalDetails(vehicledetailsNonUS);
        updateNonUsSellingInformation(vehicledetailsNonUS);
    }

    private final void updateNonUsSellingInformation(VehicledetailsNonUS vehicledetailsNonUS) {
        String str;
        if ((vehicledetailsNonUS != null ? vehicledetailsNonUS.getTenant() : null) != null) {
            ImageView imageView = (ImageView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvMarketValue_flag);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "nonUs_tvMarketValue_flag");
            imageView.setVisibility(0);
            if (StringsKt.equals$default(vehicledetailsNonUS != null ? vehicledetailsNonUS.getTenant() : null, "CA", false, 2, (Object) null)) {
                TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvMarketValue);
                Intrinsics.checkExpressionValueIsNotNull(textView, "nonUs_tvMarketValue");
                textView.setText(Constants.CANADA);
                ((ImageView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvMarketValue_flag)).setImageResource(C2723R.C2725drawable.flag_canada);
            } else {
                TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvMarketValue);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "nonUs_tvMarketValue");
                textView2.setText(Constants.UNITED_KINGDOM);
                ((ImageView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvMarketValue_flag)).setImageResource(C2723R.C2725drawable.ic_flag_results_uk);
            }
        } else {
            ImageView imageView2 = (ImageView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvMarketValue_flag);
            Intrinsics.checkExpressionValueIsNotNull(imageView2, "nonUs_tvMarketValue_flag");
            imageView2.setVisibility(8);
        }
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvSellingBranch_value);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "nonUs_tvSellingBranch_value");
        StringBuilder sb = new StringBuilder();
        sb.append("<u>");
        if (vehicledetailsNonUS == null || (str = vehicledetailsNonUS.getBranchName()) == null) {
            str = "";
        }
        sb.append(str);
        sb.append("</u>");
        textView3.setText(Activity_ExtensionKt.setTextHTML(sb.toString()));
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvVehicleLocation_value);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "nonUs_tvVehicleLocation_value");
        textView4.setText("");
    }

    private final void updateNonUsConditionalDetails(VehicledetailsNonUS vehicledetailsNonUS) {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvLoss_value);
        Intrinsics.checkExpressionValueIsNotNull(textView, "nonUs_tvLoss_value");
        String str = null;
        textView.setText(vehicledetailsNonUS != null ? vehicledetailsNonUS.getLossType() : null);
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvPrimaryDamage_value);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "nonUs_tvPrimaryDamage_value");
        textView2.setText(vehicledetailsNonUS != null ? vehicledetailsNonUS.getPrimaryDamage() : null);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvSecondaryDamage_value);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "nonUs_tvSecondaryDamage_value");
        textView3.setText(vehicledetailsNonUS != null ? vehicledetailsNonUS.getSecondaryDamage() : null);
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvOdometer_value);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "nonUs_tvOdometer_value");
        textView4.setText(vehicledetailsNonUS != null ? vehicledetailsNonUS.getOdometer() : null);
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvStartCode_value);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "nonUs_tvStartCode_value");
        textView5.setText(vehicledetailsNonUS != null ? vehicledetailsNonUS.getStartDesc() : null);
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvKey_value);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "nonUs_tvKey_value");
        if (vehicledetailsNonUS != null) {
            str = vehicledetailsNonUS.getKey();
        }
        textView6.setText(str);
        TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvAirBagDeployment_value);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "nonUs_tvAirBagDeployment_value");
        textView7.setText("");
        TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvAirBag_value);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "nonUs_tvAirBag_value");
        textView8.setText("");
    }

    private final void updateNonUsVehicleTitle(VehicledetailsNonUS vehicledetailsNonUS) {
        String str;
        String str2;
        String str3;
        String str4;
        CharSequence charSequence;
        String branchName2;
        String str5 = null;
        if ((vehicledetailsNonUS != null ? vehicledetailsNonUS.getYear() : null) != null) {
            str = String.valueOf(vehicledetailsNonUS != null ? vehicledetailsNonUS.getYear() : null);
        } else {
            str = "";
        }
        if ((vehicledetailsNonUS != null ? vehicledetailsNonUS.getMake() : null) != null) {
            str2 = String.valueOf(vehicledetailsNonUS != null ? vehicledetailsNonUS.getMake() : null);
        } else {
            str2 = "";
        }
        if ((vehicledetailsNonUS != null ? vehicledetailsNonUS.getModel() : null) != null) {
            str3 = String.valueOf(vehicledetailsNonUS != null ? vehicledetailsNonUS.getModel() : null);
        } else {
            str3 = "";
        }
        if ((vehicledetailsNonUS != null ? vehicledetailsNonUS.getSeries() : null) != null) {
            str4 = String.valueOf(vehicledetailsNonUS != null ? vehicledetailsNonUS.getSeries() : null);
        } else {
            str4 = "";
        }
        String str6 = str + ' ' + str2 + ' ' + str3 + ' ' + str4;
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvVehicleMakeModel);
        Intrinsics.checkExpressionValueIsNotNull(textView, "nonUs_tvVehicleMakeModel");
        if (str6 != null) {
            String upperCase = str6.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            textView.setText(upperCase);
            if ((vehicledetailsNonUS != null ? vehicledetailsNonUS.getAlertMessage() : null) != null) {
                TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_txtLocatedOutsideUSA);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "nonUs_txtLocatedOutsideUSA");
                textView2.setText(vehicledetailsNonUS != null ? vehicledetailsNonUS.getAlertMessage() : null);
            }
            TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvStockValue);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "nonUs_tvStockValue");
            textView3.setText(vehicledetailsNonUS != null ? vehicledetailsNonUS.getStockno() : null);
            TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvVinValue);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "nonUs_tvVinValue");
            if (vehicledetailsNonUS != null) {
                str5 = vehicledetailsNonUS.getVIN();
            }
            textView4.setText(str5);
            TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.nonUs_tvState);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "nonUs_tvState");
            if (vehicledetailsNonUS == null || (branchName2 = vehicledetailsNonUS.getBranchName()) == null) {
                charSequence = "";
            } else {
                charSequence = branchName2;
            }
            textView5.setText(charSequence);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final void updateNonUSVehicleImage(String str) {
        Glide.with(getContext()).load(str).apply(new RequestOptions().centerCrop().error((int) C2723R.C2725drawable.ic_image_na).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.progress_animation)).into((ImageView) _$_findCachedViewById(C2723R.C2726id.img_ukcan_vehicle_image));
    }

    /* access modifiers changed from: private */
    public final void updateBiddingInfo(BiddingInformation biddingInformation, String str) {
        String str2;
        Boolean isUpstreamBranchStock;
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        Application application = baseActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        Boolean biddingInfoViewLessPreferencesMVVM = IAASharedPreference.getBiddingInfoViewLessPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(biddingInfoViewLessPreferencesMVVM, "IAASharedPreference.getB…ation.applicationContext)");
        String str3 = null;
        if (biddingInfoViewLessPreferencesMVVM.booleanValue()) {
            ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_bidding_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_up));
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.whocanbid);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "whocanbid");
            linearLayout.setVisibility(0);
            ((TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle)).setSingleLine(false);
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvBidStatusSubTitle");
            textView.setEllipsize((TextUtils.TruncateAt) null);
        } else {
            ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_bidding_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_down));
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.whocanbid);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "whocanbid");
            linearLayout2.setVisibility(8);
            if (Intrinsics.areEqual((Object) biddingInformation != null ? biddingInformation.getBidStatusIcon() : null, (Object) ExifInterface.LONGITUDE_WEST)) {
                ((TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle)).setSingleLine(false);
                TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "tvBidStatusSubTitle");
                textView2.setEllipsize((TextUtils.TruncateAt) null);
            } else {
                ((TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle)).setSingleLine(true);
                TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView3, "tvBidStatusSubTitle");
                textView3.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        if (biddingInformation == null || (str2 = biddingInformation.getBidStatusIcon()) == null) {
            str2 = "O";
        }
        this.bidStatusIcon = str2;
        updateStatusWarnings(biddingInformation != null ? biddingInformation.getBidStatusWarnings() : null, biddingInformation != null ? biddingInformation.getBidStatusIcon() : null);
        ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2723R.C2726id.svDataContainer);
        Intrinsics.checkExpressionValueIsNotNull(scrollView, "svDataContainer");
        scrollView.setVisibility(0);
        this.IsUpstreamBranchStock = (biddingInformation == null || (isUpstreamBranchStock = biddingInformation.getIsUpstreamBranchStock()) == null) ? false : isUpstreamBranchStock.booleanValue();
        if (biddingInformation != null && biddingInformation.getWatchingAllowed()) {
            updateWatchUI(biddingInformation.getIsWatching());
        }
        if (biddingInformation == null || !biddingInformation.getBidBuyInd()) {
            LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llBidBuyInd);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llBidBuyInd");
            linearLayout3.setVisibility(8);
        } else {
            LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llBidBuyInd);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llBidBuyInd");
            linearLayout4.setVisibility(0);
        }
        List<String> whoCanBuy = biddingInformation != null ? biddingInformation.getWhoCanBuy() : null;
        if (whoCanBuy != null) {
            for (String str4 : whoCanBuy) {
                if (Intrinsics.areEqual((Object) str4, (Object) getString(C2723R.string.can_buy_public))) {
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.img_public)).setImageResource(C2723R.C2725drawable.ic_check);
                } else if (Intrinsics.areEqual((Object) str4, (Object) getString(C2723R.string.can_buy_dealer))) {
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.img_dealer)).setImageResource(C2723R.C2725drawable.ic_check);
                } else if (Intrinsics.areEqual((Object) str4, (Object) getString(C2723R.string.can_buy_dismantler))) {
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.img_dismantler)).setImageResource(C2723R.C2725drawable.ic_check);
                } else if (Intrinsics.areEqual((Object) str4, (Object) getString(C2723R.string.can_buy_exporter))) {
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.img_exporter)).setImageResource(C2723R.C2725drawable.ic_check);
                } else if (Intrinsics.areEqual((Object) str4, (Object) getString(C2723R.string.can_buy_non_auto_licensed_business))) {
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.img_non_auto)).setImageResource(C2723R.C2725drawable.ic_check);
                } else if (Intrinsics.areEqual((Object) str4, (Object) getString(C2723R.string.can_buy_other_licensed_business))) {
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.img_other_licensed)).setImageResource(C2723R.C2725drawable.ic_check);
                } else if (Intrinsics.areEqual((Object) str4, (Object) getString(C2723R.string.can_buy_scrapper))) {
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.img_scrapper)).setImageResource(C2723R.C2725drawable.ic_check);
                } else if (Intrinsics.areEqual((Object) str4, (Object) getString(C2723R.string.can_buy_rebuilder))) {
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.img_rebuilder)).setImageResource(C2723R.C2725drawable.ic_check);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(biddingInformation != null ? biddingInformation.getYear() : null);
        sb.append(' ');
        sb.append(biddingInformation != null ? biddingInformation.getMake() : null);
        sb.append(' ');
        if (biddingInformation != null) {
            str3 = biddingInformation.getModel();
        }
        sb.append(str3);
        sb.append(' ');
        sb.append(str);
        String sb2 = sb.toString();
        this.yearModel = sb2;
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvVehicleMakeModel);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "tvVehicleMakeModel");
        if (sb2 != null) {
            String upperCase = sb2.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            textView4.setText(upperCase);
            BaseActivity baseActivity3 = this.baseActivity;
            if (!(baseActivity3 instanceof ProductDetailActivity)) {
                return;
            }
            if (baseActivity3 != null) {
                ((ProductDetailActivity) baseActivity3).getToolbarTitle().setText(sb2);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.productDetail.ProductDetailActivity");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final void updateStatusWarnings(List<String> list, String str) {
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            int size = collection.size();
            String str2 = "";
            String str3 = str2;
            String str4 = str3;
            String str5 = str4;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    str2 = list.get(i);
                } else if (i != 1) {
                    if (str3.length() == 0) {
                        str3 = list.get(i);
                    } else {
                        str3 = str3 + "<br>" + list.get(i);
                    }
                    str4 = str3;
                } else {
                    str5 = list.get(i);
                }
            }
            if (Intrinsics.areEqual((Object) str2, (Object) "") || str2 == null) {
                TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView, "tvBidStatusTitle");
                textView.setVisibility(8);
            } else {
                TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "tvBidStatusTitle");
                formatWarningTextToHTML(textView2, str2);
            }
            TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "tvBidStatusSubTitle");
            formatWarningTextToHTML(textView3, str5);
            if (str4.length() > 0) {
                TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvStatusWarning);
                Intrinsics.checkExpressionValueIsNotNull(textView4, "tvStatusWarning");
                formatWarningTextToHTML(textView4, str4);
                TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvStatusWarning);
                Intrinsics.checkExpressionValueIsNotNull(textView5, "tvStatusWarning");
                textView5.setVisibility(0);
            } else {
                TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvStatusWarning);
                Intrinsics.checkExpressionValueIsNotNull(textView6, "tvStatusWarning");
                textView6.setVisibility(8);
            }
            BaseActivity baseActivity2 = this.baseActivity;
            if (baseActivity2 == null) {
                Intrinsics.throwNpe();
            }
            Application application = baseActivity2.getApplication();
            Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
            Boolean biddingInfoViewLessPreferencesMVVM = IAASharedPreference.getBiddingInfoViewLessPreferencesMVVM(application.getApplicationContext());
            Intrinsics.checkExpressionValueIsNotNull(biddingInfoViewLessPreferencesMVVM, "IAASharedPreference.getB…ation.applicationContext)");
            if (biddingInfoViewLessPreferencesMVVM.booleanValue()) {
                TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView7, "tvBidStatusSubTitle");
                textView7.setSingleLine(false);
                TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView8, "tvBidStatusSubTitle");
                textView8.setEllipsize((TextUtils.TruncateAt) null);
            } else {
                TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView9, "tvBidStatusSubTitle");
                textView9.setSingleLine(true);
                TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
                Intrinsics.checkExpressionValueIsNotNull(textView10, "tvBidStatusSubTitle");
                textView10.setEllipsize(TextUtils.TruncateAt.END);
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 71) {
                    if (hashCode != 79) {
                        if (hashCode != 87) {
                            if (hashCode == 89 && str.equals("Y")) {
                                ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivColorIcon)).setImageResource(C2723R.C2725drawable.circle_yellow);
                            }
                        } else if (str.equals(ExifInterface.LONGITUDE_WEST)) {
                            ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivColorIcon)).setImageResource(C2723R.C2725drawable.circle_white);
                            TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
                            Intrinsics.checkExpressionValueIsNotNull(textView11, "tvBidStatusSubTitle");
                            textView11.setSingleLine(false);
                            TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusSubTitle);
                            Intrinsics.checkExpressionValueIsNotNull(textView12, "tvBidStatusSubTitle");
                            textView12.setEllipsize((TextUtils.TruncateAt) null);
                        }
                    } else if (str.equals("O")) {
                        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivColorIcon)).setImageResource(C2723R.C2725drawable.circle_orange);
                    }
                } else if (str.equals("G")) {
                    ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivColorIcon)).setImageResource(C2723R.C2725drawable.circle_green);
                }
            }
            if (StringsKt.equals$default(str, "", false, 2, (Object) null) || str == null) {
                ImageView imageView = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivColorIcon);
                Intrinsics.checkExpressionValueIsNotNull(imageView, "ivColorIcon");
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivColorIcon);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivColorIcon");
        imageView2.setVisibility(8);
        TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBidStatusTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView13, "tvBidStatusTitle");
        textView13.setVisibility(8);
    }

    private final void formatWarningTextToHTML(TextView textView, String str) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(str, 0);
            Intrinsics.checkExpressionValueIsNotNull(fromHtml, "Html.fromHtml(warningTex…ml.FROM_HTML_MODE_LEGACY)");
            charSequence = fromHtml;
        } else {
            Spanned fromHtml2 = Html.fromHtml(str);
            Intrinsics.checkExpressionValueIsNotNull(fromHtml2, "Html.fromHtml(warningText)");
            charSequence = fromHtml2;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, charSequence.length(), URLSpan.class);
        Intrinsics.checkExpressionValueIsNotNull(uRLSpanArr, "urls");
        for (URLSpan uRLSpan : uRLSpanArr) {
            Intrinsics.checkExpressionValueIsNotNull(uRLSpan, "span");
            makeLinkClickable(spannableStringBuilder, uRLSpan);
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* access modifiers changed from: private */
    public final void updateBiddingNotes(Spanned spanned) {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.bidding_notes_pre_bid);
        Intrinsics.checkExpressionValueIsNotNull(textView, "bidding_notes_pre_bid");
        textView.setVisibility(0);
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.bidding_notes_pre_bid);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "bidding_notes_pre_bid");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.bidding_notes_pre_bid);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        textView3.setLinkTextColor(ContextCompat.getColor(activity.getApplicationContext(), C2723R.C2724color.iaa_black));
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.bidding_notes_pre_bid);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "bidding_notes_pre_bid");
        textView4.setText(spanned);
    }

    /* access modifiers changed from: private */
    public final void updateBiddingWarnings(WarningTextModel warningTextModel) {
        String str;
        CharSequence charSequence;
        if (!Intrinsics.areEqual((Object) warningTextModel.getWarningText(), (Object) "") || warningTextModel.isTimedAuction()) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_warning);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_warning");
            textView.setVisibility(0);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_warning);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_warning");
            textView2.setVisibility(8);
        }
        if (warningTextModel.isTimedAuction()) {
            String string = getString(C2723R.string.lbl_bdt_timed_auction_label);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.lbl_bdt_timed_auction_label)");
            str = string + "<br>" + warningTextModel.getWarningText();
        } else {
            str = warningTextModel.getWarningText();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(str, 0);
            Intrinsics.checkExpressionValueIsNotNull(fromHtml, "Html.fromHtml(warningTex…ml.FROM_HTML_MODE_LEGACY)");
            charSequence = fromHtml;
        } else {
            Spanned fromHtml2 = Html.fromHtml(str);
            Intrinsics.checkExpressionValueIsNotNull(fromHtml2, "Html.fromHtml(warningTextString)");
            charSequence = fromHtml2;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, charSequence.length(), URLSpan.class);
        Intrinsics.checkExpressionValueIsNotNull(uRLSpanArr, "urls");
        for (URLSpan uRLSpan : uRLSpanArr) {
            Intrinsics.checkExpressionValueIsNotNull(uRLSpan, "span");
            makeLinkClickable(spannableStringBuilder, uRLSpan);
        }
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_warning);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tv_warning");
        textView3.setText(spannableStringBuilder);
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_warning);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "tv_warning");
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void makeLinkClickable(SpannableStringBuilder spannableStringBuilder, URLSpan uRLSpan) {
        spannableStringBuilder.setSpan(new ProductDetailFragment$makeLinkClickable$clickableSpan$1(this, uRLSpan), spannableStringBuilder.getSpanStart(uRLSpan), spannableStringBuilder.getSpanEnd(uRLSpan), spannableStringBuilder.getSpanFlags(uRLSpan));
        spannableStringBuilder.removeSpan(uRLSpan);
    }

    /* access modifiers changed from: private */
    public final void navigateToLicencedBorkerPage(String str) {
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        if (instance.getIAARemoteConfig().getBorkerCommunityFlag()) {
            String string = getString(C2723R.string.url_broker_community_licensed, Constants_MVVM.EXTRA_ENGLISH_CODE);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.url_b…_MVVM.EXTRA_ENGLISH_CODE)");
            if (Intrinsics.areEqual((Object) Utils.getLanguage(), (Object) Constants_MVVM.EXTRA_SPANISH_CODE)) {
                string = getString(C2723R.string.url_broker_community_licensed, Constants_MVVM.EXTRA_SPANISH_CODE);
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.url_b…_MVVM.EXTRA_SPANISH_CODE)");
            }
            str = getString(C2723R.string.base_broker_community_url) + string;
        }
        Intent intent = new Intent(getContext(), WebViewActivity.class);
        intent.putExtra(Constants_MVVM.EXTRA_BROKER_HELP_LINK_URL, str);
        intent.putExtra(Constants_MVVM.EXTRA_BROKER_TITLE, "Licensed Brokers");
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void showEmptyState(boolean z) {
        if (!isAdded()) {
            return;
        }
        if (z) {
            ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2723R.C2726id.svDataContainer);
            Intrinsics.checkExpressionValueIsNotNull(scrollView, "svDataContainer");
            scrollView.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyRecyclerView");
            linearLayout.setVisibility(0);
            return;
        }
        ScrollView scrollView2 = (ScrollView) _$_findCachedViewById(C2723R.C2726id.svDataContainer);
        Intrinsics.checkExpressionValueIsNotNull(scrollView2, "svDataContainer");
        scrollView2.setVisibility(0);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "emptyRecyclerView");
        linearLayout2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoading);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoading);
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            fetchProductDetail();
            return;
        }
        showEmptyState(true);
        displayError(BaseFragment.ErrorType.NO_INTERNET, "");
        IAAAnalytics.INSTANCE.logNetworkEvent("acserviceswebapi/api/GetVehicleDetailsV2", false, "", BaseFragment.ErrorType.NO_INTERNET.getValue());
        InternetUtil internetUtil = InternetUtil.INSTANCE;
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        internetUtil.observe(baseActivity2, new ProductDetailFragment$checkNetworkConnection$1(this));
    }

    /* access modifiers changed from: private */
    public final void fetchProductDetail() {
        ProductDetailViewModel productDetailViewModel = this.viewModel;
        if (productDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        productDetailViewModel.getProductDetail(this.itemId, this.userId, this.tenantCode);
    }

    /* access modifiers changed from: private */
    public final void fetchPartsInfo() {
        ProductDetailViewModel productDetailViewModel = this.viewModel;
        if (productDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        productDetailViewModel.getPartsSectionInfo(this.salvageId);
    }

    private final boolean isPartsInfoAvailable() {
        if (!this.isPartsIndicator) {
            updatePartsButtonUI(false, 8);
            return false;
        } else if (this.isLoggedIn) {
            updatePartsButtonUI(false, 0);
            return true;
        } else {
            updatePartsButtonUI(true, 0);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void loadPartsInfo() {
        List<PartsSectionResponse> list = this.partsList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partsList");
        }
        if (list.size() > 1000) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.VinViewMore);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "VinViewMore");
            linearLayout.setVisibility(0);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.VinViewMore);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "VinViewMore");
            linearLayout2.setVisibility(8);
        }
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        Application application = baseActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        Boolean vinDetailsViewLessPreferencesMVVM = IAASharedPreference.getVinDetailsViewLessPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(vinDetailsViewLessPreferencesMVVM, "IAASharedPreference.getV…ation.applicationContext)");
        if (vinDetailsViewLessPreferencesMVVM.booleanValue()) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.txtVinViewMore);
            Intrinsics.checkExpressionValueIsNotNull(textView, "txtVinViewMore");
            textView.setText(getString(C2723R.string.lbl_view_less));
            ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_vin_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_up));
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.txtVinViewMore);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "txtVinViewMore");
            textView2.setText(getString(C2723R.string.lbl_view_more));
            ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_vin_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_down));
        }
        PartsInfoAdapter partsInfoAdapter2 = this.partsInfoAdapter;
        if (partsInfoAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partsInfoAdapter");
        }
        List<PartsSectionResponse> list2 = this.partsList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partsList");
        }
        partsInfoAdapter2.setPartsData(list2);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPartsDetailsInfo);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvPartsDetailsInfo");
        PartsInfoAdapter partsInfoAdapter3 = this.partsInfoAdapter;
        if (partsInfoAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("partsInfoAdapter");
        }
        recyclerView.setAdapter(partsInfoAdapter3);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPartsDetailsInfo);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvPartsDetailsInfo");
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwNpe();
        }
        Application application2 = baseActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application2, "baseActivity!!.application");
        recyclerView2.setLayoutManager(new LinearLayoutManager(application2.getApplicationContext()));
    }

    public void onDestroy() {
        super.onDestroy();
        ProductDetailViewModel productDetailViewModel = this.viewModel;
        if (productDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        productDetailViewModel.disposeElements();
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        baseActivity2.unregisterReceiver(this.downloadCompleteReceiver);
    }

    public final void checkGustUser() {
        if (IAASharedPreference.getIsLoggedInPreferencesMVVM(getContext()).booleanValue()) {
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            if (!Intrinsics.areEqual((Object) sessionManager2.getCurrentSessionBuyerId(), (Object) "0")) {
                return;
            }
        }
        Toast.makeText(this.baseActivity, getString(C2723R.string.bdt_lbl_to_check_user), 1).show();
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i2 == -1) {
            Boolean isLoggedInPreferencesMVVM = IAASharedPreference.getIsLoggedInPreferencesMVVM(getContext());
            Intrinsics.checkExpressionValueIsNotNull(isLoggedInPreferencesMVVM, "IAASharedPreference.getI…nPreferencesMVVM(context)");
            this.isLoggedIn = isLoggedInPreferencesMVVM.booleanValue();
            checkGustUser();
            String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(getContext());
            Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…dPreferencesMVVM(context)");
            this.userId = userIdPreferencesMVVM;
            if (i == 20) {
                fetchProductDetail();
            } else if (i == 38) {
                showAcceptBuyNowOfferDailog();
            } else if (i != 39) {
                switch (i) {
                    case 25:
                        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.rvPartsLogin);
                        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "rvPartsLogin");
                        linearLayout.setVisibility(8);
                        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.rvPartsDetails);
                        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "rvPartsDetails");
                        linearLayout2.setVisibility(0);
                        LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.rvVinDetails);
                        Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "rvVinDetails");
                        linearLayout3.setVisibility(8);
                        updatePartsButtonUI(false, 0);
                        fetchPartsInfo();
                        return;
                    case 26:
                        BaseActivity baseActivity2 = this.baseActivity;
                        if (baseActivity2 == null) {
                            Intrinsics.throwNpe();
                        }
                        Application application = baseActivity2.getApplication();
                        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
                        String userIdPreferencesMVVM2 = IAASharedPreference.getUserIdPreferencesMVVM(application.getApplicationContext());
                        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM2, "IAASharedPreference.getU…ation.applicationContext)");
                        this.userId = userIdPreferencesMVVM2;
                        this.isWatchingButtonClick = true;
                        addToWatchList();
                        return;
                    case 27:
                        fetchProductDetail();
                        this.isPreBidButtonClick = true;
                        return;
                    case 28:
                        fetchProductDetail();
                        this.isBuyNowButtonClick = true;
                        return;
                    case 29:
                        fetchProductDetail();
                        launchIBidLive();
                        return;
                    default:
                        return;
                }
            } else {
                showDeclineBuyNowOfferDailog();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updatePartsButtonUI(boolean z, int i) {
        isAdded();
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_parts);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_parts");
        textView.setVisibility(i);
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_parts);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_parts");
        textView2.setClickable(z);
    }

    /* access modifiers changed from: private */
    public final void updatePartsErrorSection(String str) {
        isAdded();
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_parts_error);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_parts_error");
        textView.setVisibility(0);
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_parts_error);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_parts_error");
        textView2.setText("Unable to fetch parts information. Please try again later.");
    }

    /* access modifiers changed from: private */
    public final void updateVehicleImageCarousel() {
        if (this.vehicleImages.isEmpty()) {
            CarouselView carouselView = (CarouselView) _$_findCachedViewById(C2723R.C2726id.cvVehicleImages);
            Intrinsics.checkExpressionValueIsNotNull(carouselView, "cvVehicleImages");
            carouselView.setPageCount(1);
        } else {
            CarouselView carouselView2 = (CarouselView) _$_findCachedViewById(C2723R.C2726id.cvVehicleImages);
            Intrinsics.checkExpressionValueIsNotNull(carouselView2, "cvVehicleImages");
            carouselView2.setPageCount(this.vehicleImages.size());
        }
        if (this.isEngineVideoPresent) {
            CarouselView carouselView3 = (CarouselView) _$_findCachedViewById(C2723R.C2726id.cvVehicleImages);
            Intrinsics.checkExpressionValueIsNotNull(carouselView3, "cvVehicleImages");
            CarouselView carouselView4 = (CarouselView) _$_findCachedViewById(C2723R.C2726id.cvVehicleImages);
            Intrinsics.checkExpressionValueIsNotNull(carouselView4, "cvVehicleImages");
            carouselView3.setPageCount(carouselView4.getPageCount() + 1);
        }
    }

    /* access modifiers changed from: private */
    public final void loadVehicleImageUrlForAndroidOS7(boolean z, String str, ImageView imageView) {
        if (z) {
            Picasso.get().load(str).networkPolicy(NetworkPolicy.NO_CACHE, new NetworkPolicy[0]).memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[0]).resize(WOWZMediaConfig.DEFAULT_VIDEO_FRAME_HEIGHT, 360).onlyScaleDown().placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.ic_image_na).into(imageView);
        } else if (Intrinsics.areEqual((Object) str, (Object) "img_engine_video_thumbnail")) {
            Picasso.get().load((int) C2723R.C2725drawable.img_engine_video_thumbnail).into(imageView);
        } else {
            Picasso.get().load((int) C2723R.C2725drawable.ic_image_na).into(imageView);
        }
    }

    /* access modifiers changed from: private */
    public final void vehicleImageUrl(boolean z, String str, ImageView imageView) {
        RequestOptions placeholder = new RequestOptions().centerCrop().error((int) C2723R.C2725drawable.ic_image_na).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.progress_animation);
        if (z) {
            Glide.with(getContext()).load(str).apply(placeholder).into(imageView);
        } else if (Intrinsics.areEqual((Object) str, (Object) "img_engine_video_thumbnail")) {
            RequestManager with = Glide.with(getContext());
            Resources resources = getResources();
            FragmentActivity activity = getActivity();
            if (activity == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
            with.load(Integer.valueOf(resources.getIdentifier(str, "drawable", activity.getPackageName()))).apply(placeholder).into(imageView);
        } else {
            RequestManager with2 = Glide.with(getContext());
            Resources resources2 = getResources();
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(activity2, "activity!!");
            with2.load(Integer.valueOf(resources2.getIdentifier(str, "drawable", activity2.getPackageName()))).apply(placeholder).into(imageView);
        }
    }

    /* access modifiers changed from: private */
    public final void launchNonHDActivity(int i, NonHDImagesMode nonHDImagesMode) {
        Intent intent = new Intent(getContext(), NonHDFullImagesActivity.class);
        intent.putExtra(Constants_MVVM.VEHICLE_IMAGE_CLICKED_POSITION, i);
        intent.putExtra(Constants_MVVM.VEHICLE_IMAGES_LAUNCH_MODE, nonHDImagesMode);
        List<Image> list = this.vehicleImages;
        if (list != null) {
            intent.putExtra(Constants_MVVM.VEHICLE_IMAGES_INFO, (Serializable) list);
            startActivity(intent);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.io.Serializable");
    }

    /* access modifiers changed from: private */
    public final void launch360ImageActivity(String str) {
        Intent intent = new Intent(getContext(), Product360ImageActivity.class);
        intent.putExtra(Constants_MVVM.VEHICLE_IMAGES_360, str);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void launchHDImageActivity() {
        Intent intent = new Intent(getContext(), ProductHDImageActivity.class);
        List<Image> list = this.vehicleImages;
        if (list != null) {
            intent.putExtra(Constants_MVVM.VEHICLE_IMAGES_INFO, (Serializable) list);
            startActivity(intent);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.io.Serializable");
    }

    /* access modifiers changed from: private */
    public final void updateStockAndVinNumber(String str, String str2) {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvStockValue);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvStockValue");
        textView.setText(str);
        if (str2 == null) {
            Intrinsics.throwNpe();
        }
        if (StringsKt.startsWith(str2, "Un", true)) {
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvVinValue);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvVinValue");
            textView2.setText(BinData.UNKNOWN);
            return;
        }
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvVinValue);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvVinValue");
        textView3.setText(Utils.unMaskVinNumber(str2));
    }

    /* access modifiers changed from: private */
    public final void loadConditionInfo(ConditionInformation conditionInformation, ConditionReports conditionReports) {
        List<ConditionInfo> list;
        if (conditionInformation == null || !conditionInformation.getEnableInteractFeature()) {
            CardView cardView = (CardView) _$_findCachedViewById(C2723R.C2726id.cvIaaInteractInfo);
            Intrinsics.checkExpressionValueIsNotNull(cardView, "cvIaaInteractInfo");
            cardView.setVisibility(8);
        } else {
            CardView cardView2 = (CardView) _$_findCachedViewById(C2723R.C2726id.cvIaaInteractInfo);
            Intrinsics.checkExpressionValueIsNotNull(cardView2, "cvIaaInteractInfo");
            cardView2.setVisibility(0);
        }
        loadReport(conditionReports);
        loadFindParts();
        if (conditionInformation == null || (list = conditionInformation.getConditionInfo()) == null) {
            list = CollectionsKt.emptyList();
        }
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivConditionToolTip)).setOnClickListener(new ProductDetailFragment$loadConditionInfo$1(this));
        displayConditionInfo(list);
    }

    /* access modifiers changed from: private */
    public final void loadVehicleGradeInformation(VehicleGradeInformation vehicleGradeInformation) {
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        if (!instance.getIAARemoteConfig().getVehicleGradeInformationFlag()) {
            handleGradeContainerVisibility();
        } else if (vehicleGradeInformation == null || !vehicleGradeInformation.getIsVehicleGrade() || StringsKt.equals(vehicleGradeInformation.getVehicleGradeValue(), IdManager.DEFAULT_VERSION_NAME, false) || StringsKt.equals(vehicleGradeInformation.getVehicleGradeValue(), "0", false)) {
            handleGradeContainerVisibility();
        } else {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.rlGradeContainer);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "rlGradeContainer");
            linearLayout.setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.separatorGrade);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "separatorGrade");
            _$_findCachedViewById.setVisibility(0);
            this.salesForceVehicleConditionGradeURL = vehicleGradeInformation.getSalesForceVehicleConditionGradeURL();
            String vehicleGradeValue = vehicleGradeInformation.getVehicleGradeValue();
            setTubeSpeedOmeter(vehicleGradeValue != null ? StringsKt.toFloatOrNull(vehicleGradeValue) : null);
        }
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvGradeLearn)).setOnClickListener(new ProductDetailFragment$loadVehicleGradeInformation$1(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.iv_arrowMore)).setOnClickListener(new ProductDetailFragment$loadVehicleGradeInformation$2(this));
    }

    private final void handleGradeContainerVisibility() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.rlGradeContainer);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "rlGradeContainer");
        linearLayout.setVisibility(8);
        View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.separatorGrade);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "separatorGrade");
        _$_findCachedViewById.setVisibility(8);
    }

    private final void loadFindParts() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvFindPartReport);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvFindPartReport");
        textView.setPaintFlags(8);
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvFindPartReport)).setOnClickListener(new ProductDetailFragment$loadFindParts$1(this));
    }

    private final void loadReport(ConditionReports conditionReports) {
        String str;
        if (conditionReports != null) {
            Collection reports = conditionReports.getReports();
            boolean z = true;
            if (!(reports == null || reports.isEmpty())) {
                List<Reports> reports2 = conditionReports.getReports();
                String str2 = "";
                if (reports2 != null) {
                    str = str2;
                    for (Reports reports3 : reports2) {
                        if (Intrinsics.areEqual((Object) reports3.getKey(), (Object) "IAA Condition Report") || Intrinsics.areEqual((Object) reports3.getKey(), (Object) "Informe de IAA sobre condiciones")) {
                            str2 = reports3.getValue();
                        }
                        if (Intrinsics.areEqual((Object) reports3.getKey(), (Object) "Premium Vehicle Report") || Intrinsics.areEqual((Object) reports3.getKey(), (Object) "Informe Premium de Vehículo")) {
                            str = reports3.getValue();
                        }
                    }
                } else {
                    str = str2;
                }
                if (str2.length() > 0) {
                    TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvIAAConditionReport);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "tvIAAConditionReport");
                    textView.setPaintFlags(8);
                    TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvIAAConditionReport);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "tvIAAConditionReport");
                    textView2.setVisibility(0);
                    ((TextView) _$_findCachedViewById(C2723R.C2726id.tvIAAConditionReport)).setOnClickListener(new ProductDetailFragment$loadReport$2(this, getString(C2723R.string.base_https_url) + str2));
                }
                if (str.length() <= 0) {
                    z = false;
                }
                if (z) {
                    RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_premium_vehicle_report);
                    Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "rl_premium_vehicle_report");
                    relativeLayout.setVisibility(0);
                    TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvPremiumVehicleReport);
                    Intrinsics.checkExpressionValueIsNotNull(textView3, "tvPremiumVehicleReport");
                    textView3.setPaintFlags(8);
                    ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPremiumVehicleReport)).setOnClickListener(new ProductDetailFragment$loadReport$3(this, getString(C2723R.string.base_https_url) + str));
                }
            }
        }
    }

    private final void displayConditionInfo(List<ConditionInfo> list) {
        ArrayList arrayList = new ArrayList();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            for (ConditionInfo next : list) {
                Collection displayValues = next.getDisplayValues();
                if (!(displayValues == null || displayValues.isEmpty())) {
                    if (StringsKt.equals(next.getDisplayText(), "Loss", true)) {
                        for (DisplayValue text : next.getDisplayValues()) {
                            if (!Intrinsics.areEqual((Object) text.getText(), (Object) "")) {
                                arrayList.add(next);
                            }
                        }
                    } else {
                        arrayList.add(next);
                    }
                }
            }
        }
        if (arrayList.size() > 1000) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.condition_viewMore);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "condition_viewMore");
            linearLayout.setVisibility(0);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.condition_viewMore);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "condition_viewMore");
            linearLayout2.setVisibility(8);
        }
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        Application application = baseActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        Boolean vCConditionViewLessPreferencesMVVM = IAASharedPreference.getVCConditionViewLessPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(vCConditionViewLessPreferencesMVVM, "IAASharedPreference.getV…ation.applicationContext)");
        if (vCConditionViewLessPreferencesMVVM.booleanValue()) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.txtVCCondiViewMore);
            Intrinsics.checkExpressionValueIsNotNull(textView, "txtVCCondiViewMore");
            textView.setText(getString(C2723R.string.lbl_view_less));
            ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_VCcondition_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_up));
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.txtVCCondiViewMore);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "txtVCCondiViewMore");
            textView2.setText(getString(C2723R.string.lbl_view_more));
            ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_VCcondition_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_down));
        }
        ConditionInfoAdapter conditionInfoAdapter2 = this.conditionInfoAdapter;
        if (conditionInfoAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conditionInfoAdapter");
        }
        conditionInfoAdapter2.setConditionsData(arrayList);
        ConditionInfoAdapter conditionInfoAdapter3 = this.conditionInfoAdapter;
        if (conditionInfoAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conditionInfoAdapter");
        }
        conditionInfoAdapter3.setIsKeyImagePresent(this.isKeyImagePresent);
        ConditionInfoAdapter conditionInfoAdapter4 = this.conditionInfoAdapter;
        if (conditionInfoAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conditionInfoAdapter");
        }
        conditionInfoAdapter4.setIsEngineVideoPresent(this.isEngineVideoPresent);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvConditionInfo);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvConditionInfo");
        ConditionInfoAdapter conditionInfoAdapter5 = this.conditionInfoAdapter;
        if (conditionInfoAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conditionInfoAdapter");
        }
        recyclerView.setAdapter(conditionInfoAdapter5);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvConditionInfo);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvConditionInfo");
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwNpe();
        }
        Application application2 = baseActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application2, "baseActivity!!.application");
        recyclerView2.setLayoutManager(new LinearLayoutManager(application2.getApplicationContext()));
    }

    /* access modifiers changed from: private */
    public final void updateVINInfo(VinDetails vinDetails) {
        List<VINInfo> list;
        if (vinDetails == null || (list = vinDetails.getVINInfo()) == null) {
            list = CollectionsKt.emptyList();
        }
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.iv_vin_tool_tip)).setOnClickListener(new ProductDetailFragment$updateVINInfo$1(this, vinDetails));
        if (this.chromeIndicator) {
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnChromeData);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnChromeData");
            button.setVisibility(0);
        } else {
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnChromeData);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnChromeData");
            button2.setVisibility(8);
        }
        displayVinDetailsInfo(list);
    }

    private final void displayVinDetailsInfo(List<VINInfo> list) {
        ArrayList arrayList = new ArrayList();
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            for (VINInfo next : list) {
                Collection displayValues = next.getDisplayValues();
                if (!(displayValues == null || displayValues.isEmpty())) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.size() > 1000) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.VinViewMore);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "VinViewMore");
            linearLayout.setVisibility(0);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.VinViewMore);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "VinViewMore");
            linearLayout2.setVisibility(8);
        }
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        Application application = baseActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        Boolean vinDetailsViewLessPreferencesMVVM = IAASharedPreference.getVinDetailsViewLessPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(vinDetailsViewLessPreferencesMVVM, "IAASharedPreference.getV…ation.applicationContext)");
        if (vinDetailsViewLessPreferencesMVVM.booleanValue()) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.txtVinViewMore);
            Intrinsics.checkExpressionValueIsNotNull(textView, "txtVinViewMore");
            textView.setText(getString(C2723R.string.lbl_view_less));
            ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_vin_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_up));
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.txtVinViewMore);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "txtVinViewMore");
            textView2.setText(getString(C2723R.string.lbl_view_more));
            ((ImageView) _$_findCachedViewById(C2723R.C2726id.ic_vin_view_more)).setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.ic_view_down));
        }
        VinInfoAdapter vinInfoAdapter = this.vininfoAdapter;
        if (vinInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vininfoAdapter");
        }
        vinInfoAdapter.setVinInfoData(arrayList);
        VinInfoAdapter vinInfoAdapter2 = this.vininfoAdapter;
        if (vinInfoAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vininfoAdapter");
        }
        vinInfoAdapter2.setIsEngineVideoPresent(this.isEngineVideoPresent);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvVinDetailsInfo);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvVinDetailsInfo");
        VinInfoAdapter vinInfoAdapter3 = this.vininfoAdapter;
        if (vinInfoAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vininfoAdapter");
        }
        recyclerView.setAdapter(vinInfoAdapter3);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvVinDetailsInfo);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvVinDetailsInfo");
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwNpe();
        }
        Application application2 = baseActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application2, "baseActivity!!.application");
        recyclerView2.setLayoutManager(new LinearLayoutManager(application2.getApplicationContext()));
    }

    /* access modifiers changed from: private */
    public final void updateSaleInfo(int i) {
        int i2;
        String str;
        String str2;
        String str3;
        String sb;
        int i3;
        int i4;
        String str4;
        String sb2;
        SaleInfo saleInfo;
        SaleInformation saleInformation2 = this.saleInformation;
        if (saleInformation2 != null) {
            if (saleInformation2 == null || (saleInfo = saleInformation2.getSaleInfo()) == null || (str = saleInfo.getStockNumber()) == null) {
                str = "";
            }
            this.stockNumber = str;
            SaleInformation saleInformation3 = this.saleInformation;
            if (saleInformation3 == null || (str2 = saleInformation3.getBranchLink()) == null) {
                str2 = "";
            }
            this.branchName = str2;
            ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llSalesInfo)).removeAllViews();
            String string = getResources().getString(C2723R.string.lbl_selling_branch);
            Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.lbl_selling_branch)");
            SaleInformation saleInformation4 = this.saleInformation;
            Object obj = null;
            String branchLink = saleInformation4 != null ? saleInformation4.getBranchLink() : null;
            SaleInformation saleInformation5 = this.saleInformation;
            if (saleInformation5 == null) {
                Intrinsics.throwNpe();
            }
            int inflateSalesInfo = inflateSalesInfo(string, branchLink, saleInformation5.getBranchCode(), "", 0) + 0;
            SaleInformation saleInformation6 = this.saleInformation;
            if (saleInformation6 == null) {
                Intrinsics.throwNpe();
            }
            if (saleInformation6.getIsVehicleAtBranch()) {
                str3 = getResources().getString(C2723R.string.lbl_at_the_branch);
                Intrinsics.checkExpressionValueIsNotNull(str3, "resources.getString(R.string.lbl_at_the_branch)");
            } else {
                str3 = getResources().getString(C2723R.string.lbl_offsite);
                Intrinsics.checkExpressionValueIsNotNull(str3, "resources.getString(R.string.lbl_offsite)");
            }
            String string2 = getResources().getString(C2723R.string.lbl_vehicle_location);
            Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.string.lbl_vehicle_location)");
            int inflateSalesInfo2 = inflateSalesInfo + inflateSalesInfo(string2, str3, 0, "", 0);
            this.vehicleLoc = str3;
            SaleInformation saleInformation7 = this.saleInformation;
            if (saleInformation7 == null) {
                Intrinsics.throwNpe();
            }
            boolean z = true;
            if (!saleInformation7.getIsVehicleAtBranch()) {
                SaleInformation saleInformation8 = this.saleInformation;
                if (saleInformation8 == null) {
                    Intrinsics.throwNpe();
                }
                if (saleInformation8.getIsVehicleAtIAABranchForVirualBranch()) {
                    String string3 = getResources().getString(C2723R.string.lbl_is_at_remote_branch);
                    Intrinsics.checkExpressionValueIsNotNull(string3, "resources.getString(R.st….lbl_is_at_remote_branch)");
                    SaleInformation saleInformation9 = this.saleInformation;
                    if (saleInformation9 == null) {
                        Intrinsics.throwNpe();
                    }
                    String iaaBranchLocationForVirtualBranch = saleInformation9.getIaaBranchLocationForVirtualBranch();
                    SaleInformation saleInformation10 = this.saleInformation;
                    if (saleInformation10 == null) {
                        Intrinsics.throwNpe();
                    }
                    inflateSalesInfo2 += inflateSalesInfo(string3, iaaBranchLocationForVirtualBranch, saleInformation10.getIaaBranchCodeForVirtualBranch(), "", 0);
                    SaleInformation saleInformation11 = this.saleInformation;
                    if (saleInformation11 == null) {
                        Intrinsics.throwNpe();
                    }
                    this.vehicleLoc = saleInformation11.getIaaBranchLocationForVirtualBranch();
                }
                SaleInformation saleInformation12 = this.saleInformation;
                if (saleInformation12 == null) {
                    Intrinsics.throwNpe();
                }
                CharSequence locationName = saleInformation12.getLocationName();
                if (locationName == null || locationName.length() == 0) {
                    StringBuilder sb3 = new StringBuilder();
                    SaleInformation saleInformation13 = this.saleInformation;
                    if (saleInformation13 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb3.append(saleInformation13.getAddress());
                    sb3.append(10);
                    SaleInformation saleInformation14 = this.saleInformation;
                    if (saleInformation14 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb3.append(saleInformation14.getCity());
                    sb3.append(", ");
                    SaleInformation saleInformation15 = this.saleInformation;
                    if (saleInformation15 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb3.append(saleInformation15.getState());
                    sb3.append(", ");
                    SaleInformation saleInformation16 = this.saleInformation;
                    if (saleInformation16 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb3.append(saleInformation16.getZip());
                    sb3.append(10);
                    SaleInformation saleInformation17 = this.saleInformation;
                    if (saleInformation17 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb3.append(saleInformation17.getPhone());
                    sb2 = sb3.toString();
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    SaleInformation saleInformation18 = this.saleInformation;
                    if (saleInformation18 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb4.append(saleInformation18.getLocationName());
                    sb4.append(10);
                    SaleInformation saleInformation19 = this.saleInformation;
                    if (saleInformation19 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb4.append(saleInformation19.getAddress());
                    sb4.append(10);
                    SaleInformation saleInformation20 = this.saleInformation;
                    if (saleInformation20 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb4.append(saleInformation20.getCity());
                    sb4.append(", ");
                    SaleInformation saleInformation21 = this.saleInformation;
                    if (saleInformation21 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb4.append(saleInformation21.getState());
                    sb4.append(", ");
                    SaleInformation saleInformation22 = this.saleInformation;
                    if (saleInformation22 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb4.append(saleInformation22.getZip());
                    sb4.append(10);
                    SaleInformation saleInformation23 = this.saleInformation;
                    if (saleInformation23 == null) {
                        Intrinsics.throwNpe();
                    }
                    sb4.append(saleInformation23.getPhone());
                    sb2 = sb4.toString();
                }
                String str5 = sb2;
                this.vehicleLoc += "\n" + str5;
                String string4 = getResources().getString(C2723R.string.lbl_branch_address);
                Intrinsics.checkExpressionValueIsNotNull(string4, "resources.getString(R.string.lbl_branch_address)");
                inflateSalesInfo2 += inflateSalesInfo(string4, str5, 0, "", 0);
                SaleInformation saleInformation24 = this.saleInformation;
                if (saleInformation24 == null) {
                    Intrinsics.throwNpe();
                }
                if (saleInformation24.getDisplayMoreLinkForRemote()) {
                    String string5 = getResources().getString(C2723R.string.lbl_more);
                    Intrinsics.checkExpressionValueIsNotNull(string5, "resources.getString(R.string.lbl_more)");
                    String string6 = getResources().getString(C2723R.string.lbl_more);
                    SaleInformation saleInformation25 = this.saleInformation;
                    if (saleInformation25 == null) {
                        Intrinsics.throwNpe();
                    }
                    inflateSalesInfo2 += inflateSalesInfo(string5, string6, 0, saleInformation25.getRemoteSaleInfo(), 0);
                }
            }
            if (Intrinsics.areEqual((Object) this.vehicleStatus, (Object) "WC")) {
                sb = getResources().getString(C2723R.string.lbl_not_ready_for_sale);
            } else {
                StringBuilder sb5 = new StringBuilder();
                SaleInformation saleInformation26 = this.saleInformation;
                if (saleInformation26 == null) {
                    Intrinsics.throwNpe();
                }
                sb5.append(saleInformation26.getDay());
                sb5.append(' ');
                SaleInformation saleInformation27 = this.saleInformation;
                if (saleInformation27 == null) {
                    Intrinsics.throwNpe();
                }
                sb5.append(saleInformation27.getMonth());
                sb5.append(' ');
                SaleInformation saleInformation28 = this.saleInformation;
                if (saleInformation28 == null) {
                    Intrinsics.throwNpe();
                }
                sb5.append(saleInformation28.getDate());
                sb5.append(", ");
                SaleInformation saleInformation29 = this.saleInformation;
                if (saleInformation29 == null) {
                    Intrinsics.throwNpe();
                }
                sb5.append(saleInformation29.getLiveDateString());
                sb5.append(" (");
                SaleInformation saleInformation30 = this.saleInformation;
                if (saleInformation30 == null) {
                    Intrinsics.throwNpe();
                }
                sb5.append(saleInformation30.getUserTimezoneAbb());
                sb5.append(')');
                sb = sb5.toString();
            }
            String str6 = sb;
            Intrinsics.checkExpressionValueIsNotNull(str6, "auctionDateTime");
            this.auctionDate = str6;
            String string7 = getResources().getString(C2723R.string.lbl_auction_date_time);
            Intrinsics.checkExpressionValueIsNotNull(string7, "resources.getString(R.st…ng.lbl_auction_date_time)");
            int inflateSalesInfo3 = inflateSalesInfo2 + inflateSalesInfo(string7, str6, 0, "", 0);
            StringBuilder sb6 = new StringBuilder();
            SaleInformation saleInformation31 = this.saleInformation;
            if (saleInformation31 == null) {
                Intrinsics.throwNpe();
            }
            sb6.append(saleInformation31.getLane());
            sb6.append(" - #");
            SaleInformation saleInformation32 = this.saleInformation;
            if (saleInformation32 == null) {
                Intrinsics.throwNpe();
            }
            sb6.append(saleInformation32.getSlot());
            String sb7 = sb6.toString();
            String string8 = getResources().getString(C2723R.string.lbl_lane_item);
            Intrinsics.checkExpressionValueIsNotNull(string8, "resources.getString(R.string.lbl_lane_item)");
            int inflateSalesInfo4 = inflateSalesInfo3 + inflateSalesInfo(string8, sb7, 0, "", i);
            SaleInformation saleInformation33 = this.saleInformation;
            CharSequence row = saleInformation33 != null ? saleInformation33.getRow() : null;
            if (!(row == null || row.length() == 0)) {
                SaleInformation saleInformation34 = this.saleInformation;
                if ((saleInformation34 != null ? saleInformation34.getStallNumber() : null) != null) {
                    StringBuilder sb8 = new StringBuilder();
                    SaleInformation saleInformation35 = this.saleInformation;
                    sb8.append(saleInformation35 != null ? saleInformation35.getRow() : null);
                    sb8.append(" - ");
                    SaleInformation saleInformation36 = this.saleInformation;
                    if (saleInformation36 != null) {
                        obj = saleInformation36.getStallNumber();
                    }
                    sb8.append(obj);
                    str4 = sb8.toString();
                } else {
                    SaleInformation saleInformation37 = this.saleInformation;
                    if (saleInformation37 != null) {
                        obj = saleInformation37.getRow();
                    }
                    str4 = String.valueOf(obj);
                }
                String string9 = getResources().getString(C2723R.string.lbl_aisle_stall);
                Intrinsics.checkExpressionValueIsNotNull(string9, "resources.getString(R.string.lbl_aisle_stall)");
                inflateSalesInfo4 += inflateSalesInfo(string9, str4, 0, "", i);
            }
            String string10 = getResources().getString(C2723R.string.lbl_seller);
            Intrinsics.checkExpressionValueIsNotNull(string10, "resources.getString(R.string.lbl_seller)");
            SaleInformation saleInformation38 = this.saleInformation;
            if (saleInformation38 == null) {
                Intrinsics.throwNpe();
            }
            int inflateSalesInfo5 = inflateSalesInfo4 + inflateSalesInfo(string10, saleInformation38.getSeller(), 0, "", i);
            SaleInformation saleInformation39 = this.saleInformation;
            if (saleInformation39 == null) {
                Intrinsics.throwNpe();
            }
            CharSequence acv = saleInformation39.getACV();
            if (acv == null || acv.length() == 0) {
                String string11 = getResources().getString(C2723R.string.lbl_actual_cash_value);
                Intrinsics.checkExpressionValueIsNotNull(string11, "resources.getString(R.st…ng.lbl_actual_cash_value)");
                SaleInformation saleInformation40 = this.saleInformation;
                if (saleInformation40 == null) {
                    Intrinsics.throwNpe();
                }
                i3 = inflateSalesInfo(string11, saleInformation40.getACV(), 0, "", i);
            } else {
                String string12 = getResources().getString(C2723R.string.lbl_actual_cash_value);
                Intrinsics.checkExpressionValueIsNotNull(string12, "resources.getString(R.st…ng.lbl_actual_cash_value)");
                StringBuilder sb9 = new StringBuilder();
                SaleInformation saleInformation41 = this.saleInformation;
                if (saleInformation41 == null) {
                    Intrinsics.throwNpe();
                }
                sb9.append(saleInformation41.getACV());
                sb9.append(" USD");
                i3 = inflateSalesInfo(string12, sb9.toString(), 0, "", i);
            }
            int i5 = inflateSalesInfo5 + i3;
            SaleInformation saleInformation42 = this.saleInformation;
            if (saleInformation42 == null) {
                Intrinsics.throwNpe();
            }
            CharSequence estimatedRepairCost = saleInformation42.getEstimatedRepairCost();
            if (estimatedRepairCost == null || estimatedRepairCost.length() == 0) {
                String string13 = getResources().getString(C2723R.string.lbl_estimated_repair_cost);
                Intrinsics.checkExpressionValueIsNotNull(string13, "resources.getString(R.st…bl_estimated_repair_cost)");
                SaleInformation saleInformation43 = this.saleInformation;
                if (saleInformation43 == null) {
                    Intrinsics.throwNpe();
                }
                i4 = inflateSalesInfo(string13, saleInformation43.getEstimatedRepairCost(), 0, "", i);
            } else {
                String string14 = getResources().getString(C2723R.string.lbl_estimated_repair_cost);
                Intrinsics.checkExpressionValueIsNotNull(string14, "resources.getString(R.st…bl_estimated_repair_cost)");
                StringBuilder sb10 = new StringBuilder();
                SaleInformation saleInformation44 = this.saleInformation;
                if (saleInformation44 == null) {
                    Intrinsics.throwNpe();
                }
                sb10.append(saleInformation44.getEstimatedRepairCost());
                sb10.append(" USD");
                i4 = inflateSalesInfo(string14, sb10.toString(), 0, "", i);
            }
            int i6 = i5 + i4;
            String string15 = getResources().getString(C2723R.string.lbl_title_doc);
            Intrinsics.checkExpressionValueIsNotNull(string15, "resources.getString(R.string.lbl_title_doc)");
            SaleInformation saleInformation45 = this.saleInformation;
            if (saleInformation45 == null) {
                Intrinsics.throwNpe();
            }
            i2 = i6 + inflateSalesInfo(string15, saleInformation45.getSaleDoc(), 0, "", i);
            SaleInformation saleInformation46 = this.saleInformation;
            if (saleInformation46 == null) {
                Intrinsics.throwNpe();
            }
            if (saleInformation46.getSaleInfo().getBrand().length() > 0) {
                String string16 = getResources().getString(C2723R.string.lbl_title_doc_brand);
                Intrinsics.checkExpressionValueIsNotNull(string16, "resources.getString(R.string.lbl_title_doc_brand)");
                SaleInformation saleInformation47 = this.saleInformation;
                if (saleInformation47 == null) {
                    Intrinsics.throwNpe();
                }
                i2 += inflateSalesInfo(string16, saleInformation47.getSaleInfo().getBrand(), 0, "", i);
            }
            SaleInformation saleInformation48 = this.saleInformation;
            if (saleInformation48 == null) {
                Intrinsics.throwNpe();
            }
            if (saleInformation48.getSaleInfo().getNotes().length() > 0) {
                String string17 = getResources().getString(C2723R.string.lbl_title_doc_notes);
                Intrinsics.checkExpressionValueIsNotNull(string17, "resources.getString(R.string.lbl_title_doc_notes)");
                SaleInformation saleInformation49 = this.saleInformation;
                if (saleInformation49 == null) {
                    Intrinsics.throwNpe();
                }
                i2 += inflateSalesInfo(string17, saleInformation49.getSaleInfo().getNotes(), 0, "", i);
            }
            if (this.tboInd) {
                SaleInformation saleInformation50 = this.saleInformation;
                if (saleInformation50 == null) {
                    Intrinsics.throwNpe();
                }
                CharSequence tBONotes = saleInformation50.getTBONotes();
                if (!(tBONotes == null || tBONotes.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    SaleInformation saleInformation51 = this.saleInformation;
                    if (saleInformation51 == null) {
                        Intrinsics.throwNpe();
                    }
                    i2 += inflateSalesInfo("", saleInformation51.getTBONotes(), 0, "", i);
                }
            }
            ((ImageView) _$_findCachedViewById(C2723R.C2726id.iv_sale_info_tip)).setOnClickListener(new ProductDetailFragment$updateSaleInfo$1(this));
        } else {
            i2 = 0;
        }
        if (i2 > 1000) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.salesInfoViewMore);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "salesInfoViewMore");
            linearLayout.setVisibility(0);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.salesInfoViewMore);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "salesInfoViewMore");
        linearLayout2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void updateWatchUI(boolean z) {
        if (z) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llWatchLayout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llWatchLayout");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llUnWatchLayout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llUnWatchLayout");
            linearLayout2.setVisibility(0);
            return;
        }
        LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llUnWatchLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llUnWatchLayout");
        linearLayout3.setVisibility(8);
        LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llWatchLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llWatchLayout");
        linearLayout4.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void addToWatchList() {
        String string = getResources().getString(C2723R.string.lbl_watch_action_add);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.lbl_watch_action_add)");
        this.action = string;
        ProductDetailViewModel productDetailViewModel = this.viewModel;
        if (productDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[0] = sessionManager2.getCurrentSessionUsername();
        SessionManager sessionManager3 = this.sessionManager;
        if (sessionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[1] = sessionManager3.getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        productDetailViewModel.updateWatchStatus(format, this.itemId, this.userId, this.action);
    }

    /* access modifiers changed from: private */
    public final void removeFromWatchList() {
        String string = getResources().getString(C2723R.string.lbl_watch_action_delete);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st….lbl_watch_action_delete)");
        this.action = string;
        ProductDetailViewModel productDetailViewModel = this.viewModel;
        if (productDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[0] = sessionManager2.getCurrentSessionUsername();
        SessionManager sessionManager3 = this.sessionManager;
        if (sessionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[1] = sessionManager3.getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        productDetailViewModel.updateWatchStatus(format, this.itemId, this.userId, this.action);
    }

    /* access modifiers changed from: private */
    public final boolean checkUserValidAndBidBuyClick(PrebidInformation prebidInformation) {
        String str;
        if (prebidInformation == null) {
            Intrinsics.throwNpe();
        }
        this.isPublic = prebidInformation.getIsPublic();
        this.preBidErrorMsg = prebidInformation.getPrebidPopupErrorMessage();
        if (checkForInValidUser() || (prebidInformation.getIsPublic() && prebidInformation.getPrebidPopupErrorMessage() != null)) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPreBidSection);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llPreBidSection");
            linearLayout.setVisibility(0);
            disableActionAreaButtons();
        } else if (this.isPreBidButtonClick) {
            this.isPreBidButtonClick = false;
            this.pickUpDate = prebidInformation.getPrebidPickUpDate();
            this.paymentDueDate = prebidInformation.getPrebidPayDate();
            this.displaySaleTaxWarning = prebidInformation.getDisplaySalesTaxWarning();
            this.displaySaleTextMessage = prebidInformation.getSalesTaxWarningMessage();
            this.preBidCurrentBid = prebidInformation.getDecimalHighBidAmount();
            if (Float.parseFloat(this.preBidCurrentBid) > 0.0f) {
                str = prebidInformation.getOutBidAmountNeededText();
            } else {
                Integer num = this.startingBid;
                if (num != null && num.intValue() == 0) {
                    str = prebidInformation.getOutBidAmountNeededText();
                } else {
                    str = prebidInformation.getStartingBidAmountNeededText();
                }
            }
            this.preBidIncrement = str;
            this.formattedMyMax = prebidInformation.getFormattedMyMax();
            String myMax2 = prebidInformation.getMyMax();
            if (myMax2 == null) {
                myMax2 = "";
            }
            this.myMax = myMax2;
            navigateToPreBidPageIfAlreadyLogin();
            return true;
        } else if (this.isBuyNowButtonClick) {
            this.isBuyNowButtonClick = false;
            String iBFPickUpDate = prebidInformation.getIBFPickUpDate();
            if (iBFPickUpDate == null) {
                iBFPickUpDate = "";
            }
            this.ibfPickUpDate = iBFPickUpDate;
            String iBFPayDate = prebidInformation.getIBFPayDate();
            if (iBFPayDate == null) {
                iBFPayDate = "";
            }
            this.ibfPaymentDueDate = iBFPayDate;
            navigateToBuyNowPageIfAlreadyLogin();
            return true;
        } else {
            enableActionAreaButtons();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void updatePreBidActionArea(PrebidInformation prebidInformation) {
        String str;
        checkUserValidAndBidBuyClick(prebidInformation);
        StringBuilder sb = new StringBuilder();
        if (prebidInformation == null) {
            Intrinsics.throwNpe();
        }
        sb.append(prebidInformation.getBuyNowPrice());
        sb.append(" USD");
        this.buyNowPrice = sb.toString();
        this.auctionId = prebidInformation.getAuctionID();
        this.pickUpDate = prebidInformation.getPrebidPickUpDate();
        this.paymentDueDate = prebidInformation.getPrebidPayDate();
        this.awardMessage = prebidInformation.getPrebidAwardMesssage();
        String iBFPickUpDate = prebidInformation.getIBFPickUpDate();
        if (iBFPickUpDate == null) {
            iBFPickUpDate = "";
        }
        this.ibfPickUpDate = iBFPickUpDate;
        String iBFPayDate = prebidInformation.getIBFPayDate();
        if (iBFPayDate == null) {
            iBFPayDate = "";
        }
        this.ibfPaymentDueDate = iBFPayDate;
        String iBFAwardMesssage = prebidInformation.getIBFAwardMesssage();
        if (iBFAwardMesssage == null) {
            iBFAwardMesssage = "";
        }
        this.ibfAwardMessage = iBFAwardMesssage;
        this.liveDate = prebidInformation.getLiveDate();
        this.preBidCurrentBid = prebidInformation.getDecimalHighBidAmount();
        if (Float.parseFloat(this.preBidCurrentBid) > 0.0f) {
            str = prebidInformation.getOutBidAmountNeededText();
        } else {
            Integer num = this.startingBid;
            if (num != null && num.intValue() == 0) {
                str = prebidInformation.getOutBidAmountNeededText();
            } else {
                str = prebidInformation.getStartingBidAmountNeededText();
            }
        }
        this.preBidIncrement = str;
        this.formattedMyMax = prebidInformation.getFormattedMyMax();
        String myMax2 = prebidInformation.getMyMax();
        if (myMax2 == null) {
            myMax2 = "";
        }
        this.myMax = myMax2;
        this.displaySaleTaxWarning = prebidInformation.getDisplaySalesTaxWarning();
        this.displaySaleTextMessage = prebidInformation.getSalesTaxWarningMessage();
        this.buyNowOfferAmount = prebidInformation.getBuyNowOfferAmount();
        DateHelper.TimeDiff calculateDateTimeDiff = DateHelper.calculateDateTimeDiff(new Date(), DateHelper.parseDateInServerTimezone(prebidInformation.getAdjustedCloseDate()));
        if (calculateDateTimeDiff != null) {
            String preBidTimeString = calculateDateTimeDiff.getPreBidTimeString();
            Intrinsics.checkExpressionValueIsNotNull(preBidTimeString, "timeDiff.preBidTimeString");
            this.preBidTimeRemaining = preBidTimeString;
        }
        if (Intrinsics.areEqual((Object) prebidInformation.getVehicleStatus(), (Object) "WC")) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvAuctionNotAssigned);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvAuctionNotAssigned");
            textView.setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.auctionNotAssignSeparator);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "auctionNotAssignSeparator");
            _$_findCachedViewById.setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPreBidSection);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llPreBidSection");
            linearLayout.setVisibility(8);
            View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.preBidSeparator);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "preBidSeparator");
            _$_findCachedViewById2.setVisibility(8);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvAuctionNotAssigned);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvAuctionNotAssigned");
            textView2.setVisibility(8);
            View _$_findCachedViewById3 = _$_findCachedViewById(C2723R.C2726id.auctionNotAssignSeparator);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById3, "auctionNotAssignSeparator");
            _$_findCachedViewById3.setVisibility(8);
            View _$_findCachedViewById4 = _$_findCachedViewById(C2723R.C2726id.preBidSeparator);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById4, "preBidSeparator");
            _$_findCachedViewById4.setVisibility(0);
            if (!prebidInformation.getBuyNowSold() && !prebidInformation.getTimedAuctionInd()) {
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPreBidSection);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llPreBidSection");
                linearLayout2.setVisibility(0);
                stockIsPreBid(prebidInformation);
            } else if (!prebidInformation.getBuyNowSold() || prebidInformation.getTimedAuctionInd()) {
                stockIsTimedAuction(prebidInformation);
            } else {
                stockIsBuyNowSold(prebidInformation);
            }
        }
        updateCostCalculatorActionArea();
    }

    private final void updateCostCalculatorActionArea() {
        if (this.isLoggedIn) {
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            boolean z = true;
            if (!Intrinsics.areEqual((Object) sessionManager2.getCurrentSessionBuyerId(), (Object) "0")) {
                View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.costSeparator);
                Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "costSeparator");
                _$_findCachedViewById.setVisibility(0);
                if (this.estimatedBid.length() == 0) {
                    if (this.estimatedFinalCost.length() != 0) {
                        z = false;
                    }
                    if (z) {
                        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llCostCalculator);
                        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llCostCalculator");
                        linearLayout.setVisibility(0);
                        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llEstimatedCostValue);
                        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llEstimatedCostValue");
                        linearLayout2.setVisibility(8);
                    }
                }
            }
        }
    }

    private final void handleBuyNowOfferDisplaySection(PrebidInformation prebidInformation) {
        int intValue = (prebidInformation != null ? Integer.valueOf(prebidInformation.getTimedAuctionBuyNowOfferstatus()) : null).intValue();
        if (intValue != 0) {
            if (intValue == 1) {
                ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.con_bno_main_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "con_bno_main_layout");
                constraintLayout.setVisibility(0);
                RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.cd_bno_offer);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "cd_bno_offer");
                relativeLayout.setVisibility(0);
                TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_livesale);
                Intrinsics.checkExpressionValueIsNotNull(textView, "tv_bno_livesale");
                textView.setText(prebidInformation.getTimedAuctionDay() + ' ' + prebidInformation.getTimedAuctionMonth() + ' ' + prebidInformation.getTimedAuctionDate() + ", " + prebidInformation.getTimedAuctionDateString() + ' ' + prebidInformation.getUserTimezoneAbb());
                TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_offer_amount);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_bno_offer_amount");
                textView2.setText(UiUtils.formatCurrencyFromString(String.valueOf(this.buyNowOfferAmount), true) + " USD");
                String formatCurrencyFromString = UiUtils.formatCurrencyFromString(String.valueOf(this.buyNowOfferAmount), false);
                Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btn_bno_buy_now);
                Intrinsics.checkExpressionValueIsNotNull(button, "btn_bno_buy_now");
                button.setText(getString(C2723R.string.lbl_bno_button_text, formatCurrencyFromString));
                ((Button) _$_findCachedViewById(C2723R.C2726id.btn_bno_buy_now)).setOnClickListener(new ProductDetailFragment$handleBuyNowOfferDisplaySection$1(this));
                ((TextView) _$_findCachedViewById(C2723R.C2726id.btn_bno_decline)).setOnClickListener(new ProductDetailFragment$handleBuyNowOfferDisplaySection$2(this));
                TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_currentbid);
                Intrinsics.checkExpressionValueIsNotNull(textView3, "tv_bno_currentbid");
                textView3.setText(UiUtils.formatCurrencyFromString(this.preBidCurrentBid, true) + " USD");
                TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_maxbid);
                Intrinsics.checkExpressionValueIsNotNull(textView4, "tv_bno_maxbid");
                textView4.setText(this.formattedMyMax + ".00 USD");
                TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_message);
                Intrinsics.checkExpressionValueIsNotNull(textView5, "tv_bno_message");
                textView5.setText(getString(C2723R.string.lbl_bdt_buy_now_offer_msg_please_confirm, prebidInformation.getTimedAuctionDay() + ' ' + prebidInformation.getTimedAuctionMonth() + ' ' + prebidInformation.getTimedAuctionDate() + ", 11:00pm " + prebidInformation.getUserTimezoneAbb()));
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llTimedAuctionSection);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llTimedAuctionSection");
                linearLayout.setVisibility(8);
                disableWatchButton();
            } else if (intValue == 2) {
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llTimedAuctionSection);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llTimedAuctionSection");
                linearLayout2.setVisibility(8);
                ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.con_bno_main_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "con_bno_main_layout");
                constraintLayout2.setVisibility(0);
                RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.cd_bno_won);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "cd_bno_won");
                relativeLayout2.setVisibility(0);
                TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_won_offer_amont);
                Intrinsics.checkExpressionValueIsNotNull(textView6, "tv_bno_won_offer_amont");
                textView6.setText(UiUtils.formatCurrencyFromString(String.valueOf(this.buyNowOfferAmount), false) + " USD");
                disableWatchButton();
            } else if (intValue == 3) {
                LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llTimedAuctionSection);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llTimedAuctionSection");
                linearLayout3.setVisibility(8);
                ConstraintLayout constraintLayout3 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.con_bno_main_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "con_bno_main_layout");
                constraintLayout3.setVisibility(0);
                RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.cd_bno_nosale);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "cd_bno_nosale");
                relativeLayout3.setVisibility(0);
                TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_nosale_currentbid);
                Intrinsics.checkExpressionValueIsNotNull(textView7, "tv_bno_nosale_currentbid");
                textView7.setText(UiUtils.formatCurrencyFromString(this.preBidCurrentBid, false) + " USD");
                TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_nosale_maxbid);
                Intrinsics.checkExpressionValueIsNotNull(textView8, "tv_bno_nosale_maxbid");
                textView8.setText(this.formattedMyMax + " USD");
                disableWatchButton();
            } else if (intValue == 4) {
                LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llTimedAuctionSection);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llTimedAuctionSection");
                linearLayout4.setVisibility(8);
                ConstraintLayout constraintLayout4 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.con_bno_main_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout4, "con_bno_main_layout");
                constraintLayout4.setVisibility(0);
                RelativeLayout relativeLayout4 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.cd_bno_nosale);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout4, "cd_bno_nosale");
                relativeLayout4.setVisibility(0);
                TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_nosale_currentbid);
                Intrinsics.checkExpressionValueIsNotNull(textView9, "tv_bno_nosale_currentbid");
                textView9.setText(UiUtils.formatCurrencyFromString(this.preBidCurrentBid, false) + " USD");
                TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_nosale_maxbid);
                Intrinsics.checkExpressionValueIsNotNull(textView10, "tv_bno_nosale_maxbid");
                textView10.setText(this.formattedMyMax + " USD");
                disableWatchButton();
            }
        } else if (Intrinsics.areEqual((Object) prebidInformation.getTimedAuctionClosingStatus(), (Object) "WON")) {
            ConstraintLayout constraintLayout5 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.con_bno_main_layout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout5, "con_bno_main_layout");
            constraintLayout5.setVisibility(0);
            RelativeLayout relativeLayout5 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.cd_bno_sold);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout5, "cd_bno_sold");
            relativeLayout5.setVisibility(0);
            TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_sold_won);
            Intrinsics.checkExpressionValueIsNotNull(textView11, "tv_bno_sold_won");
            textView11.setVisibility(0);
            TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_sold_date);
            Intrinsics.checkExpressionValueIsNotNull(textView12, "tv_bno_sold_date");
            textView12.setText(getString(C2723R.string.bdt_bno_sold_message, prebidInformation.getTimedAuctionSoldTime(), "You"));
            disableWatchButton();
        } else if (Intrinsics.areEqual((Object) prebidInformation.getTimedAuctionClosingStatus(), (Object) "LOST")) {
            ConstraintLayout constraintLayout6 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.con_bno_main_layout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout6, "con_bno_main_layout");
            constraintLayout6.setVisibility(0);
            RelativeLayout relativeLayout6 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.cd_bno_sold);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout6, "cd_bno_sold");
            relativeLayout6.setVisibility(0);
            TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_sold_won);
            Intrinsics.checkExpressionValueIsNotNull(textView13, "tv_bno_sold_won");
            textView13.setVisibility(8);
            TextView textView14 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_sold_date);
            Intrinsics.checkExpressionValueIsNotNull(textView14, "tv_bno_sold_date");
            textView14.setText(getString(C2723R.string.bdt_bno_sold_message, prebidInformation.getTimedAuctionSoldTime(), "Not You"));
            disableWatchButton();
        } else if (Intrinsics.areEqual((Object) prebidInformation.getTimedAuctionClosingStatus(), (Object) "NOSALE")) {
            ConstraintLayout constraintLayout7 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.con_bno_main_layout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout7, "con_bno_main_layout");
            constraintLayout7.setVisibility(8);
            LinearLayout linearLayout5 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llTimedAuctionSection);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout5, "llTimedAuctionSection");
            linearLayout5.setVisibility(8);
            ConstraintLayout constraintLayout8 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.con_bno_main_layout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout8, "con_bno_main_layout");
            constraintLayout8.setVisibility(0);
            RelativeLayout relativeLayout7 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.cd_bno_nosale);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout7, "cd_bno_nosale");
            relativeLayout7.setVisibility(0);
            TextView textView15 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_nosale_currentbid);
            Intrinsics.checkExpressionValueIsNotNull(textView15, "tv_bno_nosale_currentbid");
            textView15.setText(UiUtils.formatCurrencyFromString(this.preBidCurrentBid, false) + " USD");
            TextView textView16 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_bno_nosale_maxbid);
            Intrinsics.checkExpressionValueIsNotNull(textView16, "tv_bno_nosale_maxbid");
            textView16.setText(this.formattedMyMax + " USD");
            disableWatchButton();
        } else {
            ConstraintLayout constraintLayout9 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.con_bno_main_layout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout9, "con_bno_main_layout");
            constraintLayout9.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void showAcceptBuyNowOfferDailog() {
        C2754x2ce754bf productDetailFragment$showAcceptBuyNowOfferDailog$onAlertButtonClick$1 = new C2754x2ce754bf(this);
        String formatCurrencyFromString = UiUtils.formatCurrencyFromString(String.valueOf(this.buyNowOfferAmount), true);
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 != null) {
            String string = getString(C2723R.string.bno_accept_message, formatCurrencyFromString);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.bno_a…yNowOfferFormattedAmount)");
            Dialog showAlertWithButton = Activity_ExtensionKt.showAlertWithButton(baseActivity2, C2723R.string.bno_accept_button_text, 17039360, string, productDetailFragment$showAcceptBuyNowOfferDailog$onAlertButtonClick$1);
            if (showAlertWithButton != null) {
                showAlertWithButton.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showDeclineBuyNowOfferDailog() {
        C2755xae7f7fab productDetailFragment$showDeclineBuyNowOfferDailog$onAlertButtonClick$1 = new C2755xae7f7fab(this);
        String formatCurrencyFromString = UiUtils.formatCurrencyFromString(String.valueOf(this.buyNowOfferAmount), true);
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 != null) {
            String string = getString(C2723R.string.bno_decline_message, formatCurrencyFromString);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.bno_d…yNowOfferFormattedAmount)");
            Dialog showAlertWithButton = Activity_ExtensionKt.showAlertWithButton(baseActivity2, C2723R.string.bno_decline_button_text, 17039360, string, productDetailFragment$showDeclineBuyNowOfferDailog$onAlertButtonClick$1);
            if (showAlertWithButton != null) {
                showAlertWithButton.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void acceptBuyNowOfferServiceCall() {
        Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.BUY_NOW_OFFER_ACCEPT.getId());
        IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.BUY_NOW_OFFER_ACCEPT, (Bundle) null);
        ProductDetailViewModel productDetailViewModel = this.viewModel;
        if (productDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        productDetailViewModel.acceptBuyNowOffer(this.userId, this.itemId, this.auctionId, this.branchCode, this.stockNumber);
    }

    /* access modifiers changed from: private */
    public final void declineBuyNowOfferServiceCall() {
        Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.BUY_NOW_OFFER_DECLINE.getId());
        IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.BUY_NOW_OFFER_DECLINE, (Bundle) null);
        ProductDetailViewModel productDetailViewModel = this.viewModel;
        if (productDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        productDetailViewModel.declineBuyNowOffer(this.userId, this.itemId, this.auctionId, this.branchCode, this.stockNumber);
    }

    private final void disableWatchButton() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llUnWatchLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llUnWatchLayout");
        linearLayout.setAlpha(0.25f);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llUnWatchLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llUnWatchLayout");
        linearLayout2.setClickable(false);
        LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llWatchLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llWatchLayout");
        linearLayout3.setAlpha(0.25f);
        LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llWatchLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llWatchLayout");
        linearLayout4.setClickable(false);
    }

    /* access modifiers changed from: private */
    public final boolean isAuctionCompleted(PrebidInformation prebidInformation) {
        boolean z;
        Integer num = null;
        Integer auctionStatus = prebidInformation != null ? prebidInformation.getAuctionStatus() : null;
        if (auctionStatus == null || auctionStatus.intValue() != 4) {
            if (prebidInformation != null) {
                num = prebidInformation.getAuctionStatus();
            }
            if (num == null || num.intValue() != 0) {
                z = false;
                this.isAuctionComplete = z;
                return this.isAuctionComplete;
            }
        }
        z = true;
        this.isAuctionComplete = z;
        return this.isAuctionComplete;
    }

    /* access modifiers changed from: private */
    public final void navigateToPreBidPage() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        if (!sessionManager2.promptForLoginIfNeedFromFragment(getActivity(), this, 27)) {
            navigateToPreBidPageIfAlreadyLogin();
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToBuyNowPage() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        if (!sessionManager2.promptForLoginIfNeedFromFragment(getActivity(), this, 28)) {
            navigateToBuyNowPageIfAlreadyLogin();
        }
    }

    private final void navigateToPreBidPageIfAlreadyLogin() {
        updateActionBarForBidAndBuyNow(false, true, getBundleForActionArea(false, true));
    }

    private final void navigateToBuyNowPageIfAlreadyLogin() {
        updateActionBarForBidAndBuyNow(true, false, getBundleForActionArea(true, false));
    }

    private final boolean checkForInValidUser() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        if (!Intrinsics.areEqual((Object) sessionManager2.getCurrentSessionBuyerId(), (Object) "0")) {
            SessionManager sessionManager3 = this.sessionManager;
            if (sessionManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            if (!Intrinsics.areEqual((Object) sessionManager3.getCurrentSessionStatusCode(), (Object) "INA")) {
                CharSequence charSequence = this.preBidErrorMsg;
                return !(charSequence == null || charSequence.length() == 0);
            }
        }
    }

    private final Bundle getBundleForActionArea(boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putString(Constants_MVVM.EXTRA_ITEM_ID, this.itemId);
            bundle.putString("userID", this.userId);
            bundle.putString(Constants_MVVM.EXTRA_STOCK_NUMBER, this.stockNumber);
            bundle.putString("branchName", this.branchName);
            bundle.putString(Constants_MVVM.EXTRA_AUCTION_DATE, this.auctionDate);
            bundle.putString(Constants_MVVM.EXTRA_YEAR_MAKE_MODEL, this.yearModel);
            bundle.putString(Constants_MVVM.EXTRA_VEHICLE_LOCATION, this.vehicleLoc);
            bundle.putString(Constants_MVVM.EXTRA_BUY_PRICE, this.buyNowPrice);
            bundle.putString(Constants_MVVM.EXTRA_TIME_LEFT_TO_BUY, this.timeLeftToBuy);
            bundle.putString(Constants_MVVM.EXTRA_AUCTION_ID, this.auctionId);
            bundle.putString(Constants_MVVM.EXTRA_BUY_NOW_PAYMENT_DUE_BY, this.ibfPaymentDueDate);
            bundle.putString(Constants_MVVM.EXTRA_BUY_NOW_PICK_UP_BY, this.ibfPickUpDate);
            bundle.putString(Constants_MVVM.EXTRA_BUY_NOW_AWARD_MESSAGE, this.ibfAwardMessage);
            bundle.putBoolean(Constants_MVVM.EXTRA_BUY_NOW_IS_UPSTREAM_BRANCH, this.IsUpstreamBranchStock);
        } else if (z2) {
            String str = this.preBidIncrement;
            String str2 = Constants_MVVM.EXTRA_BUY_NOW_AWARD_MESSAGE;
            bundle.putString(Constants_MVVM.EXTRA_PRE_BID_INCREMENT, str);
            bundle.putString(Constants_MVVM.EXTRA_PRE_BID_FORMATTED_MYMAX, this.formattedMyMax);
            bundle.putString(Constants_MVVM.EXTRA_PRE_BID_MYMAX, this.myMax);
            bundle.putString(Constants_MVVM.EXTRA_PRE_BID_CURRENT_BID, this.preBidCurrentBid);
            bundle.putBoolean(Constants_MVVM.EXTRA_PRE_BID_DISPLAY_SALES_TAX, this.displaySaleTaxWarning);
            bundle.putString(Constants_MVVM.EXTRA_PRE_BID_DISPLAY_SALES_TAX_MASG, this.displaySaleTextMessage);
            bundle.putString(Constants_MVVM.EXTRA_PRE_BID_TIME_REMAINING, this.preBidTimeRemaining);
            bundle.putBoolean(Constants_MVVM.EXTRA_IS_TIMED_AUCTION, this.isTimedAuction);
            bundle.putString(Constants_MVVM.EXTRA_ITEM_ID, this.itemId);
            bundle.putString("userID", this.userId);
            bundle.putString(Constants_MVVM.EXTRA_STOCK_NUMBER, this.stockNumber);
            bundle.putString("branchName", this.branchName);
            bundle.putString(Constants_MVVM.EXTRA_AUCTION_DATE, this.auctionDate);
            bundle.putString(Constants_MVVM.EXTRA_YEAR_MAKE_MODEL, this.yearModel);
            bundle.putString(Constants_MVVM.EXTRA_VEHICLE_LOCATION, this.vehicleLoc);
            bundle.putString(Constants_MVVM.EXTRA_BUY_PRICE, this.buyNowPrice);
            bundle.putString(Constants_MVVM.EXTRA_TIME_LEFT_TO_BUY, this.timeLeftToBuy);
            bundle.putString(Constants_MVVM.EXTRA_AUCTION_ID, this.auctionId);
            bundle.putString(Constants_MVVM.EXTRA_BUY_NOW_PAYMENT_DUE_BY, this.paymentDueDate);
            bundle.putString(Constants_MVVM.EXTRA_BUY_NOW_PICK_UP_BY, this.pickUpDate);
            bundle.putString(str2, this.awardMessage);
            Integer num = this.startingBid;
            bundle.putInt(Constants_MVVM.EXTRA_PRE_BID_STARTING_BID, num != null ? num.intValue() : 0);
        } else {
            Integer num2 = this.salvageId;
            if (num2 == null) {
                Intrinsics.throwNpe();
            }
            bundle.putInt(Constants_MVVM.EXTRA_SALVAGE_ID, num2.intValue());
            bundle.putString(Constants_MVVM.EXTRA_STOCK_NUMBER, this.stockNumber);
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            bundle.putString(Constants_MVVM.EXTRA_BUYER_ID, sessionManager2.getCurrentSessionBuyerId());
            SessionManager sessionManager3 = this.sessionManager;
            if (sessionManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            bundle.putString(Constants_MVVM.EXTRA_EMPLOYEE_ID, sessionManager3.getBuyerEmployeeId());
            bundle.putString("userID", this.userId);
            bundle.putString(Constants_MVVM.EXTRA_VIN, this.vin);
            bundle.putString(Constants_MVVM.EXTRA_BRANCH_CODE, this.branchCode);
            bundle.putString("zipCode", this.zip);
            bundle.putString(Constants_MVVM.EXTRA_ITEM_ID, this.itemId);
            bundle.putString("userID", this.userId);
            bundle.putBoolean(Constants_MVVM.EXTRA_IS_TRANSPORTATION_QUOTES, this.isTransportationQuotesAvailable);
        }
        return bundle;
    }

    private final void disableActionAreaButtons() {
        Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnBuyNow);
        Intrinsics.checkExpressionValueIsNotNull(button, "btnBuyNow");
        button.setClickable(false);
        Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnBuyNow);
        Intrinsics.checkExpressionValueIsNotNull(button2, "btnBuyNow");
        button2.setAlpha(0.5f);
        Button button3 = (Button) _$_findCachedViewById(C2723R.C2726id.btnTimedBid);
        Intrinsics.checkExpressionValueIsNotNull(button3, "btnTimedBid");
        button3.setClickable(false);
        Button button4 = (Button) _$_findCachedViewById(C2723R.C2726id.btnTimedBid);
        Intrinsics.checkExpressionValueIsNotNull(button4, "btnTimedBid");
        button4.setAlpha(0.5f);
        Button button5 = (Button) _$_findCachedViewById(C2723R.C2726id.btnPreBid);
        Intrinsics.checkExpressionValueIsNotNull(button5, "btnPreBid");
        button5.setClickable(false);
        Button button6 = (Button) _$_findCachedViewById(C2723R.C2726id.btnPreBid);
        Intrinsics.checkExpressionValueIsNotNull(button6, "btnPreBid");
        button6.setAlpha(0.5f);
    }

    private final void enableActionAreaButtons() {
        Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnBuyNow);
        Intrinsics.checkExpressionValueIsNotNull(button, "btnBuyNow");
        button.setClickable(true);
        Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnBuyNow);
        Intrinsics.checkExpressionValueIsNotNull(button2, "btnBuyNow");
        button2.setAlpha(1.0f);
        Button button3 = (Button) _$_findCachedViewById(C2723R.C2726id.btnTimedBid);
        Intrinsics.checkExpressionValueIsNotNull(button3, "btnTimedBid");
        button3.setClickable(true);
        Button button4 = (Button) _$_findCachedViewById(C2723R.C2726id.btnTimedBid);
        Intrinsics.checkExpressionValueIsNotNull(button4, "btnTimedBid");
        button4.setAlpha(1.0f);
        Button button5 = (Button) _$_findCachedViewById(C2723R.C2726id.btnPreBid);
        Intrinsics.checkExpressionValueIsNotNull(button5, "btnPreBid");
        button5.setClickable(true);
        Button button6 = (Button) _$_findCachedViewById(C2723R.C2726id.btnPreBid);
        Intrinsics.checkExpressionValueIsNotNull(button6, "btnPreBid");
        button6.setAlpha(1.0f);
    }

    private final void stockIsBuyNowSold(PrebidInformation prebidInformation) {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llBuyNowSection);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llBuyNowSection");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPreBidSection);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llPreBidSection");
        linearLayout2.setVisibility(8);
        disableWatchButton();
        LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llBuyNowSold);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llBuyNowSold");
        linearLayout3.setVisibility(0);
        View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.auctionNotAssignSeparator);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "auctionNotAssignSeparator");
        _$_findCachedViewById.setVisibility(0);
        View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.preBidSeparator);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "preBidSeparator");
        _$_findCachedViewById2.setVisibility(8);
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBuyNowSold);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvBuyNowSold");
        textView.setText(getResources().getString(C2723R.string.lbl_bdt_buy_now_sold));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBuyNowSoldMessage);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvBuyNowSoldMessage");
        textView2.setText(prebidInformation != null ? prebidInformation.getIBFSoldMessage() : null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x034a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.getCurrentSessionStatusCode(), (java.lang.Object) "INA") != false) goto L_0x034c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void stockIsTimedAuction(com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r15) {
        /*
            r14 = this;
            r0 = 1
            r14.isTimedAuction = r0
            r1 = 0
            com.iaai.android.old.utils.DateHelper$TimeDiff r1 = (com.iaai.android.old.utils.DateHelper.TimeDiff) r1
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            java.lang.String r3 = r15.getTimedAuctionCloseTimeCST()
            java.util.Date r3 = com.iaai.android.old.utils.DateHelper.parseDateInServerTimezone(r3)
            int r4 = r2.compareTo(r3)
            java.lang.String r5 = "llPreBidSection"
            java.lang.String r6 = "llTimedAuctionSection"
            r7 = -1
            r8 = 8
            r9 = 0
            if (r4 != r7) goto L_0x0028
            com.iaai.android.old.utils.DateHelper$TimeDiff r1 = com.iaai.android.old.utils.DateHelper.calculateDateTimeDiff(r2, r3)
            r2 = r1
            r1 = 0
            goto L_0x0046
        L_0x0028:
            int r2 = com.iaai.android.C2723R.C2726id.llTimedAuctionSection
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r6)
            r2.setVisibility(r8)
            int r2 = com.iaai.android.C2723R.C2726id.llPreBidSection
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            r2.setVisibility(r8)
            r2 = r1
            r1 = 1
        L_0x0046:
            if (r1 == 0) goto L_0x0050
            if (r1 == 0) goto L_0x03c6
            boolean r3 = r15.getReserveMet()
            if (r3 != 0) goto L_0x03c6
        L_0x0050:
            int r3 = com.iaai.android.C2723R.C2726id.llTimedAuctionSection
            android.view.View r3 = r14._$_findCachedViewById(r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
            r3.setVisibility(r9)
            int r3 = com.iaai.android.C2723R.C2726id.llPreBidSection
            android.view.View r3 = r14._$_findCachedViewById(r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r5)
            r3.setVisibility(r8)
            int r3 = com.iaai.android.C2723R.C2726id.btnTimedBid
            android.view.View r3 = r14._$_findCachedViewById(r3)
            android.widget.Button r3 = (android.widget.Button) r3
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$stockIsTimedAuction$1 r5 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$stockIsTimedAuction$1
            r5.<init>(r14)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r3.setOnClickListener(r5)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r15.getTimedAuctionDay()
            r3.append(r5)
            java.lang.String r5 = " "
            r3.append(r5)
            java.lang.Object r6 = r15.getTimedAuctionMonth()
            r3.append(r6)
            r3.append(r5)
            java.lang.Object r6 = r15.getTimedAuctionDate()
            r3.append(r6)
            java.lang.String r6 = ", "
            r3.append(r6)
            java.lang.Object r6 = r15.getTimedAuctionDateString()
            r3.append(r6)
            r3.append(r5)
            java.lang.String r5 = r15.getUserTimezoneAbb()
            r3.append(r5)
            r3.toString()
            r3 = 1056964608(0x3f000000, float:0.5)
            java.lang.String r5 = "tvLiveSaleValue"
            java.lang.String r6 = "btnTimedBid"
            if (r2 != 0) goto L_0x00f9
            int r2 = com.iaai.android.C2723R.C2726id.tvLiveSaleValue
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            android.content.res.Resources r5 = r14.getResources()
            r10 = 2131821262(0x7f1102ce, float:1.9275262E38)
            java.lang.String r5 = r5.getString(r10)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
            int r2 = com.iaai.android.C2723R.C2726id.btnTimedBid
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.Button r2 = (android.widget.Button) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r6)
            r2.setClickable(r9)
            int r2 = com.iaai.android.C2723R.C2726id.btnTimedBid
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.Button r2 = (android.widget.Button) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r6)
            r2.setAlpha(r3)
            goto L_0x0118
        L_0x00f9:
            int r10 = com.iaai.android.C2723R.C2726id.tvLiveSaleValue
            android.view.View r10 = r14._$_findCachedViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r5)
            java.lang.String r5 = r2.getPreBidTimeString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r10.setText(r5)
            java.lang.String r2 = r2.getPreBidTimeString()
            java.lang.String r5 = "timeDiff.preBidTimeString"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r5)
            r14.preBidTimeRemaining = r2
        L_0x0118:
            java.lang.String r2 = r15.getMyMax()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0129
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0127
            goto L_0x0129
        L_0x0127:
            r2 = 0
            goto L_0x012a
        L_0x0129:
            r2 = 1
        L_0x012a:
            if (r2 != 0) goto L_0x0131
            if (r1 != 0) goto L_0x0131
            r14.disableWatchButton()
        L_0x0131:
            java.lang.String r2 = r15.getHighBidAmount()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0142
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0140
            goto L_0x0142
        L_0x0140:
            r2 = 0
            goto L_0x0143
        L_0x0142:
            r2 = 1
        L_0x0143:
            java.lang.String r5 = " USD"
            if (r2 != 0) goto L_0x02a6
            int r2 = com.iaai.android.C2723R.C2726id.tvTimedCurrentBidValue
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r10 = "tvTimedCurrentBidValue"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r10)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r15.getHighBidAmount()
            r11.append(r12)
            r11.append(r5)
            java.lang.String r11 = r11.toString()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r2.setText(r11)
            int r2 = r15.getTimedAuctionBuyNowOfferstatus()
            r11 = 2
            if (r2 != r11) goto L_0x0178
            r14.handleBuyNowOfferDisplaySection(r15)
            goto L_0x02a6
        L_0x0178:
            if (r1 == 0) goto L_0x018e
            java.lang.String r2 = r15.getTimedAuctionClosingStatus()
            java.lang.String r11 = "NOSALE"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r11)
            if (r2 == 0) goto L_0x01b1
            if (r4 != r7) goto L_0x01b1
            boolean r2 = r15.getReserveMet()
            if (r2 != 0) goto L_0x01b1
        L_0x018e:
            int r2 = com.iaai.android.C2723R.C2726id.tvTimedCurrentBidValue
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r10)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r15.getHighBidAmount()
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
        L_0x01b1:
            if (r1 != 0) goto L_0x02a6
            java.lang.String r2 = r15.getHighBidder()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x01c4
            int r2 = r2.length()
            if (r2 != 0) goto L_0x01c2
            goto L_0x01c4
        L_0x01c2:
            r2 = 0
            goto L_0x01c5
        L_0x01c4:
            r2 = 1
        L_0x01c5:
            java.lang.String r4 = "tvTimedBiddingStatus"
            if (r2 != 0) goto L_0x0208
            int r2 = com.iaai.android.C2723R.C2726id.tvTimedBiddingStatus
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            r2.setVisibility(r9)
            int r2 = com.iaai.android.C2723R.C2726id.tvTimedBiddingStatus
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            java.lang.String r7 = r15.getHighBidder()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.setText(r7)
            int r2 = com.iaai.android.C2723R.C2726id.tvTimedBiddingStatus
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            android.content.res.Resources r7 = r14.getResources()
            r10 = 2131231046(0x7f080146, float:1.8078162E38)
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r10)
            r2.setBackground(r7)
        L_0x0208:
            java.lang.String r2 = r15.getLosingBidStatus()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0219
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0217
            goto L_0x0219
        L_0x0217:
            r2 = 0
            goto L_0x021a
        L_0x0219:
            r2 = 1
        L_0x021a:
            if (r2 != 0) goto L_0x025b
            int r2 = com.iaai.android.C2723R.C2726id.tvTimedBiddingStatus
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            r2.setVisibility(r9)
            int r2 = com.iaai.android.C2723R.C2726id.tvTimedBiddingStatus
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            java.lang.String r7 = r15.getLosingBidStatus()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.setText(r7)
            int r2 = com.iaai.android.C2723R.C2726id.tvTimedBiddingStatus
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            android.content.res.Resources r4 = r14.getResources()
            r7 = 2131231579(0x7f08035b, float:1.8079243E38)
            android.graphics.drawable.Drawable r4 = r4.getDrawable(r7)
            r2.setBackground(r4)
        L_0x025b:
            java.lang.String r2 = r15.getDecimalHighBidAmount()
            float r2 = java.lang.Float.parseFloat(r2)
            int r4 = r15.getStartBid()
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x02a6
            int r2 = com.iaai.android.C2723R.C2726id.llTimedAuctionStartBid
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            java.lang.String r4 = "llTimedAuctionStartBid"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            r2.setVisibility(r9)
            int r2 = com.iaai.android.C2723R.C2726id.tvTimedStartingBidValue
            android.view.View r2 = r14._$_findCachedViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.String r4 = "tvTimedStartingBidValue"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r7 = 36
            r4.append(r7)
            int r7 = r15.getStartBid()
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r2.setText(r4)
        L_0x02a6:
            if (r1 != 0) goto L_0x0368
            boolean r1 = r15.getReserveMet()
            r10 = 0
            java.lang.String r2 = "tvReserveMetStatus"
            if (r1 == 0) goto L_0x02e8
            java.lang.String r1 = r15.getMyCurrent()
            float r1 = java.lang.Float.parseFloat(r1)
            double r12 = (double) r1
            int r1 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r1 <= 0) goto L_0x02e8
            int r1 = com.iaai.android.C2723R.C2726id.tvReserveMetStatus
            android.view.View r1 = r14._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            android.content.res.Resources r4 = r14.getResources()
            r7 = 2131821240(0x7f1102b8, float:1.9275218E38)
            java.lang.String r4 = r4.getString(r7)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            int r1 = com.iaai.android.C2723R.C2726id.tvReserveMetStatus
            android.view.View r1 = r14._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r1.setVisibility(r9)
        L_0x02e8:
            boolean r1 = r15.getReserveMet()
            if (r1 != 0) goto L_0x0331
            java.lang.String r1 = r15.getDecimalHighBidAmount()
            float r1 = java.lang.Float.parseFloat(r1)
            double r12 = (double) r1
            int r1 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r1 <= 0) goto L_0x0331
            java.lang.String r1 = r15.getMyCurrent()
            float r1 = java.lang.Float.parseFloat(r1)
            double r12 = (double) r1
            int r1 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r1 <= 0) goto L_0x0331
            int r1 = com.iaai.android.C2723R.C2726id.tvReserveMetStatus
            android.view.View r1 = r14._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            android.content.res.Resources r4 = r14.getResources()
            r7 = 2131821241(0x7f1102b9, float:1.927522E38)
            java.lang.String r4 = r4.getString(r7)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            int r1 = com.iaai.android.C2723R.C2726id.tvReserveMetStatus
            android.view.View r1 = r14._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r1.setVisibility(r9)
        L_0x0331:
            boolean r1 = r15.getIsGuest()
            if (r1 != 0) goto L_0x034c
            com.iaai.android.bdt.feature.login.SessionManager r1 = r14.sessionManager
            if (r1 != 0) goto L_0x0340
            java.lang.String r2 = "sessionManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0340:
            java.lang.String r1 = r1.getCurrentSessionStatusCode()
            java.lang.String r2 = "INA"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0368
        L_0x034c:
            int r1 = com.iaai.android.C2723R.C2726id.btnTimedBid
            android.view.View r1 = r14._$_findCachedViewById(r1)
            android.widget.Button r1 = (android.widget.Button) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r6)
            r1.setClickable(r9)
            int r1 = com.iaai.android.C2723R.C2726id.btnTimedBid
            android.view.View r1 = r14._$_findCachedViewById(r1)
            android.widget.Button r1 = (android.widget.Button) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r6)
            r1.setAlpha(r3)
        L_0x0368:
            java.lang.String r1 = r15.getMyMax()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0378
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0377
            goto L_0x0378
        L_0x0377:
            r0 = 0
        L_0x0378:
            if (r0 != 0) goto L_0x03c6
            int r0 = r15.getTimedAuctionBuyNowOfferstatus()
            r1 = 2
            if (r0 == r1) goto L_0x03c6
            int r0 = com.iaai.android.C2723R.C2726id.llTimedMaxBid
            android.view.View r0 = r14._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r1 = "llTimedMaxBid"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.setVisibility(r9)
            int r0 = com.iaai.android.C2723R.C2726id.tvTimedMaxBidValue
            android.view.View r0 = r14._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tvTimedMaxBidValue"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r15.getFormattedMyMax()
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = com.iaai.android.C2723R.C2726id.llTimedAuctionStartBid
            android.view.View r0 = r14._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r1 = "llTimedAuctionStartBid"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.setVisibility(r8)
        L_0x03c6:
            r14.handleBuyNowOfferDisplaySection(r15)
            boolean r0 = r14.checkForInValidUser()
            if (r0 != 0) goto L_0x03e0
            if (r15 != 0) goto L_0x03d4
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x03d4:
            boolean r0 = r15.getIsPublic()
            if (r0 == 0) goto L_0x03e3
            java.lang.String r15 = r15.getPrebidPopupErrorMessage()
            if (r15 == 0) goto L_0x03e3
        L_0x03e0:
            r14.disableActionAreaButtons()
        L_0x03e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.productDetail.ProductDetailFragment.stockIsTimedAuction(com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:144:0x03ea, code lost:
        if (r13.getPrebidPopupErrorMessage() != null) goto L_0x03ec;
     */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void stockIsPreBid(com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r13) {
        /*
            r12 = this;
            boolean r0 = r13.getIsPrebiddingDone()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002f
            boolean r0 = r12.isLoggedIn
            if (r0 == 0) goto L_0x002f
            r12.updateWatchUI(r1)
            int r0 = com.iaai.android.C2723R.C2726id.llUnWatchLayout
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r3 = "llUnWatchLayout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r4 = 1048576000(0x3e800000, float:0.25)
            r0.setAlpha(r4)
            int r0 = com.iaai.android.C2723R.C2726id.llUnWatchLayout
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r0.setClickable(r2)
        L_0x002f:
            boolean r0 = r13.getPrebidAllowed()
            r3 = 1056964608(0x3f000000, float:0.5)
            r4 = 4
            java.lang.String r5 = "btnPreBid"
            if (r0 == 0) goto L_0x0245
            boolean r0 = r13.getPrebidClosed()
            java.lang.String r6 = "tvBiddingStatus"
            if (r0 != 0) goto L_0x0147
            java.lang.String r0 = r13.getVehicleStatus()
            java.lang.String r7 = "RS"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)
            if (r0 == 0) goto L_0x0147
            java.lang.String r0 = r13.getHighBidAmount()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x005f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r0 = 0
            goto L_0x0060
        L_0x005f:
            r0 = 1
        L_0x0060:
            if (r0 != 0) goto L_0x0147
            int r0 = com.iaai.android.C2723R.C2726id.tvCurrentBidAmount
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r7 = "tvCurrentBidAmount"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r8 = 32
            r7.append(r8)
            java.lang.String r8 = r13.getHighBidAmount()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
            java.lang.String r0 = r13.getHighBidder()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x009a
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            r0 = 0
            goto L_0x009b
        L_0x009a:
            r0 = 1
        L_0x009b:
            java.lang.String r7 = "activity!!"
            r8 = 41
            r9 = 40
            if (r0 != 0) goto L_0x00eb
            int r0 = com.iaai.android.C2723R.C2726id.tvBiddingStatus
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            java.lang.String r11 = r13.getHighBidder()
            r10.append(r11)
            r10.append(r8)
            java.lang.String r10 = r10.toString()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r0.setText(r10)
            int r0 = com.iaai.android.C2723R.C2726id.tvBiddingStatus
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            androidx.fragment.app.FragmentActivity r10 = r12.getActivity()
            if (r10 != 0) goto L_0x00da
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00da:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r7)
            android.content.Context r10 = r10.getApplicationContext()
            r11 = 2131099855(0x7f0600cf, float:1.7812075E38)
            int r10 = androidx.core.content.ContextCompat.getColor(r10, r11)
            r0.setTextColor(r10)
        L_0x00eb:
            java.lang.String r0 = r13.getLosingBidStatus()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00fc
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00fa
            goto L_0x00fc
        L_0x00fa:
            r0 = 0
            goto L_0x00fd
        L_0x00fc:
            r0 = 1
        L_0x00fd:
            if (r0 != 0) goto L_0x0147
            int r0 = com.iaai.android.C2723R.C2726id.tvBiddingStatus
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            java.lang.String r9 = r13.getLosingBidStatus()
            r10.append(r9)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.setText(r8)
            int r0 = com.iaai.android.C2723R.C2726id.tvBiddingStatus
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            androidx.fragment.app.FragmentActivity r8 = r12.getActivity()
            if (r8 != 0) goto L_0x0136
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0136:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r7)
            android.content.Context r7 = r8.getApplicationContext()
            r8 = 2131099886(0x7f0600ee, float:1.7812138E38)
            int r7 = androidx.core.content.ContextCompat.getColor(r7, r8)
            r0.setTextColor(r7)
        L_0x0147:
            boolean r0 = r13.getPrebidClosed()
            if (r0 == 0) goto L_0x0245
            java.lang.Integer r0 = r13.getAuctionStatus()
            if (r0 != 0) goto L_0x0154
            goto L_0x015a
        L_0x0154:
            int r0 = r0.intValue()
            if (r0 == 0) goto L_0x0245
        L_0x015a:
            java.lang.Integer r0 = r13.getAuctionStatus()
            if (r0 != 0) goto L_0x0161
            goto L_0x0167
        L_0x0161:
            int r0 = r0.intValue()
            if (r0 == r4) goto L_0x0245
        L_0x0167:
            java.lang.String r0 = r13.getDecimalHighBidAmount()
            float r0 = java.lang.Float.parseFloat(r0)
            float r7 = (float) r2
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0217
            boolean r0 = r13.getBuyNowSold()
            if (r0 != 0) goto L_0x0217
            java.lang.String r0 = r13.getHighBidder()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x018b
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0189
            goto L_0x018b
        L_0x0189:
            r0 = 0
            goto L_0x018c
        L_0x018b:
            r0 = 1
        L_0x018c:
            if (r0 == 0) goto L_0x01be
            java.lang.String r0 = r13.getLosingBidStatus()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x019f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x019d
            goto L_0x019f
        L_0x019d:
            r0 = 0
            goto L_0x01a0
        L_0x019f:
            r0 = 1
        L_0x01a0:
            if (r0 == 0) goto L_0x01be
            int r0 = com.iaai.android.C2723R.C2726id.tvBiddingStatus
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            android.content.res.Resources r6 = r12.getResources()
            r7 = 2131821463(0x7f110397, float:1.927567E38)
            java.lang.String r6 = r6.getString(r7)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            goto L_0x0217
        L_0x01be:
            java.lang.String r0 = r13.getHighBidder()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x01cf
            int r0 = r0.length()
            if (r0 != 0) goto L_0x01cd
            goto L_0x01cf
        L_0x01cd:
            r0 = 0
            goto L_0x01d0
        L_0x01cf:
            r0 = 1
        L_0x01d0:
            if (r0 != 0) goto L_0x01eb
            int r0 = com.iaai.android.C2723R.C2726id.tvBiddingStatus
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            java.lang.String r6 = r13.getHighBidder()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            goto L_0x0217
        L_0x01eb:
            java.lang.String r0 = r13.getLosingBidStatus()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x01fc
            int r0 = r0.length()
            if (r0 != 0) goto L_0x01fa
            goto L_0x01fc
        L_0x01fa:
            r0 = 0
            goto L_0x01fd
        L_0x01fc:
            r0 = 1
        L_0x01fd:
            if (r0 != 0) goto L_0x0217
            int r0 = com.iaai.android.C2723R.C2726id.tvBiddingStatus
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            java.lang.String r6 = r13.getLosingBidStatus()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
        L_0x0217:
            boolean r0 = r13.getPrebidClosed()
            if (r0 != 0) goto L_0x0229
            java.lang.String r0 = r13.getVehicleStatus()
            java.lang.String r6 = "WC"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r0 == 0) goto L_0x0245
        L_0x0229:
            int r0 = com.iaai.android.C2723R.C2726id.btnPreBid
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            r0.setClickable(r2)
            int r0 = com.iaai.android.C2723R.C2726id.btnPreBid
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            r0.setAlpha(r3)
        L_0x0245:
            r0 = 0
            if (r13 == 0) goto L_0x024d
            java.lang.String r6 = r13.getMyMax()
            goto L_0x024e
        L_0x024d:
            r6 = r0
        L_0x024e:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x025b
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0259
            goto L_0x025b
        L_0x0259:
            r6 = 0
            goto L_0x025c
        L_0x025b:
            r6 = 1
        L_0x025c:
            java.lang.String r7 = " USD"
            if (r6 != 0) goto L_0x0297
            int r6 = com.iaai.android.C2723R.C2726id.llMaxBid
            android.view.View r6 = r12._$_findCachedViewById(r6)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            java.lang.String r8 = "llMaxBid"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r8)
            r6.setVisibility(r2)
            int r6 = com.iaai.android.C2723R.C2726id.tvMaxBidValue
            android.view.View r6 = r12._$_findCachedViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.String r8 = "tvMaxBidValue"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            if (r13 == 0) goto L_0x0288
            java.lang.String r0 = r13.getFormattedMyMax()
        L_0x0288:
            r8.append(r0)
            r8.append(r7)
            java.lang.String r0 = r8.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
        L_0x0297:
            boolean r0 = r13.getIbuyFastAllowed()
            java.lang.String r6 = "llBuyNowSection"
            if (r0 == 0) goto L_0x0317
            int r0 = com.iaai.android.C2723R.C2726id.llBuyNowSection
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            r0.setVisibility(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = r13.getBuyNowPrice()
            r0.append(r8)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r12.buyNowPrice = r0
            java.lang.String r0 = r13.getAuctionID()
            r12.auctionId = r0
            java.lang.String r0 = r13.getPrebidPickUpDate()
            r12.pickUpDate = r0
            java.lang.String r0 = r13.getPrebidPayDate()
            r12.paymentDueDate = r0
            java.lang.String r0 = r13.getPrebidAwardMesssage()
            r12.awardMessage = r0
            java.lang.String r0 = r13.getBuyNowCloseDate()
            r12.timeLeftToBuy = r0
            int r0 = com.iaai.android.C2723R.C2726id.btnBuyNow
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$stockIsPreBid$1 r8 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$stockIsPreBid$1
            r8.<init>(r12)
            android.view.View$OnClickListener r8 = (android.view.View.OnClickListener) r8
            r0.setOnClickListener(r8)
            int r0 = com.iaai.android.C2723R.C2726id.tvBuyPriceValue
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r8 = "tvBuyPriceValue"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r13.getBuyNowPrice()
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
        L_0x0317:
            java.lang.String r0 = r13.getAuctionStatusDescription()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0328
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0326
            goto L_0x0328
        L_0x0326:
            r0 = 0
            goto L_0x0329
        L_0x0328:
            r0 = 1
        L_0x0329:
            r7 = 8
            if (r0 != 0) goto L_0x03d5
            java.lang.Integer r0 = r13.getAuctionStatus()
            if (r0 == 0) goto L_0x03d5
            int r0 = com.iaai.android.C2723R.C2726id.llBuyNowSection
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            r0.setVisibility(r7)
            int r0 = com.iaai.android.C2723R.C2726id.llPreBidSection
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            java.lang.String r6 = "llPreBidSection"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            r0.setVisibility(r7)
            int r0 = com.iaai.android.C2723R.C2726id.layoutBidLive
            android.view.View r0 = r12._$_findCachedViewById(r0)
            java.lang.String r6 = "layoutBidLive"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            r0.setVisibility(r2)
            com.iaai.android.bdt.feature.productDetail.ProductDetailViewModel r0 = r12.viewModel
            if (r0 != 0) goto L_0x0368
            java.lang.String r6 = "viewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x0368:
            java.lang.String r6 = r13.getLiveDateinUserTimeZone()
            r0.getBidLiveStatus(r6)
            java.lang.Integer r0 = r13.getAuctionStatus()
            java.lang.String r6 = "btnBidLive"
            if (r0 != 0) goto L_0x0378
            goto L_0x037e
        L_0x0378:
            int r0 = r0.intValue()
            if (r0 == 0) goto L_0x03b9
        L_0x037e:
            java.lang.Integer r0 = r13.getAuctionStatus()
            if (r0 != 0) goto L_0x0385
            goto L_0x038c
        L_0x0385:
            int r0 = r0.intValue()
            if (r0 != r4) goto L_0x038c
            goto L_0x03b9
        L_0x038c:
            java.lang.Integer r0 = r13.getAuctionStatus()
            if (r0 != 0) goto L_0x0393
            goto L_0x03d5
        L_0x0393:
            int r0 = r0.intValue()
            r2 = 2
            if (r0 != r2) goto L_0x03d5
            int r0 = com.iaai.android.C2723R.C2726id.btnBidLive
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            r0.setClickable(r1)
            int r0 = com.iaai.android.C2723R.C2726id.btnBidLive
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            r2 = 1065353216(0x3f800000, float:1.0)
            r0.setAlpha(r2)
            goto L_0x03d5
        L_0x03b9:
            int r0 = com.iaai.android.C2723R.C2726id.btnBidLive
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            r0.setClickable(r2)
            int r0 = com.iaai.android.C2723R.C2726id.btnBidLive
            android.view.View r0 = r12._$_findCachedViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            r0.setAlpha(r3)
        L_0x03d5:
            boolean r0 = r12.checkForInValidUser()
            if (r0 != 0) goto L_0x03ec
            if (r13 != 0) goto L_0x03e0
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x03e0:
            boolean r0 = r13.getIsPublic()
            if (r0 == 0) goto L_0x03ef
            java.lang.String r0 = r13.getPrebidPopupErrorMessage()
            if (r0 == 0) goto L_0x03ef
        L_0x03ec:
            r12.disableActionAreaButtons()
        L_0x03ef:
            if (r13 != 0) goto L_0x03f4
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x03f4:
            java.lang.Boolean r13 = r13.getHidePreBidOnUpstreamBuyNow()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r0)
            if (r13 == 0) goto L_0x0410
            int r13 = com.iaai.android.C2723R.C2726id.btnPreBid
            android.view.View r13 = r12._$_findCachedViewById(r13)
            android.widget.Button r13 = (android.widget.Button) r13
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r5)
            r13.setVisibility(r7)
        L_0x0410:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.productDetail.ProductDetailFragment.stockIsPreBid(com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation):void");
    }

    private final void updateActionBarForBidAndBuyNow(boolean z, boolean z2, Bundle bundle) {
        Bundle bundle2 = bundle;
        if (getResources().getBoolean(C2723R.bool.isTabletPhone)) {
            BaseActivity baseActivity2 = this.baseActivity;
            if ((baseActivity2 instanceof AuctionSalesListActivity) || (baseActivity2 instanceof SearchResultActivity) || (baseActivity2 instanceof ManageOfferListActivity) || (baseActivity2 instanceof PreSaleListActivity) || (baseActivity2 instanceof BDTPaymentActivity) || (baseActivity2 instanceof BuyNowOfferListActivity) || (baseActivity2 instanceof ToPickedUpAccountActivity) || (baseActivity2 instanceof RefinerResultActivity) || (baseActivity2 instanceof SalesDocumentActivity)) {
                BaseActivity baseActivity3 = this.baseActivity;
                if (baseActivity3 instanceof BDTPaymentActivity) {
                    if (baseActivity3 != null) {
                        BDTPaymentActivity bDTPaymentActivity = (BDTPaymentActivity) baseActivity3;
                        RelativeLayout relativeLayout = (RelativeLayout) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "bdtPaymentActivity.toolbar_relativelayout");
                        relativeLayout.setVisibility(8);
                        ActionBar supportActionBar = bDTPaymentActivity.getSupportActionBar();
                        if (supportActionBar != null) {
                            supportActionBar.setDisplayHomeAsUpEnabled(false);
                            Unit unit = Unit.INSTANCE;
                        }
                        ActionBar supportActionBar2 = bDTPaymentActivity.getSupportActionBar();
                        if (supportActionBar2 != null) {
                            supportActionBar2.setHomeButtonEnabled(false);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        Toolbar toolbar = bDTPaymentActivity.getToolbar();
                        if (toolbar != null) {
                            toolbar.setBackgroundColor(-1);
                            Unit unit3 = Unit.INSTANCE;
                        }
                        ConstraintLayout constraintLayout = (ConstraintLayout) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "bdtPaymentActivity.prebid_title_layout");
                        constraintLayout.setVisibility(0);
                        bDTPaymentActivity.getIvStockShare().setVisibility(8);
                        if (bDTPaymentActivity == null) {
                            Intrinsics.throwNpe();
                        }
                        NavController findNavController = Navigation.findNavController(bDTPaymentActivity, C2723R.C2726id.main_nav_host_fragment);
                        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
                        if (z) {
                            TextView textView = (TextView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                            Intrinsics.checkExpressionValueIsNotNull(textView, "bdtPaymentActivity.prebid_page_title");
                            textView.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                            findNavController.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                            return;
                        } else if (z2) {
                            if (this.isTimedAuction) {
                                TextView textView2 = (TextView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                                Intrinsics.checkExpressionValueIsNotNull(textView2, "bdtPaymentActivity.prebid_page_title");
                                textView2.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                            } else {
                                TextView textView3 = (TextView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                                Intrinsics.checkExpressionValueIsNotNull(textView3, "bdtPaymentActivity.prebid_page_title");
                                textView3.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                            }
                            findNavController.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                            return;
                        } else {
                            TextView textView4 = (TextView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                            Intrinsics.checkExpressionValueIsNotNull(textView4, "bdtPaymentActivity.prebid_page_title");
                            textView4.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                            findNavController.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                            return;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity");
                    }
                } else if (baseActivity3 instanceof SalesDocumentActivity) {
                    if (baseActivity3 != null) {
                        SalesDocumentActivity salesDocumentActivity = (SalesDocumentActivity) baseActivity3;
                        RelativeLayout relativeLayout2 = (RelativeLayout) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.sale_doc_toolbar_relativelayout);
                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "salesDocumentActivity.sa…oc_toolbar_relativelayout");
                        relativeLayout2.setVisibility(8);
                        ActionBar supportActionBar3 = salesDocumentActivity.getSupportActionBar();
                        if (supportActionBar3 != null) {
                            supportActionBar3.setDisplayHomeAsUpEnabled(false);
                            Unit unit4 = Unit.INSTANCE;
                        }
                        ActionBar supportActionBar4 = salesDocumentActivity.getSupportActionBar();
                        if (supportActionBar4 != null) {
                            supportActionBar4.setHomeButtonEnabled(false);
                            Unit unit5 = Unit.INSTANCE;
                        }
                        Toolbar toolbar2 = salesDocumentActivity.getToolbar();
                        if (toolbar2 != null) {
                            toolbar2.setBackgroundColor(-1);
                            Unit unit6 = Unit.INSTANCE;
                        }
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                        Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "salesDocumentActivity.prebid_title_layout");
                        constraintLayout2.setVisibility(0);
                        salesDocumentActivity.getIvStockShare().setVisibility(8);
                        if (salesDocumentActivity == null) {
                            Intrinsics.throwNpe();
                        }
                        NavController findNavController2 = Navigation.findNavController(salesDocumentActivity, C2723R.C2726id.sales_document_nav_host_fragment);
                        Intrinsics.checkExpressionValueIsNotNull(findNavController2, "Navigation.findNavContro…cument_nav_host_fragment)");
                        if (z) {
                            TextView textView5 = (TextView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                            Intrinsics.checkExpressionValueIsNotNull(textView5, "salesDocumentActivity.prebid_page_title");
                            textView5.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                            findNavController2.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                            return;
                        } else if (z2) {
                            if (this.isTimedAuction) {
                                TextView textView6 = (TextView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                                Intrinsics.checkExpressionValueIsNotNull(textView6, "salesDocumentActivity.prebid_page_title");
                                textView6.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                            } else {
                                TextView textView7 = (TextView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                                Intrinsics.checkExpressionValueIsNotNull(textView7, "salesDocumentActivity.prebid_page_title");
                                textView7.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                            }
                            findNavController2.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                            return;
                        } else {
                            TextView textView8 = (TextView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                            Intrinsics.checkExpressionValueIsNotNull(textView8, "salesDocumentActivity.prebid_page_title");
                            textView8.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                            findNavController2.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                            return;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity");
                    }
                } else if (!(baseActivity3 instanceof RefinerResultActivity)) {
                    initializeShareForTablet(false);
                    BaseActivity baseActivity4 = this.baseActivity;
                    if (baseActivity4 == null) {
                        Intrinsics.throwNpe();
                    }
                    NavController findNavController3 = Navigation.findNavController(baseActivity4, C2723R.C2726id.auction_sales_nav_container);
                    Intrinsics.checkExpressionValueIsNotNull(findNavController3, "Navigation.findNavContro…tion_sales_nav_container)");
                    if (z) {
                        findNavController3.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                        return;
                    } else if (z2) {
                        findNavController3.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                        return;
                    } else {
                        findNavController3.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                        return;
                    }
                } else if (baseActivity3 != null) {
                    RefinerResultActivity refinerResultActivity = (RefinerResultActivity) baseActivity3;
                    RelativeLayout relativeLayout3 = (RelativeLayout) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                    Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "refinerResultActivity.toolbar_relativelayout");
                    relativeLayout3.setVisibility(0);
                    ActionBar supportActionBar5 = refinerResultActivity.getSupportActionBar();
                    if (supportActionBar5 != null) {
                        supportActionBar5.setDisplayHomeAsUpEnabled(true);
                        Unit unit7 = Unit.INSTANCE;
                    }
                    ActionBar supportActionBar6 = refinerResultActivity.getSupportActionBar();
                    if (supportActionBar6 != null) {
                        supportActionBar6.setHomeButtonEnabled(true);
                        Unit unit8 = Unit.INSTANCE;
                    }
                    Toolbar toolbar3 = refinerResultActivity.getToolbar();
                    if (toolbar3 != null) {
                        toolbar3.setBackgroundColor(-1);
                        Unit unit9 = Unit.INSTANCE;
                    }
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                    Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "refinerResultActivity.prebid_title_layout");
                    constraintLayout3.setVisibility(0);
                    refinerResultActivity.getIvStockShare().setVisibility(8);
                    if (refinerResultActivity == null) {
                        Intrinsics.throwNpe();
                    }
                    NavController findNavController4 = Navigation.findNavController(refinerResultActivity, C2723R.C2726id.auction_sales_nav_container);
                    Intrinsics.checkExpressionValueIsNotNull(findNavController4, "Navigation.findNavContro…tion_sales_nav_container)");
                    if (z) {
                        TextView textView9 = (TextView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView9, "refinerResultActivity.prebid_page_title");
                        textView9.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                        findNavController4.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                        return;
                    } else if (z2) {
                        if (this.isTimedAuction) {
                            TextView textView10 = (TextView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                            Intrinsics.checkExpressionValueIsNotNull(textView10, "refinerResultActivity.prebid_page_title");
                            textView10.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                        } else {
                            TextView textView11 = (TextView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                            Intrinsics.checkExpressionValueIsNotNull(textView11, "refinerResultActivity.prebid_page_title");
                            textView11.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                        }
                        findNavController4.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                        return;
                    } else {
                        TextView textView12 = (TextView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView12, "refinerResultActivity.prebid_page_title");
                        textView12.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                        findNavController4.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                        return;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
                }
            }
        }
        BaseActivity baseActivity5 = this.baseActivity;
        if (baseActivity5 instanceof AuctionSalesListActivity) {
            if (baseActivity5 != null) {
                AuctionSalesListActivity auctionSalesListActivity = (AuctionSalesListActivity) baseActivity5;
                RelativeLayout relativeLayout4 = (RelativeLayout) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout4, "auctionSalesListActivity.toolbar_relativelayout");
                relativeLayout4.setVisibility(8);
                ActionBar supportActionBar7 = auctionSalesListActivity.getSupportActionBar();
                if (supportActionBar7 != null) {
                    supportActionBar7.setDisplayHomeAsUpEnabled(false);
                    Unit unit10 = Unit.INSTANCE;
                }
                ActionBar supportActionBar8 = auctionSalesListActivity.getSupportActionBar();
                if (supportActionBar8 != null) {
                    supportActionBar8.setHomeButtonEnabled(false);
                    Unit unit11 = Unit.INSTANCE;
                }
                Toolbar toolbar4 = auctionSalesListActivity.getToolbar();
                if (toolbar4 != null) {
                    toolbar4.setBackgroundColor(-1);
                    Unit unit12 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout4 = (ConstraintLayout) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout4, "auctionSalesListActivity.prebid_title_layout");
                constraintLayout4.setVisibility(0);
                auctionSalesListActivity.getIvStockShare().setVisibility(8);
                if (auctionSalesListActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController5 = Navigation.findNavController(auctionSalesListActivity, C2723R.C2726id.main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController5, "Navigation.findNavContro…d.main_nav_host_fragment)");
                if (z) {
                    TextView textView13 = (TextView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView13, "auctionSalesListActivity.prebid_page_title");
                    textView13.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                    findNavController5.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                } else if (z2) {
                    if (this.isTimedAuction) {
                        TextView textView14 = (TextView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView14, "auctionSalesListActivity.prebid_page_title");
                        textView14.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                    } else {
                        TextView textView15 = (TextView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView15, "auctionSalesListActivity.prebid_page_title");
                        textView15.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                    }
                    findNavController5.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                } else {
                    TextView textView16 = (TextView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView16, "auctionSalesListActivity.prebid_page_title");
                    textView16.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                    findNavController5.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
            }
        } else if (baseActivity5 instanceof SearchResultActivity) {
            if (baseActivity5 != null) {
                SearchResultActivity searchResultActivity = (SearchResultActivity) baseActivity5;
                RelativeLayout relativeLayout5 = (RelativeLayout) searchResultActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout5, "searchResultActivity.toolbar_relativelayout");
                relativeLayout5.setVisibility(8);
                ActionBar supportActionBar9 = searchResultActivity.getSupportActionBar();
                if (supportActionBar9 != null) {
                    supportActionBar9.setDisplayHomeAsUpEnabled(false);
                    Unit unit13 = Unit.INSTANCE;
                }
                ActionBar supportActionBar10 = searchResultActivity.getSupportActionBar();
                if (supportActionBar10 != null) {
                    supportActionBar10.setHomeButtonEnabled(false);
                    Unit unit14 = Unit.INSTANCE;
                }
                Toolbar toolbar5 = searchResultActivity.getToolbar();
                if (toolbar5 != null) {
                    toolbar5.setBackgroundColor(-1);
                    Unit unit15 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout5 = (ConstraintLayout) searchResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout5, "searchResultActivity.prebid_title_layout");
                constraintLayout5.setVisibility(0);
                searchResultActivity.getIvStockShare().setVisibility(8);
                if (searchResultActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController6 = Navigation.findNavController(searchResultActivity, C2723R.C2726id.main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController6, "Navigation.findNavContro…d.main_nav_host_fragment)");
                if (z) {
                    TextView textView17 = (TextView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView17, "searchResultActivity.prebid_page_title");
                    textView17.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                    findNavController6.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                } else if (z2) {
                    if (this.isTimedAuction) {
                        TextView textView18 = (TextView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView18, "searchResultActivity.prebid_page_title");
                        textView18.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                    } else {
                        TextView textView19 = (TextView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView19, "searchResultActivity.prebid_page_title");
                        textView19.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                    }
                    findNavController6.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                } else {
                    TextView textView20 = (TextView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView20, "searchResultActivity.prebid_page_title");
                    textView20.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                    findNavController6.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity");
            }
        } else if (baseActivity5 instanceof ProductDetailActivity) {
            if (baseActivity5 != null) {
                ProductDetailActivity productDetailActivity = (ProductDetailActivity) baseActivity5;
                if (productDetailActivity == null) {
                    Intrinsics.throwNpe();
                }
                RelativeLayout relativeLayout6 = (RelativeLayout) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_fs);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout6, "productDetailActivity!!.toolbar_relativelayout_fs");
                relativeLayout6.setVisibility(8);
                ActionBar supportActionBar11 = productDetailActivity.getSupportActionBar();
                if (supportActionBar11 != null) {
                    supportActionBar11.setDisplayHomeAsUpEnabled(false);
                    Unit unit16 = Unit.INSTANCE;
                }
                ActionBar supportActionBar12 = productDetailActivity.getSupportActionBar();
                if (supportActionBar12 != null) {
                    supportActionBar12.setHomeButtonEnabled(false);
                    Unit unit17 = Unit.INSTANCE;
                }
                Toolbar toolbar6 = productDetailActivity.getToolbar();
                if (toolbar6 != null) {
                    toolbar6.setBackgroundColor(-1);
                    Unit unit18 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout6 = (ConstraintLayout) productDetailActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout_fs);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout6, "productDetailActivity!!.prebid_title_layout_fs");
                constraintLayout6.setVisibility(0);
                productDetailActivity.getIvStockShare().setVisibility(8);
                NavController findNavController7 = Navigation.findNavController(productDetailActivity, C2723R.C2726id.main_nav_host_product_activity);
                Intrinsics.checkExpressionValueIsNotNull(findNavController7, "Navigation.findNavContro…av_host_product_activity)");
                if (z) {
                    TextView textView21 = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title_fs);
                    Intrinsics.checkExpressionValueIsNotNull(textView21, "productDetailActivity.prebid_page_title_fs");
                    textView21.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                    findNavController7.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                } else if (z2) {
                    if (this.isTimedAuction) {
                        TextView textView22 = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title_fs);
                        Intrinsics.checkExpressionValueIsNotNull(textView22, "productDetailActivity.prebid_page_title_fs");
                        textView22.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                    } else {
                        TextView textView23 = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title_fs);
                        Intrinsics.checkExpressionValueIsNotNull(textView23, "productDetailActivity.prebid_page_title_fs");
                        textView23.setText("Place Pre-Bid");
                    }
                    findNavController7.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                } else {
                    TextView textView24 = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title_fs);
                    Intrinsics.checkExpressionValueIsNotNull(textView24, "productDetailActivity.prebid_page_title_fs");
                    textView24.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                    findNavController7.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.productDetail.ProductDetailActivity");
            }
        } else if (baseActivity5 instanceof ManageOfferListActivity) {
            if (baseActivity5 != null) {
                ManageOfferListActivity manageOfferListActivity = (ManageOfferListActivity) baseActivity5;
                RelativeLayout relativeLayout7 = (RelativeLayout) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout7, "manageOfferListActivity.toolbar_relativelayout");
                relativeLayout7.setVisibility(8);
                ActionBar supportActionBar13 = manageOfferListActivity.getSupportActionBar();
                if (supportActionBar13 != null) {
                    supportActionBar13.setDisplayHomeAsUpEnabled(false);
                    Unit unit19 = Unit.INSTANCE;
                }
                ActionBar supportActionBar14 = manageOfferListActivity.getSupportActionBar();
                if (supportActionBar14 != null) {
                    supportActionBar14.setHomeButtonEnabled(false);
                    Unit unit20 = Unit.INSTANCE;
                }
                Toolbar toolbar7 = manageOfferListActivity.getToolbar();
                if (toolbar7 != null) {
                    toolbar7.setBackgroundColor(-1);
                    Unit unit21 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout7 = (ConstraintLayout) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout7, "manageOfferListActivity.prebid_title_layout");
                constraintLayout7.setVisibility(0);
                manageOfferListActivity.getIvStockShare().setVisibility(8);
                if (manageOfferListActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController8 = Navigation.findNavController(manageOfferListActivity, C2723R.C2726id.main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController8, "Navigation.findNavContro…d.main_nav_host_fragment)");
                if (z) {
                    TextView textView25 = (TextView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView25, "manageOfferListActivity.prebid_page_title");
                    textView25.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                    findNavController8.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                } else if (z2) {
                    if (this.isTimedAuction) {
                        TextView textView26 = (TextView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView26, "manageOfferListActivity.prebid_page_title");
                        textView26.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                    } else {
                        TextView textView27 = (TextView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView27, "manageOfferListActivity.prebid_page_title");
                        textView27.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                    }
                    findNavController8.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                } else {
                    TextView textView28 = (TextView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView28, "manageOfferListActivity.prebid_page_title");
                    textView28.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                    findNavController8.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity");
            }
        } else if (baseActivity5 instanceof LandingBRESectionActivity) {
            if (baseActivity5 != null) {
                LandingBRESectionActivity landingBRESectionActivity = (LandingBRESectionActivity) baseActivity5;
                RelativeLayout relativeLayout8 = (RelativeLayout) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout8, "landingBRESectionActivity.toolbar_relativelayout");
                relativeLayout8.setVisibility(8);
                ActionBar supportActionBar15 = landingBRESectionActivity.getSupportActionBar();
                if (supportActionBar15 != null) {
                    supportActionBar15.setDisplayHomeAsUpEnabled(false);
                    Unit unit22 = Unit.INSTANCE;
                }
                ActionBar supportActionBar16 = landingBRESectionActivity.getSupportActionBar();
                if (supportActionBar16 != null) {
                    supportActionBar16.setHomeButtonEnabled(false);
                    Unit unit23 = Unit.INSTANCE;
                }
                Toolbar toolbar8 = (Toolbar) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.landingToolbar);
                if (toolbar8 != null) {
                    toolbar8.setBackgroundColor(-1);
                    Unit unit24 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout8 = (ConstraintLayout) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout8, "landingBRESectionActivity.prebid_title_layout");
                constraintLayout8.setVisibility(0);
                ImageView imageView = (ImageView) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.ivShareLanding);
                Intrinsics.checkExpressionValueIsNotNull(imageView, "landingBRESectionActivity.ivShareLanding");
                imageView.setVisibility(8);
                if (landingBRESectionActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController9 = Navigation.findNavController(landingBRESectionActivity, C2723R.C2726id.landingBreHostFragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController9, "Navigation.findNavContro…d.landingBreHostFragment)");
                if (z) {
                    TextView textView29 = (TextView) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView29, "landingBRESectionActivity.prebid_page_title");
                    textView29.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                    findNavController9.navigate((int) C2723R.C2726id.action_landing_view_pager_pd_to_buy_now, bundle2);
                } else if (z2) {
                    if (this.isTimedAuction) {
                        TextView textView30 = (TextView) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView30, "landingBRESectionActivity.prebid_page_title");
                        textView30.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                    } else {
                        TextView textView31 = (TextView) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView31, "landingBRESectionActivity.prebid_page_title");
                        textView31.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                    }
                    findNavController9.navigate((int) C2723R.C2726id.action_landing_view_pager_pd_to_pre_bid, bundle2);
                } else {
                    TextView textView32 = (TextView) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView32, "landingBRESectionActivity.prebid_page_title");
                    textView32.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                    findNavController9.navigate((int) C2723R.C2726id.action_landing_view_pager_pd_to_cost_calculator, bundle2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.LandingBRESectionActivity");
            }
        } else if (baseActivity5 instanceof PreSaleListActivity) {
            if (baseActivity5 != null) {
                PreSaleListActivity preSaleListActivity = (PreSaleListActivity) baseActivity5;
                RelativeLayout relativeLayout9 = (RelativeLayout) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout9, "preSaleListActivity.toolbar_relativelayout");
                relativeLayout9.setVisibility(8);
                ActionBar supportActionBar17 = preSaleListActivity.getSupportActionBar();
                if (supportActionBar17 != null) {
                    supportActionBar17.setDisplayHomeAsUpEnabled(false);
                    Unit unit25 = Unit.INSTANCE;
                }
                ActionBar supportActionBar18 = preSaleListActivity.getSupportActionBar();
                if (supportActionBar18 != null) {
                    supportActionBar18.setHomeButtonEnabled(false);
                    Unit unit26 = Unit.INSTANCE;
                }
                Toolbar toolbar9 = (Toolbar) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.landingToolbar);
                if (toolbar9 != null) {
                    toolbar9.setBackgroundColor(-1);
                    Unit unit27 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout9 = (ConstraintLayout) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout9, "preSaleListActivity.prebid_title_layout");
                constraintLayout9.setVisibility(0);
                ImageView imageView2 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.ivShareAS);
                Intrinsics.checkExpressionValueIsNotNull(imageView2, "preSaleListActivity.ivShareAS");
                imageView2.setVisibility(8);
                preSaleListActivity.getIvToolTip().setVisibility(8);
                if (preSaleListActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController10 = Navigation.findNavController(preSaleListActivity, C2723R.C2726id.watch_main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController10, "Navigation.findNavContro…h_main_nav_host_fragment)");
                if (z) {
                    TextView textView33 = (TextView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView33, "preSaleListActivity.prebid_page_title");
                    textView33.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                    findNavController10.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                } else if (z2) {
                    if (this.isTimedAuction) {
                        TextView textView34 = (TextView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView34, "preSaleListActivity.prebid_page_title");
                        textView34.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                    } else {
                        TextView textView35 = (TextView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView35, "preSaleListActivity.prebid_page_title");
                        textView35.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                    }
                    findNavController10.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                } else {
                    TextView textView36 = (TextView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView36, "preSaleListActivity.prebid_page_title");
                    textView36.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                    findNavController10.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity");
            }
        } else if (baseActivity5 instanceof BDTPaymentActivity) {
            if (baseActivity5 != null) {
                BDTPaymentActivity bDTPaymentActivity2 = (BDTPaymentActivity) baseActivity5;
                RelativeLayout relativeLayout10 = (RelativeLayout) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout10, "bdtPaymentActivity.toolbar_relativelayout");
                relativeLayout10.setVisibility(8);
                ActionBar supportActionBar19 = bDTPaymentActivity2.getSupportActionBar();
                if (supportActionBar19 != null) {
                    supportActionBar19.setDisplayHomeAsUpEnabled(false);
                    Unit unit28 = Unit.INSTANCE;
                }
                ActionBar supportActionBar20 = bDTPaymentActivity2.getSupportActionBar();
                if (supportActionBar20 != null) {
                    supportActionBar20.setHomeButtonEnabled(false);
                    Unit unit29 = Unit.INSTANCE;
                }
                Toolbar toolbar10 = bDTPaymentActivity2.getToolbar();
                if (toolbar10 != null) {
                    toolbar10.setBackgroundColor(-1);
                    Unit unit30 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout10 = (ConstraintLayout) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout10, "bdtPaymentActivity.prebid_title_layout");
                constraintLayout10.setVisibility(0);
                bDTPaymentActivity2.getIvStockShare().setVisibility(8);
                if (bDTPaymentActivity2 == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController11 = Navigation.findNavController(bDTPaymentActivity2, C2723R.C2726id.main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController11, "Navigation.findNavContro…d.main_nav_host_fragment)");
                if (z) {
                    TextView textView37 = (TextView) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView37, "bdtPaymentActivity.prebid_page_title");
                    textView37.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                    findNavController11.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                } else if (z2) {
                    if (this.isTimedAuction) {
                        TextView textView38 = (TextView) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView38, "bdtPaymentActivity.prebid_page_title");
                        textView38.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                    } else {
                        TextView textView39 = (TextView) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView39, "bdtPaymentActivity.prebid_page_title");
                        textView39.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                    }
                    findNavController11.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                } else {
                    TextView textView40 = (TextView) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView40, "bdtPaymentActivity.prebid_page_title");
                    textView40.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                    findNavController11.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity");
            }
        } else if (baseActivity5 instanceof ToPickedUpAccountActivity) {
            if (baseActivity5 != null) {
                ToPickedUpAccountActivity toPickedUpAccountActivity = (ToPickedUpAccountActivity) baseActivity5;
                RelativeLayout relativeLayout11 = (RelativeLayout) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_toPickUp);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout11, "toPickedUpAccountActivit…r_relativelayout_toPickUp");
                relativeLayout11.setVisibility(8);
                ActionBar supportActionBar21 = toPickedUpAccountActivity.getSupportActionBar();
                if (supportActionBar21 != null) {
                    supportActionBar21.setDisplayHomeAsUpEnabled(false);
                    Unit unit31 = Unit.INSTANCE;
                }
                ActionBar supportActionBar22 = toPickedUpAccountActivity.getSupportActionBar();
                if (supportActionBar22 != null) {
                    supportActionBar22.setHomeButtonEnabled(false);
                    Unit unit32 = Unit.INSTANCE;
                }
                Toolbar toolbar11 = (Toolbar) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.landingToolbar);
                if (toolbar11 != null) {
                    toolbar11.setBackgroundColor(-1);
                    Unit unit33 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout11 = (ConstraintLayout) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout11, "toPickedUpAccountActivity.prebid_title_layout");
                constraintLayout11.setVisibility(0);
                ImageView imageView3 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.ivShareAS);
                Intrinsics.checkExpressionValueIsNotNull(imageView3, "toPickedUpAccountActivity.ivShareAS");
                imageView3.setVisibility(8);
                ImageView imageView4 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.ivToolTipPickUp);
                Intrinsics.checkExpressionValueIsNotNull(imageView4, "toPickedUpAccountActivity.ivToolTipPickUp");
                imageView4.setVisibility(8);
                if (toPickedUpAccountActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController12 = Navigation.findNavController(toPickedUpAccountActivity, C2723R.C2726id.tobe_pickedup_main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController12, "Navigation.findNavContro…p_main_nav_host_fragment)");
                if (z) {
                    TextView textView41 = (TextView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView41, "toPickedUpAccountActivity.prebid_page_title");
                    textView41.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                    findNavController12.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                } else if (z2) {
                    if (this.isTimedAuction) {
                        TextView textView42 = (TextView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView42, "toPickedUpAccountActivity.prebid_page_title");
                        textView42.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                    } else {
                        TextView textView43 = (TextView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView43, "toPickedUpAccountActivity.prebid_page_title");
                        textView43.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                    }
                    findNavController12.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                } else {
                    TextView textView44 = (TextView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView44, "toPickedUpAccountActivity.prebid_page_title");
                    textView44.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                    findNavController12.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity");
            }
        } else if (baseActivity5 instanceof BuyNowOfferListActivity) {
            if (baseActivity5 != null) {
                BuyNowOfferListActivity buyNowOfferListActivity = (BuyNowOfferListActivity) baseActivity5;
                RelativeLayout relativeLayout12 = (RelativeLayout) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.buynow_toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout12, "buyNowOfferListActivity.…ow_toolbar_relativelayout");
                relativeLayout12.setVisibility(8);
                ActionBar supportActionBar23 = buyNowOfferListActivity.getSupportActionBar();
                if (supportActionBar23 != null) {
                    supportActionBar23.setDisplayHomeAsUpEnabled(false);
                    Unit unit34 = Unit.INSTANCE;
                }
                ActionBar supportActionBar24 = buyNowOfferListActivity.getSupportActionBar();
                if (supportActionBar24 != null) {
                    supportActionBar24.setHomeButtonEnabled(false);
                    Unit unit35 = Unit.INSTANCE;
                }
                Toolbar toolbar12 = (Toolbar) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.landingToolbar);
                if (toolbar12 != null) {
                    toolbar12.setBackgroundColor(-1);
                    Unit unit36 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout12 = (ConstraintLayout) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout12, "buyNowOfferListActivity.prebid_title_layout");
                constraintLayout12.setVisibility(0);
                ImageView imageView5 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.ivShareAS);
                Intrinsics.checkExpressionValueIsNotNull(imageView5, "buyNowOfferListActivity.ivShareAS");
                imageView5.setVisibility(8);
                buyNowOfferListActivity.getIvToolTip().setVisibility(8);
                if (buyNowOfferListActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController13 = Navigation.findNavController(buyNowOfferListActivity, C2723R.C2726id.buy_now_main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController13, "Navigation.findNavContro…w_main_nav_host_fragment)");
                if (z) {
                    TextView textView45 = (TextView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView45, "buyNowOfferListActivity.prebid_page_title");
                    textView45.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                    findNavController13.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                } else if (z2) {
                    if (this.isTimedAuction) {
                        TextView textView46 = (TextView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView46, "buyNowOfferListActivity.prebid_page_title");
                        textView46.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                    } else {
                        TextView textView47 = (TextView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView47, "buyNowOfferListActivity.prebid_page_title");
                        textView47.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                    }
                    findNavController13.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                } else {
                    TextView textView48 = (TextView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView48, "buyNowOfferListActivity.prebid_page_title");
                    textView48.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                    findNavController13.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity");
            }
        } else if (baseActivity5 instanceof SalesDocumentActivity) {
            if (baseActivity5 != null) {
                SalesDocumentActivity salesDocumentActivity2 = (SalesDocumentActivity) baseActivity5;
                RelativeLayout relativeLayout13 = (RelativeLayout) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.sale_doc_toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout13, "salesDocumentActivity.sa…oc_toolbar_relativelayout");
                relativeLayout13.setVisibility(8);
                ActionBar supportActionBar25 = salesDocumentActivity2.getSupportActionBar();
                if (supportActionBar25 != null) {
                    supportActionBar25.setDisplayHomeAsUpEnabled(false);
                    Unit unit37 = Unit.INSTANCE;
                }
                ActionBar supportActionBar26 = salesDocumentActivity2.getSupportActionBar();
                if (supportActionBar26 != null) {
                    supportActionBar26.setHomeButtonEnabled(false);
                    Unit unit38 = Unit.INSTANCE;
                }
                Toolbar toolbar13 = salesDocumentActivity2.getToolbar();
                if (toolbar13 != null) {
                    toolbar13.setBackgroundColor(-1);
                    Unit unit39 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout13 = (ConstraintLayout) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout13, "salesDocumentActivity.prebid_title_layout");
                constraintLayout13.setVisibility(0);
                salesDocumentActivity2.getIvStockShare().setVisibility(8);
                if (salesDocumentActivity2 == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController14 = Navigation.findNavController(salesDocumentActivity2, C2723R.C2726id.sales_document_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController14, "Navigation.findNavContro…cument_nav_host_fragment)");
                if (z) {
                    TextView textView49 = (TextView) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView49, "salesDocumentActivity.prebid_page_title");
                    textView49.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                    findNavController14.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                } else if (z2) {
                    if (this.isTimedAuction) {
                        TextView textView50 = (TextView) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView50, "salesDocumentActivity.prebid_page_title");
                        textView50.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                    } else {
                        TextView textView51 = (TextView) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView51, "salesDocumentActivity.prebid_page_title");
                        textView51.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                    }
                    findNavController14.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                } else {
                    TextView textView52 = (TextView) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView52, "salesDocumentActivity.prebid_page_title");
                    textView52.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                    findNavController14.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity");
            }
        } else if (!(baseActivity5 instanceof RefinerResultActivity)) {
        } else {
            if (baseActivity5 != null) {
                RefinerResultActivity refinerResultActivity2 = (RefinerResultActivity) baseActivity5;
                RelativeLayout relativeLayout14 = (RelativeLayout) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout14, "refinerResultActivity.toolbar_relativelayout");
                relativeLayout14.setVisibility(8);
                ActionBar supportActionBar27 = refinerResultActivity2.getSupportActionBar();
                if (supportActionBar27 != null) {
                    supportActionBar27.setDisplayHomeAsUpEnabled(false);
                    Unit unit40 = Unit.INSTANCE;
                }
                ActionBar supportActionBar28 = refinerResultActivity2.getSupportActionBar();
                if (supportActionBar28 != null) {
                    supportActionBar28.setHomeButtonEnabled(false);
                    Unit unit41 = Unit.INSTANCE;
                }
                Toolbar toolbar14 = refinerResultActivity2.getToolbar();
                if (toolbar14 != null) {
                    toolbar14.setBackgroundColor(-1);
                    Unit unit42 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout14 = (ConstraintLayout) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout14, "refinerResultActivity.prebid_title_layout");
                constraintLayout14.setVisibility(0);
                refinerResultActivity2.getIvStockShare().setVisibility(8);
                TextView textView53 = (TextView) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.tvSavedSearch);
                Intrinsics.checkExpressionValueIsNotNull(textView53, "refinerResultActivity.tvSavedSearch");
                textView53.setVisibility(8);
                if (refinerResultActivity2 == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController15 = Navigation.findNavController(refinerResultActivity2, C2723R.C2726id.main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController15, "Navigation.findNavContro…d.main_nav_host_fragment)");
                if (z) {
                    TextView textView54 = (TextView) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView54, "refinerResultActivity.prebid_page_title");
                    textView54.setText(getResources().getString(C2723R.string.lbl_buy_now_bdt));
                    findNavController15.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_BuyNowFragment, bundle2);
                } else if (z2) {
                    if (this.isTimedAuction) {
                        TextView textView55 = (TextView) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView55, "refinerResultActivity.prebid_page_title");
                        textView55.setText(getResources().getString(C2723R.string.lbl_bdt_place_timed_auction_bid));
                    } else {
                        TextView textView56 = (TextView) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView56, "refinerResultActivity.prebid_page_title");
                        textView56.setText(getResources().getString(C2723R.string.lbl_place_pre_bid));
                    }
                    findNavController15.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_PreBIDFragment, bundle2);
                } else {
                    TextView textView57 = (TextView) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView57, "refinerResultActivity.prebid_page_title");
                    textView57.setText(getResources().getString(C2723R.string.lbl_cost_cal_bdt));
                    findNavController15.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_CostCalculatorFragment, bundle2);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateBidLiveSection(Constants_MVVM.BidAction bidAction) {
        int i = WhenMappings.$EnumSwitchMapping$0[bidAction.ordinal()];
        if (i == 1) {
            this.isBidLive = true;
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.layoutBidLive);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "layoutBidLive");
            _$_findCachedViewById.setVisibility(0);
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnBidLive);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnBidLive");
            button.setText(getResources().getString(C2723R.string.lbl_bdt_bid_live));
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvAuctionBeginsAt);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvAuctionBeginsAt");
            textView.setText(getResources().getString(C2723R.string.lbl_bdt_auction_in_progress_status));
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvCurrentBid);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvCurrentBid");
            textView2.setText(Typography.dollar + this.preBidCurrentBid);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPreBidSection);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llPreBidSection");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llBuyNowSection);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llBuyNowSection");
            linearLayout2.setVisibility(8);
            LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llTimedAuctionSection);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llTimedAuctionSection");
            linearLayout3.setVisibility(8);
        } else if (i == 2) {
            this.isBidLive = false;
            View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.layoutBidLive);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "layoutBidLive");
            _$_findCachedViewById2.setVisibility(0);
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnBidLive);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnBidLive");
            button2.setText(getResources().getString(C2723R.string.lbl_bdt_join_auction));
            TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvAuctionBeginsAt);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "tvAuctionBeginsAt");
            textView3.setText(getResources().getString(C2723R.string.lbl_bdt_join_auction_status, new Object[]{this.liveDateString, this.userTimezoneAbb}));
            TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvCurrentBid);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "tvCurrentBid");
            textView4.setText(Typography.dollar + this.preBidCurrentBid);
            LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llPreBidSection);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llPreBidSection");
            linearLayout4.setVisibility(8);
            LinearLayout linearLayout5 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llBuyNowSection);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout5, "llBuyNowSection");
            linearLayout5.setVisibility(8);
            LinearLayout linearLayout6 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llTimedAuctionSection);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout6, "llTimedAuctionSection");
            linearLayout6.setVisibility(8);
        } else if (i == 3) {
            View _$_findCachedViewById3 = _$_findCachedViewById(C2723R.C2726id.layoutBidLive);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById3, "layoutBidLive");
            _$_findCachedViewById3.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void iBidLive() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        if (!sessionManager2.promptForLoginIfNeedFromFragment(this.baseActivity, this, 29)) {
            launchIBidLive();
        }
    }

    private final void launchIBidLive() {
        String format = NewDateHelper.INSTANCE.format(NewDateHelper.INSTANCE.getDateFromString(this.liveDate), Constants.DATE_PATTERN_WEBSERVICE_PARAM);
        BidManager bidManager2 = this.bidManager;
        if (bidManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bidManager");
        }
        bidManager2.launchIBidLiveFromProductDetail(this.baseActivity, this.branchCode, format, false, false);
    }

    private final void clearCostCalculatorSharedPreference() {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        Application application = baseActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        SharedPreferences sharedPreferences = application.getApplicationContext().getSharedPreferences("cost_preferences_mvvm", 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "baseActivity!!.applicati…m\", Context.MODE_PRIVATE)");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "sharedPref.edit()");
        edit.clear();
        edit.commit();
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwNpe();
        }
        Application application2 = baseActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application2, "baseActivity!!.application");
        SharedPreferences sharedPreferences2 = application2.getApplicationContext().getSharedPreferences("zip_cost_preferences_mvvm", 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences2, "baseActivity!!.applicati…m\", Context.MODE_PRIVATE)");
        SharedPreferences.Editor edit2 = sharedPreferences2.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit2, "sharedPrefZip.edit()");
        edit2.clear();
        edit2.commit();
        BaseActivity baseActivity4 = this.baseActivity;
        if (baseActivity4 == null) {
            Intrinsics.throwNpe();
        }
        Application application3 = baseActivity4.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application3, "baseActivity!!.application");
        SharedPreferences sharedPreferences3 = application3.getApplicationContext().getSharedPreferences("estimate_cost_preferences_mvvm", 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences3, "baseActivity!!.applicati…m\", Context.MODE_PRIVATE)");
        SharedPreferences.Editor edit3 = sharedPreferences3.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit3, "sharedPrefEstimateBid.edit()");
        edit3.clear();
        edit3.commit();
    }

    /* access modifiers changed from: private */
    public final void getChromeSectionData() {
        Bundle bundle = new Bundle();
        bundle.putString(Constants_MVVM.EXTRA_VIN_NUMBER, Utils.unMaskVinNumber(this.vin));
        bundle.putString(Constants_MVVM.EXTRA_YEAR_MAKE_MODEL, this.yearModel);
        bundle.putString(Constants_MVVM.EXTRA_ITEM_ID, this.itemId);
        if (getResources().getBoolean(C2723R.bool.isTabletPhone)) {
            BaseActivity baseActivity2 = this.baseActivity;
            if ((baseActivity2 instanceof AuctionSalesListActivity) || (baseActivity2 instanceof ManageOfferListActivity) || (baseActivity2 instanceof PreSaleListActivity) || (baseActivity2 instanceof BDTPaymentActivity) || (baseActivity2 instanceof BuyNowOfferListActivity) || (baseActivity2 instanceof ToPickedUpAccountActivity) || (baseActivity2 instanceof SearchResultActivity) || (baseActivity2 instanceof RefinerResultActivity) || (baseActivity2 instanceof SalesDocumentActivity)) {
                initializeShareForTablet(false);
                BaseActivity baseActivity3 = this.baseActivity;
                if (baseActivity3 instanceof BDTPaymentActivity) {
                    if (baseActivity3 != null) {
                        BDTPaymentActivity bDTPaymentActivity = (BDTPaymentActivity) baseActivity3;
                        RelativeLayout relativeLayout = (RelativeLayout) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "bdtPaymentActivity.toolbar_relativelayout");
                        relativeLayout.setVisibility(8);
                        ActionBar supportActionBar = bDTPaymentActivity.getSupportActionBar();
                        if (supportActionBar != null) {
                            supportActionBar.setDisplayHomeAsUpEnabled(false);
                            Unit unit = Unit.INSTANCE;
                        }
                        ActionBar supportActionBar2 = bDTPaymentActivity.getSupportActionBar();
                        if (supportActionBar2 != null) {
                            supportActionBar2.setHomeButtonEnabled(false);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        Toolbar toolbar = bDTPaymentActivity.getToolbar();
                        if (toolbar != null) {
                            toolbar.setBackgroundColor(-1);
                            Unit unit3 = Unit.INSTANCE;
                        }
                        ConstraintLayout constraintLayout = (ConstraintLayout) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "bdtPaymentActivity.prebid_title_layout");
                        constraintLayout.setVisibility(0);
                        bDTPaymentActivity.getIvStockShare().setVisibility(8);
                        if (bDTPaymentActivity == null) {
                            Intrinsics.throwNpe();
                        }
                        NavController findNavController = Navigation.findNavController(bDTPaymentActivity, C2723R.C2726id.main_nav_host_fragment);
                        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
                        TextView textView = (TextView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView, "bdtPaymentActivity.prebid_page_title");
                        textView.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                        findNavController.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity");
                } else if (baseActivity3 instanceof SalesDocumentActivity) {
                    if (baseActivity3 != null) {
                        SalesDocumentActivity salesDocumentActivity = (SalesDocumentActivity) baseActivity3;
                        RelativeLayout relativeLayout2 = (RelativeLayout) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.sale_doc_toolbar_relativelayout);
                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "salesDocumentActivity.sa…oc_toolbar_relativelayout");
                        relativeLayout2.setVisibility(8);
                        ActionBar supportActionBar3 = salesDocumentActivity.getSupportActionBar();
                        if (supportActionBar3 != null) {
                            supportActionBar3.setDisplayHomeAsUpEnabled(false);
                            Unit unit4 = Unit.INSTANCE;
                        }
                        ActionBar supportActionBar4 = salesDocumentActivity.getSupportActionBar();
                        if (supportActionBar4 != null) {
                            supportActionBar4.setHomeButtonEnabled(false);
                            Unit unit5 = Unit.INSTANCE;
                        }
                        Toolbar toolbar2 = salesDocumentActivity.getToolbar();
                        if (toolbar2 != null) {
                            toolbar2.setBackgroundColor(-1);
                            Unit unit6 = Unit.INSTANCE;
                        }
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                        Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "salesDocumentActivity.prebid_title_layout");
                        constraintLayout2.setVisibility(0);
                        salesDocumentActivity.getIvStockShare().setVisibility(8);
                        if (salesDocumentActivity == null) {
                            Intrinsics.throwNpe();
                        }
                        NavController findNavController2 = Navigation.findNavController(salesDocumentActivity, C2723R.C2726id.sales_document_nav_host_fragment);
                        Intrinsics.checkExpressionValueIsNotNull(findNavController2, "Navigation.findNavContro…cument_nav_host_fragment)");
                        TextView textView2 = (TextView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                        Intrinsics.checkExpressionValueIsNotNull(textView2, "salesDocumentActivity.prebid_page_title");
                        textView2.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                        findNavController2.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity");
                } else if (!(baseActivity3 instanceof RefinerResultActivity)) {
                    if (baseActivity3 == null) {
                        Intrinsics.throwNpe();
                    }
                    NavController findNavController3 = Navigation.findNavController(baseActivity3, C2723R.C2726id.auction_sales_nav_container);
                    Intrinsics.checkExpressionValueIsNotNull(findNavController3, "Navigation.findNavContro…tion_sales_nav_container)");
                    findNavController3.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                    return;
                } else if (baseActivity3 != null) {
                    RefinerResultActivity refinerResultActivity = (RefinerResultActivity) baseActivity3;
                    RelativeLayout relativeLayout3 = (RelativeLayout) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                    Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "refinerResultActivity.toolbar_relativelayout");
                    relativeLayout3.setVisibility(0);
                    ActionBar supportActionBar5 = refinerResultActivity.getSupportActionBar();
                    if (supportActionBar5 != null) {
                        supportActionBar5.setDisplayHomeAsUpEnabled(true);
                        Unit unit7 = Unit.INSTANCE;
                    }
                    ActionBar supportActionBar6 = refinerResultActivity.getSupportActionBar();
                    if (supportActionBar6 != null) {
                        supportActionBar6.setHomeButtonEnabled(true);
                        Unit unit8 = Unit.INSTANCE;
                    }
                    Toolbar toolbar3 = refinerResultActivity.getToolbar();
                    if (toolbar3 != null) {
                        toolbar3.setBackgroundColor(-1);
                        Unit unit9 = Unit.INSTANCE;
                    }
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                    Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "refinerResultActivity.prebid_title_layout");
                    constraintLayout3.setVisibility(0);
                    refinerResultActivity.getIvStockShare().setVisibility(8);
                    if (refinerResultActivity == null) {
                        Intrinsics.throwNpe();
                    }
                    NavController findNavController4 = Navigation.findNavController(refinerResultActivity, C2723R.C2726id.auction_sales_nav_container);
                    Intrinsics.checkExpressionValueIsNotNull(findNavController4, "Navigation.findNavContro…tion_sales_nav_container)");
                    TextView textView3 = (TextView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                    Intrinsics.checkExpressionValueIsNotNull(textView3, "refinerResultActivity.prebid_page_title");
                    textView3.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                    findNavController4.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                    return;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
                }
            }
        }
        BaseActivity baseActivity4 = this.baseActivity;
        if (baseActivity4 instanceof AuctionSalesListActivity) {
            if (baseActivity4 != null) {
                AuctionSalesListActivity auctionSalesListActivity = (AuctionSalesListActivity) baseActivity4;
                RelativeLayout relativeLayout4 = (RelativeLayout) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout4, "auctionSalesListActivity.toolbar_relativelayout");
                relativeLayout4.setVisibility(8);
                ActionBar supportActionBar7 = auctionSalesListActivity.getSupportActionBar();
                if (supportActionBar7 != null) {
                    supportActionBar7.setDisplayHomeAsUpEnabled(false);
                    Unit unit10 = Unit.INSTANCE;
                }
                ActionBar supportActionBar8 = auctionSalesListActivity.getSupportActionBar();
                if (supportActionBar8 != null) {
                    supportActionBar8.setHomeButtonEnabled(false);
                    Unit unit11 = Unit.INSTANCE;
                }
                Toolbar toolbar4 = auctionSalesListActivity.getToolbar();
                if (toolbar4 != null) {
                    toolbar4.setBackgroundColor(-1);
                    Unit unit12 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout4 = (ConstraintLayout) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout4, "auctionSalesListActivity.prebid_title_layout");
                constraintLayout4.setVisibility(0);
                auctionSalesListActivity.getIvStockShare().setVisibility(8);
                if (auctionSalesListActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController5 = Navigation.findNavController(auctionSalesListActivity, C2723R.C2726id.main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController5, "Navigation.findNavContro…d.main_nav_host_fragment)");
                TextView textView4 = (TextView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                Intrinsics.checkExpressionValueIsNotNull(textView4, "auctionSalesListActivity.prebid_page_title");
                textView4.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                findNavController5.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
        } else if (baseActivity4 instanceof ManageOfferListActivity) {
            if (baseActivity4 != null) {
                ManageOfferListActivity manageOfferListActivity = (ManageOfferListActivity) baseActivity4;
                RelativeLayout relativeLayout5 = (RelativeLayout) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout5, "manageOfferListActivity.toolbar_relativelayout");
                relativeLayout5.setVisibility(8);
                ActionBar supportActionBar9 = manageOfferListActivity.getSupportActionBar();
                if (supportActionBar9 != null) {
                    supportActionBar9.setDisplayHomeAsUpEnabled(false);
                    Unit unit13 = Unit.INSTANCE;
                }
                ActionBar supportActionBar10 = manageOfferListActivity.getSupportActionBar();
                if (supportActionBar10 != null) {
                    supportActionBar10.setHomeButtonEnabled(false);
                    Unit unit14 = Unit.INSTANCE;
                }
                Toolbar toolbar5 = manageOfferListActivity.getToolbar();
                if (toolbar5 != null) {
                    toolbar5.setBackgroundColor(-1);
                    Unit unit15 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout5 = (ConstraintLayout) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout5, "manageOfferListActivity.prebid_title_layout");
                constraintLayout5.setVisibility(0);
                manageOfferListActivity.getIvStockShare().setVisibility(8);
                if (manageOfferListActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController6 = Navigation.findNavController(manageOfferListActivity, C2723R.C2726id.main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController6, "Navigation.findNavContro…d.main_nav_host_fragment)");
                TextView textView5 = (TextView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                Intrinsics.checkExpressionValueIsNotNull(textView5, "manageOfferListActivity.prebid_page_title");
                textView5.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                findNavController6.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity");
        } else if (baseActivity4 instanceof SearchResultActivity) {
            if (baseActivity4 != null) {
                SearchResultActivity searchResultActivity = (SearchResultActivity) baseActivity4;
                RelativeLayout relativeLayout6 = (RelativeLayout) searchResultActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout6, "searchResultActivity.toolbar_relativelayout");
                relativeLayout6.setVisibility(8);
                ActionBar supportActionBar11 = searchResultActivity.getSupportActionBar();
                if (supportActionBar11 != null) {
                    supportActionBar11.setDisplayHomeAsUpEnabled(false);
                    Unit unit16 = Unit.INSTANCE;
                }
                ActionBar supportActionBar12 = searchResultActivity.getSupportActionBar();
                if (supportActionBar12 != null) {
                    supportActionBar12.setHomeButtonEnabled(false);
                    Unit unit17 = Unit.INSTANCE;
                }
                Toolbar toolbar6 = searchResultActivity.getToolbar();
                if (toolbar6 != null) {
                    toolbar6.setBackgroundColor(-1);
                    Unit unit18 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout6 = (ConstraintLayout) searchResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout6, "searchResultActivity.prebid_title_layout");
                constraintLayout6.setVisibility(0);
                searchResultActivity.getIvStockShare().setVisibility(8);
                if (searchResultActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController7 = Navigation.findNavController(searchResultActivity, C2723R.C2726id.main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController7, "Navigation.findNavContro…d.main_nav_host_fragment)");
                TextView textView6 = (TextView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                Intrinsics.checkExpressionValueIsNotNull(textView6, "searchResultActivity.prebid_page_title");
                textView6.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                findNavController7.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity");
        } else if (baseActivity4 instanceof ProductDetailActivity) {
            if (baseActivity4 != null) {
                ProductDetailActivity productDetailActivity = (ProductDetailActivity) baseActivity4;
                RelativeLayout relativeLayout7 = (RelativeLayout) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_fs);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout7, "productDetailActivity.toolbar_relativelayout_fs");
                relativeLayout7.setVisibility(8);
                ActionBar supportActionBar13 = productDetailActivity.getSupportActionBar();
                if (supportActionBar13 != null) {
                    supportActionBar13.setDisplayHomeAsUpEnabled(false);
                    Unit unit19 = Unit.INSTANCE;
                }
                ActionBar supportActionBar14 = productDetailActivity.getSupportActionBar();
                if (supportActionBar14 != null) {
                    supportActionBar14.setHomeButtonEnabled(false);
                    Unit unit20 = Unit.INSTANCE;
                }
                Toolbar toolbar7 = productDetailActivity.getToolbar();
                if (toolbar7 != null) {
                    toolbar7.setBackgroundColor(-1);
                    Unit unit21 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout7 = (ConstraintLayout) productDetailActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout_fs);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout7, "productDetailActivity.prebid_title_layout_fs");
                constraintLayout7.setVisibility(0);
                productDetailActivity.getIvStockShare().setVisibility(8);
                TextView textView7 = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title_fs);
                Intrinsics.checkExpressionValueIsNotNull(textView7, "productDetailActivity.prebid_page_title_fs");
                textView7.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                if (productDetailActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController8 = Navigation.findNavController(productDetailActivity, C2723R.C2726id.main_nav_host_product_activity);
                Intrinsics.checkExpressionValueIsNotNull(findNavController8, "Navigation.findNavContro…av_host_product_activity)");
                findNavController8.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.productDetail.ProductDetailActivity");
        } else if (baseActivity4 instanceof LandingBRESectionActivity) {
            if (baseActivity4 != null) {
                LandingBRESectionActivity landingBRESectionActivity = (LandingBRESectionActivity) baseActivity4;
                RelativeLayout relativeLayout8 = (RelativeLayout) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout8, "landingBRESectionActivity.toolbar_relativelayout");
                relativeLayout8.setVisibility(8);
                ActionBar supportActionBar15 = landingBRESectionActivity.getSupportActionBar();
                if (supportActionBar15 != null) {
                    supportActionBar15.setDisplayHomeAsUpEnabled(false);
                    Unit unit22 = Unit.INSTANCE;
                }
                ActionBar supportActionBar16 = landingBRESectionActivity.getSupportActionBar();
                if (supportActionBar16 != null) {
                    supportActionBar16.setHomeButtonEnabled(false);
                    Unit unit23 = Unit.INSTANCE;
                }
                Toolbar toolbar8 = (Toolbar) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.landingToolbar);
                if (toolbar8 != null) {
                    toolbar8.setBackgroundColor(-1);
                    Unit unit24 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout8 = (ConstraintLayout) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout8, "landingBRESectionActivity.prebid_title_layout");
                constraintLayout8.setVisibility(0);
                ImageView imageView = (ImageView) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.ivShareLanding);
                Intrinsics.checkExpressionValueIsNotNull(imageView, "landingBRESectionActivity.ivShareLanding");
                imageView.setVisibility(8);
                if (landingBRESectionActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController9 = Navigation.findNavController(landingBRESectionActivity, C2723R.C2726id.landingBreHostFragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController9, "Navigation.findNavContro…d.landingBreHostFragment)");
                TextView textView8 = (TextView) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                Intrinsics.checkExpressionValueIsNotNull(textView8, "landingBRESectionActivity.prebid_page_title");
                textView8.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                findNavController9.navigate((int) C2723R.C2726id.action_landing_view_pager_pd_to_chrome_section, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.LandingBRESectionActivity");
        } else if (baseActivity4 instanceof PreSaleListActivity) {
            if (baseActivity4 != null) {
                PreSaleListActivity preSaleListActivity = (PreSaleListActivity) baseActivity4;
                RelativeLayout relativeLayout9 = (RelativeLayout) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout9, "preSaleListActivity.toolbar_relativelayout");
                relativeLayout9.setVisibility(8);
                ActionBar supportActionBar17 = preSaleListActivity.getSupportActionBar();
                if (supportActionBar17 != null) {
                    supportActionBar17.setDisplayHomeAsUpEnabled(false);
                    Unit unit25 = Unit.INSTANCE;
                }
                ActionBar supportActionBar18 = preSaleListActivity.getSupportActionBar();
                if (supportActionBar18 != null) {
                    supportActionBar18.setHomeButtonEnabled(false);
                    Unit unit26 = Unit.INSTANCE;
                }
                Toolbar toolbar9 = (Toolbar) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.landingToolbar);
                if (toolbar9 != null) {
                    toolbar9.setBackgroundColor(-1);
                    Unit unit27 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout9 = (ConstraintLayout) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout9, "preSaleListActivity.prebid_title_layout");
                constraintLayout9.setVisibility(0);
                preSaleListActivity.getIvStockShare().setVisibility(8);
                preSaleListActivity.getIvToolTip().setVisibility(8);
                if (preSaleListActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController10 = Navigation.findNavController(preSaleListActivity, C2723R.C2726id.watch_main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController10, "Navigation.findNavContro…h_main_nav_host_fragment)");
                TextView textView9 = (TextView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                Intrinsics.checkExpressionValueIsNotNull(textView9, "preSaleListActivity.prebid_page_title");
                textView9.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                findNavController10.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity");
        } else if (baseActivity4 instanceof BDTPaymentActivity) {
            if (baseActivity4 != null) {
                BDTPaymentActivity bDTPaymentActivity2 = (BDTPaymentActivity) baseActivity4;
                RelativeLayout relativeLayout10 = (RelativeLayout) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout10, "bdtPaymentActivity.toolbar_relativelayout");
                relativeLayout10.setVisibility(8);
                ActionBar supportActionBar19 = bDTPaymentActivity2.getSupportActionBar();
                if (supportActionBar19 != null) {
                    supportActionBar19.setDisplayHomeAsUpEnabled(false);
                    Unit unit28 = Unit.INSTANCE;
                }
                ActionBar supportActionBar20 = bDTPaymentActivity2.getSupportActionBar();
                if (supportActionBar20 != null) {
                    supportActionBar20.setHomeButtonEnabled(false);
                    Unit unit29 = Unit.INSTANCE;
                }
                Toolbar toolbar10 = bDTPaymentActivity2.getToolbar();
                if (toolbar10 != null) {
                    toolbar10.setBackgroundColor(-1);
                    Unit unit30 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout10 = (ConstraintLayout) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout10, "bdtPaymentActivity.prebid_title_layout");
                constraintLayout10.setVisibility(0);
                bDTPaymentActivity2.getIvStockShare().setVisibility(8);
                if (bDTPaymentActivity2 == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController11 = Navigation.findNavController(bDTPaymentActivity2, C2723R.C2726id.main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController11, "Navigation.findNavContro…d.main_nav_host_fragment)");
                TextView textView10 = (TextView) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                Intrinsics.checkExpressionValueIsNotNull(textView10, "bdtPaymentActivity.prebid_page_title");
                textView10.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                findNavController11.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity");
        } else if (baseActivity4 instanceof BuyNowOfferListActivity) {
            if (baseActivity4 != null) {
                BuyNowOfferListActivity buyNowOfferListActivity = (BuyNowOfferListActivity) baseActivity4;
                RelativeLayout relativeLayout11 = (RelativeLayout) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.buynow_toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout11, "buyNowOfferListActivity.…ow_toolbar_relativelayout");
                relativeLayout11.setVisibility(8);
                ActionBar supportActionBar21 = buyNowOfferListActivity.getSupportActionBar();
                if (supportActionBar21 != null) {
                    supportActionBar21.setDisplayHomeAsUpEnabled(false);
                    Unit unit31 = Unit.INSTANCE;
                }
                ActionBar supportActionBar22 = buyNowOfferListActivity.getSupportActionBar();
                if (supportActionBar22 != null) {
                    supportActionBar22.setHomeButtonEnabled(false);
                    Unit unit32 = Unit.INSTANCE;
                }
                Toolbar toolbar11 = (Toolbar) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.landingToolbar);
                if (toolbar11 != null) {
                    toolbar11.setBackgroundColor(-1);
                    Unit unit33 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout11 = (ConstraintLayout) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout11, "buyNowOfferListActivity.prebid_title_layout");
                constraintLayout11.setVisibility(0);
                ImageView imageView2 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.ivShareLanding);
                Intrinsics.checkExpressionValueIsNotNull(imageView2, "buyNowOfferListActivity.ivShareLanding");
                imageView2.setVisibility(8);
                buyNowOfferListActivity.getIvToolTip().setVisibility(8);
                if (buyNowOfferListActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController12 = Navigation.findNavController(buyNowOfferListActivity, C2723R.C2726id.buy_now_main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController12, "Navigation.findNavContro…w_main_nav_host_fragment)");
                TextView textView11 = (TextView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                Intrinsics.checkExpressionValueIsNotNull(textView11, "buyNowOfferListActivity.prebid_page_title");
                textView11.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                findNavController12.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity");
        } else if (baseActivity4 instanceof ToPickedUpAccountActivity) {
            if (baseActivity4 != null) {
                ToPickedUpAccountActivity toPickedUpAccountActivity = (ToPickedUpAccountActivity) baseActivity4;
                RelativeLayout relativeLayout12 = (RelativeLayout) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_toPickUp);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout12, "toPickedUpAccountActivit…r_relativelayout_toPickUp");
                relativeLayout12.setVisibility(8);
                ActionBar supportActionBar23 = toPickedUpAccountActivity.getSupportActionBar();
                if (supportActionBar23 != null) {
                    supportActionBar23.setDisplayHomeAsUpEnabled(false);
                    Unit unit34 = Unit.INSTANCE;
                }
                ActionBar supportActionBar24 = toPickedUpAccountActivity.getSupportActionBar();
                if (supportActionBar24 != null) {
                    supportActionBar24.setHomeButtonEnabled(false);
                    Unit unit35 = Unit.INSTANCE;
                }
                Toolbar toolbar12 = (Toolbar) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.landingToolbar);
                if (toolbar12 != null) {
                    toolbar12.setBackgroundColor(-1);
                    Unit unit36 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout12 = (ConstraintLayout) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout12, "toPickedUpAccountActivity.prebid_title_layout");
                constraintLayout12.setVisibility(0);
                ImageView imageView3 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.ivShareAS);
                Intrinsics.checkExpressionValueIsNotNull(imageView3, "toPickedUpAccountActivity.ivShareAS");
                imageView3.setVisibility(8);
                ImageView imageView4 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.ivToolTipPickUp);
                Intrinsics.checkExpressionValueIsNotNull(imageView4, "toPickedUpAccountActivity.ivToolTipPickUp");
                imageView4.setVisibility(8);
                if (toPickedUpAccountActivity == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController13 = Navigation.findNavController(toPickedUpAccountActivity, C2723R.C2726id.tobe_pickedup_main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController13, "Navigation.findNavContro…p_main_nav_host_fragment)");
                TextView textView12 = (TextView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                Intrinsics.checkExpressionValueIsNotNull(textView12, "toPickedUpAccountActivity.prebid_page_title");
                textView12.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                findNavController13.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity");
        } else if (baseActivity4 instanceof SalesDocumentActivity) {
            if (baseActivity4 != null) {
                SalesDocumentActivity salesDocumentActivity2 = (SalesDocumentActivity) baseActivity4;
                RelativeLayout relativeLayout13 = (RelativeLayout) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.sale_doc_toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout13, "salesDocumentActivity.sa…oc_toolbar_relativelayout");
                relativeLayout13.setVisibility(8);
                ActionBar supportActionBar25 = salesDocumentActivity2.getSupportActionBar();
                if (supportActionBar25 != null) {
                    supportActionBar25.setDisplayHomeAsUpEnabled(false);
                    Unit unit37 = Unit.INSTANCE;
                }
                ActionBar supportActionBar26 = salesDocumentActivity2.getSupportActionBar();
                if (supportActionBar26 != null) {
                    supportActionBar26.setHomeButtonEnabled(false);
                    Unit unit38 = Unit.INSTANCE;
                }
                Toolbar toolbar13 = salesDocumentActivity2.getToolbar();
                if (toolbar13 != null) {
                    toolbar13.setBackgroundColor(-1);
                    Unit unit39 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout13 = (ConstraintLayout) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout13, "salesDocumentActivity.prebid_title_layout");
                constraintLayout13.setVisibility(0);
                salesDocumentActivity2.getIvStockShare().setVisibility(8);
                if (salesDocumentActivity2 == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController14 = Navigation.findNavController(salesDocumentActivity2, C2723R.C2726id.sales_document_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController14, "Navigation.findNavContro…cument_nav_host_fragment)");
                TextView textView13 = (TextView) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                Intrinsics.checkExpressionValueIsNotNull(textView13, "salesDocumentActivity.prebid_page_title");
                textView13.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                findNavController14.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity");
        } else if (!(baseActivity4 instanceof RefinerResultActivity)) {
        } else {
            if (baseActivity4 != null) {
                RefinerResultActivity refinerResultActivity2 = (RefinerResultActivity) baseActivity4;
                RelativeLayout relativeLayout14 = (RelativeLayout) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout14, "refinerResultActivity.toolbar_relativelayout");
                relativeLayout14.setVisibility(8);
                ActionBar supportActionBar27 = refinerResultActivity2.getSupportActionBar();
                if (supportActionBar27 != null) {
                    supportActionBar27.setDisplayHomeAsUpEnabled(false);
                    Unit unit40 = Unit.INSTANCE;
                }
                ActionBar supportActionBar28 = refinerResultActivity2.getSupportActionBar();
                if (supportActionBar28 != null) {
                    supportActionBar28.setHomeButtonEnabled(false);
                    Unit unit41 = Unit.INSTANCE;
                }
                Toolbar toolbar14 = refinerResultActivity2.getToolbar();
                if (toolbar14 != null) {
                    toolbar14.setBackgroundColor(-1);
                    Unit unit42 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout14 = (ConstraintLayout) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout14, "refinerResultActivity.prebid_title_layout");
                constraintLayout14.setVisibility(0);
                refinerResultActivity2.getIvStockShare().setVisibility(8);
                TextView textView14 = (TextView) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.tvSavedSearch);
                Intrinsics.checkExpressionValueIsNotNull(textView14, "refinerResultActivity.tvSavedSearch");
                textView14.setVisibility(8);
                if (refinerResultActivity2 == null) {
                    Intrinsics.throwNpe();
                }
                NavController findNavController15 = Navigation.findNavController(refinerResultActivity2, C2723R.C2726id.main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController15, "Navigation.findNavContro…d.main_nav_host_fragment)");
                TextView textView15 = (TextView) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
                Intrinsics.checkExpressionValueIsNotNull(textView15, "refinerResultActivity.prebid_page_title");
                textView15.setText(getResources().getString(C2723R.string.lbl_bdt_view_full_vin_details));
                findNavController15.navigate((int) C2723R.C2726id.action_view_pager_PDFragment_to_chrome_section_fragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
        }
    }

    public void onResume() {
        super.onResume();
        boolean z = getResources().getBoolean(C2723R.bool.isTabletPhone);
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        String value = IAAAnalytics.IAAScreenName.VEHICLE_DETAIL.getValue();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        iAAAnalytics.logScreenName(value, activity, this);
        if (z) {
            if (!Intrinsics.areEqual((Object) this.itemId, (Object) "")) {
                initializeShareForTablet(true);
            } else {
                initializeShareForTablet(false);
            }
        }
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        Application application = baseActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        String estimateCostValue = IAASharedPreference.getEstimateCostValue(application.getApplicationContext(), this.itemId);
        Intrinsics.checkExpressionValueIsNotNull(estimateCostValue, "IAASharedPreference.getE…plicationContext, itemId)");
        this.estimatedBid = estimateCostValue;
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwNpe();
        }
        Application application2 = baseActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application2, "baseActivity!!.application");
        String estimateFinalCostValue = IAASharedPreference.getEstimateFinalCostValue(application2.getApplicationContext(), this.itemId);
        Intrinsics.checkExpressionValueIsNotNull(estimateFinalCostValue, "IAASharedPreference.getE…plicationContext, itemId)");
        this.estimatedFinalCost = estimateFinalCostValue;
        if (this.estimatedBid.length() > 0) {
            if (this.estimatedFinalCost.length() > 0) {
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llCostCalculator);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llCostCalculator");
                linearLayout.setVisibility(8);
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llEstimatedCostValue);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llEstimatedCostValue");
                linearLayout2.setVisibility(0);
                TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.estimateFinalCost);
                Intrinsics.checkExpressionValueIsNotNull(textView, "estimateFinalCost");
                textView.setText(getResources().getString(C2723R.string.lbl_bdt_estimated_final_cost) + this.estimatedFinalCost);
                TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.estimateBid);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "estimateBid");
                textView2.setText(getResources().getString(C2723R.string.lbl_bdt_estimated_bid) + this.estimatedBid);
                return;
            }
        }
        if (this.isLoggedIn) {
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            if (!Intrinsics.areEqual((Object) sessionManager2.getCurrentSessionBuyerId(), (Object) "0")) {
                LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llCostCalculator);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llCostCalculator");
                linearLayout3.setVisibility(0);
                LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llEstimatedCostValue);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llEstimatedCostValue");
                linearLayout4.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void playEngineVideoSound(String str) {
        Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.ENGINE_VIDEO.getId());
        IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.ENGINE_VIDEO, (Bundle) null);
        Intent intent = new Intent(getContext(), EngineVideoActivity.class);
        intent.putExtra(Constants_MVVM.EXTRA_ENGINE_VIDEO_URL, str);
        startActivity(intent);
    }

    public void postShortLinkURL(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "shortLinkURL");
        if (isAdded() && this.isViewAvalibale) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", String.valueOf(str));
            intent.setType(HTTP.PLAIN_TEXT_TYPE);
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public final void setUpShareButtonClick() {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 instanceof AuctionSalesListActivity) {
            if (baseActivity2 != null) {
                AuctionSalesListActivity auctionSalesListActivity = (AuctionSalesListActivity) baseActivity2;
                auctionSalesListActivity.getIvStockShare().setOnClickListener(new ProductDetailFragment$setUpShareButtonClick$1(this, auctionSalesListActivity));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
        } else if (baseActivity2 instanceof SearchResultActivity) {
            if (baseActivity2 != null) {
                SearchResultActivity searchResultActivity = (SearchResultActivity) baseActivity2;
                searchResultActivity.getIvStockShare().setOnClickListener(new ProductDetailFragment$setUpShareButtonClick$2(this, searchResultActivity));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity");
        } else if (baseActivity2 instanceof ProductDetailActivity) {
            if (baseActivity2 != null) {
                ProductDetailActivity productDetailActivity = (ProductDetailActivity) baseActivity2;
                productDetailActivity.getIvStockShare().setOnClickListener(new ProductDetailFragment$setUpShareButtonClick$3(this, productDetailActivity));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.productDetail.ProductDetailActivity");
        } else if (baseActivity2 instanceof LandingBRESectionActivity) {
            if (baseActivity2 != null) {
                LandingBRESectionActivity landingBRESectionActivity = (LandingBRESectionActivity) baseActivity2;
                ((ImageView) landingBRESectionActivity._$_findCachedViewById(C2723R.C2726id.ivShareLanding)).setOnClickListener(new ProductDetailFragment$setUpShareButtonClick$4(this, landingBRESectionActivity));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.LandingBRESectionActivity");
        } else if (baseActivity2 instanceof ManageOfferListActivity) {
            if (baseActivity2 != null) {
                ManageOfferListActivity manageOfferListActivity = (ManageOfferListActivity) baseActivity2;
                manageOfferListActivity.getIvStockShare().setOnClickListener(new ProductDetailFragment$setUpShareButtonClick$5(this, manageOfferListActivity));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity");
        } else if (baseActivity2 instanceof PreSaleListActivity) {
            if (baseActivity2 != null) {
                PreSaleListActivity preSaleListActivity = (PreSaleListActivity) baseActivity2;
                preSaleListActivity.getIvStockShare().setOnClickListener(new ProductDetailFragment$setUpShareButtonClick$6(this, preSaleListActivity));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity");
        } else if (baseActivity2 instanceof BDTPaymentActivity) {
            if (baseActivity2 != null) {
                BDTPaymentActivity bDTPaymentActivity = (BDTPaymentActivity) baseActivity2;
                bDTPaymentActivity.getIvStockShare().setOnClickListener(new ProductDetailFragment$setUpShareButtonClick$7(this, bDTPaymentActivity));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity");
        } else if (baseActivity2 instanceof BuyNowOfferListActivity) {
            if (baseActivity2 != null) {
                BuyNowOfferListActivity buyNowOfferListActivity = (BuyNowOfferListActivity) baseActivity2;
                buyNowOfferListActivity.getIvStockShare().setOnClickListener(new ProductDetailFragment$setUpShareButtonClick$8(this, buyNowOfferListActivity));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity");
        } else if (baseActivity2 instanceof ToPickedUpAccountActivity) {
            if (baseActivity2 != null) {
                ToPickedUpAccountActivity toPickedUpAccountActivity = (ToPickedUpAccountActivity) baseActivity2;
                toPickedUpAccountActivity.getIvStockShare().setOnClickListener(new ProductDetailFragment$setUpShareButtonClick$9(this, toPickedUpAccountActivity));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity");
        } else if (baseActivity2 instanceof SalesDocumentActivity) {
            if (baseActivity2 != null) {
                SalesDocumentActivity salesDocumentActivity = (SalesDocumentActivity) baseActivity2;
                salesDocumentActivity.getIvStockShare().setOnClickListener(new ProductDetailFragment$setUpShareButtonClick$10(this, salesDocumentActivity));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity");
        } else if (!(baseActivity2 instanceof RefinerResultActivity)) {
        } else {
            if (baseActivity2 != null) {
                RefinerResultActivity refinerResultActivity = (RefinerResultActivity) baseActivity2;
                refinerResultActivity.getIvStockShare().setOnClickListener(new ProductDetailFragment$setUpShareButtonClick$11(this, refinerResultActivity));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
        }
    }

    /* access modifiers changed from: private */
    public final boolean checkDownloadStatus(long j) {
        try {
            BaseActivity baseActivity2 = this.baseActivity;
            if (baseActivity2 == null) {
                Intrinsics.throwNpe();
            }
            Object systemService = baseActivity2.getSystemService("download");
            if (systemService != null) {
                DownloadManager downloadManager = (DownloadManager) systemService;
                DownloadManager.Query query = new DownloadManager.Query();
                Cursor cursor = null;
                query.setFilterById(new long[]{j});
                while (true) {
                    Cursor query2 = downloadManager.query(query);
                    if (query2.moveToFirst()) {
                        int i = query2.getInt(query2.getColumnIndex("status"));
                        if (i == 8) {
                            return true;
                        }
                        if (i == 16) {
                            return false;
                        }
                    }
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.app.DownloadManager");
            }
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final String shareStockVerbiage() {
        List<String> split = new Regex("\\s").split(this.liveDate, 0);
        if (split == null) {
            Intrinsics.throwNpe();
        }
        String str = split.get(0);
        if (Intrinsics.areEqual((Object) this.auctionId, (Object) "0")) {
            return "Check out this " + this.yearModel + " at IAA.";
        }
        return "Check out this " + this.yearModel + " at IAA before its scheduled auction on " + str + '.';
    }

    /* access modifiers changed from: private */
    public final void sendFireBaseEventBuyNowOfferSuccess() {
        Bundle bundle = new Bundle();
        bundle.putDouble(IAAAnalytics.FireBaseKeyNames.VALUE.getId(), (double) this.buyNowOfferAmount);
        bundle.putString(IAAAnalytics.FireBaseKeyNames.CURRENCY.getId(), IAAAnalytics.FireBaseValueNames.USD.getId());
        bundle.putString(IAAAnalytics.FireBaseKeyNames.ITEM_ID.getId(), this.itemId);
        bundle.putString(IAAAnalytics.FireBaseKeyNames.ORIGIN.getId(), IAAAnalytics.FireBaseValueNames.BUY_NOW_OFFER.getId());
        Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.ECOMMERCE_PURCHASE.getId() + " :" + bundle);
        IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.ECOMMERCE_PURCHASE, bundle);
    }

    /* access modifiers changed from: private */
    public final void initializeShareForTablet(boolean z) {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 instanceof AuctionSalesListActivity) {
            if (baseActivity2 != null) {
                AuctionSalesListActivity auctionSalesListActivity = (AuctionSalesListActivity) baseActivity2;
                if (z) {
                    auctionSalesListActivity.getIvStockShare().setVisibility(0);
                } else {
                    auctionSalesListActivity.getIvStockShare().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
            }
        } else if (baseActivity2 instanceof ManageOfferListActivity) {
            if (baseActivity2 != null) {
                ManageOfferListActivity manageOfferListActivity = (ManageOfferListActivity) baseActivity2;
                ImageView imageView = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.ivToolTip);
                Intrinsics.checkExpressionValueIsNotNull(imageView, "manageOfferListActivity.ivToolTip");
                imageView.setVisibility(0);
                if (z) {
                    manageOfferListActivity.getIvStockShare().setVisibility(0);
                } else {
                    manageOfferListActivity.getIvStockShare().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity");
            }
        } else if (baseActivity2 instanceof SearchResultActivity) {
            if (baseActivity2 != null) {
                SearchResultActivity searchResultActivity = (SearchResultActivity) baseActivity2;
                if (z) {
                    searchResultActivity.getIvStockShare().setVisibility(0);
                } else {
                    searchResultActivity.getIvStockShare().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity");
            }
        } else if (baseActivity2 instanceof ProductDetailActivity) {
            if (baseActivity2 != null) {
                ProductDetailActivity productDetailActivity = (ProductDetailActivity) baseActivity2;
                if (z) {
                    productDetailActivity.getIvStockShare().setVisibility(0);
                } else {
                    productDetailActivity.getIvStockShare().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.productDetail.ProductDetailActivity");
            }
        } else if (baseActivity2 instanceof PreSaleListActivity) {
            if (baseActivity2 != null) {
                PreSaleListActivity preSaleListActivity = (PreSaleListActivity) baseActivity2;
                if (z) {
                    preSaleListActivity.getIvStockShare().setVisibility(0);
                } else {
                    preSaleListActivity.getIvStockShare().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity");
            }
        } else if (baseActivity2 instanceof BuyNowOfferListActivity) {
            if (baseActivity2 != null) {
                BuyNowOfferListActivity buyNowOfferListActivity = (BuyNowOfferListActivity) baseActivity2;
                if (z) {
                    buyNowOfferListActivity.getIvStockShare().setVisibility(0);
                } else {
                    buyNowOfferListActivity.getIvStockShare().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity");
            }
        } else if (baseActivity2 instanceof ToPickedUpAccountActivity) {
            if (baseActivity2 != null) {
                ToPickedUpAccountActivity toPickedUpAccountActivity = (ToPickedUpAccountActivity) baseActivity2;
                if (z) {
                    toPickedUpAccountActivity.getIvStockShare().setVisibility(0);
                } else {
                    toPickedUpAccountActivity.getIvStockShare().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity");
            }
        } else if (!(baseActivity2 instanceof RefinerResultActivity)) {
        } else {
            if (baseActivity2 != null) {
                RefinerResultActivity refinerResultActivity = (RefinerResultActivity) baseActivity2;
                if (z) {
                    refinerResultActivity.getIvStockShare().setVisibility(0);
                } else {
                    refinerResultActivity.getIvStockShare().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x015e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int inflateSalesInfo(java.lang.String r17, java.lang.String r18, int r19, java.lang.String r20, int r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            android.content.Context r4 = r16.getContext()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r5 = 0
            r6 = 0
            r7 = 2131493293(0x7f0c01ad, float:1.8610062E38)
            android.view.View r4 = r4.inflate(r7, r5, r6)
            r7 = 2131297232(0x7f0903d0, float:1.8212403E38)
            android.view.View r7 = r4.findViewById(r7)
            java.lang.String r8 = "view.findViewById<ImageView>(R.id.ivEngineLink)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r8 = 8
            r7.setVisibility(r8)
            r7 = 2131298567(0x7f090907, float:1.821511E38)
            android.view.View r7 = r4.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r9 = 2131298704(0x7f090990, float:1.8215389E38)
            android.view.View r9 = r4.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            android.content.res.Resources r10 = r16.getResources()
            r11 = 2131821561(0x7f1103f9, float:1.9275869E38)
            java.lang.String r10 = r10.getString(r11)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            r12 = 1
            r13 = 2131821484(0x7f1103ac, float:1.9275712E38)
            java.lang.String r14 = "tvLabel"
            if (r10 != 0) goto L_0x009d
            android.content.res.Resources r10 = r16.getResources()
            r15 = 2131821295(0x7f1102ef, float:1.927533E38)
            java.lang.String r10 = r10.getString(r15)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            if (r10 != 0) goto L_0x009d
            android.content.res.Resources r10 = r16.getResources()
            java.lang.String r10 = r10.getString(r13)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            if (r10 != 0) goto L_0x009d
            r10 = r1
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 != 0) goto L_0x007f
            r10 = 1
            goto L_0x0080
        L_0x007f:
            r10 = 0
        L_0x0080:
            if (r10 == 0) goto L_0x0083
            goto L_0x009d
        L_0x0083:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r14)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r1)
            java.lang.String r14 = ": "
            r10.append(r14)
            java.lang.String r10 = r10.toString()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r7.setText(r10)
            goto L_0x00a7
        L_0x009d:
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r14)
            java.lang.String r10 = ""
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r7.setText(r10)
        L_0x00a7:
            java.lang.String r7 = "tvValue"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r7)
            r7 = r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r9.setText(r7)
            r10 = 2131099852(0x7f0600cc, float:1.7812069E38)
            if (r3 == 0) goto L_0x011b
            android.content.res.Resources r14 = r16.getResources()
            java.lang.String r13 = r14.getString(r13)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r13)
            if (r1 == 0) goto L_0x0103
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r13 = "At the <font color='#1c548d'>"
            r1.append(r13)
            r1.append(r2)
            java.lang.String r13 = "</font> branch"
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            int r13 = android.os.Build.VERSION.SDK_INT
            r14 = 24
            if (r13 < r14) goto L_0x00f2
            android.text.SpannableString r13 = new android.text.SpannableString
            android.text.Spanned r1 = android.text.Html.fromHtml(r1, r6)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r13.<init>(r1)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r9.setText(r13)
            goto L_0x0111
        L_0x00f2:
            android.text.SpannableString r13 = new android.text.SpannableString
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r13.<init>(r1)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r9.setText(r13)
            goto L_0x0111
        L_0x0103:
            android.content.res.Resources r1 = r16.getResources()
            int r1 = r1.getColor(r10)
            r9.setTextColor(r1)
            r9.setPaintFlags(r8)
        L_0x0111:
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$inflateSalesInfo$1 r1 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$inflateSalesInfo$1
            r1.<init>(r0, r3, r2)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r9.setOnClickListener(r1)
        L_0x011b:
            if (r2 != 0) goto L_0x0120
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0120:
            android.content.res.Resources r1 = r16.getResources()
            r3 = 2131821602(0x7f110422, float:1.9275952E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.String r3 = "resources.getString(R.string.lbl_offsite)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3 = 2
            boolean r1 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r7, (java.lang.CharSequence) r1, (boolean) r6, (int) r3, (java.lang.Object) r5)
            if (r1 == 0) goto L_0x0150
            android.content.res.Resources r1 = r16.getResources()
            r3 = 2131099887(0x7f0600ef, float:1.781214E38)
            int r1 = r1.getColor(r3)
            r9.setTextColor(r1)
            r1 = 2131231276(0x7f08022c, float:1.8078628E38)
            r9.setCompoundDrawablesWithIntrinsicBounds(r1, r6, r6, r6)
            r9.setCompoundDrawablePadding(r8)
        L_0x0150:
            android.content.res.Resources r1 = r16.getResources()
            java.lang.String r1 = r1.getString(r11)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0178
            android.content.res.Resources r1 = r16.getResources()
            int r1 = r1.getColor(r10)
            r9.setTextColor(r1)
            r9.setPaintFlags(r8)
            com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$inflateSalesInfo$2 r1 = new com.iaai.android.bdt.feature.productDetail.ProductDetailFragment$inflateSalesInfo$2
            r2 = r20
            r1.<init>(r0, r2)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r9.setOnClickListener(r1)
        L_0x0178:
            int r1 = com.iaai.android.C2723R.C2726id.llSalesInfo
            android.view.View r1 = r0._$_findCachedViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r1.addView(r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.productDetail.ProductDetailFragment.inflateSalesInfo(java.lang.String, java.lang.String, int, java.lang.String, int):int");
    }
}
