package com.haohao.framwork.haoframwork.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃  神兽保佑
 * 　　　　┃　　　┃  代码无bug
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 *
 * @author hao
 * @date 2018/11/09
 * @description toast工具类
 */
public class ToastUtil {

    public static void showToast(Context context, String msg) {
        SuperActivityToast.create(context, new Style(), Style.TYPE_STANDARD)
                //当上边Style为TYPE_BUTTON的时候设置button的文字
                //.setButtonText("UNDO")
                //.setButtonIconResource(R.mipmap.ic_launcher)
                //.setOnButtonClickListener("good_tag_name", null, onButtonClickListener)
                .setProgressBarColor(Color.WHITE)
                .setText(msg)
                .setTypefaceStyle(Typeface.NORMAL)
                .setDuration(Style.DURATION_MEDIUM)
                //弹窗的外形：FRAME_STANDARD为方框；FRAME_KITKAT为圆框；FRAME_LOLLIPOP为底部宽撑满屏的弹窗
                .setFrame(Style.FRAME_KITKAT)
                //弹窗颜色
                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_GREY))
                //如果有特殊位置，可设置
                //.setGravity(Gravity.END)
                //设置icon相对于文字的位置
                //.setIconResource(Style.ICONPOSITION_BOTTOM, R.mipmap.ic_launcher)
                //ANIMATIONS_FADE;ANIMATIONS_FLY;ANIMATIONS_POP;ANIMATIONS_SCALE
                .setAnimations(Style.ANIMATIONS_SCALE)
                .show();
    }

    /**
     * 可点击按钮的弹窗
     *
     * @param context
     * @param msg       弹窗文字
     * @param buttonMsg 点击按钮的文字
     */
    public static void showClickToast(Context context, String msg, String buttonMsg
            , SuperActivityToast.OnButtonClickListener onButtonClickListener) {
        SuperActivityToast.create(context, new Style(), Style.TYPE_BUTTON)
                //当上边Style为TYPE_BUTTON的时候设置button的文字
                .setButtonText(buttonMsg)
                //.setButtonIconResource(R.mipmap.ic_launcher)
                .setOnButtonClickListener("tag_name", null, onButtonClickListener)
                .setProgressBarColor(Color.WHITE)
                .setText(msg)
                .setTypefaceStyle(Typeface.NORMAL)
                .setDuration(Style.DURATION_MEDIUM)
                //弹窗的外形：FRAME_STANDARD为方框；FRAME_KITKAT为圆框；FRAME_LOLLIPOP为底部宽撑满屏的弹窗
                .setFrame(Style.FRAME_LOLLIPOP)
                //弹窗颜色
                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_GREY))
                //如果有特殊位置，可设置
                //.setGravity(Gravity.END)
                //设置icon相对于文字的位置
                //.setIconResource(Style.ICONPOSITION_BOTTOM, R.mipmap.ic_launcher)
                //ANIMATIONS_FADE;ANIMATIONS_FLY;ANIMATIONS_POP;ANIMATIONS_SCALE
                .setAnimations(Style.ANIMATIONS_POP)
                .show();
    }
}
