package com.wowza.gocoder.sdk.api.android.opengl;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import android.view.Surface;
import com.lowagie.text.pdf.codec.TIFFConstants;
import com.wowza.gocoder.sdk.api.data.WOWZData;
import com.wowza.gocoder.sdk.api.data.WOWZDataList;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.support.p040g.C4300a;
import java.util.Arrays;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* compiled from: GoCoderSDK */
public class WOWZGLES {
    public static final int DEFAULT_GLES_VERSION = 2;
    public static final float[] IDENTITY_MATRIX = new float[16];

    /* renamed from: a */
    private static final String f3544a = "WOWZGLES";

    /* renamed from: b */
    private static final int f3545b = 12610;

    public static String getEglErrorString(int i) {
        switch (i) {
            case 12288:
                return "EGL_SUCCESS: The last function completed without error.";
            case 12289:
                return "EGL_NOT_INITIALIZED: EGL is not initialized or could not be initialized for the specified EGL display connection.";
            case 12290:
                return "EGL_BAD_ACCESS: EGL cannot access a requested resource.";
            case 12291:
                return "EGL_BAD_ALLOC: EGL failed to allocate resources for the requested operation.";
            case 12292:
                return "EGL_BAD_ATTRIBUTE: An unrecognized attribute or attribute value was passed in the attribute list.";
            case 12293:
                return "EGL_BAD_CONFIG: An EGLConfig argument does not name a valid EGL frame buffer configuration.";
            case 12294:
                return "EGL_BAD_CONTEXT: An EGLContext argument does not name a valid EGL rendering context.";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE: The current surface of the calling thread is a window, pixel buffer, or pixmap that is no longer valid.";
            case 12296:
                return "EGL_BAD_DISPLAY: An EGLDisplay argument does not name a valid EGL display connection.";
            case 12297:
                return "EGL_BAD_MATCH: An inconsistent parameter argument was specified.";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP: A NativePixmapType argument does not refer to a valid native pixmap.";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW: A NativeWindowType argument does not refer to a valid native window.";
            case 12300:
                return "EGL_BAD_PARAMETER: One or more parameter argument values are invalid.";
            case 12301:
                return "EGL_BAD_SURFACE: An EGLSurface argument does not name a valid surface.";
            case 12302:
                return "EGL_CONTEXT_LOST: The EGL context has been lost.";
            default:
                return "UNKNOWN EGL ERROR: An unknown EGL error code was specified.";
        }
    }

    public static int surfaceToEGLRotation(int i) {
        if (i == 0) {
            return 90;
        }
        if (i != 1) {
            return i != 2 ? i != 3 ? 0 : 180 : TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
        }
        return 0;
    }

    static {
        Matrix.setIdentityM(IDENTITY_MATRIX, 0);
    }

    public static int checkForEglError(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            String str2 = f3544a;
            WOWZLog.error(str2, str + " returned " + getEglErrorString(eglGetError));
        }
        return eglGetError;
    }

    public static int getEglError() {
        return EGL14.eglGetError();
    }

    public static String getEglInfo(boolean z) {
        WOWZDataMap eglInfoDataMap = getEglInfoDataMap();
        if (eglInfoDataMap == null) {
            return null;
        }
        if (!z) {
            eglInfoDataMap.remove("GLExtensions");
            eglInfoDataMap.remove("EGLExtensions");
        }
        return eglInfoDataMap.toString(true);
    }

    public static WOWZDataMap getEglInfoDataMap() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        checkForEglError("eglGetDisplay");
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            WOWZLog.error(f3544a, "Could not establish connection to EGLDisplay.");
            return null;
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            checkForEglError("eglInitialize");
            WOWZLog.error(f3544a, "Could not initialize EGL14.");
            return null;
        }
        EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
        EGLConfig eglConfig = getEglConfig(eglGetDisplay, 3);
        if (eglConfig != null) {
            eGLContext = EGL14.eglCreateContext(eglGetDisplay, eglConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 3, 12344}, 0);
            if (checkForEglError("eglCreateContext") != 12288) {
                eGLContext = EGL14.EGL_NO_CONTEXT;
            }
        } else {
            WOWZLog.info(f3544a, "Could not establish a GLES3 EGLConfig.");
        }
        if (eGLContext == EGL14.EGL_NO_CONTEXT) {
            WOWZLog.info(f3544a, "Could not create a GLES3 EGLContext, trying GLES2.");
            eglConfig = getEglConfig(eglGetDisplay, 2);
            if (eglConfig == null) {
                WOWZLog.warn(f3544a, "Could not establish a GLES2 EGLConfig.");
            } else {
                eGLContext = EGL14.eglCreateContext(eglGetDisplay, eglConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                if (checkForEglError("eglCreateContext") != 12288) {
                    WOWZLog.warn(f3544a, "Could not create a GLES2 EGLContext.");
                    eGLContext = EGL14.EGL_NO_CONTEXT;
                }
            }
        }
        WOWZDataMap wOWZDataMap = new WOWZDataMap();
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (eGLContext != EGL14.EGL_NO_CONTEXT) {
            eGLSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eglConfig, new int[]{12375, 1, 12374, 1, 12344}, 0);
            checkForEglError("eglCreatePbufferSurface");
            if (eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) {
                eGLSurface = EGL14.EGL_NO_SURFACE;
            } else {
                EGL14.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, eGLContext);
                wOWZDataMap.put("GLVendor", GLES20.glGetString(7936));
                wOWZDataMap.put("GLVersion", GLES20.glGetString(7938));
                wOWZDataMap.put("GLRenderer", GLES20.glGetString(7937));
                wOWZDataMap.put("GLExtensions", (WOWZData) m3496b(GLES20.glGetString(7939)));
                wOWZDataMap.put("EGLVendor", EGL14.eglQueryString(eglGetDisplay, 12371));
                wOWZDataMap.put("EGLVersion", EGL14.eglQueryString(eglGetDisplay, 12372));
                wOWZDataMap.put("EGLClientAPIs", EGL14.eglQueryString(eglGetDisplay, 12429));
                wOWZDataMap.put("EGLExtensions", (WOWZData) m3496b(EGL14.eglQueryString(eglGetDisplay, 12373)));
            }
        }
        EGL14.eglMakeCurrent(eglGetDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        if (eGLSurface == EGL14.EGL_NO_SURFACE) {
            WOWZLog.error(f3544a, "Could not create a surface to query EGL capabilities.");
            wOWZDataMap = null;
        } else {
            EGL14.eglDestroySurface(eglGetDisplay, eGLSurface);
        }
        if (eGLContext != EGL14.EGL_NO_CONTEXT) {
            EGL14.eglDestroyContext(eglGetDisplay, eGLContext);
        }
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(eglGetDisplay);
        return wOWZDataMap;
    }

    public static String getEglInfo() {
        return getEglInfo(true);
    }

    /* renamed from: a */
    private static String m3495a(String str) {
        String[] split = str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        Arrays.sort(split);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(i % 4 == 0 ? "\n    " : ", ");
            sb.append(split[i]);
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static WOWZDataList m3496b(String str) {
        WOWZDataList wOWZDataList = new WOWZDataList();
        String[] split = str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        Arrays.sort(split);
        for (String add : split) {
            wOWZDataList.add(add);
        }
        return wOWZDataList;
    }

    public static String matrixToString(String str, float[] fArr) {
        return C4300a.m4216a(str, fArr);
    }

    public static String matrixToString(float[] fArr) {
        return matrixToString((String) null, fArr);
    }

    public static EGLConfig getEglConfig(EGLDisplay eGLDisplay, int i, boolean z) {
        int i2 = i;
        if (i2 == 2 || i2 == 3) {
            int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
            if (z) {
                iArr[iArr.length - 3] = f3545b;
                iArr[iArr.length - 2] = 1;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            String str = f3544a;
            WOWZLog.error(str, "Unable to find RGB8888 / " + i2 + " EGLConfig");
            return null;
        }
        WOWZLog.error(f3544a, "Invalid OpenGL ES version passed to getEglConfig.");
        return null;
    }

    public static EGLConfig getEglConfig(EGLDisplay eGLDisplay, int i) {
        return getEglConfig(eGLDisplay, i, false);
    }

    public static EGLContext createEglContext(EGLDisplay eGLDisplay, int i, EGLContext eGLContext, boolean z) {
        EGLContext eGLContext2 = EGL14.EGL_NO_CONTEXT;
        if (i == 2 || i == 3) {
            EGLConfig eglConfig = getEglConfig(eGLDisplay, i, z);
            if (eglConfig != null) {
                EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eglConfig, eGLContext, new int[]{12440, i, 12344}, 0);
                if (checkForEglError("eglCreateContext") != 12288) {
                    eglCreateContext = EGL14.EGL_NO_CONTEXT;
                }
                return eglCreateContext;
            }
            WOWZLog.info(f3544a, "Could not create an EGLConfig.");
            return eGLContext2;
        }
        WOWZLog.error(f3544a, "Invalid OpenGL ES version passed to createEglContext.");
        return eGLContext2;
    }

    public static EGLContext createEglContext(EGLDisplay eGLDisplay, int i, EGLContext eGLContext) {
        return createEglContext(eGLDisplay, i, eGLContext, false);
    }

    public static EGLContext createEglContext(EGLDisplay eGLDisplay, int i) {
        return createEglContext(eGLDisplay, i, EGL14.EGL_NO_CONTEXT, false);
    }

    public static EGLConfig getEglContextConfig(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        int[] iArr = new int[1];
        if (!EGL14.eglQueryContext(eGLDisplay, eGLContext, 12328, iArr, 0)) {
            checkForEglError("eglQueryContext");
            WOWZLog.error(f3544a, "An EGL error occurred trying to get EGL_CONFIG_ID for an EGLContext.");
        } else {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(eGLDisplay, new int[]{12328, iArr[0], 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            checkForEglError("eglChooseConfig");
            String str = f3544a;
            WOWZLog.error(str, "Unable to find the eGLConfig with id: " + iArr[1]);
        }
        return null;
    }

    public static int getEglContextVersion(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        int[] iArr = new int[1];
        if (EGL14.eglQueryContext(eGLDisplay, eGLContext, 12440, iArr, 0)) {
            return iArr[0];
        }
        checkForEglError("eglQueryContext");
        WOWZLog.error(f3544a, "An EGL error occurred trying to query EGL_CONTEXT_CLIENT_VERSION.");
        return -1;
    }

    public static void destroyEglContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        if (!EGL14.eglMakeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            checkForEglError("eglMakeCurrent");
            WOWZLog.error(f3544a, "An error occurred attempting to clear the current EGLContext.");
        }
        if (!EGL14.eglDestroyContext(eGLDisplay, eGLContext)) {
            checkForEglError("eglDestroyContext");
            WOWZLog.error(f3544a, "An error occurred attempting to destroy an EGLContext.");
        }
    }

    public static EGLSurface createEglWindowSurface(Object obj, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture)) {
            eGLSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, new int[]{12344}, 0);
            if (eGLSurface == EGL14.EGL_NO_SURFACE) {
                checkForEglError("eglCreateWindowSurface");
                WOWZLog.error(f3544a, "An error occurred attempting to create an EGLSurface.");
            }
        } else {
            WOWZLog.error(f3544a, "Invalid native surface type passed to createEglWindowSurface.");
        }
        return eGLSurface;
    }

    public static WOWZSize getEglSurfaceSize(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        int[] iArr = new int[1];
        if (EGL14.eglQuerySurface(eGLDisplay, eGLSurface, 12375, iArr, 0)) {
            int i = iArr[0];
            if (EGL14.eglQuerySurface(eGLDisplay, eGLSurface, 12374, iArr, 0)) {
                return new WOWZSize(i, iArr[0]);
            }
            checkForEglError("eglQuerySurface");
            WOWZLog.error(f3544a, "An EGL error occurred attempting to query the height of an EGLSurface.");
            return null;
        }
        checkForEglError("eglQuerySurface");
        WOWZLog.error(f3544a, "An EGL error occurred attempting to query the width of an EGLSurface.");
        return null;
    }

    public static EGLConfig getEglSurfaceConfig(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        int[] iArr = new int[1];
        if (!EGL14.eglQuerySurface(eGLDisplay, eGLSurface, 12328, iArr, 0)) {
            checkForEglError("eglQuerySurface");
            WOWZLog.error(f3544a, "An EGL error occurred trying to get EGL_CONFIG_ID for an EGLSurface.");
        } else {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(eGLDisplay, new int[]{12328, iArr[0], 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            checkForEglError("eglChooseConfig");
            String str = f3544a;
            WOWZLog.error(str, "Unable to find the eGLConfig with id: " + iArr[1]);
        }
        return null;
    }

    /* compiled from: GoCoderSDK */
    public static class EglEnv {

        /* renamed from: a */
        private static final String f3546a = "EglEnv";

        /* renamed from: b */
        private EGLDisplay f3547b;

        /* renamed from: c */
        private EGLContext f3548c;

        /* renamed from: d */
        private EGLSurface f3549d;

        /* renamed from: e */
        private int f3550e;

        /* renamed from: f */
        private EGLConfig f3551f;

        /* renamed from: g */
        private boolean f3552g;

        /* renamed from: h */
        private WOWZSize f3553h;

        /* renamed from: i */
        private EGLSurface f3554i;

        /* renamed from: j */
        private Surface f3555j;

        /* renamed from: k */
        private int f3556k;

        public EglEnv(int i, EGLDisplay eGLDisplay, EGLContext eGLContext, EGLContext eGLContext2, Object obj, boolean z) {
            this.f3547b = EGL14.EGL_NO_DISPLAY;
            this.f3548c = EGL14.EGL_NO_CONTEXT;
            this.f3549d = EGL14.EGL_NO_SURFACE;
            this.f3550e = -1;
            this.f3551f = null;
            this.f3552g = false;
            this.f3553h = null;
            this.f3554i = EGL14.EGL_NO_SURFACE;
            this.f3555j = null;
            this.f3556k = -1;
            this.f3552g = z;
            if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
                this.f3547b = EGL14.eglGetDisplay(0);
                WOWZGLES.checkForEglError("eglGetDisplay");
                if (this.f3547b == EGL14.EGL_NO_DISPLAY) {
                    IllegalStateException illegalStateException = new IllegalStateException("Could not initialize EGL.");
                    WOWZLog.error(f3546a, (Throwable) illegalStateException);
                    throw illegalStateException;
                }
            } else {
                this.f3547b = eGLDisplay;
            }
            if (i == -1) {
                this.f3550e = WOWZGLES.getEglContextVersion(this.f3547b, eGLContext2 != EGL14.EGL_NO_CONTEXT ? eGLContext2 : eGLContext);
            } else if (i == 2 || i == 3) {
                this.f3550e = i;
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid OpenGL ES version specified.");
                WOWZLog.error(f3546a, (Throwable) illegalArgumentException);
                throw illegalArgumentException;
            }
            int[] iArr = new int[2];
            boolean eglInitialize = EGL14.eglInitialize(this.f3547b, iArr, 0, iArr, 1);
            WOWZGLES.checkForEglError("eglInitialize");
            if (eglInitialize) {
                if (eGLContext == EGL14.EGL_NO_CONTEXT || eGLContext2 != EGL14.EGL_NO_CONTEXT) {
                    this.f3548c = WOWZGLES.createEglContext(this.f3547b, this.f3550e, eGLContext2, z);
                    if (this.f3548c == EGL14.EGL_NO_CONTEXT && i == -1 && this.f3550e == 3 && eGLContext2 == EGL14.EGL_NO_CONTEXT) {
                        this.f3548c = WOWZGLES.createEglContext(this.f3547b, 2, eGLContext2, z);
                        if (this.f3548c != EGL14.EGL_NO_CONTEXT) {
                            this.f3550e = 2;
                        } else {
                            release();
                            IllegalStateException illegalStateException2 = new IllegalStateException("Unable to create an EGLContext.");
                            WOWZLog.error(f3546a, (Throwable) illegalStateException2);
                            throw illegalStateException2;
                        }
                    }
                } else {
                    this.f3548c = eGLContext;
                }
                this.f3551f = WOWZGLES.getEglContextConfig(this.f3547b, this.f3548c);
                EGLConfig eGLConfig = this.f3551f;
                if (eGLConfig == null) {
                    release();
                    IllegalStateException illegalStateException3 = new IllegalStateException("Unable to identify the EGLConfig for the EGLContext.");
                    WOWZLog.error(f3546a, (Throwable) illegalStateException3);
                    throw illegalStateException3;
                } else if (obj != null) {
                    this.f3549d = WOWZGLES.createEglWindowSurface(obj, this.f3547b, eGLConfig);
                    if (this.f3549d != EGL14.EGL_NO_SURFACE) {
                        this.f3553h = getEglSurfaceSize();
                        return;
                    }
                    release();
                    IllegalStateException illegalStateException4 = new IllegalStateException("Unable to create an EGLSurface.");
                    WOWZLog.error(f3546a, (Throwable) illegalStateException4);
                    throw illegalStateException4;
                }
            } else {
                IllegalStateException illegalStateException5 = new IllegalStateException("Could not initialize EGL.");
                WOWZLog.error(f3546a, (Throwable) illegalStateException5);
                throw illegalStateException5;
            }
        }

        public EglEnv(EGLContext eGLContext, Object obj, boolean z) {
            this(-1, EGL14.EGL_NO_DISPLAY, EGL14.EGL_NO_CONTEXT, eGLContext, obj, z);
        }

        public EglEnv(EGLContext eGLContext, Object obj) {
            this(-1, EGL14.EGL_NO_DISPLAY, EGL14.EGL_NO_CONTEXT, eGLContext, obj, true);
        }

        public EglEnv(EGLContext eGLContext) {
            this(-1, EGL14.EGL_NO_DISPLAY, EGL14.EGL_NO_CONTEXT, eGLContext, (Object) null, true);
        }

        public EglEnv(int i, EGLDisplay eGLDisplay, Object obj, boolean z) {
            this(i, eGLDisplay, EGL14.EGL_NO_CONTEXT, EGL14.EGL_NO_CONTEXT, obj, z);
        }

        public EglEnv(int i, Object obj, boolean z) {
            this(i, EGL14.EGL_NO_DISPLAY, EGL14.EGL_NO_CONTEXT, EGL14.EGL_NO_CONTEXT, obj, z);
        }

        public EglEnv(int i, EGLContext eGLContext, boolean z) {
            this(i, EGL14.EGL_NO_DISPLAY, EGL14.EGL_NO_CONTEXT, eGLContext, (Object) null, z);
        }

        public EglEnv(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface) {
            this(-1, eGLDisplay, eGLContext, EGL14.EGL_NO_CONTEXT, (Object) null, true);
            this.f3549d = eGLSurface;
            this.f3553h = getEglSurfaceSize();
        }

        public EglEnv(EGLDisplay eGLDisplay, EGLContext eGLContext, Object obj) {
            this(-1, eGLDisplay, eGLContext, EGL14.EGL_NO_CONTEXT, obj, true);
        }

        public EglEnv(EGLDisplay eGLDisplay, EGLContext eGLContext) {
            this(-1, eGLDisplay, eGLContext, EGL14.EGL_NO_CONTEXT, (Object) null, true);
        }

        public EglEnv(int i, boolean z) {
            this(i, EGL14.EGL_NO_DISPLAY, EGL14.EGL_NO_CONTEXT, EGL14.EGL_NO_CONTEXT, (Object) null, z);
        }

        public EglEnv(int i) {
            this(i, EGL14.EGL_NO_DISPLAY, EGL14.EGL_NO_CONTEXT, EGL14.EGL_NO_CONTEXT, (Object) null, true);
        }

        public EGLDisplay getEglDisplay() {
            return this.f3547b;
        }

        public EGLContext getEglContext() {
            return this.f3548c;
        }

        public EGLConfig getEglConfig() {
            return this.f3551f;
        }

        public int getEglVersion() {
            return this.f3550e;
        }

        public EGLSurface getEglSurface() {
            return this.f3549d;
        }

        public WOWZSize getEglSurfaceSize() {
            return this.f3553h;
        }

        public boolean makeCurrent() {
            EGLDisplay eGLDisplay = this.f3547b;
            EGLSurface eGLSurface = this.f3549d;
            if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f3548c)) {
                return true;
            }
            WOWZGLES.checkForEglError("eglMakeCurrent");
            WOWZLog.error(f3546a, "An error occurred attempting to make an EGLEnv current.");
            return false;
        }

        public boolean makeCurrent(EGLSurface eGLSurface) {
            if (EGL14.eglMakeCurrent(this.f3547b, this.f3549d, eGLSurface, this.f3548c)) {
                return true;
            }
            WOWZGLES.checkForEglError("eglMakeCurrent");
            WOWZLog.error(f3546a, "An error occurred attempting to make an EGLEnv current with a separate reading surface.");
            return false;
        }

        public boolean makeNothingCurrent() {
            if (EGL14.eglMakeCurrent(this.f3547b, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
                return true;
            }
            WOWZGLES.checkForEglError("eglMakeCurrent");
            WOWZLog.error(f3546a, "An error occurred attempting to clear an EGLEnv.");
            return false;
        }

        public boolean copySurfaceContents(EGLSurface eGLSurface, int i, int i2) {
            if (this.f3550e != 3) {
                WOWZLog.error(f3546a, "Attempt to call glBlitFramebuffer without an OpenGL ES 3 context.");
                return false;
            } else if (this.f3549d == EGL14.EGL_NO_SURFACE) {
                WOWZLog.error(f3546a, "Attempt to copy surface contents with a current destination surface.");
                return false;
            } else if (!makeCurrent(eGLSurface)) {
                return true;
            } else {
                GLES30.glBlitFramebuffer(0, 0, i, i2, 0, 0, this.f3553h.getWidth(), this.f3553h.getHeight(), 16384, 9728);
                int glGetError = GLES30.glGetError();
                if (glGetError == 0) {
                    return true;
                }
                String str = f3546a;
                WOWZLog.error(str, "ERROR: glBlitFramebuffer failed: 0x" + Integer.toHexString(glGetError));
                return false;
            }
        }

        public boolean setPresentationTime(long j) {
            if (EGLExt.eglPresentationTimeANDROID(this.f3547b, this.f3549d, j)) {
                return true;
            }
            WOWZGLES.checkForEglError("eglPresentationTimeANDROID");
            WOWZLog.error(f3546a, "An error occurred attempting to set the EGL presentation time on a surface.");
            return false;
        }

        public boolean swapBuffers() {
            if (EGL14.eglSwapBuffers(this.f3547b, this.f3549d)) {
                return true;
            }
            WOWZGLES.checkForEglError("eglSwapBuffers");
            WOWZLog.error(f3546a, "An error occurred swapping the EGL surface buffers.");
            return false;
        }

        public boolean setSharedEglContext(EGLContext eGLContext) {
            if (this.f3548c != EGL14.EGL_NO_CONTEXT) {
                WOWZGLES.destroyEglContext(this.f3547b, this.f3548c);
                this.f3548c = EGL14.EGL_NO_CONTEXT;
            }
            EGLContext createEglContext = WOWZGLES.createEglContext(this.f3547b, this.f3550e, eGLContext, this.f3552g);
            if (createEglContext != EGL14.EGL_NO_CONTEXT) {
                this.f3548c = createEglContext;
                return true;
            }
            WOWZLog.error(f3546a, "Unable to create EGLContext during shared EGLContext update request.");
            return false;
        }

        public EGLSurface generateEglWindowSurface(Object obj) {
            if ((obj instanceof Surface) || (obj instanceof SurfaceTexture)) {
                if (this.f3549d != EGL14.EGL_NO_SURFACE) {
                    if (!EGL14.eglDestroySurface(this.f3547b, this.f3549d)) {
                        WOWZGLES.checkForEglError("eglDestroySurface");
                        WOWZLog.error(f3546a, "An error occurred attempting to destroy an EGLSurface.");
                    }
                    this.f3549d = EGL14.EGL_NO_SURFACE;
                }
                this.f3549d = WOWZGLES.createEglWindowSurface(obj, this.f3547b, this.f3551f);
            } else {
                WOWZLog.error(f3546a, "Invalid surface type passed to createEglWindowSurface.");
            }
            return this.f3549d;
        }

        public void releaseSurface() {
            if (this.f3549d != EGL14.EGL_NO_SURFACE && !EGL14.eglDestroySurface(this.f3547b, this.f3549d)) {
                WOWZGLES.checkForEglError("eglDestroySurface");
                WOWZLog.error(f3546a, "An error occurred attempting to destroy an EGLSurface.");
            }
            this.f3549d = EGL14.EGL_NO_SURFACE;
            this.f3553h = null;
        }

        public void release() {
            makeNothingCurrent();
            releaseSurface();
            if (this.f3548c != EGL14.EGL_NO_CONTEXT) {
                WOWZGLES.destroyEglContext(this.f3547b, this.f3548c);
            }
            if (this.f3547b != EGL14.EGL_NO_DISPLAY) {
                if (!EGL14.eglReleaseThread()) {
                    WOWZGLES.checkForEglError("eglReleaseThread");
                    WOWZLog.error(f3546a, "An error occurred attempting to release the EGL thread.");
                }
                if (!EGL14.eglTerminate(this.f3547b)) {
                    WOWZGLES.checkForEglError("eglTerminate");
                    WOWZLog.error(f3546a, "An error occurred attempting to terminate the EGLDisplay connection.");
                }
            }
            this.f3547b = EGL14.EGL_NO_DISPLAY;
            this.f3548c = EGL14.EGL_NO_CONTEXT;
            this.f3549d = EGL14.EGL_NO_SURFACE;
            this.f3551f = null;
            this.f3550e = -1;
            this.f3554i = EGL14.EGL_NO_SURFACE;
            this.f3555j = null;
            this.f3556k = -1;
        }

        public EglEnv(EGLContext eGLContext, EGLSurface eGLSurface) {
            this(-1, EGL14.EGL_NO_DISPLAY, EGL14.EGL_NO_CONTEXT, eGLContext, (Object) null, true);
            this.f3554i = eGLSurface;
        }

        public EGLSurface getEglBaseSurface() {
            return this.f3554i;
        }

        public WOWZSize getBaseSurfaceSize() {
            return WOWZGLES.getEglSurfaceSize(this.f3547b, this.f3554i);
        }

        public Surface getNativeSurface() {
            return this.f3555j;
        }

        public int getTextureId() {
            return this.f3556k;
        }

        public void setTextureId(int i) {
            this.f3556k = i;
        }

        public static EGLSurface createEglSurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Surface surface) {
            EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
            EGLConfig eglSurfaceConfig = WOWZGLES.getEglSurfaceConfig(eGLDisplay, eGLSurface);
            if (eglSurfaceConfig != null) {
                eGLSurface2 = EGL14.eglCreateWindowSurface(eGLDisplay, eglSurfaceConfig, surface, new int[]{12344}, 0);
                if (eGLSurface2 == EGL14.EGL_NO_SURFACE) {
                    WOWZGLES.checkForEglError("eglCreateWindowSurface");
                    WOWZLog.error(f3546a, "An error occurred attempting to create an EGLSurface.");
                }
            } else {
                WOWZLog.error(f3546a, "An error occurred trying to retrieve an EGLConfig.");
            }
            return eGLSurface2;
        }

        public boolean setNativeSurface(Surface surface) {
            if (this.f3549d != EGL14.EGL_NO_SURFACE) {
                if (!EGL14.eglDestroySurface(this.f3547b, this.f3549d)) {
                    WOWZGLES.checkForEglError("eglDestroySurface");
                    WOWZLog.error(f3546a, "An error occurred attempting to destroy an EGLSurface.");
                }
                this.f3549d = EGL14.EGL_NO_SURFACE;
            }
            EGLSurface createEglSurface = createEglSurface(this.f3547b, this.f3554i, surface);
            if (createEglSurface != EGL14.EGL_NO_SURFACE) {
                this.f3555j = surface;
                this.f3549d = createEglSurface;
                return true;
            }
            WOWZLog.error(f3546a, "An error occurred attempting to create an EGLSurface.");
            return false;
        }
    }

    public static int checkEglError(String str) {
        return checkForEglError(str);
    }
}
