package com.wowza.gocoder.sdk.api.devices;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Handler;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZPlatformError;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.DebugKt;

/* compiled from: GoCoderSDK */
public class WOWZCamera2 {

    /* renamed from: A */
    private static final int f3672A = 1920;

    /* renamed from: B */
    private static final int f3673B = 1080;
    public static final int DIRECTION_BACK = 0;
    public static final int DIRECTION_FRONT = 1;
    public static final int DIRECTION_INDETERMINATE = -1;
    public static final int FOCUS_MODE_AUTO = 2;
    public static final int FOCUS_MODE_CONTINUOUS = 3;
    public static final int FOCUS_MODE_OFF = 4;
    public static final int TORCH = 1;

    /* renamed from: b */
    static final /* synthetic */ boolean f3674b = (!WOWZCamera2.class.desiredAssertionStatus());

    /* renamed from: c */
    private static final String f3675c = WOWZCamera.class.getSimpleName();

    /* renamed from: v */
    private static final int f3676v = 0;

    /* renamed from: w */
    private static final int f3677w = 1;

    /* renamed from: x */
    private static final int f3678x = 2;

    /* renamed from: y */
    private static final int f3679y = 3;

    /* renamed from: z */
    private static final int f3680z = 4;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f3681C = 0;

    /* renamed from: D */
    private CameraCaptureSession.CaptureCallback f3682D = new CameraCaptureSession.CaptureCallback() {
        /* renamed from: a */
        private void m3603a(CaptureResult captureResult) {
            int a = WOWZCamera2.this.f3681C;
            if (a == 0) {
                return;
            }
            if (a == 1) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num != null) {
                    if (4 == num.intValue() || 5 == num.intValue()) {
                        Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                        if (num2 == null || num2.intValue() == 2) {
                            int unused = WOWZCamera2.this.f3681C = 4;
                        }
                    }
                }
            } else if (a == 2) {
                Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num3 == null || num3.intValue() == 5 || num3.intValue() == 4) {
                    int unused2 = WOWZCamera2.this.f3681C = 3;
                }
            } else if (a == 3) {
                Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num4 == null || num4.intValue() != 5) {
                    int unused3 = WOWZCamera2.this.f3681C = 4;
                }
            }
        }

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            m3603a(captureResult);
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            m3603a(totalCaptureResult);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: E */
    public CaptureRequest f3683E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public CameraCaptureSession f3684F;

    /* renamed from: G */
    private Handler f3685G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public CaptureRequest.Builder f3686H;

    /* renamed from: a */
    CameraManager f3687a;

    /* renamed from: d */
    private CameraDevice.StateCallback f3688d = new CameraDevice.StateCallback() {
        public void onDisconnected(CameraDevice cameraDevice) {
        }

        public void onError(CameraDevice cameraDevice, int i) {
        }

        public void onOpened(CameraDevice cameraDevice) {
            CameraDevice unused = WOWZCamera2.this.f3690f = cameraDevice;
        }
    };

    /* renamed from: e */
    private int f3689e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CameraDevice f3690f;

    /* renamed from: g */
    private int f3691g;

    /* renamed from: h */
    private SurfaceTexture f3692h;

    /* renamed from: i */
    private WOWZStatus f3693i;

    /* renamed from: j */
    private boolean f3694j;

    /* renamed from: k */
    private boolean f3695k;

    /* renamed from: l */
    private WOWZSize[] f3696l;

    /* renamed from: m */
    private WOWZSize f3697m;

    /* renamed from: n */
    private List<int[]> f3698n;

    /* renamed from: o */
    private List<String> f3699o;

    /* renamed from: p */
    private boolean f3700p;

    /* renamed from: q */
    private WOWZSize f3701q;

    /* renamed from: r */
    private int f3702r;

    /* renamed from: s */
    private int f3703s;

    /* renamed from: t */
    private volatile boolean f3704t;

    /* renamed from: u */
    private Context f3705u;

    /* renamed from: a */
    private int m3581a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: a */
    private boolean m3591a(Camera.Parameters parameters) {
        return false;
    }

    /* renamed from: b */
    private String m3594b(int i) {
        return null;
    }

    /* renamed from: b */
    private void m3596b(Camera.Parameters parameters) {
    }

    /* renamed from: b */
    private WOWZSize[] m3597b(List<Size> list) {
        return null;
    }

    /* renamed from: c */
    private int m3598c(Context context) {
        return 0;
    }

    /* renamed from: c */
    private void m3601c(Camera.Parameters parameters) {
    }

    /* renamed from: c */
    private WOWZSize[] m3602c(List<Camera.Size> list) {
        return null;
    }

    public static String directionString(int i) {
        return i == 1 ? "Front" : "Back";
    }

    /* access modifiers changed from: protected */
    public int autoDetectOrientation(Context context) {
        return 0;
    }

    public void continuePreview() {
    }

    public boolean isTorchOn() {
        return false;
    }

    public boolean open(Context context) {
        return true;
    }

    public void pausePreview() {
    }

    public void setFocusMode(int i) {
    }

    public void setFocusPoint(float f, float f2, int i) {
    }

    public int setFramerate(int i) {
        return 0;
    }

    public void setTorchOn(boolean z) {
    }

    public WOWZDataMap toDataMap() {
        return null;
    }

    public RectF toViewCoords(View view, Rect rect) {
        return null;
    }

    public static int getNumberOfDeviceCameras(Context context) {
        try {
            return m3588a(context).getCameraIdList().length;
        } catch (Exception e) {
            WOWZLog.error(f3675c, (WOWZError) new WOWZPlatformError(58, e));
            return 0;
        }
    }

    public static WOWZCamera2[] getDeviceCameras(boolean z, boolean z2, Context context) {
        int numberOfDeviceCameras = getNumberOfDeviceCameras(context);
        ArrayList arrayList = new ArrayList(numberOfDeviceCameras);
        for (int i = 0; i < numberOfDeviceCameras; i++) {
            WOWZCamera2 wOWZCamera2 = new WOWZCamera2(i, context);
            if (!z || wOWZCamera2.isAvailable()) {
                arrayList.add(wOWZCamera2);
            }
        }
        return (WOWZCamera2[]) arrayList.toArray(new WOWZCamera2[arrayList.size()]);
    }

    public static WOWZCamera2[] getDeviceCameras(boolean z, Context context) {
        return getDeviceCameras(z, true, context);
    }

    public static WOWZCamera2[] getDeviceCameras(Context context) {
        return getDeviceCameras(false, context);
    }

    public static WOWZCamera2[] getAvailableDeviceCameras(Context context) {
        return getDeviceCameras(true, context);
    }

    public static String getCameraInfo(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        WOWZCamera2[] deviceCameras = getDeviceCameras(context);
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

    WOWZCamera2(int i, Context context) {
        this.f3689e = i;
        this.f3690f = null;
        this.f3691g = -1;
        this.f3692h = null;
        this.f3693i = new WOWZStatus();
        this.f3694j = false;
        this.f3695k = false;
        this.f3696l = new WOWZSize[0];
        this.f3697m = null;
        this.f3698n = new ArrayList();
        this.f3700p = false;
        this.f3701q = null;
        this.f3702r = -1;
        this.f3703s = 4;
        this.f3704t = false;
        this.f3705u = context;
        this.f3687a = null;
        try {
            this.f3687a = m3588a(this.f3705u);
            CameraCharacteristics cameraCharacteristics = this.f3687a.getCameraCharacteristics(String.valueOf(i));
            this.f3689e = i;
            this.f3691g = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
            this.f3694j = true;
        } catch (Exception e) {
            WOWZStatus wOWZStatus = this.f3693i;
            wOWZStatus.setError(new WOWZError("An exception occurred attempting to query info about camera ID." + i, e));
            WOWZLog.error(this.f3693i.getLastError());
            this.f3694j = false;
        }
    }

    public int getCameraId() {
        return this.f3689e;
    }

    public WOWZStatus getStatus() {
        return new WOWZStatus(this.f3693i);
    }

    public WOWZError getLastError() {
        return this.f3693i.getLastError();
    }

    public CameraDevice getPlatformDevice() {
        return this.f3690f;
    }

    public boolean isAvailable() {
        return this.f3694j;
    }

    public boolean isDirectional() {
        return getDirection() != -1;
    }

    public int getDirection() {
        return this.f3691g;
    }

    public boolean isFront() {
        return getDirection() == 1;
    }

    public boolean isBack() {
        return getDirection() == 0;
    }

    public boolean isPreviewing() {
        return this.f3693i.isRunning();
    }

    /* renamed from: a */
    private boolean m3590a() {
        return this.f3690f != null;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.f3692h;
    }

    public boolean setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.f3693i.clearLastError();
        this.f3692h = surfaceTexture;
        return true;
    }

    public WOWZSize[] getSupportedFrameSizes() {
        return this.f3696l;
    }

    public WOWZMediaConfig[] getSupportedConfigs() {
        if (!this.f3695k) {
            return null;
        }
        return WOWZMediaConfig.fromFrameSizes(this.f3696l);
    }

    public WOWZSize getPreferredVideoFrameSize() {
        return this.f3697m;
    }

    public WOWZSize getOptimalPreviewSize(WOWZSize wOWZSize) {
        if (!this.f3695k) {
            return null;
        }
        WOWZSize[] wOWZSizeArr = this.f3696l;
        if (wOWZSizeArr.length == 0) {
            return null;
        }
        for (WOWZSize wOWZSize2 : wOWZSizeArr) {
            if (wOWZSize2.equals(wOWZSize)) {
                return wOWZSize2;
            }
        }
        WOWZSize[] filterByAspectRatio = WOWZSize.filterByAspectRatio(this.f3696l, wOWZSize);
        if (filterByAspectRatio.length > 0) {
            return filterByAspectRatio[filterByAspectRatio.length - 1];
        }
        WOWZSize closestTo = WOWZSize.closestTo(wOWZSize, this.f3696l);
        return closestTo == null ? getPreferredVideoFrameSize() : closestTo;
    }

    public WOWZSize getOptimalPreviewSize(WOWZSize wOWZSize, WOWZSize wOWZSize2) {
        WOWZSize closestTo;
        if (this.f3696l.length == 0) {
            return null;
        }
        if (wOWZSize2 == null || wOWZSize2.isZero()) {
            return getOptimalPreviewSize(wOWZSize);
        }
        for (WOWZSize wOWZSize3 : this.f3696l) {
            if (wOWZSize3.equals(wOWZSize) && wOWZSize2.fitsWithin(wOWZSize3)) {
                return wOWZSize3;
            }
        }
        for (WOWZSize wOWZSize4 : WOWZSize.filterByAspectRatio(this.f3696l, wOWZSize)) {
            if (wOWZSize2.fitsWithin(wOWZSize4)) {
                return wOWZSize4;
            }
        }
        WOWZSize[] findContainers = WOWZSize.findContainers(this.f3696l, wOWZSize2);
        if (findContainers.length > 0 && (closestTo = WOWZSize.closestTo(wOWZSize, findContainers)) != null) {
            return closestTo;
        }
        WOWZSize closestTo2 = WOWZSize.closestTo(wOWZSize, this.f3696l);
        if (closestTo2 == null) {
            return getPreferredVideoFrameSize();
        }
        return closestTo2;
    }

    public boolean hasCapability(int i) {
        if (!this.f3695k) {
            return false;
        }
        try {
            m3588a(this.f3705u).getCameraCharacteristics(String.valueOf(this.f3689e));
            if (i == 1) {
                return this.f3700p;
            }
            if (i == 2) {
                return this.f3699o.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
            if (i != 3) {
                return false;
            }
            return this.f3699o.contains("continuous-video");
        } catch (Exception unused) {
        }
    }

    public static List<Size> getSupportedPreviewSizes(Context context, int i) {
        try {
            Size[] outputSizes = ((StreamConfigurationMap) m3588a(context).getCameraCharacteristics(String.valueOf(i)).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(ImageReader.class);
            ArrayList arrayList = new ArrayList();
            for (Size add : outputSizes) {
                arrayList.add(add);
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (CameraAccessException e) {
            WOWZLog.debug("Error getting preview sizes: " + e.getMessage());
            return null;
        }
    }

    public boolean startPreview(Context context, WOWZSize wOWZSize, int i) {
        return startPreview(context, wOWZSize, (WOWZSize) null, i);
    }

    public boolean startPreview(Context context, WOWZSize wOWZSize, WOWZSize wOWZSize2, int i) {
        try {
            if (!f3674b) {
                if (this.f3692h == null) {
                    throw new AssertionError();
                }
            }
            this.f3692h.setDefaultBufferSize(this.f3701q.getWidth(), this.f3701q.getHeight());
            Surface surface = new Surface(this.f3692h);
            this.f3686H = this.f3690f.createCaptureRequest(1);
            this.f3686H.addTarget(surface);
            this.f3690f.createCaptureSession(Arrays.asList(new Surface[]{surface}), new CameraCaptureSession.StateCallback() {
                public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                }

                public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    if (WOWZCamera2.this.f3690f != null) {
                        CameraCaptureSession unused = WOWZCamera2.this.f3684F = cameraCaptureSession;
                        WOWZCamera2.this.f3686H.set(CaptureRequest.CONTROL_AF_MODE, 4);
                        WOWZCamera2 wOWZCamera2 = WOWZCamera2.this;
                        CaptureRequest unused2 = wOWZCamera2.f3683E = wOWZCamera2.f3686H.build();
                    }
                }
            }, (Handler) null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void release() {
        if (m3590a()) {
            try {
                this.f3690f.close();
            } catch (Exception e) {
                WOWZLog.error(f3675c, "An exception occurred releasing the camera,", (Throwable) e);
            } catch (Throwable th) {
                this.f3690f = null;
                throw th;
            }
            this.f3690f = null;
        }
    }

    public WOWZSize getFrameSize() {
        return this.f3701q;
    }

    public WOWZSize setFrameSize(WOWZSize wOWZSize) {
        return this.f3701q;
    }

    public void stopPreview() {
        CameraCaptureSession cameraCaptureSession = this.f3684F;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.f3684F = null;
        }
        CameraDevice cameraDevice = this.f3690f;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.f3690f = null;
        }
    }

    public int getFramerate() {
        if (!this.f3695k || this.f3702r == -1 || this.f3698n.isEmpty()) {
            return 0;
        }
        return this.f3698n.get(this.f3702r)[0] / 10000;
    }

    /* renamed from: a */
    private int m3580a(int i) {
        List<int[]> list = this.f3698n;
        if (list != null && !list.isEmpty()) {
            try {
                Range[] rangeArr = (Range[]) this.f3687a.getCameraCharacteristics(String.valueOf(this.f3689e)).get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                int a = m3582a(i, this.f3698n);
                return a == -1 ? m3585a(this.f3698n) : a;
            } catch (CameraAccessException unused) {
            }
        }
        return -1;
    }

    /* renamed from: a */
    private int m3582a(int i, List<int[]> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            int[] iArr = list.get(i2);
            if (iArr[0] == i && iArr[1] == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private int m3585a(List<int[]> list) {
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

    public int getFocusMode() {
        return this.f3703s;
    }

    /* renamed from: b */
    private void m3595b() {
        m3596b((Camera.Parameters) null);
    }

    /* renamed from: c */
    private void m3600c() throws RuntimeException {
        m3601c((Camera.Parameters) null);
    }

    /* renamed from: a */
    private static CameraManager m3588a(Context context) {
        return (CameraManager) context.getSystemService("camera");
    }

    /* renamed from: b */
    private static WindowManager m3593b(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public String toString() {
        return toDataMap().toString(true);
    }
}
