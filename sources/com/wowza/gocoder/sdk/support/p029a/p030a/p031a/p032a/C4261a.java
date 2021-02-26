package com.wowza.gocoder.sdk.support.p029a.p030a.p031a.p032a;

import com.wowza.gocoder.sdk.support.p029a.p030a.p031a.C4260a;

/* renamed from: com.wowza.gocoder.sdk.support.a.a.a.a.a */
/* compiled from: GoCoderSDK */
public class C4261a extends C4262b {

    /* renamed from: a */
    private static final C4260a[] f3918a = {C4260a.A_Position, C4260a.A_TexCoordinate, C4260a.A_MVPMatrixIndex};

    /* renamed from: b */
    private static final String f3919b = "uniform mat4 u_MVPMatrix[24];      \nattribute float a_MVPMatrixIndex; \nattribute vec4 a_Position;     \nattribute vec2 a_TexCoordinate;\nvarying vec2 v_TexCoordinate;  \nvoid main()                    \n{                              \n   int mvpMatrixIndex = int(a_MVPMatrixIndex); \n   v_TexCoordinate = a_TexCoordinate; \n   gl_Position = u_MVPMatrix[mvpMatrixIndex]   \n               * a_Position;   \n}                              \n";

    /* renamed from: c */
    private static final String f3920c = "uniform sampler2D u_Texture;       \nprecision mediump float;       \nuniform vec4 u_Color;          \nvarying vec2 v_TexCoordinate;  \nvoid main()                    \n{                              \n   gl_FragColor = texture2D(u_Texture, v_TexCoordinate).w * u_Color;\n}                             \n";

    /* renamed from: a */
    public void mo58978a() {
        super.mo58979a(f3919b, f3920c, f3918a);
    }
}
