package com.haohao.framwork.haoframwork.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.math.BigDecimal;

/**
 * @author hao
 * @date 2017/6/8
 * @package com.ftnew.database.util
 * @description 其他工具
 */
public class OtherUtil {

    /**
     * 隐藏虚拟按键，并且全屏
     */
    public static void hideBottomUIMenu(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    /**
     * 修改通知栏颜色
     * @param activity
     * @param colorResId
     */
    public static void setWindowStatusBarColor(Activity activity, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(activity.getResources().getColor(colorResId));
                //底部导航栏
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 数字转为中文单位
     *
     * @param number 10000
     * @return 1万
     */
    public static String getNumberToChineseUnit(float number) {
        if (number >= 100 && number < 1000) {
            return Math.round(number / 100) + "百";
        } else if (number >= 1000 && number < 10000) {
            return Math.round(number / 1000) + "千";
        } else if (number >= 10000) {
            return Math.round(number / 10000) + "万";
        }
        return "";
    }

    /**
     * 格式化数字四舍五入
     * @param number
     * @return
     */
    public static String getNumberToDecimalValues(float values, int number){
        BigDecimal decimal = new BigDecimal(values);
        float value = decimal.setScale(number, BigDecimal.ROUND_HALF_UP).floatValue();
        return value + "";
    }
}
