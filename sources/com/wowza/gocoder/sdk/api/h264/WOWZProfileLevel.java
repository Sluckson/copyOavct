package com.wowza.gocoder.sdk.api.h264;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import java.io.Serializable;
import kotlinx.coroutines.DebugKt;

/* compiled from: GoCoderSDK */
public class WOWZProfileLevel implements Serializable, Comparable {
    public static final int PROFILE_BASELINE = 1;
    public static final int PROFILE_HIGH = 4;
    public static final int PROFILE_LEVEL1 = 1;
    public static final int PROFILE_LEVEL11 = 3;
    public static final int PROFILE_LEVEL12 = 4;
    public static final int PROFILE_LEVEL13 = 5;
    public static final int PROFILE_LEVEL1B = 2;
    public static final int PROFILE_LEVEL2 = 6;
    public static final int PROFILE_LEVEL21 = 7;
    public static final int PROFILE_LEVEL22 = 8;
    public static final int PROFILE_LEVEL3 = 9;
    public static final int PROFILE_LEVEL31 = 10;
    public static final int PROFILE_LEVEL32 = 11;
    public static final int PROFILE_LEVEL4 = 12;
    public static final int PROFILE_LEVEL41 = 13;
    public static final int PROFILE_LEVEL42 = 14;
    public static final int PROFILE_LEVEL5 = 15;
    public static final int PROFILE_LEVEL51 = 16;
    public static final int PROFILE_LEVEL_AUTO = 0;
    public static final int PROFILE_MAIN = 3;
    protected int mLevel;
    protected int mProfile;

    public WOWZProfileLevel(int i) {
        this.mLevel = 0;
    }

    public WOWZProfileLevel(int i, int i2) {
        this.mProfile = i;
        this.mLevel = i2;
    }

    public WOWZProfileLevel(WOWZProfileLevel wOWZProfileLevel) {
        set(wOWZProfileLevel);
    }

    public void set(WOWZProfileLevel wOWZProfileLevel) {
        if (wOWZProfileLevel != null || !wOWZProfileLevel.validate()) {
            this.mProfile = wOWZProfileLevel.mProfile;
            this.mLevel = wOWZProfileLevel.mLevel;
        }
    }

    public int getLevel() {
        return this.mLevel;
    }

    public int getProfile() {
        return this.mProfile;
    }

    public boolean validate() {
        int i = this.mProfile;
        if (i != 1 && i != 3 && i != 4) {
            return false;
        }
        switch (this.mLevel) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                return true;
            default:
                return false;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(m3635a(this.mProfile));
        if (this.mLevel == 0) {
            str = " (auto level)";
        } else {
            str = " (level " + m3636b(this.mLevel) + ")";
        }
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    private String m3635a(int i) {
        if (i == 1) {
            return "Baseline";
        }
        if (i == 3) {
            return "Main";
        }
        if (i == 4) {
            return "High";
        }
        return "unknown[" + String.valueOf(i) + "]";
    }

    /* renamed from: b */
    private String m3636b(int i) {
        switch (i) {
            case 0:
                return DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
            case 1:
                return IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
            case 2:
                return "1b";
            case 3:
                return "1.1";
            case 4:
                return "1.2";
            case 5:
                return "1.3";
            case 6:
                return ExifInterface.GPS_MEASUREMENT_2D;
            case 7:
                return "2.1";
            case 8:
                return "2.2";
            case 9:
                return ExifInterface.GPS_MEASUREMENT_3D;
            case 10:
                return "3.1";
            case 11:
                return "3.2";
            case 12:
                return "4";
            case 13:
                return "4.1";
            case 14:
                return "4.2";
            case 15:
                return "5";
            case 16:
                return "5.1";
            default:
                return "unknown[" + String.valueOf(i) + "]";
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof WOWZProfileLevel)) {
            WOWZProfileLevel wOWZProfileLevel = (WOWZProfileLevel) obj;
            return wOWZProfileLevel.mProfile == this.mProfile && wOWZProfileLevel.mLevel == this.mLevel;
        }
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        WOWZProfileLevel wOWZProfileLevel = (WOWZProfileLevel) obj;
        int i = wOWZProfileLevel.mProfile;
        int i2 = this.mProfile;
        return i == i2 ? this.mLevel - wOWZProfileLevel.mLevel : i2 - i;
    }
}
