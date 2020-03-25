package com.yuong.demo.utils;

import android.graphics.Color;

public class ColorUtil {
    /**
     * 修改颜色透明度
     *
     * @param color
     * @param fraction
     * @return
     */
    public static int changeAlpha(int color, float fraction) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = (int) (Color.alpha(color) * fraction);
        return Color.argb(alpha, red, green, blue);
    }
}
