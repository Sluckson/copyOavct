package com.iaai.android.bdt.feature.landing;

import android.location.Address;
import android.location.Location;
import com.google.android.gms.tasks.OnSuccessListener;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "location", "Landroid/location/Location;", "onSuccess"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTLandingPageActivity.kt */
final class BDTLandingPageActivity$getLastLocation$1<TResult> implements OnSuccessListener<Location> {
    final /* synthetic */ BDTLandingPageActivity this$0;

    BDTLandingPageActivity$getLastLocation$1(BDTLandingPageActivity bDTLandingPageActivity) {
        this.this$0 = bDTLandingPageActivity;
    }

    public final void onSuccess(@Nullable Location location) {
        List<Address> list;
        String str = null;
        if (location != null) {
            try {
                list = this.this$0.getGeocoder().getFromLocation(location.getLatitude(), location.getLongitude(), 10);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        } else {
            list = null;
        }
        if ((list != null ? list.size() : 0) > 0) {
            Address address = list != null ? list.get(0) : null;
            BDTLandingPageActivity bDTLandingPageActivity = this.this$0;
            if (address != null) {
                str = address.getCountryCode();
            }
            bDTLandingPageActivity.handleFlagMSG(str);
        }
    }
}
