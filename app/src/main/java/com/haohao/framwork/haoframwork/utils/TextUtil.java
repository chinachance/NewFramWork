package com.haohao.framwork.haoframwork.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

/**
 * @author hao
 * @date 2016-11-8
 * @package com.fyxj.moviedom.util
 * @description text工具类
 */
public class TextUtil {
	/**
	 * TextView设置drawable
	 * 
	 * @param context
	 * @param tv
	 * @param topResoure
	 * @param downResoure
	 * @param leftResoure
	 * @param rightResoure
	 */
	public static void setTextCompoundDrawables(Context context, TextView tv, int leftResoure, int topResoure, int rightResoure, int downResoure) {
		Drawable drawLeft = null;
		Drawable drawTop = null;
		Drawable drawRight = null;
		Drawable drawDown = null;
		// 左
		if (leftResoure != 0 && leftResoure != -1) {
			drawLeft = context.getResources().getDrawable(leftResoure);
			drawLeft.setBounds(0, 0, drawLeft.getMinimumWidth(), drawLeft.getMinimumHeight());
		}
		// 上
		if (topResoure != 0 && topResoure != -1) {
			drawTop = context.getResources().getDrawable(topResoure);
			drawTop.setBounds(0, 0, drawTop.getMinimumWidth(), drawTop.getMinimumHeight());
		}
		// 右
		if (rightResoure != 0 && rightResoure != -1) {
			drawRight = context.getResources().getDrawable(rightResoure);
			drawRight.setBounds(0, 0, drawRight.getMinimumWidth(), drawRight.getMinimumHeight());
		}
		// 下
		if (downResoure != 0 && downResoure != -1) {
			drawDown = context.getResources().getDrawable(downResoure);
			drawDown.setBounds(0, 0, drawDown.getMinimumWidth(), drawDown.getMinimumHeight());
		}
		tv.setCompoundDrawables(drawLeft, drawTop, drawRight, drawDown);
	}
}
