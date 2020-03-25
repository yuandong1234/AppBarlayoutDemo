package com.yuong.demo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;

public class StatusBarUtil {

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    public static void setStatusBarColor(Activity activity, int colorId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //6.0以上版本
            // 设置状态栏底色颜色
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(colorId);
        }
    }

    /**
     * 获取ActionBar 高度
     *
     * @param context
     * @return
     */
    public static int getActionBarHeight(Context context) {
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            return TypedValue.complexToDimensionPixelSize(tv.data,
                    context.getResources().getDisplayMetrics());
        }
        return 0;
    }
}
