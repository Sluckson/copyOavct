package com.wowza.gocoder.sdk.api.codec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.wowza.gocoder.sdk.api.data.WOWZData;
import com.wowza.gocoder.sdk.api.data.WOWZDataList;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.h264.WOWZProfileLevel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: GoCoderSDK */
public class WOWZCodecUtils {
    public static final String AAC_MIME_TYPE = "audio/mp4a-latm";
    public static final String H264_MIME_TYPE = "video/avc";

    public static MediaCodecInfo[] getCodecsForType(String str) {
        ArrayList arrayList = new ArrayList();
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            String[] supportedTypes = codecInfoAt.getSupportedTypes();
            for (String lowerCase : supportedTypes) {
                if (lowerCase.toLowerCase().equals(str.toLowerCase())) {
                    arrayList.add(codecInfoAt);
                }
            }
        }
        return (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
    }

    public static MediaCodecInfo[] getEncodersForType(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(getCodecsForType(str)));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((MediaCodecInfo) it.next()).isEncoder()) {
                it.remove();
            }
        }
        return (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
    }

    public static MediaCodecInfo[] getDecodersForType(String str) {
        ArrayList arrayList = new ArrayList(Arrays.asList(getCodecsForType(str)));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((MediaCodecInfo) it.next()).isEncoder()) {
                it.remove();
            }
        }
        return (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
    }

    public static int[] getProfiles() {
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo capabilitiesForType : getEncodersForType("video/avc")) {
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.getCapabilitiesForType("video/avc").profileLevels;
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                int i = null;
                int i2 = codecProfileLevel.profile;
                if (i2 == 1) {
                    i = 1;
                } else if (i2 == 2) {
                    i = 3;
                } else if (i2 == 8) {
                    i = 4;
                }
                if (i != null && !arrayList.contains(i)) {
                    arrayList.add(i);
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            iArr[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr;
    }

    public static WOWZProfileLevel[] getProfileLevels() {
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo capabilitiesForType : getEncodersForType("video/avc")) {
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.getCapabilitiesForType("video/avc").profileLevels;
            for (MediaCodecInfo.CodecProfileLevel ProfileLevelToWZProfileLevel : codecProfileLevelArr) {
                WOWZProfileLevel ProfileLevelToWZProfileLevel2 = ProfileLevelToWZProfileLevel(ProfileLevelToWZProfileLevel);
                if (ProfileLevelToWZProfileLevel2 != null) {
                    arrayList.add(ProfileLevelToWZProfileLevel2);
                }
            }
        }
        return (WOWZProfileLevel[]) arrayList.toArray(new WOWZProfileLevel[arrayList.size()]);
    }

    public static MediaCodecInfo.CodecProfileLevel WZProfileLevelToProfileLevel(WOWZProfileLevel wOWZProfileLevel) {
        int profile = wOWZProfileLevel.getProfile();
        int i = 8;
        int i2 = profile != 1 ? profile != 3 ? profile != 4 ? -1 : 8 : 2 : 1;
        switch (wOWZProfileLevel.getLevel()) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                break;
            case 5:
                i = 16;
                break;
            case 6:
                i = 32;
                break;
            case 7:
                i = 64;
                break;
            case 8:
                i = 128;
                break;
            case 9:
                i = 256;
                break;
            case 10:
                i = 512;
                break;
            case 11:
                i = 1024;
                break;
            case 12:
                i = 2048;
                break;
            case 13:
                i = 4096;
                break;
            case 14:
                i = 8192;
                break;
            case 15:
                i = 16384;
                break;
            case 16:
                i = 32768;
                break;
            default:
                i = -1;
                break;
        }
        if (i2 == -1 || i == -1) {
            return null;
        }
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = i2;
        codecProfileLevel.level = i;
        return codecProfileLevel;
    }

    public static WOWZProfileLevel ProfileLevelToWZProfileLevel(MediaCodecInfo.CodecProfileLevel codecProfileLevel) {
        int i = codecProfileLevel.profile;
        int i2 = 4;
        int i3 = i != 1 ? i != 2 ? i != 8 ? -1 : 4 : 3 : 1;
        int i4 = codecProfileLevel.level;
        if (i4 == 1) {
            i2 = 1;
        } else if (i4 != 2) {
            switch (i4) {
                case 4:
                    i2 = 3;
                    break;
                case 8:
                    break;
                case 16:
                    i2 = 5;
                    break;
                case 32:
                    i2 = 6;
                    break;
                case 64:
                    i2 = 7;
                    break;
                case 128:
                    i2 = 8;
                    break;
                case 256:
                    i2 = 9;
                    break;
                case 512:
                    i2 = 10;
                    break;
                case 1024:
                    i2 = 11;
                    break;
                case 2048:
                    i2 = 12;
                    break;
                case 4096:
                    i2 = 13;
                    break;
                case 8192:
                    i2 = 14;
                    break;
                case 16384:
                    i2 = 15;
                    break;
                case 32768:
                    i2 = 16;
                    break;
                default:
                    i2 = -1;
                    break;
            }
        } else {
            i2 = 2;
        }
        if (i3 == -1 || i2 == -1) {
            return null;
        }
        return new WOWZProfileLevel(i3, i2);
    }

    public static String getCodecInfo() {
        return getCodecInfoDataMap().toString(false);
    }

    public static WOWZDataMap getCodecInfoDataMap() {
        WOWZDataMap wOWZDataMap = new WOWZDataMap();
        WOWZDataList wOWZDataList = new WOWZDataList();
        for (MediaCodecInfo name : getEncodersForType("video/avc")) {
            wOWZDataList.add(name.getName());
        }
        wOWZDataMap.put("H264VideoEncoders", (WOWZData) wOWZDataList);
        WOWZDataList wOWZDataList2 = new WOWZDataList();
        for (MediaCodecInfo name2 : getDecodersForType("video/avc")) {
            wOWZDataList2.add(name2.getName());
        }
        wOWZDataMap.put("H264VideoDecoders", (WOWZData) wOWZDataList2);
        WOWZDataList wOWZDataList3 = new WOWZDataList();
        for (MediaCodecInfo name3 : getEncodersForType("audio/mp4a-latm")) {
            wOWZDataList3.add(name3.getName());
        }
        wOWZDataMap.put("AACAudioEncoders", (WOWZData) wOWZDataList3);
        WOWZDataList wOWZDataList4 = new WOWZDataList();
        for (MediaCodecInfo name4 : getDecodersForType("audio/mp4a-latm")) {
            wOWZDataList4.add(name4.getName());
        }
        wOWZDataMap.put("AACAudioDecoders", (WOWZData) wOWZDataList4);
        return wOWZDataMap;
    }

    /* renamed from: a */
    private static WOWZDataMap m3513a(MediaCodecInfo mediaCodecInfo, String str) {
        WOWZDataMap wOWZDataMap = new WOWZDataMap();
        wOWZDataMap.put("codecName", mediaCodecInfo.getName());
        return wOWZDataMap;
    }

    /* renamed from: a */
    private static String m3514a(int i) {
        if (i == 2130706688) {
            return "COLOR_TI_FormatYUV420PackedSemiPlanar";
        }
        if (i == 2141391872) {
            return "COLOR_QCOM_FormatYUV420SemiPlanar";
        }
        switch (i) {
            case 1:
                return "COLOR_FormatMonochrome";
            case 2:
                return "COLOR_Format8bitRGB332";
            case 3:
                return "COLOR_Format12bitRGB444";
            case 4:
                return "COLOR_Format16bitARGB4444";
            case 5:
                return "COLOR_Format16bitARGB1555";
            case 6:
                return "COLOR_Format16bitRGB565";
            case 7:
                return "COLOR_Format16bitBGR565";
            case 8:
                return "COLOR_Format18bitRGB666";
            case 9:
                return "COLOR_Format18bitARGB1665";
            case 10:
                return "COLOR_Format19bitARGB1666";
            case 11:
                return "COLOR_Format24bitRGB888";
            case 12:
                return "COLOR_Format24bitBGR888";
            case 13:
                return "COLOR_Format24bitARGB1887";
            case 14:
                return "COLOR_Format25bitARGB1888";
            case 15:
                return "COLOR_Format32bitBGRA8888";
            case 16:
                return "COLOR_Format32bitARGB8888";
            case 17:
                return "COLOR_FormatYUV411Planar";
            case 18:
                return "COLOR_FormatYUV411PackedPlanar";
            case 19:
                return "COLOR_FormatYUV420Planar";
            case 20:
                return "COLOR_FormatYUV420PackedPlanar";
            case 21:
                return "COLOR_FormatYUV420SemiPlanar";
            case 22:
                return "COLOR_FormatYUV422Planar";
            case 23:
                return "COLOR_FormatYUV422PackedPlanar";
            case 24:
                return "COLOR_FormatYUV422SemiPlanar";
            case 25:
                return "COLOR_FormatYCbYCr";
            case 26:
                return "COLOR_FormatYCrYCb";
            case 27:
                return "COLOR_FormatCbYCrY";
            case 28:
                return "COLOR_FormatCrYCbY";
            case 29:
                return "COLOR_FormatYUV444Interleaved";
            case 30:
                return "COLOR_FormatRawBayer8bit";
            case 31:
                return "COLOR_FormatRawBayer10bit";
            case 32:
                return "COLOR_FormatRawBayer8bitcompressed";
            case 33:
                return "COLOR_FormatL2";
            case 34:
                return "COLOR_FormatL4";
            case 35:
                return "COLOR_FormatL8";
            case 36:
                return "COLOR_FormatL16";
            case 37:
                return "COLOR_FormatL24";
            case 38:
                return "COLOR_FormatL32";
            case 39:
                return "COLOR_FormatYUV420PackedSemiPlanar";
            case 40:
                return "COLOR_FormatYUV422PackedSemiPlanar";
            case 41:
                return "COLOR_Format18BitBGR666";
            case 42:
                return "COLOR_Format24BitARGB6666";
            case 43:
                return "COLOR_Format24BitABGR6666";
            default:
                return "COLOR_FormatId" + i;
        }
    }

    /* renamed from: b */
    private static String m3515b(int i) {
        if (i == 1) {
            return "AVCProfileBaseline";
        }
        if (i == 2) {
            return "AVCProfileMain";
        }
        if (i == 4) {
            return "AVCProfileExtended";
        }
        if (i == 8) {
            return "AVCProfileHigh";
        }
        if (i == 16) {
            return "AVCProfileHigh10";
        }
        if (i == 32) {
            return "AVCProfileHigh422";
        }
        if (i == 64) {
            return "AVCProfileHigh444";
        }
        return "AVCProfile" + i;
    }

    /* renamed from: c */
    private static String m3516c(int i) {
        if (i == 1) {
            return "AVCLevel1";
        }
        if (i == 2) {
            return "AVCLevel1b";
        }
        switch (i) {
            case 4:
                return "AVCLevel11";
            case 8:
                return "AVCLevel12";
            case 16:
                return "AVCLevel13";
            case 32:
                return "AVCLevel2";
            case 64:
                return "AVCLevel21";
            case 128:
                return "AVCLevel22";
            case 256:
                return "AVCLevel3";
            case 512:
                return "AVCLevel31";
            case 1024:
                return "AVCLevel32";
            case 2048:
                return "AVCLevel4";
            case 4096:
                return "AVCLevel41";
            case 8192:
                return "AVCLevel42";
            case 16384:
                return "AVCLevel5";
            case 32768:
                return "AVCLevel51";
            default:
                return "AVCLevel" + i;
        }
    }

    /* renamed from: d */
    private static String m3517d(int i) {
        if (i == 17) {
            return "AACObjectERLC";
        }
        if (i == 23) {
            return "AACObjectLD";
        }
        if (i == 29) {
            return "AACObjectHE_PS";
        }
        if (i == 39) {
            return "AACObjectELD";
        }
        switch (i) {
            case 1:
                return "AACObjectMain";
            case 2:
                return "AACObjectLC";
            case 3:
                return "AACObjectSSR";
            case 4:
                return "AACObjectLTP";
            case 5:
                return "AACObjectHE";
            case 6:
                return "AACObjectScalable";
            default:
                return "AACProfileId" + i;
        }
    }
}
