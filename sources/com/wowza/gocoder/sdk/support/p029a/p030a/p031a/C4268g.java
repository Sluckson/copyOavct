package com.wowza.gocoder.sdk.support.p029a.p030a.p031a;

import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.wowza.gocoder.sdk.support.a.a.a.g */
/* compiled from: GoCoderSDK */
public class C4268g {

    /* renamed from: a */
    public static final int f3987a = 4;

    /* renamed from: b */
    public static final int f3988b = 2;

    /* renamed from: c */
    private static final String f3989c = "Utilities";

    /* renamed from: a */
    public static int m3746a(int i, int i2, C4260a[] aVarArr) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i);
            GLES20.glAttachShader(glCreateProgram, i2);
            for (C4260a aVar : aVarArr) {
                GLES20.glBindAttribLocation(glCreateProgram, aVar.mo58976a(), aVar.mo58977b());
            }
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] == 0) {
                Log.v(f3989c, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                glCreateProgram = 0;
            }
        }
        if (glCreateProgram != 0) {
            return glCreateProgram;
        }
        throw new RuntimeException("Error creating program.");
    }

    /* renamed from: a */
    public static int m3747a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                Log.v(f3989c, "Shader fail info: " + GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                glCreateShader = 0;
            }
        }
        if (glCreateShader != 0) {
            return glCreateShader;
        }
        throw new RuntimeException("Error creating shader " + i);
    }

    /* renamed from: a */
    public static FloatBuffer m3748a(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        return asFloatBuffer;
    }
}
