package com.wowza.gocoder.sdk.api.android.graphics;

import com.wowza.gocoder.sdk.api.android.graphics.WOWZTextManager;
import com.wowza.gocoder.sdk.api.geometry.WOWZPoint;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.graphics.WOWZColor;
import java.util.UUID;

/* compiled from: GoCoderSDK */
public class WOWZText {
    public static final int BOTTOM = -5;
    public static final int CENTER = -1;
    public static final int LEFT = -2;
    public static final int RIGHT = -3;
    public static final int TOP = -4;
    protected int mAlignment;
    protected WOWZSize mBaseSize;
    protected WOWZColor mColor;
    protected UUID mFontId;
    protected WOWZSize mFrameSize;
    protected WOWZPoint mPosition;
    protected int mRotationAngle;
    protected float mScale;
    protected int mScaleBasis;
    protected float mSpacing;
    protected String mText;
    protected boolean mVisible;

    protected WOWZText(UUID uuid, String str, WOWZColor wOWZColor) {
        init(uuid, str);
        setColor(wOWZColor);
    }

    protected WOWZText(UUID uuid, String str, float f, float f2, float f3, float f4) {
        init(uuid, str);
        setColor(f, f2, f3, f4);
    }

    protected WOWZText(UUID uuid, String str, float f, float f2, float f3) {
        init(uuid, str);
        setColor(f, f2, f3);
    }

    protected WOWZText(UUID uuid, String str) {
        init(uuid, str);
    }

    protected WOWZText(UUID uuid) {
        init(uuid, (String) null);
    }

    public String getText() {
        return this.mText;
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        this.mText = str;
    }

    public UUID getFontId() {
        return this.mFontId;
    }

    public void setFontId(UUID uuid) {
        this.mFontId = uuid;
    }

    public WOWZTextManager.Font getFont() {
        return WOWZTextManager.getInstance().getFontById(this.mFontId);
    }

    public WOWZColor getColor() {
        return this.mColor;
    }

    public void setColor(WOWZColor wOWZColor) {
        this.mColor.set(wOWZColor);
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.mColor.set(f, f2, f3, f4);
    }

    public void setColor(float f, float f2, float f3) {
        this.mColor.set(f, f2, f3);
    }

    /* access modifiers changed from: protected */
    public void init(UUID uuid, String str) {
        setFontId(uuid);
        setText(str);
        this.mVisible = true;
        this.mColor = new WOWZColor();
        this.mScaleBasis = -8;
        this.mScale = 1.0f;
        this.mRotationAngle = 0;
        this.mPosition = new WOWZPoint(-1, -1);
        this.mSpacing = 0.0f;
        this.mAlignment = -2;
        this.mFrameSize = new WOWZSize(0, 0);
        this.mBaseSize = new WOWZSize(getWidth(), getHeight());
    }

    public synchronized WOWZSize getBaseSize() {
        return this.mBaseSize;
    }

    public synchronized WOWZSize getScaledSize() {
        return new WOWZSize(getWidth(), getHeight());
    }

    public int getWidth() {
        return Math.round(getFont().getLength(this.mText, getScale()));
    }

    public int getHeight() {
        return Math.round(getFont().getFontHeight() * getScale());
    }

    /* access modifiers changed from: protected */
    public void setFrameSize(WOWZSize wOWZSize) {
        this.mFrameSize.set(wOWZSize);
    }

    public synchronized int getScaleBasis() {
        return this.mScaleBasis;
    }

    public synchronized float getScale() {
        int i = this.mScaleBasis;
        if (i == -7) {
            return (((float) this.mFrameSize.height) * this.mScale) / ((float) this.mBaseSize.height);
        } else if (i != -6) {
            return this.mScale;
        } else {
            return (((float) this.mFrameSize.width) * this.mScale) / ((float) this.mBaseSize.width);
        }
    }

    public synchronized void setScale(float f) {
        setScale(f, -8);
    }

    public synchronized void setScale(float f, int i) {
        this.mScaleBasis = i;
        if (i != -9) {
            this.mScale = f;
        } else {
            this.mScale *= f;
            this.mScaleBasis = -8;
        }
    }

    public float getSpacing() {
        return this.mSpacing;
    }

    public void setSpacing(float f) {
        this.mSpacing = f;
    }

    public synchronized void setPosition(WOWZPoint wOWZPoint) {
        setPosition(wOWZPoint.f3734x, wOWZPoint.f3735y);
    }

    public synchronized void setPosition(int i, int i2) {
        this.mPosition.f3734x = i;
        this.mPosition.f3735y = i2;
    }

    public int getAlignment() {
        return this.mAlignment;
    }

    public void setAlignment(int i) {
        this.mAlignment = i;
    }

    public synchronized int getRotationAngle() {
        return this.mRotationAngle;
    }

    public synchronized void setRotationAngle(int i) {
        this.mRotationAngle = i;
    }

    public void setVisible(boolean z) {
        this.mVisible = z;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public float getCharWidth(char c) {
        return getFont().getCharWidth(c, getScale());
    }

    public float getCharWidthMax() {
        return getFont().getCharWidthMax(getScale());
    }

    public float getCharHeight() {
        return getFont().getCharHeight(getScale());
    }

    public float getAscent() {
        return getFont().getFontAscent(getScale());
    }

    public float getDescent() {
        return getFont().getFontDescent(getScale());
    }

    public WOWZPoint getPosition() {
        WOWZPoint wOWZPoint = new WOWZPoint(this.mPosition);
        WOWZTextManager.Font font = getFont();
        int i = this.mPosition.f3734x;
        if (i == -3) {
            wOWZPoint.f3734x = Math.round(((float) this.mFrameSize.width) - (((float) getWidth()) / 2.0f));
        } else if (i == -2) {
            wOWZPoint.f3734x = 0;
        } else if (i == -1) {
            wOWZPoint.f3734x = Math.round(((float) this.mFrameSize.width) / 2.0f);
        }
        int i2 = this.mPosition.f3735y;
        if (i2 == -5) {
            wOWZPoint.f3735y = 0;
        } else if (i2 == -4) {
            wOWZPoint.f3735y = Math.round(((float) this.mFrameSize.height) - ((float) getHeight()));
        } else if (i2 == -1) {
            wOWZPoint.f3735y = Math.round(((float) this.mFrameSize.height) / 2.0f);
        }
        float cellHeight = ((float) font.getCellHeight()) * getScale();
        wOWZPoint.f3734x = (int) (((float) wOWZPoint.f3734x) + (((((float) font.getCellWidth()) * getScale()) / 2.0f) - (((float) font.getFontPadX()) * getScale())));
        wOWZPoint.f3735y = (int) (((float) wOWZPoint.f3735y) + ((cellHeight / 2.0f) - (((float) font.getFontPadY()) * getScale())));
        return wOWZPoint;
    }
}
