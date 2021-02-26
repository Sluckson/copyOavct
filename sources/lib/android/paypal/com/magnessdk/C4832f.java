package lib.android.paypal.com.magnessdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import lib.android.paypal.com.magnessdk.p058a.C4819a;
import lib.android.paypal.com.magnessdk.p059b.C4823a;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: lib.android.paypal.com.magnessdk.f */
final class C4832f extends C4826d {

    /* renamed from: aJ */
    private static final int f5649aJ = 255;

    /* renamed from: aK */
    private static final int f5650aK = 256;

    /* renamed from: aL */
    private static final int f5651aL = 16;

    /* renamed from: aM */
    private static final int f5652aM = 32;

    /* renamed from: aN */
    private static final int f5653aN = 32;

    /* renamed from: aO */
    private static final String f5654aO = "invalid_input";

    /* renamed from: aP */
    private static final String f5655aP = "SG1hY1NIQTI1Ng==";

    /* renamed from: aQ */
    private static final String f5656aQ = "RiskManagerCT";

    /* renamed from: aR */
    private static final String f5657aR = "00:00:00:00:00:00";

    /* renamed from: aS */
    private static C4832f f5658aS;

    /* renamed from: aT */
    private int f5659aT = -1;

    /* renamed from: aU */
    private int f5660aU = -1;

    /* renamed from: aV */
    private int f5661aV;

    /* renamed from: aW */
    private int f5662aW = -1;

    /* renamed from: aX */
    private int f5663aX = -1;

    /* renamed from: aY */
    private int f5664aY = -1;

    /* renamed from: aZ */
    private String f5665aZ;

    /* renamed from: bA */
    private long f5666bA;

    /* renamed from: bB */
    private long f5667bB = -1;

    /* renamed from: bC */
    private boolean f5668bC;

    /* renamed from: bD */
    private boolean f5669bD;

    /* renamed from: bE */
    private boolean f5670bE;

    /* renamed from: bF */
    private boolean f5671bF;

    /* renamed from: bG */
    private boolean f5672bG;

    /* renamed from: bH */
    private boolean f5673bH;

    /* renamed from: bI */
    private boolean f5674bI;

    /* renamed from: bJ */
    private boolean f5675bJ;

    /* renamed from: bK */
    private boolean f5676bK;

    /* renamed from: bL */
    private Map<String, String> f5677bL;

    /* renamed from: bM */
    private NetworkInfo f5678bM;

    /* renamed from: bN */
    private WifiInfo f5679bN;

    /* renamed from: bO */
    private GsmCellLocation f5680bO;

    /* renamed from: bP */
    private CdmaCellLocation f5681bP;

    /* renamed from: bQ */
    private TelephonyManager f5682bQ;

    /* renamed from: bR */
    private WifiManager f5683bR;

    /* renamed from: bS */
    private ConnectivityManager f5684bS;

    /* renamed from: bT */
    private LocationManager f5685bT;

    /* renamed from: bU */
    private Location f5686bU;

    /* renamed from: ba */
    private String f5687ba;

    /* renamed from: bb */
    private String f5688bb;

    /* renamed from: bc */
    private String f5689bc;

    /* renamed from: bd */
    private String f5690bd;

    /* renamed from: be */
    private String f5691be;

    /* renamed from: bf */
    private String f5692bf;

    /* renamed from: bg */
    private String f5693bg;

    /* renamed from: bh */
    private String f5694bh;

    /* renamed from: bi */
    private String f5695bi;

    /* renamed from: bj */
    private String f5696bj;

    /* renamed from: bk */
    private String f5697bk;

    /* renamed from: bl */
    private String f5698bl;

    /* renamed from: bm */
    private String f5699bm;

    /* renamed from: bn */
    private String f5700bn;

    /* renamed from: bo */
    private String f5701bo;

    /* renamed from: bp */
    private String f5702bp;

    /* renamed from: bq */
    private String f5703bq;

    /* renamed from: br */
    private String f5704br;

    /* renamed from: bs */
    private String f5705bs;

    /* renamed from: bt */
    private String f5706bt;

    /* renamed from: bu */
    private String f5707bu;

    /* renamed from: bv */
    private String f5708bv;

    /* renamed from: bw */
    private String f5709bw;

    /* renamed from: bx */
    private List<String> f5710bx;

    /* renamed from: by */
    private List<String> f5711by;

    /* renamed from: bz */
    private List<String> f5712bz;

    private C4832f() {
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    private Location m4695a(LocationManager locationManager) {
        Location location = null;
        if (locationManager == null) {
            return null;
        }
        try {
            List<String> providers = locationManager.getProviders(true);
            for (int size = providers.size() - 1; size >= 0; size--) {
                location = locationManager.getLastKnownLocation(providers.get(size));
                if (location != null) {
                    break;
                }
            }
        } catch (Exception e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
        }
        return location;
    }

    /* renamed from: a */
    private String m4696a(String str) {
        if (str == null || str.isEmpty()) {
            str = "invalid input in dc method";
        }
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(str.getBytes());
        byte[] digest = instance.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return sb.toString().substring(0, 32);
    }

    /* renamed from: a */
    private String m4697a(String str, String str2, long j, String str3) {
        String str4;
        String str5;
        StringBuilder sb;
        if (!C4825c.m4660a((Object) str) || !C4825c.m4660a((Object) str2) || !C4825c.m4660a((Object) Long.valueOf(j))) {
            if (C4825c.m4660a((Object) str)) {
                str = "";
            }
            if (C4825c.m4660a((Object) str2)) {
                str2 = "";
            }
            if (C4825c.m4660a((Object) Long.valueOf(j))) {
                sb = new StringBuilder();
                sb.append(str);
            } else {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(j);
            }
            sb.append(str2);
            str4 = sb.toString();
        } else {
            str4 = f5654aO;
        }
        String a = C4825c.m4656a(f5655aP);
        if (C4825c.m4660a((Object) Long.valueOf(j))) {
            str5 = C4825c.m4656a(str3);
        } else {
            str5 = C4825c.m4656a(str3) + j;
        }
        Mac instance = Mac.getInstance(a);
        instance.init(new SecretKeySpec(str5.getBytes(), a));
        byte[] doFinal = instance.doFinal(str4.getBytes());
        StringBuilder sb2 = new StringBuilder();
        for (byte b : doFinal) {
            sb2.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return sb2.toString().substring(0, 32);
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    private ArrayList<String> m4698a(WifiManager wifiManager) {
        String bssid;
        int i;
        if (wifiManager == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        List<ScanResult> scanResults = wifiManager.getScanResults();
        if (scanResults == null || scanResults.size() == 0 || (bssid = wifiManager.getConnectionInfo().getBSSID()) == null || bssid.equals(f5657aR)) {
            return null;
        }
        int i2 = -1;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < scanResults.size(); i4++) {
            if (!bssid.equals(scanResults.get(i4).BSSID) && i3 < (i = scanResults.get(i4).level)) {
                i2 = i4;
                i3 = i;
            }
        }
        arrayList.add(bssid);
        if (i2 != -1) {
            arrayList.add(scanResults.get(i2).BSSID);
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<String> m4699a(boolean z) {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        String hostAddress = nextElement.getHostAddress();
                        if (!(nextElement instanceof Inet6Address) || z) {
                            arrayList.add(hostAddress);
                        }
                    }
                }
            }
        } catch (Exception e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: a */
    private JSONObject m4700a(Location location) {
        if (location != null) {
            try {
                return new JSONObject("{\"lat\":" + location.getLatitude() + ",\"lng\":" + location.getLongitude() + ",\"acc\":" + location.getAccuracy() + ",\"timestamp\":" + location.getTime() + "}");
            } catch (Exception e) {
                C4823a.m4654a(getClass(), 3, (Throwable) e);
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.telephony.gsm.GsmCellLocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.telephony.cdma.CdmaCellLocation} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"MissingPermission"})
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4701a(android.telephony.TelephonyManager r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r5.getPhoneType()
            if (r0 == 0) goto L_0x0067
            r1 = 1
            r2 = 0
            r3 = 3
            if (r0 == r1) goto L_0x0046
            r1 = 2
            if (r0 == r1) goto L_0x002e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "unknown ("
            r0.append(r1)
            int r5 = r5.getPhoneType()
            r0.append(r5)
            java.lang.String r5 = ")"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
        L_0x002b:
            r4.f5700bn = r5
            goto L_0x006a
        L_0x002e:
            java.lang.String r0 = "cdma"
            r4.f5700bn = r0
            boolean r0 = r4.f5670bE     // Catch:{ Exception -> 0x005e }
            if (r0 == 0) goto L_0x0043
            android.telephony.CellLocation r5 = r5.getCellLocation()     // Catch:{ Exception -> 0x005e }
            java.lang.Class<android.telephony.cdma.CdmaCellLocation> r0 = android.telephony.cdma.CdmaCellLocation.class
            java.lang.Object r5 = lib.android.paypal.com.magnessdk.C4825c.m4655a((java.lang.Object) r5, r0)     // Catch:{ Exception -> 0x005e }
            r2 = r5
            android.telephony.cdma.CdmaCellLocation r2 = (android.telephony.cdma.CdmaCellLocation) r2     // Catch:{ Exception -> 0x005e }
        L_0x0043:
            r4.f5681bP = r2     // Catch:{ Exception -> 0x005e }
            goto L_0x006a
        L_0x0046:
            java.lang.String r0 = "gsm"
            r4.f5700bn = r0
            boolean r0 = r4.f5670bE     // Catch:{ Exception -> 0x005e }
            if (r0 == 0) goto L_0x005b
            android.telephony.CellLocation r5 = r5.getCellLocation()     // Catch:{ Exception -> 0x005e }
            java.lang.Class<android.telephony.gsm.GsmCellLocation> r0 = android.telephony.gsm.GsmCellLocation.class
            java.lang.Object r5 = lib.android.paypal.com.magnessdk.C4825c.m4655a((java.lang.Object) r5, r0)     // Catch:{ Exception -> 0x005e }
            r2 = r5
            android.telephony.gsm.GsmCellLocation r2 = (android.telephony.gsm.GsmCellLocation) r2     // Catch:{ Exception -> 0x005e }
        L_0x005b:
            r4.f5680bO = r2     // Catch:{ Exception -> 0x005e }
            goto L_0x006a
        L_0x005e:
            r5 = move-exception
            java.lang.Class r0 = r4.getClass()
            lib.android.paypal.com.magnessdk.p059b.C4823a.m4654a((java.lang.Class<?>) r0, (int) r3, (java.lang.Throwable) r5)
            goto L_0x006a
        L_0x0067:
            java.lang.String r5 = "none"
            goto L_0x002b
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.C4832f.m4701a(android.telephony.TelephonyManager):void");
    }

    /* renamed from: b */
    private String m4702b(Context context) {
        int i = context.getSharedPreferences(f5656aQ, 0).getInt(f5656aQ, 0);
        return i + "";
    }

    /* renamed from: b */
    private String m4703b(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getSimOperatorName();
        } catch (Exception e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
            return null;
        }
    }

    /* renamed from: b */
    static C4832f m4704b() {
        if (f5658aS == null) {
            f5658aS = new C4832f();
            C4823a.m4653a((Class<?>) C4832f.class, 0, "creating RiskBlobDynamicData instance");
        }
        return f5658aS;
    }

    /* renamed from: b */
    private void m4705b(JSONObject jSONObject) {
        Map<String, String> map = this.f5677bL;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                try {
                    jSONObject.put((String) next.getKey(), next.getValue());
                } catch (Exception e) {
                    C4823a.m4654a(getClass(), 3, (Throwable) e);
                }
            }
        }
    }

    /* renamed from: c */
    private String m4706c() {
        List<String> a = m4699a(false);
        if (a == null) {
            return null;
        }
        return a.get(0);
    }

    /* renamed from: c */
    private void m4707c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f5656aQ, 0);
        int i = sharedPreferences.getInt(f5656aQ, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i2 = 1;
        if (i > 0 && i < Integer.MAX_VALUE) {
            i2 = 1 + i;
        }
        edit.putInt(f5656aQ, i2);
        edit.apply();
    }

    /* renamed from: d */
    private String m4708d() {
        String property;
        String property2 = System.getProperty("http.proxyHost");
        if (property2 == null || (property = System.getProperty("http.proxyPort")) == null) {
            return null;
        }
        return "host=" + property2 + ",port=" + property;
    }

    /* renamed from: e */
    private String m4709e() {
        try {
            Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp()) {
                    if (networkInterface.getInterfaceAddresses().size() != 0) {
                        String name = networkInterface.getName();
                        if (name.startsWith("ppp") || name.startsWith("tun") || name.startsWith("tap")) {
                            return name;
                        }
                    }
                }
            }
            return null;
        } catch (Exception e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
            return null;
        }
    }

    /* renamed from: f */
    private String m4710f() {
        C4819a aVar = new C4819a();
        aVar.mo68908a(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.ebay.lid/");
        try {
            if (this.f5673bH || this.f5672bG) {
                return aVar.mo68910b("fb.bin");
            }
            return null;
        } catch (FileNotFoundException unused) {
            if (!this.f5673bH) {
                return null;
            }
            String a = C4825c.m4657a(Boolean.TRUE.booleanValue());
            aVar.mo68909a("fb.bin", a.getBytes("UTF-8"));
            return a;
        } catch (IOException e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
            return null;
        }
    }

    /* renamed from: g */
    private String m4711g() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5670bE ? 1 : 0);
        sb.append(this.f5671bF ? 1 : 0);
        sb.append(this.f5674bI ? 1 : 0);
        sb.append(this.f5675bJ ? 1 : 0);
        sb.append(this.f5672bG ? 1 : 0);
        sb.append(this.f5673bH ? 1 : 0);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo68913a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Integer num = null;
            jSONObject.put("base_station_id", this.f5659aT == -1 ? null : Integer.valueOf(this.f5659aT));
            jSONObject.put("bssid", this.f5665aZ);
            jSONObject.put("bssid_array", this.f5712bz == null ? null : new JSONArray(this.f5712bz));
            jSONObject.put("cell_id", this.f5660aU == -1 ? null : Integer.valueOf(this.f5660aU));
            jSONObject.put("conn_type", this.f5694bh);
            jSONObject.put("conf_version", this.f5705bs);
            jSONObject.put("device_id", this.f5695bi);
            jSONObject.put("dc_id", this.f5693bg);
            jSONObject.put("device_uptime", this.f5667bB == -1 ? null : Long.valueOf(this.f5667bB));
            jSONObject.put("ip_addrs", this.f5696bj);
            jSONObject.put("ip_addresses", this.f5710bx == null ? null : new JSONArray(this.f5710bx));
            jSONObject.put("known_apps", this.f5711by == null ? null : new JSONArray(this.f5711by));
            jSONObject.put("locale_country", this.f5698bl);
            jSONObject.put("locale_lang", this.f5699bm);
            jSONObject.put("location", m4700a(this.f5686bU));
            jSONObject.put("location_area_code", this.f5664aY == -1 ? null : Integer.valueOf(this.f5664aY));
            jSONObject.put("phone_type", this.f5700bn);
            jSONObject.put("risk_comp_session_id", this.f5701bo);
            jSONObject.put("roaming", this.f5668bC);
            jSONObject.put("sim_operator_name", this.f5708bv);
            jSONObject.put("sim_serial_number", this.f5702bp);
            jSONObject.put("ssid", this.f5703bq);
            jSONObject.put("cdma_network_id", this.f5663aX == -1 ? null : Integer.valueOf(this.f5663aX));
            if (this.f5662aW != -1) {
                num = Integer.valueOf(this.f5662aW);
            }
            jSONObject.put("cdma_system_id", num);
            jSONObject.put("subscriber_id", this.f5704br);
            jSONObject.put("timestamp", this.f5666bA);
            jSONObject.put("tz_name", this.f5697bk);
            jSONObject.put("ds", this.f5669bD);
            jSONObject.put("tz", this.f5661aV);
            jSONObject.put("network_operator", this.f5687ba);
            jSONObject.put("pairing_id", this.f5688bb);
            jSONObject.put("serial_number", this.f5689bc);
            jSONObject.put("VPN_setting", this.f5691be);
            jSONObject.put("proxy_setting", this.f5690bd);
            jSONObject.put("c", this.f5692bf);
            jSONObject.put("mg_id", this.f5706bt);
            jSONObject.put("linker_id", this.f5707bu);
            jSONObject.put("pl", this.f5709bw);
            m4705b(jSONObject);
            return jSONObject;
        } catch (Exception e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
            return jSONObject;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo68914a(Context context) {
        return mo68920a(context, (String) null, (HashMap<String, String>) null);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    /* renamed from: a */
    public JSONObject mo68920a(Context context, String str, HashMap<String, String> hashMap) {
        C4823a.m4653a(getClass(), 0, "collecting RiskBlobDynamicData");
        boolean z = true;
        if (!this.f5676bK) {
            this.f5682bQ = (TelephonyManager) context.getSystemService("phone");
            this.f5683bR = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            this.f5685bT = (LocationManager) context.getSystemService("location");
            this.f5684bS = (ConnectivityManager) context.getSystemService("connectivity");
            this.f5676bK = true;
        }
        if (!mo68917a(context, "android.permission.ACCESS_COARSE_LOCATION") && !mo68917a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            z = false;
        }
        this.f5670bE = z;
        this.f5672bG = mo68917a(context, "android.permission.READ_EXTERNAL_STORAGE");
        this.f5673bH = mo68917a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        this.f5671bF = mo68917a(context, "android.permission.READ_PHONE_STATE");
        this.f5675bJ = mo68917a(context, "android.permission.ACCESS_NETWORK_STATE");
        this.f5674bI = mo68917a(context, "android.permission.ACCESS_WIFI_STATE");
        this.f5677bL = hashMap;
        this.f5666bA = System.currentTimeMillis();
        this.f5705bs = MagnesSDK.getInstance().f5503a.mo68937a();
        this.f5688bb = str;
        if (this.f5688bb == null) {
            this.f5688bb = C4825c.m4657a(false);
        }
        m4701a(this.f5682bQ);
        WifiManager wifiManager = this.f5683bR;
        NetworkInfo networkInfo = null;
        if (wifiManager != null) {
            this.f5679bN = this.f5674bI ? wifiManager.getConnectionInfo() : null;
        }
        ConnectivityManager connectivityManager = this.f5684bS;
        if (connectivityManager != null) {
            if (this.f5675bJ) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            this.f5678bM = networkInfo;
        }
        mo68916a(82, context);
        mo68916a(81, context);
        mo68916a(16, context);
        mo68916a(21, context);
        mo68916a(75, context);
        mo68916a(23, context);
        mo68916a(27, context);
        mo68916a(28, context);
        mo68916a(25, context);
        mo68916a(56, context);
        mo68916a(72, context);
        mo68916a(42, context);
        mo68916a(43, context);
        mo68916a(45, context);
        mo68916a(53, context);
        mo68916a(80, context);
        mo68916a(71, context);
        mo68916a(4, context);
        mo68916a(57, context);
        mo68916a(58, context);
        mo68916a(6, context);
        mo68916a(30, context);
        mo68916a(29, context);
        mo68916a(13, context);
        mo68916a(68, context);
        mo68916a(49, context);
        mo68916a(84, context);
        mo68916a(5, context);
        mo68916a(48, context);
        mo68916a(11, context);
        mo68916a(85, context);
        mo68916a(46, context);
        mo68916a(79, context);
        mo68916a(87, context);
        return mo68913a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: android.location.Location} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v9, types: [java.util.List<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"MissingPermission,HardwareIds"})
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo68916a(int r9, android.content.Context r10) {
        /*
            r8 = this;
            r0 = 4
            r1 = 3
            r2 = -1
            if (r9 == r0) goto L_0x02a7
            r0 = 5
            r3 = 0
            if (r9 == r0) goto L_0x0299
            r0 = 6
            if (r9 == r0) goto L_0x028b
            r0 = 11
            if (r9 == r0) goto L_0x027d
            r0 = 13
            if (r9 == r0) goto L_0x026c
            r0 = 16
            if (r9 == r0) goto L_0x0265
            r0 = 21
            if (r9 == r0) goto L_0x025e
            r0 = 23
            if (r9 == r0) goto L_0x020a
            r0 = 25
            if (r9 == r0) goto L_0x0202
            r0 = 53
            r4 = 1
            if (r9 == r0) goto L_0x01e7
            r0 = 68
            if (r9 == r0) goto L_0x01ce
            r0 = 75
            if (r9 == r0) goto L_0x01c6
            r0 = 87
            if (r9 == r0) goto L_0x01be
            r0 = 42
            if (r9 == r0) goto L_0x01b6
            r0 = 43
            if (r9 == r0) goto L_0x01a9
            r0 = 45
            if (r9 == r0) goto L_0x019a
            r0 = 46
            if (r9 == r0) goto L_0x0188
            r0 = 48
            if (r9 == r0) goto L_0x0179
            r0 = 49
            if (r9 == r0) goto L_0x0167
            r0 = 71
            if (r9 == r0) goto L_0x015f
            r0 = 72
            if (r9 == r0) goto L_0x0157
            r0 = 84
            if (r9 == r0) goto L_0x0149
            r0 = 85
            if (r9 == r0) goto L_0x012c
            switch(r9) {
                case 27: goto L_0x0120;
                case 28: goto L_0x0114;
                case 29: goto L_0x0106;
                case 30: goto L_0x00f7;
                default: goto L_0x0060;
            }
        L_0x0060:
            switch(r9) {
                case 56: goto L_0x00e8;
                case 57: goto L_0x00d9;
                case 58: goto L_0x00ca;
                default: goto L_0x0063;
            }
        L_0x0063:
            switch(r9) {
                case 79: goto L_0x00b9;
                case 80: goto L_0x00a4;
                case 81: goto L_0x0085;
                case 82: goto L_0x0068;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x02bd
        L_0x0068:
            lib.android.paypal.com.magnessdk.MagnesSDK r9 = lib.android.paypal.com.magnessdk.MagnesSDK.getInstance()     // Catch:{ Exception -> 0x02b5 }
            lib.android.paypal.com.magnessdk.MagnesSettings r9 = r9.f5504b     // Catch:{ Exception -> 0x02b5 }
            int r9 = r9.getMagnesSource()     // Catch:{ Exception -> 0x02b5 }
            lib.android.paypal.com.magnessdk.MagnesSource r0 = lib.android.paypal.com.magnessdk.MagnesSource.PAYPAL     // Catch:{ Exception -> 0x02b5 }
            int r0 = r0.getVersion()     // Catch:{ Exception -> 0x02b5 }
            if (r9 != r0) goto L_0x02bd
            r8.m4707c(r10)     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r9 = r8.m4702b((android.content.Context) r10)     // Catch:{ Exception -> 0x02b5 }
            r8.f5692bf = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0085:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b5 }
            r9.<init>()     // Catch:{ Exception -> 0x02b5 }
            lib.android.paypal.com.magnessdk.e r10 = lib.android.paypal.com.magnessdk.C4829e.m4668b()     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r10 = r10.f5625aJ     // Catch:{ Exception -> 0x02b5 }
            r9.append(r10)     // Catch:{ Exception -> 0x02b5 }
            long r2 = r8.f5666bA     // Catch:{ Exception -> 0x02b5 }
            r9.append(r2)     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r9 = r8.m4696a((java.lang.String) r9)     // Catch:{ Exception -> 0x02b5 }
            r8.f5693bg = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x00a4:
            java.util.TimeZone r9 = java.util.TimeZone.getDefault()     // Catch:{ Exception -> 0x02b5 }
            java.util.Date r10 = new java.util.Date     // Catch:{ Exception -> 0x02b5 }
            r10.<init>()     // Catch:{ Exception -> 0x02b5 }
            long r2 = r10.getTime()     // Catch:{ Exception -> 0x02b5 }
            int r9 = r9.getOffset(r2)     // Catch:{ Exception -> 0x02b5 }
            r8.f5661aV = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x00b9:
            java.util.TimeZone r9 = java.util.TimeZone.getDefault()     // Catch:{ Exception -> 0x02b5 }
            java.util.Date r10 = new java.util.Date     // Catch:{ Exception -> 0x02b5 }
            r10.<init>()     // Catch:{ Exception -> 0x02b5 }
            boolean r9 = r9.inDaylightTime(r10)     // Catch:{ Exception -> 0x02b5 }
            r8.f5669bD = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x00ca:
            android.telephony.cdma.CdmaCellLocation r9 = r8.f5681bP     // Catch:{ Exception -> 0x02b5 }
            if (r9 != 0) goto L_0x00cf
            goto L_0x00d5
        L_0x00cf:
            android.telephony.cdma.CdmaCellLocation r9 = r8.f5681bP     // Catch:{ Exception -> 0x02b5 }
            int r2 = r9.getSystemId()     // Catch:{ Exception -> 0x02b5 }
        L_0x00d5:
            r8.f5662aW = r2     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x00d9:
            android.telephony.cdma.CdmaCellLocation r9 = r8.f5681bP     // Catch:{ Exception -> 0x02b5 }
            if (r9 != 0) goto L_0x00de
            goto L_0x00e4
        L_0x00de:
            android.telephony.cdma.CdmaCellLocation r9 = r8.f5681bP     // Catch:{ Exception -> 0x02b5 }
            int r2 = r9.getNetworkId()     // Catch:{ Exception -> 0x02b5 }
        L_0x00e4:
            r8.f5663aX = r2     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x00e8:
            android.telephony.TelephonyManager r9 = r8.f5682bQ     // Catch:{ Exception -> 0x02b5 }
            if (r9 != 0) goto L_0x00ed
            goto L_0x00f3
        L_0x00ed:
            android.telephony.TelephonyManager r9 = r8.f5682bQ     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r3 = r9.getNetworkOperator()     // Catch:{ Exception -> 0x02b5 }
        L_0x00f3:
            r8.f5687ba = r3     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x00f7:
            android.telephony.gsm.GsmCellLocation r9 = r8.f5680bO     // Catch:{ Exception -> 0x02b5 }
            if (r9 != 0) goto L_0x00fc
            goto L_0x0102
        L_0x00fc:
            android.telephony.gsm.GsmCellLocation r9 = r8.f5680bO     // Catch:{ Exception -> 0x02b5 }
            int r2 = r9.getLac()     // Catch:{ Exception -> 0x02b5 }
        L_0x0102:
            r8.f5664aY = r2     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0106:
            boolean r9 = r8.f5670bE     // Catch:{ Exception -> 0x02b5 }
            if (r9 == 0) goto L_0x0110
            android.location.LocationManager r9 = r8.f5685bT     // Catch:{ Exception -> 0x02b5 }
            android.location.Location r3 = r8.m4695a((android.location.LocationManager) r9)     // Catch:{ Exception -> 0x02b5 }
        L_0x0110:
            r8.f5686bU = r3     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0114:
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r9 = r9.getLanguage()     // Catch:{ Exception -> 0x02b5 }
            r8.f5699bm = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0120:
            java.util.Locale r9 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r9 = r9.getCountry()     // Catch:{ Exception -> 0x02b5 }
            r8.f5698bl = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x012c:
            lib.android.paypal.com.magnessdk.e r9 = lib.android.paypal.com.magnessdk.C4829e.m4668b()     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r3 = r9.f5625aJ     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r4 = r8.f5688bb     // Catch:{ Exception -> 0x02b5 }
            long r5 = r8.f5666bA     // Catch:{ Exception -> 0x02b5 }
            lib.android.paypal.com.magnessdk.MagnesSDK r9 = lib.android.paypal.com.magnessdk.MagnesSDK.getInstance()     // Catch:{ Exception -> 0x02b5 }
            lib.android.paypal.com.magnessdk.network.i r9 = r9.f5503a     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r7 = r9.mo68940c()     // Catch:{ Exception -> 0x02b5 }
            r2 = r8
            java.lang.String r9 = r2.m4697a(r3, r4, r5, r7)     // Catch:{ Exception -> 0x02b5 }
            r8.f5706bt = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0149:
            boolean r9 = r8.f5670bE     // Catch:{ Exception -> 0x02b5 }
            if (r9 == 0) goto L_0x0153
            android.net.wifi.WifiManager r9 = r8.f5683bR     // Catch:{ Exception -> 0x02b5 }
            java.util.ArrayList r3 = r8.m4698a((android.net.wifi.WifiManager) r9)     // Catch:{ Exception -> 0x02b5 }
        L_0x0153:
            r8.f5712bz = r3     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0157:
            java.lang.String r9 = r8.m4708d()     // Catch:{ Exception -> 0x02b5 }
            r8.f5690bd = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x015f:
            java.lang.String r9 = r8.m4709e()     // Catch:{ Exception -> 0x02b5 }
            r8.f5691be = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0167:
            boolean r9 = r8.f5671bF     // Catch:{ Exception -> 0x02b5 }
            if (r9 == 0) goto L_0x02bd
            android.telephony.TelephonyManager r9 = r8.f5682bQ     // Catch:{ Exception -> 0x02b5 }
            if (r9 == 0) goto L_0x02bd
            android.telephony.TelephonyManager r9 = r8.f5682bQ     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r9 = r9.getSubscriberId()     // Catch:{ Exception -> 0x02b5 }
            r8.f5704br = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0179:
            android.net.wifi.WifiInfo r9 = r8.f5679bN     // Catch:{ Exception -> 0x02b5 }
            if (r9 != 0) goto L_0x017e
            goto L_0x0184
        L_0x017e:
            android.net.wifi.WifiInfo r9 = r8.f5679bN     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r3 = r9.getSSID()     // Catch:{ Exception -> 0x02b5 }
        L_0x0184:
            r8.f5703bq = r3     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0188:
            boolean r9 = r8.f5671bF     // Catch:{ Exception -> 0x02b5 }
            if (r9 == 0) goto L_0x02bd
            android.telephony.TelephonyManager r9 = r8.f5682bQ     // Catch:{ Exception -> 0x02b5 }
            if (r9 == 0) goto L_0x02bd
            android.telephony.TelephonyManager r9 = r8.f5682bQ     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r9 = r9.getSimSerialNumber()     // Catch:{ Exception -> 0x02b5 }
            r8.f5702bp = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x019a:
            android.telephony.TelephonyManager r9 = r8.f5682bQ     // Catch:{ Exception -> 0x02b5 }
            if (r9 != 0) goto L_0x019f
            goto L_0x01a5
        L_0x019f:
            android.telephony.TelephonyManager r9 = r8.f5682bQ     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r3 = r8.m4703b((android.telephony.TelephonyManager) r9)     // Catch:{ Exception -> 0x02b5 }
        L_0x01a5:
            r8.f5708bv = r3     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x01a9:
            android.telephony.ServiceState r9 = new android.telephony.ServiceState     // Catch:{ Exception -> 0x02b5 }
            r9.<init>()     // Catch:{ Exception -> 0x02b5 }
            boolean r9 = r9.getRoaming()     // Catch:{ Exception -> 0x02b5 }
            r8.f5668bC = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x01b6:
            java.lang.String r9 = lib.android.paypal.com.magnessdk.C4825c.m4657a((boolean) r4)     // Catch:{ Exception -> 0x02b5 }
            r8.f5701bo = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x01be:
            java.lang.String r9 = r8.m4711g()     // Catch:{ Exception -> 0x02b5 }
            r8.f5709bw = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x01c6:
            java.util.List r9 = r8.m4699a((boolean) r4)     // Catch:{ Exception -> 0x02b5 }
            r8.f5710bx = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x01ce:
            boolean r9 = r8.f5671bF     // Catch:{ Exception -> 0x02b5 }
            if (r9 == 0) goto L_0x02bd
            android.telephony.TelephonyManager r9 = r8.f5682bQ     // Catch:{ Exception -> 0x02b5 }
            if (r9 == 0) goto L_0x02bd
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x02b5 }
            r10 = 26
            if (r9 < r10) goto L_0x01e4
            java.lang.String r9 = android.os.Build.getSerial()     // Catch:{ Exception -> 0x02b5 }
        L_0x01e0:
            r8.f5689bc = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x01e4:
            java.lang.String r9 = android.os.Build.SERIAL     // Catch:{ Exception -> 0x02b5 }
            goto L_0x01e0
        L_0x01e7:
            java.util.TimeZone r9 = java.util.TimeZone.getDefault()     // Catch:{ Exception -> 0x02b5 }
            java.util.TimeZone r10 = java.util.TimeZone.getDefault()     // Catch:{ Exception -> 0x02b5 }
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x02b5 }
            r0.<init>()     // Catch:{ Exception -> 0x02b5 }
            boolean r10 = r10.inDaylightTime(r0)     // Catch:{ Exception -> 0x02b5 }
            java.util.Locale r0 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r9 = r9.getDisplayName(r10, r4, r0)     // Catch:{ Exception -> 0x02b5 }
            r8.f5697bk = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0202:
            java.lang.String r9 = r8.m4710f()     // Catch:{ Exception -> 0x02b5 }
            r8.f5707bu = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x020a:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x02b5 }
            r9.<init>()     // Catch:{ Exception -> 0x02b5 }
            lib.android.paypal.com.magnessdk.MagnesSDK r0 = lib.android.paypal.com.magnessdk.MagnesSDK.getInstance()     // Catch:{ Exception -> 0x02b5 }
            lib.android.paypal.com.magnessdk.network.i r0 = r0.f5503a     // Catch:{ Exception -> 0x02b5 }
            if (r0 == 0) goto L_0x0254
            lib.android.paypal.com.magnessdk.MagnesSDK r0 = lib.android.paypal.com.magnessdk.MagnesSDK.getInstance()     // Catch:{ Exception -> 0x02b5 }
            lib.android.paypal.com.magnessdk.network.i r0 = r0.f5503a     // Catch:{ Exception -> 0x02b5 }
            java.util.List r0 = r0.mo68939b()     // Catch:{ Exception -> 0x02b5 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x024c }
        L_0x0225:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x024c }
            if (r2 == 0) goto L_0x0254
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x024c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x024c }
            android.content.pm.PackageManager r4 = r10.getPackageManager()     // Catch:{ Exception -> 0x024c }
            android.content.Intent r5 = new android.content.Intent     // Catch:{ Exception -> 0x024c }
            r5.<init>()     // Catch:{ Exception -> 0x024c }
            android.content.ComponentName r6 = android.content.ComponentName.unflattenFromString(r2)     // Catch:{ Exception -> 0x024c }
            android.content.Intent r5 = r5.setComponent(r6)     // Catch:{ Exception -> 0x024c }
            boolean r4 = lib.android.paypal.com.magnessdk.C4825c.m4659a((android.content.pm.PackageManager) r4, (android.content.Intent) r5)     // Catch:{ Exception -> 0x024c }
            if (r4 == 0) goto L_0x0225
            r9.add(r2)     // Catch:{ Exception -> 0x024c }
            goto L_0x0225
        L_0x024c:
            r10 = move-exception
            java.lang.Class r0 = r8.getClass()     // Catch:{ Exception -> 0x02b5 }
            lib.android.paypal.com.magnessdk.p059b.C4823a.m4654a((java.lang.Class<?>) r0, (int) r1, (java.lang.Throwable) r10)     // Catch:{ Exception -> 0x02b5 }
        L_0x0254:
            int r10 = r9.size()     // Catch:{ Exception -> 0x02b5 }
            if (r10 != 0) goto L_0x025b
            r9 = r3
        L_0x025b:
            r8.f5711by = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x025e:
            java.lang.String r9 = r8.m4706c()     // Catch:{ Exception -> 0x02b5 }
            r8.f5696bj = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0265:
            long r9 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x02b5 }
            r8.f5667bB = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x026c:
            boolean r9 = r8.f5671bF     // Catch:{ Exception -> 0x02b5 }
            if (r9 == 0) goto L_0x02bd
            android.telephony.TelephonyManager r9 = r8.f5682bQ     // Catch:{ Exception -> 0x02b5 }
            if (r9 == 0) goto L_0x02bd
            android.telephony.TelephonyManager r9 = r8.f5682bQ     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r9 = r9.getDeviceId()     // Catch:{ Exception -> 0x02b5 }
            r8.f5695bi = r9     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x027d:
            android.net.NetworkInfo r9 = r8.f5678bM     // Catch:{ Exception -> 0x02b5 }
            if (r9 != 0) goto L_0x0282
            goto L_0x0288
        L_0x0282:
            android.net.NetworkInfo r9 = r8.f5678bM     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r3 = r9.getTypeName()     // Catch:{ Exception -> 0x02b5 }
        L_0x0288:
            r8.f5694bh = r3     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x028b:
            android.telephony.gsm.GsmCellLocation r9 = r8.f5680bO     // Catch:{ Exception -> 0x02b5 }
            if (r9 != 0) goto L_0x0290
            goto L_0x0296
        L_0x0290:
            android.telephony.gsm.GsmCellLocation r9 = r8.f5680bO     // Catch:{ Exception -> 0x02b5 }
            int r2 = r9.getCid()     // Catch:{ Exception -> 0x02b5 }
        L_0x0296:
            r8.f5660aU = r2     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x0299:
            android.net.wifi.WifiInfo r9 = r8.f5679bN     // Catch:{ Exception -> 0x02b5 }
            if (r9 != 0) goto L_0x029e
            goto L_0x02a4
        L_0x029e:
            android.net.wifi.WifiInfo r9 = r8.f5679bN     // Catch:{ Exception -> 0x02b5 }
            java.lang.String r3 = r9.getBSSID()     // Catch:{ Exception -> 0x02b5 }
        L_0x02a4:
            r8.f5665aZ = r3     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x02a7:
            android.telephony.cdma.CdmaCellLocation r9 = r8.f5681bP     // Catch:{ Exception -> 0x02b5 }
            if (r9 != 0) goto L_0x02ac
            goto L_0x02b2
        L_0x02ac:
            android.telephony.cdma.CdmaCellLocation r9 = r8.f5681bP     // Catch:{ Exception -> 0x02b5 }
            int r2 = r9.getBaseStationId()     // Catch:{ Exception -> 0x02b5 }
        L_0x02b2:
            r8.f5659aT = r2     // Catch:{ Exception -> 0x02b5 }
            goto L_0x02bd
        L_0x02b5:
            r9 = move-exception
            java.lang.Class r10 = r8.getClass()
            lib.android.paypal.com.magnessdk.p059b.C4823a.m4654a((java.lang.Class<?>) r10, (int) r1, (java.lang.Throwable) r9)
        L_0x02bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lib.android.paypal.com.magnessdk.C4832f.mo68916a(int, android.content.Context):void");
    }
}
