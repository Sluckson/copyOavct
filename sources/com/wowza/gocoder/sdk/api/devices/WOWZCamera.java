package com.wowza.gocoder.sdk.api.devices;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.View;
import android.view.WindowManager;
import com.lowagie.text.pdf.codec.TIFFConstants;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZPlatformError;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.DebugKt;

/* compiled from: GoCoderSDK */
public class WOWZCamera {
    public static final int DIRECTION_BACK = 0;
    public static final int DIRECTION_FRONT = 1;
    public static final int DIRECTION_INDETERMINATE = -1;
    public static final int FOCUS_MODE_AUTO = 2;
    public static final int FOCUS_MODE_CONTINUOUS = 3;
    public static final int FOCUS_MODE_OFF = 4;
    public static final int TORCH = 1;

    /* renamed from: a */
    private static final String f3653a = "WOWZCamera";

    /* renamed from: b */
    private int f3654b;

    /* renamed from: c */
    private Camera f3655c;

    /* renamed from: d */
    private int f3656d;

    /* renamed from: e */
    private SurfaceTexture f3657e;

    /* renamed from: f */
    private WOWZStatus f3658f;

    /* renamed from: g */
    private boolean f3659g;

    /* renamed from: h */
    private boolean f3660h;

    /* renamed from: i */
    private WOWZSize[] f3661i;

    /* renamed from: j */
    private WOWZSize f3662j;

    /* renamed from: k */
    private List<int[]> f3663k;

    /* renamed from: l */
    private List<String> f3664l;

    /* renamed from: m */
    private boolean f3665m;

    /* renamed from: n */
    private WOWZSize f3666n;

    /* renamed from: o */
    private int f3667o;

    /* renamed from: p */
    private int f3668p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public volatile boolean f3669q;

    /* renamed from: r */
    private int f3670r = -1;

    /* renamed from: a */
    private int m3565a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public static String directionString(int i) {
        return i == 1 ? "Front" : "Back";
    }

    public static int getNumberOfDeviceCameras(Context context) {
        try {
            return Camera.getNumberOfCameras();
        } catch (Exception e) {
            WOWZLog.error(f3653a, (WOWZError) new WOWZPlatformError(58, e));
            return 0;
        }
    }

    public static WOWZCamera[] getDeviceCameras(boolean z, boolean z2, Context context) {
        int numberOfDeviceCameras = getNumberOfDeviceCameras(context);
        ArrayList arrayList = new ArrayList(numberOfDeviceCameras);
        for (int i = 0; i < numberOfDeviceCameras; i++) {
            WOWZCamera wOWZCamera = new WOWZCamera(i);
            if (!z || wOWZCamera.isAvailable()) {
                if (wOWZCamera.isAvailable() && z2 && wOWZCamera.open()) {
                    wOWZCamera.release();
                }
                arrayList.add(wOWZCamera);
            }
        }
        return (WOWZCamera[]) arrayList.toArray(new WOWZCamera[arrayList.size()]);
    }

    public static WOWZCamera[] getDeviceCameras(boolean z, Context context) {
        return getDeviceCameras(z, true, context);
    }

    public static WOWZCamera[] getDeviceCameras(Context context) {
        return getDeviceCameras(false, context);
    }

    public static WOWZCamera[] getAvailableDeviceCameras(Context context) {
        return getDeviceCameras(true, context);
    }

    public static String getCameraInfo(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        WOWZCamera[] deviceCameras = getDeviceCameras(context);
        int i = 0;
        while (i < deviceCameras.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(i > 0 ? "\n\n" : "");
            sb.append(deviceCameras[i].toString());
            stringBuffer.append(sb.toString());
            i++;
        }
        return stringBuffer.toString();
    }

    public static WOWZSize sizeToWzSize(Camera.Size size) {
        return new WOWZSize(size.width, size.height);
    }

    WOWZCamera(int i) {
        this.f3654b = i;
        this.f3655c = null;
        this.f3656d = -1;
        this.f3657e = null;
        this.f3658f = new WOWZStatus();
        this.f3659g = false;
        this.f3660h = false;
        this.f3661i = new WOWZSize[0];
        this.f3662j = null;
        this.f3663k = new ArrayList();
        this.f3665m = false;
        this.f3666n = null;
        this.f3667o = -1;
        this.f3668p = 4;
        this.f3669q = false;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(i, cameraInfo);
            this.f3654b = i;
            this.f3656d = cameraInfo.facing;
            this.f3659g = true;
        } catch (Exception e) {
            WOWZStatus wOWZStatus = this.f3658f;
            wOWZStatus.setError(new WOWZError("An exception occurred attempting to query info about camera ID." + i, e));
            WOWZLog.error(this.f3658f.getLastError());
            this.f3659g = false;
        }
    }

    public int getCameraId() {
        return this.f3654b;
    }

    public WOWZStatus getStatus() {
        return new WOWZStatus(this.f3658f);
    }

    public WOWZError getLastError() {
        return this.f3658f.getLastError();
    }

    public Camera getPlatformDevice() {
        return this.f3655c;
    }

    public boolean isAvailable() {
        return this.f3659g;
    }

    public boolean isDirectional() {
        return getDirection() != -1;
    }

    public int getDirection() {
        return this.f3656d;
    }

    public boolean isFront() {
        return getDirection() == 1;
    }

    public boolean isBack() {
        return getDirection() == 0;
    }

    public boolean isPreviewing() {
        return this.f3658f.isRunning();
    }

    /* renamed from: a */
    private boolean m3569a() {
        return this.f3655c != null;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f3657e;
    }

    public boolean setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.f3658f.clearLastError();
        this.f3657e = surfaceTexture;
        if (!isPreviewing()) {
            return true;
        }
        this.f3655c.stopPreview();
        SurfaceTexture surfaceTexture2 = this.f3657e;
        if (surfaceTexture2 == null) {
            return true;
        }
        try {
            this.f3655c.setPreviewTexture(surfaceTexture2);
            this.f3655c.startPreview();
            return true;
        } catch (IOException e) {
            this.f3658f.setError(new WOWZPlatformError(57, (Exception) e));
            WOWZLog.error(f3653a, this.f3658f.getLastError());
            return false;
        }
    }

    public WOWZSize[] getSupportedFrameSizes() {
        if (!this.f3660h) {
            return null;
        }
        return this.f3661i;
    }

    public WOWZSize[] getOriginalFrameSizes() {
        try {
            WOWZLog.debug("*** getOriginalFrameSizes1 " + this.f3661i.length);
            Camera.Parameters parameters = this.f3655c.getParameters();
            if (parameters.getSupportedPreviewSizes() != null && parameters.getSupportedPreviewSizes().size() > 0) {
                WOWZLog.debug("*** getOriginalFrameSizes2a");
                this.f3661i = m3576b(parameters.getSupportedPreviewSizes());
                WOWZLog.debug("*** getOriginalFrameSizes2b");
            }
            WOWZLog.debug("*** getOriginalFrameSizes2");
            return this.f3661i;
        } catch (Exception unused) {
            return getSupportedFrameSizes();
        }
    }

    public WOWZMediaConfig[] getSupportedConfigs() {
        if (!this.f3660h) {
            return null;
        }
        return WOWZMediaConfig.fromFrameSizes(this.f3661i);
    }

    public WOWZSize getPreferredVideoFrameSize() {
        return this.f3662j;
    }

    public WOWZSize getOptimalPreviewSize(WOWZSize wOWZSize) {
        if (!this.f3660h) {
            return null;
        }
        WOWZSize[] wOWZSizeArr = this.f3661i;
        if (wOWZSizeArr.length == 0) {
            return null;
        }
        for (WOWZSize wOWZSize2 : wOWZSizeArr) {
            if (wOWZSize2.equals(wOWZSize)) {
                return wOWZSize2;
            }
        }
        WOWZSize[] filterByAspectRatio = WOWZSize.filterByAspectRatio(this.f3661i, wOWZSize);
        if (filterByAspectRatio.length > 0) {
            return filterByAspectRatio[filterByAspectRatio.length - 1];
        }
        WOWZSize closestTo = WOWZSize.closestTo(wOWZSize, this.f3661i);
        return closestTo == null ? getPreferredVideoFrameSize() : closestTo;
    }

    public WOWZSize getOptimalPreviewSize(WOWZSize wOWZSize, WOWZSize wOWZSize2) {
        WOWZSize closestTo;
        if (this.f3661i.length == 0) {
            return null;
        }
        if (wOWZSize2 == null || wOWZSize2.isZero()) {
            return getOptimalPreviewSize(wOWZSize);
        }
        for (WOWZSize wOWZSize3 : this.f3661i) {
            if (wOWZSize3.equals(wOWZSize) && wOWZSize2.fitsWithin(wOWZSize3)) {
                return wOWZSize3;
            }
        }
        for (WOWZSize wOWZSize4 : WOWZSize.filterByAspectRatio(this.f3661i, wOWZSize)) {
            if (wOWZSize2.fitsWithin(wOWZSize4)) {
                return wOWZSize4;
            }
        }
        WOWZSize[] findContainers = WOWZSize.findContainers(this.f3661i, wOWZSize2);
        if (findContainers.length > 0 && (closestTo = WOWZSize.closestTo(wOWZSize, findContainers)) != null) {
            return closestTo;
        }
        WOWZSize closestTo2 = WOWZSize.closestTo(wOWZSize, this.f3661i);
        if (closestTo2 == null) {
            return getPreferredVideoFrameSize();
        }
        return closestTo2;
    }

    public boolean hasCapability(int i) {
        if (!this.f3660h) {
            return false;
        }
        if (i == 1) {
            return this.f3665m;
        }
        if (i == 2) {
            return this.f3664l.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        }
        if (i != 3) {
            return false;
        }
        return this.f3664l.contains("continuous-video");
    }

    public boolean open() {
        if (!isAvailable()) {
            return false;
        }
        if (m3569a()) {
            return true;
        }
        this.f3658f.clearLastError();
        this.f3658f.setState(1);
        try {
            this.f3655c = Camera.open(this.f3654b);
            if (!this.f3660h) {
                Camera.Parameters parameters = this.f3655c.getParameters();
                if (parameters.getSupportedPreviewSizes() != null && parameters.getSupportedPreviewSizes().size() > 0) {
                    this.f3661i = m3576b(parameters.getSupportedPreviewSizes());
                }
                Camera.Size preferredPreviewSizeForVideo = parameters.getPreferredPreviewSizeForVideo();
                if (preferredPreviewSizeForVideo != null) {
                    this.f3662j = sizeToWzSize(preferredPreviewSizeForVideo);
                }
                this.f3663k = new ArrayList(parameters.getSupportedPreviewFpsRange());
                this.f3664l = new ArrayList(parameters.getSupportedFocusModes());
                this.f3665m = m3570a(parameters);
                this.f3660h = true;
            }
            this.f3658f.setState(2);
            return true;
        } catch (Exception e) {
            if (this.f3655c != null) {
                release();
            }
            this.f3658f.setError(new WOWZPlatformError(51, e));
            WOWZLog.error(f3653a, this.f3658f.getLastError());
            this.f3658f.setState(0);
            return false;
        }
    }

    public boolean startPreview(Context context, WOWZSize wOWZSize, int i) {
        return startPreview(context, wOWZSize, (WOWZSize) null, i);
    }

    public boolean startPreview(Context context, WOWZSize wOWZSize, WOWZSize wOWZSize2, int i) {
        WOWZSize[] supportedFrameSizes;
        this.f3658f.clearLastError();
        if (isPreviewing()) {
            return true;
        }
        if (this.f3657e == null) {
            this.f3658f.setError(new WOWZPlatformError(56));
            return false;
        } else if (!open()) {
            return false;
        } else {
            try {
                Camera.Parameters parameters = this.f3655c.getParameters();
                this.f3666n = getOptimalPreviewSize(wOWZSize, wOWZSize2);
                if (this.f3666n == null && (supportedFrameSizes = getSupportedFrameSizes()) != null && supportedFrameSizes.length > 0) {
                    this.f3666n = supportedFrameSizes[0];
                }
                parameters.setPreviewSize(this.f3666n.getWidth(), this.f3666n.getHeight());
                if (!this.f3663k.isEmpty()) {
                    if (i < 1000) {
                        i *= 1000;
                    }
                    this.f3667o = m3564a(i);
                    if (this.f3667o != -1) {
                        int[] iArr = this.f3663k.get(this.f3667o);
                        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                    }
                }
                String b = m3574b(this.f3668p);
                if (b != null) {
                    parameters.setFocusMode(b);
                }
                parameters.setRecordingHint(true);
                this.f3655c.setParameters(parameters);
                autoDetectOrientation(context);
                try {
                    this.f3655c.setPreviewTexture(this.f3657e);
                    this.f3655c.startPreview();
                    this.f3658f.setState(3);
                    return true;
                } catch (IOException e) {
                    release();
                    this.f3658f.setError(new WOWZPlatformError(57, (Exception) e));
                    WOWZLog.error(f3653a, this.f3658f.getLastError());
                    return false;
                }
            } catch (Exception e2) {
                release();
                this.f3658f.setError(new WOWZPlatformError(52, e2));
                WOWZLog.error(f3653a, this.f3658f.getLastError());
                return false;
            }
        }
    }

    public void release() {
        if (m3569a()) {
            try {
                this.f3655c.release();
            } catch (Exception e) {
                WOWZLog.error(f3653a, "An exception occurred releasing the camera,", (Throwable) e);
            } catch (Throwable th) {
                this.f3655c = null;
                throw th;
            }
            this.f3655c = null;
        }
    }

    public WOWZSize getFrameSize() {
        return this.f3666n;
    }

    public WOWZSize setFrameSize(WOWZSize wOWZSize) {
        if (!this.f3660h) {
            return null;
        }
        WOWZSize optimalPreviewSize = getOptimalPreviewSize(wOWZSize);
        if (optimalPreviewSize == null) {
            optimalPreviewSize = this.f3666n;
        }
        if (optimalPreviewSize == null) {
            return null;
        }
        WOWZSize wOWZSize2 = this.f3666n;
        if (wOWZSize2 != null && wOWZSize2.equals(optimalPreviewSize)) {
            return this.f3666n;
        }
        if (this.f3666n == null) {
            this.f3666n = new WOWZSize();
        }
        this.f3666n.set(optimalPreviewSize);
        if (m3569a()) {
            if (isPreviewing()) {
                this.f3655c.stopPreview();
            }
            Camera.Parameters parameters = this.f3655c.getParameters();
            parameters.setPreviewSize(this.f3666n.width, this.f3666n.height);
            this.f3655c.setParameters(parameters);
            if (!isPreviewing()) {
                this.f3655c.startPreview();
            }
        }
        return this.f3666n;
    }

    public void stopPreview() {
        this.f3658f.setState(4);
        if (m3569a()) {
            try {
                m3579d();
                if (isPreviewing()) {
                    this.f3655c.stopPreview();
                }
            } catch (Exception e) {
                WOWZLog.error(f3653a, "An exception occurred stopping the camera preview.", (Throwable) e);
            } catch (Throwable th) {
                release();
                throw th;
            }
            release();
        }
        this.f3669q = false;
        this.f3658f.setState(0);
    }

    public void pausePreview() {
        if (m3569a()) {
            if (isPreviewing()) {
                this.f3655c.stopPreview();
            }
            this.f3658f.setState(5);
        }
    }

    public void continuePreview() {
        if (this.f3658f.isPaused() && m3569a()) {
            this.f3655c.startPreview();
            this.f3658f.setState(3);
        }
    }

    public int getFramerate() {
        if (!this.f3660h || this.f3667o == -1 || this.f3663k.isEmpty()) {
            return 0;
        }
        return this.f3663k.get(this.f3667o)[0] / 10000;
    }

    public int setFramerate(int i) {
        if (!this.f3660h || this.f3663k.isEmpty()) {
            return 0;
        }
        int a = m3564a(i < 1000 ? i * 1000 : i);
        if (a == -1) {
            a = this.f3667o;
        }
        if (a == -1) {
            return 0;
        }
        int i2 = this.f3667o;
        if (a == i2) {
            return i2;
        }
        this.f3667o = a;
        int[] iArr = this.f3663k.get(this.f3667o);
        if (i < iArr[0]) {
            i = iArr[0];
        } else if (i > iArr[1]) {
            i = iArr[1];
        }
        if (m3569a()) {
            if (isPreviewing()) {
                this.f3655c.stopPreview();
            }
            Camera.Parameters parameters = this.f3655c.getParameters();
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
            this.f3655c.setParameters(parameters);
            if (isPreviewing()) {
                this.f3655c.startPreview();
            }
        }
        return i;
    }

    public boolean isFrameRateSupported(int i) {
        return m3566a(i * 1000, this.f3663k) != -1;
    }

    /* renamed from: a */
    private int m3564a(int i) {
        List<int[]> list = this.f3663k;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int b = m3573b(i, this.f3663k);
        return b == -1 ? m3568a(this.f3663k) : b;
    }

    public int getDefaultSupported() {
        int i = this.f3670r;
        if (i > -1) {
            return i;
        }
        return m3572b();
    }

    /* renamed from: a */
    private int m3566a(int i, List<int[]> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            int[] iArr = list.get(i2);
            WOWZLog.debug("FPS: findSpecificFrameRateIdx:fpsRange " + iArr[0] + " vs " + i);
            if (iArr[0] == i && iArr[1] == i) {
                return i2;
            }
        }
        WOWZLog.debug("FPS: findSpecificFrameRateIdx: " + -1);
        return -1;
    }

    /* renamed from: b */
    private int m3572b() {
        for (int i = 0; i < this.f3663k.size(); i++) {
            int[] iArr = this.f3663k.get(i);
            if (iArr[0] == iArr[1]) {
                WOWZLog.debug("FPS: findBestFrameRateIdx: " + iArr[1]);
                return iArr[0];
            }
        }
        WOWZLog.debug("FPS: findBestFrameRateIdx: -1");
        return -1;
    }

    /* renamed from: b */
    private int m3573b(int i, List<int[]> list) {
        int i2 = -1;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int[] iArr = list.get(i3);
            WOWZLog.debug("DUPLE [" + i3 + "]: " + iArr[0] + " <range> " + iArr[1] + " :: " + i);
            if ((iArr[0] == i && iArr[1] == i) || (iArr[0] <= i && iArr[1] >= i && i2 == -1)) {
                i2 = i3;
            }
        }
        WOWZLog.debug("DUPLE [sel]: " + i2);
        return i2;
    }

    /* renamed from: a */
    private int m3568a(List<int[]> list) {
        int i;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int[] iArr = list.get(i4);
            if (iArr != null && iArr.length == 2 && (i = iArr[1] - iArr[0]) > i3) {
                i2 = i4;
                i3 = i;
            }
        }
        if (list.size() < i2 || i2 < 0) {
            return -1;
        }
        return i2;
    }

    public boolean isTorchOn() {
        if (!m3569a() || !this.f3665m) {
            return false;
        }
        return this.f3655c.getParameters().getFlashMode().equals("torch");
    }

    public void setTorchOn(boolean z) {
        if (m3569a() && hasCapability(1)) {
            Camera.Parameters parameters = this.f3655c.getParameters();
            if (parameters.getFlashMode().equals("torch") != z) {
                if (z) {
                    m3575b(parameters);
                } else {
                    m3578c(parameters);
                }
            }
        }
    }

    public int getFocusMode() {
        return this.f3668p;
    }

    public void setFocusMode(int i) {
        String b;
        if (isPreviewing() && getFocusMode() != i && (b = m3574b(i)) != null) {
            if (hasCapability(2)) {
                this.f3655c.cancelAutoFocus();
            }
            this.f3669q = false;
            Camera.Parameters parameters = this.f3655c.getParameters();
            parameters.setFocusMode(b);
            this.f3655c.setParameters(parameters);
        }
    }

    /* renamed from: b */
    private String m3574b(int i) {
        String str = null;
        if (i != 3) {
            if (i != 4) {
                return null;
            }
            if (this.f3664l.contains("infinity")) {
                str = "infinity";
            }
            this.f3668p = 4;
            return str;
        } else if (!hasCapability(3)) {
            return null;
        } else {
            this.f3668p = 3;
            return "continuous-video";
        }
    }

    public void setFocusPoint(float f, float f2, int i) {
        if (isPreviewing() && hasCapability(2) && !this.f3669q) {
            this.f3658f.clearLastError();
            this.f3668p = 2;
            this.f3655c.cancelAutoFocus();
            Camera.Parameters parameters = this.f3655c.getParameters();
            Camera.Size previewSize = parameters.getPreviewSize();
            if (parameters.getMaxNumFocusAreas() > 0) {
                int i2 = (int) f;
                int i3 = i / 2;
                int a = m3565a(i2 - i3, 0, previewSize.width - i);
                int i4 = (int) f2;
                int a2 = m3565a(i4 - i3, 0, previewSize.height - i);
                Rect rect = new Rect(a, a2, a + i, a2 + i);
                Rect rect2 = new Rect(((rect.left * 2000) / previewSize.width) - 1000, ((rect.top * 2000) / previewSize.height) - 1000, ((rect.right * 2000) / previewSize.width) - 1000, ((rect.bottom * 2000) / previewSize.height) - 1000);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(rect2, 1000));
                parameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                parameters.setFocusAreas(arrayList);
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    int intValue = Float.valueOf(((float) i) * 1.5f).intValue();
                    int i5 = intValue / 2;
                    int a3 = m3565a(i2 - i5, 0, previewSize.width - intValue);
                    int a4 = m3565a(i4 - i5, 0, previewSize.height - intValue);
                    Rect rect3 = new Rect(a3, a4, a3 + intValue, intValue + a4);
                    Rect rect4 = new Rect(((rect3.left * 2000) / previewSize.width) - 1000, ((rect3.top * 2000) / previewSize.height) - 1000, ((rect3.right * 2000) / previewSize.width) - 1000, ((rect3.bottom * 2000) / previewSize.height) - 1000);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new Camera.Area(rect4, 1000));
                    parameters.setMeteringAreas(arrayList2);
                }
                try {
                    this.f3655c.setParameters(parameters);
                    this.f3669q = true;
                    this.f3655c.autoFocus(new Camera.AutoFocusCallback() {
                        public void onAutoFocus(boolean z, Camera camera) {
                            boolean unused = WOWZCamera.this.f3669q = false;
                        }
                    });
                } catch (Exception e) {
                    this.f3669q = false;
                    this.f3658f.setError(new WOWZPlatformError(55, e));
                    WOWZLog.error(f3653a, this.f3658f.getLastError());
                }
            }
        }
    }

    /* renamed from: b */
    private WOWZSize[] m3576b(List<Camera.Size> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Camera.Size next : list) {
            WOWZLog.debug("FRAME SIZE: WOWZCamera: " + next.width + " x " + next.height);
            arrayList.add(new WOWZSize(next.width, next.height));
        }
        Collections.sort(arrayList);
        return (WOWZSize[]) arrayList.toArray(new WOWZSize[arrayList.size()]);
    }

    /* renamed from: a */
    private boolean m3570a(Camera.Parameters parameters) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes == null) {
            return false;
        }
        for (String equals : supportedFlashModes) {
            if (equals.equals("torch")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m3575b(Camera.Parameters parameters) {
        this.f3658f.clearLastError();
        if (m3569a() && hasCapability(1)) {
            if (parameters == null) {
                parameters = this.f3655c.getParameters();
            }
            try {
                parameters.setFlashMode("torch");
                this.f3655c.setParameters(parameters);
            } catch (Exception e) {
                this.f3658f.setError(new WOWZPlatformError(53, e));
                WOWZLog.error(f3653a, this.f3658f.getLastError());
            }
        }
    }

    /* renamed from: c */
    private void m3577c() {
        m3575b((Camera.Parameters) null);
    }

    /* renamed from: c */
    private void m3578c(Camera.Parameters parameters) {
        this.f3658f.clearLastError();
        if (m3569a() && this.f3665m) {
            if (parameters == null) {
                try {
                    parameters = this.f3655c.getParameters();
                } catch (Exception e) {
                    this.f3658f.setError(new WOWZPlatformError(53, e));
                    WOWZLog.error(f3653a, this.f3658f.getLastError());
                    return;
                }
            }
            parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            this.f3655c.setParameters(parameters);
        }
    }

    /* renamed from: d */
    private void m3579d() throws RuntimeException {
        m3578c((Camera.Parameters) null);
    }

    /* access modifiers changed from: protected */
    public int autoDetectOrientation(Context context) {
        int i;
        int i2 = 0;
        if (!m3569a()) {
            return 0;
        }
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
            }
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f3654b, cameraInfo);
        if (this.f3656d == 1) {
            i = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        } else {
            i = ((cameraInfo.orientation - i2) + 360) % 360;
        }
        this.f3655c.setDisplayOrientation(i);
        return i;
    }

    /* renamed from: a */
    private int m3567a(Context context) {
        if (!m3569a()) {
            return -1;
        }
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
            }
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f3654b, cameraInfo);
        if (this.f3656d == 1) {
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    public RectF toViewCoords(View view, Rect rect) {
        Matrix matrix = new Matrix();
        RectF rectF = new RectF(rect);
        boolean z = true;
        if (this.f3656d != 1) {
            z = false;
        }
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate((float) m3567a(view.getContext()));
        matrix.postScale(((float) view.getWidth()) / 2000.0f, ((float) view.getHeight()) / 2000.0f);
        matrix.postTranslate(((float) view.getWidth()) / 2.0f, ((float) view.getHeight()) / 2.0f);
        matrix.mapRect(rectF);
        return rectF;
    }

    public String toString() {
        return toDataMap().toString(true);
    }

    public WOWZDataMap toDataMap() {
        WOWZDataMap wOWZDataMap = new WOWZDataMap();
        wOWZDataMap.put("cameraId", this.f3654b);
        wOWZDataMap.put("available", isAvailable());
        if (isAvailable()) {
            wOWZDataMap.put("direction", directionString(getDirection()).toLowerCase());
            wOWZDataMap.put("previewSizes", Arrays.toString(this.f3661i));
            wOWZDataMap.put("focusModes", this.f3664l.toString());
            wOWZDataMap.put("hasTorch", this.f3665m);
        } else {
            wOWZDataMap.put("lastError", this.f3658f.getLastError().toString());
        }
        return wOWZDataMap;
    }
}
