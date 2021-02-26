package com.google.android.gms.appinvite;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import java.util.ArrayList;

@KeepForSdkWithMembers
public class PreviewActivity extends Activity {
    public static final String ACTION_PREVIEW = "com.google.android.gms.appinvite.ACTION_PREVIEW";
    public static final String EXTRA_LAYOUT_RES_ID = "com.google.android.gms.appinvite.LAYOUT_RES_ID";
    public static final String EXTRA_TABS = "com.google.android.gms.appinvite.TABS";
    public static final String EXTRA_VIEWS = "com.google.android.gms.appinvite.VIEWS";
    public static final String KEY_TAB_CONTENT_ID = "tabContentId";
    public static final String KEY_TAB_TAG = "tabTag";
    public static final String KEY_TEXT_VIEW_IS_TITLE = "TextView_isTitle";
    public static final String KEY_TEXT_VIEW_TEXT = "TextView_text";
    public static final String KEY_TEXT_VIEW_TEXT_COLOR = "TextView_textColor";
    public static final String KEY_VIEW_BACKGROUND_COLOR = "View_backgroundColor";
    public static final String KEY_VIEW_ID = "View_id";
    public static final String KEY_VIEW_MIN_HEIGHT = "View_minHeight";
    public static final String KEY_VIEW_ON_CLICK_LISTENER = "View_onClickListener";
    public static final String KEY_WEB_VIEW_DATA = "WebView_data";
    public static final String ON_CLICK_LISTENER_CLOSE = "close";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getCallingActivity() == null || !"com.google.android.gms".equals(getCallingActivity().getPackageName())) {
            finish();
            return;
        }
        int i = 0;
        try {
            Context createPackageContext = createPackageContext("com.google.android.gms", 0);
            Bundle extras = getIntent().getExtras();
            View zza = zza(createPackageContext, (ViewGroup) null, extras);
            if (zza == null) {
                finish();
                return;
            }
            TabHost tabHost = (TabHost) zza.findViewById(16908306);
            TabWidget tabWidget = (TabWidget) zza.findViewById(16908307);
            ArrayList parcelableArrayList = extras.getParcelableArrayList(EXTRA_TABS);
            if (!(tabHost == null || tabWidget == null || parcelableArrayList == null)) {
                tabHost.setup();
                ArrayList arrayList = parcelableArrayList;
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    Bundle bundle2 = (Bundle) obj;
                    TabHost.TabSpec newTabSpec = tabHost.newTabSpec(bundle2.getString(KEY_TAB_TAG));
                    newTabSpec.setContent(bundle2.getInt(KEY_TAB_CONTENT_ID));
                    newTabSpec.setIndicator(zza(createPackageContext, tabWidget, bundle2));
                    tabHost.addTab(newTabSpec);
                }
            }
            setContentView(zza);
        } catch (PackageManager.NameNotFoundException unused) {
            finish();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.View zza(android.content.Context r11, android.view.ViewGroup r12, android.os.Bundle r13) {
        /*
            r10 = this;
            java.lang.String r0 = "com.google.android.gms.appinvite.LAYOUT_RES_ID"
            int r0 = r13.getInt(r0)
            android.view.LayoutInflater r11 = android.view.LayoutInflater.from(r11)
            r1 = 0
            android.view.View r11 = r11.inflate(r0, r12, r1)
            java.lang.String r12 = "com.google.android.gms.appinvite.VIEWS"
            java.util.ArrayList r12 = r13.getParcelableArrayList(r12)
            if (r12 == 0) goto L_0x0127
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            int r13 = r12.size()
            r0 = 0
        L_0x001e:
            if (r0 >= r13) goto L_0x0127
            java.lang.Object r2 = r12.get(r0)
            int r0 = r0 + 1
            android.os.Bundle r2 = (android.os.Bundle) r2
            java.lang.String r3 = "View_id"
            int r3 = r2.getInt(r3)
            android.view.View r3 = r11.findViewById(r3)
            java.util.Set r4 = r2.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x003a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x001e
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            int r6 = r5.hashCode()
            r7 = -1
            switch(r6) {
                case -1829808865: goto L_0x008b;
                case -499175494: goto L_0x0081;
                case -111184848: goto L_0x0077;
                case 573559753: goto L_0x006d;
                case 966644059: goto L_0x0063;
                case 1729346977: goto L_0x0059;
                case 1920443715: goto L_0x004f;
                default: goto L_0x004e;
            }
        L_0x004e:
            goto L_0x0095
        L_0x004f:
            java.lang.String r6 = "View_onClickListener"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0095
            r6 = 2
            goto L_0x0096
        L_0x0059:
            java.lang.String r6 = "TextView_isTitle"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0095
            r6 = 5
            goto L_0x0096
        L_0x0063:
            java.lang.String r6 = "View_backgroundColor"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0095
            r6 = 0
            goto L_0x0096
        L_0x006d:
            java.lang.String r6 = "TextView_textColor"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0095
            r6 = 4
            goto L_0x0096
        L_0x0077:
            java.lang.String r6 = "WebView_data"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0095
            r6 = 6
            goto L_0x0096
        L_0x0081:
            java.lang.String r6 = "TextView_text"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0095
            r6 = 3
            goto L_0x0096
        L_0x008b:
            java.lang.String r6 = "View_minHeight"
            boolean r6 = r5.equals(r6)
            if (r6 == 0) goto L_0x0095
            r6 = 1
            goto L_0x0096
        L_0x0095:
            r6 = -1
        L_0x0096:
            switch(r6) {
                case 0: goto L_0x011e;
                case 1: goto L_0x0115;
                case 2: goto L_0x00f0;
                case 3: goto L_0x00e0;
                case 4: goto L_0x00d0;
                case 5: goto L_0x00ba;
                case 6: goto L_0x009a;
                default: goto L_0x0099;
            }
        L_0x0099:
            goto L_0x003a
        L_0x009a:
            boolean r6 = r3 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x003a
            android.webkit.WebView r6 = new android.webkit.WebView
            r6.<init>(r10)
            java.lang.String r5 = r2.getString(r5)
            java.lang.String r8 = "text/html; charset=utf-8"
            java.lang.String r9 = "UTF-8"
            r6.loadData(r5, r8, r9)
            r5 = r3
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            android.view.ViewGroup$LayoutParams r8 = new android.view.ViewGroup$LayoutParams
            r8.<init>(r7, r7)
            r5.addView(r6, r8)
            goto L_0x003a
        L_0x00ba:
            boolean r6 = r3 instanceof android.widget.TextView
            if (r6 == 0) goto L_0x003a
            boolean r5 = r2.getBoolean(r5)
            if (r5 == 0) goto L_0x003a
            r5 = r3
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.CharSequence r5 = r5.getText()
            r10.setTitle(r5)
            goto L_0x003a
        L_0x00d0:
            boolean r6 = r3 instanceof android.widget.TextView
            if (r6 == 0) goto L_0x003a
            r6 = r3
            android.widget.TextView r6 = (android.widget.TextView) r6
            int r5 = r2.getInt(r5)
            r6.setTextColor(r5)
            goto L_0x003a
        L_0x00e0:
            boolean r6 = r3 instanceof android.widget.TextView
            if (r6 == 0) goto L_0x003a
            r6 = r3
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.CharSequence r5 = r2.getCharSequence(r5)
            r6.setText(r5)
            goto L_0x003a
        L_0x00f0:
            java.lang.String r5 = r2.getString(r5)
            int r6 = r5.hashCode()
            r8 = 94756344(0x5a5ddf8, float:1.5598064E-35)
            if (r6 == r8) goto L_0x00fe
            goto L_0x0107
        L_0x00fe:
            java.lang.String r6 = "close"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0107
            r7 = 0
        L_0x0107:
            if (r7 == 0) goto L_0x010b
            goto L_0x003a
        L_0x010b:
            com.google.android.gms.appinvite.zzb r5 = new com.google.android.gms.appinvite.zzb
            r5.<init>(r10)
            r3.setOnClickListener(r5)
            goto L_0x003a
        L_0x0115:
            int r5 = r2.getInt(r5)
            r3.setMinimumHeight(r5)
            goto L_0x003a
        L_0x011e:
            int r5 = r2.getInt(r5)
            r3.setBackgroundColor(r5)
            goto L_0x003a
        L_0x0127:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.appinvite.PreviewActivity.zza(android.content.Context, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }
}
