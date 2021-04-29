package com.haohao.framwork.haoframwork.framwork;

import android.content.Context;
import androidx.appcompat.widget.AppCompatRadioButton;
import android.util.AttributeSet;

/**
 * @author hao
 * @date 2015-11-22
 * @package com.ft.database.base
 * @description RadioButton基类
 */
public class BaseRadioButton extends AppCompatRadioButton {
	public BaseRadioButton(Context context) {
		super(context);
		init();
	}

	public BaseRadioButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public BaseRadioButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {

	}

}
