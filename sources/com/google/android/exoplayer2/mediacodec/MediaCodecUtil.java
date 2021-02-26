package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.lowagie.text.pdf.PdfFormField;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p044b.C4317c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil {
    private static final SparseIntArray AVC_LEVEL_NUMBER_TO_CONST = new SparseIntArray();
    private static final SparseIntArray AVC_PROFILE_NUMBER_TO_CONST = new SparseIntArray();
    private static final String CODEC_ID_AVC1 = "avc1";
    private static final String CODEC_ID_AVC2 = "avc2";
    private static final String CODEC_ID_DVH1 = "dvh1";
    private static final String CODEC_ID_DVHE = "dvhe";
    private static final String CODEC_ID_HEV1 = "hev1";
    private static final String CODEC_ID_HVC1 = "hvc1";
    private static final String CODEC_ID_MP4A = "mp4a";
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_LEVEL = new HashMap();
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_PROFILE = new HashMap();
    private static final Map<String, Integer> HEVC_CODEC_STRING_TO_PROFILE_LEVEL = new HashMap();
    private static final SparseIntArray MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE = new SparseIntArray();
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final String TAG = "MediaCodecUtil";
    private static final HashMap<CodecKey, List<MediaCodecInfo>> decoderInfosCache = new HashMap<>();
    private static int maxH264DecodableFrameSize = -1;

    private interface MediaCodecListCompat {
        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i);

        boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    private static int avcLevelToMaxFrameSize(int i) {
        if (i == 1 || i == 2) {
            return 25344;
        }
        switch (i) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    static {
        AVC_PROFILE_NUMBER_TO_CONST.put(66, 1);
        AVC_PROFILE_NUMBER_TO_CONST.put(77, 2);
        AVC_PROFILE_NUMBER_TO_CONST.put(88, 4);
        AVC_PROFILE_NUMBER_TO_CONST.put(100, 8);
        AVC_PROFILE_NUMBER_TO_CONST.put(110, 16);
        AVC_PROFILE_NUMBER_TO_CONST.put(122, 32);
        AVC_PROFILE_NUMBER_TO_CONST.put(C4317c.f4528X, 64);
        AVC_LEVEL_NUMBER_TO_CONST.put(10, 1);
        AVC_LEVEL_NUMBER_TO_CONST.put(11, 4);
        AVC_LEVEL_NUMBER_TO_CONST.put(12, 8);
        AVC_LEVEL_NUMBER_TO_CONST.put(13, 16);
        AVC_LEVEL_NUMBER_TO_CONST.put(20, 32);
        AVC_LEVEL_NUMBER_TO_CONST.put(21, 64);
        AVC_LEVEL_NUMBER_TO_CONST.put(22, 128);
        AVC_LEVEL_NUMBER_TO_CONST.put(30, 256);
        AVC_LEVEL_NUMBER_TO_CONST.put(31, 512);
        AVC_LEVEL_NUMBER_TO_CONST.put(32, 1024);
        AVC_LEVEL_NUMBER_TO_CONST.put(40, 2048);
        AVC_LEVEL_NUMBER_TO_CONST.put(41, 4096);
        AVC_LEVEL_NUMBER_TO_CONST.put(42, 8192);
        AVC_LEVEL_NUMBER_TO_CONST.put(50, 16384);
        AVC_LEVEL_NUMBER_TO_CONST.put(51, 32768);
        AVC_LEVEL_NUMBER_TO_CONST.put(52, 65536);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L30", 1);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L60", 4);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L63", 16);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L90", 64);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L93", 256);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L120", 1024);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L123", 4096);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L150", 16384);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L153", 65536);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L156", 262144);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L180", 1048576);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L183", 4194304);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L186", 16777216);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H30", 2);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H60", 8);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H63", 32);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H90", 128);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H93", 512);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H120", 2048);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H123", 8192);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H150", 32768);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H153", 131072);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H156", 524288);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H180", 2097152);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H183", 8388608);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H186", Integer.valueOf(PdfFormField.FF_RADIOSINUNISON));
        DOLBY_VISION_STRING_TO_PROFILE.put("00", 1);
        DOLBY_VISION_STRING_TO_PROFILE.put("01", 2);
        DOLBY_VISION_STRING_TO_PROFILE.put("02", 4);
        DOLBY_VISION_STRING_TO_PROFILE.put("03", 8);
        DOLBY_VISION_STRING_TO_PROFILE.put("04", 16);
        DOLBY_VISION_STRING_TO_PROFILE.put("05", 32);
        DOLBY_VISION_STRING_TO_PROFILE.put("06", 64);
        DOLBY_VISION_STRING_TO_PROFILE.put("07", 128);
        DOLBY_VISION_STRING_TO_PROFILE.put("08", 256);
        DOLBY_VISION_STRING_TO_PROFILE.put("09", 512);
        DOLBY_VISION_STRING_TO_LEVEL.put("01", 1);
        DOLBY_VISION_STRING_TO_LEVEL.put("02", 2);
        DOLBY_VISION_STRING_TO_LEVEL.put("03", 4);
        DOLBY_VISION_STRING_TO_LEVEL.put("04", 8);
        DOLBY_VISION_STRING_TO_LEVEL.put("05", 16);
        DOLBY_VISION_STRING_TO_LEVEL.put("06", 32);
        DOLBY_VISION_STRING_TO_LEVEL.put("07", 64);
        DOLBY_VISION_STRING_TO_LEVEL.put("08", 128);
        DOLBY_VISION_STRING_TO_LEVEL.put("09", 256);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(1, 1);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(2, 2);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(3, 3);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(4, 4);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(5, 5);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(6, 6);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(17, 17);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(20, 20);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(23, 23);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(29, 29);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(39, 39);
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.put(42, 42);
    }

    private MediaCodecUtil() {
    }

    public static void warmDecoderInfoCache(String str, boolean z, boolean z2) {
        try {
            getDecoderInfos(str, z, z2);
        } catch (DecoderQueryException e) {
            Log.m51e(TAG, "Codec warming failed", e);
        }
    }

    @Nullable
    public static MediaCodecInfo getPassthroughDecoderInfo() throws DecoderQueryException {
        MediaCodecInfo decoderInfo = getDecoderInfo(MimeTypes.AUDIO_RAW, false, false);
        if (decoderInfo == null) {
            return null;
        }
        return MediaCodecInfo.newPassthroughInstance(decoderInfo.name);
    }

    @Nullable
    public static MediaCodecInfo getDecoderInfo(String str, boolean z, boolean z2) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(str, z, z2);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2) throws DecoderQueryException {
        synchronized (MediaCodecUtil.class) {
            CodecKey codecKey = new CodecKey(str, z, z2);
            List<MediaCodecInfo> list = decoderInfosCache.get(codecKey);
            if (list != null) {
                return list;
            }
            ArrayList<MediaCodecInfo> decoderInfosInternal = getDecoderInfosInternal(codecKey, Util.SDK_INT >= 21 ? new MediaCodecListCompatV21(z, z2) : new MediaCodecListCompatV16());
            if (z && decoderInfosInternal.isEmpty() && 21 <= Util.SDK_INT && Util.SDK_INT <= 23) {
                decoderInfosInternal = getDecoderInfosInternal(codecKey, new MediaCodecListCompatV16());
                if (!decoderInfosInternal.isEmpty()) {
                    Log.m54w(TAG, "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + decoderInfosInternal.get(0).name);
                }
            }
            applyWorkarounds(str, decoderInfosInternal);
            List<MediaCodecInfo> unmodifiableList = Collections.unmodifiableList(decoderInfosInternal);
            decoderInfosCache.put(codecKey, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        if (maxH264DecodableFrameSize == -1) {
            int i = 0;
            MediaCodecInfo decoderInfo = getDecoderInfo("video/avc", false, false);
            if (decoderInfo != null) {
                MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int i2 = 0;
                while (i < length) {
                    i2 = Math.max(avcLevelToMaxFrameSize(profileLevels[i].level), i2);
                    i++;
                }
                i = Math.max(i2, Util.SDK_INT >= 21 ? 345600 : 172800);
            }
            maxH264DecodableFrameSize = i;
        }
        return maxH264DecodableFrameSize;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0058, code lost:
        if (r3.equals("avc1") != false) goto L_0x005c;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> getCodecProfileAndLevel(@androidx.annotation.Nullable java.lang.String r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "\\."
            java.lang.String[] r1 = r6.split(r1)
            r2 = 0
            r3 = r1[r2]
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case 3006243: goto L_0x0052;
                case 3006244: goto L_0x0048;
                case 3095771: goto L_0x003e;
                case 3095823: goto L_0x0034;
                case 3199032: goto L_0x002a;
                case 3214780: goto L_0x0020;
                case 3356560: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x005b
        L_0x0016:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005b
            r2 = 6
            goto L_0x005c
        L_0x0020:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005b
            r2 = 3
            goto L_0x005c
        L_0x002a:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005b
            r2 = 2
            goto L_0x005c
        L_0x0034:
            java.lang.String r2 = "dvhe"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005b
            r2 = 4
            goto L_0x005c
        L_0x003e:
            java.lang.String r2 = "dvh1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005b
            r2 = 5
            goto L_0x005c
        L_0x0048:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x005b
            r2 = 1
            goto L_0x005c
        L_0x0052:
            java.lang.String r5 = "avc1"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r2 = -1
        L_0x005c:
            switch(r2) {
                case 0: goto L_0x006f;
                case 1: goto L_0x006f;
                case 2: goto L_0x006a;
                case 3: goto L_0x006a;
                case 4: goto L_0x0065;
                case 5: goto L_0x0065;
                case 6: goto L_0x0060;
                default: goto L_0x005f;
            }
        L_0x005f:
            return r0
        L_0x0060:
            android.util.Pair r6 = getAacCodecProfileAndLevel(r6, r1)
            return r6
        L_0x0065:
            android.util.Pair r6 = getDolbyVisionProfileAndLevel(r6, r1)
            return r6
        L_0x006a:
            android.util.Pair r6 = getHevcProfileAndLevel(r6, r1)
            return r6
        L_0x006f:
            android.util.Pair r6 = getAvcProfileAndLevel(r6, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(java.lang.String):android.util.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b1 A[SYNTHETIC, Splitter:B:44:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfosInternal(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey r18, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat r19) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r1 = r18
            r2 = r19
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x00fb }
            r5.<init>()     // Catch:{ Exception -> 0x00fb }
            java.lang.String r12 = r1.mimeType     // Catch:{ Exception -> 0x00fb }
            int r13 = r19.getCodecCount()     // Catch:{ Exception -> 0x00fb }
            boolean r14 = r19.secureDecodersExplicit()     // Catch:{ Exception -> 0x00fb }
            r0 = 0
            r15 = 0
        L_0x0019:
            if (r15 >= r13) goto L_0x00fa
            android.media.MediaCodecInfo r0 = r2.getCodecInfoAt(r15)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r11 = r0.getName()     // Catch:{ Exception -> 0x00fb }
            java.lang.String r10 = getCodecMimeType(r0, r11, r14, r12)     // Catch:{ Exception -> 0x00fb }
            if (r10 != 0) goto L_0x002b
            goto L_0x00d0
        L_0x002b:
            android.media.MediaCodecInfo$CodecCapabilities r9 = r0.getCapabilitiesForType(r10)     // Catch:{ Exception -> 0x00a5 }
            boolean r0 = r2.isFeatureSupported(r4, r10, r9)     // Catch:{ Exception -> 0x00a5 }
            boolean r6 = r2.isFeatureRequired(r4, r10, r9)     // Catch:{ Exception -> 0x00a5 }
            boolean r7 = r1.tunneling     // Catch:{ Exception -> 0x00a5 }
            if (r7 != 0) goto L_0x003d
            if (r6 != 0) goto L_0x00d0
        L_0x003d:
            boolean r6 = r1.tunneling     // Catch:{ Exception -> 0x00a5 }
            if (r6 == 0) goto L_0x0045
            if (r0 != 0) goto L_0x0045
            goto L_0x00d0
        L_0x0045:
            boolean r0 = r2.isFeatureSupported(r3, r10, r9)     // Catch:{ Exception -> 0x00a5 }
            boolean r6 = r2.isFeatureRequired(r3, r10, r9)     // Catch:{ Exception -> 0x00a5 }
            boolean r7 = r1.secure     // Catch:{ Exception -> 0x00a5 }
            if (r7 != 0) goto L_0x0053
            if (r6 != 0) goto L_0x00d0
        L_0x0053:
            boolean r6 = r1.secure     // Catch:{ Exception -> 0x00a5 }
            if (r6 == 0) goto L_0x005b
            if (r0 != 0) goto L_0x005b
            goto L_0x00d0
        L_0x005b:
            boolean r16 = codecNeedsDisableAdaptationWorkaround(r11)     // Catch:{ Exception -> 0x00a5 }
            if (r14 == 0) goto L_0x0065
            boolean r6 = r1.secure     // Catch:{ Exception -> 0x00a5 }
            if (r6 == r0) goto L_0x006b
        L_0x0065:
            if (r14 != 0) goto L_0x007f
            boolean r6 = r1.secure     // Catch:{ Exception -> 0x00a5 }
            if (r6 != 0) goto L_0x007f
        L_0x006b:
            r0 = 0
            r6 = r11
            r7 = r12
            r8 = r10
            r17 = r10
            r10 = r16
            r1 = r11
            r11 = r0
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x007d }
            r5.add(r0)     // Catch:{ Exception -> 0x007d }
            goto L_0x00d0
        L_0x007d:
            r0 = move-exception
            goto L_0x00a9
        L_0x007f:
            r17 = r10
            r1 = r11
            if (r14 != 0) goto L_0x00d0
            if (r0 == 0) goto L_0x00d0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r0.<init>()     // Catch:{ Exception -> 0x007d }
            r0.append(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r6 = ".secure"
            r0.append(r6)     // Catch:{ Exception -> 0x007d }
            java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x007d }
            r11 = 1
            r7 = r12
            r8 = r17
            r10 = r16
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x007d }
            r5.add(r0)     // Catch:{ Exception -> 0x007d }
            return r5
        L_0x00a5:
            r0 = move-exception
            r17 = r10
            r1 = r11
        L_0x00a9:
            int r6 = com.google.android.exoplayer2.util.Util.SDK_INT     // Catch:{ Exception -> 0x00fb }
            r7 = 23
            java.lang.String r8 = "MediaCodecUtil"
            if (r6 > r7) goto L_0x00d6
            boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x00fb }
            if (r6 != 0) goto L_0x00d6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb }
            r0.<init>()     // Catch:{ Exception -> 0x00fb }
            java.lang.String r6 = "Skipping codec "
            r0.append(r6)     // Catch:{ Exception -> 0x00fb }
            r0.append(r1)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r1 = " (failed to query capabilities)"
            r0.append(r1)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00fb }
            com.google.android.exoplayer2.util.Log.m50e(r8, r0)     // Catch:{ Exception -> 0x00fb }
        L_0x00d0:
            int r15 = r15 + 1
            r1 = r18
            goto L_0x0019
        L_0x00d6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fb }
            r2.<init>()     // Catch:{ Exception -> 0x00fb }
            java.lang.String r3 = "Failed to query codec "
            r2.append(r3)     // Catch:{ Exception -> 0x00fb }
            r2.append(r1)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x00fb }
            r1 = r17
            r2.append(r1)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00fb }
            com.google.android.exoplayer2.util.Log.m50e(r8, r1)     // Catch:{ Exception -> 0x00fb }
            throw r0     // Catch:{ Exception -> 0x00fb }
        L_0x00fa:
            return r5
        L_0x00fb:
            r0 = move-exception
            com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException r1 = new com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException
            r2 = 0
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getDecoderInfosInternal(com.google.android.exoplayer2.mediacodec.MediaCodecUtil$CodecKey, com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat):java.util.ArrayList");
    }

    @Nullable
    private static String getCodecMimeType(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (!isCodecUsableDecoder(mediaCodecInfo, str, z, str2)) {
            return null;
        }
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals(MimeTypes.VIDEO_DOLBY_VISION)) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
        } else if (str2.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (!str2.equals(MimeTypes.AUDIO_FLAC) || !"OMX.lge.flac.decoder".equals(str)) {
                return null;
            }
            return "audio/x-lg-flac";
        }
        return null;
    }

    private static boolean isCodecUsableDecoder(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        if (Util.SDK_INT < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (Util.SDK_INT < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && ("a70".equals(Util.DEVICE) || ("Xiaomi".equals(Util.MANUFACTURER) && Util.DEVICE.startsWith("HM")))) {
            return false;
        }
        if (Util.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(Util.DEVICE) || "protou".equals(Util.DEVICE) || "ville".equals(Util.DEVICE) || "villeplus".equals(Util.DEVICE) || "villec2".equals(Util.DEVICE) || Util.DEVICE.startsWith("gee") || "C6602".equals(Util.DEVICE) || "C6603".equals(Util.DEVICE) || "C6606".equals(Util.DEVICE) || "C6616".equals(Util.DEVICE) || "L36h".equals(Util.DEVICE) || "SO-02E".equals(Util.DEVICE))) {
            return false;
        }
        if (Util.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(Util.DEVICE) || "C1505".equals(Util.DEVICE) || "C1604".equals(Util.DEVICE) || "C1605".equals(Util.DEVICE))) {
            return false;
        }
        if (Util.SDK_INT < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("zeroflte") || Util.DEVICE.startsWith("zerolte") || Util.DEVICE.startsWith("zenlte") || "SC-05G".equals(Util.DEVICE) || "marinelteatt".equals(Util.DEVICE) || "404SC".equals(Util.DEVICE) || "SC-04G".equals(Util.DEVICE) || "SCV31".equals(Util.DEVICE)))) {
            return false;
        }
        if (Util.SDK_INT <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("d2") || Util.DEVICE.startsWith("serrano") || Util.DEVICE.startsWith("jflte") || Util.DEVICE.startsWith("santos") || Util.DEVICE.startsWith("t0"))) {
            return false;
        }
        if (Util.SDK_INT <= 19 && Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        if (!MimeTypes.AUDIO_E_AC3_JOC.equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) {
            return true;
        }
        return false;
    }

    private static void applyWorkarounds(String str, List<MediaCodecInfo> list) {
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            Collections.sort(list, new RawAudioCodecComparator());
        } else if (Util.SDK_INT < 21 && list.size() > 1) {
            String str2 = list.get(0).name;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                Collections.sort(list, new PreferOmxGoogleCodecComparator());
            }
        }
    }

    private static boolean codecNeedsDisableAdaptationWorkaround(String str) {
        return Util.SDK_INT <= 22 && ("ODROID-XU3".equals(Util.MODEL) || "Nexus 10".equals(Util.MODEL)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str));
    }

    private static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.m54w(TAG, "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.m54w(TAG, "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        Integer num = DOLBY_VISION_STRING_TO_PROFILE.get(group);
        if (num == null) {
            Log.m54w(TAG, "Unknown Dolby Vision profile string: " + group);
            return null;
        }
        String str2 = strArr[2];
        Integer num2 = DOLBY_VISION_STRING_TO_LEVEL.get(str2);
        if (num2 != null) {
            return new Pair<>(num, num2);
        }
        Log.m54w(TAG, "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    private static Pair<Integer, Integer> getHevcProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 4) {
            Log.m54w(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i = 1;
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.m54w(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if (!IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE.equals(group)) {
            if (ExifInterface.GPS_MEASUREMENT_2D.equals(group)) {
                i = 2;
            } else {
                Log.m54w(TAG, "Unknown HEVC profile string: " + group);
                return null;
            }
        }
        String str2 = strArr[3];
        Integer num = HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(str2);
        if (num != null) {
            return new Pair<>(Integer.valueOf(i), num);
        }
        Log.m54w(TAG, "Unknown HEVC level string: " + str2);
        return null;
    }

    private static Pair<Integer, Integer> getAvcProfileAndLevel(String str, String[] strArr) {
        int i;
        int i2;
        if (strArr.length < 2) {
            Log.m54w(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                int parseInt = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i = Integer.parseInt(strArr[1].substring(4), 16);
                i2 = parseInt;
            } else if (strArr.length >= 3) {
                i2 = Integer.parseInt(strArr[1]);
                i = Integer.parseInt(strArr[2]);
            } else {
                Log.m54w(TAG, "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            int i3 = AVC_PROFILE_NUMBER_TO_CONST.get(i2, -1);
            if (i3 == -1) {
                Log.m54w(TAG, "Unknown AVC profile: " + i2);
                return null;
            }
            int i4 = AVC_LEVEL_NUMBER_TO_CONST.get(i, -1);
            if (i4 != -1) {
                return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i4));
            }
            Log.m54w(TAG, "Unknown AVC level: " + i);
            return null;
        } catch (NumberFormatException unused) {
            Log.m54w(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    @Nullable
    private static Pair<Integer, Integer> getAacCodecProfileAndLevel(String str, String[] strArr) {
        int i;
        if (strArr.length != 3) {
            Log.m54w(TAG, "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(MimeTypes.getMimeTypeFromMp4ObjectType(Integer.parseInt(strArr[1], 16))) && (i = MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.get(Integer.parseInt(strArr[2]), -1)) != -1) {
                return new Pair<>(Integer.valueOf(i), 0);
            }
        } catch (NumberFormatException unused) {
            Log.m54w(TAG, "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    @TargetApi(21)
    private static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int codecKind;
        private MediaCodecInfo[] mediaCodecInfos;

        public boolean secureDecodersExplicit() {
            return true;
        }

        public MediaCodecListCompatV21(boolean z, boolean z2) {
            this.codecKind = (z || z2) ? 1 : 0;
        }

        public int getCodecCount() {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        public MediaCodecInfo getCodecInfoAt(int i) {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[i];
        }

        public boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        public boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        private void ensureMediaCodecInfosInitialized() {
            if (this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }
    }

    private static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        public boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        public boolean secureDecodersExplicit() {
            return false;
        }

        private MediaCodecListCompatV16() {
        }

        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        public MediaCodecInfo getCodecInfoAt(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }
    }

    private static final class CodecKey {
        public final String mimeType;
        public final boolean secure;
        public final boolean tunneling;

        public CodecKey(String str, boolean z, boolean z2) {
            this.mimeType = str;
            this.secure = z;
            this.tunneling = z2;
        }

        public int hashCode() {
            String str = this.mimeType;
            int i = 1231;
            int hashCode = ((((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.secure ? 1231 : 1237)) * 31;
            if (!this.tunneling) {
                i = 1237;
            }
            return hashCode + i;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != CodecKey.class) {
                return false;
            }
            CodecKey codecKey = (CodecKey) obj;
            if (TextUtils.equals(this.mimeType, codecKey.mimeType) && this.secure == codecKey.secure && this.tunneling == codecKey.tunneling) {
                return true;
            }
            return false;
        }
    }

    private static final class RawAudioCodecComparator implements Comparator<MediaCodecInfo> {
        private RawAudioCodecComparator() {
        }

        public int compare(MediaCodecInfo mediaCodecInfo, MediaCodecInfo mediaCodecInfo2) {
            return scoreMediaCodecInfo(mediaCodecInfo) - scoreMediaCodecInfo(mediaCodecInfo2);
        }

        private static int scoreMediaCodecInfo(MediaCodecInfo mediaCodecInfo) {
            String str = mediaCodecInfo.name;
            if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
                return -1;
            }
            return (Util.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : 1;
        }
    }

    private static final class PreferOmxGoogleCodecComparator implements Comparator<MediaCodecInfo> {
        private PreferOmxGoogleCodecComparator() {
        }

        public int compare(MediaCodecInfo mediaCodecInfo, MediaCodecInfo mediaCodecInfo2) {
            return scoreMediaCodecInfo(mediaCodecInfo) - scoreMediaCodecInfo(mediaCodecInfo2);
        }

        private static int scoreMediaCodecInfo(MediaCodecInfo mediaCodecInfo) {
            return mediaCodecInfo.name.startsWith("OMX.google") ? -1 : 0;
        }
    }
}
