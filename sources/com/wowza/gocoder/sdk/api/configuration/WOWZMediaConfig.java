package com.wowza.gocoder.sdk.api.configuration;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.lowagie.text.pdf.PdfBoolean;
import com.lowagie.text.pdf.codec.TIFFConstants;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.h264.WOWZProfileLevel;
import java.io.Serializable;
import java.text.DecimalFormat;
import repack.org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: GoCoderSDK */
public class WOWZMediaConfig implements Serializable, Comparable<WOWZMediaConfig> {
    public static final int ALWAYS_LANDSCAPE = 1;
    public static final int ALWAYS_PORTRAIT = 2;
    public static final int AUDIO_CHANNELS_MONO = 1;
    public static final int AUDIO_CHANNELS_STEREO = 2;
    public static final int CROP_TO_FRAME = 1;
    public static final int DEFAULT_AUDIO_BITRATE = 64000;
    public static final int DEFAULT_AUDIO_SAMPLE_RATE = 44100;
    public static final int DEFAULT_SCALE_MODE = 2;
    public static final int DEFAULT_VIDEO_BITRATE = 1500;
    public static final float DEFAULT_VIDEO_BITRATE_SCALING_FACTOR = 0.75f;
    public static final int DEFAULT_VIDEO_FRAME_BUFFER_MULTIPLIER = 4;
    public static final int DEFAULT_VIDEO_FRAME_HEIGHT = 480;
    public static final int DEFAULT_VIDEO_FRAME_RATE = 30;
    public static final WOWZSize DEFAULT_VIDEO_FRAME_SIZE = new WOWZSize(DEFAULT_VIDEO_FRAME_WIDTH, DEFAULT_VIDEO_FRAME_HEIGHT);
    public static final int DEFAULT_VIDEO_FRAME_SKIP_COUNT = 4;
    public static final int DEFAULT_VIDEO_FRAME_WIDTH = 640;
    public static final int DEFAULT_VIDEO_KEYFRAME_INTERVAL = 30;
    public static final int FILL_FRAME = 2;
    public static final int FILL_VIEW = 2;
    public static final WOWZMediaConfig FRAME_SIZE_1280x720 = new WOWZMediaConfig("720p", 1280, 720, 3750, 30, 30, 2, DEFAULT_AUDIO_SAMPLE_RATE, DEFAULT_AUDIO_BITRATE);
    public static final WOWZMediaConfig FRAME_SIZE_1440x1080 = new WOWZMediaConfig("1080i", 1440, 1080, 5000, 30, 30, 2, DEFAULT_AUDIO_SAMPLE_RATE, DEFAULT_AUDIO_BITRATE);
    public static final WOWZMediaConfig FRAME_SIZE_176x144 = new WOWZMediaConfig("QCIF", 176, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, TIFFConstants.TIFFTAG_MINSAMPLEVALUE, 30, 30, 2, DEFAULT_AUDIO_SAMPLE_RATE, DEFAULT_AUDIO_BITRATE);
    public static final WOWZMediaConfig FRAME_SIZE_1920x1080 = new WOWZMediaConfig("1080p", 1920, 1080, 5000, 30, 30, 2, DEFAULT_AUDIO_SAMPLE_RATE, DEFAULT_AUDIO_BITRATE);
    public static final WOWZMediaConfig FRAME_SIZE_320x240 = new WOWZMediaConfig("QVGA", TIFFConstants.TIFFTAG_COLORMAP, PsExtractor.VIDEO_STREAM_MASK, TIFFConstants.TIFFTAG_MINSAMPLEVALUE, 30, 30, 2, DEFAULT_AUDIO_SAMPLE_RATE, DEFAULT_AUDIO_BITRATE);
    public static final WOWZMediaConfig FRAME_SIZE_352x288 = new WOWZMediaConfig("CIF", 352, TIFFConstants.TIFFTAG_FREEOFFSETS, 1000, 30, 30, 2, DEFAULT_AUDIO_SAMPLE_RATE, DEFAULT_AUDIO_BITRATE);
    public static final WOWZMediaConfig FRAME_SIZE_3840x2160 = new WOWZMediaConfig("4k UHD", 3840, 2160, 8000, 30, 30, 2, DEFAULT_AUDIO_SAMPLE_RATE, DEFAULT_AUDIO_BITRATE);
    public static final WOWZMediaConfig FRAME_SIZE_640x480 = new WOWZMediaConfig("VGA", DEFAULT_VIDEO_FRAME_WIDTH, DEFAULT_VIDEO_FRAME_HEIGHT, 1500, 30, 30, 2, DEFAULT_AUDIO_SAMPLE_RATE, DEFAULT_AUDIO_BITRATE);
    public static final WOWZMediaConfig FRAME_SIZE_960x540 = new WOWZMediaConfig(960, 540, 1500, 30, 30, 2, DEFAULT_AUDIO_SAMPLE_RATE, DEFAULT_AUDIO_BITRATE);
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_LANDSCAPE_INVERTED = 3;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int ORIENTATION_PORTRAIT_INVERTED = 4;
    public static final WOWZMediaConfig[] PRESET_CONFIGS = {FRAME_SIZE_176x144, FRAME_SIZE_320x240, FRAME_SIZE_352x288, FRAME_SIZE_640x480, FRAME_SIZE_960x540, FRAME_SIZE_1280x720, FRAME_SIZE_1440x1080, FRAME_SIZE_1920x1080, FRAME_SIZE_3840x2160};
    public static final int RESIZE_TO_ASPECT = 1;
    public static final int SAME_AS_SOURCE = 3;
    public static final int[] SUPPORTED_AUDIO_SAMPLE_RATES = {8000, 11025, 22050, DEFAULT_AUDIO_SAMPLE_RATE, 48000};
    protected boolean mABREnabled;
    protected int mAudioBitRate;
    protected int mAudioChannels;
    protected boolean mAudioEnabled;
    protected int mAudioSampleRate;
    protected String mConfigName;
    protected String mHLSBackupURL;
    protected boolean mIsPlayback;
    protected String mPresetLabel;
    protected boolean mUseHLS;
    protected int mVBEFrameBufferSizeMultiplier;
    protected int mVBEFrameRateLowBandwidthSkipCount;
    protected float mVBELowBandwidthScalingFactor;
    protected int mVideoBitRate;
    protected boolean mVideoEnabled;
    protected WOWZSize mVideoFrameSize;
    protected int mVideoFramerate;
    protected int mVideoKeyFrameInterval;
    protected WOWZProfileLevel mVideoProfileLevel;
    protected int mVideoRotation;

    public static boolean isLandscape(int i) {
        return i == 1 || i == 3;
    }

    public static boolean isValidScaleMode(int i) {
        return i == 1 || i == 2;
    }

    public static int orientationToRotation(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 90;
        }
        if (i == 3) {
            return 180;
        }
        if (i != 4) {
            return 0;
        }
        return TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
    }

    public static int rotationToOrientation(int i) {
        if (i < 90) {
            return 1;
        }
        if (i < 180) {
            return 2;
        }
        return i < 270 ? 3 : 4;
    }

    public static boolean isLandscapeRotation(int i) {
        return isLandscape(rotationToOrientation(i));
    }

    public static String orientationLabel(int i) {
        return isPortrait(i) ? "portrait" : "landscape";
    }

    public static boolean isPortrait(int i) {
        return !isLandscape(i);
    }

    public static boolean isPortraitRotation(int i) {
        return !isLandscapeRotation(i);
    }

    public static int surfaceRotationToOrientation(int i) {
        return rotationToOrientation(i);
    }

    public static int orientationToSurfaceRotation(int i) {
        return orientationToRotation(i);
    }

    public static int keyFrameIntervalFramesToSeconds(int i, int i2) {
        if (i2 == 0) {
            return 1;
        }
        return (int) Math.ceil((double) (i / i2));
    }

    public static String bitrateLabel(int i) {
        if (i >= 1000) {
            DecimalFormat decimalFormat = new DecimalFormat("#0.##");
            return decimalFormat.format((double) (((float) i) / 1000.0f)) + "kbps";
        }
        return i + "bps";
    }

    public static WOWZSize[] toFrameSizes(WOWZMediaConfig[] wOWZMediaConfigArr) {
        WOWZSize[] wOWZSizeArr = new WOWZSize[wOWZMediaConfigArr.length];
        for (int i = 0; i < wOWZMediaConfigArr.length; i++) {
            if (wOWZMediaConfigArr[i] != null) {
                wOWZSizeArr[i] = new WOWZSize(wOWZMediaConfigArr[i].getVideoFrameSize());
            }
        }
        return wOWZSizeArr;
    }

    public static WOWZMediaConfig[] fromFrameSizes(WOWZSize[] wOWZSizeArr) {
        WOWZMediaConfig[] wOWZMediaConfigArr = new WOWZMediaConfig[wOWZSizeArr.length];
        WOWZSize[] frameSizes = toFrameSizes(PRESET_CONFIGS);
        for (int i = 0; i < wOWZSizeArr.length; i++) {
            wOWZMediaConfigArr[i] = new WOWZMediaConfig();
            int closestToIndex = WOWZSize.closestToIndex(wOWZSizeArr[i], frameSizes);
            if (closestToIndex != -1) {
                wOWZMediaConfigArr[i].set(PRESET_CONFIGS[closestToIndex]);
            }
            wOWZMediaConfigArr[i].setVideoFrameSize(wOWZSizeArr[i]);
        }
        return wOWZMediaConfigArr;
    }

    public void setLowBandwidthScalingFactor(float f) {
        this.mVBELowBandwidthScalingFactor = f;
    }

    public float getLowBandwidthScalingFactor() {
        return this.mVBELowBandwidthScalingFactor;
    }

    public void setFrameRateLowBandwidthSkipCount(int i) {
        this.mVBEFrameRateLowBandwidthSkipCount = i;
    }

    public int getFrameRateLowBandwidthSkipCount() {
        return this.mVBEFrameRateLowBandwidthSkipCount;
    }

    public void setFrameBufferSizeMultiplier(int i) {
        this.mVBEFrameBufferSizeMultiplier = i;
    }

    public int getFrameBufferSizeMultiplier() {
        return this.mVBEFrameBufferSizeMultiplier;
    }

    public void setABREnabled(boolean z) {
        this.mABREnabled = z;
    }

    public boolean isABREnabled() {
        return this.mABREnabled;
    }

    public WOWZMediaConfig() {
        this.mVideoFrameSize = new WOWZSize(DEFAULT_VIDEO_FRAME_SIZE);
        this.mVideoBitRate = 1500;
        this.mVideoFramerate = 30;
        this.mVideoKeyFrameInterval = 30;
        this.mVideoProfileLevel = null;
        this.mVideoRotation = 0;
        this.mVBELowBandwidthScalingFactor = 0.75f;
        this.mVBEFrameBufferSizeMultiplier = 4;
        this.mVBEFrameRateLowBandwidthSkipCount = 4;
        this.mABREnabled = false;
        this.mAudioChannels = 2;
        this.mAudioSampleRate = DEFAULT_AUDIO_SAMPLE_RATE;
        this.mAudioBitRate = DEFAULT_AUDIO_BITRATE;
        this.mVideoEnabled = true;
        this.mUseHLS = false;
        this.mIsPlayback = false;
        this.mAudioEnabled = true;
        this.mPresetLabel = null;
        this.mHLSBackupURL = null;
        this.mConfigName = null;
    }

    public void resetToDefaults() {
        this.mVideoFrameSize = new WOWZSize(DEFAULT_VIDEO_FRAME_SIZE);
        this.mVideoBitRate = 1500;
        this.mVideoFramerate = 30;
        this.mVideoKeyFrameInterval = 30;
        this.mVideoProfileLevel = null;
        this.mVideoRotation = 0;
        this.mVBELowBandwidthScalingFactor = 0.75f;
        this.mVBEFrameBufferSizeMultiplier = 4;
        this.mVBEFrameRateLowBandwidthSkipCount = 4;
        this.mABREnabled = false;
        this.mAudioChannels = 2;
        this.mAudioSampleRate = DEFAULT_AUDIO_SAMPLE_RATE;
        this.mAudioBitRate = DEFAULT_AUDIO_BITRATE;
        this.mVideoEnabled = true;
        this.mUseHLS = false;
        this.mIsPlayback = false;
        this.mHLSBackupURL = null;
        this.mAudioEnabled = true;
        this.mConfigName = null;
        this.mPresetLabel = null;
    }

    WOWZMediaConfig(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this();
        this.mVideoFrameSize = new WOWZSize(i, i2);
        this.mVideoBitRate = i3;
        this.mVideoFramerate = i4;
        this.mVideoKeyFrameInterval = i5;
        this.mAudioChannels = i6;
        this.mAudioSampleRate = i7;
        this.mAudioBitRate = i8;
        this.mPresetLabel = str;
    }

    WOWZMediaConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this((String) null, i, i2, i3, i4, i5, i6, i7, i8);
    }

    WOWZMediaConfig(WOWZSize wOWZSize) {
        this();
        setVideoFrameSize(wOWZSize);
    }

    public WOWZMediaConfig(WOWZMediaConfig wOWZMediaConfig) {
        this();
        set(wOWZMediaConfig);
    }

    public int compareTo(WOWZMediaConfig wOWZMediaConfig) {
        return this.mVideoFrameSize.compareTo(wOWZMediaConfig.getVideoFrameSize());
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof WOWZMediaConfig) && this.mVideoFrameSize.equals(((WOWZMediaConfig) obj).getVideoFrameSize());
    }

    public void set(WOWZMediaConfig wOWZMediaConfig) {
        if (wOWZMediaConfig != null) {
            this.mVideoFrameSize.set(wOWZMediaConfig.getVideoFrameSize());
            this.mVideoBitRate = wOWZMediaConfig.getVideoBitRate();
            this.mVideoFramerate = wOWZMediaConfig.getVideoFramerate();
            this.mVideoKeyFrameInterval = wOWZMediaConfig.getVideoKeyFrameInterval();
            this.mVideoRotation = wOWZMediaConfig.getVideoRotation();
            if (wOWZMediaConfig.getVideoProfileLevel() == null) {
                this.mVideoProfileLevel = null;
            } else {
                WOWZProfileLevel wOWZProfileLevel = this.mVideoProfileLevel;
                if (wOWZProfileLevel != null) {
                    wOWZProfileLevel.set(wOWZMediaConfig.getVideoProfileLevel());
                } else {
                    this.mVideoProfileLevel = new WOWZProfileLevel(wOWZMediaConfig.getVideoProfileLevel());
                }
            }
            this.mVBEFrameRateLowBandwidthSkipCount = wOWZMediaConfig.getFrameRateLowBandwidthSkipCount();
            this.mVBEFrameBufferSizeMultiplier = wOWZMediaConfig.getFrameBufferSizeMultiplier();
            this.mVBELowBandwidthScalingFactor = wOWZMediaConfig.getLowBandwidthScalingFactor();
            this.mABREnabled = wOWZMediaConfig.mABREnabled;
            this.mAudioChannels = wOWZMediaConfig.getAudioChannels();
            this.mAudioSampleRate = wOWZMediaConfig.getAudioSampleRate();
            this.mAudioBitRate = wOWZMediaConfig.getAudioBitRate();
            this.mVideoEnabled = wOWZMediaConfig.isVideoEnabled();
            this.mUseHLS = wOWZMediaConfig.isHLSEnabled();
            this.mAudioEnabled = wOWZMediaConfig.isAudioEnabled();
            this.mIsPlayback = wOWZMediaConfig.getIsPlayback().booleanValue();
            this.mHLSBackupURL = wOWZMediaConfig.getHLSBackupURL();
            this.mConfigName = wOWZMediaConfig.getPlayerExampleAutoconfig();
        }
    }

    public WOWZSize getVideoFrameSize() {
        return this.mVideoFrameSize;
    }

    public void setVideoFrameSize(WOWZSize wOWZSize) {
        this.mVideoFrameSize.set(wOWZSize);
    }

    public void setVideoFrameSize(int i, int i2) {
        this.mVideoFrameSize.setWidth(i);
        this.mVideoFrameSize.setHeight(i2);
    }

    public int getVideoFrameWidth() {
        return this.mVideoFrameSize.getWidth();
    }

    public void setVideoFrameWidth(int i) {
        this.mVideoFrameSize.setWidth(i);
    }

    public int getVideoFrameHeight() {
        return this.mVideoFrameSize.getHeight();
    }

    public void setVideoFrameHeight(int i) {
        this.mVideoFrameSize.setHeight(i);
    }

    public int getVideoRotation() {
        return this.mVideoRotation;
    }

    public void setVideoRotation(int i) {
        this.mVideoRotation = (int) (Math.floor((double) ((i % 360) / 90)) * 90.0d);
    }

    public int getVideoBitRate() {
        return this.mVideoBitRate;
    }

    public void setVideoBitRate(int i) {
        this.mVideoBitRate = i;
    }

    public int getVideoFramerate() {
        return this.mVideoFramerate;
    }

    public void setVideoFramerate(int i) {
        this.mVideoFramerate = i;
    }

    public int getVideoKeyFrameInterval() {
        return this.mVideoKeyFrameInterval;
    }

    public void setVideoKeyFrameInterval(int i) {
        this.mVideoKeyFrameInterval = i;
    }

    public WOWZProfileLevel getVideoProfileLevel() {
        return this.mVideoProfileLevel;
    }

    public void setVideoProfileLevel(int i, int i2) {
        this.mVideoProfileLevel = new WOWZProfileLevel(i, i2);
    }

    public void setVideoProfileLevel(WOWZProfileLevel wOWZProfileLevel) {
        if (wOWZProfileLevel != null) {
            this.mVideoProfileLevel = new WOWZProfileLevel(wOWZProfileLevel);
        } else {
            this.mVideoProfileLevel = null;
        }
    }

    public int getAudioChannels() {
        return this.mAudioChannels;
    }

    public void setAudioChannels(int i) {
        this.mAudioChannels = i;
    }

    public int getAudioSampleRate() {
        return this.mAudioSampleRate;
    }

    public int setAudioSampleRate(int i) {
        int[] iArr = SUPPORTED_AUDIO_SAMPLE_RATES;
        int i2 = iArr[iArr.length - 1];
        int i3 = 0;
        while (true) {
            int[] iArr2 = SUPPORTED_AUDIO_SAMPLE_RATES;
            if (i3 >= iArr2.length) {
                break;
            } else if (i == iArr2[i3] || iArr2[i3] > i) {
                i2 = SUPPORTED_AUDIO_SAMPLE_RATES[i3];
            } else {
                i3++;
            }
        }
        i2 = SUPPORTED_AUDIO_SAMPLE_RATES[i3];
        this.mAudioSampleRate = i2;
        return this.mAudioSampleRate;
    }

    public int getAudioBitRate() {
        return this.mAudioBitRate;
    }

    public void setAudioBitRate(int i) {
        this.mAudioBitRate = i;
    }

    public boolean isVideoEnabled() {
        return this.mVideoEnabled;
    }

    public String getHLSBackupURL() {
        return this.mHLSBackupURL;
    }

    public Boolean getIsPlayback() {
        return Boolean.valueOf(this.mIsPlayback);
    }

    public void setIsPlayback(boolean z) {
        this.mIsPlayback = z;
    }

    public void setHLSBackupURL(String str) {
        this.mHLSBackupURL = str;
    }

    public String getPlayerExampleAutoconfig() {
        return this.mConfigName;
    }

    public void setPlayerExampleAutoconfig(String str) {
        this.mConfigName = str;
    }

    public boolean isHLSEnabled() {
        return this.mUseHLS;
    }

    public void setHLSEnabled(boolean z) {
        this.mUseHLS = z;
    }

    public void setVideoEnabled(boolean z) {
        this.mVideoEnabled = z;
    }

    public boolean isAudioEnabled() {
        return this.mAudioEnabled;
    }

    public void setAudioEnabled(boolean z) {
        this.mAudioEnabled = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WOWZMediaConfig mo58335a() {
        for (WOWZMediaConfig wOWZMediaConfig : PRESET_CONFIGS) {
            if (wOWZMediaConfig.getVideoFrameWidth() == getVideoFrameWidth() && wOWZMediaConfig.getVideoFrameHeight() == getVideoFrameHeight()) {
                return wOWZMediaConfig;
            }
        }
        return null;
    }

    public String getPresetLabel() {
        return this.mPresetLabel;
    }

    public String getPresetLabelByFrameSize() {
        WOWZMediaConfig a = mo58335a();
        if (a != null) {
            return a.getPresetLabel();
        }
        return null;
    }

    public String getLabel(boolean z, boolean z2, boolean z3) {
        return getLabel(z, false, z2, z3);
    }

    public String getLabel(boolean z, boolean z2, boolean z3, boolean z4) {
        StringBuffer stringBuffer = new StringBuffer();
        if (z) {
            stringBuffer.append(getVideoFrameSize().toString());
            if (z2 || z3) {
                String str = null;
                String presetLabelByFrameSize = z2 ? getPresetLabelByFrameSize() : null;
                if (z3) {
                    str = getVideoFrameSize().aspectRatioLabel();
                }
                if (!(presetLabelByFrameSize == null && str == null)) {
                    stringBuffer.append(" (");
                    if (presetLabelByFrameSize != null) {
                        stringBuffer.append(presetLabelByFrameSize);
                        if (str != null) {
                            stringBuffer.append(" - ");
                        }
                    }
                    if (str != null) {
                        stringBuffer.append(str);
                    }
                    stringBuffer.append(")");
                }
            }
        }
        if (z4) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" @ ");
            }
            stringBuffer.append(bitrateLabel(this.mVideoBitRate));
        }
        return stringBuffer.toString();
    }

    public String toString() {
        String str;
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        String presetLabelByFrameSize = getPresetLabelByFrameSize();
        StringBuilder sb = new StringBuilder();
        sb.append("Video enabled             : ");
        String str3 = "yes";
        sb.append(this.mVideoEnabled ? str3 : "no");
        stringBuffer.append(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Using HLS             : ");
        if (this.mUseHLS) {
            str = str3;
        } else {
            str = "no";
        }
        sb2.append(str);
        stringBuffer.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\nVideo frame size          : ");
        WOWZSize wOWZSize = this.mVideoFrameSize;
        String str4 = "null";
        sb3.append(wOWZSize != null ? wOWZSize.toString() : str4);
        stringBuffer.append(sb3.toString());
        stringBuffer.append("\nVideo rotation (degrees)  : " + this.mVideoRotation);
        if (presetLabelByFrameSize != null) {
            stringBuffer.append(" (" + presetLabelByFrameSize + ")");
        }
        if (this.mHLSBackupURL != null) {
            stringBuffer.append("\nHLS Fail Over URL     : " + this.mHLSBackupURL);
        }
        if (this.mConfigName != null) {
            stringBuffer.append("\nConfig Example Name    : " + this.mConfigName);
        }
        stringBuffer.append("\nVideo framerate (fps)     : " + this.mVideoFramerate);
        stringBuffer.append("\nVideo keyframe interval   : " + this.mVideoKeyFrameInterval);
        stringBuffer.append("\nVideo bitrate (kbps)      : " + this.mVideoBitRate);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("\nVideo profile             : ");
        WOWZProfileLevel wOWZProfileLevel = this.mVideoProfileLevel;
        if (wOWZProfileLevel != null) {
            str4 = wOWZProfileLevel.toString();
        }
        sb4.append(str4);
        stringBuffer.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\nABR enabled               : ");
        if (this.mABREnabled) {
            str2 = str3;
        } else {
            str2 = "no";
        }
        sb5.append(str2);
        stringBuffer.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("\n\nAudio enabled             : ");
        if (!this.mAudioEnabled) {
            str3 = "no";
        }
        sb6.append(str3);
        stringBuffer.append(sb6.toString());
        stringBuffer.append("\nAudio channels            : " + this.mAudioChannels);
        stringBuffer.append("\nAudio sample rate (hz)    : " + this.mAudioSampleRate);
        stringBuffer.append("\nAudio bitrate (kbps)      : " + this.mAudioBitRate);
        return stringBuffer.toString();
    }

    public WOWZDataMap toDataMap(WOWZDataMap wOWZDataMap) {
        if (wOWZDataMap == null) {
            return toDataMap();
        }
        String str = "true";
        wOWZDataMap.put("videoEnabled", this.mVideoEnabled ? str : PdfBoolean.FALSE);
        if (this.mVideoEnabled) {
            wOWZDataMap.put("videoFrameWidth", String.valueOf(this.mVideoFrameSize.width));
            wOWZDataMap.put("videoFrameHeight", String.valueOf(this.mVideoFrameSize.height));
            wOWZDataMap.put("videoBitrate", String.valueOf(this.mVideoBitRate));
            wOWZDataMap.put("videoFramerate", String.valueOf(this.mVideoFramerate));
            wOWZDataMap.put("videoKeyframeInterval", String.valueOf(this.mVideoKeyFrameInterval));
            WOWZProfileLevel wOWZProfileLevel = this.mVideoProfileLevel;
            if (wOWZProfileLevel != null) {
                wOWZDataMap.put("videoProfile", wOWZProfileLevel.toString());
            }
        }
        wOWZDataMap.put("abrEnabled", this.mABREnabled ? str : PdfBoolean.FALSE);
        if (this.mABREnabled) {
            wOWZDataMap.put("abrFrameRateLowBandwidthSkipCount", String.valueOf(this.mVBEFrameRateLowBandwidthSkipCount));
            wOWZDataMap.put("abrLowBandwidthScalingFactor", String.valueOf(this.mVBELowBandwidthScalingFactor));
            wOWZDataMap.put("abrFrameBufferSizeMultiplier", String.valueOf(this.mVBEFrameBufferSizeMultiplier));
        }
        if (!this.mAudioEnabled) {
            str = PdfBoolean.FALSE;
        }
        wOWZDataMap.put("audioEnabled", str);
        if (this.mAudioEnabled) {
            wOWZDataMap.put("audioChannels", String.valueOf(this.mVideoBitRate));
            wOWZDataMap.put("audioSampleRate", String.valueOf(this.mVideoFrameSize.width));
            wOWZDataMap.put("audioBitrate", String.valueOf(this.mVideoFrameSize.height));
        }
        return wOWZDataMap;
    }

    public WOWZDataMap toDataMap() {
        return toDataMap(new WOWZDataMap());
    }
}
