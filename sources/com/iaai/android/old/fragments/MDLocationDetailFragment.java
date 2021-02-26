package com.iaai.android.old.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.managers.MasterDetailLocationManager;
import com.iaai.android.old.models.MDLocationBranchDetail;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;

public class MDLocationDetailFragment extends Fragment implements OnMapReadyCallback {
    public static final String ARG_BRANCH_NAME = "branch_name";
    public static final String ARG_ITEM_ID = "item_id";
    IaaiApplication application;
    String branch_code;
    String branch_name;
    GoogleMap googleMap;
    @BindView(2131297630)
    ImageView imgBranchImage1;
    @BindView(2131297631)
    ImageView imgBranchImage2;
    double latitude;
    @BindView(2131297634)
    LinearLayout layoutAuctions;
    @BindView(2131297579)
    LinearLayout layoutItemSequence;
    double longitude;
    @BindView(2131297636)
    MapView mapView;
    MasterDetailLocationManager masterDetailLocationManager;
    OnAdditionalStatePDF onAdditionalStatePDF;
    View rootView;
    @BindView(2131297649)
    TextView txtAddress;
    @BindView(2131297651)
    TextView txtAuctionTime;
    @BindView(2131297653)
    TextView txtBranchNote;
    @BindView(2131297654)
    TextView txtDrivingDirection;
    @BindView(2131297655)
    TextView txtDrivingDirectionInfo;
    @BindView(2131297657)
    TextView txtFax;
    @BindView(2131297660)
    TextView txtManager;
    @BindView(2131297661)
    TextView txtPCB;
    @BindView(2131297663)
    TextView txtPhone;
    @BindView(2131297664)
    TextView txtUpcomingAuctionTitle;
    @BindView(2131297666)
    TextView txtVehiclePickup;
    @BindView(2131297668)
    TextView txtVehiclePreview;
    @BindView(2131297670)
    TextView txtWorkingHours;
    @BindView(2131297648)
    TextView txtaddstatereq;

    public interface OnAdditionalStatePDF {
        void OnAdditionalStatePDFListener(String str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.application = (IaaiApplication) getActivity().getApplication();
        this.masterDetailLocationManager = (MasterDetailLocationManager) this.application.getInjector().getInstance(MasterDetailLocationManager.class);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = layoutInflater.inflate(C2723R.C2728layout.mdlocation_detail, viewGroup, false);
        ButterKnife.bind((Object) this, this.rootView);
        this.mapView.onCreate(bundle);
        this.mapView.getMapAsync(this);
        return this.rootView;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.onAdditionalStatePDF = (OnAdditionalStatePDF) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement OnAdditionalStatePDF");
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        this.branch_code = arguments.getString("item_id");
        this.branch_name = arguments.getString(ARG_BRANCH_NAME);
        getLocationDetail(this.branch_code, "");
    }

    public void onMapReady(GoogleMap googleMap2) {
        this.googleMap = googleMap2;
        googleMap2.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(this.latitude, this.longitude), 10.0f));
    }

    /* access modifiers changed from: private */
    public void initilizeMapView(MDLocationBranchDetail mDLocationBranchDetail) {
        if (mDLocationBranchDetail.latitude == null || mDLocationBranchDetail.latitude.length() <= 0) {
            this.latitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            this.latitude = Double.parseDouble(mDLocationBranchDetail.latitude);
        }
        if (mDLocationBranchDetail.longitude == null || mDLocationBranchDetail.longitude.length() <= 0) {
            this.longitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            this.longitude = Double.parseDouble(mDLocationBranchDetail.longitude);
        }
        GoogleMap googleMap2 = this.googleMap;
        if (googleMap2 != null) {
            googleMap2.getUiSettings().setZoomControlsEnabled(true);
            GoogleMap googleMap3 = this.googleMap;
            MarkerOptions title = new MarkerOptions().title(this.branch_name);
            googleMap3.addMarker(title.snippet(mDLocationBranchDetail.streetAddress + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + mDLocationBranchDetail.cityStateZip).icon(BitmapDescriptorFactory.fromResource(C2723R.C2725drawable.ic_marker)).anchor(0.0f, 1.0f).position(new LatLng(this.latitude, this.longitude)));
            this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(this.latitude, this.longitude), 13.0f));
            this.googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                public void onInfoWindowClick(Marker marker) {
                    MDLocationDetailFragment.this.startActivity(Intent.createChooser(new Intent("android.intent.action.VIEW", Uri.parse("geo:<" + MDLocationDetailFragment.this.latitude + ">,<" + MDLocationDetailFragment.this.longitude + ">?q=<" + MDLocationDetailFragment.this.latitude + ">,<" + MDLocationDetailFragment.this.longitude + ">(" + MDLocationDetailFragment.this.branch_name + ")")), "Choose Map..."));
                }
            });
        }
    }

    public void onResume() {
        this.mapView.onResume();
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        this.mapView.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mapView.onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mapView.onLowMemory();
    }

    private void getLocationDetail(String str, String str2) {
        final Dialog showProgressDialog = MDActivityHelper.showProgressDialog(getActivity(), getString(C2723R.string.msg_Loading));
        this.masterDetailLocationManager.getLocationDetail(getActivity(), str, str2, new AsyncHttpResponseHandler() {
            /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
                r8 = (com.iaai.android.old.models.MDLocationBranchDetail) new com.google.gson.Gson().fromJson(new java.lang.String(r10), com.iaai.android.old.models.MDLocationBranchDetail.class);
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(int r8, p052cz.msebera.android.httpclient.Header[] r9, byte[] r10) {
                /*
                    r7 = this;
                    com.iaai.android.old.fragments.MDLocationDetailFragment r8 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    androidx.fragment.app.FragmentActivity r8 = r8.getActivity()
                    if (r8 == 0) goto L_0x0355
                    com.iaai.android.old.fragments.MDLocationDetailFragment r8 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    boolean r8 = r8.isAdded()
                    if (r8 == 0) goto L_0x0355
                    com.google.gson.Gson r8 = new com.google.gson.Gson
                    r8.<init>()
                    java.lang.String r9 = new java.lang.String
                    r9.<init>(r10)
                    java.lang.Class<com.iaai.android.old.models.MDLocationBranchDetail> r10 = com.iaai.android.old.models.MDLocationBranchDetail.class
                    java.lang.Object r8 = r8.fromJson((java.lang.String) r9, r10)
                    com.iaai.android.old.models.MDLocationBranchDetail r8 = (com.iaai.android.old.models.MDLocationBranchDetail) r8
                    if (r8 == 0) goto L_0x0355
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtAddress
                    java.lang.StringBuilder r10 = new java.lang.StringBuilder
                    r10.<init>()
                    java.lang.String r0 = r8.streetAddress
                    r10.append(r0)
                    java.lang.String r0 = "\n"
                    r10.append(r0)
                    java.lang.String r1 = r8.cityStateZip
                    r10.append(r1)
                    java.lang.String r10 = r10.toString()
                    r9.setText(r10)
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    r9.<init>()
                    r10 = 0
                    r1 = 0
                L_0x004a:
                    java.util.ArrayList<com.iaai.android.old.models.BranchOfficeHours> r2 = r8.officeHours
                    int r2 = r2.size()
                    java.lang.String r3 = " "
                    if (r1 >= r2) goto L_0x0086
                    java.util.ArrayList<com.iaai.android.old.models.BranchOfficeHours> r2 = r8.officeHours
                    java.lang.Object r2 = r2.get(r1)
                    com.iaai.android.old.models.BranchOfficeHours r2 = (com.iaai.android.old.models.BranchOfficeHours) r2
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    java.lang.String r5 = r2.officeDays
                    r4.append(r5)
                    r4.append(r3)
                    java.lang.String r2 = r2.officeHours
                    r4.append(r2)
                    java.lang.String r2 = r4.toString()
                    r9.append(r2)
                    java.util.ArrayList<com.iaai.android.old.models.BranchOfficeHours> r2 = r8.officeHours
                    int r2 = r2.size()
                    int r2 = r2 + -1
                    if (r1 != r2) goto L_0x0080
                    goto L_0x0083
                L_0x0080:
                    r9.append(r0)
                L_0x0083:
                    int r1 = r1 + 1
                    goto L_0x004a
                L_0x0086:
                    com.iaai.android.old.fragments.MDLocationDetailFragment r1 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    r1.initilizeMapView(r8)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r1 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r1 = r1.txtWorkingHours
                    r1.setText(r9)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtPhone
                    java.lang.String r1 = r8.phone
                    r9.setText(r1)
                    java.lang.String r9 = r8.phone
                    com.iaai.android.old.fragments.MDLocationDetailFragment r1 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r1 = r1.txtPhone
                    com.iaai.android.old.fragments.MDLocationDetailFragment$2$1 r2 = new com.iaai.android.old.fragments.MDLocationDetailFragment$2$1
                    r2.<init>(r9)
                    r1.setOnClickListener(r2)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtBranchNote
                    java.lang.String r1 = r8.additionalInfo
                    r9.setText(r1)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtFax
                    java.lang.String r1 = r8.fax
                    r9.setText(r1)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtManager
                    java.lang.String r1 = r8.managerName
                    r9.setText(r1)
                    java.lang.String r9 = r8.managerEmail
                    com.iaai.android.old.fragments.MDLocationDetailFragment r1 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r1 = r1.txtManager
                    com.iaai.android.old.fragments.MDLocationDetailFragment$2$2 r2 = new com.iaai.android.old.fragments.MDLocationDetailFragment$2$2
                    r2.<init>(r9)
                    r1.setOnClickListener(r2)
                    java.lang.String r9 = r8.isPublic
                    java.lang.String r1 = "true"
                    boolean r9 = r9.equalsIgnoreCase(r1)
                    r1 = 8
                    if (r9 == 0) goto L_0x00e6
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtPCB
                    r9.setVisibility(r10)
                    goto L_0x00ed
                L_0x00e6:
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtPCB
                    r9.setVisibility(r1)
                L_0x00ed:
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtAuctionTime
                    java.lang.String r2 = r8.auctionSchedule
                    r9.setText(r2)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtVehiclePreview
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r4 = r8.onsitePreview
                    r2.append(r4)
                    java.lang.String r4 = "\n\n"
                    r2.append(r4)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r4 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    r5 = 2131822370(0x7f110722, float:1.927751E38)
                    java.lang.String r4 = r4.getString(r5)
                    r2.append(r4)
                    java.lang.String r2 = r2.toString()
                    r9.setText(r2)
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    r9.<init>()
                    r2 = 0
                L_0x0122:
                    java.util.ArrayList<com.iaai.android.old.models.BranchYardHours> r4 = r8.yardHours
                    int r4 = r4.size()
                    if (r2 >= r4) goto L_0x015c
                    java.util.ArrayList<com.iaai.android.old.models.BranchYardHours> r4 = r8.yardHours
                    java.lang.Object r4 = r4.get(r2)
                    com.iaai.android.old.models.BranchYardHours r4 = (com.iaai.android.old.models.BranchYardHours) r4
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = r4.officeDays
                    r5.append(r6)
                    r5.append(r3)
                    java.lang.String r4 = r4.officeHours
                    r5.append(r4)
                    java.lang.String r4 = r5.toString()
                    r9.append(r4)
                    java.util.ArrayList<com.iaai.android.old.models.BranchYardHours> r4 = r8.yardHours
                    int r4 = r4.size()
                    int r4 = r4 + -1
                    if (r2 != r4) goto L_0x0156
                    goto L_0x0159
                L_0x0156:
                    r9.append(r0)
                L_0x0159:
                    int r2 = r2 + 1
                    goto L_0x0122
                L_0x015c:
                    com.iaai.android.old.fragments.MDLocationDetailFragment r0 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    r2 = 2131822368(0x7f110720, float:1.9277505E38)
                    java.lang.String r0 = r0.getString(r2)
                    r9.append(r0)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r0 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r0 = r0.txtVehiclePickup
                    java.lang.String r9 = r9.toString()
                    r0.setText(r9)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtDrivingDirection
                    com.iaai.android.old.fragments.MDLocationDetailFragment$2$3 r0 = new com.iaai.android.old.fragments.MDLocationDetailFragment$2$3
                    r0.<init>()
                    r9.setOnClickListener(r0)
                    java.util.ArrayList<com.iaai.android.old.models.BranchAuctionNumbering> r9 = r8.auctionNumbering
                    int r9 = r9.size()
                    if (r9 > 0) goto L_0x0188
                    goto L_0x01ff
                L_0x0188:
                    r9 = 0
                L_0x0189:
                    java.util.ArrayList<com.iaai.android.old.models.BranchAuctionNumbering> r0 = r8.auctionNumbering
                    int r0 = r0.size()
                    if (r9 >= r0) goto L_0x01ff
                    com.iaai.android.old.fragments.MDLocationDetailFragment r0 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.content.Context r0 = r0.getContext()
                    java.lang.String r2 = "layout_inflater"
                    java.lang.Object r0 = r0.getSystemService(r2)
                    android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
                    r2 = 2131493178(0x7f0c013a, float:1.8609829E38)
                    r3 = 0
                    android.view.View r0 = r0.inflate(r2, r3)
                    r2 = 2131298283(0x7f0907eb, float:1.8214535E38)
                    android.view.View r2 = r0.findViewById(r2)
                    android.widget.TextView r2 = (android.widget.TextView) r2
                    r3 = 2131296918(0x7f090296, float:1.8211766E38)
                    android.view.View r3 = r0.findViewById(r3)
                    android.widget.TextView r3 = (android.widget.TextView) r3
                    r4 = 2131298147(0x7f090763, float:1.8214259E38)
                    android.view.View r4 = r0.findViewById(r4)
                    android.widget.TextView r4 = (android.widget.TextView) r4
                    java.util.ArrayList<com.iaai.android.old.models.BranchAuctionNumbering> r5 = r8.auctionNumbering
                    java.lang.Object r5 = r5.get(r9)
                    com.iaai.android.old.models.BranchAuctionNumbering r5 = (com.iaai.android.old.models.BranchAuctionNumbering) r5
                    java.lang.String r5 = r5.startItemNumber
                    java.lang.String r5 = java.lang.String.valueOf(r5)
                    r2.setText(r5)
                    java.util.ArrayList<com.iaai.android.old.models.BranchAuctionNumbering> r2 = r8.auctionNumbering
                    java.lang.Object r2 = r2.get(r9)
                    com.iaai.android.old.models.BranchAuctionNumbering r2 = (com.iaai.android.old.models.BranchAuctionNumbering) r2
                    java.lang.String r2 = r2.endItemNumber
                    java.lang.String r2 = java.lang.String.valueOf(r2)
                    r3.setText(r2)
                    java.util.ArrayList<com.iaai.android.old.models.BranchAuctionNumbering> r2 = r8.auctionNumbering
                    java.lang.Object r2 = r2.get(r9)
                    com.iaai.android.old.models.BranchAuctionNumbering r2 = (com.iaai.android.old.models.BranchAuctionNumbering) r2
                    java.lang.String r2 = r2.saleOrderInfo
                    java.lang.String r2 = java.lang.String.valueOf(r2)
                    r4.setText(r2)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r2 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.LinearLayout r2 = r2.layoutItemSequence
                    r2.addView(r0)
                    int r9 = r9 + 1
                    goto L_0x0189
                L_0x01ff:
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtDrivingDirectionInfo
                    java.lang.String r0 = r8.drivingDirection
                    r9.setText(r0)
                    java.util.ArrayList<java.lang.String> r9 = r8.upcomingAuctions
                    int r9 = r9.size()
                    if (r9 > 0) goto L_0x021c
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtUpcomingAuctionTitle
                    r0 = 2131822032(0x7f1105d0, float:1.9276824E38)
                    r9.setText(r0)
                    goto L_0x02be
                L_0x021c:
                    java.util.ArrayList<java.lang.String> r9 = r8.upcomingAuctions
                    com.iaai.android.old.fragments.MDLocationDetailFragment$2$4 r0 = new com.iaai.android.old.fragments.MDLocationDetailFragment$2$4
                    r0.<init>()
                    java.util.Collections.sort(r9, r0)
                    r9 = 0
                L_0x0227:
                    java.util.ArrayList<java.lang.String> r0 = r8.upcomingAuctions
                    int r0 = r0.size()
                    if (r9 >= r0) goto L_0x02be
                    android.widget.TextView r0 = new android.widget.TextView
                    com.iaai.android.old.fragments.MDLocationDetailFragment r2 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    androidx.fragment.app.FragmentActivity r2 = r2.getActivity()
                    r0.<init>(r2)
                    java.util.ArrayList<java.lang.String> r2 = r8.upcomingAuctions
                    java.lang.Object r2 = r2.get(r9)
                    java.lang.String r2 = (java.lang.String) r2
                    java.util.Date r2 = com.iaai.android.old.utils.DateHelper.getDateFromString(r2)
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "EEE MMM d - h:mma"
                    java.lang.String r2 = com.iaai.android.old.utils.DateHelper.format((java.util.Date) r2, (java.lang.String) r4)
                    r3.append(r2)
                    java.lang.String r2 = " (CDT)"
                    r3.append(r2)
                    java.lang.String r2 = r3.toString()
                    r0.setText(r2)
                    r2 = 2131231103(0x7f08017f, float:1.8078278E38)
                    r0.setCompoundDrawablesWithIntrinsicBounds(r2, r10, r10, r10)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r2 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    int r2 = r2.convertDPToPixel(r1)
                    r0.setCompoundDrawablePadding(r2)
                    r0.setId(r9)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r2 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    androidx.fragment.app.FragmentActivity r2 = r2.getActivity()
                    android.content.res.Resources r2 = r2.getResources()
                    r3 = 2131099864(0x7f0600d8, float:1.7812093E38)
                    int r2 = r2.getColor(r3)
                    r0.setTextColor(r2)
                    android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
                    r3 = -2
                    r2.<init>(r3, r3)
                    r3 = 16
                    r2.gravity = r3
                    com.iaai.android.old.fragments.MDLocationDetailFragment r4 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    int r3 = r4.convertDPToPixel(r3)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r4 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    r5 = 4
                    int r4 = r4.convertDPToPixel(r5)
                    r2.setMargins(r3, r4, r10, r10)
                    r0.setLayoutParams(r2)
                    java.util.ArrayList<java.lang.String> r2 = r8.upcomingAuctions
                    java.lang.Object r2 = r2.get(r9)
                    java.lang.String r2 = (java.lang.String) r2
                    com.iaai.android.old.fragments.MDLocationDetailFragment$2$5 r3 = new com.iaai.android.old.fragments.MDLocationDetailFragment$2$5
                    r3.<init>(r2)
                    r0.setOnClickListener(r3)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r2 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.LinearLayout r2 = r2.layoutAuctions
                    r2.addView(r0)
                    int r9 = r9 + 1
                    goto L_0x0227
                L_0x02be:
                    java.lang.String r9 = r8.branchImage
                    boolean r9 = android.text.TextUtils.isEmpty(r9)
                    r0 = 2131231567(0x7f08034f, float:1.8079219E38)
                    r2 = 2131231231(0x7f0801ff, float:1.8078537E38)
                    if (r9 == 0) goto L_0x02dc
                    com.squareup.picasso.Picasso r9 = com.squareup.picasso.Picasso.get()
                    com.squareup.picasso.RequestCreator r9 = r9.load((int) r2)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r3 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.ImageView r3 = r3.imgBranchImage1
                    r9.into((android.widget.ImageView) r3)
                    goto L_0x02fd
                L_0x02dc:
                    com.squareup.picasso.Picasso r9 = com.squareup.picasso.Picasso.get()
                    java.lang.String r3 = r8.branchImage
                    com.squareup.picasso.RequestCreator r9 = r9.load((java.lang.String) r3)
                    com.squareup.picasso.RequestCreator r9 = r9.fit()
                    com.squareup.picasso.RequestCreator r9 = r9.centerCrop()
                    com.squareup.picasso.RequestCreator r9 = r9.placeholder((int) r0)
                    com.squareup.picasso.RequestCreator r9 = r9.error((int) r2)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r3 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.ImageView r3 = r3.imgBranchImage1
                    r9.into((android.widget.ImageView) r3)
                L_0x02fd:
                    java.lang.String r9 = r8.branchImage2
                    boolean r9 = android.text.TextUtils.isEmpty(r9)
                    if (r9 == 0) goto L_0x0315
                    com.squareup.picasso.Picasso r9 = com.squareup.picasso.Picasso.get()
                    com.squareup.picasso.RequestCreator r9 = r9.load((int) r2)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r0 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.ImageView r0 = r0.imgBranchImage2
                    r9.into((android.widget.ImageView) r0)
                    goto L_0x0336
                L_0x0315:
                    com.squareup.picasso.Picasso r9 = com.squareup.picasso.Picasso.get()
                    java.lang.String r3 = r8.branchImage2
                    com.squareup.picasso.RequestCreator r9 = r9.load((java.lang.String) r3)
                    com.squareup.picasso.RequestCreator r9 = r9.fit()
                    com.squareup.picasso.RequestCreator r9 = r9.centerCrop()
                    com.squareup.picasso.RequestCreator r9 = r9.placeholder((int) r0)
                    com.squareup.picasso.RequestCreator r9 = r9.error((int) r2)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r0 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.ImageView r0 = r0.imgBranchImage2
                    r9.into((android.widget.ImageView) r0)
                L_0x0336:
                    java.lang.String r9 = r8.additionalStateReq
                    if (r9 == 0) goto L_0x034e
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtaddstatereq
                    r9.setVisibility(r10)
                    com.iaai.android.old.fragments.MDLocationDetailFragment r9 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r9 = r9.txtaddstatereq
                    com.iaai.android.old.fragments.MDLocationDetailFragment$2$6 r10 = new com.iaai.android.old.fragments.MDLocationDetailFragment$2$6
                    r10.<init>(r8)
                    r9.setOnClickListener(r10)
                    goto L_0x0355
                L_0x034e:
                    com.iaai.android.old.fragments.MDLocationDetailFragment r8 = com.iaai.android.old.fragments.MDLocationDetailFragment.this
                    android.widget.TextView r8 = r8.txtaddstatereq
                    r8.setVisibility(r1)
                L_0x0355:
                    android.app.Dialog r8 = r0
                    r8.dismiss()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.fragments.MDLocationDetailFragment.C32062.onSuccess(int, cz.msebera.android.httpclient.Header[], byte[]):void");
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                showProgressDialog.dismiss();
            }
        });
    }

    public int convertDPToPixel(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getActivity().getResources().getDisplayMetrics());
    }

    public boolean isCallingSupported() {
        return ((TelephonyManager) getActivity().getSystemService("phone")).getPhoneType() != 0;
    }
}
