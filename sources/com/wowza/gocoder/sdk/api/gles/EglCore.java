package com.wowza.gocoder.sdk.api.gles;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;

/* compiled from: GoCoderSDK */
public final class EglCore {
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;

    /* renamed from: a */
    private static final String f3758a = "GlUtil";

    /* renamed from: b */
    private static final int f3759b = 12610;

    /* renamed from: c */
    private EGLDisplay f3760c;

    /* renamed from: d */
    private EGLContext f3761d;

    /* renamed from: e */
    private EGLConfig f3762e;

    /* renamed from: f */
    private int f3763f;

    public EglCore() {
        this((EGLContext) null, 0);
    }

    public EglCore(EGLContext eGLContext, int i) {
        EGLConfig a;
        this.f3760c = EGL14.EGL_NO_DISPLAY;
        this.f3761d = EGL14.EGL_NO_CONTEXT;
        this.f3762e = null;
        this.f3763f = -1;
        if (this.f3760c == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            this.f3760c = EGL14.eglGetDisplay(0);
            if (this.f3760c != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(this.f3760c, iArr, 0, iArr, 1)) {
                    if (!((i & 2) == 0 || (a = m3619a(i, 3)) == null)) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f3760c, a, eGLContext, new int[]{12440, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.f3762e = a;
                            this.f3761d = eglCreateContext;
                            this.f3763f = 3;
                        }
                    }
                    if (this.f3761d == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig a2 = m3619a(i, 2);
                        if (a2 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f3760c, a2, eGLContext, new int[]{12440, 2, 12344}, 0);
                            m3620a("eglCreateContext");
                            this.f3762e = a2;
                            this.f3761d = eglCreateContext2;
                            this.f3763f = 2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig.");
                        }
                    }
                    EGL14.eglQueryContext(this.f3760c, this.f3761d, 12440, new int[1], 0);
                    return;
                }
                this.f3760c = null;
                throw new RuntimeException("Unable to initialize EGL14.");
            }
            throw new RuntimeException("Unable to get EGL14 display.");
        }
        throw new RuntimeException("EGL already set up.");
    }

    /* renamed from: a */
    private EGLConfig m3619a(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[iArr.length - 3] = f3759b;
            iArr[iArr.length - 2] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f3760c, iArr, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w("GlUtil", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    public void release() {
        if (this.f3760c != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.f3760c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f3760c, this.f3761d);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f3760c);
        }
        this.f3760c = EGL14.EGL_NO_DISPLAY;
        this.f3761d = EGL14.EGL_NO_CONTEXT;
        this.f3762e = null;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.f3760c != EGL14.EGL_NO_DISPLAY) {
                Log.w("GlUtil", "WARNING: EglCore was not explicitly released -- state may be leaked.");
                release();
            }
        } finally {
            super.finalize();
        }
    }

    public void releaseSurface(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f3760c, eGLSurface);
    }

    public EGLSurface createWindowSurface(Object obj) {
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture)) {
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f3760c, this.f3762e, obj, new int[]{12344}, 0);
            m3620a("eglCreateWindowSurface");
            if (eglCreateWindowSurface != null) {
                return eglCreateWindowSurface;
            }
            throw new RuntimeException("Surface was null.");
        }
        throw new RuntimeException("Invalid surface: " + obj);
    }

    public EGLSurface createOffscreenSurface(int i, int i2) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f3760c, this.f3762e, new int[]{12375, i, 12374, i2, 12344}, 0);
        m3620a("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new RuntimeException("Surface was null.");
    }

    public void makeCurrent(EGLSurface eGLSurface) {
        EGLDisplay eGLDisplay = this.f3760c;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        if (!EGL14.eglMakeCurrent(this.f3760c, eGLSurface, eGLSurface, this.f3761d)) {
            throw new RuntimeException("eglMakeCurrent failed.");
        }
    }

    public void makeCurrent(EGLSurface eGLSurface, EGLSurface eGLSurface2) {
        EGLDisplay eGLDisplay = this.f3760c;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        if (!EGL14.eglMakeCurrent(this.f3760c, eGLSurface, eGLSurface2, this.f3761d)) {
            throw new RuntimeException("eglMakeCurrent(draw,read) failed.");
        }
    }

    public void makeNothingCurrent() {
        if (!EGL14.eglMakeCurrent(this.f3760c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean swapBuffers(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.f3760c, eGLSurface);
    }

    public void setPresentationTime(EGLSurface eGLSurface, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f3760c, eGLSurface, j);
    }

    public boolean isCurrent(EGLSurface eGLSurface) {
        return this.f3761d.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    public int querySurface(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f3760c, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    public String queryString(int i) {
        return EGL14.eglQueryString(this.f3760c, i);
    }

    public int getGlVersion() {
        return this.f3763f;
    }

    public static void logCurrent(String str) {
        EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        EGLSurface eglGetCurrentSurface = EGL14.eglGetCurrentSurface(12377);
        Log.i("GlUtil", "Current EGL (" + str + "): display=" + eglGetCurrentDisplay + ", context=" + eglGetCurrentContext + ", surface=" + eglGetCurrentSurface);
    }

    /* renamed from: a */
    private void m3620a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            WOWZLog.debug("EGLCore", "ERROR MESSAGE: " + str + ": EGL error[" + EGL14.eglGetError() + "]: 0x" + Integer.toHexString(EGL14.eglGetError()));
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }
}
