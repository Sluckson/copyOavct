package com.salesforce.marketingcloud.messages;

import android.annotation.SuppressLint;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.location.LatLon;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.messages.f */
public interface C4080f {

    /* renamed from: com.salesforce.marketingcloud.messages.f$a */
    public interface C4081a {
        /* renamed from: a */
        void mo56718a(Region region);

        /* renamed from: a */
        void mo56719a(Region region, Message message);

        /* renamed from: b */
        void mo56720b(Region region);
    }

    /* renamed from: com.salesforce.marketingcloud.messages.f$b */
    public interface C4082b {
        /* renamed from: a */
        void mo56721a(MessageResponse messageResponse);
    }

    /* renamed from: a */
    void mo56714a();

    /* renamed from: a */
    void mo56715a(LatLon latLon, String str, MarketingCloudConfig marketingCloudConfig, C4082b bVar);

    /* renamed from: b */
    void mo56716b();

    /* renamed from: c */
    void mo56717c();
}
